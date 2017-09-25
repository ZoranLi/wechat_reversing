package com.tencent.mm.plugin.webview.modelcache;

import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public final class p {
    public static boolean xt(String str) {
        return !bg.mA(str) && (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str));
    }

    public static String Jb(String str) {
        String str2;
        if (!xt(str)) {
            return null;
        }
        try {
            URI uri = new URI(str);
            String toLowerCase = bg.mz(uri.getScheme()).toLowerCase();
            String toLowerCase2 = bg.mz(uri.getHost()).toLowerCase();
            if (bg.mA(toLowerCase2)) {
                return null;
            }
            int port = uri.getPort() == -1 ? toLowerCase.equalsIgnoreCase("http") ? 80 : 443 : uri.getPort();
            str = toLowerCase + "://" + toLowerCase2 + ":" + port + "/" + bg.mz(uri.getPath()) + (bg.mA(uri.getQuery()) ? "" : "?" + uri.getQuery()) + (bg.mA(uri.getFragment()) ? "" : "#" + uri.getFragment());
            if (str.endsWith("/")) {
                str = str + "/";
            }
            return Jc(str);
        } catch (URISyntaxException e) {
            URISyntaxException uRISyntaxException = e;
            str2 = str;
            w.e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL URISyntaxException : %s", new Object[]{uRISyntaxException.getMessage()});
            return str2;
        } catch (Exception e2) {
            Exception exception = e2;
            str2 = str;
            w.e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL normal : %s", new Object[]{exception.getMessage()});
            return str2;
        }
    }

    private static String Jc(String str) {
        Uri parse = Uri.parse(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parse.getScheme()).append("://");
        stringBuilder.append(parse.getHost()).append(":").append(parse.getPort());
        if (bg.bV(parse.getPathSegments())) {
            stringBuilder.append("/");
        } else {
            for (String append : parse.getPathSegments()) {
                stringBuilder.append("/").append(append);
            }
        }
        if (!bg.mA(parse.getQuery())) {
            stringBuilder.append("?").append(parse.getQuery());
        }
        if (!bg.mA(parse.getFragment())) {
            stringBuilder.append("#").append(parse.getFragment());
        }
        if (str.endsWith("/")) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    public static String Jd(String str) {
        String Jb = Jb(str);
        if (bg.mA(Jb)) {
            return null;
        }
        return Uri.parse(Jb).getHost();
    }

    public static String Je(String str) {
        String Jf = Jf(str);
        return bg.mA(Jf) ? null : Jf.replaceAll("http://", "").replaceAll("https://", "");
    }

    public static String Jf(String str) {
        String Jb = Jb(str);
        if (bg.mA(Jb)) {
            w.e("MicroMsg.WebViewCacheUtils", "evaluateResURLWithScheme, original url is invalid = %s", new Object[]{str});
            return null;
        }
        Uri parse = Uri.parse(Jb);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parse.getScheme()).append("://").append(parse.getHost()).append(":").append(parse.getPort());
        if (!bg.bV(parse.getPathSegments())) {
            for (String Jb2 : parse.getPathSegments()) {
                stringBuilder.append("/").append(bg.mz(Jb2));
            }
        }
        if (str.endsWith("/")) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    public static byte[] Jg(String str) {
        Exception e;
        Throwable th;
        Closeable closeable = null;
        Closeable byteArrayOutputStream;
        Closeable inputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestMethod("GET");
                int responseCode = httpURLConnection.getResponseCode();
                int contentLength = httpURLConnection.getContentLength();
                w.d("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, statusCode = %d, contentLength = %d", new Object[]{str, Integer.valueOf(responseCode), Integer.valueOf(contentLength)});
                inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    try {
                        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        while (true) {
                            contentLength = inputStream.read(bArr);
                            if (contentLength != -1) {
                                byteArrayOutputStream.write(bArr, 0, contentLength);
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                                bg.g(inputStream);
                                bg.g(byteArrayOutputStream);
                                return bArr;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            w.e("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, e = %s", new Object[]{str, e});
                            bg.g(inputStream);
                            bg.g(byteArrayOutputStream);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = inputStream;
                            bg.g(closeable);
                            bg.g(byteArrayOutputStream);
                            throw th;
                        }
                    }
                }
                bg.g(inputStream);
                bg.g(byteArrayOutputStream);
                return null;
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
                w.e("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, e = %s", new Object[]{str, e});
                bg.g(inputStream);
                bg.g(byteArrayOutputStream);
                return null;
            } catch (Throwable th3) {
                th = th3;
                bg.g(closeable);
                bg.g(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
            inputStream = null;
            w.e("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, e = %s", new Object[]{str, e});
            bg.g(inputStream);
            bg.g(byteArrayOutputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            bg.g(closeable);
            bg.g(byteArrayOutputStream);
            throw th;
        }
    }

    public static String Jh(String str) {
        Closeable openRead;
        FileNotFoundException e;
        Throwable th;
        Exception e2;
        String str2 = null;
        if (FileOp.aO(str)) {
            try {
                int ki = (int) FileOp.ki(str);
                openRead = FileOp.openRead(str);
                try {
                    str2 = g.a(openRead, ki);
                    bg.g(openRead);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    try {
                        w.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", new Object[]{str, e});
                        bg.g(openRead);
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        bg.g(openRead);
                        throw th;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    w.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", new Object[]{str, e2});
                    bg.g(openRead);
                    return str2;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                openRead = str2;
                w.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", new Object[]{str, e});
                bg.g(openRead);
                return str2;
            } catch (Exception e6) {
                e2 = e6;
                openRead = str2;
                w.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", new Object[]{str, e2});
                bg.g(openRead);
                return str2;
            } catch (Throwable th3) {
                openRead = str2;
                th = th3;
                bg.g(openRead);
                throw th;
            }
        }
        return str2;
    }

    public static int a(i iVar) {
        if (!bg.mz(iVar.smN).equals("cache")) {
            return -1;
        }
        if (!Boolean.parseBoolean((String) iVar.ozE.get("async")) || bg.mA((String) iVar.ozE.get("src"))) {
            return !bg.mA((String) iVar.ozE.get("resourceList")) ? 1 : -1;
        } else {
            return 2;
        }
    }
}
