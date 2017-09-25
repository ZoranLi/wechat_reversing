package com.tencent.mm.plugin.appbrand.g;

import com.tencent.mm.modelappbrand.a.b.c;
import com.tencent.mm.modelappbrand.a.b.i;

public final class l {
    private static final i jcV = new c();

    public static android.graphics.Bitmap g(com.tencent.mm.plugin.appbrand.h r7, java.lang.String r8) {
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
        r0 = 0;
        if (r7 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r2 = com.tencent.mm.plugin.appbrand.appcache.a.nz(r8);
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r1 != 0) goto L_0x0003;
    L_0x000e:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = r7.hashCode();
        r3 = r3 + 35;
        r1 = r1.append(r3);
        r1 = r1.append(r2);
        r3 = r1.toString();
        r1 = jcV;
        r1 = r1.gS(r3);
        if (r1 == 0) goto L_0x0035;
    L_0x002d:
        r4 = r1.isRecycled();
        if (r4 != 0) goto L_0x0035;
    L_0x0033:
        r0 = r1;
        goto L_0x0003;
    L_0x0035:
        r2 = com.tencent.mm.plugin.appbrand.appcache.l.d(r7, r2);
        if (r2 == 0) goto L_0x0041;
    L_0x003b:
        r1 = r2.available();	 Catch:{ IOException -> 0x0065, all -> 0x007b }
        if (r1 > 0) goto L_0x0047;
    L_0x0041:
        if (r2 == 0) goto L_0x0003;
    L_0x0043:
        com.tencent.mm.sdk.platformtools.bg.g(r2);
        goto L_0x0003;
    L_0x0047:
        r1 = com.tencent.mm.sdk.platformtools.d.decodeStream(r2);	 Catch:{ IOException -> 0x0065, all -> 0x007b }
        if (r1 == 0) goto L_0x005f;	 Catch:{ IOException -> 0x0065, all -> 0x007b }
    L_0x004d:
        r4 = r1.isRecycled();	 Catch:{ IOException -> 0x0065, all -> 0x007b }
        if (r4 != 0) goto L_0x005f;	 Catch:{ IOException -> 0x0065, all -> 0x007b }
    L_0x0053:
        r4 = jcV;	 Catch:{ IOException -> 0x0065, all -> 0x007b }
        r4.b(r3, r1);	 Catch:{ IOException -> 0x0065, all -> 0x007b }
        if (r2 == 0) goto L_0x005d;
    L_0x005a:
        com.tencent.mm.sdk.platformtools.bg.g(r2);
    L_0x005d:
        r0 = r1;
        goto L_0x0003;
    L_0x005f:
        if (r2 == 0) goto L_0x0003;
    L_0x0061:
        com.tencent.mm.sdk.platformtools.bg.g(r2);
        goto L_0x0003;
    L_0x0065:
        r1 = move-exception;
        r3 = "MicroMsg.AppBrandPageIconCache";	 Catch:{ IOException -> 0x0065, all -> 0x007b }
        r4 = "try decode icon e = %s";	 Catch:{ IOException -> 0x0065, all -> 0x007b }
        r5 = 1;	 Catch:{ IOException -> 0x0065, all -> 0x007b }
        r5 = new java.lang.Object[r5];	 Catch:{ IOException -> 0x0065, all -> 0x007b }
        r6 = 0;	 Catch:{ IOException -> 0x0065, all -> 0x007b }
        r5[r6] = r1;	 Catch:{ IOException -> 0x0065, all -> 0x007b }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ IOException -> 0x0065, all -> 0x007b }
        if (r2 == 0) goto L_0x0003;
    L_0x0077:
        com.tencent.mm.sdk.platformtools.bg.g(r2);
        goto L_0x0003;
    L_0x007b:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0081;
    L_0x007e:
        com.tencent.mm.sdk.platformtools.bg.g(r2);
    L_0x0081:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.g.l.g(com.tencent.mm.plugin.appbrand.h, java.lang.String):android.graphics.Bitmap");
    }
}
