package com.tencent.mm.plugin.aa.a.b;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class b extends i<a> {
    public static final String[] gUx = new String[]{i.a(a.gTP, "AAPayRecord")};
    private static final String[] ioi = new String[]{"*", "rowid"};
    private e gUz;

    public final com.tencent.mm.plugin.aa.a.b.a mI(java.lang.String r10) {
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
        r9 = this;
        r4 = 1;
        r6 = 0;
        r5 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r10);
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return r5;
    L_0x000a:
        r0 = r9.gUz;
        r1 = "AAPayRecord";
        r2 = ioi;
        r3 = "payMsgId=?";
        r4 = new java.lang.String[r4];
        r4[r6] = r10;
        r8 = 2;
        r6 = r5;
        r7 = r5;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        if (r0 == 0) goto L_0x0034;	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
    L_0x0025:
        r0 = new com.tencent.mm.plugin.aa.a.b.a;	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        r0.<init>();	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        r0.b(r1);	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        if (r1 == 0) goto L_0x0032;
    L_0x002f:
        r1.close();
    L_0x0032:
        r5 = r0;
        goto L_0x0009;
    L_0x0034:
        if (r1 == 0) goto L_0x0009;
    L_0x0036:
        r1.close();
        goto L_0x0009;
    L_0x003a:
        r0 = move-exception;
        r2 = "MicroMsg.AAPayRecordStorage";	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        r3 = "getByPayMsgId error: %s";	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        r4 = 1;	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        r6 = 0;	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        r4[r6] = r0;	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        if (r1 == 0) goto L_0x0009;
    L_0x0050:
        r1.close();
        goto L_0x0009;
    L_0x0054:
        r0 = move-exception;
        if (r1 == 0) goto L_0x005a;
    L_0x0057:
        r1.close();
    L_0x005a:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.aa.a.b.b.mI(java.lang.String):com.tencent.mm.plugin.aa.a.b.a");
    }

    public b(e eVar) {
        super(eVar, a.gTP, "AAPayRecord", null);
        this.gUz = eVar;
    }
}
