package com.tencent.wcdb.database;

import android.content.ContentValues;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Printer;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.DefaultDatabaseErrorHandler;
import com.tencent.wcdb.SQLException;
import com.tencent.wcdb.database.SQLiteDebug.DbStats;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class SQLiteDatabase extends SQLiteClosable {
    static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteDatabase.class.desiredAssertionStatus());
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    private static final String[] CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final int CREATE_IF_NECESSARY = 268435456;
    public static final int ENABLE_IO_TRACE = 256;
    public static final int ENABLE_WRITE_AHEAD_LOGGING = 536870912;
    public static final int MAX_SQL_CACHE_SIZE = 100;
    public static final int NO_CORRUPTION_BACKUP = 512;
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    private static final String TAG = "WCDB.SQLiteDatabase";
    private static final WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap();
    private final SQLiteDatabaseConfiguration mConfigurationLocked;
    private SQLiteConnectionPool mConnectionPoolLocked;
    private final CursorFactory mCursorFactory;
    private final DatabaseErrorHandler mErrorHandler;
    private boolean mHasAttachedDbsLocked;
    private final Object mLock = new Object();
    private final ThreadLocal<SQLiteSession> mThreadSession = new ThreadLocal<SQLiteSession>() {
        protected SQLiteSession initialValue() {
            return SQLiteDatabase.this.createSession();
        }
    };

    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram);

        SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal);
    }

    public interface CustomFunction {
        void callback(String[] strArr);
    }

    static {
        System.loadLibrary("wcdb");
    }

    public static void loadLib() {
    }

    private SQLiteDatabase(String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        this.mCursorFactory = cursorFactory;
        if (databaseErrorHandler == null) {
            databaseErrorHandler = new DefaultDatabaseErrorHandler((i & 512) != 0);
        }
        this.mErrorHandler = databaseErrorHandler;
        this.mConfigurationLocked = new SQLiteDatabaseConfiguration(str, i);
    }

    protected final void finalize() {
        try {
            dispose(true);
        } finally {
            super.finalize();
        }
    }

    protected final void onAllReferencesReleased() {
        dispose(false);
    }

    private void dispose(boolean z) {
        synchronized (this.mLock) {
            SQLiteConnectionPool sQLiteConnectionPool = this.mConnectionPoolLocked;
            this.mConnectionPoolLocked = null;
        }
        if (!z) {
            synchronized (sActiveDatabases) {
                sActiveDatabases.remove(this);
            }
            if (sQLiteConnectionPool != null) {
                sQLiteConnectionPool.close();
            }
        }
    }

    public static int releaseMemory() {
        return SQLiteGlobal.releaseMemory();
    }

    @Deprecated
    public final void setLockingEnabled(boolean z) {
    }

    final String getLabel() {
        String str;
        synchronized (this.mLock) {
            str = this.mConfigurationLocked.label;
        }
        return str;
    }

    final void onCorruption() {
        this.mErrorHandler.onCorruption(this);
    }

    final SQLiteSession getThreadSession() {
        return (SQLiteSession) this.mThreadSession.get();
    }

    final SQLiteSession createSession() {
        SQLiteConnectionPool sQLiteConnectionPool;
        synchronized (this.mLock) {
            throwIfNotOpenLocked();
            sQLiteConnectionPool = this.mConnectionPoolLocked;
        }
        return new SQLiteSession(sQLiteConnectionPool);
    }

    final int getThreadDefaultConnectionFlags(boolean z) {
        int i = z ? 1 : 2;
        if (isMainThread()) {
            return i | 4;
        }
        return i;
    }

    private static boolean isMainThread() {
        Looper myLooper = Looper.myLooper();
        return myLooper != null && myLooper == Looper.getMainLooper();
    }

    public final void beginTransaction() {
        beginTransaction(null, true);
    }

    public final void beginTransactionNonExclusive() {
        beginTransaction(null, false);
    }

    public final void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransaction(sQLiteTransactionListener, true);
    }

    public final void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransaction(sQLiteTransactionListener, false);
    }

    private void beginTransaction(SQLiteTransactionListener sQLiteTransactionListener, boolean z) {
        acquireReference();
        try {
            getThreadSession().beginTransaction(z ? 2 : 1, sQLiteTransactionListener, getThreadDefaultConnectionFlags(false), null);
        } finally {
            releaseReference();
        }
    }

    public final void endTransaction() {
        acquireReference();
        try {
            getThreadSession().endTransaction(null);
        } finally {
            releaseReference();
        }
    }

    public final void setTransactionSuccessful() {
        acquireReference();
        try {
            getThreadSession().setTransactionSuccessful();
        } finally {
            releaseReference();
        }
    }

    public final boolean inTransaction() {
        acquireReference();
        try {
            boolean hasTransaction = getThreadSession().hasTransaction();
            return hasTransaction;
        } finally {
            releaseReference();
        }
    }

    public final boolean isDbLockedByCurrentThread() {
        acquireReference();
        try {
            boolean hasConnection = getThreadSession().hasConnection();
            return hasConnection;
        } finally {
            releaseReference();
        }
    }

    @Deprecated
    public final boolean isDbLockedByOtherThreads() {
        return false;
    }

    @Deprecated
    public final boolean yieldIfContended() {
        return yieldIfContendedHelper(false, -1);
    }

    public final boolean yieldIfContendedSafely() {
        return yieldIfContendedHelper(true, -1);
    }

    public final boolean yieldIfContendedSafely(long j) {
        return yieldIfContendedHelper(true, j);
    }

    private boolean yieldIfContendedHelper(boolean z, long j) {
        acquireReference();
        try {
            boolean yieldTransaction = getThreadSession().yieldTransaction(j, z, null);
            return yieldTransaction;
        } finally {
            releaseReference();
        }
    }

    @Deprecated
    public final Map<String, String> getSyncedTables() {
        return new HashMap(0);
    }

    public static SQLiteDatabase openDatabase(String str, CursorFactory cursorFactory, int i) {
        return openDatabase(str, cursorFactory, i, null);
    }

    public static SQLiteDatabase openDatabase(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler, int i2) {
        SQLiteDatabase sQLiteDatabase = new SQLiteDatabase(str, i, cursorFactory, databaseErrorHandler);
        sQLiteDatabase.open(bArr, sQLiteCipherSpec, i2);
        return sQLiteDatabase;
    }

    public static SQLiteDatabase openDatabase(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, bArr, sQLiteCipherSpec, cursorFactory, i, databaseErrorHandler, 0);
    }

    public static SQLiteDatabase openDatabase(String str, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, null, null, cursorFactory, i, databaseErrorHandler, 0);
    }

    public static SQLiteDatabase openDatabase(String str, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler, int i2) {
        return openDatabase(str, null, null, cursorFactory, i, databaseErrorHandler, i2);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, CursorFactory cursorFactory) {
        return openOrCreateDatabase(file.getPath(), cursorFactory);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return openOrCreateDatabase(file.getPath(), bArr, sQLiteCipherSpec, cursorFactory, databaseErrorHandler, 0);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, int i) {
        return openOrCreateDatabase(file.getPath(), bArr, sQLiteCipherSpec, cursorFactory, databaseErrorHandler, i);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, byte[] bArr, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return openOrCreateDatabase(file.getPath(), bArr, null, cursorFactory, databaseErrorHandler, 0);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, byte[] bArr, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, int i) {
        return openOrCreateDatabase(file.getPath(), bArr, null, cursorFactory, databaseErrorHandler, i);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory, int i) {
        return openDatabase(str, null, null, cursorFactory, CREATE_IF_NECESSARY, null, i);
    }

    public static SQLiteDatabase openOrCreateDatabaseInWalMode(String str, CursorFactory cursorFactory) {
        return openDatabase(str, null, null, cursorFactory, 805306368, null, 0);
    }

    public static SQLiteDatabase openOrCreateDatabaseInWalMode(String str, CursorFactory cursorFactory, int i) {
        return openDatabase(str, null, null, cursorFactory, 805306368, null, i);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory) {
        return openDatabase(str, null, null, cursorFactory, CREATE_IF_NECESSARY, null, 0);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory, boolean z) {
        int i = CREATE_IF_NECESSARY;
        if (z) {
            i = 805306368;
        }
        return openDatabase(str, null, null, cursorFactory, i, null, 0);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, int i) {
        return openDatabase(str, bArr, sQLiteCipherSpec, cursorFactory, CREATE_IF_NECESSARY, databaseErrorHandler, i);
    }

    public static SQLiteDatabase openOrCreateDatabaseInWalMode(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, int i) {
        return openDatabase(str, bArr, sQLiteCipherSpec, cursorFactory, 805306368, databaseErrorHandler, i);
    }

    public static SQLiteDatabase openOrCreateDatabaseInWalMode(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory) {
        return openDatabase(str, bArr, sQLiteCipherSpec, cursorFactory, 805306368, null, 0);
    }

    public static SQLiteDatabase openOrCreateMemoryDatabaseInWalMode(CursorFactory cursorFactory) {
        return openDatabase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH, null, null, cursorFactory, 805306368, null, 0);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, int i) {
        return openOrCreateDatabase(str, bArr, null, cursorFactory, databaseErrorHandler, i);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return openOrCreateDatabase(str, bArr, null, cursorFactory, databaseErrorHandler, 0);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, cursorFactory, CREATE_IF_NECESSARY, databaseErrorHandler);
    }

    public static boolean deleteDatabase(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file must not be null");
        }
        boolean delete = (((file.delete() | 0) | new File(file.getPath() + "-journal").delete()) | new File(file.getPath() + "-shm").delete()) | new File(file.getPath() + "-wal").delete();
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            final String str = file.getName() + "-mj";
            File[] listFiles = parentFile.listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    return file.getName().startsWith(str);
                }
            });
            int i = 0;
            while (i < listFiles.length) {
                boolean delete2 = listFiles[i].delete() | delete;
                i++;
                delete = delete2;
            }
        }
        return delete;
    }

    public final void reopenReadWrite() {
        synchronized (this.mLock) {
            throwIfNotOpenLocked();
            if (isReadOnlyLocked()) {
                int i = this.mConfigurationLocked.openFlags;
                this.mConfigurationLocked.openFlags = (this.mConfigurationLocked.openFlags & -2) | 0;
                try {
                    this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
                    return;
                } catch (RuntimeException e) {
                    this.mConfigurationLocked.openFlags = i;
                    throw e;
                }
            }
        }
    }

    private void open(byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i) {
        try {
            openInner(bArr, sQLiteCipherSpec, i);
        } catch (SQLiteDatabaseCorruptException e) {
            try {
                onCorruption();
                openInner(bArr, sQLiteCipherSpec, i);
            } catch (SQLiteException e2) {
                Log.e(TAG, "Failed to open database '" + getLabel() + "'.", e2);
                close();
                throw e2;
            }
        }
    }

    private void openInner(byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i) {
        synchronized (this.mLock) {
            if ($assertionsDisabled || this.mConnectionPoolLocked == null) {
                this.mConnectionPoolLocked = SQLiteConnectionPool.open(this, this.mConfigurationLocked, bArr, sQLiteCipherSpec, i);
            } else {
                throw new AssertionError();
            }
        }
        synchronized (sActiveDatabases) {
            sActiveDatabases.put(this, null);
        }
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory) {
        return openDatabase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH, cursorFactory, CREATE_IF_NECESSARY);
    }

    public final void addCustomFunction(String str, int i, CustomFunction customFunction) {
        SQLiteCustomFunction sQLiteCustomFunction = new SQLiteCustomFunction(str, i, customFunction);
        synchronized (this.mLock) {
            throwIfNotOpenLocked();
            this.mConfigurationLocked.customFunctions.add(sQLiteCustomFunction);
            try {
                this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
            } catch (RuntimeException e) {
                this.mConfigurationLocked.customFunctions.remove(sQLiteCustomFunction);
                throw e;
            }
        }
    }

    public final int getVersion() {
        return Long.valueOf(DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue();
    }

    public final void setVersion(int i) {
        execSQL("PRAGMA user_version = " + i);
    }

    public final long getMaximumSize() {
        return DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null) * getPageSize();
    }

    public final long setMaximumSize(long j) {
        long pageSize = getPageSize();
        long j2 = j / pageSize;
        if (j % pageSize != 0) {
            j2++;
        }
        return DatabaseUtils.longForQuery(this, "PRAGMA max_page_count = " + j2, null) * pageSize;
    }

    public final long getPageSize() {
        return DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null);
    }

    public final void setPageSize(long j) {
        execSQL("PRAGMA page_size = " + j);
    }

    @Deprecated
    public final void markTableSyncable(String str, String str2) {
    }

    @Deprecated
    public final void markTableSyncable(String str, String str2, String str3) {
    }

    public static String findEditTable(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException("Invalid tables");
        }
        int indexOf = str.indexOf(32);
        int indexOf2 = str.indexOf(44);
        if (indexOf > 0 && (indexOf < indexOf2 || indexOf2 < 0)) {
            return str.substring(0, indexOf);
        }
        if (indexOf2 <= 0) {
            return str;
        }
        if (indexOf2 < indexOf || indexOf < 0) {
            return str.substring(0, indexOf2);
        }
        return str;
    }

    public final SQLiteStatement compileStatement(String str) {
        acquireReference();
        try {
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, str, null);
            return sQLiteStatement;
        } finally {
            releaseReference();
        }
    }

    public final Cursor query(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return queryWithFactory(null, z, str, strArr, str2, strArr2, str3, str4, str5, str6, null);
    }

    public final Cursor query(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, CancellationSignal cancellationSignal) {
        return queryWithFactory(null, z, str, strArr, str2, strArr2, str3, str4, str5, str6, cancellationSignal);
    }

    public final Cursor queryWithFactory(CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return queryWithFactory(cursorFactory, z, str, strArr, str2, strArr2, str3, str4, str5, str6, null);
    }

    public final Cursor queryWithFactory(CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, CancellationSignal cancellationSignal) {
        acquireReference();
        try {
            Cursor rawQueryWithFactory = rawQueryWithFactory(cursorFactory, SQLiteQueryBuilder.buildQueryString(z, str, strArr, str2, str3, str4, str5, str6), strArr2, findEditTable(str), cancellationSignal);
            return rawQueryWithFactory;
        } finally {
            releaseReference();
        }
    }

    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, null);
    }

    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        return rawQueryWithFactory(null, str, strArr, null, null);
    }

    public final Cursor rawQuery(String str, String[] strArr, CancellationSignal cancellationSignal) {
        return rawQueryWithFactory(null, str, strArr, null, cancellationSignal);
    }

    public final Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, String[] strArr, String str2) {
        return rawQueryWithFactory(cursorFactory, str, strArr, str2, null);
    }

    public final Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, String[] strArr, String str2, CancellationSignal cancellationSignal) {
        acquireReference();
        try {
            SQLiteCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, str2, cancellationSignal);
            if (cursorFactory == null) {
                cursorFactory = this.mCursorFactory;
            }
            Cursor query = sQLiteDirectCursorDriver.query(cursorFactory, strArr);
            return query;
        } finally {
            releaseReference();
        }
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 0);
        } catch (SQLiteDatabaseCorruptException e) {
            throw e;
        } catch (SQLException e2) {
            Log.e(TAG, "Error inserting %s: %s", contentValues, e2);
            return -1;
        }
    }

    public final long insertOrThrow(String str, String str2, ContentValues contentValues) {
        return insertWithOnConflict(str, str2, contentValues, 0);
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 5);
        } catch (SQLiteDatabaseCorruptException e) {
            throw e;
        } catch (SQLException e2) {
            Log.e(TAG, "Error inserting " + contentValues, e2);
            return -1;
        }
    }

    public final long replaceOrThrow(String str, String str2, ContentValues contentValues) {
        return insertWithOnConflict(str, str2, contentValues, 5);
    }

    private Set<String> keySet(ContentValues contentValues) {
        if (VERSION.SDK_INT >= 11) {
            return contentValues.keySet();
        }
        try {
            Field declaredField = Class.forName("android.content.ContentValues").getDeclaredField("mValues");
            declaredField.setAccessible(true);
            return ((HashMap) declaredField.get(contentValues)).keySet();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final long insertWithOnConflict(String str, String str2, ContentValues contentValues, int i) {
        int i2 = 0;
        acquireReference();
        SQLiteStatement sQLiteStatement;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT");
            stringBuilder.append(CONFLICT_VALUES[i]);
            stringBuilder.append(" INTO ");
            stringBuilder.append(str);
            stringBuilder.append('(');
            Object[] objArr = null;
            int size = (contentValues == null || contentValues.size() <= 0) ? 0 : contentValues.size();
            if (size > 0) {
                Object[] objArr2 = new Object[size];
                int i3 = 0;
                for (String str3 : keySet(contentValues)) {
                    stringBuilder.append(i3 > 0 ? "," : "");
                    stringBuilder.append(str3);
                    int i4 = i3 + 1;
                    objArr2[i3] = contentValues.get(str3);
                    i3 = i4;
                }
                stringBuilder.append(')');
                stringBuilder.append(" VALUES (");
                while (i2 < size) {
                    stringBuilder.append(i2 > 0 ? ",?" : "?");
                    i2++;
                }
                objArr = objArr2;
            } else {
                stringBuilder.append(str2 + ") VALUES (NULL");
            }
            stringBuilder.append(')');
            sQLiteStatement = new SQLiteStatement(this, stringBuilder.toString(), objArr);
            long executeInsert = sQLiteStatement.executeInsert();
            sQLiteStatement.close();
            releaseReference();
            return executeInsert;
        } catch (Throwable th) {
            releaseReference();
        }
    }

    public final int delete(String str, String str2, String[] strArr) {
        acquireReference();
        SQLiteStatement sQLiteStatement;
        try {
            sQLiteStatement = new SQLiteStatement(this, "DELETE FROM " + str + (!TextUtils.isEmpty(str2) ? " WHERE " + str2 : ""), strArr);
            int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
            sQLiteStatement.close();
            releaseReference();
            return executeUpdateDelete;
        } catch (Throwable th) {
            releaseReference();
        }
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        return updateWithOnConflict(str, contentValues, str2, strArr, 0);
    }

    public final int updateWithOnConflict(String str, ContentValues contentValues, String str2, String[] strArr, int i) {
        SQLiteStatement sQLiteStatement;
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        acquireReference();
        try {
            StringBuilder stringBuilder = new StringBuilder(120);
            stringBuilder.append("UPDATE ");
            stringBuilder.append(CONFLICT_VALUES[i]);
            stringBuilder.append(str);
            stringBuilder.append(" SET ");
            int size = contentValues.size();
            int length = strArr == null ? size : strArr.length + size;
            Object[] objArr = new Object[length];
            int i2 = 0;
            for (String str3 : keySet(contentValues)) {
                stringBuilder.append(i2 > 0 ? "," : "");
                stringBuilder.append(str3);
                int i3 = i2 + 1;
                objArr[i2] = contentValues.get(str3);
                stringBuilder.append("=?");
                i2 = i3;
            }
            if (strArr != null) {
                for (int i4 = size; i4 < length; i4++) {
                    objArr[i4] = strArr[i4 - size];
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                stringBuilder.append(" WHERE ");
                stringBuilder.append(str2);
            }
            sQLiteStatement = new SQLiteStatement(this, stringBuilder.toString(), objArr);
            size = sQLiteStatement.executeUpdateDelete();
            sQLiteStatement.close();
            releaseReference();
            return size;
        } catch (Throwable th) {
            releaseReference();
        }
    }

    public final void execSQL(String str) {
        executeSql(str, null);
    }

    public final void execSQL(String str, Object[] objArr) {
        if (objArr == null) {
            throw new IllegalArgumentException("Empty bindArgs");
        }
        executeSql(str, objArr);
    }

    private int executeSql(String str, Object[] objArr) {
        Object obj = 1;
        acquireReference();
        SQLiteStatement sQLiteStatement;
        try {
            if (DatabaseUtils.getSqlStatementType(str) == 3) {
                synchronized (this.mLock) {
                    if (this.mHasAttachedDbsLocked) {
                        obj = null;
                    } else {
                        this.mHasAttachedDbsLocked = true;
                    }
                }
                if (obj != null) {
                    disableWriteAheadLogging();
                }
            }
            sQLiteStatement = new SQLiteStatement(this, str, objArr);
            int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
            sQLiteStatement.close();
            releaseReference();
            return executeUpdateDelete;
        } catch (Throwable th) {
            releaseReference();
        }
    }

    public final boolean isReadOnly() {
        boolean isReadOnlyLocked;
        synchronized (this.mLock) {
            isReadOnlyLocked = isReadOnlyLocked();
        }
        return isReadOnlyLocked;
    }

    private boolean isReadOnlyLocked() {
        return (this.mConfigurationLocked.openFlags & 1) == 1;
    }

    public final boolean isInMemoryDatabase() {
        boolean isInMemoryDb;
        synchronized (this.mLock) {
            isInMemoryDb = this.mConfigurationLocked.isInMemoryDb();
        }
        return isInMemoryDb;
    }

    public final boolean isOpen() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mConnectionPoolLocked != null;
        }
        return z;
    }

    public final boolean needUpgrade(int i) {
        return i > getVersion();
    }

    public final String getPath() {
        String str;
        synchronized (this.mLock) {
            str = this.mConfigurationLocked.path;
        }
        return str;
    }

    public final void setLocale(Locale locale) {
        if (locale == null) {
            throw new IllegalArgumentException("locale must not be null.");
        }
        synchronized (this.mLock) {
            throwIfNotOpenLocked();
            Locale locale2 = this.mConfigurationLocked.locale;
            this.mConfigurationLocked.locale = locale;
            try {
                this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
            } catch (RuntimeException e) {
                this.mConfigurationLocked.locale = locale2;
                throw e;
            }
        }
    }

    public final void setMaxSqlCacheSize(int i) {
        if (i > 100 || i < 0) {
            throw new IllegalStateException("expected value between 0 and 100");
        }
        synchronized (this.mLock) {
            throwIfNotOpenLocked();
            int i2 = this.mConfigurationLocked.maxSqlCacheSize;
            this.mConfigurationLocked.maxSqlCacheSize = i;
            try {
                this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
            } catch (RuntimeException e) {
                this.mConfigurationLocked.maxSqlCacheSize = i2;
                throw e;
            }
        }
    }

    public final void setForeignKeyConstraintsEnabled(boolean z) {
        synchronized (this.mLock) {
            throwIfNotOpenLocked();
            if (this.mConfigurationLocked.foreignKeyConstraintsEnabled == z) {
                return;
            }
            this.mConfigurationLocked.foreignKeyConstraintsEnabled = z;
            try {
                this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
            } catch (RuntimeException e) {
                this.mConfigurationLocked.foreignKeyConstraintsEnabled = !z;
                throw e;
            }
        }
    }

    public final boolean enableWriteAheadLogging() {
        synchronized (this.mLock) {
            throwIfNotOpenLocked();
            if ((this.mConfigurationLocked.openFlags & ENABLE_WRITE_AHEAD_LOGGING) != 0) {
                return true;
            } else if (isReadOnlyLocked()) {
                return false;
            } else if (this.mConfigurationLocked.isInMemoryDb()) {
                Log.i(TAG, "can't enable WAL for memory databases.");
                return false;
            } else if (this.mHasAttachedDbsLocked) {
                Log.i(TAG, "this database: " + this.mConfigurationLocked.label + " has attached databases. can't  enable WAL.");
                return false;
            } else {
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                sQLiteDatabaseConfiguration.openFlags |= ENABLE_WRITE_AHEAD_LOGGING;
                try {
                    this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
                    return true;
                } catch (RuntimeException e) {
                    sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                    sQLiteDatabaseConfiguration.openFlags &= -536870913;
                    throw e;
                }
            }
        }
    }

    public final void disableWriteAheadLogging() {
        synchronized (this.mLock) {
            throwIfNotOpenLocked();
            if ((this.mConfigurationLocked.openFlags & ENABLE_WRITE_AHEAD_LOGGING) == 0) {
                return;
            }
            SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
            sQLiteDatabaseConfiguration.openFlags &= -536870913;
            try {
                this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
            } catch (RuntimeException e) {
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2 = this.mConfigurationLocked;
                sQLiteDatabaseConfiguration2.openFlags |= ENABLE_WRITE_AHEAD_LOGGING;
                throw e;
            }
        }
    }

    public final boolean isWriteAheadLoggingEnabled() {
        boolean z;
        synchronized (this.mLock) {
            throwIfNotOpenLocked();
            z = (this.mConfigurationLocked.openFlags & ENABLE_WRITE_AHEAD_LOGGING) != 0;
        }
        return z;
    }

    public final SQLiteTrace getTraceCallback() {
        SQLiteTrace traceCallback;
        synchronized (this.mLock) {
            throwIfNotOpenLocked();
            traceCallback = this.mConnectionPoolLocked.getTraceCallback();
        }
        return traceCallback;
    }

    public final void setTraceCallback(SQLiteTrace sQLiteTrace) {
        synchronized (this.mLock) {
            throwIfNotOpenLocked();
            this.mConnectionPoolLocked.setTraceCallback(sQLiteTrace);
        }
    }

    static ArrayList<DbStats> getDbStats() {
        ArrayList<DbStats> arrayList = new ArrayList();
        Iterator it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            ((SQLiteDatabase) it.next()).collectDbStats(arrayList);
        }
        return arrayList;
    }

    private void collectDbStats(ArrayList<DbStats> arrayList) {
        synchronized (this.mLock) {
            if (this.mConnectionPoolLocked != null) {
                this.mConnectionPoolLocked.collectDbStats(arrayList);
            }
        }
    }

    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        ArrayList<SQLiteDatabase> arrayList = new ArrayList();
        synchronized (sActiveDatabases) {
            arrayList.addAll(sActiveDatabases.keySet());
        }
        return arrayList;
    }

    public static void dumpAll(Printer printer, boolean z) {
        Iterator it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            ((SQLiteDatabase) it.next()).dump(printer, z);
        }
    }

    public final void dump(Printer printer, boolean z) {
        synchronized (this.mLock) {
            if (this.mConnectionPoolLocked != null) {
                this.mConnectionPoolLocked.dump(printer, z);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<android.util.Pair<java.lang.String, java.lang.String>> getAttachedDbs() {
        /*
        r6 = this;
        r0 = 0;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = r6.mLock;
        monitor-enter(r2);
        r3 = r6.mConnectionPoolLocked;	 Catch:{ all -> 0x0057 }
        if (r3 != 0) goto L_0x000f;
    L_0x000d:
        monitor-exit(r2);	 Catch:{ all -> 0x0057 }
    L_0x000e:
        return r0;
    L_0x000f:
        r3 = r6.mHasAttachedDbsLocked;	 Catch:{ all -> 0x0057 }
        if (r3 != 0) goto L_0x0025;
    L_0x0013:
        r0 = new android.util.Pair;	 Catch:{ all -> 0x0057 }
        r3 = "main";
        r4 = r6.mConfigurationLocked;	 Catch:{ all -> 0x0057 }
        r4 = r4.path;	 Catch:{ all -> 0x0057 }
        r0.<init>(r3, r4);	 Catch:{ all -> 0x0057 }
        r1.add(r0);	 Catch:{ all -> 0x0057 }
        monitor-exit(r2);	 Catch:{ all -> 0x0057 }
        r0 = r1;
        goto L_0x000e;
    L_0x0025:
        r6.acquireReference();	 Catch:{ all -> 0x0057 }
        monitor-exit(r2);	 Catch:{ all -> 0x0057 }
        r2 = "pragma database_list;";
        r3 = 0;
        r2 = r6.rawQuery(r2, r3);	 Catch:{ all -> 0x0064 }
    L_0x0031:
        r0 = r2.moveToNext();	 Catch:{ all -> 0x004a }
        if (r0 == 0) goto L_0x005a;
    L_0x0037:
        r0 = new android.util.Pair;	 Catch:{ all -> 0x004a }
        r3 = 1;
        r3 = r2.getString(r3);	 Catch:{ all -> 0x004a }
        r4 = 2;
        r4 = r2.getString(r4);	 Catch:{ all -> 0x004a }
        r0.<init>(r3, r4);	 Catch:{ all -> 0x004a }
        r1.add(r0);	 Catch:{ all -> 0x004a }
        goto L_0x0031;
    L_0x004a:
        r0 = move-exception;
        r1 = r2;
    L_0x004c:
        if (r1 == 0) goto L_0x0051;
    L_0x004e:
        r1.close();	 Catch:{ all -> 0x0052 }
    L_0x0051:
        throw r0;	 Catch:{ all -> 0x0052 }
    L_0x0052:
        r0 = move-exception;
        r6.releaseReference();
        throw r0;
    L_0x0057:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0057 }
        throw r0;
    L_0x005a:
        if (r2 == 0) goto L_0x005f;
    L_0x005c:
        r2.close();	 Catch:{ all -> 0x0052 }
    L_0x005f:
        r6.releaseReference();
        r0 = r1;
        goto L_0x000e;
    L_0x0064:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wcdb.database.SQLiteDatabase.getAttachedDbs():java.util.List<android.util.Pair<java.lang.String, java.lang.String>>");
    }

    public final boolean isDatabaseIntegrityOk() {
        SQLiteStatement compileStatement;
        Throwable th;
        acquireReference();
        List attachedDbs;
        try {
            attachedDbs = getAttachedDbs();
            if (attachedDbs == null) {
                throw new IllegalStateException("databaselist for: " + getPath() + " couldn't be retrieved. probably because the database is closed");
            }
            List list = attachedDbs;
            int i = 0;
            while (i < list.size()) {
                Pair pair = (Pair) list.get(i);
                try {
                    compileStatement = compileStatement("PRAGMA " + ((String) pair.first) + ".integrity_check(1);");
                    try {
                        String simpleQueryForString = compileStatement.simpleQueryForString();
                        if (simpleQueryForString.equalsIgnoreCase("ok")) {
                            if (compileStatement != null) {
                                compileStatement.close();
                            }
                            i++;
                        } else {
                            Log.e(TAG, "PRAGMA integrity_check on " + ((String) pair.second) + " returned: " + simpleQueryForString);
                            if (compileStatement != null) {
                                compileStatement.close();
                            }
                            releaseReference();
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    compileStatement = null;
                }
            }
            releaseReference();
            return true;
        } catch (SQLiteException e) {
            attachedDbs = new ArrayList();
            attachedDbs.add(new Pair("main", getPath()));
            list = attachedDbs;
        } catch (Throwable th4) {
            releaseReference();
        }
        if (compileStatement != null) {
            compileStatement.close();
        }
        throw th;
    }

    public final long acquireNativeConnectionHandle(String str, boolean z, boolean z2) {
        if (str == null) {
            str = "unnamedNative";
        }
        int i = z ? 1 : 2;
        if (z2) {
            i |= 4;
        }
        long nativeHandle = getThreadSession().acquireConnectionForNativeHandle(i).getNativeHandle(str);
        if (nativeHandle != 0) {
            return nativeHandle;
        }
        throw new IllegalStateException("SQLiteConnection native handle not initialized.");
    }

    public final void releaseNativeConnection(long j, Exception exception) {
        getThreadSession().releaseConnectionForNativeHandle(exception);
    }

    public final String toString() {
        return "SQLiteDatabase: " + getPath();
    }

    private void throwIfNotOpenLocked() {
        if (this.mConnectionPoolLocked == null) {
            throw new IllegalStateException("The database '" + this.mConfigurationLocked.label + "' is not open.");
        }
    }
}
