package com.tencent.mm.plugin.appbrand.f;

import android.text.TextUtils;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.w;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class f {
    public String ivH;
    private int jaQ;
    public SSLContext jaS;
    private final ArrayList<g> jbm = new ArrayList();

    public interface a {
        void b(int i, String str, int i2);

        void c(int i, long j, long j2);

        void py(String str);
    }

    public class b implements Runnable {
        private g jbn;
        final /* synthetic */ f jbo;

        public b(f fVar, g gVar) {
            this.jbo = fVar;
            this.jbn = gVar;
        }

        public final void run() {
            a(this.jbn);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(com.tencent.mm.plugin.appbrand.f.g r40) {
            /*
            r39 = this;
            r0 = r39;
            r4 = r0.jbo;
            r4 = r4.ivH;
            r25 = com.tencent.mm.plugin.appbrand.a.mV(r4);
            r0 = r40;
            r0 = r0.mUrl;
            r26 = r0;
            r0 = r40;
            r0 = r0.jbp;
            r27 = r0;
            r0 = r40;
            r0 = r0.mName;
            r28 = r0;
            r0 = r40;
            r0 = r0.mMimeType;
            r18 = r0;
            r6 = new java.lang.StringBuilder;
            r4 = "wx-file.";
            r6.<init>(r4);
            r5 = com.tencent.mm.pluginsdk.ui.tools.s.MB(r18);
            r4 = "dat";
            r7 = com.tencent.mm.sdk.platformtools.bg.mA(r5);
            if (r7 == 0) goto L_0x009d;
        L_0x0037:
            r4 = r6.append(r4);
            r29 = r4.toString();
            r0 = r40;
            r0 = r0.jbq;
            r30 = r0;
            r0 = r40;
            r0 = r0.jbg;
            r31 = r0;
            r22 = 0;
            r23 = 0;
            r19 = 0;
            r20 = 0;
            r0 = r40;
            r4 = r0.jbr;
            r0 = r40;
            r0 = r0.jbh;
            r32 = r0;
            if (r32 == 0) goto L_0x009f;
        L_0x005f:
            r0 = r32;
            r1 = r26;
            r5 = com.tencent.mm.plugin.appbrand.f.i.b(r0, r1);
            if (r5 != 0) goto L_0x009f;
        L_0x0069:
            r5 = "fail:url not in domain list";
            r4.py(r5);
            r0 = r39;
            r4 = r0.jbo;
            r4 = r4.ivH;
            r0 = r40;
            r5 = r0.jbk;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r8 = 0;
            r10 = 0;
            r12 = 0;
            r13 = 2;
            r14 = r40.Vn();
            com.tencent.mm.plugin.appbrand.report.a.e.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = "MicroMsg.AppBrandNetworkUpload";
            r5 = "not in domain url %s";
            r6 = 1;
            r6 = new java.lang.Object[r6];
            r7 = 0;
            r6[r7] = r26;
            com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        L_0x009c:
            return;
        L_0x009d:
            r4 = r5;
            goto L_0x0037;
        L_0x009f:
            r15 = 0;
            r17 = 0;
            r14 = 0;
            r13 = 0;
            r0 = r40;
            r5 = r0.aJi;
            if (r5 != 0) goto L_0x00d8;
        L_0x00aa:
            r5 = "force_stop!";
            r4.py(r5);
            r0 = r39;
            r4 = r0.jbo;
            r4 = r4.ivH;
            r0 = r40;
            r5 = r0.jbk;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r8 = 0;
            r10 = 0;
            r12 = 0;
            r13 = 2;
            r14 = r40.Vn();
            com.tencent.mm.plugin.appbrand.report.a.e.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = "MicroMsg.AppBrandNetworkUpload";
            r5 = "force stop!";
            com.tencent.mm.sdk.platformtools.w.e(r4, r5);
            goto L_0x009c;
        L_0x00d8:
            r0 = r40;
            r5 = r0.mUrl;
            r5 = android.webkit.URLUtil.isHttpsUrl(r5);
            if (r5 != 0) goto L_0x0111;
        L_0x00e2:
            r0 = r40;
            r5 = r0.mUrl;
            r5 = android.webkit.URLUtil.isHttpUrl(r5);
            if (r5 != 0) goto L_0x0111;
        L_0x00ec:
            r5 = "uploadFile protocol must be http or https";
            r4.py(r5);
            r0 = r39;
            r4 = r0.jbo;
            r4 = r4.ivH;
            r0 = r40;
            r5 = r0.jbk;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r8 = 0;
            r10 = 0;
            r12 = 0;
            r13 = 2;
            r14 = r40.Vn();
            com.tencent.mm.plugin.appbrand.report.a.e.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            goto L_0x009c;
        L_0x0111:
            r33 = "--";
            r6 = java.lang.System.currentTimeMillis();
            r34 = java.lang.Long.toString(r6);
            r35 = "\r\n";
            r24 = "";
            r5 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ UnsupportedEncodingException -> 0x0e33, FileNotFoundException -> 0x0ded, SSLHandshakeException -> 0x0da7, SocketTimeoutException -> 0x0a73, Exception -> 0x0b3e, all -> 0x0c09 }
            r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
            r8 = 0;
            r10 = 1;
            r12 = 0;
            r5.a(r6, r8, r10, r12);	 Catch:{ UnsupportedEncodingException -> 0x0e33, FileNotFoundException -> 0x0ded, SSLHandshakeException -> 0x0da7, SocketTimeoutException -> 0x0a73, Exception -> 0x0b3e, all -> 0x0c09 }
            r7 = new java.io.File;	 Catch:{ UnsupportedEncodingException -> 0x0e33, FileNotFoundException -> 0x0ded, SSLHandshakeException -> 0x0da7, SocketTimeoutException -> 0x0a73, Exception -> 0x0b3e, all -> 0x0c09 }
            r0 = r27;
            r7.<init>(r0);	 Catch:{ UnsupportedEncodingException -> 0x0e33, FileNotFoundException -> 0x0ded, SSLHandshakeException -> 0x0da7, SocketTimeoutException -> 0x0a73, Exception -> 0x0b3e, all -> 0x0c09 }
            r16 = new java.io.FileInputStream;	 Catch:{ UnsupportedEncodingException -> 0x0e33, FileNotFoundException -> 0x0ded, SSLHandshakeException -> 0x0da7, SocketTimeoutException -> 0x0a73, Exception -> 0x0b3e, all -> 0x0c09 }
            r0 = r16;
            r0.<init>(r7);	 Catch:{ UnsupportedEncodingException -> 0x0e33, FileNotFoundException -> 0x0ded, SSLHandshakeException -> 0x0da7, SocketTimeoutException -> 0x0a73, Exception -> 0x0b3e, all -> 0x0c09 }
            r11 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x0e3e, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0ca8 }
            r0 = r26;
            r11.<init>(r0);	 Catch:{ UnsupportedEncodingException -> 0x0e3e, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0ca8 }
            r5 = r11.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x0e3e, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0ca8 }
            r0 = r5;
            r0 = (java.net.HttpURLConnection) r0;	 Catch:{ UnsupportedEncodingException -> 0x0e3e, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0ca8 }
            r15 = r0;
            r0 = r40;
            r5 = r0.iKz;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = com.tencent.mm.sdk.platformtools.bg.mA(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            if (r5 != 0) goto L_0x0159;
        L_0x0155:
            r0 = r40;
            r0.jbj = r15;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
        L_0x0159:
            r5 = r15 instanceof javax.net.ssl.HttpsURLConnection;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            if (r5 == 0) goto L_0x0193;
        L_0x015d:
            r0 = r39;
            r5 = r0.jbo;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = r5.jaS;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            if (r5 != 0) goto L_0x0175;
        L_0x0165:
            r0 = r39;
            r5 = r0.jbo;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r39;
            r6 = r0.jbo;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r6 = r6.ivH;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r6 = com.tencent.mm.plugin.appbrand.f.i.pZ(r6);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5.jaS = r6;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
        L_0x0175:
            r0 = r39;
            r5 = r0.jbo;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = r5.jaS;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            if (r5 == 0) goto L_0x0193;
        L_0x017d:
            r0 = r15;
            r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = r0;
            r0 = r39;
            r6 = r0.jbo;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r6 = r6.jaS;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r6 = r6.getSocketFactory();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5.setSSLSocketFactory(r6);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r32;
            com.tencent.mm.plugin.appbrand.f.i.a(r15, r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
        L_0x0193:
            r5 = 1;
            r15.setDoInput(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = 1;
            r15.setDoOutput(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = 0;
            r15.setUseCaches(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r40;
            r5 = r0.jbc;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r15.setConnectTimeout(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r40;
            r5 = r0.jbc;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r15.setReadTimeout(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = "POST";
            r15.setRequestMethod(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = "Connection";
            r6 = "Keep-Alive";
            r15.setRequestProperty(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = "Accept-Encoding";
            r6 = "gzip";
            r15.setRequestProperty(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "file path = %s, length = %d";
            r8 = 2;
            r8 = new java.lang.Object[r8];	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r9 = 0;
            r10 = r7.getAbsolutePath();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r8[r9] = r10;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r9 = 1;
            r12 = r7.length();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r10 = java.lang.Long.valueOf(r12);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r8[r9] = r10;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            com.tencent.mm.sdk.platformtools.w.i(r5, r6, r8);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = 0;
            r15.setInstanceFollowRedirects(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            if (r31 == 0) goto L_0x039b;
        L_0x01e9:
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "url %s : set header ";
            r8 = 1;
            r8 = new java.lang.Object[r8];	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r9 = 0;
            r8[r9] = r26;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            com.tencent.mm.sdk.platformtools.w.i(r5, r6, r8);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = r31.entrySet();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r8 = r5.iterator();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
        L_0x0200:
            r5 = r8.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            if (r5 == 0) goto L_0x039b;
        L_0x0206:
            r5 = r8.next();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r5;
            r0 = (java.util.Map.Entry) r0;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r6 = r0;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r9 = "set header for : url %s : key:%s ,value %s ";
            r10 = 3;
            r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r12 = 0;
            r10[r12] = r26;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r12 = 1;
            r13 = r6.getKey();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r10[r12] = r13;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r12 = 2;
            r13 = r6.getValue();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r10[r12] = r13;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            com.tencent.mm.sdk.platformtools.w.i(r5, r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = r6.getKey();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = (java.lang.String) r5;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = com.tencent.mm.sdk.platformtools.bg.mA(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            if (r5 != 0) goto L_0x0200;
        L_0x0237:
            r5 = r6.getValue();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = (java.lang.String) r5;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = com.tencent.mm.sdk.platformtools.bg.mA(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            if (r5 != 0) goto L_0x0200;
        L_0x0243:
            r5 = r6.getKey();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = (java.lang.String) r5;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = r5.toLowerCase();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r9 = "content-length";
            r5 = r5.contains(r9);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            if (r5 == 0) goto L_0x02f7;
        L_0x0256:
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "not allow to set Content-Length";
            com.tencent.mm.sdk.platformtools.w.e(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            goto L_0x0200;
        L_0x0260:
            r5 = move-exception;
            r13 = r5;
            r18 = r15;
            r15 = r16;
            r16 = r14;
            r14 = r22;
        L_0x026a:
            r5 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x0d03 }
            r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
            r8 = 1;
            r10 = 1;
            r12 = 0;
            r5.a(r6, r8, r10, r12);	 Catch:{ all -> 0x0d03 }
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "UnsupportEncodingException : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0d03 }
            r8 = 0;
            r9 = r13.toString();	 Catch:{ all -> 0x0d03 }
            r7[r8] = r9;	 Catch:{ all -> 0x0d03 }
            r8 = 1;
            r7[r8] = r26;	 Catch:{ all -> 0x0d03 }
            r8 = 2;
            r7[r8] = r27;	 Catch:{ all -> 0x0d03 }
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);	 Catch:{ all -> 0x0d03 }
            r5 = -1;
            r6 = "unsupported encoding";
            r0 = r19;
            r4.b(r5, r6, r0);	 Catch:{ all -> 0x0d03 }
            r0 = r39;
            r4 = r0.jbo;
            r4 = r4.ivH;
            r0 = r40;
            r5 = r0.jbk;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r10 = (long) r14;
            r13 = 2;
            r14 = r40.Vn();
            r8 = r20;
            r12 = r19;
            com.tencent.mm.plugin.appbrand.report.a.e.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.aJi = r4;
            r0 = r39;
            r4 = r0.jbo;
            r0 = r26;
            r1 = r28;
            r2 = r27;
            r3 = r18;
            r4.a(r0, r1, r2, r3);
            if (r15 == 0) goto L_0x02cf;
        L_0x02cc:
            r15.close();	 Catch:{ Exception -> 0x09cb }
        L_0x02cf:
            if (r16 == 0) goto L_0x02d4;
        L_0x02d1:
            r16.close();	 Catch:{ IOException -> 0x09e7 }
        L_0x02d4:
            if (r17 == 0) goto L_0x009c;
        L_0x02d6:
            r17.close();	 Catch:{ IOException -> 0x02db }
            goto L_0x009c;
        L_0x02db:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x009c;
        L_0x02f7:
            r5 = r6.getKey();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = (java.lang.String) r5;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r6 = r6.getValue();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r6 = (java.lang.String) r6;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r15.setRequestProperty(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            goto L_0x0200;
        L_0x0308:
            r5 = move-exception;
            r13 = r5;
            r18 = r17;
            r17 = r14;
        L_0x030e:
            r5 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x0d15 }
            r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
            r8 = 3;
            r10 = 1;
            r12 = 0;
            r5.a(r6, r8, r10, r12);	 Catch:{ all -> 0x0d15 }
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "FileNotFoundException : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0d15 }
            r8 = 0;
            r9 = r13.toString();	 Catch:{ all -> 0x0d15 }
            r7[r8] = r9;	 Catch:{ all -> 0x0d15 }
            r8 = 1;
            r7[r8] = r26;	 Catch:{ all -> 0x0d15 }
            r8 = 2;
            r7[r8] = r27;	 Catch:{ all -> 0x0d15 }
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);	 Catch:{ all -> 0x0d15 }
            r5 = -1;
            r6 = "file not exist";
            r0 = r19;
            r4.b(r5, r6, r0);	 Catch:{ all -> 0x0d15 }
            r0 = r39;
            r4 = r0.jbo;
            r4 = r4.ivH;
            r0 = r40;
            r5 = r0.jbk;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r0 = r22;
            r10 = (long) r0;
            r13 = 2;
            r14 = r40.Vn();
            r8 = r20;
            r12 = r19;
            com.tencent.mm.plugin.appbrand.report.a.e.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.aJi = r4;
            r0 = r39;
            r4 = r0.jbo;
            r0 = r26;
            r1 = r28;
            r2 = r27;
            r4.a(r0, r1, r2, r15);
            if (r16 == 0) goto L_0x0373;
        L_0x0370:
            r16.close();	 Catch:{ Exception -> 0x0a03 }
        L_0x0373:
            if (r17 == 0) goto L_0x0378;
        L_0x0375:
            r17.close();	 Catch:{ IOException -> 0x0a1f }
        L_0x0378:
            if (r18 == 0) goto L_0x009c;
        L_0x037a:
            r18.close();	 Catch:{ IOException -> 0x037f }
            goto L_0x009c;
        L_0x037f:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x009c;
        L_0x039b:
            r5 = "User-Agent";
            r6 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r8 = "";
            r6 = com.tencent.mm.pluginsdk.ui.tools.s.aZ(r6, r8);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r15.setRequestProperty(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r8 = r7.length();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r10 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r10.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r12 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r12.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            if (r30 == 0) goto L_0x0590;
        L_0x03bc:
            r5 = "Content-Type";
            r6 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r13 = "multipart/form-data; boundary=";
            r6.<init>(r13);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r34;
            r6 = r6.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r6 = r6.toString();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r15.setRequestProperty(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = r30.keySet();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r13 = r5.iterator();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
        L_0x03dc:
            r5 = r13.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            if (r5 == 0) goto L_0x04fa;
        L_0x03e2:
            r5 = r13.next();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = (java.lang.String) r5;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r30;
            r6 = r0.get(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r6 = (java.lang.String) r6;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r31 = "MicroMsg.AppBrandNetworkUpload";
            r32 = "append form data: key = %s, value = %s";
            r36 = 2;
            r0 = r36;
            r0 = new java.lang.Object[r0];	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r36 = r0;
            r37 = 0;
            r36[r37] = r5;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r37 = 1;
            r36[r37] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r31;
            r1 = r32;
            r2 = r36;
            com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r31 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r31.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r31;
            r1 = r33;
            r31 = r0.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r31;
            r1 = r34;
            r31 = r0.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r31;
            r1 = r35;
            r31 = r0.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r31 = r31.toString();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r31;
            r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r31 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r32 = "Content-Disposition: form-data; name=\"";
            r31.<init>(r32);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r31;
            r5 = r0.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r31 = "\"";
            r0 = r31;
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r10.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r35;
            r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r35;
            r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r10.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r35;
            r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            goto L_0x03dc;
        L_0x0467:
            r5 = move-exception;
            r13 = r5;
            r18 = r17;
            r17 = r14;
        L_0x046d:
            r5 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x0d15 }
            r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
            r8 = 2;
            r10 = 1;
            r12 = 0;
            r5.a(r6, r8, r10, r12);	 Catch:{ all -> 0x0d15 }
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "SSLHandshakeException : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0d15 }
            r8 = 0;
            r9 = r13.toString();	 Catch:{ all -> 0x0d15 }
            r7[r8] = r9;	 Catch:{ all -> 0x0d15 }
            r8 = 1;
            r7[r8] = r26;	 Catch:{ all -> 0x0d15 }
            r8 = 2;
            r7[r8] = r27;	 Catch:{ all -> 0x0d15 }
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);	 Catch:{ all -> 0x0d15 }
            r5 = -1;
            r6 = "ssl hand shake error";
            r0 = r19;
            r4.b(r5, r6, r0);	 Catch:{ all -> 0x0d15 }
            r0 = r39;
            r4 = r0.jbo;
            r4 = r4.ivH;
            r0 = r40;
            r5 = r0.jbk;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r0 = r22;
            r10 = (long) r0;
            r13 = 2;
            r14 = r40.Vn();
            r8 = r20;
            r12 = r19;
            com.tencent.mm.plugin.appbrand.report.a.e.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.aJi = r4;
            r0 = r39;
            r4 = r0.jbo;
            r0 = r26;
            r1 = r28;
            r2 = r27;
            r4.a(r0, r1, r2, r15);
            if (r16 == 0) goto L_0x04d2;
        L_0x04cf:
            r16.close();	 Catch:{ Exception -> 0x0a3b }
        L_0x04d2:
            if (r17 == 0) goto L_0x04d7;
        L_0x04d4:
            r17.close();	 Catch:{ IOException -> 0x0a57 }
        L_0x04d7:
            if (r18 == 0) goto L_0x009c;
        L_0x04d9:
            r18.close();	 Catch:{ IOException -> 0x04de }
            goto L_0x009c;
        L_0x04de:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x009c;
        L_0x04fa:
            r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r33;
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r34;
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r35;
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r10.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r6 = "Content-Disposition: form-data; name=\"";
            r5.<init>(r6);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r28;
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r6 = "\"; filename=\"";
            r5 = r5.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r29;
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r6 = "\"";
            r5 = r5.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r35;
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r10.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r6 = "Content-Type: ";
            r5.<init>(r6);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r18;
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r10.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r35;
            r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r35;
            r10.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r35;
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r33;
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r34;
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r33;
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r35;
            r5 = r5.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r12.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
        L_0x0590:
            r5 = r10.toString();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r6 = "UTF-8";
            r6 = r5.getBytes(r6);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = r12.toString();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r10 = "UTF-8";
            r5 = r5.getBytes(r10);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            if (r6 != 0) goto L_0x05ab;
        L_0x05a8:
            r6 = 0;
            r6 = new byte[r6];	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
        L_0x05ab:
            if (r5 != 0) goto L_0x0eb9;
        L_0x05ad:
            r5 = 0;
            r5 = new byte[r5];	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r10 = r5;
        L_0x05b1:
            r5 = r6.length;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r12 = (long) r5;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r8 = r8 + r12;
            r5 = r10.length;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r12 = (long) r5;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r8 = r8 + r12;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r12 = "contentLenght = %d";
            r13 = 1;
            r13 = new java.lang.Object[r13];	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r18 = 0;
            r29 = java.lang.Long.valueOf(r8);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r13[r18] = r29;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            com.tencent.mm.sdk.platformtools.w.i(r5, r12, r13);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = "Content-Length";
            r8 = java.lang.String.valueOf(r8);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r15.setRequestProperty(r5, r8);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r18 = new java.io.DataOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r5 = r15.getOutputStream();	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r18;
            r0.<init>(r5);	 Catch:{ UnsupportedEncodingException -> 0x0260, FileNotFoundException -> 0x0308, SSLHandshakeException -> 0x0467, SocketTimeoutException -> 0x0d63, Exception -> 0x0d1f, all -> 0x0cb6 }
            r0 = r18;
            r0.write(r6);	 Catch:{ UnsupportedEncodingException -> 0x0e4a, FileNotFoundException -> 0x0df7, SSLHandshakeException -> 0x0db1, SocketTimeoutException -> 0x0d6b, Exception -> 0x0d27, all -> 0x0cc4 }
            r5 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
            r12 = new byte[r5];	 Catch:{ UnsupportedEncodingException -> 0x0e4a, FileNotFoundException -> 0x0df7, SSLHandshakeException -> 0x0db1, SocketTimeoutException -> 0x0d6b, Exception -> 0x0d27, all -> 0x0cc4 }
            r30 = r7.length();	 Catch:{ UnsupportedEncodingException -> 0x0e4a, FileNotFoundException -> 0x0df7, SSLHandshakeException -> 0x0db1, SocketTimeoutException -> 0x0d6b, Exception -> 0x0d27, all -> 0x0cc4 }
            r8 = r20;
        L_0x05ef:
            r0 = r16;
            r5 = r0.read(r12);	 Catch:{ UnsupportedEncodingException -> 0x0e58, FileNotFoundException -> 0x0dfd, SSLHandshakeException -> 0x0db7, SocketTimeoutException -> 0x0d71, Exception -> 0x0d2d, all -> 0x0cd0 }
            r6 = -1;
            if (r5 == r6) goto L_0x06bd;
        L_0x05f8:
            r0 = r40;
            r6 = r0.aJi;	 Catch:{ UnsupportedEncodingException -> 0x0e58, FileNotFoundException -> 0x0dfd, SSLHandshakeException -> 0x0db7, SocketTimeoutException -> 0x0d71, Exception -> 0x0d2d, all -> 0x0cd0 }
            if (r6 == 0) goto L_0x06bd;
        L_0x05fe:
            r6 = r25.Pn();	 Catch:{ UnsupportedEncodingException -> 0x0e58, FileNotFoundException -> 0x0dfd, SSLHandshakeException -> 0x0db7, SocketTimeoutException -> 0x0d71, Exception -> 0x0d2d, all -> 0x0cd0 }
            if (r6 == 0) goto L_0x0677;
        L_0x0604:
            r5 = "interrupted";
            r4.py(r5);	 Catch:{ UnsupportedEncodingException -> 0x0e58, FileNotFoundException -> 0x0dfd, SSLHandshakeException -> 0x0db7, SocketTimeoutException -> 0x0d71, Exception -> 0x0d2d, all -> 0x0cd0 }
            r0 = r39;
            r4 = r0.jbo;
            r4 = r4.ivH;
            r0 = r40;
            r5 = r0.jbk;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r10 = 0;
            r12 = 0;
            r13 = 2;
            r14 = r40.Vn();
            com.tencent.mm.plugin.appbrand.report.a.e.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.aJi = r4;
            r0 = r39;
            r4 = r0.jbo;
            r0 = r26;
            r1 = r28;
            r2 = r27;
            r4.a(r0, r1, r2, r15);
            r16.close();	 Catch:{ Exception -> 0x065c }
        L_0x063b:
            r18.close();	 Catch:{ IOException -> 0x0640 }
            goto L_0x009c;
        L_0x0640:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x009c;
        L_0x065c:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x063b;
        L_0x0677:
            r6 = 0;
            r0 = r18;
            r0.write(r12, r6, r5);	 Catch:{ UnsupportedEncodingException -> 0x0e58, FileNotFoundException -> 0x0dfd, SSLHandshakeException -> 0x0db7, SocketTimeoutException -> 0x0d71, Exception -> 0x0d2d, all -> 0x0cd0 }
            r6 = (long) r5;
            r6 = r6 + r8;
            r8 = 0;
            r5 = (r30 > r8 ? 1 : (r30 == r8 ? 0 : -1));
            if (r5 <= 0) goto L_0x0eb6;
        L_0x0685:
            r0 = r40;
            r5 = r0.aJi;	 Catch:{ UnsupportedEncodingException -> 0x0e68, FileNotFoundException -> 0x0e05, SSLHandshakeException -> 0x0dbf, SocketTimeoutException -> 0x0d79, Exception -> 0x0d35, all -> 0x0cda }
            if (r5 == 0) goto L_0x0eb6;
        L_0x068b:
            r8 = 100;
            r8 = r8 * r6;
            r8 = r8 / r30;
            r5 = (int) r8;	 Catch:{ UnsupportedEncodingException -> 0x0e68, FileNotFoundException -> 0x0e05, SSLHandshakeException -> 0x0dbf, SocketTimeoutException -> 0x0d79, Exception -> 0x0d35, all -> 0x0cda }
            r8 = r30;
            r4.c(r5, r6, r8);	 Catch:{ UnsupportedEncodingException -> 0x0e68, FileNotFoundException -> 0x0e05, SSLHandshakeException -> 0x0dbf, SocketTimeoutException -> 0x0d79, Exception -> 0x0d35, all -> 0x0cda }
            r8 = "MicroMsg.AppBrandNetworkUpload";
            r9 = "uploadSize %d, totalSize %d, percent = %d";
            r13 = 3;
            r13 = new java.lang.Object[r13];	 Catch:{ UnsupportedEncodingException -> 0x0e68, FileNotFoundException -> 0x0e05, SSLHandshakeException -> 0x0dbf, SocketTimeoutException -> 0x0d79, Exception -> 0x0d35, all -> 0x0cda }
            r17 = 0;
            r20 = java.lang.Long.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x0e68, FileNotFoundException -> 0x0e05, SSLHandshakeException -> 0x0dbf, SocketTimeoutException -> 0x0d79, Exception -> 0x0d35, all -> 0x0cda }
            r13[r17] = r20;	 Catch:{ UnsupportedEncodingException -> 0x0e68, FileNotFoundException -> 0x0e05, SSLHandshakeException -> 0x0dbf, SocketTimeoutException -> 0x0d79, Exception -> 0x0d35, all -> 0x0cda }
            r17 = 1;
            r20 = java.lang.Long.valueOf(r30);	 Catch:{ UnsupportedEncodingException -> 0x0e68, FileNotFoundException -> 0x0e05, SSLHandshakeException -> 0x0dbf, SocketTimeoutException -> 0x0d79, Exception -> 0x0d35, all -> 0x0cda }
            r13[r17] = r20;	 Catch:{ UnsupportedEncodingException -> 0x0e68, FileNotFoundException -> 0x0e05, SSLHandshakeException -> 0x0dbf, SocketTimeoutException -> 0x0d79, Exception -> 0x0d35, all -> 0x0cda }
            r17 = 2;
            r5 = java.lang.Integer.valueOf(r5);	 Catch:{ UnsupportedEncodingException -> 0x0e68, FileNotFoundException -> 0x0e05, SSLHandshakeException -> 0x0dbf, SocketTimeoutException -> 0x0d79, Exception -> 0x0d35, all -> 0x0cda }
            r13[r17] = r5;	 Catch:{ UnsupportedEncodingException -> 0x0e68, FileNotFoundException -> 0x0e05, SSLHandshakeException -> 0x0dbf, SocketTimeoutException -> 0x0d79, Exception -> 0x0d35, all -> 0x0cda }
            com.tencent.mm.sdk.platformtools.w.v(r8, r9, r13);	 Catch:{ UnsupportedEncodingException -> 0x0e68, FileNotFoundException -> 0x0e05, SSLHandshakeException -> 0x0dbf, SocketTimeoutException -> 0x0d79, Exception -> 0x0d35, all -> 0x0cda }
            r8 = r6;
            goto L_0x05ef;
        L_0x06bd:
            r0 = r18;
            r0.write(r10);	 Catch:{ UnsupportedEncodingException -> 0x0e58, FileNotFoundException -> 0x0dfd, SSLHandshakeException -> 0x0db7, SocketTimeoutException -> 0x0d71, Exception -> 0x0d2d, all -> 0x0cd0 }
            r18.flush();	 Catch:{ UnsupportedEncodingException -> 0x0e58, FileNotFoundException -> 0x0dfd, SSLHandshakeException -> 0x0db7, SocketTimeoutException -> 0x0d71, Exception -> 0x0d2d, all -> 0x0cd0 }
            r12 = r15.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x0e58, FileNotFoundException -> 0x0dfd, SSLHandshakeException -> 0x0db7, SocketTimeoutException -> 0x0d71, Exception -> 0x0d2d, all -> 0x0cd0 }
            r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r5 == r12) goto L_0x0820;
        L_0x06cd:
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "code %d  url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r10 = 0;
            r13 = r15.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r13 = java.lang.Integer.valueOf(r13);	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r7[r10] = r13;	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r10 = 1;
            r7[r10] = r26;	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r10 = 2;
            r7[r10] = r27;	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r5 = com.tencent.mm.plugin.appbrand.f.i.ia(r12);	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            if (r5 == 0) goto L_0x0820;
        L_0x06f0:
            r5 = com.tencent.mm.plugin.appbrand.f.i.c(r15);	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r0 = r40;
            r6 = r0.jbi;	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r7 = android.text.TextUtils.isEmpty(r5);	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            if (r7 != 0) goto L_0x0820;
        L_0x06fe:
            if (r6 > 0) goto L_0x0788;
        L_0x0700:
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "reach the max redirect count(%d)";
            r7 = 1;
            r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r10 = 0;
            r11 = 15;
            r11 = java.lang.Integer.valueOf(r11);	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r7[r10] = r11;	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            com.tencent.mm.sdk.platformtools.w.w(r5, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r5 = 0;
            r6 = "reach the max redirect count 15";
            r4.b(r5, r6, r12);	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r0 = r39;
            r4 = r0.jbo;
            r4 = r4.ivH;
            r0 = r40;
            r5 = r0.jbk;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r10 = 0;
            r13 = 1;
            r14 = r40.Vn();
            com.tencent.mm.plugin.appbrand.report.a.e.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.aJi = r4;
            r0 = r39;
            r4 = r0.jbo;
            r0 = r26;
            r1 = r28;
            r2 = r27;
            r4.a(r0, r1, r2, r15);
            r16.close();	 Catch:{ Exception -> 0x076d }
        L_0x074c:
            r18.close();	 Catch:{ IOException -> 0x0751 }
            goto L_0x009c;
        L_0x0751:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x009c;
        L_0x076d:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x074c;
        L_0x0788:
            r7 = "MicroMsg.AppBrandNetworkUpload";
            r10 = "redirect(%d) URL(%s) to URL(%s)";
            r11 = 3;
            r11 = new java.lang.Object[r11];	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r13 = 0;
            r17 = java.lang.Integer.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r11[r13] = r17;	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r13 = 1;
            r0 = r40;
            r0 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r17 = r0;
            r11[r13] = r17;	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r13 = 2;
            r11[r13] = r5;	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            com.tencent.mm.sdk.platformtools.w.i(r7, r10, r11);	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r0 = r40;
            r0.mUrl = r5;	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r5 = r6 + -1;
            r0 = r40;
            r0.jbi = r5;	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r39.a(r40);	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r0 = r39;
            r4 = r0.jbo;
            r4 = r4.ivH;
            r0 = r40;
            r5 = r0.jbk;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r10 = 0;
            r13 = 2;
            r14 = r40.Vn();
            com.tencent.mm.plugin.appbrand.report.a.e.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.aJi = r4;
            r0 = r39;
            r4 = r0.jbo;
            r0 = r26;
            r1 = r28;
            r2 = r27;
            r4.a(r0, r1, r2, r15);
            r16.close();	 Catch:{ Exception -> 0x0805 }
        L_0x07e4:
            r18.close();	 Catch:{ IOException -> 0x07e9 }
            goto L_0x009c;
        L_0x07e9:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x009c;
        L_0x0805:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x07e4;
        L_0x0820:
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "url %s ,start to read response ";
            r7 = 1;
            r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r10 = 0;
            r7[r10] = r26;	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            com.tencent.mm.sdk.platformtools.w.i(r5, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r5 = "gzip";
            r6 = r15.getContentEncoding();	 Catch:{ Exception -> 0x0883, UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, all -> 0x0ce5 }
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x0883, UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, all -> 0x0ce5 }
            if (r5 == 0) goto L_0x087e;
        L_0x083c:
            r17 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x0883, UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, all -> 0x0ce5 }
            r5 = r15.getInputStream();	 Catch:{ Exception -> 0x0883, UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, all -> 0x0ce5 }
            r0 = r17;
            r0.<init>(r5);	 Catch:{ Exception -> 0x0883, UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, all -> 0x0ce5 }
        L_0x0847:
            if (r17 == 0) goto L_0x0eb0;
        L_0x0849:
            r5 = new java.io.BufferedReader;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x0e17, SSLHandshakeException -> 0x0dd1, SocketTimeoutException -> 0x0d8b, Exception -> 0x0d47, all -> 0x0ced }
            r6 = new java.io.InputStreamReader;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x0e17, SSLHandshakeException -> 0x0dd1, SocketTimeoutException -> 0x0d8b, Exception -> 0x0d47, all -> 0x0ced }
            r0 = r17;
            r6.<init>(r0);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x0e17, SSLHandshakeException -> 0x0dd1, SocketTimeoutException -> 0x0d8b, Exception -> 0x0d47, all -> 0x0ced }
            r5.<init>(r6);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x0e17, SSLHandshakeException -> 0x0dd1, SocketTimeoutException -> 0x0d8b, Exception -> 0x0d47, all -> 0x0ced }
            r6 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x0e17, SSLHandshakeException -> 0x0dd1, SocketTimeoutException -> 0x0d8b, Exception -> 0x0d47, all -> 0x0ced }
            r6.<init>();	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x0e17, SSLHandshakeException -> 0x0dd1, SocketTimeoutException -> 0x0d8b, Exception -> 0x0d47, all -> 0x0ced }
        L_0x085a:
            r7 = r5.readLine();	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x0e17, SSLHandshakeException -> 0x0dd1, SocketTimeoutException -> 0x0d8b, Exception -> 0x0d47, all -> 0x0ced }
            if (r7 == 0) goto L_0x08c8;
        L_0x0860:
            r0 = r40;
            r10 = r0.aJi;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x0e17, SSLHandshakeException -> 0x0dd1, SocketTimeoutException -> 0x0d8b, Exception -> 0x0d47, all -> 0x0ced }
            if (r10 == 0) goto L_0x08c8;
        L_0x0866:
            r6.append(r7);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x0e17, SSLHandshakeException -> 0x0dd1, SocketTimeoutException -> 0x0d8b, Exception -> 0x0d47, all -> 0x0ced }
            goto L_0x085a;
        L_0x086a:
            r5 = move-exception;
            r13 = r5;
            r20 = r8;
            r19 = r12;
            r14 = r22;
            r38 = r15;
            r15 = r16;
            r16 = r17;
            r17 = r18;
            r18 = r38;
            goto L_0x026a;
        L_0x087e:
            r17 = r15.getInputStream();	 Catch:{ Exception -> 0x0883, UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, all -> 0x0ce5 }
            goto L_0x0847;
        L_0x0883:
            r5 = move-exception;
            r6 = "MicroMsg.AppBrandNetworkUpload";
            r7 = "getInputStream error : %s";
            r10 = 1;
            r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r13 = 0;
            r10[r13] = r5;	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            com.tencent.mm.sdk.platformtools.w.e(r6, r7, r10);	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r5 = "gzip";
            r6 = r15.getContentEncoding();	 Catch:{ Exception -> 0x08ac, UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, all -> 0x0ce5 }
            r5 = r5.equals(r6);	 Catch:{ Exception -> 0x08ac, UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, all -> 0x0ce5 }
            if (r5 == 0) goto L_0x08c3;
        L_0x08a0:
            r17 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x08ac, UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, all -> 0x0ce5 }
            r5 = r15.getErrorStream();	 Catch:{ Exception -> 0x08ac, UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, all -> 0x0ce5 }
            r0 = r17;
            r0.<init>(r5);	 Catch:{ Exception -> 0x08ac, UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, all -> 0x0ce5 }
            goto L_0x0847;
        L_0x08ac:
            r5 = move-exception;
            r6 = "MicroMsg.AppBrandNetworkUpload";
            r7 = "read err stream failed : %s";
            r10 = 1;
            r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r13 = 0;
            r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r10[r13] = r5;	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            com.tencent.mm.sdk.platformtools.w.e(r6, r7, r10);	 Catch:{ UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, Exception -> 0x0d3d, all -> 0x0ce5 }
            r17 = r14;
            goto L_0x0847;
        L_0x08c3:
            r17 = r15.getErrorStream();	 Catch:{ Exception -> 0x08ac, UnsupportedEncodingException -> 0x0e78, FileNotFoundException -> 0x0e0d, SSLHandshakeException -> 0x0dc7, SocketTimeoutException -> 0x0d81, all -> 0x0ce5 }
            goto L_0x0847;
        L_0x08c8:
            r5 = r6.toString();	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x0e17, SSLHandshakeException -> 0x0dd1, SocketTimeoutException -> 0x0d8b, Exception -> 0x0d47, all -> 0x0ced }
            r6 = "UTF-8";
            r6 = java.nio.charset.Charset.forName(r6);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x0e17, SSLHandshakeException -> 0x0dd1, SocketTimeoutException -> 0x0d8b, Exception -> 0x0d47, all -> 0x0ced }
            r6 = r5.getBytes(r6);	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x0e17, SSLHandshakeException -> 0x0dd1, SocketTimeoutException -> 0x0d8b, Exception -> 0x0d47, all -> 0x0ced }
            r6 = r6.length;	 Catch:{ UnsupportedEncodingException -> 0x086a, FileNotFoundException -> 0x0e17, SSLHandshakeException -> 0x0dd1, SocketTimeoutException -> 0x0d8b, Exception -> 0x0d47, all -> 0x0ced }
            r7 = "MicroMsg.AppBrandNetworkUpload";
            r10 = "upload for url : %s, result = %s, statecode = %s";
            r13 = 3;
            r13 = new java.lang.Object[r13];	 Catch:{ UnsupportedEncodingException -> 0x0e8a, FileNotFoundException -> 0x0e1f, SSLHandshakeException -> 0x0dd9, SocketTimeoutException -> 0x0d93, Exception -> 0x0d4f, all -> 0x0cf3 }
            r14 = 0;
            r13[r14] = r11;	 Catch:{ UnsupportedEncodingException -> 0x0e8a, FileNotFoundException -> 0x0e1f, SSLHandshakeException -> 0x0dd9, SocketTimeoutException -> 0x0d93, Exception -> 0x0d4f, all -> 0x0cf3 }
            r11 = 1;
            r13[r11] = r5;	 Catch:{ UnsupportedEncodingException -> 0x0e8a, FileNotFoundException -> 0x0e1f, SSLHandshakeException -> 0x0dd9, SocketTimeoutException -> 0x0d93, Exception -> 0x0d4f, all -> 0x0cf3 }
            r11 = 2;
            r14 = java.lang.Integer.valueOf(r12);	 Catch:{ UnsupportedEncodingException -> 0x0e8a, FileNotFoundException -> 0x0e1f, SSLHandshakeException -> 0x0dd9, SocketTimeoutException -> 0x0d93, Exception -> 0x0d4f, all -> 0x0cf3 }
            r13[r11] = r14;	 Catch:{ UnsupportedEncodingException -> 0x0e8a, FileNotFoundException -> 0x0e1f, SSLHandshakeException -> 0x0dd9, SocketTimeoutException -> 0x0d93, Exception -> 0x0d4f, all -> 0x0cf3 }
            com.tencent.mm.sdk.platformtools.w.i(r7, r10, r13);	 Catch:{ UnsupportedEncodingException -> 0x0e8a, FileNotFoundException -> 0x0e1f, SSLHandshakeException -> 0x0dd9, SocketTimeoutException -> 0x0d93, Exception -> 0x0d4f, all -> 0x0cf3 }
            r10 = r6;
        L_0x08f2:
            r0 = r40;
            r6 = r0.aJi;	 Catch:{ UnsupportedEncodingException -> 0x0e9d, FileNotFoundException -> 0x0e29, SSLHandshakeException -> 0x0de3, SocketTimeoutException -> 0x0d9d, Exception -> 0x0d59, all -> 0x0cfb }
            if (r6 == 0) goto L_0x0966;
        L_0x08f8:
            r6 = 0;
            r4.b(r6, r5, r12);	 Catch:{ UnsupportedEncodingException -> 0x0e9d, FileNotFoundException -> 0x0e29, SSLHandshakeException -> 0x0de3, SocketTimeoutException -> 0x0d9d, Exception -> 0x0d59, all -> 0x0cfb }
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "success : url = %s, filePath = %s";
            r7 = 2;
            r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x0e9d, FileNotFoundException -> 0x0e29, SSLHandshakeException -> 0x0de3, SocketTimeoutException -> 0x0d9d, Exception -> 0x0d59, all -> 0x0cfb }
            r11 = 0;
            r7[r11] = r26;	 Catch:{ UnsupportedEncodingException -> 0x0e9d, FileNotFoundException -> 0x0e29, SSLHandshakeException -> 0x0de3, SocketTimeoutException -> 0x0d9d, Exception -> 0x0d59, all -> 0x0cfb }
            r11 = 1;
            r7[r11] = r27;	 Catch:{ UnsupportedEncodingException -> 0x0e9d, FileNotFoundException -> 0x0e29, SSLHandshakeException -> 0x0de3, SocketTimeoutException -> 0x0d9d, Exception -> 0x0d59, all -> 0x0cfb }
            com.tencent.mm.sdk.platformtools.w.i(r5, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x0e9d, FileNotFoundException -> 0x0e29, SSLHandshakeException -> 0x0de3, SocketTimeoutException -> 0x0d9d, Exception -> 0x0d59, all -> 0x0cfb }
            r4 = 1;
        L_0x090f:
            if (r4 == 0) goto L_0x0979;
        L_0x0911:
            r0 = r39;
            r4 = r0.jbo;
            r4 = r4.ivH;
            r0 = r40;
            r5 = r0.jbk;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r10 = (long) r10;
            r13 = 1;
            r14 = r40.Vn();
            com.tencent.mm.plugin.appbrand.report.a.e.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
        L_0x092b:
            r4 = 0;
            r0 = r40;
            r0.aJi = r4;
            r0 = r39;
            r4 = r0.jbo;
            r0 = r26;
            r1 = r28;
            r2 = r27;
            r4.a(r0, r1, r2, r15);
            r16.close();	 Catch:{ Exception -> 0x0994 }
        L_0x0940:
            if (r17 == 0) goto L_0x0945;
        L_0x0942:
            r17.close();	 Catch:{ IOException -> 0x09af }
        L_0x0945:
            r18.close();	 Catch:{ IOException -> 0x094a }
            goto L_0x009c;
        L_0x094a:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x009c;
        L_0x0966:
            r5 = 0;
            r6 = "force_stop!";
            r4.b(r5, r6, r12);	 Catch:{ UnsupportedEncodingException -> 0x0e9d, FileNotFoundException -> 0x0e29, SSLHandshakeException -> 0x0de3, SocketTimeoutException -> 0x0d9d, Exception -> 0x0d59, all -> 0x0cfb }
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "force stop!";
            com.tencent.mm.sdk.platformtools.w.e(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0e9d, FileNotFoundException -> 0x0e29, SSLHandshakeException -> 0x0de3, SocketTimeoutException -> 0x0d9d, Exception -> 0x0d59, all -> 0x0cfb }
            r4 = r23;
            goto L_0x090f;
        L_0x0979:
            r0 = r39;
            r4 = r0.jbo;
            r4 = r4.ivH;
            r0 = r40;
            r5 = r0.jbk;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r10 = (long) r10;
            r13 = 2;
            r14 = r40.Vn();
            com.tencent.mm.plugin.appbrand.report.a.e.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            goto L_0x092b;
        L_0x0994:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x0940;
        L_0x09af:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s , url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x0945;
        L_0x09cb:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x02cf;
        L_0x09e7:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s , url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x02d4;
        L_0x0a03:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x0373;
        L_0x0a1f:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s , url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x0378;
        L_0x0a3b:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x04d2;
        L_0x0a57:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s , url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x04d7;
        L_0x0a73:
            r5 = move-exception;
            r16 = r13;
            r18 = r17;
            r17 = r14;
            r13 = r5;
        L_0x0a7b:
            r5 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x0d15 }
            r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
            r8 = 4;
            r10 = 1;
            r12 = 0;
            r5.a(r6, r8, r10, r12);	 Catch:{ all -> 0x0d15 }
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "SocketTimeoutException : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0d15 }
            r8 = 0;
            r9 = r13.toString();	 Catch:{ all -> 0x0d15 }
            r7[r8] = r9;	 Catch:{ all -> 0x0d15 }
            r8 = 1;
            r7[r8] = r26;	 Catch:{ all -> 0x0d15 }
            r8 = 2;
            r7[r8] = r27;	 Catch:{ all -> 0x0d15 }
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);	 Catch:{ all -> 0x0d15 }
            r5 = -1;
            r6 = "socket timeout error";
            r0 = r19;
            r4.b(r5, r6, r0);	 Catch:{ all -> 0x0d15 }
            r0 = r39;
            r4 = r0.jbo;
            r4 = r4.ivH;
            r0 = r40;
            r5 = r0.jbk;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r0 = r22;
            r10 = (long) r0;
            r13 = 2;
            r14 = r40.Vn();
            r8 = r20;
            r12 = r19;
            com.tencent.mm.plugin.appbrand.report.a.e.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.aJi = r4;
            r0 = r39;
            r4 = r0.jbo;
            r0 = r26;
            r1 = r28;
            r2 = r27;
            r4.a(r0, r1, r2, r15);
            if (r16 == 0) goto L_0x0ae0;
        L_0x0add:
            r16.close();	 Catch:{ Exception -> 0x0b08 }
        L_0x0ae0:
            if (r17 == 0) goto L_0x0ae5;
        L_0x0ae2:
            r17.close();	 Catch:{ IOException -> 0x0b23 }
        L_0x0ae5:
            if (r18 == 0) goto L_0x009c;
        L_0x0ae7:
            r18.close();	 Catch:{ IOException -> 0x0aec }
            goto L_0x009c;
        L_0x0aec:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x009c;
        L_0x0b08:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x0ae0;
        L_0x0b23:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s , url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x0ae5;
        L_0x0b3e:
            r5 = move-exception;
            r16 = r13;
            r18 = r17;
            r17 = r14;
            r13 = r5;
        L_0x0b46:
            r5 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x0d15 }
            r6 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
            r8 = 5;
            r10 = 1;
            r12 = 0;
            r5.a(r6, r8, r10, r12);	 Catch:{ all -> 0x0d15 }
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0d15 }
            r8 = 0;
            r9 = r13.toString();	 Catch:{ all -> 0x0d15 }
            r7[r8] = r9;	 Catch:{ all -> 0x0d15 }
            r8 = 1;
            r7[r8] = r26;	 Catch:{ all -> 0x0d15 }
            r8 = 2;
            r7[r8] = r27;	 Catch:{ all -> 0x0d15 }
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);	 Catch:{ all -> 0x0d15 }
            r5 = -1;
            r6 = "unknown";
            r0 = r19;
            r4.b(r5, r6, r0);	 Catch:{ all -> 0x0d15 }
            r0 = r39;
            r4 = r0.jbo;
            r4 = r4.ivH;
            r0 = r40;
            r5 = r0.jbk;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r0 = r22;
            r10 = (long) r0;
            r13 = 2;
            r14 = r40.Vn();
            r8 = r20;
            r12 = r19;
            com.tencent.mm.plugin.appbrand.report.a.e.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.aJi = r4;
            r0 = r39;
            r4 = r0.jbo;
            r0 = r26;
            r1 = r28;
            r2 = r27;
            r4.a(r0, r1, r2, r15);
            if (r16 == 0) goto L_0x0bab;
        L_0x0ba8:
            r16.close();	 Catch:{ Exception -> 0x0bd3 }
        L_0x0bab:
            if (r17 == 0) goto L_0x0bb0;
        L_0x0bad:
            r17.close();	 Catch:{ IOException -> 0x0bee }
        L_0x0bb0:
            if (r18 == 0) goto L_0x009c;
        L_0x0bb2:
            r18.close();	 Catch:{ IOException -> 0x0bb7 }
            goto L_0x009c;
        L_0x0bb7:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x009c;
        L_0x0bd3:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x0bab;
        L_0x0bee:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s , url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x0bb0;
        L_0x0c09:
            r4 = move-exception;
            r16 = r13;
            r18 = r17;
            r8 = r20;
            r12 = r19;
            r19 = r15;
            r17 = r14;
            r15 = r4;
        L_0x0c17:
            r0 = r39;
            r4 = r0.jbo;
            r4 = r4.ivH;
            r0 = r40;
            r5 = r0.jbk;
            r6 = "POST";
            r0 = r40;
            r7 = r0.mUrl;
            r0 = r22;
            r10 = (long) r0;
            r13 = 2;
            r14 = r40.Vn();
            com.tencent.mm.plugin.appbrand.report.a.e.a(r4, r5, r6, r7, r8, r10, r12, r13, r14);
            r4 = 0;
            r0 = r40;
            r0.aJi = r4;
            r0 = r39;
            r4 = r0.jbo;
            r0 = r26;
            r1 = r28;
            r2 = r27;
            r3 = r19;
            r4.a(r0, r1, r2, r3);
            if (r16 == 0) goto L_0x0c4c;
        L_0x0c49:
            r16.close();	 Catch:{ Exception -> 0x0c57 }
        L_0x0c4c:
            if (r17 == 0) goto L_0x0c51;
        L_0x0c4e:
            r17.close();	 Catch:{ IOException -> 0x0c72 }
        L_0x0c51:
            if (r18 == 0) goto L_0x0c56;
        L_0x0c53:
            r18.close();	 Catch:{ IOException -> 0x0c8d }
        L_0x0c56:
            throw r15;
        L_0x0c57:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x0c4c;
        L_0x0c72:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s , url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x0c51;
        L_0x0c8d:
            r4 = move-exception;
            r5 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "exception : %s ,url is %s filepath %s ";
            r7 = 3;
            r7 = new java.lang.Object[r7];
            r8 = 0;
            r4 = r4.toString();
            r7[r8] = r4;
            r4 = 1;
            r7[r4] = r26;
            r4 = 2;
            r7[r4] = r27;
            com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
            goto L_0x0c56;
        L_0x0ca8:
            r4 = move-exception;
            r18 = r17;
            r8 = r20;
            r12 = r19;
            r19 = r15;
            r17 = r14;
            r15 = r4;
            goto L_0x0c17;
        L_0x0cb6:
            r4 = move-exception;
            r18 = r17;
            r8 = r20;
            r12 = r19;
            r19 = r15;
            r17 = r14;
            r15 = r4;
            goto L_0x0c17;
        L_0x0cc4:
            r4 = move-exception;
            r17 = r14;
            r8 = r20;
            r12 = r19;
            r19 = r15;
            r15 = r4;
            goto L_0x0c17;
        L_0x0cd0:
            r4 = move-exception;
            r17 = r14;
            r12 = r19;
            r19 = r15;
            r15 = r4;
            goto L_0x0c17;
        L_0x0cda:
            r4 = move-exception;
            r17 = r14;
            r8 = r6;
            r12 = r19;
            r19 = r15;
            r15 = r4;
            goto L_0x0c17;
        L_0x0ce5:
            r4 = move-exception;
            r17 = r14;
            r19 = r15;
            r15 = r4;
            goto L_0x0c17;
        L_0x0ced:
            r4 = move-exception;
            r19 = r15;
            r15 = r4;
            goto L_0x0c17;
        L_0x0cf3:
            r4 = move-exception;
            r19 = r15;
            r22 = r6;
            r15 = r4;
            goto L_0x0c17;
        L_0x0cfb:
            r4 = move-exception;
            r19 = r15;
            r22 = r10;
            r15 = r4;
            goto L_0x0c17;
        L_0x0d03:
            r4 = move-exception;
            r8 = r20;
            r12 = r19;
            r22 = r14;
            r19 = r18;
            r18 = r17;
            r17 = r16;
            r16 = r15;
            r15 = r4;
            goto L_0x0c17;
        L_0x0d15:
            r4 = move-exception;
            r8 = r20;
            r12 = r19;
            r19 = r15;
            r15 = r4;
            goto L_0x0c17;
        L_0x0d1f:
            r5 = move-exception;
            r13 = r5;
            r18 = r17;
            r17 = r14;
            goto L_0x0b46;
        L_0x0d27:
            r5 = move-exception;
            r13 = r5;
            r17 = r14;
            goto L_0x0b46;
        L_0x0d2d:
            r5 = move-exception;
            r13 = r5;
            r17 = r14;
            r20 = r8;
            goto L_0x0b46;
        L_0x0d35:
            r5 = move-exception;
            r13 = r5;
            r17 = r14;
            r20 = r6;
            goto L_0x0b46;
        L_0x0d3d:
            r5 = move-exception;
            r13 = r5;
            r17 = r14;
            r20 = r8;
            r19 = r12;
            goto L_0x0b46;
        L_0x0d47:
            r5 = move-exception;
            r13 = r5;
            r20 = r8;
            r19 = r12;
            goto L_0x0b46;
        L_0x0d4f:
            r5 = move-exception;
            r13 = r5;
            r20 = r8;
            r19 = r12;
            r22 = r6;
            goto L_0x0b46;
        L_0x0d59:
            r5 = move-exception;
            r13 = r5;
            r20 = r8;
            r19 = r12;
            r22 = r10;
            goto L_0x0b46;
        L_0x0d63:
            r5 = move-exception;
            r13 = r5;
            r18 = r17;
            r17 = r14;
            goto L_0x0a7b;
        L_0x0d6b:
            r5 = move-exception;
            r13 = r5;
            r17 = r14;
            goto L_0x0a7b;
        L_0x0d71:
            r5 = move-exception;
            r13 = r5;
            r17 = r14;
            r20 = r8;
            goto L_0x0a7b;
        L_0x0d79:
            r5 = move-exception;
            r13 = r5;
            r17 = r14;
            r20 = r6;
            goto L_0x0a7b;
        L_0x0d81:
            r5 = move-exception;
            r13 = r5;
            r17 = r14;
            r20 = r8;
            r19 = r12;
            goto L_0x0a7b;
        L_0x0d8b:
            r5 = move-exception;
            r13 = r5;
            r20 = r8;
            r19 = r12;
            goto L_0x0a7b;
        L_0x0d93:
            r5 = move-exception;
            r13 = r5;
            r20 = r8;
            r19 = r12;
            r22 = r6;
            goto L_0x0a7b;
        L_0x0d9d:
            r5 = move-exception;
            r13 = r5;
            r20 = r8;
            r19 = r12;
            r22 = r10;
            goto L_0x0a7b;
        L_0x0da7:
            r5 = move-exception;
            r16 = r13;
            r18 = r17;
            r17 = r14;
            r13 = r5;
            goto L_0x046d;
        L_0x0db1:
            r5 = move-exception;
            r13 = r5;
            r17 = r14;
            goto L_0x046d;
        L_0x0db7:
            r5 = move-exception;
            r13 = r5;
            r17 = r14;
            r20 = r8;
            goto L_0x046d;
        L_0x0dbf:
            r5 = move-exception;
            r13 = r5;
            r17 = r14;
            r20 = r6;
            goto L_0x046d;
        L_0x0dc7:
            r5 = move-exception;
            r13 = r5;
            r17 = r14;
            r20 = r8;
            r19 = r12;
            goto L_0x046d;
        L_0x0dd1:
            r5 = move-exception;
            r13 = r5;
            r20 = r8;
            r19 = r12;
            goto L_0x046d;
        L_0x0dd9:
            r5 = move-exception;
            r13 = r5;
            r20 = r8;
            r19 = r12;
            r22 = r6;
            goto L_0x046d;
        L_0x0de3:
            r5 = move-exception;
            r13 = r5;
            r20 = r8;
            r19 = r12;
            r22 = r10;
            goto L_0x046d;
        L_0x0ded:
            r5 = move-exception;
            r16 = r13;
            r18 = r17;
            r17 = r14;
            r13 = r5;
            goto L_0x030e;
        L_0x0df7:
            r5 = move-exception;
            r13 = r5;
            r17 = r14;
            goto L_0x030e;
        L_0x0dfd:
            r5 = move-exception;
            r13 = r5;
            r17 = r14;
            r20 = r8;
            goto L_0x030e;
        L_0x0e05:
            r5 = move-exception;
            r13 = r5;
            r17 = r14;
            r20 = r6;
            goto L_0x030e;
        L_0x0e0d:
            r5 = move-exception;
            r13 = r5;
            r17 = r14;
            r20 = r8;
            r19 = r12;
            goto L_0x030e;
        L_0x0e17:
            r5 = move-exception;
            r13 = r5;
            r20 = r8;
            r19 = r12;
            goto L_0x030e;
        L_0x0e1f:
            r5 = move-exception;
            r13 = r5;
            r20 = r8;
            r19 = r12;
            r22 = r6;
            goto L_0x030e;
        L_0x0e29:
            r5 = move-exception;
            r13 = r5;
            r20 = r8;
            r19 = r12;
            r22 = r10;
            goto L_0x030e;
        L_0x0e33:
            r5 = move-exception;
            r16 = r14;
            r18 = r15;
            r15 = r13;
            r14 = r22;
            r13 = r5;
            goto L_0x026a;
        L_0x0e3e:
            r5 = move-exception;
            r13 = r5;
            r18 = r15;
            r15 = r16;
            r16 = r14;
            r14 = r22;
            goto L_0x026a;
        L_0x0e4a:
            r5 = move-exception;
            r13 = r5;
            r17 = r18;
            r18 = r15;
            r15 = r16;
            r16 = r14;
            r14 = r22;
            goto L_0x026a;
        L_0x0e58:
            r5 = move-exception;
            r13 = r5;
            r17 = r18;
            r20 = r8;
            r18 = r15;
            r15 = r16;
            r16 = r14;
            r14 = r22;
            goto L_0x026a;
        L_0x0e68:
            r5 = move-exception;
            r13 = r5;
            r17 = r18;
            r20 = r6;
            r18 = r15;
            r15 = r16;
            r16 = r14;
            r14 = r22;
            goto L_0x026a;
        L_0x0e78:
            r5 = move-exception;
            r13 = r5;
            r17 = r18;
            r20 = r8;
            r19 = r12;
            r18 = r15;
            r15 = r16;
            r16 = r14;
            r14 = r22;
            goto L_0x026a;
        L_0x0e8a:
            r5 = move-exception;
            r13 = r5;
            r20 = r8;
            r19 = r12;
            r14 = r6;
            r38 = r15;
            r15 = r16;
            r16 = r17;
            r17 = r18;
            r18 = r38;
            goto L_0x026a;
        L_0x0e9d:
            r5 = move-exception;
            r13 = r5;
            r20 = r8;
            r19 = r12;
            r14 = r10;
            r38 = r15;
            r15 = r16;
            r16 = r17;
            r17 = r18;
            r18 = r38;
            goto L_0x026a;
        L_0x0eb0:
            r5 = r24;
            r10 = r22;
            goto L_0x08f2;
        L_0x0eb6:
            r8 = r6;
            goto L_0x05ef;
        L_0x0eb9:
            r10 = r5;
            goto L_0x05b1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.f.f.b.a(com.tencent.mm.plugin.appbrand.f.g):void");
        }
    }

    public f(String str) {
        this.ivH = str;
        this.jaQ = com.tencent.mm.plugin.appbrand.b.mY(str).iEX;
    }

    public final void a(int i, String str, String str2, JSONObject jSONObject, Map<String, String> map, ArrayList<String> arrayList, a aVar, String str3, String str4) {
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        Object optString2 = jSONObject.optString("name");
        Map n = i.n(jSONObject);
        if (this.jbm.size() >= this.jaQ) {
            aVar.py("tasked refused max connected");
            w.i("MicroMsg.AppBrandNetworkUpload", "max connected");
        } else if (TextUtils.isEmpty(optString2)) {
            aVar.py("fileName error");
            w.i("MicroMsg.AppBrandNetworkUpload", "fileName error");
        } else {
            g gVar = new g(str2, optString, optString2, i, str, aVar);
            gVar.jbq = n;
            gVar.jbg = map;
            gVar.jbh = arrayList;
            gVar.aJi = true;
            gVar.iKz = str3;
            gVar.jbk = str4;
            synchronized (this.jbm) {
                this.jbm.add(gVar);
            }
            e.post(new b(this, gVar), "appbrand_upload_thread");
        }
    }

    public final g pW(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.jbm) {
            Iterator it = this.jbm.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                if (str.equals(gVar.iKz)) {
                    return gVar;
                }
            }
            return null;
        }
    }

    public final void a(String str, String str2, String str3, HttpURLConnection httpURLConnection) {
        if (str != null) {
            Collection arrayList = new ArrayList();
            synchronized (this.jbm) {
                Iterator it = this.jbm.iterator();
                while (it.hasNext()) {
                    g gVar = (g) it.next();
                    if (gVar.mUrl.equals(str) && gVar.mName.equals(str2)) {
                        arrayList.add(gVar);
                    }
                }
                if (arrayList.size() > 0) {
                    this.jbm.removeAll(arrayList);
                }
            }
        }
        w.i("MicroMsg.AppBrandNetworkUpload", "finally : url is " + str + ", filepath" + str3);
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
