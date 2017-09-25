package com.tencent.mm.p;

import android.content.ContentValues;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;

public final class e extends i<d> {
    public static final String[] gUx = new String[]{i.a(d.gTP, "FunctionMsgItem")};
    private static final String[] gUy = new String[]{"*", "rowid"};
    private com.tencent.mm.sdk.e.e gUz;

    public final com.tencent.mm.p.d dO(java.lang.String r10) {
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
        r4 = 1;
        r6 = 0;
        r5 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r10);
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return r5;
    L_0x000a:
        r0 = "MicroMsg.FunctionMsgStorage";
        r1 = "getByFunctionMsgId, functionMsgId: %s";
        r2 = new java.lang.Object[r4];
        r2[r6] = r10;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        r0 = r9.gUz;
        r1 = "FunctionMsgItem";
        r2 = gUy;
        r3 = "functionmsgid=?";
        r4 = new java.lang.String[r4];
        r4[r6] = r10;
        r8 = 2;
        r6 = r5;
        r7 = r5;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        if (r0 == 0) goto L_0x0041;	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
    L_0x0032:
        r0 = new com.tencent.mm.p.d;	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r0.<init>();	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r0.b(r1);	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        if (r1 == 0) goto L_0x003f;
    L_0x003c:
        r1.close();
    L_0x003f:
        r5 = r0;
        goto L_0x0009;
    L_0x0041:
        if (r1 == 0) goto L_0x0009;
    L_0x0043:
        r1.close();
        goto L_0x0009;
    L_0x0047:
        r0 = move-exception;
        r2 = "MicroMsg.FunctionMsgStorage";	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r3 = "getByFunctionMsgId error: %s";	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r4 = 1;	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r6 = 0;	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r4[r6] = r0;	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        if (r1 == 0) goto L_0x0009;
    L_0x005d:
        r1.close();
        goto L_0x0009;
    L_0x0061:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0067;
    L_0x0064:
        r1.close();
    L_0x0067:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.p.e.dO(java.lang.String):com.tencent.mm.p.d");
    }

    public final java.util.List<com.tencent.mm.p.d> ua() {
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
        r4 = 1;
        r7 = 0;
        r5 = 0;
        r0 = r9.gUz;
        r1 = "FunctionMsgItem";
        r2 = gUy;
        r3 = "status<?";
        r4 = new java.lang.String[r4];
        r6 = "2";
        r4[r7] = r6;
        r8 = 2;
        r6 = r5;
        r7 = r5;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        if (r1 != 0) goto L_0x001e;
    L_0x001d:
        return r5;
    L_0x001e:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        if (r0 == 0) goto L_0x0041;	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
    L_0x0024:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r0.<init>();	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
    L_0x0029:
        r2 = new com.tencent.mm.p.d;	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r2.<init>();	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r2.b(r1);	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r0.add(r2);	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r2 = r1.moveToNext();	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        if (r2 != 0) goto L_0x0029;
    L_0x003a:
        if (r1 == 0) goto L_0x003f;
    L_0x003c:
        r1.close();
    L_0x003f:
        r5 = r0;
        goto L_0x001d;
    L_0x0041:
        if (r1 == 0) goto L_0x001d;
    L_0x0043:
        r1.close();
        goto L_0x001d;
    L_0x0047:
        r0 = move-exception;
        r2 = "MicroMsg.FunctionMsgStorage";	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r3 = "getAllNeedFetchFunctionMsg error: %s";	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r4 = 1;	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r6 = 0;	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r4[r6] = r0;	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        if (r1 == 0) goto L_0x001d;
    L_0x005d:
        r1.close();
        goto L_0x001d;
    L_0x0061:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0067;
    L_0x0064:
        r1.close();
    L_0x0067:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.p.e.ua():java.util.List<com.tencent.mm.p.d>");
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, d.gTP, "FunctionMsgItem", null);
        this.gUz = eVar;
    }

    public final void a(String str, d dVar) {
        w.i("MicroMsg.FunctionMsgStorage", "updateByFunctionMsgId, functionMsgId: %s", str);
        d dO = dO(str);
        if (dO != null) {
            try {
                String str2 = "MicroMsg.FunctionMsgStorage";
                String str3 = "updateByFunctionMsgId, functionMsgId: %s, newFunctionMsgItem.msgContent==null: %s,oldFunctionMsgItem.msgContent==null: %s";
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(dVar.field_addMsg == null);
                objArr[2] = Boolean.valueOf(dO.field_addMsg == null);
                w.i(str2, str3, objArr);
                ContentValues pv = dVar.pv();
                if (pv.get("addMsg") == null && dO.field_addMsg != null) {
                    pv.put("addMsg", dO.field_addMsg.toByteArray());
                }
                int update = this.gUz.update("FunctionMsgItem", pv, "functionmsgid=?", new String[]{str});
                w.i("MicroMsg.FunctionMsgStorage", "updateByFunctionMsgId, ret: %s", Integer.valueOf(update));
            } catch (Exception e) {
                w.e("MicroMsg.FunctionMsgStorage", "updateByFunctionMsgId error: %s", e.getMessage());
            }
        }
    }
}
