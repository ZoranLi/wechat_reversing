package com.tencent.mm.bj;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Base64;
import android.util.Pair;
import android.util.StringBuilderPrinter;
import com.tencent.mm.a.g;
import com.tencent.mm.bj.a.f;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.CursorWrapper;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteCursor;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.database.SQLiteDatabaseConfiguration;
import com.tencent.wcdb.database.SQLiteDebug;
import com.tencent.wcdb.database.SQLiteDebug.IOTraceStats;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteTrace;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class e implements DatabaseErrorHandler, SQLiteTrace {
    private static final SQLiteCipherSpec kFy = new SQLiteCipherSpec().setPageSize(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT).setSQLCipherVersion(1);
    private static Map<String, SQLiteDatabase> uLJ = new HashMap();
    private static final SharedPreferences uLK;
    private static SQLiteTrace uLO;
    private static boolean uLP;
    SQLiteDatabase uLH = null;
    SQLiteDatabase uLI = null;
    private boolean uLL = false;
    private boolean uLM = false;
    private String uLN = null;

    private static class a extends CursorWrapper {
        private long mCreateTime;
        private int uLQ;
        private String uLR;

        public a(Cursor cursor, String str) {
            super(cursor);
            this.uLR = str;
            if (cursor instanceof SQLiteDirectCursor) {
                this.uLQ = 2;
            } else if (cursor instanceof SQLiteCursor) {
                this.uLQ = 1;
            } else {
                this.uLQ = -1;
            }
            this.mCreateTime = System.nanoTime();
            w.d("MicroMsg.MMDataBase", "TimingCursor opened, SQL: %s, hash: %d", this.uLR, Integer.valueOf(hashCode()));
        }

        public final void close() {
            int i;
            this.mCursor.close();
            long nanoTime = (System.nanoTime() - this.mCreateTime) / 1000;
            String str = "MicroMsg.MMDataBase";
            String str2 = "TimingCursor closed, mode: %d, time : %d us, SQL: %s, hash: %d";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(this.uLQ);
            objArr[1] = Long.valueOf(nanoTime);
            objArr[2] = this.uLR == null ? "(query)" : this.uLR;
            objArr[3] = Integer.valueOf(hashCode());
            w.d(str, str2, objArr);
            if (this.uLQ == 1) {
                i = 0;
            } else if (this.uLQ == 2) {
                i = 3;
            } else {
                i = -1;
            }
            if (i >= 0) {
                c.oTb.c(463, i + 1, i + 2, (int) nanoTime, false);
            }
        }

        public final int getCount() {
            w.w("MicroMsg.MMDataBase", "Slow operation: " + bg.g(new Throwable()));
            return this.mCursor.getCount();
        }
    }

    static {
        boolean z = true;
        SQLiteDatabase.loadLib();
        SQLiteDebug.setIOTraceFlags(0);
        CursorWindow.windowSize(3145728);
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("db_config", 0);
        uLK = sharedPreferences;
        if (sharedPreferences.getInt("alter_cursor", 0) == 0) {
            z = false;
        }
        uLP = z;
    }

    public static void a(SQLiteTrace sQLiteTrace) {
        uLO = sQLiteTrace;
    }

    public static void ah(Map<String, ?> map) {
        if (!uLK.getAll().equals(map)) {
            Editor edit = uLK.edit();
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof Integer) {
                    edit.putInt(str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(str, ((Long) value).longValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(str, ((Boolean) value).booleanValue());
                } else if (value instanceof String) {
                    edit.putString(str, value.toString());
                } else if (value instanceof Float) {
                    edit.putFloat(str, ((Float) value).floatValue());
                }
            }
            edit.apply();
        }
    }

    public static void Ss(String str) {
        int i = 0;
        File file = new File(str);
        File file2 = new File(file.getParentFile(), "corrupted");
        file2.mkdirs();
        String absolutePath = new File(file2, file.getName()).getAbsolutePath();
        String[] strArr = new String[]{"", "-journal", "-wal", ".bak", ".sm", "-vfslog", "-vfslo1"};
        while (i < 7) {
            String str2 = strArr[i];
            FileOp.aj(str + str2, absolutePath + str2);
            i++;
        }
    }

    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
        w.e("MicroMsg.MMDataBase", "Database corrupted, isOpen: %s, path: %s", Boolean.toString(sQLiteDatabase.isOpen()), sQLiteDatabase.getPath());
        List<Pair> attachedDbs = sQLiteDatabase.getAttachedDbs();
        if (!this.uLM) {
            this.uLM = true;
            int lastErrorLine = SQLiteDebug.getLastErrorLine();
            ArrayList lastIOTraceStats = SQLiteDebug.getLastIOTraceStats();
            if (!(lastIOTraceStats == null || lastIOTraceStats.isEmpty())) {
                String str;
                String encodeToString;
                IOTraceStats iOTraceStats = (IOTraceStats) lastIOTraceStats.get(0);
                String str2 = "";
                try {
                    h.vG();
                    str2 = g.n((p.rA() + com.tencent.mm.kernel.a.uH()).getBytes()).substring(0, 7);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MMDataBase", e, "Failed to get hash.", new Object[0]);
                }
                Object obj = "";
                try {
                    str = ab.getContext().getFilesDir().getAbsolutePath() + "/battery.bin";
                    if (FileOp.aO(str)) {
                        byte[] c = FileOp.c(str, 0, -1);
                        Parcel obtain = Parcel.obtain();
                        obtain.unmarshall(c, 0, c.length);
                        obtain.setDataPosition(0);
                        Bundle readBundle = obtain.readBundle();
                        StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                        stringBuilder.append("level: ").append(readBundle.getInt("level", -1)).append('\n');
                        stringBuilder.append("scale: ").append(readBundle.getInt("scale", -1)).append('\n');
                        stringBuilder.append("health: ").append(readBundle.getInt("health")).append('\n');
                        stringBuilder.append("status: ").append(readBundle.getInt(DownloadInfo.STATUS)).append('\n');
                        stringBuilder.append("voltage: ").append(readBundle.getInt("voltage")).append('\n');
                        stringBuilder.append("temperature: ").append(readBundle.getInt("temperature")).append('\n');
                        stringBuilder.append("plugged: ").append(readBundle.getInt("plugged")).append('\n');
                        obj = stringBuilder.toString();
                    } else {
                        w.w("MicroMsg.MMDataBase", "Battery info not present.");
                    }
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.MMDataBase", e2, "Failed to get battery info.", new Object[0]);
                }
                String format = String.format("DB corrupted (line: %d, hash: %s, open: %s) => %s", new Object[]{Integer.valueOf(lastErrorLine), str2, Boolean.toString(r4), iOTraceStats.toString()});
                str2 = "";
                if (iOTraceStats.lastReadPage != null) {
                    str2 = Base64.encodeToString(iOTraceStats.lastReadPage, 2);
                }
                str = "";
                if (iOTraceStats.lastJournalReadPage != null) {
                    encodeToString = Base64.encodeToString(iOTraceStats.lastJournalReadPage, 2);
                } else {
                    encodeToString = str;
                }
                Map hashMap = new HashMap();
                hashMap.put("lastReadPage", str2);
                hashMap.put("lastJournalReadPage", encodeToString);
                hashMap.put("batteryInfo", obj);
                c.oTb.d("DBCorrupt", format, hashMap);
                w.e("MMDB.CorruptionDumper", ">>> DUMP CORRUPTED DATABASE <<<\n" + format);
                w.e("MMDB.CorruptionDumper", "> LAST READ PAGE:\n" + str2);
                w.e("MMDB.CorruptionDumper", "> LAST READ JOURNAL:\n" + encodeToString);
            }
        }
        if (r4) {
            c.oTb.a(181, (long) (sQLiteDatabase.isWriteAheadLoggingEnabled() ? 41 : 42), 1, true);
            sQLiteDatabase.close();
            if (attachedDbs == null) {
                Ss(r9);
                return;
            }
            for (Pair pair : attachedDbs) {
                Ss((String) pair.second);
            }
        }
    }

    public final void onSQLExecuted(SQLiteDatabase sQLiteDatabase, String str, int i, long j) {
        if (j > 10 && sQLiteDatabase.getPath().endsWith("EnMicroMsg.db")) {
            int i2 = ((sQLiteDatabase.isWriteAheadLoggingEnabled() ? 0 : 3) + 24) + (i == 1 ? 0 : 6);
            c.oTb.c(463, i2 + 1, i2 + 2, (int) j, false);
        }
        if (uLO != null) {
            uLO.onSQLExecuted(sQLiteDatabase, str, i, j);
        }
    }

    public final void onConnectionObtained(SQLiteDatabase sQLiteDatabase, String str, long j, boolean z) {
        if (j > 10 && sQLiteDatabase.getPath().endsWith("EnMicroMsg.db")) {
            int i = ((sQLiteDatabase.isWriteAheadLoggingEnabled() ? 0 : 3) + 36) + (z ? 0 : 6);
            c.oTb.c(463, i + 1, i + 2, (int) j, false);
        }
    }

    public final void onConnectionPoolBusy(SQLiteDatabase sQLiteDatabase, String str, List<String> list, String str2) {
        if (this.uLN == null || !this.uLN.equals(str)) {
            this.uLN = str;
            StringBuilder stringBuilder = new StringBuilder(2048);
            stringBuilder.append("Waiting SQL: ").append(str).append('\n').append("Running SQL: \n");
            for (String append : list) {
                stringBuilder.append("  ").append(append).append('\n');
            }
            String stringBuilder2 = stringBuilder.toString();
            stringBuilder.setLength(0);
            try {
                sQLiteDatabase.dump(new StringBuilderPrinter(stringBuilder), false);
            } catch (Exception e) {
                stringBuilder.append(e.getMessage()).append('\n').append(str2);
            }
            Map hashMap = new HashMap();
            hashMap.put("SQL", str);
            hashMap.put("message", stringBuilder.toString());
            c.oTb.d("DBPoolBusy", stringBuilder2, hashMap);
            c.oTb.a(463, 6, 1, false);
        }
    }

    public final void onDatabaseCorrupted(SQLiteDatabase sQLiteDatabase) {
    }

    public static e aQ(String str, boolean z) {
        e eVar = new e();
        if (str == null || str.length() == 0) {
            eVar.uLI = SQLiteDatabase.create(null);
            eVar.uLL = true;
            if (eVar.uLI == null) {
                return null;
            }
            return eVar;
        }
        int i = SQLiteDatabase.CREATE_IF_NECESSARY;
        if (z) {
            i = 805306368;
        }
        try {
            eVar.uLI = SQLiteDatabase.openDatabase(str, null, i, eVar);
            eVar.uLI.setTraceCallback(eVar);
            if (BaseBuildInfo.ENABLE_STETHO) {
                uLJ.put(eVar.getPath(), eVar.uLI);
            }
            if (eVar.uLI != null) {
                return eVar;
            }
            return null;
        } catch (Throwable e) {
            c.oTb.d("DBCantOpen", "DB (" + new File(str).getName() + ") can't open: " + bg.g(e), null);
            throw e;
        }
    }

    public final String getPath() {
        if (this.uLH != null) {
            return this.uLH.getPath();
        }
        return this.uLI.getPath();
    }

    public static boolean bNM() {
        return uLK.getInt("wal", 0) != 0;
    }

    public static e r(String str, String str2, boolean z) {
        String str3;
        SQLiteCipherSpec sQLiteCipherSpec;
        byte[] bArr;
        try {
            File file = new File(str + "-vfslog");
            File file2 = new File(str + "-vfslo1");
            if (file.exists() && file.length() > 256) {
                file.delete();
            }
            if (file2.exists() && file2.length() > 256) {
                file2.delete();
            }
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.MMDataBase", th, "", new Object[0]);
        }
        e eVar = new e();
        int i = SQLiteDatabase.CREATE_IF_NECESSARY;
        if (bg.mA(str)) {
            str3 = SQLiteDatabaseConfiguration.MEMORY_DB_PATH;
            eVar.uLL = true;
        } else {
            str3 = str;
        }
        if (bg.mA(str2)) {
            sQLiteCipherSpec = null;
            bArr = null;
        } else {
            bArr = str2.getBytes();
            sQLiteCipherSpec = kFy;
        }
        boolean bNM = bNM();
        if (z || bNM) {
            i = 805306368;
        }
        try {
            eVar.uLH = SQLiteDatabase.openDatabase(str3, bArr, sQLiteCipherSpec, null, i, eVar);
            eVar.uLH.setTraceCallback(eVar);
            if (BaseBuildInfo.ENABLE_STETHO) {
                uLJ.put(eVar.getPath(), eVar.uLH);
            }
            if (eVar.uLH == null) {
                return null;
            }
            return eVar;
        } catch (Throwable e) {
            c.oTb.d("DBCantOpen", "DB (" + new File(str3).getName() + ") can't open: " + bg.g(e), null);
            throw e;
        }
    }

    public final boolean isOpen() {
        if (this.uLH != null) {
            return this.uLH.isOpen();
        }
        if (this.uLI != null) {
            return this.uLI.isOpen();
        }
        return false;
    }

    public final void close() {
        try {
            if (this.uLH != null && this.uLH.isOpen()) {
                this.uLH.close();
                this.uLH = null;
            }
            if (this.uLI != null && this.uLI.isOpen()) {
                this.uLI.close();
                this.uLI = null;
            }
        } catch (Throwable e) {
            w.e("MicroMsg.MMDataBase", "exception:%s", bg.g(e));
        }
    }

    public final android.database.Cursor a(String str, String[] strArr, int i) {
        CursorFactory cursorFactory;
        SQLiteDatabase sQLiteDatabase = this.uLH != null ? this.uLH : this.uLI;
        if (i == 4) {
            cursorFactory = f.FACTORY;
        } else if (b.bIu() || uLP) {
            switch (i) {
                case 0:
                    cursorFactory = null;
                    break;
                case 1:
                    cursorFactory = SQLiteCursor.FACTORY;
                    break;
                case 2:
                    cursorFactory = SQLiteDirectCursor.FACTORY;
                    break;
                case 3:
                    cursorFactory = null;
                    break;
                case 4:
                    cursorFactory = f.FACTORY;
                    break;
                default:
                    cursorFactory = null;
                    break;
            }
        } else {
            cursorFactory = null;
        }
        Cursor rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, null);
        if (i == 0 || i == 4) {
            return rawQueryWithFactory;
        }
        return new a(rawQueryWithFactory, str);
    }

    public final void execSQL(String str) {
        if (this.uLH != null) {
            this.uLH.execSQL(str);
        } else {
            this.uLI.execSQL(str);
        }
    }

    public final android.database.Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i) {
        SQLiteDatabase sQLiteDatabase = this.uLH != null ? this.uLH : this.uLI;
        CursorFactory cursorFactory = null;
        if (i != 4) {
            if (b.bIu() || uLP) {
                switch (i) {
                    case 0:
                        cursorFactory = null;
                        break;
                    case 1:
                        cursorFactory = SQLiteCursor.FACTORY;
                        break;
                    case 2:
                        cursorFactory = SQLiteDirectCursor.FACTORY;
                        break;
                    case 3:
                        cursorFactory = null;
                        break;
                    case 4:
                        cursorFactory = f.FACTORY;
                        break;
                    default:
                        cursorFactory = null;
                        break;
                }
            }
        }
        cursorFactory = f.FACTORY;
        Cursor queryWithFactory = sQLiteDatabase.queryWithFactory(cursorFactory, false, str, strArr, str2, strArr2, str3, str4, str5, null);
        if (i == 0 || i == 4) {
            return queryWithFactory;
        }
        return new a(queryWithFactory, str);
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        if (this.uLH != null) {
            return this.uLH.insert(str, str2, contentValues);
        }
        return this.uLI.insert(str, str2, contentValues);
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        if (this.uLH != null) {
            return this.uLH.update(str, contentValues, str2, strArr);
        }
        return this.uLI.update(str, contentValues, str2, strArr);
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        if (this.uLH != null) {
            return this.uLH.replace(str, str2, contentValues);
        }
        return this.uLI.replace(str, str2, contentValues);
    }

    public final int delete(String str, String str2, String[] strArr) {
        if (this.uLH != null) {
            return this.uLH.delete(str, str2, strArr);
        }
        return this.uLI.delete(str, str2, strArr);
    }

    public final void beginTransaction() {
        try {
            if (this.uLH != null) {
                this.uLH.beginTransaction();
            } else {
                this.uLI.beginTransaction();
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MMDataBase", e, "", new Object[0]);
        }
    }

    public final void endTransaction() {
        try {
            if (this.uLH != null) {
                this.uLH.setTransactionSuccessful();
                this.uLH.endTransaction();
                return;
            }
            this.uLI.setTransactionSuccessful();
            this.uLI.endTransaction();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MMDataBase", e, "", new Object[0]);
        }
    }

    public static boolean a(e eVar, String str) {
        if (eVar == null || str == null) {
            String str2 = "MicroMsg.MMDataBase";
            String str3 = "[arthurdan.checkTableExist] Notice!!! null == db: %b, table: %s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(eVar == null);
            objArr[1] = str;
            w.e(str2, str3, objArr);
            return false;
        }
        android.database.Cursor a = eVar.a("select tbl_name from sqlite_master  where type = \"table\" and tbl_name=\"" + str + "\"", null, 0);
        if (a == null) {
            return false;
        }
        int count = a.getCount();
        a.close();
        if (count > 0) {
            return true;
        }
        return false;
    }
}
