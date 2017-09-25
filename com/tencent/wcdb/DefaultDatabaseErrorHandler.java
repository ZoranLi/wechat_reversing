package com.tencent.wcdb;

import android.util.Pair;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseConfiguration;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteTrace;
import com.tencent.wcdb.support.Log;
import java.io.File;
import java.util.List;

public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    private static final String[] SUFFIX_TO_BACKUP = new String[]{"", "-journal", "-wal", ".sm", ".bak", "-vfslog", "-vfslo1"};
    private static final String TAG = "WCDB.DefaultDatabaseErrorHandler";
    private final boolean mNoCorruptionBackup;

    public DefaultDatabaseErrorHandler() {
        this.mNoCorruptionBackup = false;
    }

    public DefaultDatabaseErrorHandler(boolean z) {
        this.mNoCorruptionBackup = z;
    }

    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
        Log.e(TAG, "Corruption reported by sqlite on database: " + sQLiteDatabase.getPath());
        if (sQLiteDatabase.isOpen()) {
            List list = null;
            try {
                list = sQLiteDatabase.getAttachedDbs();
            } catch (SQLiteException e) {
            }
            SQLiteTrace traceCallback = sQLiteDatabase.getTraceCallback();
            if (traceCallback != null) {
                traceCallback.onDatabaseCorrupted(sQLiteDatabase);
            }
            try {
                sQLiteDatabase.close();
                if (r0 != null) {
                    for (Pair pair : r0) {
                        deleteDatabaseFile((String) pair.second);
                    }
                    return;
                }
                deleteDatabaseFile(sQLiteDatabase.getPath());
            } catch (SQLiteException e2) {
                if (r0 != null) {
                    for (Pair pair2 : r0) {
                        deleteDatabaseFile((String) pair2.second);
                    }
                    return;
                }
                deleteDatabaseFile(sQLiteDatabase.getPath());
            } catch (Throwable th) {
                if (r0 != null) {
                    for (Pair pair22 : r0) {
                        deleteDatabaseFile((String) pair22.second);
                    }
                } else {
                    deleteDatabaseFile(sQLiteDatabase.getPath());
                }
            }
        } else {
            deleteDatabaseFile(sQLiteDatabase.getPath());
        }
    }

    private void deleteDatabaseFile(String str) {
        int i = 0;
        if (!str.equalsIgnoreCase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH) && str.trim().length() != 0) {
            Log.e(TAG, "Remove database file: " + str);
            if (this.mNoCorruptionBackup) {
                String[] strArr = SUFFIX_TO_BACKUP;
                int length = strArr.length;
                while (i < length) {
                    deleteFile(str + strArr[i]);
                    i++;
                }
                return;
            }
            File file = new File(str);
            File file2 = new File(file.getParentFile(), "corrupted");
            if (!file2.mkdirs()) {
                Log.e(TAG, "Could not create directory for corrupted database. Corruption backup may be unavailable.");
            }
            String str2 = file2.getPath() + "/" + file.getName();
            String[] strArr2 = SUFFIX_TO_BACKUP;
            int length2 = strArr2.length;
            while (i < length2) {
                String str3 = strArr2[i];
                moveOrDeleteFile(str + str3, str2 + str3);
                i++;
            }
        }
    }

    private static boolean moveOrDeleteFile(String str, String str2) {
        File file = new File(str);
        boolean renameTo = file.renameTo(new File(str2));
        if (!renameTo) {
            file.delete();
        }
        return renameTo;
    }

    private static boolean deleteFile(String str) {
        return new File(str).delete();
    }
}
