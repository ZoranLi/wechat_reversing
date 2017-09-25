package com.tencent.mm.plugin.music.a.d;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.music.a.a.b;
import com.tencent.mm.plugin.music.a.a.c;
import com.tencent.mm.plugin.music.a.a.d;
import com.tencent.mm.plugin.music.a.a.e;
import com.tencent.mm.plugin.music.a.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.BitSet;
import java.util.Map;
import java.util.Map.Entry;

public final class a implements IMediaHTTPConnection {
    private boolean mAllowCrossDomainRedirect = true;
    private boolean mAllowCrossProtocolRedirect = true;
    private HttpURLConnection mConnection = null;
    private long mCurrentOffset = -1;
    private Map<String, String> mHeaders = null;
    private InputStream mInputStream = null;
    private long mTotalSize = -1;
    private URL mURL = null;
    private b nTO;
    public URL nTP = null;

    public final boolean connect(URL url, Map<String, String> map) {
        Logger.i("MicroMsg.MMMediaHTTPConnection", "connect");
        Logger.i("MicroMsg.MMMediaHTTPConnection", "connect: uri=" + url + ", headers=" + map);
        disconnect();
        this.mAllowCrossDomainRedirect = true;
        this.mURL = url;
        this.nTP = url;
        this.mHeaders = map;
        if (this.mURL != null) {
            d.g(this.mURL.toString(), map);
            Logger.i("MicroMsg.MMMediaHTTPConnection", "headers=" + map);
        }
        this.nTO = new b(this);
        b bVar = this.nTO;
        bVar.nTB = new c(bVar.nTA.nTP.toString());
        bVar.nTB.ilG = bVar.nTA.getSize();
        c cVar = bVar.nTB;
        w.i("MicroMsg.IndexBitMgr", "initData");
        if (cVar.ilG <= 0) {
            w.e("MicroMsg.IndexBitMgr", "fileLength is invalid!");
        } else {
            if (cVar.ilG % 8192 == 0 || cVar.ilG < 8192) {
                cVar.count = (int) (cVar.ilG / 8192);
            } else {
                cVar.count = ((int) (cVar.ilG / 8192)) + 1;
            }
            w.i("MicroMsg.IndexBitMgr", "fileLength:%d, count:%d", new Object[]{Long.valueOf(cVar.ilG), Integer.valueOf(cVar.count)});
            cVar.nTD = new BitSet(cVar.count);
            cVar.nTE = d.By(cVar.mUrl);
            if (TextUtils.isEmpty(cVar.nTE)) {
                w.e("MicroMsg.IndexBitMgr", "initData musicId is null!'");
            } else {
                w.i("MicroMsg.IndexBitMgr", "musicId:%s", new Object[]{cVar.nTE});
                com.tencent.mm.plugin.music.a.f.b BF = i.aNW().BF(cVar.nTE);
                if (BF == null) {
                    w.e("MicroMsg.IndexBitMgr", "initData pMusic is null!'");
                } else {
                    w.i("MicroMsg.IndexBitMgr", "initData music field_fileCacheComplete:%d", new Object[]{Integer.valueOf(BF.field_fileCacheComplete)});
                    if (BF.field_indexBitData == null) {
                        w.e("MicroMsg.IndexBitMgr", "initData field_indexBitData is null!'");
                    } else {
                        cVar.nTD = com.tencent.mm.plugin.music.a.a.c.a.az(BF.field_indexBitData);
                        if (cVar.nTD == null) {
                            w.e("MicroMsg.IndexBitMgr", "initData bitSet is null");
                            cVar.nTD = new BitSet(cVar.count);
                        } else if (cVar.count < cVar.nTD.cardinality()) {
                            w.e("MicroMsg.IndexBitMgr", "initData cont < bitSet.cardinality(), count:%d, cardinality:%d", new Object[]{Integer.valueOf(cVar.count), Integer.valueOf(cVar.nTD.cardinality())});
                            cVar.clearCache();
                        }
                        w.i("MicroMsg.IndexBitMgr", "initData bitSet:" + cVar.nTD.toString());
                        w.i("MicroMsg.IndexBitMgr", "initData bitSet count %d, cardinality:" + cVar.count + "," + cVar.nTD.cardinality());
                    }
                }
            }
        }
        bVar.nTC = new e(bVar.nTA.nTP.toString());
        if (!new File(bVar.nTC.fyF).exists()) {
            w.i("MicroMsg.FileBytesCacheMgr", "piece file not exist, clear cache!");
            bVar.nTB.clearCache();
        } else if (bVar.nTC.aOa() != bVar.nTA.getSize() && bVar.nTA.getSize() != -1) {
            w.i("MicroMsg.FileBytesCacheMgr", "piece file length is not equals to real file length exist, clear cache!");
            bVar.nTB.clearCache();
            e eVar = bVar.nTC;
            Logger.i("MicroMsg.PieceFileCache", "deleteFile");
            e.tv(eVar.fyF);
        } else if (bVar.nTA.getSize() == -1) {
            w.i("MicroMsg.FileBytesCacheMgr", "getFileLength is -1, network is disconnect!");
        } else {
            w.i("MicroMsg.FileBytesCacheMgr", "piece file exist!");
        }
        e eVar2 = bVar.nTC;
        Logger.i("MicroMsg.PieceFileCache", "open");
        try {
            File file = new File(eVar2.fyF);
            if (!file.exists()) {
                w.i("MicroMsg.PieceFileCache", "create file:%b", new Object[]{Boolean.valueOf(file.createNewFile())});
            }
            eVar2.randomAccessFile = new RandomAccessFile(file, "rws");
            Logger.e("MicroMsg.PieceFileCache", "create RandomAccessFile file  %s  success", eVar2.fyF);
        } catch (Throwable e) {
            Logger.e("MicroMsg.PieceFileCache", "file not found", e);
            Logger.e("MicroMsg.PieceFileCache", "create RandomAccessFile file  %s  success", eVar2.fyF);
        } catch (Throwable e2) {
            Logger.e("MicroMsg.PieceFileCache", "io ", e2);
            Logger.e("MicroMsg.PieceFileCache", "create RandomAccessFile file  %s  success", eVar2.fyF);
        } catch (Throwable th) {
            Logger.e("MicroMsg.PieceFileCache", "create RandomAccessFile file  %s  success", eVar2.fyF);
        }
        bVar.nTC.setLength((int) bVar.nTA.getSize());
        w.i("MicroMsg.FileBytesCacheMgr", "attach() fileLength is " + bVar.nTA.getSize() + ",pieceFileCache length is " + bVar.nTC.getLength());
        if (!(TextUtils.isEmpty(bVar.nTA.getMIMEType()) || "application/octet-stream".equalsIgnoreCase(bVar.nTA.getMIMEType()))) {
            d.cX(bVar.nTA.nTP.toString(), bVar.nTA.getMIMEType());
        }
        bVar.wa = -1;
        bVar.hP = 0;
        return true;
    }

