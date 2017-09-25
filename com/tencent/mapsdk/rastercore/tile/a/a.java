package com.tencent.mapsdk.rastercore.tile.a;

import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.os.Environment;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import java.io.File;
import java.security.MessageDigest;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class a {
    private static final String g = ("Qmap" + File.separator);
    private AtomicBoolean a = new AtomicBoolean(false);
    private volatile Context b;
    private AtomicInteger c = new AtomicInteger(0);
    private b d;
    private c e;
    private ReentrantReadWriteLock f = new ReentrantReadWriteLock();

    static class a {
        public static final a a = new a();
    }

    class b extends ContextWrapper {
        private /* synthetic */ a a;

        public b(a aVar, Context context) {
            this.a = aVar;
            super(context);
        }

        public final SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory) {
            String b = this.a.b();
            return (b == null || b.length() == 0) ? super.openOrCreateDatabase(str, i, cursorFactory) : SQLiteDatabase.openOrCreateDatabase(b + str, null);
        }

        public final SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
            String b = this.a.b();
            return (b == null || b.length() == 0) ? super.openOrCreateDatabase(str, i, cursorFactory, databaseErrorHandler) : SQLiteDatabase.openOrCreateDatabase(b + str, null);
        }
    }

    class c extends SQLiteOpenHelper {
        private SQLiteDatabase a;

        public c(a aVar, Context context) {
            super(context, "Cache.db", null, 1);
            this.a = null;
            this.a = getReadableDatabase();
            if (VERSION.SDK_INT > 10) {
                this.a.enableWriteAheadLogging();
            } else {
                this.a.setLockingEnabled(true);
            }
        }

        private static void a(String str, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + str + " (tile TEXT PRIMARY KEY UNIQUE,version TEXT,style TEXT,md5" + " TEXT,data BLOB )");
        }

        private static String b(MapSource mapSource) {
            switch (mapSource) {
                case BING:
                    return "wmt";
                case TENCENT:
                    return "tct";
                case SATELLITE:
                    return "stt";
                default:
                    return "";
            }
        }

        private static String b(com.tencent.mapsdk.rastercore.tile.a aVar) {
            switch (aVar.m()) {
                case BING:
                    return aVar.d() + "-" + aVar.b() + "-" + aVar.c() + "-" + e.u() + "-" + e.t();
                case TENCENT:
                    return aVar.d() + "-" + aVar.b() + "-" + aVar.c() + "-zh-" + e.y();
                case SATELLITE:
                    return aVar.d() + "-" + aVar.b() + "-" + aVar.c();
                default:
                    return null;
            }
        }

        private static int c(MapSource mapSource) {
            return mapSource == MapSource.BING ? e.t() : mapSource == MapSource.TENCENT ? e.y() : -1;
        }

        private boolean c(com.tencent.mapsdk.rastercore.tile.a aVar) {
            Cursor cursor = null;
            boolean z = true;
            try {
                cursor = this.a.rawQuery("select count(*) as ct from " + b(aVar.m()) + " where " + "tile" + " = '" + b(aVar) + "'", null);
                if (cursor == null || cursor.getCount() <= 0) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return z;
                }
                cursor.moveToFirst();
                if (cursor.getInt(cursor.getColumnIndex("ct")) <= 0) {
                    z = false;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return z;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        public final c a(com.tencent.mapsdk.rastercore.tile.a aVar) {
            Cursor rawQuery;
            Throwable th;
            Throwable th2;
            if (this.a == null) {
                return null;
            }
            String str = "select * from " + b(aVar.m()) + " where tile = ?";
            try {
                rawQuery = this.a.rawQuery(str, new String[]{b(aVar)});
                if (rawQuery != null) {
                    try {
                        if (rawQuery.getCount() > 0) {
                            rawQuery.moveToFirst();
                            byte[] blob = rawQuery.getBlob(rawQuery.getColumnIndex(SlookAirButtonFrequentContactAdapter.DATA));
                            String string = rawQuery.getString(rawQuery.getColumnIndex("md5"));
                            c cVar = new c(a.d(blob, string), rawQuery.getInt(rawQuery.getColumnIndex("version")), string);
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            return cVar;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            new StringBuilder("getBitmap error:").append(th.toString());
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            return new c(null, e.v(), "");
                        } catch (Throwable th4) {
                            th2 = th4;
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            throw th2;
                        }
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Throwable th5) {
                rawQuery = null;
                th2 = th5;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th2;
            }
            return new c(null, e.v(), "");
        }

        public final boolean a(MapSource mapSource) {
            if (this.a == null) {
                return false;
            }
            String str = "delete  from " + b(mapSource);
            if (mapSource == MapSource.BING || mapSource == MapSource.TENCENT) {
                str = str + " where style = '" + c(mapSource) + "'";
            }
            try {
                this.a.execSQL(str);
                return true;
            } catch (Throwable th) {
                new StringBuilder("cleanCache Error:").append(th.toString());
                return false;
            }
        }

        public final boolean a(MapSource mapSource, int i) {
            try {
                StringBuilder stringBuilder = new StringBuilder("delete from ");
                stringBuilder.append(b(mapSource));
                stringBuilder.append(mapSource == MapSource.SATELLITE ? " where version != '" + i + "'" : " where style = '" + c(mapSource) + "' and version != '" + i + "'");
                this.a.execSQL(stringBuilder.toString());
                return true;
            } catch (Throwable th) {
                new StringBuilder("deleteOlderCache error:").append(th.toString());
                return false;
            }
        }

        public final boolean a(com.tencent.mapsdk.rastercore.tile.a aVar, byte[] bArr) {
            if (this.a == null) {
                return false;
            }
            try {
                String a = a.a(bArr);
                byte[] c = a.c(bArr, a);
                ContentValues contentValues = new ContentValues();
                contentValues.put("tile", b(aVar));
                contentValues.put(SlookAirButtonFrequentContactAdapter.DATA, c);
                contentValues.put("md5", a);
                MapSource m = aVar.m();
                if (m == MapSource.BING) {
                    contentValues.put("style", Integer.valueOf(e.t()));
                }
                if (m == MapSource.TENCENT) {
                    contentValues.put("style", Integer.valueOf(e.y()));
                }
                contentValues.put("version", Integer.valueOf(aVar.l()));
                return this.a.insert(b(aVar.m()), null, contentValues) != -1;
            } catch (Throwable th) {
                new StringBuilder("putBitmap Error:").append(th.toString());
                return false;
            }
        }

        public final boolean a(com.tencent.mapsdk.rastercore.tile.a aVar, byte[] bArr, boolean z) {
            if (this.a == null) {
                return false;
            }
            try {
                ContentValues contentValues = new ContentValues();
                String str = "tile = ? ";
                String[] strArr = new String[]{b(aVar)};
                contentValues.put("version", Integer.valueOf(aVar.l()));
                String a = a.a(bArr);
                if (!(z || bArr == null)) {
                    contentValues.put("md5", a);
                    contentValues.put(SlookAirButtonFrequentContactAdapter.DATA, bArr);
                }
                return this.a.update(b(aVar.m()), contentValues, str, strArr) > 0;
            } catch (Throwable th) {
                new StringBuilder("updateBitmap Error:").append(th.toString());
                return false;
            }
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            a("tct", sQLiteDatabase);
            a("wmt", sQLiteDatabase);
            a("stt", sQLiteDatabase);
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS  tct");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS  wmt");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS  stt");
            onCreate(sQLiteDatabase);
        }
    }

    public static a a() {
        return a.a;
    }

    public static String a(byte[] bArr) {
        String str = "md5";
        if (!(bArr == null || bArr.length == 0)) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(bArr);
                byte[] digest = instance.digest();
                StringBuilder stringBuilder = new StringBuilder();
                for (byte b : digest) {
                    String toHexString = Integer.toHexString(b & 255);
                    if (toHexString.length() == 1) {
                        toHexString = "0" + toHexString;
                    }
                    stringBuilder.append(toHexString);
                }
                str = stringBuilder.toString();
            } catch (Exception e) {
                new StringBuilder("CacheManager getMd5 failed:").append(e.toString());
            }
        }
        return str;
    }

    public static byte[] c(byte[] bArr, String str) {
        try {
            int i;
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length + bArr.length;
            byte[] bArr2 = new byte[length];
            for (i = 0; i < bytes.length; i++) {
                bArr2[i] = bytes[i];
            }
            for (i = bytes.length; i < length; i++) {
                bArr2[i] = bArr[i - bytes.length];
            }
            return bArr2;
        } catch (Exception e) {
            new StringBuilder("CacheManager encode:").append(e.toString());
            return bArr;
        }
    }

    public static byte[] d(byte[] bArr, String str) {
        try {
            int length = str.getBytes("UTF-8").length;
            byte[] bArr2 = new byte[(bArr.length - length)];
            for (int i = length; i < bArr.length; i++) {
                bArr2[i - length] = bArr[i];
            }
            return bArr2;
        } catch (Exception e) {
            return bArr;
        }
    }

    public final c a(com.tencent.mapsdk.rastercore.tile.a aVar) {
        c cVar = new c(null, e.v(), "");
        if (!(this.e == null || aVar.m() == MapSource.CUSTOMER || aVar.m() == MapSource.TRAFFIC)) {
            this.f.readLock().lock();
            try {
                cVar = this.e.a(aVar);
            } catch (Throwable th) {
            } finally {
                this.f.readLock().unlock();
            }
        }
        return cVar;
    }

    public final void a(Context context) {
        try {
            this.c.incrementAndGet();
            if (this.a.compareAndSet(false, true)) {
                this.b = context;
                this.d = new b(this, this.b);
                this.e = new c(this, this.d);
            }
        } catch (Throwable th) {
        }
    }

    public final boolean a(MapSource mapSource) {
        boolean z = false;
        if (this.e != null) {
            this.f.writeLock().lock();
            try {
                z = this.e.a(mapSource);
            } catch (Throwable th) {
                new StringBuilder("clearCache error:").append(th.toString());
            } finally {
                this.f.writeLock().unlock();
            }
        }
        return z;
    }

    public final boolean a(MapSource mapSource, int i) {
        boolean z = false;
        if (this.e != null) {
            this.f.writeLock().lock();
            try {
                z = this.e.a(mapSource, i);
            } catch (Throwable th) {
                new StringBuilder("deleteOlderMapCache error:").append(th.toString());
            } finally {
                this.f.writeLock().unlock();
            }
        }
        return z;
    }

    public final boolean a(com.tencent.mapsdk.rastercore.tile.a.c r5, com.tencent.mapsdk.rastercore.tile.a r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r1 = 0;
        r0 = r4.e;
        if (r0 == 0) goto L_0x0015;
    L_0x0005:
        r0 = r6.m();
        r2 = com.tencent.mapsdk.rastercore.tile.MapTile.MapSource.CUSTOMER;
        if (r0 == r2) goto L_0x0015;
    L_0x000d:
        r0 = r6.m();
        r2 = com.tencent.mapsdk.rastercore.tile.MapTile.MapSource.TRAFFIC;
        if (r0 != r2) goto L_0x0017;
    L_0x0015:
        r0 = r1;
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = r6.m();
        r2 = com.tencent.mapsdk.rastercore.tile.a.a.AnonymousClass1.a;
        r0 = r0.ordinal();
        r0 = r2[r0];
        switch(r0) {
            case 1: goto L_0x0065;
            case 2: goto L_0x006a;
            case 3: goto L_0x006f;
            default: goto L_0x0026;
        };
    L_0x0026:
        r0 = -1;
    L_0x0027:
        r2 = r4.f;
        r2 = r2.writeLock();
        r2.lock();
        r2 = new java.lang.StringBuilder;
        r3 = "CacheManager Put currentVersion:";
        r2.<init>(r3);
        r2 = r2.append(r0);
        r3 = ",tileData.getVersion():";
        r2 = r2.append(r3);
        r3 = r6.l();
        r2.append(r3);
        r2 = r6.g();	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        if (r2 == 0) goto L_0x005a;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
    L_0x0050:
        r2 = r6.l();	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        if (r2 != r0) goto L_0x005a;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
    L_0x0056:
        r2 = r4.e;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        if (r2 != 0) goto L_0x0074;
    L_0x005a:
        r0 = r4.f;
        r0 = r0.writeLock();
        r0.unlock();
        r0 = r1;
        goto L_0x0016;
    L_0x0065:
        r0 = com.tencent.mapsdk.rastercore.d.e.s();
        goto L_0x0027;
    L_0x006a:
        r0 = com.tencent.mapsdk.rastercore.d.e.v();
        goto L_0x0027;
    L_0x006f:
        r0 = com.tencent.mapsdk.rastercore.d.e.w();
        goto L_0x0027;
    L_0x0074:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r3 = "Put: tileData.getVersion()=";	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r3 = r6.l();	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r3 = ",currentVersion=";	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r2.append(r0);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r0 = r4.e;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r0 = r0.c(r6);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        if (r0 != 0) goto L_0x00ab;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
    L_0x0096:
        r0 = r4.e;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r2 = r5.c();	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r0 = r0.a(r6, r2);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r1 = r4.f;
        r1 = r1.writeLock();
        r1.unlock();
        goto L_0x0016;
    L_0x00ab:
        r0 = r4.e;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r2 = r5.c();	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r3 = 0;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r0 = r0.a(r6, r2, r3);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r1 = r4.f;
        r1 = r1.writeLock();
        r1.unlock();
        goto L_0x0016;
    L_0x00c1:
        r0 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r3 = "put error:";	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r2.append(r0);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r0 = r4.f;
        r0 = r0.writeLock();
        r0.unlock();
        r0 = r1;
        goto L_0x0016;
    L_0x00dd:
        r0 = move-exception;
        r1 = r4.f;
        r1 = r1.writeLock();
        r1.unlock();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.rastercore.tile.a.a.a(com.tencent.mapsdk.rastercore.tile.a.c, com.tencent.mapsdk.rastercore.tile.a):boolean");
    }

    public final boolean a(com.tencent.mapsdk.rastercore.tile.a aVar, byte[] bArr, boolean z) {
        boolean z2 = false;
        if (!(this.e == null || aVar.m() == MapSource.CUSTOMER || aVar.m() == MapSource.TRAFFIC)) {
            this.f.writeLock().lock();
            try {
                z2 = this.e.a(aVar, null, true);
            } catch (Throwable th) {
                new StringBuilder("updateTile error:").append(th.toString());
            } finally {
                this.f.writeLock().unlock();
            }
        }
        return z2;
    }

    public final String b() {
        Object obj = 1;
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        if (this.b == null) {
            return null;
        }
        String str;
        if (VERSION.SDK_INT >= 23) {
            int checkSelfPermission = this.b.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
            int checkSelfPermission2 = this.b.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
            if (!(checkSelfPermission == 0 && checkSelfPermission2 == 0)) {
                obj = null;
            }
        }
        if (!equals || r0 == null) {
            str = this.b.getFileStreamPath("") + File.separator + g;
        } else {
            try {
                str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + g;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        }
        com.tencent.mapsdk.rastercore.d.a.b(str);
        return str;
    }

    public final void c() {
        if (this.c.decrementAndGet() == 0) {
            if (this.e != null) {
                this.e.close();
            }
            this.a.compareAndSet(true, false);
        }
    }
}
