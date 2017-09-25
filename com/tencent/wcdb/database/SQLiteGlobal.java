package com.tencent.wcdb.database;

import android.os.StatFs;
import java.lang.reflect.Method;

public final class SQLiteGlobal {
    private static final String TAG = "WCDB.SQLiteGlobal";
    public static final String defaultJournalMode = "PERSIST";
    public static final int defaultPageSize;
    public static final String defaultSyncMode = "FULL";
    public static final int journalSizeLimit = 524288;
    public static final int walAutoCheckpoint = 100;
    public static final int walConnectionPoolSize = 4;
    public static final String walSyncMode = "FULL";

    private static native int nativeReleaseMemory();

    static {
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("getInt", new Class[]{String.class, Integer.TYPE});
            int blockSize = new StatFs("/data").getBlockSize();
            defaultPageSize = ((Integer) method.invoke(null, new Object[]{"debug.sqlite.pagesize", Integer.valueOf(blockSize)})).intValue();
        } catch (Exception e) {
            throw new NoClassDefFoundError();
        }
    }

    private SQLiteGlobal() {
    }

    public static int releaseMemory() {
        return nativeReleaseMemory();
    }
}
