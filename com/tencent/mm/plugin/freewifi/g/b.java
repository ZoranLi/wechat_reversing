package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b extends i<a> {
    public static final String[] gUx = new String[]{i.a(a.gTP, "FreeWifiConfig"), "CREATE INDEX IF NOT EXISTS idx_freewificonfig_key  on FreeWifiConfig  (  key )"};
    public static Map<String, String> lVl = new ConcurrentHashMap();

    public final java.lang.String wN(java.lang.String r3) {
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
        r2 = this;
        r0 = com.tencent.mm.plugin.freewifi.m.wx(r3);
        if (r0 == 0) goto L_0x000a;
    L_0x0006:
        r0 = "";
    L_0x0009:
        return r0;
    L_0x000a:
        r0 = lVl;	 Catch:{ Exception -> 0x0041 }
        if (r0 == 0) goto L_0x0018;	 Catch:{ Exception -> 0x0041 }
    L_0x000e:
        r0 = lVl;	 Catch:{ Exception -> 0x0041 }
        r0 = r0.get(r3);	 Catch:{ Exception -> 0x0041 }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0041 }
        if (r0 != 0) goto L_0x0009;
    L_0x0018:
        r0 = new java.lang.StringBuilder;
        r1 = "select * from FreeWifiConfig where key = '";
        r0.<init>(r1);
        r0 = r0.append(r3);
        r1 = "'";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r1 = 0;
        r1 = new java.lang.String[r1];
        r1 = r2.rawQuery(r0, r1);
        if (r1 != 0) goto L_0x004c;
    L_0x0038:
        r0 = "";
        if (r1 == 0) goto L_0x0009;
    L_0x003d:
        r1.close();
        goto L_0x0009;
    L_0x0041:
        r0 = move-exception;
        r0 = "MicroMsg.FreeWifi.FreeWifiConfigStorage";
        r1 = "Map get error!";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        goto L_0x0018;
    L_0x004c:
        r0 = r1.moveToFirst();	 Catch:{ all -> 0x006b }
        if (r0 == 0) goto L_0x0062;	 Catch:{ all -> 0x006b }
    L_0x0052:
        r0 = new com.tencent.mm.plugin.freewifi.g.a;	 Catch:{ all -> 0x006b }
        r0.<init>();	 Catch:{ all -> 0x006b }
        r0.b(r1);	 Catch:{ all -> 0x006b }
        r0 = r0.field_value;	 Catch:{ all -> 0x006b }
        if (r1 == 0) goto L_0x0009;
    L_0x005e:
        r1.close();
        goto L_0x0009;
    L_0x0062:
        r0 = "";
        if (r1 == 0) goto L_0x0009;
    L_0x0067:
        r1.close();
        goto L_0x0009;
    L_0x006b:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0071;
    L_0x006e:
        r1.close();
    L_0x0071:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.g.b.wN(java.lang.String):java.lang.String");
    }

    public b(e eVar) {
        super(eVar, a.gTP, "FreeWifiConfig", null);
    }

    public final String axd() {
        String message;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("key\tvalue\tmodifyTime\r\n");
        Cursor rawQuery = rawQuery("select key, value, modifyTime from FreeWifiConfig", new String[0]);
        while (rawQuery.moveToNext()) {
            try {
                stringBuilder.append(rawQuery.getString(0)).append("\t").append(rawQuery.getString(1)).append("\t").append(rawQuery.getLong(2)).append("\r\n");
            } catch (Exception e) {
                w.i("MicroMsg.FreeWifi.FreeWifiConfigStorage", "FreeWifiConfig Table :\r\n" + e.getMessage());
                message = e.getMessage();
            } finally {
                rawQuery.close();
            }
        }
        w.i("MicroMsg.FreeWifi.FreeWifiConfigStorage", "FreeWifiConfig Table :\r\n" + stringBuilder.toString());
        message = stringBuilder.toString();
        return message;
    }

    public final void cg(String str, String str2) {
        if (!m.wx(str) && !m.wx(str2)) {
            try {
                if (lVl != null) {
                    if (lVl.size() < 1000) {
                        lVl.put(str, str2);
                    } else {
                        lVl.clear();
                        lVl.put(str, str2);
                    }
                }
            } catch (Exception e) {
                w.e("MicroMsg.FreeWifi.FreeWifiConfigStorage", "Map put error!");
            }
            Cursor rawQuery = rawQuery("select * from FreeWifiConfig where key = '" + str + "'", new String[0]);
            try {
                c aVar = new a();
                aVar.field_key = str;
                aVar.field_value = str2;
                aVar.field_modifyTime = System.currentTimeMillis();
                if (rawQuery.getCount() == 0) {
                    b(aVar);
                } else {
                    c(aVar, new String[0]);
                }
                rawQuery.close();
            } catch (Throwable th) {
                rawQuery.close();
            }
        }
    }

    public final void Ku() {
        if (lVl != null) {
            lVl.clear();
        }
        super.eE("FreeWifiConfig", "delete from FreeWifiConfig");
    }
}
