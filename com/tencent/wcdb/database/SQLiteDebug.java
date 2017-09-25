package com.tencent.wcdb.database;

import android.annotation.SuppressLint;
import android.util.Printer;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import java.util.ArrayList;

public final class SQLiteDebug {
    private static int sLastErrorLine;
    private static ArrayList<IOTraceStats> sLastIOTraceStats;

    public static class DbStats {
        public String cache;
        public String dbName;
        public long dbSize;
        public int lookaside;
        public long pageSize;

        public DbStats(String str, long j, long j2, int i, int i2, int i3, int i4) {
            this.dbName = str;
            this.pageSize = j2 / AppSupportContentFlag.MMAPP_SUPPORT_XLS;
            this.dbSize = (j * j2) / AppSupportContentFlag.MMAPP_SUPPORT_XLS;
            this.lookaside = i;
            this.cache = i2 + "/" + i3 + "/" + i4;
        }
    }

    public static class IOTraceStats {
        public String dbName;
        public String journalMode;
        public long lastJournalReadOffset;
        public byte[] lastJournalReadPage;
        public long lastJournalWriteOffset;
        public byte[] lastJournalWritePage;
        public long lastReadOffset;
        public byte[] lastReadPage;
        public long lastWriteOffset;
        public byte[] lastWritePage;
        public long pageCount;
        public long pageSize;
        public String path;

        @SuppressLint({"DefaultLocale"})
        public String toString() {
            return String.format("[%s | %s] pageSize: %d, pageCount: %d, journal: %s, lastRead: %d, lastWrite: %d, lastJournalRead: %d, lastJournalWrite: %d", new Object[]{this.dbName, this.path, Long.valueOf(this.pageSize), Long.valueOf(this.pageCount), this.journalMode, Long.valueOf(this.lastReadOffset), Long.valueOf(this.lastWriteOffset), Long.valueOf(this.lastJournalReadOffset), Long.valueOf(this.lastJournalWriteOffset)});
        }
    }

    public static class PagerStats {
        public ArrayList<DbStats> dbStats;
        public int largestMemAlloc;
        public int memoryUsed;
        public int pageCacheOverflow;
    }

    private static native void nativeGetIOTraceStats(long j, ArrayList<IOTraceStats> arrayList);

    private static native int nativeGetLastErrorLine();

    private static native void nativeGetPagerStats(PagerStats pagerStats);

    private static native void nativeSetIOTraceFlags(int i);

    static {
        SQLiteDatabase.loadLib();
    }

    private SQLiteDebug() {
    }

    public static final boolean shouldLogSlowQuery(long j) {
        return j > 300;
    }

    public static PagerStats getDatabaseInfo() {
        PagerStats pagerStats = new PagerStats();
        nativeGetPagerStats(pagerStats);
        pagerStats.dbStats = SQLiteDatabase.getDbStats();
        return pagerStats;
    }

    public static void setIOTraceFlags(int i) {
        nativeSetIOTraceFlags(i);
    }

    public static int getLastErrorLine() {
        return sLastErrorLine;
    }

    public static ArrayList<IOTraceStats> getLastIOTraceStats() {
        return sLastIOTraceStats;
    }

    static void collectLastIOTraceStats(SQLiteConnection sQLiteConnection) {
        sLastErrorLine = nativeGetLastErrorLine();
        ArrayList arrayList = new ArrayList();
        long nativeHandle = sQLiteConnection.getNativeHandle(null);
        if (nativeHandle != 0) {
            nativeGetIOTraceStats(nativeHandle, arrayList);
            sQLiteConnection.endNativeHandle(null);
        }
        sLastIOTraceStats = arrayList;
    }

    static void collectLastIOTraceStats(SQLiteDatabase sQLiteDatabase) {
        sLastErrorLine = nativeGetLastErrorLine();
        ArrayList arrayList = new ArrayList();
        long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle("collectIoStat", false, false);
        if (acquireNativeConnectionHandle != 0) {
            nativeGetIOTraceStats(acquireNativeConnectionHandle, arrayList);
        }
        sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle, null);
        sLastIOTraceStats = arrayList;
    }

    public static void dump(Printer printer, String[] strArr) {
        boolean z = false;
        for (String equals : strArr) {
            if (equals.equals("-v")) {
                z = true;
            }
        }
        SQLiteDatabase.dumpAll(printer, z);
    }
}
