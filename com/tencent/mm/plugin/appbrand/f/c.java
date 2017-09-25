package com.tencent.mm.plugin.appbrand.f;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class c {
    private String ivH;
    private int jaQ;
    private SSLContext jaS;
    protected final ArrayList<d> jaZ = new ArrayList();

    public interface a {
        void a(String str, String str2, int i, JSONObject jSONObject);

        void aX(String str, String str2);
    }

    public c(String str) {
        this.ivH = str;
        this.jaQ = b.mY(str).iEW;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.appbrand.f.d r21) {
        /*
        r20 = this;
        r0 = r20;
        r2 = r0.ivH;
        r16 = com.tencent.mm.plugin.appbrand.a.mV(r2);
        r13 = 0;
        r15 = 0;
        r14 = 0;
        r0 = r21;
        r0 = r0.jbf;
        r17 = r0;
        r0 = r21;
        r0 = r0.jbg;
        r18 = r0;
        r12 = 0;
        r11 = 0;
        r0 = r21;
        r0 = r0.jbh;
        r19 = r0;
        if (r19 == 0) goto L_0x0069;
    L_0x0021:
        r0 = r21;
        r2 = r0.mUrl;
        r0 = r19;
        r2 = com.tencent.mm.plugin.appbrand.f.i.b(r0, r2);
        if (r2 != 0) goto L_0x0069;
    L_0x002d:
        r2 = "fail";
        r3 = "url not in domain list";
        r0 = r17;
        r0.aX(r2, r3);
        r0 = r20;
        r2 = r0.ivH;
        r0 = r21;
        r3 = r0.jbk;
        r0 = r21;
        r4 = r0.jbe;
        r0 = r21;
        r5 = r0.mUrl;
        r6 = 0;
        r8 = 0;
        r10 = 0;
        r11 = 2;
        r12 = r21.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "not in domain url %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r21;
        r6 = r0.mUrl;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
    L_0x0068:
        return;
    L_0x0069:
        r3 = com.tencent.mm.plugin.report.service.g.oUh;
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 0;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "prepare to send https request url is %s method is %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r21;
        r6 = r0.mUrl;
        r4[r5] = r6;
        r5 = 1;
        r0 = r21;
        r6 = r0.jbe;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
        r2 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x083d, SSLHandshakeException -> 0x0522, FileNotFoundException -> 0x05a9, SocketTimeoutException -> 0x0630, Exception -> 0x06c8, all -> 0x0760 }
        r0 = r21;
        r3 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x083d, SSLHandshakeException -> 0x0522, FileNotFoundException -> 0x05a9, SocketTimeoutException -> 0x0630, Exception -> 0x06c8, all -> 0x0760 }
        r2.<init>(r3);	 Catch:{ UnsupportedEncodingException -> 0x083d, SSLHandshakeException -> 0x0522, FileNotFoundException -> 0x05a9, SocketTimeoutException -> 0x0630, Exception -> 0x06c8, all -> 0x0760 }
        r2 = r2.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x083d, SSLHandshakeException -> 0x0522, FileNotFoundException -> 0x05a9, SocketTimeoutException -> 0x0630, Exception -> 0x06c8, all -> 0x0760 }
        r0 = r2;
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ UnsupportedEncodingException -> 0x083d, SSLHandshakeException -> 0x0522, FileNotFoundException -> 0x05a9, SocketTimeoutException -> 0x0630, Exception -> 0x06c8, all -> 0x0760 }
        r13 = r0;
        r0 = r21;
        r2 = r0.iKz;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        if (r2 != 0) goto L_0x00ae;
    L_0x00aa:
        r0 = r21;
        r0.jbj = r13;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
    L_0x00ae:
        if (r13 != 0) goto L_0x00d9;
    L_0x00b0:
        r0 = r20;
        r2 = r0.ivH;
        r0 = r21;
        r3 = r0.jbk;
        r0 = r21;
        r4 = r0.jbe;
        r0 = r21;
        r5 = r0.mUrl;
        r6 = r21.getDataSize();
        r8 = 0;
        r10 = 0;
        r11 = 2;
        r12 = r21.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r21;
        r2 = r0.mUrl;
        r0 = r20;
        r0.a(r2, r13);
        goto L_0x0068;
    L_0x00d9:
        r2 = r13 instanceof javax.net.ssl.HttpsURLConnection;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        if (r2 == 0) goto L_0x0121;
    L_0x00dd:
        r0 = r20;
        r2 = r0.jaS;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        if (r2 != 0) goto L_0x00ef;
    L_0x00e3:
        r0 = r20;
        r2 = r0.ivH;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r2 = com.tencent.mm.plugin.appbrand.f.i.pZ(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r0 = r20;
        r0.jaS = r2;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
    L_0x00ef:
        r0 = r20;
        r2 = r0.jaS;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        if (r2 == 0) goto L_0x0104;
    L_0x00f5:
        r0 = r13;
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r2 = r0;
        r0 = r20;
        r3 = r0.jaS;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r3 = r3.getSocketFactory();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r2.setSSLSocketFactory(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
    L_0x0104:
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r4 = "DomainList: ";
        r3.<init>(r4);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r0 = r19;
        r3 = r3.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r3 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r0 = r19;
        com.tencent.mm.plugin.appbrand.f.i.a(r13, r0);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
    L_0x0121:
        r0 = r21;
        r2 = r0.jbc;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r13.setConnectTimeout(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r0 = r21;
        r2 = r0.jbc;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r13.setReadTimeout(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r2 = "charset";
        r3 = "utf-8";
        r13.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r2 = 0;
        r13.setInstanceFollowRedirects(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r0 = r21;
        r2 = r0.jbe;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r13.setRequestMethod(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r2 = 1;
        r13.setUseCaches(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r2 = "Accept-Encoding";
        r3 = "gzip";
        r13.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        if (r18 == 0) goto L_0x0226;
    L_0x0152:
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "url %s : set header ";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r5 = 0;
        r0 = r21;
        r6 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r2 = r18.entrySet();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r5 = r2.iterator();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
    L_0x016d:
        r2 = r5.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        if (r2 == 0) goto L_0x0226;
    L_0x0173:
        r2 = r5.next();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r0 = r2;
        r0 = (java.util.Map.Entry) r0;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r4 = r0;
        r2 = r4.getKey();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r2 = (java.lang.String) r2;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r3 = r4.getValue();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r3 = (java.lang.String) r3;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r13.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "url %s : key:%s ,value %s ";
        r6 = 3;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r7 = 0;
        r0 = r21;
        r8 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r7 = 1;
        r8 = r4.getKey();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r7 = 2;
        r4 = r4.getValue();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r6[r7] = r4;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r6);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        goto L_0x016d;
    L_0x01ac:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
        r11 = r12;
    L_0x01b1:
        r3 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x07cc }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 1;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x07cc }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "UnsupportedEncodingException: url %s, fail reason : %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x07cc }
        r6 = 0;
        r0 = r21;
        r7 = r0.mUrl;	 Catch:{ all -> 0x07cc }
        r5[r6] = r7;	 Catch:{ all -> 0x07cc }
        r6 = 1;
        r2 = r2.toString();	 Catch:{ all -> 0x07cc }
        r5[r6] = r2;	 Catch:{ all -> 0x07cc }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ all -> 0x07cc }
        r2 = "fail";
        r3 = "UTF-8 decode error";
        r0 = r17;
        r0.aX(r2, r3);	 Catch:{ all -> 0x07cc }
        r0 = r20;
        r2 = r0.ivH;
        r0 = r21;
        r3 = r0.jbk;
        r0 = r21;
        r4 = r0.jbe;
        r0 = r21;
        r5 = r0.mUrl;
        r6 = r21.getDataSize();
        r8 = (long) r11;
        r11 = 2;
        r12 = r21.Vn();
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r21;
        r2 = r0.mUrl;
        r0 = r20;
        r1 = r16;
        r0.a(r2, r1);
        if (r15 == 0) goto L_0x0210;
    L_0x020d:
        r15.close();	 Catch:{ IOException -> 0x0513 }
    L_0x0210:
        if (r14 == 0) goto L_0x0068;
    L_0x0212:
        r14.close();	 Catch:{ IOException -> 0x0217 }
        goto L_0x0068;
    L_0x0217:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0068;
    L_0x0226:
        r2 = "User-Agent";
        r3 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r4 = "";
        r3 = com.tencent.mm.pluginsdk.ui.tools.s.aZ(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r13.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r0 = r21;
        r2 = r0.jbe;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r2 = pT(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        if (r2 == 0) goto L_0x0274;
    L_0x0241:
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "set post or put";
        com.tencent.mm.sdk.platformtools.w.i(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r2 = "Content-Length";
        r0 = r21;
        r3 = r0.jbd;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r3 = r3.length;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r13.setRequestProperty(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r2 = 1;
        r13.setDoOutput(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r3 = new java.io.DataOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r2 = r13.getOutputStream();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r3.<init>(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r0 = r21;
        r2 = r0.jbd;	 Catch:{ UnsupportedEncodingException -> 0x0844, SSLHandshakeException -> 0x0829, FileNotFoundException -> 0x080f, SocketTimeoutException -> 0x07f5, Exception -> 0x07db, all -> 0x07ba }
        r3.write(r2);	 Catch:{ UnsupportedEncodingException -> 0x0844, SSLHandshakeException -> 0x0829, FileNotFoundException -> 0x080f, SocketTimeoutException -> 0x07f5, Exception -> 0x07db, all -> 0x07ba }
        r3.flush();	 Catch:{ UnsupportedEncodingException -> 0x0844, SSLHandshakeException -> 0x0829, FileNotFoundException -> 0x080f, SocketTimeoutException -> 0x07f5, Exception -> 0x07db, all -> 0x07ba }
        r3.close();	 Catch:{ UnsupportedEncodingException -> 0x0844, SSLHandshakeException -> 0x0829, FileNotFoundException -> 0x080f, SocketTimeoutException -> 0x07f5, Exception -> 0x07db, all -> 0x07ba }
        r14 = r3;
    L_0x0274:
        r10 = r13.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x01ac, SSLHandshakeException -> 0x0823, FileNotFoundException -> 0x0809, SocketTimeoutException -> 0x07ef, Exception -> 0x07d5, all -> 0x07b4 }
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "responseCode = %d, url = %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r10);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r5 = 1;
        r0 = r21;
        r6 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r10 == r2) goto L_0x03a5;
    L_0x0296:
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "url is %s, failed code: %d";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r5 = 0;
        r0 = r21;
        r6 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r5 = 1;
        r6 = java.lang.Integer.valueOf(r10);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r2 = com.tencent.mm.plugin.appbrand.f.i.ia(r10);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        if (r2 == 0) goto L_0x03a5;
    L_0x02b6:
        r2 = com.tencent.mm.plugin.appbrand.f.i.c(r13);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r0 = r21;
        r3 = r0.jbi;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r4 = android.text.TextUtils.isEmpty(r2);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        if (r4 != 0) goto L_0x03a5;
    L_0x02c4:
        if (r3 > 0) goto L_0x0327;
    L_0x02c6:
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "reach the max redirect count(%d)";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r5 = 0;
        r6 = 15;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        com.tencent.mm.sdk.platformtools.w.w(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r2 = "ok";
        r3 = "reach the max redirect count 15";
        r4 = b(r13);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r0 = r17;
        r0.a(r2, r3, r10, r4);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r0 = r20;
        r2 = r0.ivH;
        r0 = r21;
        r3 = r0.jbk;
        r0 = r21;
        r4 = r0.jbe;
        r0 = r21;
        r5 = r0.mUrl;
        r6 = r21.getDataSize();
        r8 = 0;
        r11 = 1;
        r12 = r21.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r21;
        r2 = r0.mUrl;
        r0 = r20;
        r0.a(r2, r13);
        if (r14 == 0) goto L_0x0068;
    L_0x0313:
        r14.close();	 Catch:{ IOException -> 0x0318 }
        goto L_0x0068;
    L_0x0318:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0068;
    L_0x0327:
        r4 = "MicroMsg.AppBrandNetworkRequest";
        r5 = "redirect(%d) URL(%s) to URL(%s)";
        r6 = 3;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r7 = 0;
        r8 = java.lang.Integer.valueOf(r3);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r7 = 1;
        r0 = r21;
        r8 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r7 = 2;
        r6[r7] = r2;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r0 = r21;
        r0.mUrl = r2;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r2 = r3 + -1;
        r0 = r21;
        r0.jbi = r2;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "now redirect count = %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r5 = 0;
        r0 = r21;
        r6 = r0.jbi;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r20.a(r21);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r0 = r20;
        r2 = r0.ivH;
        r0 = r21;
        r3 = r0.jbk;
        r0 = r21;
        r4 = r0.jbe;
        r0 = r21;
        r5 = r0.mUrl;
        r6 = r21.getDataSize();
        r8 = 0;
        r11 = 2;
        r12 = r21.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r21;
        r2 = r0.mUrl;
        r0 = r20;
        r0.a(r2, r13);
        if (r14 == 0) goto L_0x0068;
    L_0x0391:
        r14.close();	 Catch:{ IOException -> 0x0396 }
        goto L_0x0068;
    L_0x0396:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0068;
    L_0x03a5:
        r3 = "";
        r4 = new java.io.ByteArrayOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r4.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r2 = "gzip";
        r5 = r13.getContentEncoding();	 Catch:{ Exception -> 0x0429, UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, all -> 0x07c1 }
        r2 = r2.equals(r5);	 Catch:{ Exception -> 0x0429, UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, all -> 0x07c1 }
        if (r2 == 0) goto L_0x0424;
    L_0x03ba:
        r2 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x0429, UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, all -> 0x07c1 }
        r5 = r13.getInputStream();	 Catch:{ Exception -> 0x0429, UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, all -> 0x07c1 }
        r2.<init>(r5);	 Catch:{ Exception -> 0x0429, UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, all -> 0x07c1 }
        r15 = r2;
    L_0x03c4:
        if (r15 == 0) goto L_0x0853;
    L_0x03c6:
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2 = new byte[r2];	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r8 = r12;
    L_0x03cb:
        r3 = r15.read(r2);	 Catch:{ UnsupportedEncodingException -> 0x084c, SSLHandshakeException -> 0x0836, FileNotFoundException -> 0x081c, SocketTimeoutException -> 0x0802, Exception -> 0x07e8, all -> 0x07c6 }
        r5 = -1;
        if (r3 == r5) goto L_0x048e;
    L_0x03d2:
        r5 = r16.Pn();	 Catch:{ UnsupportedEncodingException -> 0x084c, SSLHandshakeException -> 0x0836, FileNotFoundException -> 0x081c, SocketTimeoutException -> 0x0802, Exception -> 0x07e8, all -> 0x07c6 }
        if (r5 == 0) goto L_0x0487;
    L_0x03d8:
        r2 = "fail";
        r3 = "interrupted";
        r0 = r17;
        r0.aX(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x084c, SSLHandshakeException -> 0x0836, FileNotFoundException -> 0x081c, SocketTimeoutException -> 0x0802, Exception -> 0x07e8, all -> 0x07c6 }
        r0 = r20;
        r2 = r0.ivH;
        r0 = r21;
        r3 = r0.jbk;
        r0 = r21;
        r4 = r0.jbe;
        r0 = r21;
        r5 = r0.mUrl;
        r6 = r21.getDataSize();
        r8 = (long) r8;
        r11 = 2;
        r12 = r21.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r21;
        r2 = r0.mUrl;
        r0 = r20;
        r0.a(r2, r13);
        if (r15 == 0) goto L_0x040e;
    L_0x040b:
        r15.close();	 Catch:{ IOException -> 0x0479 }
    L_0x040e:
        if (r14 == 0) goto L_0x0068;
    L_0x0410:
        r14.close();	 Catch:{ IOException -> 0x0415 }
        goto L_0x0068;
    L_0x0415:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0068;
    L_0x0424:
        r15 = r13.getInputStream();	 Catch:{ Exception -> 0x0429, UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, all -> 0x07c1 }
        goto L_0x03c4;
    L_0x0429:
        r2 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkRequest";
        r6 = "read input stream failed : %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r8 = 0;
        r2 = r2.toString();	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r7[r8] = r2;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r2 = "gzip";
        r5 = r13.getContentEncoding();	 Catch:{ Exception -> 0x045c, UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, all -> 0x07c1 }
        r2 = r2.equals(r5);	 Catch:{ Exception -> 0x045c, UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, all -> 0x07c1 }
        if (r2 == 0) goto L_0x0456;
    L_0x044a:
        r2 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x045c, UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, all -> 0x07c1 }
        r5 = r13.getErrorStream();	 Catch:{ Exception -> 0x045c, UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, all -> 0x07c1 }
        r2.<init>(r5);	 Catch:{ Exception -> 0x045c, UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, all -> 0x07c1 }
        r15 = r2;
        goto L_0x03c4;
    L_0x0456:
        r15 = r13.getErrorStream();	 Catch:{ Exception -> 0x045c, UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, all -> 0x07c1 }
        goto L_0x03c4;
    L_0x045c:
        r2 = move-exception;
        r5 = "MicroMsg.AppBrandNetworkRequest";
        r6 = "read err stream failed : %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r8 = 0;
        r2 = r2.toString();	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        r7[r8] = r2;	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x0472, SSLHandshakeException -> 0x0830, FileNotFoundException -> 0x0816, SocketTimeoutException -> 0x07fc, Exception -> 0x07e2, all -> 0x07c1 }
        goto L_0x03c4;
    L_0x0472:
        r2 = move-exception;
        r11 = r12;
        r16 = r13;
        r13 = r10;
        goto L_0x01b1;
    L_0x0479:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x040e;
    L_0x0487:
        r5 = 0;
        r4.write(r2, r5, r3);	 Catch:{ UnsupportedEncodingException -> 0x084c, SSLHandshakeException -> 0x0836, FileNotFoundException -> 0x081c, SocketTimeoutException -> 0x0802, Exception -> 0x07e8, all -> 0x07c6 }
        r8 = r8 + r3;
        goto L_0x03cb;
    L_0x048e:
        r4.flush();	 Catch:{ UnsupportedEncodingException -> 0x084c, SSLHandshakeException -> 0x0836, FileNotFoundException -> 0x081c, SocketTimeoutException -> 0x0802, Exception -> 0x07e8, all -> 0x07c6 }
        r15.close();	 Catch:{ UnsupportedEncodingException -> 0x084c, SSLHandshakeException -> 0x0836, FileNotFoundException -> 0x081c, SocketTimeoutException -> 0x0802, Exception -> 0x07e8, all -> 0x07c6 }
        r2 = "UTF-8";
        r2 = r4.toString(r2);	 Catch:{ UnsupportedEncodingException -> 0x084c, SSLHandshakeException -> 0x0836, FileNotFoundException -> 0x081c, SocketTimeoutException -> 0x0802, Exception -> 0x07e8, all -> 0x07c6 }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r5 = "url %s : buffer string %s";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x084c, SSLHandshakeException -> 0x0836, FileNotFoundException -> 0x081c, SocketTimeoutException -> 0x0802, Exception -> 0x07e8, all -> 0x07c6 }
        r7 = 0;
        r0 = r21;
        r9 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x084c, SSLHandshakeException -> 0x0836, FileNotFoundException -> 0x081c, SocketTimeoutException -> 0x0802, Exception -> 0x07e8, all -> 0x07c6 }
        r6[r7] = r9;	 Catch:{ UnsupportedEncodingException -> 0x084c, SSLHandshakeException -> 0x0836, FileNotFoundException -> 0x081c, SocketTimeoutException -> 0x0802, Exception -> 0x07e8, all -> 0x07c6 }
        r7 = 1;
        r9 = "UTF-8";
        r4 = r4.toString(r9);	 Catch:{ UnsupportedEncodingException -> 0x084c, SSLHandshakeException -> 0x0836, FileNotFoundException -> 0x081c, SocketTimeoutException -> 0x0802, Exception -> 0x07e8, all -> 0x07c6 }
        r6[r7] = r4;	 Catch:{ UnsupportedEncodingException -> 0x084c, SSLHandshakeException -> 0x0836, FileNotFoundException -> 0x081c, SocketTimeoutException -> 0x0802, Exception -> 0x07e8, all -> 0x07c6 }
        com.tencent.mm.sdk.platformtools.w.v(r3, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x084c, SSLHandshakeException -> 0x0836, FileNotFoundException -> 0x081c, SocketTimeoutException -> 0x0802, Exception -> 0x07e8, all -> 0x07c6 }
    L_0x04b8:
        r3 = "ok";
        r4 = b(r13);	 Catch:{ UnsupportedEncodingException -> 0x084c, SSLHandshakeException -> 0x0836, FileNotFoundException -> 0x081c, SocketTimeoutException -> 0x0802, Exception -> 0x07e8, all -> 0x07c6 }
        r0 = r17;
        r0.a(r3, r2, r10, r4);	 Catch:{ UnsupportedEncodingException -> 0x084c, SSLHandshakeException -> 0x0836, FileNotFoundException -> 0x081c, SocketTimeoutException -> 0x0802, Exception -> 0x07e8, all -> 0x07c6 }
        r0 = r20;
        r2 = r0.ivH;
        r0 = r21;
        r3 = r0.jbk;
        r0 = r21;
        r4 = r0.jbe;
        r0 = r21;
        r5 = r0.mUrl;
        r6 = r21.getDataSize();
        r8 = (long) r8;
        r11 = 1;
        r12 = r21.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r21;
        r2 = r0.mUrl;
        r0 = r20;
        r0.a(r2, r13);
        if (r15 == 0) goto L_0x04ef;
    L_0x04ec:
        r15.close();	 Catch:{ IOException -> 0x0505 }
    L_0x04ef:
        if (r14 == 0) goto L_0x0068;
    L_0x04f1:
        r14.close();	 Catch:{ IOException -> 0x04f6 }
        goto L_0x0068;
    L_0x04f6:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0068;
    L_0x0505:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x04ef;
    L_0x0513:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0210;
    L_0x0522:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
    L_0x0526:
        r3 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x07d1 }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 2;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x07d1 }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "SSLHandshakeException: url %s, fail reason : %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x07d1 }
        r6 = 0;
        r0 = r21;
        r7 = r0.mUrl;	 Catch:{ all -> 0x07d1 }
        r5[r6] = r7;	 Catch:{ all -> 0x07d1 }
        r6 = 1;
        r2 = r2.toString();	 Catch:{ all -> 0x07d1 }
        r5[r6] = r2;	 Catch:{ all -> 0x07d1 }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ all -> 0x07d1 }
        r2 = "fail";
        r3 = "ssl hand shake error";
        r0 = r17;
        r0.aX(r2, r3);	 Catch:{ all -> 0x07d1 }
        r0 = r20;
        r2 = r0.ivH;
        r0 = r21;
        r3 = r0.jbk;
        r0 = r21;
        r4 = r0.jbe;
        r0 = r21;
        r5 = r0.mUrl;
        r6 = r21.getDataSize();
        r8 = (long) r12;
        r11 = 2;
        r12 = r21.Vn();
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r21;
        r2 = r0.mUrl;
        r0 = r20;
        r1 = r16;
        r0.a(r2, r1);
        if (r15 == 0) goto L_0x0585;
    L_0x0582:
        r15.close();	 Catch:{ IOException -> 0x059b }
    L_0x0585:
        if (r14 == 0) goto L_0x0068;
    L_0x0587:
        r14.close();	 Catch:{ IOException -> 0x058c }
        goto L_0x0068;
    L_0x058c:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0068;
    L_0x059b:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0585;
    L_0x05a9:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
    L_0x05ad:
        r3 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x07d1 }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 3;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x07d1 }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "FileNotFoundException: url %s, fail reason : %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x07d1 }
        r6 = 0;
        r0 = r21;
        r7 = r0.mUrl;	 Catch:{ all -> 0x07d1 }
        r5[r6] = r7;	 Catch:{ all -> 0x07d1 }
        r6 = 1;
        r2 = r2.toString();	 Catch:{ all -> 0x07d1 }
        r5[r6] = r2;	 Catch:{ all -> 0x07d1 }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ all -> 0x07d1 }
        r2 = "fail";
        r3 = "file not exist error";
        r0 = r17;
        r0.aX(r2, r3);	 Catch:{ all -> 0x07d1 }
        r0 = r20;
        r2 = r0.ivH;
        r0 = r21;
        r3 = r0.jbk;
        r0 = r21;
        r4 = r0.jbe;
        r0 = r21;
        r5 = r0.mUrl;
        r6 = r21.getDataSize();
        r8 = (long) r12;
        r11 = 2;
        r12 = r21.Vn();
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r21;
        r2 = r0.mUrl;
        r0 = r20;
        r1 = r16;
        r0.a(r2, r1);
        if (r15 == 0) goto L_0x060c;
    L_0x0609:
        r15.close();	 Catch:{ IOException -> 0x0622 }
    L_0x060c:
        if (r14 == 0) goto L_0x0068;
    L_0x060e:
        r14.close();	 Catch:{ IOException -> 0x0613 }
        goto L_0x0068;
    L_0x0613:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0068;
    L_0x0622:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x060c;
    L_0x0630:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
    L_0x0634:
        r3 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x07d1 }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 4;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x07d1 }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "url is %s, failed reason: %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x07d1 }
        r6 = 0;
        r0 = r21;
        r7 = r0.mUrl;	 Catch:{ all -> 0x07d1 }
        r5[r6] = r7;	 Catch:{ all -> 0x07d1 }
        r6 = 1;
        r7 = r2.toString();	 Catch:{ all -> 0x07d1 }
        r5[r6] = r7;	 Catch:{ all -> 0x07d1 }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ all -> 0x07d1 }
        r3 = "fail";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x07d1 }
        r5 = "send request fail:";
        r4.<init>(r5);	 Catch:{ all -> 0x07d1 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x07d1 }
        r2 = r4.append(r2);	 Catch:{ all -> 0x07d1 }
        r2 = r2.toString();	 Catch:{ all -> 0x07d1 }
        r0 = r17;
        r0.aX(r3, r2);	 Catch:{ all -> 0x07d1 }
        r0 = r20;
        r2 = r0.ivH;
        r0 = r21;
        r3 = r0.jbk;
        r0 = r21;
        r4 = r0.jbe;
        r0 = r21;
        r5 = r0.mUrl;
        r6 = r21.getDataSize();
        r8 = (long) r12;
        r11 = 2;
        r12 = r21.Vn();
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r21;
        r2 = r0.mUrl;
        r0 = r20;
        r1 = r16;
        r0.a(r2, r1);
        if (r15 == 0) goto L_0x06a4;
    L_0x06a1:
        r15.close();	 Catch:{ IOException -> 0x06ba }
    L_0x06a4:
        if (r14 == 0) goto L_0x0068;
    L_0x06a6:
        r14.close();	 Catch:{ IOException -> 0x06ab }
        goto L_0x0068;
    L_0x06ab:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0068;
    L_0x06ba:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x06a4;
    L_0x06c8:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
    L_0x06cc:
        r3 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x07d1 }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 5;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x07d1 }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "url is %s,failed reason: %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x07d1 }
        r6 = 0;
        r0 = r21;
        r7 = r0.mUrl;	 Catch:{ all -> 0x07d1 }
        r5[r6] = r7;	 Catch:{ all -> 0x07d1 }
        r6 = 1;
        r7 = r2.toString();	 Catch:{ all -> 0x07d1 }
        r5[r6] = r7;	 Catch:{ all -> 0x07d1 }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ all -> 0x07d1 }
        r3 = "fail";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x07d1 }
        r5 = "send request fail:";
        r4.<init>(r5);	 Catch:{ all -> 0x07d1 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x07d1 }
        r2 = r4.append(r2);	 Catch:{ all -> 0x07d1 }
        r2 = r2.toString();	 Catch:{ all -> 0x07d1 }
        r0 = r17;
        r0.aX(r3, r2);	 Catch:{ all -> 0x07d1 }
        r0 = r20;
        r2 = r0.ivH;
        r0 = r21;
        r3 = r0.jbk;
        r0 = r21;
        r4 = r0.jbe;
        r0 = r21;
        r5 = r0.mUrl;
        r6 = r21.getDataSize();
        r8 = (long) r12;
        r11 = 2;
        r12 = r21.Vn();
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r21;
        r2 = r0.mUrl;
        r0 = r20;
        r1 = r16;
        r0.a(r2, r1);
        if (r15 == 0) goto L_0x073c;
    L_0x0739:
        r15.close();	 Catch:{ IOException -> 0x0752 }
    L_0x073c:
        if (r14 == 0) goto L_0x0068;
    L_0x073e:
        r14.close();	 Catch:{ IOException -> 0x0743 }
        goto L_0x0068;
    L_0x0743:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0068;
    L_0x0752:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x073c;
    L_0x0760:
        r2 = move-exception;
        r10 = r11;
        r16 = r13;
        r13 = r2;
    L_0x0765:
        r0 = r20;
        r2 = r0.ivH;
        r0 = r21;
        r3 = r0.jbk;
        r0 = r21;
        r4 = r0.jbe;
        r0 = r21;
        r5 = r0.mUrl;
        r6 = r21.getDataSize();
        r8 = (long) r12;
        r11 = 2;
        r12 = r21.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r0 = r21;
        r2 = r0.mUrl;
        r0 = r20;
        r1 = r16;
        r0.a(r2, r1);
        if (r15 == 0) goto L_0x0792;
    L_0x078f:
        r15.close();	 Catch:{ IOException -> 0x0798 }
    L_0x0792:
        if (r14 == 0) goto L_0x0797;
    L_0x0794:
        r14.close();	 Catch:{ IOException -> 0x07a6 }
    L_0x0797:
        throw r13;
    L_0x0798:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0792;
    L_0x07a6:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0797;
    L_0x07b4:
        r2 = move-exception;
        r10 = r11;
        r16 = r13;
        r13 = r2;
        goto L_0x0765;
    L_0x07ba:
        r2 = move-exception;
        r10 = r11;
        r14 = r3;
        r16 = r13;
        r13 = r2;
        goto L_0x0765;
    L_0x07c1:
        r2 = move-exception;
        r16 = r13;
        r13 = r2;
        goto L_0x0765;
    L_0x07c6:
        r2 = move-exception;
        r12 = r8;
        r16 = r13;
        r13 = r2;
        goto L_0x0765;
    L_0x07cc:
        r2 = move-exception;
        r10 = r13;
        r12 = r11;
        r13 = r2;
        goto L_0x0765;
    L_0x07d1:
        r2 = move-exception;
        r10 = r13;
        r13 = r2;
        goto L_0x0765;
    L_0x07d5:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
        goto L_0x06cc;
    L_0x07db:
        r2 = move-exception;
        r14 = r3;
        r16 = r13;
        r13 = r11;
        goto L_0x06cc;
    L_0x07e2:
        r2 = move-exception;
        r16 = r13;
        r13 = r10;
        goto L_0x06cc;
    L_0x07e8:
        r2 = move-exception;
        r12 = r8;
        r16 = r13;
        r13 = r10;
        goto L_0x06cc;
    L_0x07ef:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
        goto L_0x0634;
    L_0x07f5:
        r2 = move-exception;
        r14 = r3;
        r16 = r13;
        r13 = r11;
        goto L_0x0634;
    L_0x07fc:
        r2 = move-exception;
        r16 = r13;
        r13 = r10;
        goto L_0x0634;
    L_0x0802:
        r2 = move-exception;
        r12 = r8;
        r16 = r13;
        r13 = r10;
        goto L_0x0634;
    L_0x0809:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
        goto L_0x05ad;
    L_0x080f:
        r2 = move-exception;
        r14 = r3;
        r16 = r13;
        r13 = r11;
        goto L_0x05ad;
    L_0x0816:
        r2 = move-exception;
        r16 = r13;
        r13 = r10;
        goto L_0x05ad;
    L_0x081c:
        r2 = move-exception;
        r12 = r8;
        r16 = r13;
        r13 = r10;
        goto L_0x05ad;
    L_0x0823:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
        goto L_0x0526;
    L_0x0829:
        r2 = move-exception;
        r14 = r3;
        r16 = r13;
        r13 = r11;
        goto L_0x0526;
    L_0x0830:
        r2 = move-exception;
        r16 = r13;
        r13 = r10;
        goto L_0x0526;
    L_0x0836:
        r2 = move-exception;
        r12 = r8;
        r16 = r13;
        r13 = r10;
        goto L_0x0526;
    L_0x083d:
        r2 = move-exception;
        r16 = r13;
        r13 = r11;
        r11 = r12;
        goto L_0x01b1;
    L_0x0844:
        r2 = move-exception;
        r14 = r3;
        r16 = r13;
        r13 = r11;
        r11 = r12;
        goto L_0x01b1;
    L_0x084c:
        r2 = move-exception;
        r11 = r8;
        r16 = r13;
        r13 = r10;
        goto L_0x01b1;
    L_0x0853:
        r8 = r12;
        r2 = r3;
        goto L_0x04b8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.f.c.a(com.tencent.mm.plugin.appbrand.f.d):void");
    }

    public final void a(String str, HttpURLConnection httpURLConnection) {
        pP(str);
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    private static boolean pT(String str) {
        return str.equalsIgnoreCase("POST") || str.equalsIgnoreCase("PUT") || str.equalsIgnoreCase("DELETE");
    }

    public final void a(int i, JSONObject jSONObject, Map<String, String> map, ArrayList<String> arrayList, a aVar, String str, String str2) {
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        String optString2 = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
        String optString3 = jSONObject.optString("method");
        if (bg.mA(optString3)) {
            optString3 = "GET";
        }
        if (TextUtils.isEmpty(optString)) {
            aVar.aX("fail", "url is null");
        } else if (URLUtil.isHttpsUrl(optString) || URLUtil.isHttpUrl(optString)) {
            byte[] bArr = new byte[0];
            if (optString2 != null && pT(optString3)) {
                bArr = optString2.getBytes(Charset.forName("UTF-8"));
            }
            if (this.jaZ.size() >= this.jaQ) {
                aVar.aX("fail", "max connected");
                w.i("MicroMsg.AppBrandNetworkRequest", "max connected");
                return;
            }
            w.i("MicroMsg.AppBrandNetworkRequest", "method %s ,url %s timeout %s", new Object[]{optString3, optString, Integer.valueOf(i)});
            final d dVar = new d(optString, bArr, i, aVar, optString3);
            dVar.jbg = map;
            dVar.jbh = arrayList;
            dVar.jbk = str2;
            synchronized (this.jaZ) {
                this.jaZ.add(dVar);
            }
            dVar.iKz = str;
            e.post(new Runnable(this) {
                final /* synthetic */ c jbb;

                public final void run() {
                    this.jbb.a(dVar);
                }
            }, "appbrand_request_thread");
        } else {
            aVar.aX("fail", "request protocol must be http or https");
        }
    }

    private synchronized void pP(String str) {
        if (str != null) {
            Collection arrayList = new ArrayList();
            synchronized (this.jaZ) {
                Iterator it = this.jaZ.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (dVar.mUrl.equals(str)) {
                        arrayList.add(dVar);
                    }
                }
                if (arrayList.size() > 0) {
                    this.jaZ.removeAll(arrayList);
                }
            }
        }
    }

    private static JSONObject b(HttpURLConnection httpURLConnection) {
        JSONObject jSONObject = new JSONObject();
        if (httpURLConnection == null) {
            return jSONObject;
        }
        Map headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null) {
            return jSONObject;
        }
        for (Entry entry : headerFields.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (!(bg.mA(str) || list == null || list.isEmpty())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String) list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    stringBuilder.append(",");
                    stringBuilder.append((String) list.get(i));
                }
                try {
                    jSONObject.put(str, stringBuilder.toString());
                } catch (Throwable e) {
                    w.e("MicroMsg.AppBrandNetworkRequest", "put header error : %s", new Object[]{Log.getStackTraceString(e)});
                }
            }
        }
        return jSONObject;
    }

    public final d pU(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.jaZ) {
            Iterator it = this.jaZ.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (str.equals(dVar.iKz)) {
                    return dVar;
                }
            }
            return null;
        }
    }
}
