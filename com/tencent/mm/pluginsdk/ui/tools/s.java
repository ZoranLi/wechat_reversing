package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Base64;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.ac;
import com.tencent.smtt.sdk.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import junit.framework.Assert;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class s {
    private static ar ihO = null;
    private static final Pattern sXL = Pattern.compile("data:(image|img)/\\S+;base64,\\S+");
    private static final Map<String, String> sXM;
    private static final Map<String, String> sXN;

    public static final class a {
        private static final Pattern sXR = Pattern.compile("([a-zA-Z*-.0-9]+/[a-zA-Z*-.0-9]+)");
        public final String charset;
        public final String mimeType;

        private a(String str, String str2) {
            this.mimeType = str;
            this.charset = str2;
        }

        public final String toString() {
            return "ContentType{mimeType='" + this.mimeType + '\'' + ", charset='" + this.charset + '\'' + '}';
        }

        public static a Nz(String str) {
            String str2 = null;
            if (bg.mA(str)) {
                return null;
            }
            Matcher matcher = sXR.matcher(str);
            if (!matcher.find()) {
                return null;
            }
            String group = matcher.group(0);
            if (str.contains("charset=")) {
                str2 = str.substring(str.indexOf("charset=") + 8).trim();
            }
            if (bg.mA(str2)) {
                str2 = "UTF-8";
            }
            return new a(group, str2);
        }
    }

    public interface b {
        void pG(String str);
    }

    private static class c implements com.tencent.mm.sdk.platformtools.ar.a {
        private static Pattern sXS = Pattern.compile("image/[A-Za-z0-9]+");
        private static Pattern sXT = Pattern.compile("filename=[A-Za-z0-9@.]+.[A-Za-z0-9]+");
        private Context context;
        private String hPd;
        private String imagePath;
        private int opType;
        private String sXU;
        private String sXV;
        private boolean sXW;
        private b sXX;

        public c(Context context, String str, String str2, boolean z) {
            this(context, str, str2, z, 0, null);
        }

        public c(Context context, String str, String str2, boolean z, int i, b bVar) {
            this.context = context;
            this.hPd = str;
            this.sXV = str2;
            this.sXW = z;
            this.opType = i;
            this.sXX = bVar;
        }

        public final boolean Bo() {
            if (1 == this.opType) {
                this.sXX.pG(this.imagePath);
            } else if (bg.mA(this.sXU)) {
                Toast.makeText(this.context, this.context.getString(R.l.fnO), 1).show();
            } else {
                Toast.makeText(this.context, this.sXU, 1).show();
            }
            return true;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void bGN() {
            /*
            r8 = this;
            r2 = 0;
            r0 = new java.net.URL;	 Catch:{ Exception -> 0x0082, all -> 0x009b }
            r1 = r8.hPd;	 Catch:{ Exception -> 0x0082, all -> 0x009b }
            r0.<init>(r1);	 Catch:{ Exception -> 0x0082, all -> 0x009b }
            r0 = r0.openConnection();	 Catch:{ Exception -> 0x0082, all -> 0x009b }
            r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0082, all -> 0x009b }
            r1 = "GET";
            r0.setRequestMethod(r1);	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            r1 = "Cookie";
            r3 = r8.sXV;	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            r0.setRequestProperty(r1, r3);	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            r1 = 1;
            r0.setAllowUserInteraction(r1);	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            r1 = r0.getResponseCode();	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r1 == r3) goto L_0x006c;
        L_0x0028:
            r3 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
            if (r1 == r3) goto L_0x0030;
        L_0x002c:
            r3 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
            if (r1 != r3) goto L_0x005e;
        L_0x0030:
            r1 = "Location";
            r1 = r0.getHeaderField(r1);	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            if (r1 != 0) goto L_0x0040;
        L_0x0039:
            r1 = "location";
            r1 = r0.getHeaderField(r1);	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
        L_0x0040:
            r3 = "MicroMsg.WebViewUtil";
            r4 = "redirect url = %s";
            r5 = 1;
            r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            r6 = 0;
            r5[r6] = r1;	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            r3 = com.tencent.mm.sdk.platformtools.bg.mA(r1);	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            if (r3 != 0) goto L_0x005e;
        L_0x0055:
            r8.hPd = r1;	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            r8.bGN();	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            a(r0, r2);
        L_0x005d:
            return;
        L_0x005e:
            r1 = r8.context;	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            r3 = com.tencent.mm.R.l.fnO;	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            r1 = r1.getString(r3);	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            r8.sXU = r1;	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            a(r0, r2);
            goto L_0x005d;
        L_0x006c:
            r1 = r0.getContentType();	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            r2 = r0.getInputStream();	 Catch:{ Exception -> 0x00ab, all -> 0x00a1 }
            r3 = "Content-Disposition";
            r3 = r0.getHeaderField(r3);	 Catch:{ Exception -> 0x00b1, all -> 0x00a1 }
            r8.a(r1, r3, r2);	 Catch:{ Exception -> 0x00b1, all -> 0x00a1 }
            a(r0, r2);
            goto L_0x005d;
        L_0x0082:
            r0 = move-exception;
            r1 = r2;
        L_0x0084:
            r3 = "MicroMsg.WebViewUtil";
            r4 = "init http url connection failed : %s";
            r5 = 1;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00a6 }
            r6 = 0;
            r0 = r0.getMessage();	 Catch:{ all -> 0x00a6 }
            r5[r6] = r0;	 Catch:{ all -> 0x00a6 }
            com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ all -> 0x00a6 }
            a(r2, r1);
            goto L_0x005d;
        L_0x009b:
            r0 = move-exception;
            r1 = r2;
        L_0x009d:
            a(r1, r2);
            throw r0;
        L_0x00a1:
            r1 = move-exception;
            r7 = r1;
            r1 = r0;
            r0 = r7;
            goto L_0x009d;
        L_0x00a6:
            r0 = move-exception;
            r7 = r1;
            r1 = r2;
            r2 = r7;
            goto L_0x009d;
        L_0x00ab:
            r1 = move-exception;
            r7 = r1;
            r1 = r2;
            r2 = r0;
            r0 = r7;
            goto L_0x0084;
        L_0x00b1:
            r1 = move-exception;
            r7 = r1;
            r1 = r2;
            r2 = r0;
            r0 = r7;
            goto L_0x0084;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.tools.s.c.bGN():void");
        }

        private static void a(HttpURLConnection httpURLConnection, InputStream inputStream) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.WebViewUtil", e, "", new Object[0]);
                }
            }
        }

        private void a(String str, String str2, InputStream inputStream) {
            Matcher matcher;
            w.i("MicroMsg.WebViewUtil", "contentType = %s, dispositionType = %s", str, str2);
            String str3 = null;
            if (!bg.mA(str)) {
                matcher = sXS.matcher(str);
                if (matcher.find()) {
                    str3 = matcher.group().substring(matcher.group().lastIndexOf(47) + 1);
                }
            }
            if (bg.mA(str3) && !bg.mA(str2)) {
                matcher = sXT.matcher(str2);
                if (matcher.find()) {
                    str3 = matcher.group().substring(matcher.group().lastIndexOf(46) + 1);
                }
            }
            if (bg.mA(str3)) {
                q qVar = new q(this.hPd);
                int lastIndexOf = qVar.aGN.lastIndexOf(46);
                if (lastIndexOf == -1) {
                    str3 = "jpg";
                } else {
                    str3 = qVar.aGN.substring(lastIndexOf + 1);
                }
            }
            this.imagePath = k.mr(str3);
            FileOutputStream fileOutputStream = new FileOutputStream(this.imagePath);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (Exception e) {
                        w.e("MicroMsg.WebViewUtil", "close os failed : %s", e.getMessage());
                    }
                }
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            if (this.opType == 0) {
                this.sXU = this.context.getString(R.l.eaX, new Object[]{k.Nk()});
                k.b(this.imagePath, this.context);
            }
        }

        public final boolean Bn() {
            Exception e;
            FileOutputStream fileOutputStream;
            Throwable th;
            HttpURLConnection httpURLConnection;
            InputStream inputStream = null;
            if (!this.sXW) {
                this.sXU = this.context.getString(R.l.fnP);
                return true;
            } else if (bg.mA(this.hPd)) {
                return false;
            } else {
                boolean isDataUrl;
                String str = this.hPd;
                ac cfb = ac.cfb();
                if (cfb == null || !cfb.cfc()) {
                    isDataUrl = URLUtil.isDataUrl(str);
                } else {
                    Object invokeStaticMethod = cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new Class[]{String.class}, str);
                    isDataUrl = invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
                }
                if (isDataUrl) {
                    this.imagePath = k.mr("jpg");
                    try {
                        int indexOf = this.hPd.indexOf("base64");
                        if (indexOf > 0) {
                            this.hPd = this.hPd.substring(indexOf + 7);
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(this.imagePath);
                        try {
                            byte[] decode = Base64.decode(this.hPd, 0);
                            if (decode != null) {
                                fileOutputStream2.write(decode);
                            }
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            this.sXU = this.context.getString(R.l.eaX, new Object[]{k.Nk()});
                            k.b(this.imagePath, this.context);
                            try {
                                fileOutputStream2.close();
                            } catch (Exception e2) {
                                w.e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", e2.getMessage());
                            }
                        } catch (Exception e3) {
                            e2 = e3;
                            fileOutputStream = fileOutputStream2;
                            try {
                                w.e("MicroMsg.WebViewUtil", "decode base64 pic failed : %s", e2.getMessage());
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e22) {
                                        w.e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", e22.getMessage());
                                    }
                                }
                                return true;
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e4) {
                                        w.e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", e4.getMessage());
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        e22 = e5;
                        w.e("MicroMsg.WebViewUtil", "decode base64 pic failed : %s", e22.getMessage());
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return true;
                    }
                } else if (x.isHttpsUrl(this.hPd)) {
                    try {
                        HttpURLConnection httpURLConnection2 = (HttpsURLConnection) new URL(this.hPd).openConnection();
                        try {
                            httpURLConnection2.setRequestMethod("GET");
                            httpURLConnection2.setRequestProperty("Cookie", this.sXV);
                            httpURLConnection2.setAllowUserInteraction(true);
                            int responseCode = httpURLConnection2.getResponseCode();
                            String headerField;
                            if (responseCode != m.CTRL_INDEX) {
                                if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.l.b.CTRL_INDEX || responseCode == 302) {
                                    headerField = httpURLConnection2.getHeaderField("Location");
                                    if (headerField == null) {
                                        headerField = httpURLConnection2.getHeaderField("location");
                                    }
                                    w.i("MicroMsg.WebViewUtil", "redirect url = %s", headerField);
                                    if (!bg.mA(headerField)) {
                                        this.hPd = headerField;
                                        bGN();
                                        a(httpURLConnection2, null);
                                    }
                                }
                                this.sXU = this.context.getString(R.l.fnO);
                                a(httpURLConnection2, null);
                            } else {
                                headerField = httpURLConnection2.getContentType();
                                inputStream = httpURLConnection2.getInputStream();
                                a(headerField, httpURLConnection2.getHeaderField("Content-Disposition"), inputStream);
                                a(httpURLConnection2, inputStream);
                            }
                        } catch (Exception e6) {
                            Exception exception = e6;
                            httpURLConnection = httpURLConnection2;
                            e22 = exception;
                            try {
                                w.e("MicroMsg.WebViewUtil", "download https resource failed : %s", e22.getMessage());
                                a(httpURLConnection, inputStream);
                                return true;
                            } catch (Throwable th4) {
                                th = th4;
                                a(httpURLConnection, inputStream);
                                throw th;
                            }
                        } catch (Throwable th5) {
                            httpURLConnection = httpURLConnection2;
                            th = th5;
                            a(httpURLConnection, inputStream);
                            throw th;
                        }
                    } catch (Exception e7) {
                        e22 = e7;
                        httpURLConnection = null;
                        w.e("MicroMsg.WebViewUtil", "download https resource failed : %s", e22.getMessage());
                        a(httpURLConnection, inputStream);
                        return true;
                    } catch (Throwable th6) {
                        th = th6;
                        httpURLConnection = null;
                        a(httpURLConnection, inputStream);
                        throw th;
                    }
                } else {
                    bGN();
                }
                return true;
            }
        }
    }

    public static String aZ(Context context, String str) {
        String str2;
        Assert.assertTrue("MicroMsg.WebViewUtil, appendUserAgent fail, context is null, stack = " + bg.bJZ(), context != null);
        if (str == null) {
            str2 = " MicroMessenger/";
        } else {
            str2 = str + " MicroMessenger/";
        }
        PackageInfo az = az(context, ab.getPackageName());
        if (az != null) {
            str2 = (str2 + f.Z(null, d.sYN)) + "." + az.versionCode;
        }
        str2 = (str2 + " NetType/" + am.ee(ab.getContext())) + " Language/" + v.ea(ab.getContext());
        w.i("MicroMsg.WebViewUtil", "appendUserAgent, uaStr = " + str2);
        return str2;
    }

    public static boolean Np(String str) {
        if (str == null) {
            return false;
        }
        return str.toLowerCase().contains(" MicroMessenger/".trim().toLowerCase());
    }

    public static boolean eq(String str, String str2) {
        if (str == null || str2 == null || str.length() < 0 || str2.length() < 0 || str2.length() > str.length() || !str2.equalsIgnoreCase(str.substring(0, str2.length()))) {
            return false;
        }
        return true;
    }

    public static PackageInfo az(Context context, String str) {
        PackageInfo packageInfo = null;
        if (str == null) {
            w.e("MicroMsg.WebViewUtil", "getPackageInfo fail, packageName is null");
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WebViewUtil", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("silk", "audio/silk"));
        arrayList.add(new Pair("jpg", "image/jpg"));
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            hashMap.put(pair.first, pair.second);
            hashMap2.put(pair.second, pair.first);
        }
        sXM = Collections.unmodifiableMap(hashMap);
        sXN = Collections.unmodifiableMap(hashMap2);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (ihO == null) {
            ihO = new ar(1, "webview-save-image", 1);
        }
        ihO.c(new c(context, str, str2, z));
    }

    public static void a(Context context, String str, String str2, boolean z, b bVar) {
        if (ihO == null) {
            ihO = new ar(1, "webview-save-image", 1);
        }
        ihO.c(new c(context, str, str2, z, 1, bVar));
    }

    public static void a(final WebView webView) {
        if (webView != null) {
            w.d("MicroMsg.WebViewUtil", "initPingIFrame");
            af.v(new Runnable() {
                public final void run() {
                    webView.evaluateJavascript("javascript:var ping_iframe = document.getElementById('ping_iframe');if (ping_iframe === null) {ping_iframe = document.createElement('iframe');ping_iframe.id = 'ping_iframe';ping_iframe.style.display = 'none';document.documentElement.appendChild(ping_iframe);ping_iframe.src = ' weixinping://iframe ' }", null);
                }
            });
        }
    }

    public static void b(final WebView webView) {
        w.d("MicroMsg.WebViewUtil", "initIFrame");
        af.v(new Runnable() {
            public final void run() {
                webView.evaluateJavascript("javascript:var edw_iframe = document.getElementById('_edw_iframe_');if (edw_iframe === null) {edw_iframe = document.createElement('iframe');edw_iframe.id = '_edw_iframe_';edw_iframe.style.display = 'none';document.documentElement.appendChild(edw_iframe);}", null);
            }
        });
    }

    public static void a(WebView webView, String str, String str2) {
        a(webView, str, str2, true);
    }

    public static void a(final WebView webView, final String str, final String str2, final boolean z) {
        if (webView == null || bg.mA(str) || bg.mA(str2)) {
            w.e("MicroMsg.WebViewUtil", "getJsResult fail, invalid argument, scheme = %s, jsCode = %s", str, str2);
            return;
        }
        w.d("MicroMsg.WebViewUtil", "getJsResult, scheme = %s, jsCode = %s", str, str2);
        b(webView);
        af.v(new Runnable() {
            public final void run() {
                if (z) {
                    webView.evaluateJavascript("javascript:document.getElementById('_edw_iframe_').src = '" + str + "' + " + str2, null);
                } else {
                    webView.evaluateJavascript("javascript:console.log('" + str + "' + " + str2 + ")", null);
                }
            }
        });
    }

    public static String er(String str, String str2) {
        if (bg.mA(str) || bg.mA(str2)) {
            w.e("MicroMsg.WebViewUtil", "genJsCode fail, invalid argument, scheme = %s, jsCode = %s", str, str2);
            return null;
        }
        w.d("MicroMsg.WebViewUtil", "genJsCode, scheme = %s, jsCode = %s", str, str2);
        return "document.getElementById('_edw_iframe_').src = '" + str + "' + " + str2;
    }

    public static final String ac(Map<String, Object> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (!(bg.mA(str) || obj == null)) {
                if (!(obj instanceof String) || !bg.mA((String) obj)) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(str);
                    stringBuilder.append("=");
                    stringBuilder.append(obj);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static final String Nq(String str) {
        if (!bg.mA(str)) {
            try {
                str = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e) {
                w.e("MicroMsg.WebViewUtil", "URLEncode fail, throw : %s", e.getMessage());
            }
        }
        return str;
    }

    public static final String Nr(String str) {
        if (bg.mA(str)) {
            return str;
        }
        byte[] bytes;
        try {
            bytes = str.getBytes(ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            bytes = str.getBytes();
            w.e("MicroMsg.WebViewUtil", "getBytes fail, throw : %s", unsupportedEncodingException.getMessage());
        }
        return Base64.encodeToString(bytes, 2);
    }

    private static String dH(Context context) {
        WifiInfo connectionInfo;
        try {
            connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        } catch (Exception e) {
            connectionInfo = null;
        }
        if (connectionInfo == null) {
            return "127.0.0.1";
        }
        int ipAddress = connectionInfo.getIpAddress();
        return String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255)});
    }

    public static String bGM() {
        int i = 0;
        try {
            i = com.tencent.mm.compatible.d.v.rR();
        } catch (Exception e) {
            w.e("MicroMsg.WebViewUtil", "getSelfIp, call NetworkDetailInfo.getNetType(), exp = %s", e);
        }
        if (i == 0) {
            return "127.0.0.1";
        }
        if (i == 1) {
            return dH(ab.getContext());
        }
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if (networkInterface != null) {
                    Enumeration inetAddresses = networkInterface.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (inetAddress != null && !inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            return bg.mA(inetAddress.getHostAddress()) ? "127.0.0.1" : inetAddress.getHostAddress();
                        }
                    }
                    continue;
                }
            }
        } catch (Exception e2) {
        }
        return "127.0.0.1";
    }

    public static String Ns(String str) {
        if (!bg.mA(str) && sXL.matcher(str).matches()) {
            return str.substring(str.indexOf("base64,") + 7).trim();
        }
        return null;
    }

    public static String bwv() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ab.getContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return "no";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        w.d("MicroMsg.WebViewUtil", "activeNetInfo extra=%s, type=%d, %s", activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()), activeNetworkInfo.getExtraInfo());
        if (activeNetworkInfo.getExtraInfo() != null) {
            return activeNetworkInfo.getExtraInfo().toLowerCase();
        }
        return "no";
    }

    public static Boolean Nt(String str) {
        if (str != null && str.startsWith("Refused to frame")) {
            String[] split = str.split("'");
            if (split.length > 1 && split[1].equalsIgnoreCase("weixinpreinject://iframe")) {
                return Boolean.valueOf(true);
            }
        }
        return Boolean.valueOf(false);
    }

    public static Boolean Nu(String str) {
        if (str != null && str.startsWith("Refused to frame")) {
            String[] split = str.split("'");
            if (split.length > 1 && split[1].equalsIgnoreCase("weixinping://iframe")) {
                return Boolean.valueOf(true);
            }
        }
        return Boolean.valueOf(false);
    }

    public static String Nv(String str) {
        String str2 = "";
        if (str == null || !str.startsWith("Refused to frame")) {
            return str2;
        }
        String[] split = str.split("'");
        if (split.length > 2) {
            return split[1];
        }
        return str2;
    }

    public static String Nw(String str) {
        if (bg.mA(str)) {
            return null;
        }
        String str2 = (String) sXM.get(str.toLowerCase());
        if (!bg.mA(str2) || bg.mA(str)) {
            return str2;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
    }

    public static String Nx(String str) {
        return Nw(Ny(str));
    }

    public static String Ny(String str) {
        if (bg.mA(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String MB(String str) {
        if (bg.mA(str)) {
            return null;
        }
        String str2 = (String) sXN.get(str.toLowerCase());
        if (bg.mA(str2)) {
            return MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        }
        return str2;
    }
}
