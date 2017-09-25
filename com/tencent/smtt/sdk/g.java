package com.tencent.smtt.sdk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

public final class g {
    public static final String LOGTAG = CookieManager.LOGTAG;
    static File wTV;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r10, int r11, java.lang.String r12, boolean r13) {
        /*
        r1 = 0;
        r2 = 1;
        r3 = 0;
        if (r10 != 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r0 = com.tencent.smtt.sdk.CookieManager.a.wSK;
        if (r11 != r0) goto L_0x0010;
    L_0x000a:
        r0 = android.text.TextUtils.isEmpty(r12);
        if (r0 != 0) goto L_0x0005;
    L_0x0010:
        r0 = ",";
        r4 = r12.split(r0);
        if (r4 == 0) goto L_0x0005;
    L_0x0019:
        r0 = r4.length;
        if (r0 <= 0) goto L_0x0005;
    L_0x001c:
        r5 = fG(r10);
        if (r5 == 0) goto L_0x0005;
    L_0x0022:
        r6 = new java.util.HashMap;
        r6.<init>();
        r0 = "select * from cookies";
        r7 = 0;
        r1 = r5.rawQuery(r0, r7);	 Catch:{ Throwable -> 0x0103 }
        r0 = r1.getCount();	 Catch:{ Throwable -> 0x0103 }
        if (r0 <= 0) goto L_0x00b8;
    L_0x0035:
        r0 = r1.moveToFirst();	 Catch:{ Throwable -> 0x0103 }
        if (r0 == 0) goto L_0x00b8;
    L_0x003b:
        r0 = "host_key";
        r0 = r1.getColumnIndex(r0);	 Catch:{ Throwable -> 0x0103 }
        r7 = r1.getString(r0);	 Catch:{ Throwable -> 0x0103 }
        r0 = com.tencent.smtt.sdk.CookieManager.a.wSK;	 Catch:{ Throwable -> 0x0103 }
        if (r11 != r0) goto L_0x0059;
    L_0x004a:
        r8 = r4.length;	 Catch:{ Throwable -> 0x0103 }
        r0 = r3;
    L_0x004c:
        if (r0 >= r8) goto L_0x0163;
    L_0x004e:
        r9 = r4[r0];	 Catch:{ Throwable -> 0x0103 }
        r9 = r7.equals(r9);	 Catch:{ Throwable -> 0x0103 }
        if (r9 == 0) goto L_0x00ff;
    L_0x0056:
        r0 = r2;
    L_0x0057:
        if (r0 == 0) goto L_0x00b2;
    L_0x0059:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0103 }
        r0.<init>();	 Catch:{ Throwable -> 0x0103 }
        r8 = "value";
        r8 = r1.getColumnIndex(r8);	 Catch:{ Throwable -> 0x0103 }
        r8 = r1.getString(r8);	 Catch:{ Throwable -> 0x0103 }
        r0.append(r8);	 Catch:{ Throwable -> 0x0103 }
        r8 = ";";
        r8 = r0.append(r8);	 Catch:{ Throwable -> 0x0103 }
        r9 = "name";
        r9 = r1.getColumnIndex(r9);	 Catch:{ Throwable -> 0x0103 }
        r9 = r1.getString(r9);	 Catch:{ Throwable -> 0x0103 }
        r8.append(r9);	 Catch:{ Throwable -> 0x0103 }
        r8 = ";";
        r8 = r0.append(r8);	 Catch:{ Throwable -> 0x0103 }
        r9 = "expires_utc";
        r9 = r1.getColumnIndex(r9);	 Catch:{ Throwable -> 0x0103 }
        r9 = r1.getInt(r9);	 Catch:{ Throwable -> 0x0103 }
        r8.append(r9);	 Catch:{ Throwable -> 0x0103 }
        r8 = ";";
        r8 = r0.append(r8);	 Catch:{ Throwable -> 0x0103 }
        r9 = "priority";
        r9 = r1.getColumnIndex(r9);	 Catch:{ Throwable -> 0x0103 }
        r9 = r1.getInt(r9);	 Catch:{ Throwable -> 0x0103 }
        r8.append(r9);	 Catch:{ Throwable -> 0x0103 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0103 }
        r6.put(r7, r0);	 Catch:{ Throwable -> 0x0103 }
    L_0x00b2:
        r0 = r1.moveToNext();	 Catch:{ Throwable -> 0x0103 }
        if (r0 != 0) goto L_0x003b;
    L_0x00b8:
        if (r1 == 0) goto L_0x00bd;
    L_0x00ba:
        r1.close();
    L_0x00bd:
        if (r5 == 0) goto L_0x00c8;
    L_0x00bf:
        r0 = r5.isOpen();
        if (r0 == 0) goto L_0x00c8;
    L_0x00c5:
        r5.close();
    L_0x00c8:
        r0 = r6.isEmpty();
        if (r0 != 0) goto L_0x0005;
    L_0x00ce:
        if (r10 == 0) goto L_0x00d7;
    L_0x00d0:
        r0 = fF(r10);
        com.tencent.smtt.utils.f.c(r0, r3);
    L_0x00d7:
        r0 = r6.entrySet();
        r3 = r0.iterator();
    L_0x00df:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0136;
    L_0x00e5:
        r0 = r3.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (java.lang.String) r1;
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r4 = com.tencent.smtt.sdk.CookieManager.getInstance();
        r4.setCookie(r1, r0, r2);
        goto L_0x00df;
    L_0x00ff:
        r0 = r0 + 1;
        goto L_0x004c;
    L_0x0103:
        r0 = move-exception;
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0124 }
        r7 = "getCookieDBVersion exception:";
        r4.<init>(r7);	 Catch:{ all -> 0x0124 }
        r0 = r0.toString();	 Catch:{ all -> 0x0124 }
        r4.append(r0);	 Catch:{ all -> 0x0124 }
        if (r1 == 0) goto L_0x0118;
    L_0x0115:
        r1.close();
    L_0x0118:
        if (r5 == 0) goto L_0x00c8;
    L_0x011a:
        r0 = r5.isOpen();
        if (r0 == 0) goto L_0x00c8;
    L_0x0120:
        r5.close();
        goto L_0x00c8;
    L_0x0124:
        r0 = move-exception;
        if (r1 == 0) goto L_0x012a;
    L_0x0127:
        r1.close();
    L_0x012a:
        if (r5 == 0) goto L_0x0135;
    L_0x012c:
        r1 = r5.isOpen();
        if (r1 == 0) goto L_0x0135;
    L_0x0132:
        r5.close();
    L_0x0135:
        throw r0;
    L_0x0136:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r0 < r1) goto L_0x015b;
    L_0x013c:
        r0 = com.tencent.smtt.sdk.CookieManager.getInstance();
        r0.flush();
    L_0x0143:
        if (r13 == 0) goto L_0x0005;
    L_0x0145:
        r0 = fG(r10);
        d(r0);
        r0 = fH(r10);
        r1 = -1;
        if (r0 == r1) goto L_0x0005;
    L_0x0153:
        com.tencent.smtt.sdk.CookieManager.getInstance();
        com.tencent.smtt.sdk.CookieManager.setROMCookieDBVersion(r10, r0);
        goto L_0x0005;
    L_0x015b:
        r0 = com.tencent.smtt.sdk.CookieSyncManager.getInstance();
        r0.sync();
        goto L_0x0143;
    L_0x0163:
        r0 = r3;
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.g.a(android.content.Context, int, java.lang.String, boolean):void");
    }

    private static String c(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        int count = rawQuery.getCount();
        int columnCount = rawQuery.getColumnCount();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("raws:" + count + ",columns:" + columnCount + "\n");
        if (count <= 0 || !rawQuery.moveToFirst()) {
            return stringBuilder.toString();
        }
        do {
            stringBuilder.append("\n");
            for (count = 0; count < columnCount; count++) {
                try {
                    stringBuilder.append(rawQuery.getString(count)).append(",");
                } catch (Exception e) {
                }
            }
            stringBuilder.append("\n");
        } while (rawQuery.moveToNext());
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<java.lang.String> d(android.database.sqlite.SQLiteDatabase r5) {
        /*
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = "select * from sqlite_master where type='table'";
        r3 = 0;
        r0 = r5.rawQuery(r2, r3);	 Catch:{ Throwable -> 0x003e, all -> 0x0050 }
        r2 = r0.moveToFirst();	 Catch:{ Throwable -> 0x003e, all -> 0x0065 }
        if (r2 == 0) goto L_0x002c;
    L_0x0017:
        r2 = 1;
        r2 = r0.getString(r2);	 Catch:{ Throwable -> 0x003e, all -> 0x0065 }
        r3 = 4;
        r0.getString(r3);	 Catch:{ Throwable -> 0x003e, all -> 0x0065 }
        r1.add(r2);	 Catch:{ Throwable -> 0x003e, all -> 0x0065 }
        c(r5, r2);	 Catch:{ Throwable -> 0x003e, all -> 0x0065 }
        r2 = r0.moveToNext();	 Catch:{ Throwable -> 0x003e, all -> 0x0065 }
        if (r2 != 0) goto L_0x0017;
    L_0x002c:
        if (r0 == 0) goto L_0x0031;
    L_0x002e:
        r0.close();
    L_0x0031:
        if (r5 == 0) goto L_0x003c;
    L_0x0033:
        r0 = r5.isOpen();
        if (r0 == 0) goto L_0x003c;
    L_0x0039:
        r5.close();
    L_0x003c:
        r0 = r1;
        goto L_0x0003;
    L_0x003e:
        r2 = move-exception;
        if (r0 == 0) goto L_0x0044;
    L_0x0041:
        r0.close();
    L_0x0044:
        if (r5 == 0) goto L_0x003c;
    L_0x0046:
        r0 = r5.isOpen();
        if (r0 == 0) goto L_0x003c;
    L_0x004c:
        r5.close();
        goto L_0x003c;
    L_0x0050:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0054:
        if (r1 == 0) goto L_0x0059;
    L_0x0056:
        r1.close();
    L_0x0059:
        if (r5 == 0) goto L_0x0064;
    L_0x005b:
        r1 = r5.isOpen();
        if (r1 == 0) goto L_0x0064;
    L_0x0061:
        r5.close();
    L_0x0064:
        throw r0;
    L_0x0065:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.g.d(android.database.sqlite.SQLiteDatabase):java.util.ArrayList<java.lang.String>");
    }

    private static File fF(Context context) {
        if (wTV == null && context != null) {
            wTV = new File(context.getDir("webview", 0), "Cookies");
        }
        if (wTV == null) {
            wTV = new File("/data/data/" + context.getPackageName() + File.separator + "app_webview" + File.separator + "Cookies");
        }
        return wTV;
    }

    private static SQLiteDatabase fG(Context context) {
        SQLiteDatabase sQLiteDatabase = null;
        if (context != null) {
            File fF = fF(context);
            if (fF != null) {
                try {
                    sQLiteDatabase = SQLiteDatabase.openDatabase(fF.getAbsolutePath(), null, 0);
                } catch (Exception e) {
                }
                if (sQLiteDatabase == null) {
                    TbsLog.i(LOGTAG, "dbPath is not exist!");
                }
            }
        }
        return sQLiteDatabase;
    }

    public static int fH(Context context) {
        SQLiteDatabase fG;
        Throwable th;
        int i = 0;
        Cursor cursor = null;
        System.currentTimeMillis();
        try {
            fG = fG(context);
            if (fG == null) {
                if (fG != null && fG.isOpen()) {
                    fG.close();
                }
                return -1;
            }
            try {
                cursor = fG.rawQuery("select * from meta", null);
                int count = cursor.getCount();
                cursor.getColumnCount();
                if (count > 0 && cursor.moveToFirst()) {
                    while (!cursor.getString(0).equals("version")) {
                        if (!cursor.moveToNext()) {
                            break;
                        }
                    }
                    i = Integer.parseInt(cursor.getString(1));
                }
                if (cursor != null) {
                    cursor.close();
                }
                if (fG == null || !fG.isOpen()) {
                    return i;
                }
                fG.close();
                return i;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fG = null;
            if (cursor != null) {
                cursor.close();
            }
            if (fG != null && fG.isOpen()) {
                fG.close();
            }
            throw th;
        }
    }
}
