package com.tencent.qqmusic.mediaplayer.network;

import com.tencent.mm.plugin.appbrand.jsapi.l.b;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.Map;
import java.util.Map.Entry;

public class DefaultMediaHTTPConnection implements IMediaHTTPConnection {
    private static final int CONNECT_TIMEOUT_MS = 30000;
    private static final int HTTP_TEMP_REDIRECT = 307;
    private static final int MAX_REDIRECTS = 20;
    private static final String TAG = "MediaHTTPConnection";
    private static final boolean VERBOSE = false;
    private boolean mAllowCrossDomainRedirect = true;
    private boolean mAllowCrossProtocolRedirect = true;
    private HttpURLConnection mConnection = null;
    private long mCurrentOffset = -1;
    private Map<String, String> mHeaders = null;
    private InputStream mInputStream = null;
    private long mTotalSize = -1;
    private URL mURL = null;

    public boolean connect(URL url, Map<String, String> map) {
        disconnect();
        this.mAllowCrossDomainRedirect = true;
        this.mURL = url;
        this.mHeaders = map;
        return true;
    }

    private boolean parseBoolean(String str) {
        try {
            if (Long.parseLong(str) != 0) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            if ("true".equalsIgnoreCase(str) || "yes".equalsIgnoreCase(str)) {
                return true;
            }
            return false;
        }
    }

    private boolean filterOutInternalHeaders(String str, String str2) {
        if (!"android-allow-cross-domain-redirect".equalsIgnoreCase(str)) {
            return false;
        }
        this.mAllowCrossDomainRedirect = parseBoolean(str2);
        this.mAllowCrossProtocolRedirect = this.mAllowCrossDomainRedirect;
        return true;
    }

    public void disconnect() {
        teardownConnection();
        this.mHeaders = null;
        this.mURL = null;
    }

    private void teardownConnection() {
        if (this.mConnection != null) {
            this.mInputStream = null;
            this.mConnection.disconnect();
            this.mConnection = null;
            this.mCurrentOffset = -1;
        }
    }

    private static final boolean isLocalHost(URL url) {
        if (url == null) {
            return false;
        }
        String host = url.getHost();
        if (host == null) {
            return false;
        }
        try {
            if (host.equalsIgnoreCase("localhost")) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            Logger.e(TAG, "isLocalHost", e);
            return false;
        }
    }

