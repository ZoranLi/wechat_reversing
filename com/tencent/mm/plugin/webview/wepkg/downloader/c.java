package com.tencent.mm.plugin.webview.wepkg.downloader;

import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.util.concurrent.Future;
import javax.net.ssl.SSLContext;

public final class c implements Runnable {
    private int fEX = 0;
    private String mContentType;
    private int mStatusCode;
    f sph;
    Future<?> spi;
    HttpURLConnection spj;
    private String spk;
    private String spl;
    private String spm;
    boolean spn;
    private boolean spo;
    private boolean spp = false;

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r15 = this;
        r14 = 2;
        r6 = -1;
        r13 = 1013; // 0x3f5 float:1.42E-42 double:5.005E-321;
        r7 = 1;
        r8 = 0;
        r0 = r15.sph;
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r0 = r15.sph;
        r0 = r0.mUrl;
        if (r0 == 0) goto L_0x000a;
    L_0x0011:
        r0 = r15.sph;
        r9 = r0.laN;
        r5 = r8;
    L_0x0016:
        r1 = new java.net.URL;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.sph;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r0.mUrl;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1.<init>(r0);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r1.openConnection();	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r15.spj = r0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.spj;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = r15.sph;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = r2.spK;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.spj;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = r15.sph;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = r2.spL;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setReadTimeout(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.spj;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = 0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setUseCaches(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.spj;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = 1;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setDoInput(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.spj;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = "GET";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setRequestMethod(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.spj;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = 0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setDoOutput(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.spj;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = 1;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setInstanceFollowRedirects(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.spj;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = "Accept-Encoding";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3 = "identity";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setRequestProperty(r2, r3);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = "http.agent";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = java.lang.System.getProperty(r0);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r0);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r2 != 0) goto L_0x0079;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x0071:
        r2 = r15.spj;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3 = "User-agent";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2.setRequestProperty(r3, r0);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x0079:
        r0 = r15.sph;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r0.spM;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 == 0) goto L_0x0177;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x007f:
        r0 = r15.sph;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r0.mFilePath;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = com.tencent.mm.pluginsdk.k.a.e.a.BA(r0);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r4 = "%s: RangeOffset = %d";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10 = 2;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r11 = 0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r12 = r15.sph;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r12 = r12.spE;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10[r11] = r12;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r11 = 1;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r12 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10[r11] = r12;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        com.tencent.mm.sdk.platformtools.w.i(r0, r4, r10);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10 = 0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 != 0) goto L_0x0155;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x00a7:
        r0 = r8;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x00a8:
        r15.spo = r0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x00aa:
        r0 = "https";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = r1.getProtocol();	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r0.equalsIgnoreCase(r1);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 == 0) goto L_0x00e8;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x00b7:
        r0 = r15.sph;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = r0.spK;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.spj;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = "TLSv1.2";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = Kx(r1);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r1 != 0) goto L_0x00d5;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x00c8:
        r1 = "TLSv1";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = Kx(r1);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r1 != 0) goto L_0x00d5;
    L_0x00d1:
        r1 = javax.net.ssl.SSLContext.getDefault();	 Catch:{ Exception -> 0x02c6 }
    L_0x00d5:
        if (r1 == 0) goto L_0x01ec;
    L_0x00d7:
        r3 = 0;
        r4 = 0;
        r10 = new java.security.SecureRandom;	 Catch:{ Exception -> 0x01eb }
        r10.<init>();	 Catch:{ Exception -> 0x01eb }
        r1.init(r3, r4, r10);	 Catch:{ Exception -> 0x01eb }
        r1 = r1.getSocketFactory();	 Catch:{ Exception -> 0x01eb }
        r0.setSSLSocketFactory(r1);	 Catch:{ Exception -> 0x01eb }
    L_0x00e8:
        r15.bAs();	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = "handle responose retcode:%s";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = 1;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3 = 0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r4 = r15.fEX;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.fEX;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 != 0) goto L_0x0237;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x0104:
        r0 = r15.sph;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r0.spN;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 == 0) goto L_0x028c;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x010a:
        r0 = r15.sph;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10 = r0.spN;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = new com.tencent.mm.plugin.webview.wepkg.downloader.g;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = r15.sph;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = 1;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3 = 0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r4 = r15.spp;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r4 == 0) goto L_0x0234;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x0118:
        r4 = r7;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x0119:
        r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10.a(r0);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.sph;
        r0 = r0.mUrl;
        r1 = "https";
        r0 = r0.startsWith(r1);
        if (r0 == 0) goto L_0x000a;
    L_0x012c:
        r0 = r15.fEX;
        if (r0 != r13) goto L_0x000a;
    L_0x0130:
        r0 = r9 + -1;
        if (r5 < r0) goto L_0x000a;
    L_0x0134:
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r1 = "change https to http request";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        r0 = r15.sph;
        r1 = r15.sph;
        r1 = r1.mUrl;
        r2 = "https";
        r3 = "http";
        r1 = r1.replaceFirst(r2, r3);
        r0.mUrl = r1;
        r15.fEX = r8;
        r15.spp = r8;
        goto L_0x000a;
    L_0x0155:
        r0 = r15.spj;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r4 = "Range";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r11 = "bytes=";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10.<init>(r11);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = r10.append(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3 = "-";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.addRequestProperty(r4, r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r7;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        goto L_0x00a8;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x0177:
        r0 = r15.sph;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r0.mFilePath;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        com.tencent.mm.pluginsdk.k.a.e.a.My(r0);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        goto L_0x00aa;
    L_0x0180:
        r0 = move-exception;
        r1 = "MicroMsg.Wepkg.WePkgDownloadTask";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = "run exception : %s";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3 = 1;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r4 = 0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3[r4] = r0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        com.tencent.mm.sdk.platformtools.w.e(r1, r2, r3);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.sph;
        r0 = r0.mUrl;
        r1 = "https";
        r0 = r0.startsWith(r1);
        if (r0 == 0) goto L_0x01c9;
    L_0x01a1:
        r0 = r15.fEX;
        if (r0 != r13) goto L_0x01c9;
    L_0x01a5:
        r0 = r9 + -1;
        if (r5 < r0) goto L_0x01c9;
    L_0x01a9:
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r1 = "change https to http request";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        r0 = r15.sph;
        r1 = r15.sph;
        r1 = r1.mUrl;
        r2 = "https";
        r3 = "http";
        r1 = r1.replaceFirst(r2, r3);
        r0.mUrl = r1;
        r15.fEX = r8;
        r15.spp = r8;
        r5 = r6;
    L_0x01c9:
        r5 = r5 + 1;
        if (r5 < r9) goto L_0x0016;
    L_0x01cd:
        r0 = r15.sph;
        r0 = r0.spN;
        if (r0 == 0) goto L_0x000a;
    L_0x01d3:
        r0 = r15.sph;
        r6 = r0.spN;
        r0 = new com.tencent.mm.plugin.webview.wepkg.downloader.g;
        r1 = r15.sph;
        r3 = r15.fEX;
        r2 = r15.spp;
        if (r2 == 0) goto L_0x02c3;
    L_0x01e1:
        r4 = r7;
    L_0x01e2:
        r2 = r14;
        r0.<init>(r1, r2, r3, r4, r5);
        r6.a(r0);
        goto L_0x000a;
    L_0x01eb:
        r1 = move-exception;
    L_0x01ec:
        r1 = new android.net.SSLSessionCache;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1.<init>(r3);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = android.net.SSLCertificateSocketFactory.getDefault(r2, r1);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setSSLSocketFactory(r1);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        goto L_0x00e8;
    L_0x01fe:
        r0 = move-exception;
        r1 = r15.sph;
        r1 = r1.mUrl;
        r2 = "https";
        r1 = r1.startsWith(r2);
        if (r1 == 0) goto L_0x0233;
    L_0x020c:
        r1 = r15.fEX;
        if (r1 != r13) goto L_0x0233;
    L_0x0210:
        r1 = r9 + -1;
        if (r5 < r1) goto L_0x0233;
    L_0x0214:
        r1 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r2 = "change https to http request";
        com.tencent.mm.sdk.platformtools.w.i(r1, r2);
        r1 = r15.sph;
        r2 = r15.sph;
        r2 = r2.mUrl;
        r3 = "https";
        r4 = "http";
        r2 = r2.replaceFirst(r3, r4);
        r1.mUrl = r2;
        r15.fEX = r8;
        r15.spp = r8;
    L_0x0233:
        throw r0;
    L_0x0234:
        r4 = r8;
        goto L_0x0119;
    L_0x0237:
        r0 = r15.fEX;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = 1011; // 0x3f3 float:1.417E-42 double:4.995E-321;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 == r1) goto L_0x0255;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x023d:
        r0 = r15.fEX;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 == r1) goto L_0x0255;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x0243:
        r0 = r15.fEX;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = 1009; // 0x3f1 float:1.414E-42 double:4.985E-321;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 == r1) goto L_0x0255;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x0249:
        r0 = r15.fEX;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 == r1) goto L_0x0255;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x024f:
        r0 = r15.fEX;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = 1007; // 0x3ef float:1.411E-42 double:4.975E-321;
        if (r0 != r1) goto L_0x028c;
    L_0x0255:
        r0 = r15.sph;
        r0 = r0.mUrl;
        r1 = "https";
        r0 = r0.startsWith(r1);
        if (r0 == 0) goto L_0x01cd;
    L_0x0262:
        r0 = r15.fEX;
        if (r0 != r13) goto L_0x01cd;
    L_0x0266:
        r0 = r9 + -1;
        if (r5 < r0) goto L_0x01cd;
    L_0x026a:
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r1 = "change https to http request";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        r0 = r15.sph;
        r1 = r15.sph;
        r1 = r1.mUrl;
        r2 = "https";
        r3 = "http";
        r1 = r1.replaceFirst(r2, r3);
        r0.mUrl = r1;
        r15.fEX = r8;
        r15.spp = r8;
        r5 = r6;
        goto L_0x01cd;
    L_0x028c:
        r0 = r15.sph;
        r0 = r0.mUrl;
        r1 = "https";
        r0 = r0.startsWith(r1);
        if (r0 == 0) goto L_0x01c9;
    L_0x0299:
        r0 = r15.fEX;
        if (r0 != r13) goto L_0x01c9;
    L_0x029d:
        r0 = r9 + -1;
        if (r5 < r0) goto L_0x01c9;
    L_0x02a1:
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r1 = "change https to http request";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        r0 = r15.sph;
        r1 = r15.sph;
        r1 = r1.mUrl;
        r2 = "https";
        r3 = "http";
        r1 = r1.replaceFirst(r2, r3);
        r0.mUrl = r1;
        r15.fEX = r8;
        r15.spp = r8;
        r5 = r6;
        goto L_0x01c9;
    L_0x02c3:
        r4 = r8;
        goto L_0x01e2;
    L_0x02c6:
        r3 = move-exception;
        goto L_0x00d5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.wepkg.downloader.c.run():void");
    }

    public c(f fVar) {
        this.sph = fVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bAs() {
        /*
        r13 = this;
        r4 = 1;
        r3 = 0;
        r1 = 0;
        r0 = 0;
        r2 = r13.spj;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = r2.getResponseCode();	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r13.mStatusCode = r2;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r5 = "%s: received status code = %d";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r7 = 0;
        r8 = r13.sph;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r8 = r8.spE;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r7 = 1;
        r8 = r13.mStatusCode;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r5, r6);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = r13.mStatusCode;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        switch(r2) {
            case 200: goto L_0x0038;
            case 206: goto L_0x0038;
            default: goto L_0x002d;
        };	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
    L_0x002d:
        r2 = r13.mStatusCode;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r13.fEX = r2;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
    L_0x0031:
        com.tencent.mm.pluginsdk.k.a.e.a.f(r1);
        com.tencent.mm.pluginsdk.k.a.e.a.f(r0);
    L_0x0037:
        return;
    L_0x0038:
        r2 = r13.spj;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r5 = "Content-Type";
        r2 = r2.getHeaderField(r5);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r13.mContentType = r2;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = r13.spj;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2.getHeaderFields();	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = r13.spj;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r5 = "Content-Range";
        r2 = r2.getHeaderField(r5);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r13.spk = r2;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = r13.spj;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r5 = "Content-Length";
        r2 = r2.getHeaderField(r5);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r13.spl = r2;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = r13.spj;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r5 = "bytes";
        r6 = "Accept-Ranges";
        r2 = r2.getHeaderField(r6);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = r5.equals(r2);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        if (r2 == 0) goto L_0x00ed;
    L_0x0070:
        r2 = r4;
    L_0x0071:
        r5 = r13.spo;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        if (r5 == 0) goto L_0x0128;
    L_0x0075:
        if (r2 != 0) goto L_0x0102;
    L_0x0077:
        r5 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r6 = "Header no Accept-Ranges, not support range";
        com.tencent.mm.sdk.platformtools.w.i(r5, r6);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r5 = r13.sph;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r5 = r5.mFilePath;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        com.tencent.mm.pluginsdk.k.a.e.a.My(r5);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r5 = r13.spl;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r6 = Kz(r5);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r5 = r2;
    L_0x008e:
        r13.spp = r5;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r8 = "%s: content-range = %s, content-length = %s, content-type = %s, isSupportRange = %b";
        r9 = 5;
        r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r10 = 0;
        r11 = r13.sph;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r11 = r11.spE;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r9[r10] = r11;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r10 = 1;
        r11 = r13.spk;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r9[r10] = r11;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r10 = 2;
        r11 = r13.spl;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r9[r10] = r11;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r10 = 3;
        r11 = r13.mContentType;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r9[r10] = r11;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r10 = 4;
        r11 = java.lang.Boolean.valueOf(r5);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r9[r10] = r11;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r8, r9);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r8 = -1;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 != 0) goto L_0x013a;
    L_0x00bf:
        r2 = 1010; // 0x3f2 float:1.415E-42 double:4.99E-321;
        r13.fEX = r2;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        goto L_0x0031;
    L_0x00c5:
        r2 = move-exception;
        r12 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r12;
    L_0x00ca:
        r3 = r13.spn;	 Catch:{ all -> 0x026f }
        if (r3 == 0) goto L_0x025f;
    L_0x00ce:
        r3 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        r13.fEX = r3;	 Catch:{ all -> 0x026f }
    L_0x00d2:
        r3 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r4 = "exception : %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x026f }
        r6 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x026f }
        r5[r6] = r0;	 Catch:{ all -> 0x026f }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ all -> 0x026f }
        com.tencent.mm.pluginsdk.k.a.e.a.f(r2);
        com.tencent.mm.pluginsdk.k.a.e.a.f(r1);
        goto L_0x0037;
    L_0x00ed:
        r2 = r13.spk;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        if (r2 == 0) goto L_0x00ff;
    L_0x00f1:
        r2 = r13.spk;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r5 = "bytes";
        r2 = r2.startsWith(r5);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        if (r2 == 0) goto L_0x00ff;
    L_0x00fc:
        r2 = r4;
        goto L_0x0071;
    L_0x00ff:
        r2 = r3;
        goto L_0x0071;
    L_0x0102:
        r5 = r13.spk;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r5 = Ky(r5);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r6 = (long) r5;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r8 = -1;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 != 0) goto L_0x02b1;
    L_0x010f:
        r2 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r5 = "content-range in header is error, not support range";
        com.tencent.mm.sdk.platformtools.w.i(r2, r5);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = r13.sph;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = r2.mFilePath;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        com.tencent.mm.pluginsdk.k.a.e.a.My(r2);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = r13.spl;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r6 = Kz(r2);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r5 = r3;
        goto L_0x008e;
    L_0x0128:
        r2 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r5 = "local dont have download file. not support range";
        com.tencent.mm.sdk.platformtools.w.i(r2, r5);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = r13.spl;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r6 = Kz(r2);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r5 = r3;
        goto L_0x008e;
    L_0x013a:
        r2 = r13.sph;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r8 = r2.spI;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r10 = 0;
        r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r2 <= 0) goto L_0x017c;
    L_0x0144:
        r2 = r13.sph;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r8 = r2.spI;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 == 0) goto L_0x017c;
    L_0x014c:
        r2 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r3 = "ServerLength(%d) != HeaderLength(%d)";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r5 = 0;
        r8 = r13.sph;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r8 = r8.spI;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r4[r5] = r8;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r5 = 1;
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = 1011; // 0x3f3 float:1.417E-42 double:4.995E-321;
        r13.fEX = r2;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        goto L_0x0031;
    L_0x0170:
        r2 = move-exception;
        r12 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r12;
    L_0x0175:
        com.tencent.mm.pluginsdk.k.a.e.a.f(r2);
        com.tencent.mm.pluginsdk.k.a.e.a.f(r1);
        throw r0;
    L_0x017c:
        r2 = r13.spj;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = r2.getContentEncoding();	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r13.spm = r2;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = r13.spj;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r6 = r2.getInputStream();	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = r13.spm;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        if (r2 != 0) goto L_0x01e1;
    L_0x0192:
        r2 = r13.spm;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r7 = "gzip";
        r2 = r2.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        if (r2 == 0) goto L_0x01e1;
    L_0x019d:
        r2 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2.<init>(r6);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
    L_0x01a2:
        r1 = r13.sph;	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        r6 = r1.mFilePath;	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        r1 = r13.sph;	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        r1 = r1.spE;	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        r7 = r13.spo;	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        if (r7 == 0) goto L_0x01e7;
    L_0x01ae:
        if (r5 == 0) goto L_0x01e7;
    L_0x01b0:
        r7 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r8 = "%s: getOutputStream, filePath %s";
        r9 = 2;
        r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        r10 = 0;
        r9[r10] = r1;	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        r10 = 1;
        r9[r10] = r6;	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        com.tencent.mm.sdk.platformtools.w.d(r7, r8, r9);	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        r7 = com.tencent.mm.sdk.platformtools.bg.mA(r6);	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        if (r7 == 0) goto L_0x01e9;
    L_0x01c8:
        r3 = new java.io.FileNotFoundException;	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        r4 = "%s filePath is null or nil";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        r6 = 0;
        r5[r6] = r1;	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        r1 = java.lang.String.format(r4, r5);	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        r3.<init>(r1);	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        throw r3;	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
    L_0x01db:
        r1 = move-exception;
        r12 = r1;
        r1 = r0;
        r0 = r12;
        goto L_0x00ca;
    L_0x01e1:
        r2 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        r2.<init>(r6);	 Catch:{ Exception -> 0x00c5, all -> 0x0170 }
        goto L_0x01a2;
    L_0x01e7:
        r4 = r3;
        goto L_0x01b0;
    L_0x01e9:
        r1 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        r7 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        r7.<init>(r6, r4);	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        r1.<init>(r7);	 Catch:{ Exception -> 0x01db, all -> 0x02a8 }
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r4 = "%s: append = %b, isSupportRange = %s";
        r6 = 3;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x02ae }
        r7 = 0;
        r8 = r13.sph;	 Catch:{ Exception -> 0x02ae }
        r8 = r8.spE;	 Catch:{ Exception -> 0x02ae }
        r6[r7] = r8;	 Catch:{ Exception -> 0x02ae }
        r7 = 1;
        r8 = r13.spo;	 Catch:{ Exception -> 0x02ae }
        r8 = java.lang.Boolean.valueOf(r8);	 Catch:{ Exception -> 0x02ae }
        r6[r7] = r8;	 Catch:{ Exception -> 0x02ae }
        r7 = 2;
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ Exception -> 0x02ae }
        r6[r7] = r5;	 Catch:{ Exception -> 0x02ae }
        com.tencent.mm.sdk.platformtools.w.i(r0, r4, r6);	 Catch:{ Exception -> 0x02ae }
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r4 = new byte[r0];	 Catch:{ Exception -> 0x02ae }
        r0 = r3;
    L_0x021b:
        r3 = 0;
        r5 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r3 = r2.read(r4, r3, r5);	 Catch:{ Exception -> 0x02ae }
        r5 = -1;
        if (r3 == r5) goto L_0x022b;
    L_0x0225:
        r5 = 0;
        r1.write(r4, r5, r3);	 Catch:{ Exception -> 0x02ae }
        r0 = r0 + r3;
        goto L_0x021b;
    L_0x022b:
        r3 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r4 = "%s: read count = %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x02ae }
        r6 = 0;
        r7 = r13.sph;	 Catch:{ Exception -> 0x02ae }
        r7 = r7.mUrl;	 Catch:{ Exception -> 0x02ae }
        r5[r6] = r7;	 Catch:{ Exception -> 0x02ae }
        r6 = 1;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x02ae }
        r5[r6] = r0;	 Catch:{ Exception -> 0x02ae }
        com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);	 Catch:{ Exception -> 0x02ae }
        r1.flush();	 Catch:{ Exception -> 0x02ae }
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r3 = "%s: download complete, flush and send complete status";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x02ae }
        r5 = 0;
        r6 = r13.sph;	 Catch:{ Exception -> 0x02ae }
        r6 = r6.mUrl;	 Catch:{ Exception -> 0x02ae }
        r4[r5] = r6;	 Catch:{ Exception -> 0x02ae }
        com.tencent.mm.sdk.platformtools.w.i(r0, r3, r4);	 Catch:{ Exception -> 0x02ae }
        r0 = r1;
        r1 = r2;
        goto L_0x0031;
    L_0x025f:
        r3 = com.tencent.mm.u.ap.vd();	 Catch:{ all -> 0x026f }
        r3 = r3.BR();	 Catch:{ all -> 0x026f }
        if (r3 != 0) goto L_0x0272;
    L_0x0269:
        r3 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r13.fEX = r3;	 Catch:{ all -> 0x026f }
        goto L_0x00d2;
    L_0x026f:
        r0 = move-exception;
        goto L_0x0175;
    L_0x0272:
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r0 instanceof javax.net.ssl.SSLException;	 Catch:{ all -> 0x026f }
        if (r4 == 0) goto L_0x027e;
    L_0x0278:
        r3 = 1013; // 0x3f5 float:1.42E-42 double:5.005E-321;
    L_0x027a:
        r13.fEX = r3;	 Catch:{ all -> 0x026f }
        goto L_0x00d2;
    L_0x027e:
        r4 = r0 instanceof java.net.SocketTimeoutException;	 Catch:{ all -> 0x026f }
        if (r4 == 0) goto L_0x0285;
    L_0x0282:
        r3 = 1003; // 0x3eb float:1.406E-42 double:4.955E-321;
        goto L_0x027a;
    L_0x0285:
        r4 = r0 instanceof java.net.UnknownHostException;	 Catch:{ all -> 0x026f }
        if (r4 == 0) goto L_0x028c;
    L_0x0289:
        r3 = 1004; // 0x3ec float:1.407E-42 double:4.96E-321;
        goto L_0x027a;
    L_0x028c:
        r4 = r0 instanceof java.net.ConnectException;	 Catch:{ all -> 0x026f }
        if (r4 == 0) goto L_0x0293;
    L_0x0290:
        r3 = 1005; // 0x3ed float:1.408E-42 double:4.965E-321;
        goto L_0x027a;
    L_0x0293:
        r4 = r0 instanceof java.net.SocketException;	 Catch:{ all -> 0x026f }
        if (r4 == 0) goto L_0x029a;
    L_0x0297:
        r3 = 1006; // 0x3ee float:1.41E-42 double:4.97E-321;
        goto L_0x027a;
    L_0x029a:
        r4 = r0 instanceof java.io.IOException;	 Catch:{ all -> 0x026f }
        if (r4 == 0) goto L_0x02a1;
    L_0x029e:
        r3 = 1007; // 0x3ef float:1.411E-42 double:4.975E-321;
        goto L_0x027a;
    L_0x02a1:
        r4 = r0 instanceof java.lang.InterruptedException;	 Catch:{ all -> 0x026f }
        if (r4 == 0) goto L_0x027a;
    L_0x02a5:
        r3 = 1008; // 0x3f0 float:1.413E-42 double:4.98E-321;
        goto L_0x027a;
    L_0x02a8:
        r1 = move-exception;
        r12 = r1;
        r1 = r0;
        r0 = r12;
        goto L_0x0175;
    L_0x02ae:
        r0 = move-exception;
        goto L_0x00ca;
    L_0x02b1:
        r5 = r2;
        goto L_0x008e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.wepkg.downloader.c.bAs():void");
    }

    private static SSLContext Kx(String str) {
        try {
            return SSLContext.getInstance(str);
        } catch (Exception e) {
            return null;
        }
    }

    private static int Ky(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("/");
            if (split != null && split.length == 2) {
                try {
                    return Integer.valueOf(split[1]).intValue();
                } catch (NumberFormatException e) {
                }
            }
        }
        return -1;
    }

    private static long Kz(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.valueOf(str).longValue();
            } catch (NumberFormatException e) {
            }
        }
        return -1;
    }
}
