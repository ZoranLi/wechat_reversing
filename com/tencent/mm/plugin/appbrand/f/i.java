package com.tencent.mm.plugin.appbrand.f;

import android.net.Uri;
import com.tencent.mm.plugin.appbrand.appcache.l;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.HttpSetting;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.protocal.c.akr;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import org.json.JSONObject;

public enum i {
    ;

    private static HashMap<String, String> pY(String str) {
        Object scheme;
        Exception e;
        HashMap<String, String> hashMap;
        Object obj = "";
        String str2 = "";
        Object obj2 = "";
        try {
            Uri parse = Uri.parse(str);
            obj = parse.getHost();
            scheme = parse.getScheme();
            try {
                obj2 = String.valueOf(parse.getPort());
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.AppBrandNetworkUtil", "message %s", new Object[]{e.getMessage()});
                hashMap = new HashMap();
                hashMap.put("host", obj);
                hashMap.put("scheme", scheme);
                hashMap.put("port", obj2);
                return hashMap;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            scheme = str2;
            e = exception;
            w.e("MicroMsg.AppBrandNetworkUtil", "message %s", new Object[]{e.getMessage()});
            hashMap = new HashMap();
            hashMap.put("host", obj);
            hashMap.put("scheme", scheme);
            hashMap.put("port", obj2);
            return hashMap;
        }
        hashMap = new HashMap();
        hashMap.put("host", obj);
        hashMap.put("scheme", scheme);
        hashMap.put("port", obj2);
        return hashMap;
    }

    private static Map<String, String> m(JSONObject jSONObject) {
        Map<String, String> hashMap = new HashMap();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    if (str != null) {
                        hashMap.put(str.toLowerCase(), optJSONObject.getString(str));
                    }
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.AppBrandNetworkUtil", "get header error, exception : %s", new Object[]{e});
        }
        return hashMap;
    }