    private void seekTo(long j) {
        teardownConnection();
        URL url = this.mURL;
        boolean isLocalHost = isLocalHost(url);
        int i = 0;
        while (true) {
            if (isLocalHost) {
                this.mConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
            } else {
                this.mConnection = (HttpURLConnection) url.openConnection();
            }
            Logger.i(TAG, "setConnectTimeout " + this.mURL);
            this.mConnection.setConnectTimeout(CONNECT_TIMEOUT_MS);
            this.mConnection.setInstanceFollowRedirects(this.mAllowCrossDomainRedirect);
            String str = "Accept-Encoding";
            Object obj = null;
            if (this.mHeaders != null) {
                for (Entry entry : this.mHeaders.entrySet()) {
                    Object obj2;
                    this.mConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    if (obj == null && str.equals(entry.getKey())) {
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    obj = obj2;
                }
            }
            if (j > 0) {
                try {
                    this.mConnection.setRequestProperty("Range", "bytes=" + j + "-");
                } catch (Exception e) {
                    throw new IOException("An suspicious exception occurred: " + e.getMessage());
                } catch (Throwable e2) {
                    this.mTotalSize = -1;
                    this.mInputStream = null;
                    this.mConnection = null;
                    this.mCurrentOffset = -1;
                    Logger.e(TAG, "seekTo", e2);
                    throw e2;
                }
            }
            if (obj == null) {
                this.mConnection.setRequestProperty(str, "");
            }
            int responseCode = this.mConnection.getResponseCode();
            if (responseCode != e.CTRL_INDEX && responseCode != b.CTRL_INDEX && responseCode != 302 && responseCode != 303 && responseCode != HTTP_TEMP_REDIRECT) {
                break;
            }
            int i2 = i + 1;
            if (i2 > 20) {
                throw new NoRouteToHostException("Too many redirects: " + i2);
            }
            String requestMethod = this.mConnection.getRequestMethod();
            if (responseCode != HTTP_TEMP_REDIRECT || requestMethod.equals("GET") || requestMethod.equals("HEAD")) {
                String headerField = this.mConnection.getHeaderField("Location");
                if (headerField == null) {
                    throw new NoRouteToHostException("Invalid redirect");
                }
                url = new URL(this.mURL, headerField);
                if (url.getProtocol().equals("https") || url.getProtocol().equals("http")) {
                    boolean equals = this.mURL.getProtocol().equals(url.getProtocol());
                    if (this.mAllowCrossProtocolRedirect || equals) {
                        equals = this.mURL.getHost().equals(url.getHost());
                        if (this.mAllowCrossDomainRedirect || equals) {
                            if (responseCode != HTTP_TEMP_REDIRECT) {
                                this.mURL = url;
                            }
                            i = i2;
                        } else {
                            throw new NoRouteToHostException("Cross-domain redirects are disallowed");
                        }
                    }
                    throw new NoRouteToHostException("Cross-protocol redirects are disallowed");
                }
                throw new NoRouteToHostException("Unsupported protocol redirect");
            }
            throw new NoRouteToHostException("Invalid redirect");
        }
        if (this.mAllowCrossDomainRedirect) {
            this.mURL = this.mConnection.getURL();
        }
        if (responseCode == v.CTRL_INDEX) {
            requestMethod = this.mConnection.getHeaderField("Content-Range");
            this.mTotalSize = -1;
            if (requestMethod != null) {
                i2 = requestMethod.lastIndexOf(47);
                if (i2 >= 0) {
                    try {
                        this.mTotalSize = Long.parseLong(requestMethod.substring(i2 + 1));
                    } catch (NumberFormatException e3) {
                    }
                }
            }
        } else if (responseCode != m.CTRL_INDEX) {
            throw new IOException();
        } else {
            this.mTotalSize = (long) this.mConnection.getContentLength();
        }
        if (j <= 0 || responseCode == v.CTRL_INDEX) {
            this.mInputStream = new BufferedInputStream(this.mConnection.getInputStream());
            this.mCurrentOffset = j;
            return;
        }
        throw new ProtocolException();
    }

    public int readAt(byte[] bArr, int i, int i2) {
        int i3 = 0;
        try {
            if (((long) i) != this.mCurrentOffset) {
                seekTo((long) i);
            }
            int read = this.mInputStream.read(bArr, 0, i2);
            if (read != -1) {
                i3 = read;
            }
            this.mCurrentOffset += (long) i3;
            return i3;
        } catch (ProtocolException e) {
            Logger.w(TAG, "readAt " + i + " / " + i2 + " => " + e);
            return -1010;
        } catch (NoRouteToHostException e2) {
            Logger.w(TAG, "readAt " + i + " / " + i2 + " => " + e2);
            return -1010;
        } catch (UnknownServiceException e3) {
            Logger.w(TAG, "readAt " + i + " / " + i2 + " => " + e3);
            return -1010;
        } catch (IOException e4) {
            return -1;
        } catch (Exception e5) {
            return -1;
        }
    }

    public long getSize() {
        if (this.mConnection == null) {
            try {
                seekTo(0);
            } catch (Throwable e) {
                Logger.e(TAG, "getSize", e);
                return -1;
            }
        }
        return this.mTotalSize;
    }

    public String getMIMEType() {
        if (this.mConnection == null) {
            try {
                seekTo(0);
            } catch (Throwable e) {
                Logger.e(TAG, "getMIMEType", e);
                return "application/octet-stream";
            }
        }
        return this.mConnection.getContentType();
    }

    public String getUri() {
        return this.mURL.toString();
    }
}
