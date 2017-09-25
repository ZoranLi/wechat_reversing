package com.tencent.mm.plugin.appbrand.jsapi;

public final class p extends a {
    public static final int CTRL_INDEX = 250;
    public static final String NAME = "captureScreen";

    public final void a(com.tencent.mm.plugin.appbrand.m r9, org.json.JSONObject r10, int r11) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r4 = 0;
        r7 = 0;
        r6 = 1;
        r0 = r9.ivH;
        r1 = "MicroMsg.JsApiCaptureScreen";
        r2 = "captureScreen, appId:%s";
        r3 = new java.lang.Object[r6];
        r3[r7] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
        r1 = com.tencent.mm.plugin.appbrand.jsapi.d.b(r9);
        if (r1 == 0) goto L_0x010b;
    L_0x0018:
        r1 = r1.jcb;
        r1 = com.tencent.mm.sdk.platformtools.d.cV(r1);
        r2 = new java.lang.StringBuilder;
        r3 = "appbrand_capture_";
        r2.<init>(r3);
        r4 = java.lang.System.currentTimeMillis();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r2 = com.tencent.mm.plugin.appbrand.appstorage.c.aC(r0, r2);
        r3 = "MicroMsg.JsApiCaptureScreen";
        r4 = "capture bitmap path:%s";
        r5 = new java.lang.Object[r6];
        r5[r7] = r2;
        com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);
        r3 = 100;
        r4 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r5 = 1;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        com.tencent.mm.sdk.platformtools.d.a(r1, r3, r4, r2, r5);	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r3 = "png";	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r4 = 1;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r0 = com.tencent.mm.plugin.appbrand.appstorage.c.b(r0, r2, r3, r4);	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        if (r0 != 0) goto L_0x007b;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
    L_0x0055:
        r0 = "MicroMsg.JsApiCaptureScreen";	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r3 = "create temp file failed, path:%s";	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r4 = 1;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r5 = 0;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r4[r5] = r2;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        com.tencent.mm.sdk.platformtools.w.w(r0, r3, r4);	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r0 = "fail:gen temp file failed";	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r2 = 0;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r0 = r8.d(r0, r2);	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r9.x(r11, r0);	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        if (r1 == 0) goto L_0x007a;
    L_0x0071:
        r0 = r1.isRecycled();
        if (r0 != 0) goto L_0x007a;
    L_0x0077:
        r1.recycle();
    L_0x007a:
        return;
    L_0x007b:
        r2 = new java.util.HashMap;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r2.<init>();	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r3 = "tempFilePath";	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r4 = r0.fJz;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r2.put(r3, r4);	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r3 = "MicroMsg.JsApiCaptureScreen";	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r4 = "capture bitmap tempFilePath:%s";	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r5 = 1;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r5 = new java.lang.Object[r5];	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r6 = 0;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r0 = r0.fJz;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r5[r6] = r0;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r0 = "ok";	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r0 = r8.d(r0, r2);	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r9.x(r11, r0);	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        if (r1 == 0) goto L_0x007a;
    L_0x00a5:
        r0 = r1.isRecycled();
        if (r0 != 0) goto L_0x007a;
    L_0x00ab:
        r1.recycle();
        goto L_0x007a;
    L_0x00af:
        r0 = move-exception;
        r2 = "MicroMsg.JsApiCaptureScreen";	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r3 = "save bitmap to file failed, . exception : %s";	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r4 = 1;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r5 = 0;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r4[r5] = r0;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        com.tencent.mm.sdk.platformtools.w.w(r2, r3, r4);	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r0 = "fail:IOException";	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r2 = 0;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r0 = r8.d(r0, r2);	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r9.x(r11, r0);	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        if (r1 == 0) goto L_0x007a;
    L_0x00cc:
        r0 = r1.isRecycled();
        if (r0 != 0) goto L_0x007a;
    L_0x00d2:
        r1.recycle();
        goto L_0x007a;
    L_0x00d6:
        r0 = move-exception;
        r2 = "MicroMsg.JsApiCaptureScreen";	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r3 = "save bitmap to file failed, . exception : %s";	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r4 = 1;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r5 = 0;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r4[r5] = r0;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        com.tencent.mm.sdk.platformtools.w.w(r2, r3, r4);	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r0 = "fail:Exception";	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r2 = 0;	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r0 = r8.d(r0, r2);	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        r9.x(r11, r0);	 Catch:{ IOException -> 0x00af, Exception -> 0x00d6, all -> 0x00fe }
        if (r1 == 0) goto L_0x007a;
    L_0x00f3:
        r0 = r1.isRecycled();
        if (r0 != 0) goto L_0x007a;
    L_0x00f9:
        r1.recycle();
        goto L_0x007a;
    L_0x00fe:
        r0 = move-exception;
        if (r1 == 0) goto L_0x010a;
    L_0x0101:
        r2 = r1.isRecycled();
        if (r2 != 0) goto L_0x010a;
    L_0x0107:
        r1.recycle();
    L_0x010a:
        throw r0;
    L_0x010b:
        r0 = "MicroMsg.JsApiCaptureScreen";
        r1 = "captureScreen, container or pageView is null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        r0 = "fail:container or pageView is null";
        r0 = r8.d(r0, r4);
        r9.x(r11, r0);
        goto L_0x007a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.p.a(com.tencent.mm.plugin.appbrand.m, org.json.JSONObject, int):void");
    }
}