    public static Map<String, String> n(JSONObject jSONObject) {
        Map<String, String> hashMap = new HashMap();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("formData");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    hashMap.put(str, optJSONObject.getString(str));
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.AppBrandNetworkUtil", "get form error, exception : %s", new Object[]{e});
        }
        return hashMap;
    }

    public static boolean b(ArrayList<String> arrayList, String str) {
        if (bg.mA(str)) {
            return false;
        }
        w.i("MicroMsg.AppBrandNetworkUtil", "url " + str);
        w.i("MicroMsg.AppBrandNetworkUtil", "configUrl size " + arrayList.size());
        HashMap pY = pY(str);
        String str2 = (String) pY.get("host");
        String str3 = (String) pY.get("scheme");
        String str4 = (String) pY.get("port");
        if (bg.mA(str2) || bg.mA(str3)) {
            return false;
        }
        w.i("MicroMsg.AppBrandNetworkUtil", "host %s  scheme %s port %s", new Object[]{str2, str3, str4});
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str5 = (String) it.next();
            w.i("MicroMsg.AppBrandNetworkUtil", "configUrl " + str5);
            HashMap pY2 = pY(str5);
            w.i("MicroMsg.AppBrandNetworkUtil", "confighost %s  configscheme %s configport %s", new Object[]{(String) pY2.get("host"), (String) pY2.get("scheme"), (String) pY2.get("port")});
            if (str2.equalsIgnoreCase((String) pY2.get("host")) && str3.equalsIgnoreCase(r4) && str4.equalsIgnoreCase(r5)) {
                w.i("MicroMsg.AppBrandNetworkUtil", "match!!");
                return true;
            }
        }
        return false;
    }

    public static Map<String, String> a(JSONObject jSONObject, AppBrandSysConfig appBrandSysConfig) {
        String str;
        Map<String, String> m = m(jSONObject);
        if (appBrandSysConfig.iFm != null) {
            HttpSetting httpSetting = appBrandSysConfig.iFm.iEt;
            if (httpSetting != null) {
                Map<String, String> map;
                ArrayList arrayList;
                if (httpSetting.mode == 1) {
                    if (httpSetting.iEA != null) {
                        arrayList = httpSetting.iEA;
                        if (arrayList == null || arrayList.isEmpty()) {
                            w.e("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderBlackList fail, headerMap is null or blacklist is null or nil.");
                        } else {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                str = (String) it.next();
                                if (str != null) {
                                    if (((String) m.remove(str.toLowerCase())) != null) {
                                        w.v("MicroMsg.AppBrandNetworkUtil", "remove key %s value %s", new Object[]{str.toLowerCase(), (String) m.remove(str.toLowerCase())});
                                    }
                                }
                            }
                        }
                        map = m;
                    }
                } else if (httpSetting.mode == 2 && httpSetting.iEB != null) {
                    arrayList = httpSetting.iEB;
                    if (arrayList == null) {
                        w.e("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderWhiteList fail");
                        map = m;
                    } else {
                        Map<String, String> hashMap = new HashMap();
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            str = (String) it2.next();
                            if (str != null) {
                                String toLowerCase = str.toLowerCase();
                                str = (String) m.get(toLowerCase);
                                if (str != null) {
                                    w.v("MicroMsg.AppBrandNetworkUtil", "add item, key(%s), value(%s)", new Object[]{toLowerCase, str});
                                    hashMap.put(toLowerCase, str);
                                }
                            }
                        }
                        map = hashMap;
                    }
                }
                m = map;
            }
        }
        m.remove("referer");
        String str2 = "referer";
        str = "";
        if (!(appBrandSysConfig.iFm == null || appBrandSysConfig.iFm.iEt == null)) {
            str = appBrandSysConfig.iFm.iEt.iEG;
        }
        if (bg.mA(str)) {
            str = "servicewechat.com";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://");
        stringBuilder.append(str);
        stringBuilder.append("/");
        stringBuilder.append(appBrandSysConfig.appId);
        stringBuilder.append("/");
        stringBuilder.append(b.mY(appBrandSysConfig.appId).iFk.izW);
        stringBuilder.append("/page-frame.html");
        m.put(str2, stringBuilder.toString());
        return m;
    }

    public static int a(AppBrandSysConfig appBrandSysConfig, a aVar, int i) {
        int i2;
        int i3;
        int i4;
        switch (i) {
            case 0:
                i2 = aVar.iDP.fLY;
                if (appBrandSysConfig.iFm == null || appBrandSysConfig.iFm.iEt == null) {
                    i3 = 0;
                } else {
                    i3 = appBrandSysConfig.iFm.iEt.iEC;
                }
                w.i("MicroMsg.AppBrandNetworkUtil", "request apptimeout %d, systimeout %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                i4 = i3;
                i3 = i2;
                i2 = i4;
                break;
            case 1:
                i2 = aVar.iDP.iDS;
                if (appBrandSysConfig.iFm == null || appBrandSysConfig.iFm.iEt == null) {
                    i3 = 0;
                } else {
                    i3 = appBrandSysConfig.iFm.iEt.iEC;
                }
                w.i("MicroMsg.AppBrandNetworkUtil", "socket apptimeout %d, systimeout %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                i4 = i3;
                i3 = i2;
                i2 = i4;
                break;
            case 2:
                i2 = aVar.iDP.iDT;
                if (appBrandSysConfig.iFm == null || appBrandSysConfig.iFm.iEt == null) {
                    i3 = 0;
                } else {
                    i3 = appBrandSysConfig.iFm.iEt.iED;
                }
                w.i("MicroMsg.AppBrandNetworkUtil", "upload apptimeout %d, systimeout %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                i4 = i3;
                i3 = i2;
                i2 = i4;
                break;
            case 3:
                i2 = aVar.iDP.iDU;
                if (appBrandSysConfig.iFm == null || appBrandSysConfig.iFm.iEt == null) {
                    i3 = 0;
                } else {
                    i3 = appBrandSysConfig.iFm.iEt.iEE;
                }
                w.i("MicroMsg.AppBrandNetworkUtil", "download apptimeout %d, systimeout %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                i4 = i3;
                i3 = i2;
                i2 = i4;
                break;
            default:
                i2 = 0;
                i3 = 0;
                break;
        }
        if (i3 > 0 && i2 <= 0) {
            return i3;
        }
        if (i3 <= 0 && i2 > 0) {
            return i2;
        }
        if (i3 <= 0 || i2 <= 0) {
            return 0;
        }
        return Math.min(i3, i2);
    }

    public static boolean ia(int i) {
        return i == 302 || i == com.tencent.mm.plugin.appbrand.jsapi.l.b.CTRL_INDEX;
    }

    public static String c(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return "";
        }
        URL url = httpURLConnection.getURL();
        if (url == null) {
            return "";
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        if (headerField == null) {
            headerField = httpURLConnection.getHeaderField("location");
        }
        if (headerField == null) {
            return null;
        }
        try {
            return url.toURI().resolve(headerField).toString();
        } catch (URISyntaxException e) {
            w.e("MicroMsg.AppBrandNetworkUtil", "resolve url error %s", new Object[]{e.getMessage()});
            return headerField;
        }
    }

    public static boolean c(AppBrandSysConfig appBrandSysConfig) {
        return ((appBrandSysConfig.iFk.izV == 1 || appBrandSysConfig.iFk.izV == 2) && appBrandSysConfig.iER) ? false : true;
    }

    public static void a(HttpURLConnection httpURLConnection, final ArrayList<String> arrayList) {
        if (httpURLConnection != null) {
            final HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() {
                public final boolean verify(String str, SSLSession sSLSession) {
                    return defaultHostnameVerifier.verify(str, sSLSession) || i.c(arrayList, str);
                }
            });
        }
    }

    public static SSLContext pZ(String str) {
        if (qa(str) == null) {
            return null;
        }
        TrustManager[] trustManagerArr = new TrustManager[]{qa(str)};
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, trustManagerArr, null);
            return instance;
        } catch (Exception e) {
            w.e("MicroMsg.AppBrandNetworkUtil", "SSLContext init error: " + e);
            return null;
        }
    }

    public static l qa(String str) {
        LinkedList qb = qb(str);
        if (qb.isEmpty()) {
            return null;
        }
        l lVar = new l();
        Iterator it = qb.iterator();
        while (it.hasNext()) {
            InputStream inputStream = (InputStream) it.next();
            if (lVar.jbF == null) {
                w.e("MicroMsg.AppBrandX509TrustManager", "local keystore is null");
            } else {
                try {
                    Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
                    inputStream.close();
                    lVar.jbF.setCertificateEntry(((X509Certificate) generateCertificate).getSubjectDN(), generateCertificate);
                } catch (Exception e) {
                    w.e("MicroMsg.AppBrandX509TrustManager", "initLocalSelfSignedCertificate:" + e);
                } catch (Throwable th) {
                    inputStream.close();
                }
            }
        }
        lVar.init();
        return lVar;
    }

    private static LinkedList<InputStream> qb(String str) {
        LinkedList<InputStream> linkedList = new LinkedList();
        byte[] e = l.e(b.mW(str), "cer");
        if (e == null) {
            return linkedList;
        }
        try {
            akr com_tencent_mm_protocal_c_akr = new akr();
            com_tencent_mm_protocal_c_akr.aD(e);
            if (com_tencent_mm_protocal_c_akr.tOq == null) {
                return linkedList;
            }
            Iterator it = com_tencent_mm_protocal_c_akr.tOq.iterator();
            while (it.hasNext()) {
                linkedList.add(new ByteArrayInputStream(((com.tencent.mm.bd.b) it.next()).sYA));
            }
            return linkedList;
        } catch (Exception e2) {
            w.e("MicroMsg.AppBrandNetworkUtil", "parse error: " + e2);
        }
    }
}
