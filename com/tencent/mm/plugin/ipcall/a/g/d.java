package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Iterator;

public final class d extends i<c> {
    public static final String[] gUx = new String[]{i.a(c.gTP, "IPCallAddressItem")};
    public static final String[] mQX = new String[]{"*", "rowid"};
    public e gUz;

    public final java.util.ArrayList<com.tencent.mm.plugin.ipcall.a.g.c> aEP() {
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
        r3 = 0;
        r0 = r9.gUz;
        r1 = "IPCallAddressItem";
        r2 = mQX;
        r8 = 2;
        r4 = r3;
        r5 = r3;
        r6 = r3;
        r7 = r3;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        if (r1 == 0) goto L_0x0036;
    L_0x0013:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        if (r0 == 0) goto L_0x0036;	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
    L_0x0019:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r0.<init>();	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
    L_0x001e:
        r2 = new com.tencent.mm.plugin.ipcall.a.g.c;	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r2.<init>();	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r2.b(r1);	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r0.add(r2);	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r2 = r1.moveToNext();	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        if (r2 != 0) goto L_0x001e;
    L_0x002f:
        if (r1 == 0) goto L_0x0034;
    L_0x0031:
        r1.close();
    L_0x0034:
        r3 = r0;
    L_0x0035:
        return r3;
    L_0x0036:
        if (r1 == 0) goto L_0x0035;
    L_0x0038:
        r1.close();
        goto L_0x0035;
    L_0x003c:
        r0 = move-exception;
        r2 = "MicroMsg.IPCallAddressStorage";	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r4 = "getAllAddress, error: %s";	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r5 = 1;	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r6 = 0;	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r5[r6] = r0;	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r4, r5);	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        if (r1 == 0) goto L_0x0035;
    L_0x0052:
        r1.close();
        goto L_0x0035;
    L_0x0056:
        r0 = move-exception;
        if (r1 == 0) goto L_0x005c;
    L_0x0059:
        r1.close();
    L_0x005c:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.a.g.d.aEP():java.util.ArrayList<com.tencent.mm.plugin.ipcall.a.g.c>");
    }

    public final com.tencent.mm.plugin.ipcall.a.g.c cr(long r10) {
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
        r1 = "IPCallAddressItem";
        r2 = mQX;
        r3 = "rowid=?";
        r4 = new java.lang.String[r4];
        r6 = java.lang.String.valueOf(r10);
        r4[r7] = r6;
        r8 = 2;
        r6 = r5;
        r7 = r5;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0037, all -> 0x0051 }
        if (r0 == 0) goto L_0x0031;	 Catch:{ Exception -> 0x0037, all -> 0x0051 }
    L_0x0022:
        r0 = new com.tencent.mm.plugin.ipcall.a.g.c;	 Catch:{ Exception -> 0x0037, all -> 0x0051 }
        r0.<init>();	 Catch:{ Exception -> 0x0037, all -> 0x0051 }
        r0.b(r1);	 Catch:{ Exception -> 0x0037, all -> 0x0051 }
        if (r1 == 0) goto L_0x002f;
    L_0x002c:
        r1.close();
    L_0x002f:
        r5 = r0;
    L_0x0030:
        return r5;
    L_0x0031:
        if (r1 == 0) goto L_0x0030;
    L_0x0033:
        r1.close();
        goto L_0x0030;
    L_0x0037:
        r0 = move-exception;
        r2 = "MicroMsg.IPCallAddressStorage";	 Catch:{ Exception -> 0x0037, all -> 0x0051 }
        r3 = "getByLocalId error: %s";	 Catch:{ Exception -> 0x0037, all -> 0x0051 }
        r4 = 1;	 Catch:{ Exception -> 0x0037, all -> 0x0051 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0037, all -> 0x0051 }
        r6 = 0;	 Catch:{ Exception -> 0x0037, all -> 0x0051 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0037, all -> 0x0051 }
        r4[r6] = r0;	 Catch:{ Exception -> 0x0037, all -> 0x0051 }
        com.tencent.mm.sdk.platformtools.w.d(r2, r3, r4);	 Catch:{ Exception -> 0x0037, all -> 0x0051 }
        if (r1 == 0) goto L_0x0030;
    L_0x004d:
        r1.close();
        goto L_0x0030;
    L_0x0051:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0057;
    L_0x0054:
        r1.close();
    L_0x0057:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.a.g.d.cr(long):com.tencent.mm.plugin.ipcall.a.g.c");
    }

    public final com.tencent.mm.plugin.ipcall.a.g.c yt(java.lang.String r10) {
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
        r0 = r9.gUz;
        r1 = "IPCallAddressItem";
        r2 = mQX;
        r3 = "contactId=?";
        r4 = new java.lang.String[r4];
        r4[r6] = r10;
        r8 = 2;
        r6 = r5;
        r7 = r5;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        if (r0 == 0) goto L_0x0034;	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
    L_0x0025:
        r0 = new com.tencent.mm.plugin.ipcall.a.g.c;	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
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
        r2 = "MicroMsg.IPCallAddressStorage";	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        r3 = "getByContactId error: %s";	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.a.g.d.yt(java.lang.String):com.tencent.mm.plugin.ipcall.a.g.c");
    }

    public final com.tencent.mm.plugin.ipcall.a.g.c yu(java.lang.String r10) {
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
        r0 = r9.gUz;
        r1 = "IPCallAddressItem";
        r2 = mQX;
        r3 = "systemAddressBookUsername=?";
        r4 = new java.lang.String[r4];
        r4[r6] = r10;
        r8 = 2;
        r6 = r5;
        r7 = r5;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        if (r0 == 0) goto L_0x0034;	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
    L_0x0025:
        r0 = new com.tencent.mm.plugin.ipcall.a.g.c;	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
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
        r2 = "MicroMsg.IPCallAddressStorage";	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        r3 = "getByContactName error: %s";	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        r4 = 1;	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        r6 = 0;	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        r4[r6] = r0;	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
        com.tencent.mm.sdk.platformtools.w.d(r2, r3, r4);	 Catch:{ Exception -> 0x003a, all -> 0x0054 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.a.g.d.yu(java.lang.String):com.tencent.mm.plugin.ipcall.a.g.c");
    }

    public d(e eVar) {
        super(eVar, c.gTP, "IPCallAddressItem", null);
        this.gUz = eVar;
    }

    public final Cursor yv(String str) {
        int i;
        Cursor yw;
        Iterator it;
        System.currentTimeMillis();
        for (i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                i = 0;
                break;
            }
        }
        i = 1;
        if (i == 0) {
            yw = yw(str);
        } else {
            String str2;
            String str3;
            String str4;
            ArrayList za = a.za(str);
            Cursor yw2 = yw(str);
            try {
                if (yw2.moveToFirst()) {
                    while (!yw2.isAfterLast()) {
                        za.add(yw2.getString(yw2.getColumnIndex("contactId")));
                        yw2.moveToNext();
                    }
                }
                if (yw2 != null) {
                    yw2.close();
                }
            } catch (Exception e) {
                w.e("MicroMsg.IPCallAddressStorage", "getContactIdList error: %s", new Object[]{e.getMessage()});
                it = za.iterator();
                str2 = "";
                while (it.hasNext()) {
                    str2 = str2 + ((String) it.next()) + ",";
                }
                if (str2.lastIndexOf(",") >= 0) {
                    str2 = str2.substring(0, str2.lastIndexOf(","));
                }
                str3 = null;
                str4 = null;
                yw = this.gUz.query("IPCallAddressItem", mQX, "contactId IN " + ("(" + str2 + ")"), null, str3, str4, "upper(sortKey) asc");
            } finally {
                if (yw2 != null) {
                    yw2.close();
                }
            }
            it = za.iterator();
            str2 = "";
            while (it.hasNext()) {
                str2 = str2 + ((String) it.next()) + ",";
            }
            if (str2.lastIndexOf(",") >= 0) {
                str2 = str2.substring(0, str2.lastIndexOf(","));
            }
            str3 = null;
            str4 = null;
            yw = this.gUz.query("IPCallAddressItem", mQX, "contactId IN " + ("(" + str2 + ")"), null, str3, str4, "upper(sortKey) asc");
        }
        System.currentTimeMillis();
        return yw;
    }

    private Cursor yw(String str) {
        return this.gUz.query("IPCallAddressItem", mQX, "systemAddressBookUsername LIKE ? or sortKey LIKE ?", new String[]{"%" + str + "%", "%" + str + "%"}, null, null, "upper(sortKey) asc");
    }

    public final long cs(long j) {
        if (this.gUz instanceof g) {
            return ((g) this.gUz).cs(j);
        }
        return -1;
    }

    public final void ct(long j) {
        if ((this.gUz instanceof g) && j != -1) {
            ((g) this.gUz).aD(j);
        }
    }
}
