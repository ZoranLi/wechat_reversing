package com.tencent.mm.plugin.appbrand.f.a;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;
import javax.net.ssl.SSLContext;

public final class b implements Runnable {
    public volatile boolean aJi = false;
    private String appId;
    private String filename;
    public String iKz;
    public SSLContext jaS;
    private final a jbH;
    public Map<String, String> jbI;
    public int jbJ = 60000;
    public volatile int jbK;
    private HttpURLConnection jbL;
    public ArrayList<String> jbh;
    private int jbi = 15;
    public String jbk;
    private long startTime;
    public String uri;

    public b(String str, String str2, String str3, a aVar) {
        this.appId = str;
        this.uri = str2;
        this.filename = str3;
        this.jbH = aVar;
        this.startTime = System.currentTimeMillis();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r26 = this;
        r0 = r26;
        r2 = r0.uri;
        r2 = android.webkit.URLUtil.isHttpsUrl(r2);
        if (r2 != 0) goto L_0x0027;
    L_0x000a:
        r0 = r26;
        r2 = r0.uri;
        r2 = android.webkit.URLUtil.isHttpUrl(r2);
        if (r2 != 0) goto L_0x0027;
    L_0x0014:
        r0 = r26;
        r2 = r0.jbH;
        r0 = r26;
        r3 = r0.filename;
        r0 = r26;
        r4 = r0.uri;
        r5 = "downloadFile protocol must be http or https";
        r2.y(r3, r4, r5);
    L_0x0026:
        return;
    L_0x0027:
        r0 = r26;
        r2 = r0.jbh;
        if (r2 == 0) goto L_0x0061;
    L_0x002d:
        r0 = r26;
        r2 = r0.jbh;
        r0 = r26;
        r3 = r0.uri;
        r2 = com.tencent.mm.plugin.appbrand.f.i.b(r2, r3);
        if (r2 != 0) goto L_0x0061;
    L_0x003b:
        r0 = r26;
        r2 = r0.jbH;
        r0 = r26;
        r3 = r0.filename;
        r0 = r26;
        r4 = r0.uri;
        r5 = "url not in domain list";
        r2.y(r3, r4, r5);
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "not in domain url %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r26;
        r6 = r0.uri;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
        goto L_0x0026;
    L_0x0061:
        r0 = r26;
        r2 = r0.appId;
        r18 = com.tencent.mm.plugin.appbrand.a.mV(r2);
        r16 = 0;
        r13 = 0;
        r14 = 0;
        r0 = r26;
        r2 = r0.aJi;
        if (r2 != 0) goto L_0x00a3;
    L_0x0074:
        r0 = r26;
        r2 = r0.jbH;
        r0 = r26;
        r3 = r0.filename;
        r0 = r26;
        r4 = r0.uri;
        r5 = "force stop";
        r2.y(r3, r4, r5);
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r10 = 0;
        r11 = 2;
        r12 = r26.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        goto L_0x0026;
    L_0x00a3:
        r12 = 0;
        r11 = 0;
        r0 = r26;
        r2 = r0.jbH;
        r0 = r26;
        r3 = r0.filename;
        r0 = r26;
        r4 = r0.uri;
        r2.ba(r3, r4);
        r3 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 0;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r5 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r0 = r26;
        r2 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r5.<init>(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "url is %s ,filename is %s , start download";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r6 = 0;
        r0 = r26;
        r7 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r4[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r6 = 1;
        r0 = r26;
        r7 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r4[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r2 = r5.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r0 = r26;
        r0.jbL = r2;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r2 = r2 instanceof javax.net.ssl.HttpsURLConnection;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        if (r2 == 0) goto L_0x0117;
    L_0x00f5:
        r0 = r26;
        r2 = r0.jaS;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        if (r2 == 0) goto L_0x0117;
    L_0x00fb:
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r2 = (javax.net.ssl.HttpsURLConnection) r2;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r0 = r26;
        r3 = r0.jaS;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r3 = r3.getSocketFactory();	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r2.setSSLSocketFactory(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r0 = r26;
        r3 = r0.jbh;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        com.tencent.mm.plugin.appbrand.f.i.a(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
    L_0x0117:
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r3 = 1;
        r2.setDoInput(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r0 = r26;
        r3 = r0.jbJ;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r2.setConnectTimeout(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r0 = r26;
        r3 = r0.jbJ;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r2.setReadTimeout(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r3 = 0;
        r2.setInstanceFollowRedirects(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r3 = "Accept-Encoding";
        r4 = "gzip";
        r2.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r0 = r26;
        r2 = r0.jbI;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        if (r2 == 0) goto L_0x0223;
    L_0x0150:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "url %s : set header ";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r6 = 0;
        r4[r6] = r5;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r0 = r26;
        r2 = r0.jbI;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r2 = r2.entrySet();	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r6 = r2.iterator();	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
    L_0x016b:
        r2 = r6.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        if (r2 == 0) goto L_0x0223;
    L_0x0171:
        r2 = r6.next();	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r0 = r26;
        r7 = r0.jbL;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r3 = r2.getKey();	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r3 = (java.lang.String) r3;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r4 = r2.getValue();	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r4 = (java.lang.String) r4;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r7.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "filename %s : key:%s ,value %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r8 = 0;
        r0 = r26;
        r9 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r7[r8] = r9;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r8 = 1;
        r9 = r2.getKey();	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r7[r8] = r9;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r8 = 2;
        r2 = r2.getValue();	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r7[r8] = r2;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        com.tencent.mm.sdk.platformtools.w.i(r3, r4, r7);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        goto L_0x016b;
    L_0x01ac:
        r2 = move-exception;
        r25 = r11;
        r11 = r16;
        r16 = r14;
        r14 = r12;
        r15 = r13;
        r13 = r25;
    L_0x01b7:
        r3 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x0a96 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 1;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0a96 }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "url is %s ,filename is %s , error is %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0a96 }
        r6 = 0;
        r0 = r26;
        r7 = r0.uri;	 Catch:{ all -> 0x0a96 }
        r5[r6] = r7;	 Catch:{ all -> 0x0a96 }
        r6 = 1;
        r0 = r26;
        r7 = r0.filename;	 Catch:{ all -> 0x0a96 }
        r5[r6] = r7;	 Catch:{ all -> 0x0a96 }
        r6 = 2;
        r2 = r2.toString();	 Catch:{ all -> 0x0a96 }
        r5[r6] = r2;	 Catch:{ all -> 0x0a96 }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ all -> 0x0a96 }
        r0 = r26;
        r2 = r0.jbH;	 Catch:{ all -> 0x0a96 }
        r0 = r26;
        r3 = r0.filename;	 Catch:{ all -> 0x0a96 }
        r0 = r26;
        r4 = r0.uri;	 Catch:{ all -> 0x0a96 }
        r5 = "unsupport encoding error";
        r2.y(r3, r4, r5);	 Catch:{ all -> 0x0a96 }
        if (r11 == 0) goto L_0x072d;
    L_0x01f8:
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r26.Vn();
        r8 = r16;
        r10 = r15;
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
    L_0x0214:
        if (r13 == 0) goto L_0x0219;
    L_0x0216:
        r13.close();	 Catch:{ IOException -> 0x074b }
    L_0x0219:
        if (r14 == 0) goto L_0x021e;
    L_0x021b:
        r14.close();	 Catch:{ IOException -> 0x075a }
    L_0x021e:
        r26.Vu();
        goto L_0x0026;
    L_0x0223:
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r3 = "User-Agent";
        r4 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r6 = "";
        r4 = com.tencent.mm.pluginsdk.ui.tools.s.aZ(r4, r6);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r2.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r2 = r2.getContentLength();	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r6 = (long) r2;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r3 = "Content-Type";
        r2 = r2.getHeaderField(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r3 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r4 = com.tencent.mm.pluginsdk.ui.tools.s.a.Nz(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        if (r4 != 0) goto L_0x02ef;
    L_0x0256:
        r2 = com.tencent.mm.pluginsdk.ui.tools.s.Nx(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r17 = r2;
    L_0x025c:
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r10 = r2.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r10 == r2) goto L_0x0356;
    L_0x0268:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "statusCode %s, url is %s ,filename is %s ";
        r4 = 3;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r5 = 0;
        r8 = java.lang.Integer.valueOf(r10);	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r4[r5] = r8;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r5 = 1;
        r0 = r26;
        r8 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r4[r5] = r8;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r5 = 2;
        r0 = r26;
        r8 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r4[r5] = r8;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r2 = com.tencent.mm.plugin.appbrand.f.i.ia(r10);	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        if (r2 == 0) goto L_0x0356;
    L_0x028f:
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r2 = com.tencent.mm.plugin.appbrand.f.i.c(r2);	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        if (r3 != 0) goto L_0x0356;
    L_0x029d:
        r0 = r26;
        r3 = r0.jbi;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r4 = r3 + -1;
        r0 = r26;
        r0.jbi = r4;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        if (r3 > 0) goto L_0x030e;
    L_0x02a9:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "reach the max redirect count(%d)";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r5 = 0;
        r6 = 15;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        com.tencent.mm.sdk.platformtools.w.w(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r0 = r26;
        r2 = r0.jbH;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r0 = r26;
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r0 = r26;
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r0 = r17;
        r2.a(r3, r0, r4, r10);	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r11 = 1;
        r12 = r26.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r26.Vu();
        goto L_0x0026;
    L_0x02ef:
        r2 = r4.mimeType;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r5 = "application/octet-stream";
        r2 = r2.contains(r5);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        if (r2 == 0) goto L_0x0308;
    L_0x02fa:
        r2 = com.tencent.mm.pluginsdk.ui.tools.s.Nx(r3);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r2);	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        if (r3 != 0) goto L_0x0308;
    L_0x0304:
        r17 = r2;
        goto L_0x025c;
    L_0x0308:
        r2 = r4.mimeType;	 Catch:{ UnsupportedEncodingException -> 0x01ac, FileNotFoundException -> 0x0769, SSLHandshakeException -> 0x0811, SocketTimeoutException -> 0x08b9, Exception -> 0x0961, all -> 0x0a09 }
        r17 = r2;
        goto L_0x025c;
    L_0x030e:
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "redirect(%d) URL(%s) to URL(%s)";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r6 = 0;
        r0 = r26;
        r7 = r0.jbi;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r6 = 1;
        r0 = r26;
        r7 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r6 = 2;
        r5[r6] = r2;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r0 = r26;
        r0.uri = r2;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r26.run();	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r11 = 2;
        r12 = r26.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r26.Vu();
        goto L_0x0026;
    L_0x0356:
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r2 = r2.getContentLength();	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        if (r2 <= 0) goto L_0x03b4;
    L_0x0360:
        r0 = r26;
        r3 = r0.jbK;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        if (r3 <= 0) goto L_0x03b4;
    L_0x0366:
        r0 = r26;
        r3 = r0.jbK;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r4 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r3 = r3 * r4;
        if (r2 < r3) goto L_0x03b4;
    L_0x036f:
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "before actually read stream, contentLength %d exceed limit";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r6 = 0;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r5[r6] = r2;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r0 = r26;
        r2 = r0.jbH;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r0 = r26;
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r0 = r26;
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r5 = "exceed max file size";
        r2.y(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r11 = 2;
        r12 = r26.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r26.Vu();
        goto L_0x0026;
    L_0x03b4:
        r2 = "gzip";
        r0 = r26;
        r3 = r0.jbL;	 Catch:{ Exception -> 0x044f, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
        r3 = r3.getContentEncoding();	 Catch:{ Exception -> 0x044f, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x044f, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
        if (r2 == 0) goto L_0x0446;
    L_0x03c5:
        r24 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x044f, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ Exception -> 0x044f, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
        r2 = r2.getInputStream();	 Catch:{ Exception -> 0x044f, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
        r0 = r24;
        r0.<init>(r2);	 Catch:{ Exception -> 0x044f, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
    L_0x03d4:
        r12 = new java.io.File;	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r0 = r26;
        r2 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r12.<init>(r2);	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r2 = r12.exists();	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        if (r2 == 0) goto L_0x04b1;
    L_0x03e3:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "exists temp file ,filename is %s ";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r5 = 0;
        r0 = r26;
        r8 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r4[r5] = r8;	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r2 = r12.delete();	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        if (r2 != 0) goto L_0x04b1;
    L_0x03fc:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "exists temp file delete failed, filename is %s ";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r5 = 0;
        r0 = r26;
        r6 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r0 = r26;
        r2 = r0.jbH;	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r0 = r26;
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r0 = r26;
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r5 = "exists temp file delete failed";
        r2.y(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r11 = 2;
        r12 = r26.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        if (r24 == 0) goto L_0x0441;
    L_0x043e:
        r24.close();	 Catch:{ IOException -> 0x04a3 }
    L_0x0441:
        r26.Vu();
        goto L_0x0026;
    L_0x0446:
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ Exception -> 0x044f, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
        r24 = r2.getInputStream();	 Catch:{ Exception -> 0x044f, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
        goto L_0x03d4;
    L_0x044f:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "getInputStream error : %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r8 = 0;
        r5[r8] = r2;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r2 = "gzip";
        r0 = r26;
        r3 = r0.jbL;	 Catch:{ Exception -> 0x0481, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
        r3 = r3.getContentEncoding();	 Catch:{ Exception -> 0x0481, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x0481, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
        if (r2 == 0) goto L_0x0499;
    L_0x0470:
        r24 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x0481, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ Exception -> 0x0481, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
        r2 = r2.getErrorStream();	 Catch:{ Exception -> 0x0481, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
        r0 = r24;
        r0.<init>(r2);	 Catch:{ Exception -> 0x0481, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
        goto L_0x03d4;
    L_0x0481:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "read err stream failed : %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r8 = 0;
        r2 = r2.toString();	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r5[r8] = r2;	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, Exception -> 0x0aa9, all -> 0x0a70 }
        r24 = r12;
        goto L_0x03d4;
    L_0x0499:
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ Exception -> 0x0481, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
        r24 = r2.getErrorStream();	 Catch:{ Exception -> 0x0481, UnsupportedEncodingException -> 0x0b59, FileNotFoundException -> 0x0b2d, SSLHandshakeException -> 0x0b01, SocketTimeoutException -> 0x0ad5, all -> 0x0a70 }
        goto L_0x03d4;
    L_0x04a3:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0441;
    L_0x04b1:
        r2 = r12.getParentFile();	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r2 = r2.exists();	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        if (r2 != 0) goto L_0x0530;
    L_0x04bb:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "create file ,filename is %s ";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r5 = 0;
        r0 = r26;
        r8 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r4[r5] = r8;	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r2 = r12.getParentFile();	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r2 = r2.mkdirs();	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        if (r2 != 0) goto L_0x0530;
    L_0x04d8:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "create file  getParentFile failed, filename is %s ";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r5 = 0;
        r0 = r26;
        r6 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r0 = r26;
        r2 = r0.jbH;	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r0 = r26;
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r0 = r26;
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r5 = "getParentFile failed";
        r2.y(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r8 = 0;
        r11 = 2;
        r12 = r26.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        if (r24 == 0) goto L_0x051d;
    L_0x051a:
        r24.close();	 Catch:{ IOException -> 0x0522 }
    L_0x051d:
        r26.Vu();
        goto L_0x0026;
    L_0x0522:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x051d;
    L_0x0530:
        if (r24 == 0) goto L_0x0ba8;
    L_0x0532:
        r23 = new java.io.FileOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r0 = r23;
        r0.<init>(r12);	 Catch:{ UnsupportedEncodingException -> 0x0b63, FileNotFoundException -> 0x0b35, SSLHandshakeException -> 0x0b09, SocketTimeoutException -> 0x0add, Exception -> 0x0ab1, all -> 0x0a78 }
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r11 = new byte[r2];	 Catch:{ UnsupportedEncodingException -> 0x0b6e, FileNotFoundException -> 0x0b3b, SSLHandshakeException -> 0x0b0f, SocketTimeoutException -> 0x0ae3, Exception -> 0x0ab7, all -> 0x0a7e }
        r8 = r14;
    L_0x053e:
        r0 = r24;
        r2 = r0.read(r11);	 Catch:{ UnsupportedEncodingException -> 0x0b7a, FileNotFoundException -> 0x0b3f, SSLHandshakeException -> 0x0b13, SocketTimeoutException -> 0x0ae7, Exception -> 0x0abb, all -> 0x0a82 }
        r3 = -1;
        if (r2 == r3) goto L_0x067a;
    L_0x0547:
        r0 = r26;
        r3 = r0.aJi;	 Catch:{ UnsupportedEncodingException -> 0x0b7a, FileNotFoundException -> 0x0b3f, SSLHandshakeException -> 0x0b13, SocketTimeoutException -> 0x0ae7, Exception -> 0x0abb, all -> 0x0a82 }
        if (r3 == 0) goto L_0x067a;
    L_0x054d:
        r3 = r18.Pn();	 Catch:{ UnsupportedEncodingException -> 0x0b7a, FileNotFoundException -> 0x0b3f, SSLHandshakeException -> 0x0b13, SocketTimeoutException -> 0x0ae7, Exception -> 0x0abb, all -> 0x0a82 }
        if (r3 == 0) goto L_0x05a7;
    L_0x0553:
        r0 = r26;
        r2 = r0.jbH;	 Catch:{ UnsupportedEncodingException -> 0x0b7a, FileNotFoundException -> 0x0b3f, SSLHandshakeException -> 0x0b13, SocketTimeoutException -> 0x0ae7, Exception -> 0x0abb, all -> 0x0a82 }
        r0 = r26;
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0b7a, FileNotFoundException -> 0x0b3f, SSLHandshakeException -> 0x0b13, SocketTimeoutException -> 0x0ae7, Exception -> 0x0abb, all -> 0x0a82 }
        r0 = r26;
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0b7a, FileNotFoundException -> 0x0b3f, SSLHandshakeException -> 0x0b13, SocketTimeoutException -> 0x0ae7, Exception -> 0x0abb, all -> 0x0a82 }
        r5 = "interrupted";
        r2.y(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0b7a, FileNotFoundException -> 0x0b3f, SSLHandshakeException -> 0x0b13, SocketTimeoutException -> 0x0ae7, Exception -> 0x0abb, all -> 0x0a82 }
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r26.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r23.close();	 Catch:{ IOException -> 0x058b }
    L_0x0581:
        if (r24 == 0) goto L_0x0586;
    L_0x0583:
        r24.close();	 Catch:{ IOException -> 0x0599 }
    L_0x0586:
        r26.Vu();
        goto L_0x0026;
    L_0x058b:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0581;
    L_0x0599:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0586;
    L_0x05a7:
        r3 = 0;
        r0 = r23;
        r0.write(r11, r3, r2);	 Catch:{ UnsupportedEncodingException -> 0x0b7a, FileNotFoundException -> 0x0b3f, SSLHandshakeException -> 0x0b13, SocketTimeoutException -> 0x0ae7, Exception -> 0x0abb, all -> 0x0a82 }
        r2 = (long) r2;
        r4 = r8 + r2;
        r2 = 0;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x05e9;
    L_0x05b6:
        r0 = r26;
        r2 = r0.aJi;	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        if (r2 == 0) goto L_0x05e9;
    L_0x05bc:
        r2 = 100;
        r2 = r2 * r4;
        r2 = r2 / r6;
        r3 = (int) r2;	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r0 = r26;
        r2 = r0.jbH;	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r2.c(r3, r4, r6);	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r8 = "download size %d, totalSize %d, percent = %d";
        r9 = 3;
        r9 = new java.lang.Object[r9];	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r13 = 0;
        r14 = java.lang.Long.valueOf(r4);	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r9[r13] = r14;	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r13 = 1;
        r14 = java.lang.Long.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r9[r13] = r14;	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r13 = 2;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r9[r13] = r3;	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        com.tencent.mm.sdk.platformtools.w.v(r2, r8, r9);	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
    L_0x05e9:
        r2 = 0;
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0ba5;
    L_0x05ef:
        r0 = r26;
        r2 = r0.jbK;	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        if (r2 <= 0) goto L_0x0ba5;
    L_0x05f5:
        r0 = r26;
        r2 = r0.jbK;	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r3 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r2 = r2 * r3;
        r2 = (long) r2;	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x0ba5;
    L_0x0601:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "after read stream, downloadSize %d exceed limit";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r7 = 0;
        r8 = java.lang.Long.valueOf(r4);	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r6);	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r0 = r26;
        r2 = r0.jbH;	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r0 = r26;
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r0 = r26;
        r6 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r7 = "exceed max file size";
        r2.y(r3, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        com.tencent.mm.sdk.platformtools.bg.g(r23);	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        com.tencent.mm.sdk.platformtools.bg.g(r24);	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r2 = r12.getAbsolutePath();	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        com.tencent.mm.loader.stub.b.deleteFile(r2);	 Catch:{ UnsupportedEncodingException -> 0x0b86, FileNotFoundException -> 0x0b44, SSLHandshakeException -> 0x0b18, SocketTimeoutException -> 0x0aec, Exception -> 0x0ac0, all -> 0x0a85 }
        r0 = r26;
        r12 = r0.appId;
        r0 = r26;
        r13 = r0.jbk;
        r14 = "GET";
        r0 = r26;
        r15 = r0.uri;
        r16 = 0;
        r21 = 2;
        r22 = r26.Vn();
        r18 = r4;
        r20 = r10;
        com.tencent.mm.plugin.appbrand.report.a.e.a(r12, r13, r14, r15, r16, r18, r20, r21, r22);
        r23.close();	 Catch:{ IOException -> 0x065e }
    L_0x0654:
        if (r24 == 0) goto L_0x0659;
    L_0x0656:
        r24.close();	 Catch:{ IOException -> 0x066c }
    L_0x0659:
        r26.Vu();
        goto L_0x0026;
    L_0x065e:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0654;
    L_0x066c:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0659;
    L_0x067a:
        r23.flush();	 Catch:{ UnsupportedEncodingException -> 0x0b7a, FileNotFoundException -> 0x0b3f, SSLHandshakeException -> 0x0b13, SocketTimeoutException -> 0x0ae7, Exception -> 0x0abb, all -> 0x0a82 }
        r13 = r23;
    L_0x067f:
        r0 = r26;
        r2 = r0.aJi;	 Catch:{ UnsupportedEncodingException -> 0x0b92, FileNotFoundException -> 0x0b49, SSLHandshakeException -> 0x0b1d, SocketTimeoutException -> 0x0af1, Exception -> 0x0ac5, all -> 0x0a89 }
        if (r2 == 0) goto L_0x06e2;
    L_0x0685:
        r0 = r26;
        r2 = r0.jbH;	 Catch:{ UnsupportedEncodingException -> 0x0b92, FileNotFoundException -> 0x0b49, SSLHandshakeException -> 0x0b1d, SocketTimeoutException -> 0x0af1, Exception -> 0x0ac5, all -> 0x0a89 }
        r0 = r26;
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0b92, FileNotFoundException -> 0x0b49, SSLHandshakeException -> 0x0b1d, SocketTimeoutException -> 0x0af1, Exception -> 0x0ac5, all -> 0x0a89 }
        r0 = r26;
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0b92, FileNotFoundException -> 0x0b49, SSLHandshakeException -> 0x0b1d, SocketTimeoutException -> 0x0af1, Exception -> 0x0ac5, all -> 0x0a89 }
        r0 = r17;
        r2.a(r3, r0, r4, r10);	 Catch:{ UnsupportedEncodingException -> 0x0b92, FileNotFoundException -> 0x0b49, SSLHandshakeException -> 0x0b1d, SocketTimeoutException -> 0x0af1, Exception -> 0x0ac5, all -> 0x0a89 }
        r3 = 1;
    L_0x0697:
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "finished filename = %s , url = %s ";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x0b9c, FileNotFoundException -> 0x0b50, SSLHandshakeException -> 0x0b24, SocketTimeoutException -> 0x0af8, Exception -> 0x0acc, all -> 0x0a8e }
        r6 = 0;
        r0 = r26;
        r7 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0b9c, FileNotFoundException -> 0x0b50, SSLHandshakeException -> 0x0b24, SocketTimeoutException -> 0x0af8, Exception -> 0x0acc, all -> 0x0a8e }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x0b9c, FileNotFoundException -> 0x0b50, SSLHandshakeException -> 0x0b24, SocketTimeoutException -> 0x0af8, Exception -> 0x0acc, all -> 0x0a8e }
        r6 = 1;
        r0 = r26;
        r7 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0b9c, FileNotFoundException -> 0x0b50, SSLHandshakeException -> 0x0b24, SocketTimeoutException -> 0x0af8, Exception -> 0x0acc, all -> 0x0a8e }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x0b9c, FileNotFoundException -> 0x0b50, SSLHandshakeException -> 0x0b24, SocketTimeoutException -> 0x0af8, Exception -> 0x0acc, all -> 0x0a8e }
        com.tencent.mm.sdk.platformtools.w.v(r2, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0b9c, FileNotFoundException -> 0x0b50, SSLHandshakeException -> 0x0b24, SocketTimeoutException -> 0x0af8, Exception -> 0x0acc, all -> 0x0a8e }
        r0 = r26;
        r2 = r0.jbL;	 Catch:{ UnsupportedEncodingException -> 0x0b9c, FileNotFoundException -> 0x0b50, SSLHandshakeException -> 0x0b24, SocketTimeoutException -> 0x0af8, Exception -> 0x0acc, all -> 0x0a8e }
        r2.disconnect();	 Catch:{ UnsupportedEncodingException -> 0x0b9c, FileNotFoundException -> 0x0b50, SSLHandshakeException -> 0x0b24, SocketTimeoutException -> 0x0af8, Exception -> 0x0acc, all -> 0x0a8e }
        if (r3 == 0) goto L_0x06f7;
    L_0x06ba:
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r26.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
    L_0x06d3:
        if (r13 == 0) goto L_0x06d8;
    L_0x06d5:
        r13.close();	 Catch:{ IOException -> 0x0711 }
    L_0x06d8:
        if (r24 == 0) goto L_0x06dd;
    L_0x06da:
        r24.close();	 Catch:{ IOException -> 0x071f }
    L_0x06dd:
        r26.Vu();
        goto L_0x0026;
    L_0x06e2:
        r0 = r26;
        r2 = r0.jbH;	 Catch:{ UnsupportedEncodingException -> 0x0b92, FileNotFoundException -> 0x0b49, SSLHandshakeException -> 0x0b1d, SocketTimeoutException -> 0x0af1, Exception -> 0x0ac5, all -> 0x0a89 }
        r0 = r26;
        r3 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0b92, FileNotFoundException -> 0x0b49, SSLHandshakeException -> 0x0b1d, SocketTimeoutException -> 0x0af1, Exception -> 0x0ac5, all -> 0x0a89 }
        r0 = r26;
        r4 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0b92, FileNotFoundException -> 0x0b49, SSLHandshakeException -> 0x0b1d, SocketTimeoutException -> 0x0af1, Exception -> 0x0ac5, all -> 0x0a89 }
        r5 = "force stop";
        r2.y(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0b92, FileNotFoundException -> 0x0b49, SSLHandshakeException -> 0x0b1d, SocketTimeoutException -> 0x0af1, Exception -> 0x0ac5, all -> 0x0a89 }
        r3 = r16;
        goto L_0x0697;
    L_0x06f7:
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r26.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        goto L_0x06d3;
    L_0x0711:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x06d8;
    L_0x071f:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x06dd;
    L_0x072d:
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r26.Vn();
        r8 = r16;
        r10 = r15;
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        goto L_0x0214;
    L_0x074b:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0219;
    L_0x075a:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x021e;
    L_0x0769:
        r2 = move-exception;
        r23 = r11;
        r24 = r12;
    L_0x076e:
        r3 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x0aa3 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 3;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0aa3 }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "url is %s ,filename is %s , error is %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0aa3 }
        r6 = 0;
        r0 = r26;
        r7 = r0.uri;	 Catch:{ all -> 0x0aa3 }
        r5[r6] = r7;	 Catch:{ all -> 0x0aa3 }
        r6 = 1;
        r0 = r26;
        r7 = r0.filename;	 Catch:{ all -> 0x0aa3 }
        r5[r6] = r7;	 Catch:{ all -> 0x0aa3 }
        r6 = 2;
        r2 = r2.toString();	 Catch:{ all -> 0x0aa3 }
        r5[r6] = r2;	 Catch:{ all -> 0x0aa3 }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ all -> 0x0aa3 }
        r0 = r26;
        r2 = r0.jbH;	 Catch:{ all -> 0x0aa3 }
        r0 = r26;
        r3 = r0.filename;	 Catch:{ all -> 0x0aa3 }
        r0 = r26;
        r4 = r0.uri;	 Catch:{ all -> 0x0aa3 }
        r5 = "file not found error";
        r2.y(r3, r4, r5);	 Catch:{ all -> 0x0aa3 }
        if (r16 == 0) goto L_0x07d9;
    L_0x07af:
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r26.Vn();
        r8 = r14;
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
    L_0x07ca:
        if (r23 == 0) goto L_0x07cf;
    L_0x07cc:
        r23.close();	 Catch:{ IOException -> 0x07f5 }
    L_0x07cf:
        if (r24 == 0) goto L_0x07d4;
    L_0x07d1:
        r24.close();	 Catch:{ IOException -> 0x0803 }
    L_0x07d4:
        r26.Vu();
        goto L_0x0026;
    L_0x07d9:
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r26.Vn();
        r8 = r14;
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        goto L_0x07ca;
    L_0x07f5:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07cf;
    L_0x0803:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x07d4;
    L_0x0811:
        r2 = move-exception;
        r23 = r11;
        r24 = r12;
    L_0x0816:
        r3 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x0aa3 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 2;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0aa3 }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "url is %s ,filename is %s , error is %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0aa3 }
        r6 = 0;
        r0 = r26;
        r7 = r0.uri;	 Catch:{ all -> 0x0aa3 }
        r5[r6] = r7;	 Catch:{ all -> 0x0aa3 }
        r6 = 1;
        r0 = r26;
        r7 = r0.filename;	 Catch:{ all -> 0x0aa3 }
        r5[r6] = r7;	 Catch:{ all -> 0x0aa3 }
        r6 = 2;
        r2 = r2.toString();	 Catch:{ all -> 0x0aa3 }
        r5[r6] = r2;	 Catch:{ all -> 0x0aa3 }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ all -> 0x0aa3 }
        r0 = r26;
        r2 = r0.jbH;	 Catch:{ all -> 0x0aa3 }
        r0 = r26;
        r3 = r0.filename;	 Catch:{ all -> 0x0aa3 }
        r0 = r26;
        r4 = r0.uri;	 Catch:{ all -> 0x0aa3 }
        r5 = "ssl handshake error";
        r2.y(r3, r4, r5);	 Catch:{ all -> 0x0aa3 }
        if (r16 == 0) goto L_0x0881;
    L_0x0857:
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r26.Vn();
        r8 = r14;
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
    L_0x0872:
        if (r23 == 0) goto L_0x0877;
    L_0x0874:
        r23.close();	 Catch:{ IOException -> 0x089d }
    L_0x0877:
        if (r24 == 0) goto L_0x087c;
    L_0x0879:
        r24.close();	 Catch:{ IOException -> 0x08ab }
    L_0x087c:
        r26.Vu();
        goto L_0x0026;
    L_0x0881:
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r26.Vn();
        r8 = r14;
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        goto L_0x0872;
    L_0x089d:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0877;
    L_0x08ab:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x087c;
    L_0x08b9:
        r2 = move-exception;
        r23 = r11;
        r24 = r12;
    L_0x08be:
        r3 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x0aa3 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 4;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0aa3 }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "url is %s ,filename is %s , error is %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0aa3 }
        r6 = 0;
        r0 = r26;
        r7 = r0.uri;	 Catch:{ all -> 0x0aa3 }
        r5[r6] = r7;	 Catch:{ all -> 0x0aa3 }
        r6 = 1;
        r0 = r26;
        r7 = r0.filename;	 Catch:{ all -> 0x0aa3 }
        r5[r6] = r7;	 Catch:{ all -> 0x0aa3 }
        r6 = 2;
        r2 = r2.toString();	 Catch:{ all -> 0x0aa3 }
        r5[r6] = r2;	 Catch:{ all -> 0x0aa3 }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ all -> 0x0aa3 }
        r0 = r26;
        r2 = r0.jbH;	 Catch:{ all -> 0x0aa3 }
        r0 = r26;
        r3 = r0.filename;	 Catch:{ all -> 0x0aa3 }
        r0 = r26;
        r4 = r0.uri;	 Catch:{ all -> 0x0aa3 }
        r5 = "socket timeout";
        r2.y(r3, r4, r5);	 Catch:{ all -> 0x0aa3 }
        if (r16 == 0) goto L_0x0929;
    L_0x08ff:
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r26.Vn();
        r8 = r14;
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
    L_0x091a:
        if (r23 == 0) goto L_0x091f;
    L_0x091c:
        r23.close();	 Catch:{ IOException -> 0x0945 }
    L_0x091f:
        if (r24 == 0) goto L_0x0924;
    L_0x0921:
        r24.close();	 Catch:{ IOException -> 0x0953 }
    L_0x0924:
        r26.Vu();
        goto L_0x0026;
    L_0x0929:
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r26.Vn();
        r8 = r14;
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        goto L_0x091a;
    L_0x0945:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x091f;
    L_0x0953:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0924;
    L_0x0961:
        r2 = move-exception;
        r23 = r11;
        r24 = r12;
    L_0x0966:
        r3 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x0aa3 }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 5;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0aa3 }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "url is %s ,filename is %s , error is %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0aa3 }
        r6 = 0;
        r0 = r26;
        r7 = r0.uri;	 Catch:{ all -> 0x0aa3 }
        r5[r6] = r7;	 Catch:{ all -> 0x0aa3 }
        r6 = 1;
        r0 = r26;
        r7 = r0.filename;	 Catch:{ all -> 0x0aa3 }
        r5[r6] = r7;	 Catch:{ all -> 0x0aa3 }
        r6 = 2;
        r2 = r2.toString();	 Catch:{ all -> 0x0aa3 }
        r5[r6] = r2;	 Catch:{ all -> 0x0aa3 }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ all -> 0x0aa3 }
        r0 = r26;
        r2 = r0.jbH;	 Catch:{ all -> 0x0aa3 }
        r0 = r26;
        r3 = r0.filename;	 Catch:{ all -> 0x0aa3 }
        r0 = r26;
        r4 = r0.uri;	 Catch:{ all -> 0x0aa3 }
        r5 = "unknown error";
        r2.y(r3, r4, r5);	 Catch:{ all -> 0x0aa3 }
        if (r16 == 0) goto L_0x09d1;
    L_0x09a7:
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r26.Vn();
        r8 = r14;
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
    L_0x09c2:
        if (r23 == 0) goto L_0x09c7;
    L_0x09c4:
        r23.close();	 Catch:{ IOException -> 0x09ed }
    L_0x09c7:
        if (r24 == 0) goto L_0x09cc;
    L_0x09c9:
        r24.close();	 Catch:{ IOException -> 0x09fb }
    L_0x09cc:
        r26.Vu();
        goto L_0x0026;
    L_0x09d1:
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r26.Vn();
        r8 = r14;
        r10 = r13;
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        goto L_0x09c2;
    L_0x09ed:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x09c7;
    L_0x09fb:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x09cc;
    L_0x0a09:
        r2 = move-exception;
        r23 = r11;
        r24 = r12;
        r8 = r14;
        r10 = r13;
        r13 = r2;
    L_0x0a11:
        if (r16 == 0) goto L_0x0a3a;
    L_0x0a13:
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r11 = 1;
        r12 = r26.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
    L_0x0a2c:
        if (r23 == 0) goto L_0x0a31;
    L_0x0a2e:
        r23.close();	 Catch:{ IOException -> 0x0a54 }
    L_0x0a31:
        if (r24 == 0) goto L_0x0a36;
    L_0x0a33:
        r24.close();	 Catch:{ IOException -> 0x0a62 }
    L_0x0a36:
        r26.Vu();
        throw r13;
    L_0x0a3a:
        r0 = r26;
        r2 = r0.appId;
        r0 = r26;
        r3 = r0.jbk;
        r4 = "GET";
        r0 = r26;
        r5 = r0.uri;
        r6 = 0;
        r11 = 2;
        r12 = r26.Vn();
        com.tencent.mm.plugin.appbrand.report.a.e.a(r2, r3, r4, r5, r6, r8, r10, r11, r12);
        goto L_0x0a2c;
    L_0x0a54:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0a31;
    L_0x0a62:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0a36;
    L_0x0a70:
        r2 = move-exception;
        r13 = r2;
        r23 = r11;
        r24 = r12;
        r8 = r14;
        goto L_0x0a11;
    L_0x0a78:
        r2 = move-exception;
        r13 = r2;
        r23 = r11;
        r8 = r14;
        goto L_0x0a11;
    L_0x0a7e:
        r2 = move-exception;
        r13 = r2;
        r8 = r14;
        goto L_0x0a11;
    L_0x0a82:
        r2 = move-exception;
        r13 = r2;
        goto L_0x0a11;
    L_0x0a85:
        r2 = move-exception;
        r13 = r2;
        r8 = r4;
        goto L_0x0a11;
    L_0x0a89:
        r2 = move-exception;
        r23 = r13;
        r13 = r2;
        goto L_0x0a11;
    L_0x0a8e:
        r2 = move-exception;
        r23 = r13;
        r16 = r3;
        r13 = r2;
        goto L_0x0a11;
    L_0x0a96:
        r2 = move-exception;
        r23 = r13;
        r24 = r14;
        r8 = r16;
        r10 = r15;
        r13 = r2;
        r16 = r11;
        goto L_0x0a11;
    L_0x0aa3:
        r2 = move-exception;
        r8 = r14;
        r10 = r13;
        r13 = r2;
        goto L_0x0a11;
    L_0x0aa9:
        r2 = move-exception;
        r23 = r11;
        r24 = r12;
        r13 = r10;
        goto L_0x0966;
    L_0x0ab1:
        r2 = move-exception;
        r23 = r11;
        r13 = r10;
        goto L_0x0966;
    L_0x0ab7:
        r2 = move-exception;
        r13 = r10;
        goto L_0x0966;
    L_0x0abb:
        r2 = move-exception;
        r14 = r8;
        r13 = r10;
        goto L_0x0966;
    L_0x0ac0:
        r2 = move-exception;
        r14 = r4;
        r13 = r10;
        goto L_0x0966;
    L_0x0ac5:
        r2 = move-exception;
        r23 = r13;
        r14 = r8;
        r13 = r10;
        goto L_0x0966;
    L_0x0acc:
        r2 = move-exception;
        r23 = r13;
        r14 = r8;
        r16 = r3;
        r13 = r10;
        goto L_0x0966;
    L_0x0ad5:
        r2 = move-exception;
        r23 = r11;
        r24 = r12;
        r13 = r10;
        goto L_0x08be;
    L_0x0add:
        r2 = move-exception;
        r23 = r11;
        r13 = r10;
        goto L_0x08be;
    L_0x0ae3:
        r2 = move-exception;
        r13 = r10;
        goto L_0x08be;
    L_0x0ae7:
        r2 = move-exception;
        r14 = r8;
        r13 = r10;
        goto L_0x08be;
    L_0x0aec:
        r2 = move-exception;
        r14 = r4;
        r13 = r10;
        goto L_0x08be;
    L_0x0af1:
        r2 = move-exception;
        r23 = r13;
        r14 = r8;
        r13 = r10;
        goto L_0x08be;
    L_0x0af8:
        r2 = move-exception;
        r23 = r13;
        r14 = r8;
        r16 = r3;
        r13 = r10;
        goto L_0x08be;
    L_0x0b01:
        r2 = move-exception;
        r23 = r11;
        r24 = r12;
        r13 = r10;
        goto L_0x0816;
    L_0x0b09:
        r2 = move-exception;
        r23 = r11;
        r13 = r10;
        goto L_0x0816;
    L_0x0b0f:
        r2 = move-exception;
        r13 = r10;
        goto L_0x0816;
    L_0x0b13:
        r2 = move-exception;
        r14 = r8;
        r13 = r10;
        goto L_0x0816;
    L_0x0b18:
        r2 = move-exception;
        r14 = r4;
        r13 = r10;
        goto L_0x0816;
    L_0x0b1d:
        r2 = move-exception;
        r23 = r13;
        r14 = r8;
        r13 = r10;
        goto L_0x0816;
    L_0x0b24:
        r2 = move-exception;
        r23 = r13;
        r14 = r8;
        r16 = r3;
        r13 = r10;
        goto L_0x0816;
    L_0x0b2d:
        r2 = move-exception;
        r23 = r11;
        r24 = r12;
        r13 = r10;
        goto L_0x076e;
    L_0x0b35:
        r2 = move-exception;
        r23 = r11;
        r13 = r10;
        goto L_0x076e;
    L_0x0b3b:
        r2 = move-exception;
        r13 = r10;
        goto L_0x076e;
    L_0x0b3f:
        r2 = move-exception;
        r14 = r8;
        r13 = r10;
        goto L_0x076e;
    L_0x0b44:
        r2 = move-exception;
        r14 = r4;
        r13 = r10;
        goto L_0x076e;
    L_0x0b49:
        r2 = move-exception;
        r23 = r13;
        r14 = r8;
        r13 = r10;
        goto L_0x076e;
    L_0x0b50:
        r2 = move-exception;
        r23 = r13;
        r14 = r8;
        r16 = r3;
        r13 = r10;
        goto L_0x076e;
    L_0x0b59:
        r2 = move-exception;
        r13 = r11;
        r11 = r16;
        r16 = r14;
        r15 = r10;
        r14 = r12;
        goto L_0x01b7;
    L_0x0b63:
        r2 = move-exception;
        r13 = r11;
        r11 = r16;
        r16 = r14;
        r15 = r10;
        r14 = r24;
        goto L_0x01b7;
    L_0x0b6e:
        r2 = move-exception;
        r13 = r23;
        r11 = r16;
        r16 = r14;
        r15 = r10;
        r14 = r24;
        goto L_0x01b7;
    L_0x0b7a:
        r2 = move-exception;
        r13 = r23;
        r14 = r24;
        r15 = r10;
        r11 = r16;
        r16 = r8;
        goto L_0x01b7;
    L_0x0b86:
        r2 = move-exception;
        r13 = r23;
        r14 = r24;
        r15 = r10;
        r11 = r16;
        r16 = r4;
        goto L_0x01b7;
    L_0x0b92:
        r2 = move-exception;
        r14 = r24;
        r15 = r10;
        r11 = r16;
        r16 = r8;
        goto L_0x01b7;
    L_0x0b9c:
        r2 = move-exception;
        r14 = r24;
        r16 = r8;
        r15 = r10;
        r11 = r3;
        goto L_0x01b7;
    L_0x0ba5:
        r8 = r4;
        goto L_0x053e;
    L_0x0ba8:
        r13 = r11;
        r8 = r14;
        goto L_0x067f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.f.a.b.run():void");
    }

    public final void Vu() {
        this.aJi = false;
        if (this.jbL != null) {
            this.jbL.disconnect();
        }
    }

    private int Vn() {
        return (int) (System.currentTimeMillis() - this.startTime);
    }
}