    public final void disconnect() {
        Logger.i("MicroMsg.MMMediaHTTPConnection", "disconnect");
        teardownConnection();
        this.mHeaders = null;
        this.mURL = null;
        if (this.nTO != null) {
            b bVar = this.nTO;
            bVar.aNY();
            bVar.nTB.aNZ();
            e eVar = bVar.nTC;
            Logger.i("MicroMsg.PieceFileCache", "close");
            if (eVar.randomAccessFile != null) {
                try {
                    eVar.randomAccessFile.close();
                } catch (IOException e) {
                    Logger.e("MicroMsg.PieceFileCache", "close RandomAccessFile error ", e.getMessage());
                }
            }
            bVar.nTA = null;
            w.i("MicroMsg.FileBytesCacheMgr", "detach()");
            this.nTO = null;
        }
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
        } catch (IllegalArgumentException e) {
            Logger.e("MicroMsg.MMMediaHTTPConnection", "isLocalHost IllegalArgumentException:%s", String.valueOf(e));
            return false;
        }
    }

    private void seekTo(long j) {
        teardownConnection();
        int i = 0;
        Object obj;
        try {
            int i2;
            String requestMethod;
            URL url = this.mURL;
            boolean isLocalHost = isLocalHost(url);
            int i3 = 0;
            int i4 = i;
            while (true) {
                if (isLocalHost) {
                    this.mConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
                } else {
                    this.mConnection = (HttpURLConnection) url.openConnection();
                }
                this.mConnection.setConnectTimeout(30000);
                this.mConnection.setInstanceFollowRedirects(this.mAllowCrossDomainRedirect);
                String str = "Accept-Encoding";
                Object obj2 = null;
                if (this.mHeaders != null) {
                    for (Entry entry : this.mHeaders.entrySet()) {
                        this.mConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        if (obj2 == null && str.equals(entry.getKey())) {
                            obj = 1;
                        } else {
                            obj = obj2;
                        }
                        obj2 = obj;
                    }
                }
                if (j > 0) {
                    try {
                        this.mConnection.setRequestProperty("Range", "bytes=" + j + "-");
                    } catch (IOException e) {
                        obj = e;
                        i = i4;
                    }
                }
                if (obj2 == null) {
                    this.mConnection.setRequestProperty(str, "");
                }
                i = this.mConnection.getResponseCode();
                if (i != com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX && i != com.tencent.mm.plugin.appbrand.jsapi.l.b.CTRL_INDEX && i != 302 && i != 303 && i != 307) {
                    break;
                }
                i2 = i3 + 1;
                if (i2 > 20) {
                    throw new NoRouteToHostException("Too many redirects: " + i2);
                }
                requestMethod = this.mConnection.getRequestMethod();
                if (i != 307 || requestMethod.equals("GET") || requestMethod.equals("HEAD")) {
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
                                if (i != 307) {
                                    this.mURL = url;
                                }
                                i3 = i2;
                                i4 = i;
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
            if (i == v.CTRL_INDEX) {
                requestMethod = this.mConnection.getHeaderField("Content-Range");
                this.mTotalSize = -1;
                if (requestMethod != null) {
                    i2 = requestMethod.lastIndexOf(47);
                    if (i2 >= 0) {
                        try {
                            this.mTotalSize = bg.getLong(requestMethod.substring(i2 + 1), 0);
                        } catch (NumberFormatException e2) {
                        }
                    }
                }
            } else if (i != m.CTRL_INDEX) {
                throw new IOException();
            } else {
                this.mTotalSize = (long) this.mConnection.getContentLength();
            }
            if (j <= 0 || i == v.CTRL_INDEX) {
                this.mInputStream = new BufferedInputStream(this.mConnection.getInputStream());
                this.mCurrentOffset = j;
                return;
            }
            throw new ProtocolException();
        } catch (IOException e3) {
            obj = e3;
            this.mTotalSize = -1;
            this.mInputStream = null;
            this.mConnection = null;
            this.mCurrentOffset = -1;
            Logger.e("MicroMsg.MMMediaHTTPConnection", "seekTo exception:%s", obj + ", response:" + i);
            throw obj;
        }
    }

    public final int readAt(byte[] bArr, int i, int i2) {
        try {
            int size;
            if (this.nTO != null) {
                b bVar = this.nTO;
                if (bArr == null || i < 0 || i2 < 0) {
                    w.e("MicroMsg.FileBytesCacheMgr", "read() params is invalid, offset:%d, size:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                } else if (bVar.nTA.getSize() <= 0) {
                    w.e("MicroMsg.FileBytesCacheMgr", "read()，fileLength is error, file length is " + bVar.nTA.getSize());
                } else {
                    if (((long) (i + i2)) > bVar.nTA.getSize()) {
                        w.e("MicroMsg.FileBytesCacheMgr", "read() endOffset is error,  startOffset %d, endOffset:%d, file length:%d ", new Object[]{Integer.valueOf(i), Integer.valueOf(i + i2), Long.valueOf(bVar.nTA.getSize())});
                        size = ((int) bVar.nTA.getSize()) - i;
                    } else {
                        size = i2;
                    }
                    if (bVar.nTB.cw(i, size)) {
                        size = bVar.nTC.a(bArr, (long) i, size);
                        if (size > 0) {
                            if (size != i2) {
                                return size;
                            }
                            Logger.i("MicroMsg.MMMediaHTTPConnection", "read from cache, n%d, size %d " + size + "," + i2);
                            return size;
                        }
                    }
                }
                size = -1;
                if (size > 0) {
                    if (size != i2) {
                        return size;
                    }
                    Logger.i("MicroMsg.MMMediaHTTPConnection", "read from cache, n%d, size %d " + size + "," + i2);
                    return size;
                }
            }
            Logger.d("MicroMsg.MMMediaHTTPConnection", "read from network");
            if (((long) i) != this.mCurrentOffset) {
                seekTo((long) i);
            }
            size = this.mInputStream.read(bArr, 0, i2);
            if (size == -1) {
                size = 0;
            }
            this.mCurrentOffset += (long) size;
            if (this.nTO == null) {
                return size;
            }
            b bVar2 = this.nTO;
            if (bArr == null || i < 0 || size < 0) {
                w.e("MicroMsg.FileBytesCacheMgr", "write() params is invalid, offset:%d, size:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(size)});
                return size;
            } else if (bVar2.nTA.getSize() <= 0) {
                w.e("MicroMsg.FileBytesCacheMgr", "write() fileLength is error, file length is " + bVar2.nTA.getSize());
                return size;
            } else {
                int i3 = i + size;
                if (((long) i3) > bVar2.nTA.getSize()) {
                    w.e("MicroMsg.FileBytesCacheMgr", "write() endOffset is error, endOffset:%d, file length:%d", new Object[]{Integer.valueOf(i3), Long.valueOf(bVar2.nTA.getSize())});
                    return size;
                }
                if (((long) i3) == bVar2.nTA.getSize()) {
                    bVar2.aNY();
                    bVar2.qg(i);
                    bVar2.e(bArr, i, size);
                    bVar2.aNY();
                    bVar2.qg(i);
                    return size;
                } else if (!bVar2.qe(i) || !bVar2.qe(i3)) {
                    bVar2.aNY();
                    bVar2.qg(i);
                    bVar2.e(bArr, i, size);
                    return size;
                } else if (bVar2.qf(i) && bVar2.qf(i3)) {
                    return size;
                } else {
                    if (bVar2.qf(i)) {
                        bVar2.e(bArr, i, size);
                        return size;
                    }
                    bVar2.aNY();
                    bVar2.qg(i);
                    bVar2.e(bArr, i, size);
                    return size;
                }
            }
        } catch (ProtocolException e) {
            Logger.w("MicroMsg.MMMediaHTTPConnection", "readAt " + i + " / " + i2 + " => " + e);
            return -1010;
        } catch (NoRouteToHostException e2) {
            Logger.w("MicroMsg.MMMediaHTTPConnection", "readAt " + i + " / " + i2 + " => " + e2);
            return -1010;
        } catch (UnknownServiceException e3) {
            Logger.w("MicroMsg.MMMediaHTTPConnection", "readAt " + i + " / " + i2 + " => " + e3);
            return -1010;
        } catch (IOException e4) {
            Logger.e("MicroMsg.MMMediaHTTPConnection", "readAt " + i + " / " + i2 + " => -1 " + e4);
            return -1;
        } catch (Exception e5) {
            Logger.e("MicroMsg.MMMediaHTTPConnection", "unknown exception " + e5);
            Logger.e("MicroMsg.MMMediaHTTPConnection", "readAt " + i + " / " + i2 + " => -1");
            return -1;
        }
    }

    public final long getSize() {
        if (this.mConnection == null) {
            try {
                seekTo(0);
            } catch (IOException e) {
                Logger.e("MicroMsg.MMMediaHTTPConnection", "getSize exception:%s", String.valueOf(e));
                this.mTotalSize = -1;
            }
        }
        if (this.mTotalSize > 0) {
            return this.mTotalSize;
        }
        if (d.BA(this.nTP.toString()) > 0) {
            return d.BA(this.nTP.toString());
        }
        return -1;
    }

    public final String getMIMEType() {
        Object contentType;
        if (this.mConnection == null) {
            try {
                seekTo(0);
                contentType = this.mConnection.getContentType();
            } catch (IOException e) {
                Logger.e("MicroMsg.MMMediaHTTPConnection", "getMIMEType exception:%s", String.valueOf(e));
                contentType = "";
            }
        } else {
            contentType = this.mConnection.getContentType();
            Logger.i("MicroMsg.MMMediaHTTPConnection", "getMIMEType mimeType:" + contentType);
        }
        if (!TextUtils.isEmpty(contentType)) {
            return contentType;
        }
        String Bz = d.Bz(this.nTP.toString());
        return TextUtils.isEmpty(Bz) ? "application/octet-stream" : Bz;
    }

    public final String getUri() {
        return this.mURL.toString();
    }
}
