package com.tencent.mm.plugin.remittance.b;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class b extends i<a> {
    public static final String[] gUx = new String[]{i.a(a.gTP, "DelayTransferRecord")};
    private static final String[] ioi = new String[]{"*", "rowid"};
    private e gUz;

    public final com.tencent.mm.plugin.remittance.b.a Ds(java.lang.String r10) {
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
        r9 = this;
        r6 = 0;
        r5 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r10);
        if (r0 == 0) goto L_0x0012;
    L_0x0008:
        r0 = "MicroMsg.AARecordStorage";
        r1 = "empty transferId";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
    L_0x0011:
        return r5;
    L_0x0012:
        r0 = r9.gUz;
        r1 = "DelayTransferRecord";
        r2 = ioi;
        r3 = "transferId=?";
        r4 = 1;
        r4 = new java.lang.String[r4];
        r4[r6] = r10;
        r8 = 2;
        r6 = r5;
        r7 = r5;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0043, all -> 0x0056 }
        if (r0 == 0) goto L_0x003d;	 Catch:{ Exception -> 0x0043, all -> 0x0056 }
    L_0x002e:
        r0 = new com.tencent.mm.plugin.remittance.b.a;	 Catch:{ Exception -> 0x0043, all -> 0x0056 }
        r0.<init>();	 Catch:{ Exception -> 0x0043, all -> 0x0056 }
        r0.b(r1);	 Catch:{ Exception -> 0x0043, all -> 0x0056 }
        if (r1 == 0) goto L_0x003b;
    L_0x0038:
        r1.close();
    L_0x003b:
        r5 = r0;
        goto L_0x0011;
    L_0x003d:
        if (r1 == 0) goto L_0x0011;
    L_0x003f:
        r1.close();
        goto L_0x0011;
    L_0x0043:
        r0 = move-exception;
        r2 = "MicroMsg.AARecordStorage";	 Catch:{ Exception -> 0x0043, all -> 0x0056 }
        r3 = "";	 Catch:{ Exception -> 0x0043, all -> 0x0056 }
        r4 = 0;	 Catch:{ Exception -> 0x0043, all -> 0x0056 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0043, all -> 0x0056 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r0, r3, r4);	 Catch:{ Exception -> 0x0043, all -> 0x0056 }
        if (r1 == 0) goto L_0x0011;
    L_0x0052:
        r1.close();
        goto L_0x0011;
    L_0x0056:
        r0 = move-exception;
        if (r1 == 0) goto L_0x005c;
    L_0x0059:
        r1.close();
    L_0x005c:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.remittance.b.b.Ds(java.lang.String):com.tencent.mm.plugin.remittance.b.a");
    }

    public b(e eVar) {
        super(eVar, a.gTP, "DelayTransferRecord", null);
        this.gUz = eVar;
    }
}
