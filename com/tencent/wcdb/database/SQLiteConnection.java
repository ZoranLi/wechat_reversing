package com.tencent.wcdb.database;

import android.annotation.SuppressLint;
import android.util.Printer;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteDebug.DbStats;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.CancellationSignal.OnCancelListener;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.LruCache;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public final class SQLiteConnection implements OnCancelListener {
    private static final boolean DEBUG = false;
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final String TAG = "WCDB.SQLiteConnection";
    private static final Pattern TRIM_SQL_PATTERN = Pattern.compile("[\\s]*\\n+[\\s]*");
    private Thread mAcquiredThread;
    public int mAcquiredTid;
    private int mCancellationSignalAttachCount;
    private SQLiteCipherSpec mCipher;
    private final SQLiteDatabaseConfiguration mConfiguration;
    private final int mConnectionId;
    private long mConnectionPtr;
    private final boolean mIsPrimaryConnection;
    private final boolean mIsReadOnlyConnection;
    private int mNativeHandleCount;
    private Operation mNativeOperation;
    private boolean mOnlyAllowReadOnlyOperations;
    private byte[] mPassword;
    public final SQLiteConnectionPool mPool;
    private final PreparedStatementCache mPreparedStatementCache;
    private PreparedStatement mPreparedStatementPool;
    public final OperationLog mRecentOperations = new OperationLog();

    @SuppressLint({"SimpleDateFormat"})
    private static final class Operation {
        private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        public ArrayList<Object> mBindArgs;
        public int mCookie;
        public long mEndTime;
        public Exception mException;
        public boolean mFinished;
        public String mKind;
        public String mSql;
        public long mStartTime;
        public int mTid;
        public int mType;

        public final void describe(StringBuilder stringBuilder, boolean z) {
            stringBuilder.append(this.mKind);
            if (this.mFinished) {
                stringBuilder.append(" took ").append(this.mEndTime - this.mStartTime).append("ms");
            } else {
                stringBuilder.append(" started ").append(System.currentTimeMillis() - this.mStartTime).append("ms ago");
            }
            stringBuilder.append(" - ").append(getStatus());
            if (this.mSql != null) {
                stringBuilder.append(", sql=\"").append(SQLiteConnection.trimSqlForDisplay(this.mSql)).append("\"");
            }
            if (this.mTid > 0) {
                stringBuilder.append(", tid=").append(this.mTid);
            }
            if (!(!z || this.mBindArgs == null || this.mBindArgs.size() == 0)) {
                stringBuilder.append(", bindArgs=[");
                int size = this.mBindArgs.size();
                for (int i = 0; i < size; i++) {
                    Object obj = this.mBindArgs.get(i);
                    if (i != 0) {
                        stringBuilder.append(", ");
                    }
                    if (obj == null) {
                        stringBuilder.append("null");
                    } else if (obj instanceof byte[]) {
                        stringBuilder.append("<byte[]>");
                    } else if (obj instanceof String) {
                        stringBuilder.append("\"").append((String) obj).append("\"");
                    } else {
                        stringBuilder.append(obj);
                    }
                }
                stringBuilder.append("]");
            }
            if (this.mException != null && this.mException.getMessage() != null) {
                stringBuilder.append(", exception=\"").append(this.mException.getMessage()).append("\"");
            }
        }

        private String getStatus() {
            if (this.mFinished) {
                return this.mException != null ? "failed" : "succeeded";
            } else {
                return "running";
            }
        }

        public final String getFormattedStartTime() {
            return sDateFormat.format(new Date(this.mStartTime));
        }
    }

    private final class OperationLog {
        private static final int COOKIE_GENERATION_SHIFT = 8;
        private static final int COOKIE_INDEX_MASK = 255;
        private static final int MAX_RECENT_OPERATIONS = 20;
        private int mGeneration;
        private int mIndex;
        private final Operation[] mOperations = new Operation[20];

        public final Operation beginOperation(String str, String str2, Object[] objArr) {
            Operation operation;
            int i = 0;
            synchronized (this.mOperations) {
                int i2 = (this.mIndex + 1) % 20;
                operation = this.mOperations[i2];
                if (operation == null) {
                    operation = new Operation();
                    this.mOperations[i2] = operation;
                } else {
                    operation.mFinished = false;
                    operation.mException = null;
                    if (operation.mBindArgs != null) {
                        operation.mBindArgs.clear();
                    }
                }
                operation.mStartTime = System.currentTimeMillis();
                operation.mKind = str;
                operation.mSql = str2;
                if (objArr != null) {
                    if (operation.mBindArgs == null) {
                        operation.mBindArgs = new ArrayList();
                    } else {
                        operation.mBindArgs.clear();
                    }
                    while (i < objArr.length) {
                        Object obj = objArr[i];
                        if (obj == null || !(obj instanceof byte[])) {
                            operation.mBindArgs.add(obj);
                        } else {
                            operation.mBindArgs.add(SQLiteConnection.EMPTY_BYTE_ARRAY);
                        }
                        i++;
                    }
                }
                operation.mCookie = newOperationCookieLocked(i2);
                operation.mTid = SQLiteConnection.this.mAcquiredTid;
                this.mIndex = i2;
            }
            return operation;
        }

        public final void failOperation(int i, Exception exception) {
            synchronized (this.mOperations) {
                Operation operationLocked = getOperationLocked(i);
                if (operationLocked != null) {
                    operationLocked.mException = exception;
                }
            }
        }

        public final void endOperation(int i) {
            synchronized (this.mOperations) {
                Operation operationLocked = getOperationLocked(i);
                if (endOperationDeferLogLocked(operationLocked)) {
                    logOperationLocked(operationLocked, null);
                }
                String str = operationLocked.mSql;
                String str2 = operationLocked.mKind;
                int i2 = operationLocked.mType;
                long j = operationLocked.mEndTime - operationLocked.mStartTime;
            }
            if (!"prepare".equals(str2)) {
                SQLiteConnection.this.mPool.traceExecute(str, i2, j);
            }
        }

        public final boolean endOperationDeferLog(int i) {
            boolean endOperationDeferLogLocked;
            synchronized (this.mOperations) {
                Operation operationLocked = getOperationLocked(i);
                endOperationDeferLogLocked = endOperationDeferLogLocked(operationLocked);
                String str = operationLocked.mSql;
                String str2 = operationLocked.mKind;
                int i2 = operationLocked.mType;
                long j = operationLocked.mEndTime - operationLocked.mStartTime;
            }
            if (!"prepare".equals(str2)) {
                SQLiteConnection.this.mPool.traceExecute(str, i2, j);
            }
            return endOperationDeferLogLocked;
        }

        public final void logOperation(int i, String str) {
            synchronized (this.mOperations) {
                logOperationLocked(getOperationLocked(i), str);
            }
        }

        private boolean endOperationDeferLogLocked(Operation operation) {
            if (operation == null) {
                return false;
            }
            operation.mEndTime = System.currentTimeMillis();
            operation.mFinished = true;
            if (operation.mException == null || operation.mException.getMessage() == null) {
                return SQLiteDebug.shouldLogSlowQuery(operation.mEndTime - operation.mStartTime);
            }
            return true;
        }

        private void logOperationLocked(Operation operation, String str) {
            StringBuilder stringBuilder = new StringBuilder();
            operation.describe(stringBuilder, false);
            if (str != null) {
                stringBuilder.append(", ").append(str);
            }
            Log.i(SQLiteConnection.TAG, stringBuilder.toString());
        }

        private int newOperationCookieLocked(int i) {
            int i2 = this.mGeneration;
            this.mGeneration = i2 + 1;
            return (i2 << 8) | i;
        }

        private Operation getOperationLocked(int i) {
            Operation operation = this.mOperations[i & 255];
            return operation.mCookie == i ? operation : null;
        }

        public final String describeCurrentOperation() {
            String str;
            synchronized (this.mOperations) {
                Operation operation = this.mOperations[this.mIndex];
                if (operation == null || operation.mFinished) {
                    str = null;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    operation.describe(stringBuilder, false);
                    str = stringBuilder.toString();
                }
            }
            return str;
        }

        public final void dump(Printer printer, boolean z) {
            synchronized (this.mOperations) {
                printer.println("  Most recently executed operations:");
                int i = this.mIndex;
                Operation operation = this.mOperations[i];
                if (operation != null) {
                    Operation operation2 = operation;
                    int i2 = 0;
                    while (true) {
                        int i3;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("    ").append(i2).append(": [");
                        stringBuilder.append(operation2.getFormattedStartTime());
                        stringBuilder.append("] ");
                        operation2.describe(stringBuilder, z);
                        printer.println(stringBuilder.toString());
                        if (i > 0) {
                            i3 = i - 1;
                        } else {
                            i3 = 19;
                        }
                        i2++;
                        Operation operation3 = this.mOperations[i3];
                        if (operation3 == null || i2 >= 20) {
                            break;
                        }
                        Operation operation4 = operation3;
                        i = i3;
                        operation2 = operation4;
                    }
                } else {
                    printer.println("    <none>");
                }
            }
        }
    }

    static final class PreparedStatement {
        private WeakReference<SQLiteConnection> mConnection;
        public boolean mInCache;
        public boolean mInUse;
        public int mNumParameters;
        private Operation mOperation;
        public PreparedStatement mPoolNext;
        public boolean mReadOnly;
        public String mSql;
        public long mStatementPtr;
        public int mType;

        PreparedStatement(SQLiteConnection sQLiteConnection) {
            this.mConnection = new WeakReference(sQLiteConnection);
        }

        public final void bindArguments(Object[] objArr) {
            SQLiteConnection sQLiteConnection = (SQLiteConnection) this.mConnection.get();
            if (sQLiteConnection != null) {
                sQLiteConnection.bindArguments(this, objArr);
            }
        }

        public final void reset(boolean z) {
            SQLiteConnection sQLiteConnection = (SQLiteConnection) this.mConnection.get();
            if (sQLiteConnection != null) {
                sQLiteConnection.resetStatement(this, z);
            }
        }

        public final long getPtr() {
            return this.mStatementPtr;
        }

        public final String getSQL() {
            return this.mSql;
        }

        public final boolean isReadOnly() {
            return this.mReadOnly;
        }

        public final int getType() {
            return this.mType;
        }

        public final void attachCancellationSignal(CancellationSignal cancellationSignal) {
            SQLiteConnection sQLiteConnection = (SQLiteConnection) this.mConnection.get();
            if (sQLiteConnection != null) {
                sQLiteConnection.attachCancellationSignal(cancellationSignal);
            }
        }

        public final void detachCancellationSignal(CancellationSignal cancellationSignal) {
            SQLiteConnection sQLiteConnection = (SQLiteConnection) this.mConnection.get();
            if (sQLiteConnection != null) {
                sQLiteConnection.detachCancellationSignal(cancellationSignal);
            }
        }

        public final void beginOperation(String str, Object[] objArr) {
            SQLiteConnection sQLiteConnection = (SQLiteConnection) this.mConnection.get();
            if (sQLiteConnection != null) {
                this.mOperation = sQLiteConnection.mRecentOperations.beginOperation(str, this.mSql, objArr);
                this.mOperation.mType = this.mType;
            }
        }

        public final void failOperation(Exception exception) {
            if (this.mOperation != null) {
                SQLiteConnection sQLiteConnection = (SQLiteConnection) this.mConnection.get();
                if (sQLiteConnection != null) {
                    sQLiteConnection.mRecentOperations.failOperation(this.mOperation.mCookie, exception);
                }
            }
        }

        public final void endOperation(String str) {
            if (this.mOperation != null) {
                SQLiteConnection sQLiteConnection = (SQLiteConnection) this.mConnection.get();
                if (sQLiteConnection != null) {
                    if (sQLiteConnection.mRecentOperations.endOperationDeferLog(this.mOperation.mCookie)) {
                        sQLiteConnection.mRecentOperations.logOperation(this.mOperation.mCookie, str);
                    }
                    this.mOperation = null;
                }
            }
        }
    }

    private final class PreparedStatementCache extends LruCache<String, PreparedStatement> {
        public PreparedStatementCache(int i) {
            super(i);
        }

        protected final void entryRemoved(boolean z, String str, PreparedStatement preparedStatement, PreparedStatement preparedStatement2) {
            preparedStatement.mInCache = false;
            if (!preparedStatement.mInUse) {
                SQLiteConnection.this.finalizePreparedStatement(preparedStatement);
            }
        }

        public final void dump(Printer printer) {
            printer.println("  Prepared statement cache:");
            Map snapshot = snapshot();
            if (snapshot.isEmpty()) {
                printer.println("    <none>");
                return;
            }
            int i = 0;
            for (Entry entry : snapshot.entrySet()) {
                PreparedStatement preparedStatement = (PreparedStatement) entry.getValue();
                if (preparedStatement.mInCache) {
                    printer.println("    " + i + ": statementPtr=0x" + Long.toHexString(preparedStatement.getPtr()) + ", numParameters=" + preparedStatement.mNumParameters + ", type=" + preparedStatement.mType + ", readOnly=" + preparedStatement.mReadOnly + ", sql=\"" + SQLiteConnection.trimSqlForDisplay((String) entry.getKey()) + "\"");
                }
                i++;
            }
        }
    }

    private static native void nativeBindBlob(long j, long j2, int i, byte[] bArr);

    private static native void nativeBindDouble(long j, long j2, int i, double d);

    private static native void nativeBindLong(long j, long j2, int i, long j3);

    private static native void nativeBindNull(long j, long j2, int i);

    private static native void nativeBindString(long j, long j2, int i, String str);

    private static native void nativeCancel(long j);

    private static native void nativeClose(long j);

    private static native void nativeExecute(long j, long j2);

    private static native int nativeExecuteForChangedRowCount(long j, long j2);

    private static native long nativeExecuteForCursorWindow(long j, long j2, long j3, int i, int i2, boolean z);

    private static native long nativeExecuteForLastInsertedRowId(long j, long j2);

    private static native long nativeExecuteForLong(long j, long j2);

    private static native String nativeExecuteForString(long j, long j2);

    private static native String nativeExplainQueryPlan(long j, String str);

    private static native void nativeFinalizeStatement(long j, long j2);

    private static native int nativeGetColumnCount(long j, long j2);

    private static native String nativeGetColumnName(long j, long j2, int i);

    private static native int nativeGetDbLookaside(long j);

    private static native int nativeGetParameterCount(long j, long j2);

    private static native long nativeGetSQLiteHandle(long j);

    private static native boolean nativeIsReadOnly(long j, long j2);

    private static native long nativeOpen(String str, int i, String str2, String str3);

    private static native long nativePrepareStatement(long j, String str);

    private static native void nativeRegisterCustomFunction(long j, SQLiteCustomFunction sQLiteCustomFunction);

    private static native void nativeRegisterLocalizedCollators(long j, String str);

    private static native void nativeResetCancel(long j, boolean z);

    private static native void nativeResetStatement(long j, long j2, boolean z);

    private static native void nativeSetKey(long j, byte[] bArr);

    private SQLiteConnection(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i, boolean z, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec) {
        this.mPassword = bArr;
        this.mCipher = sQLiteCipherSpec == null ? null : new SQLiteCipherSpec(sQLiteCipherSpec);
        this.mPool = sQLiteConnectionPool;
        this.mConfiguration = new SQLiteDatabaseConfiguration(sQLiteDatabaseConfiguration);
        this.mConnectionId = i;
        this.mIsPrimaryConnection = z;
        this.mIsReadOnlyConnection = (sQLiteDatabaseConfiguration.openFlags & 1) != 0;
        this.mPreparedStatementCache = new PreparedStatementCache(this.mConfiguration.maxSqlCacheSize);
    }

    final long getNativeHandle(String str) {
        if (this.mConnectionPtr == 0) {
            return 0;
        }
        if (str != null && this.mNativeOperation == null) {
            this.mNativeOperation = this.mRecentOperations.beginOperation(str, null, null);
            this.mNativeOperation.mType = 99;
        }
        this.mNativeHandleCount++;
        return nativeGetSQLiteHandle(this.mConnectionPtr);
    }

    final void endNativeHandle(Exception exception) {
        int i = this.mNativeHandleCount - 1;
        this.mNativeHandleCount = i;
        if (i == 0 && this.mNativeOperation != null) {
            if (exception == null) {
                this.mRecentOperations.endOperationDeferLog(this.mNativeOperation.mCookie);
            } else {
                this.mRecentOperations.failOperation(this.mNativeOperation.mCookie, exception);
            }
            this.mNativeOperation = null;
        }
    }

    protected final void finalize() {
        try {
            if (!(this.mPool == null || this.mConnectionPtr == 0)) {
                this.mPool.onConnectionLeaked();
            }
            dispose(true);
        } finally {
            super.finalize();
        }
    }

    static SQLiteConnection open(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i, boolean z, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec) {
        SQLiteConnection sQLiteConnection = new SQLiteConnection(sQLiteConnectionPool, sQLiteDatabaseConfiguration, i, z, bArr, sQLiteCipherSpec);
        try {
            sQLiteConnection.open();
            return sQLiteConnection;
        } catch (SQLiteException e) {
            SQLiteDebug.collectLastIOTraceStats(sQLiteConnection);
            sQLiteConnection.dispose(false);
            throw e;
        }
    }

    final void close() {
        dispose(false);
    }

    private void open() {
        this.mConnectionPtr = nativeOpen(this.mConfiguration.path, this.mConfiguration.openFlags, this.mConfiguration.label, this.mConfiguration.vfsName);
        if (this.mPassword != null && this.mPassword.length == 0) {
            this.mPassword = null;
        }
        if (this.mPassword != null) {
            nativeSetKey(this.mConnectionPtr, this.mPassword);
            setCipherSpec();
        }
        setPageSize();
        setForeignKeyModeFromConfiguration();
        setWalModeFromConfiguration();
        setJournalSizeLimit();
        setAutoCheckpointInterval();
        setLocaleFromConfiguration();
        int size = this.mConfiguration.customFunctions.size();
        for (int i = 0; i < size; i++) {
            nativeRegisterCustomFunction(this.mConnectionPtr, (SQLiteCustomFunction) this.mConfiguration.customFunctions.get(i));
        }
    }

    private void dispose(boolean z) {
        if (this.mConnectionPtr != 0) {
            int i = this.mRecentOperations.beginOperation("close", null, null).mCookie;
            try {
                this.mPreparedStatementCache.evictAll();
                nativeClose(this.mConnectionPtr);
                this.mConnectionPtr = 0;
            } finally {
                this.mRecentOperations.endOperation(i);
            }
        }
    }

    private void setPageSize() {
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection) {
            String str;
            long j;
            if (this.mPassword != null) {
                str = "PRAGMA cipher_page_size";
                j = (this.mCipher == null || this.mCipher.pageSize <= 0) ? (long) SQLiteGlobal.defaultPageSize : (long) this.mCipher.pageSize;
            } else {
                str = "PRAGMA page_size";
                j = (long) SQLiteGlobal.defaultPageSize;
            }
            if (executeForLong(str, null, null) != j) {
                execute(str + "=" + j, null, null);
            }
        }
    }

    private void setCipherSpec() {
        if (this.mCipher != null) {
            if (this.mCipher.cipher != null) {
                execute("PRAGMA cipher=" + DatabaseUtils.sqlEscapeString(this.mCipher.cipher), null, null);
            }
            if (this.mCipher.kdfIteration != 0) {
                execute("PRAGMA kdf_iter=" + this.mCipher.kdfIteration, null, null);
            }
            execute("PRAGMA cipher_use_hmac=" + this.mCipher.hmacEnabled, null, null);
        }
    }

    private void setAutoCheckpointInterval() {
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection && executeForLong("PRAGMA wal_autocheckpoint", null, null) != 100) {
            executeForLong("PRAGMA wal_autocheckpoint=100", null, null);
        }
    }

    private void setJournalSizeLimit() {
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection && executeForLong("PRAGMA journal_size_limit", null, null) != 524288) {
            executeForLong("PRAGMA journal_size_limit=524288", null, null);
        }
    }

    private void setForeignKeyModeFromConfiguration() {
        if (!this.mIsReadOnlyConnection) {
            long j = this.mConfiguration.foreignKeyConstraintsEnabled ? 1 : 0;
            if (executeForLong("PRAGMA foreign_keys", null, null) != j) {
                execute("PRAGMA foreign_keys=" + j, null, null);
            }
        }
    }

    private void setWalModeFromConfiguration() {
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection) {
            if ((this.mConfiguration.openFlags & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0) {
                setJournalMode("WAL");
                setSyncMode("FULL");
                return;
            }
            setJournalMode(SQLiteGlobal.defaultJournalMode);
            setSyncMode("FULL");
        }
    }

    private void setSyncMode(String str) {
        if (!canonicalizeSyncMode(executeForString("PRAGMA synchronous", null, null)).equalsIgnoreCase(canonicalizeSyncMode(str))) {
            execute("PRAGMA synchronous=" + str, null, null);
        }
    }

    private static String canonicalizeSyncMode(String str) {
        if (str.equals("0")) {
            return "OFF";
        }
        if (str.equals("1")) {
            return "NORMAL";
        }
        if (str.equals("2")) {
            return "FULL";
        }
        return str;
    }

    private void setJournalMode(String str) {
        String executeForString = executeForString("PRAGMA journal_mode", null, null);
        if (!executeForString.equalsIgnoreCase(str)) {
            try {
                if (executeForString("PRAGMA journal_mode=" + str, null, null).equalsIgnoreCase(str)) {
                    return;
                }
            } catch (SQLiteDatabaseLockedException e) {
            }
            Log.w(TAG, "Could not change the database journal mode of '" + this.mConfiguration.label + "' from '" + executeForString + "' to '" + str + "' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
        }
    }

    private void setLocaleFromConfiguration() {
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfiguration;
        sQLiteDatabaseConfiguration.openFlags |= 16;
        if ((this.mConfiguration.openFlags & 16) == 0) {
            String locale = this.mConfiguration.locale.toString();
            nativeRegisterLocalizedCollators(this.mConnectionPtr, locale);
            if (!this.mIsReadOnlyConnection) {
                try {
                    execute("CREATE TABLE IF NOT EXISTS android_metadata (locale TEXT)", null, null);
                    String executeForString = executeForString("SELECT locale FROM android_metadata UNION SELECT NULL ORDER BY locale DESC LIMIT 1", null, null);
                    if (executeForString == null || !executeForString.equals(locale)) {
                        execute("BEGIN", null, null);
                        execute("DELETE FROM android_metadata", null, null);
                        execute("INSERT INTO android_metadata (locale) VALUES(?)", new Object[]{locale}, null);
                        execute("REINDEX LOCALIZED", null, null);
                        execute("COMMIT", null, null);
                    }
                } catch (Throwable e) {
                    throw new SQLiteException("Failed to change locale for db '" + this.mConfiguration.label + "' to '" + locale + "'.", e);
                } catch (Throwable th) {
                    execute("ROLLBACK", null, null);
                }
            }
        }
    }

    final void reconfigure(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        boolean z;
        boolean z2 = true;
        this.mOnlyAllowReadOnlyOperations = false;
        int size = sQLiteDatabaseConfiguration.customFunctions.size();
        for (int i = 0; i < size; i++) {
            SQLiteCustomFunction sQLiteCustomFunction = (SQLiteCustomFunction) sQLiteDatabaseConfiguration.customFunctions.get(i);
            if (!this.mConfiguration.customFunctions.contains(sQLiteCustomFunction)) {
                nativeRegisterCustomFunction(this.mConnectionPtr, sQLiteCustomFunction);
            }
        }
        boolean z3 = sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled != this.mConfiguration.foreignKeyConstraintsEnabled;
        if (((sQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags) & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (sQLiteDatabaseConfiguration.locale.equals(this.mConfiguration.locale)) {
            z2 = false;
        }
        this.mConfiguration.updateParametersFrom(sQLiteDatabaseConfiguration);
        this.mPreparedStatementCache.resize(sQLiteDatabaseConfiguration.maxSqlCacheSize);
        if (z3) {
            setForeignKeyModeFromConfiguration();
        }
        if (z) {
            setWalModeFromConfiguration();
        }
        if (z2) {
            setLocaleFromConfiguration();
        }
    }

    final void setOnlyAllowReadOnlyOperations(boolean z) {
        this.mOnlyAllowReadOnlyOperations = z;
    }

    final void setAcquisitionState(Thread thread, int i) {
        this.mAcquiredThread = thread;
        this.mAcquiredTid = i;
    }

    final boolean isPreparedStatementInCache(String str) {
        return this.mPreparedStatementCache.get(str) != null;
    }

    public final int getConnectionId() {
        return this.mConnectionId;
    }

    public final boolean isPrimaryConnection() {
        return this.mIsPrimaryConnection;
    }

    public final void prepare(String str, SQLiteStatementInfo sQLiteStatementInfo) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("prepare", str, null);
        int i = beginOperation.mCookie;
        PreparedStatement acquirePreparedStatement;
        try {
            acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            if (sQLiteStatementInfo != null) {
                sQLiteStatementInfo.numParameters = acquirePreparedStatement.mNumParameters;
                sQLiteStatementInfo.readOnly = acquirePreparedStatement.mReadOnly;
                int nativeGetColumnCount = nativeGetColumnCount(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                if (nativeGetColumnCount == 0) {
                    sQLiteStatementInfo.columnNames = EMPTY_STRING_ARRAY;
                } else {
                    sQLiteStatementInfo.columnNames = new String[nativeGetColumnCount];
                    for (int i2 = 0; i2 < nativeGetColumnCount; i2++) {
                        sQLiteStatementInfo.columnNames[i2] = nativeGetColumnName(this.mConnectionPtr, acquirePreparedStatement.getPtr(), i2);
                    }
                }
            }
            releasePreparedStatement(acquirePreparedStatement);
            this.mRecentOperations.endOperation(i);
        } catch (Exception e) {
            try {
                if (((e instanceof SQLiteDatabaseLockedException) || (e instanceof SQLiteTableLockedException)) && this.mPool != null) {
                    this.mPool.logConnectionPoolBusy(str);
                }
                this.mRecentOperations.failOperation(i, e);
                throw e;
            } catch (Throwable th) {
                this.mRecentOperations.endOperation(i);
            }
        } catch (Throwable th2) {
            releasePreparedStatement(acquirePreparedStatement);
        }
    }

    public final void execute(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("execute", str, objArr);
        int i = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                nativeExecute(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(i);
            } catch (Throwable th) {
                releasePreparedStatement(acquirePreparedStatement);
            }
        } catch (Exception e) {
            try {
                if (((e instanceof SQLiteDatabaseLockedException) || (e instanceof SQLiteTableLockedException)) && this.mPool != null) {
                    this.mPool.logConnectionPoolBusy(str);
                }
                this.mRecentOperations.failOperation(i, e);
                throw e;
            } catch (Throwable th2) {
                this.mRecentOperations.endOperation(i);
            }
        }
    }

    public final long executeForLong(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("executeForLong", str, objArr);
        int i = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                long nativeExecuteForLong = nativeExecuteForLong(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(i);
                return nativeExecuteForLong;
            } catch (Throwable th) {
                releasePreparedStatement(acquirePreparedStatement);
            }
        } catch (Exception e) {
            try {
                if (((e instanceof SQLiteDatabaseLockedException) || (e instanceof SQLiteTableLockedException)) && this.mPool != null) {
                    this.mPool.logConnectionPoolBusy(str);
                }
                this.mRecentOperations.failOperation(i, e);
                throw e;
            } catch (Throwable th2) {
                this.mRecentOperations.endOperation(i);
            }
        }
    }

    public final String executeForString(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("executeForString", str, objArr);
        int i = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                String nativeExecuteForString = nativeExecuteForString(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(i);
                return nativeExecuteForString;
            } catch (Throwable th) {
                releasePreparedStatement(acquirePreparedStatement);
            }
        } catch (Exception e) {
            try {
                if (((e instanceof SQLiteDatabaseLockedException) || (e instanceof SQLiteTableLockedException)) && this.mPool != null) {
                    this.mPool.logConnectionPoolBusy(str);
                }
                this.mRecentOperations.failOperation(i, e);
                throw e;
            } catch (Throwable th2) {
                this.mRecentOperations.endOperation(i);
            }
        }
    }

    public final int executeForChangedRowCount(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        int i = 0;
        Operation beginOperation = this.mRecentOperations.beginOperation("executeForChangedRowCount", str, objArr);
        int i2 = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                i = nativeExecuteForChangedRowCount(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                if (this.mRecentOperations.endOperationDeferLog(i2)) {
                    this.mRecentOperations.logOperation(i2, "changedRows=" + i);
                }
                return i;
            } catch (Throwable th) {
                releasePreparedStatement(acquirePreparedStatement);
            }
        } catch (Exception e) {
            try {
                if (((e instanceof SQLiteDatabaseLockedException) || (e instanceof SQLiteTableLockedException)) && this.mPool != null) {
                    this.mPool.logConnectionPoolBusy(str);
                }
                this.mRecentOperations.failOperation(i2, e);
                throw e;
            } catch (Throwable th2) {
                if (this.mRecentOperations.endOperationDeferLog(i2)) {
                    this.mRecentOperations.logOperation(i2, "changedRows=" + i);
                }
            }
        }
    }

    public final long executeForLastInsertedRowId(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("executeForLastInsertedRowId", str, objArr);
        int i = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                long nativeExecuteForLastInsertedRowId = nativeExecuteForLastInsertedRowId(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                detachCancellationSignal(cancellationSignal);
                releasePreparedStatement(acquirePreparedStatement);
                this.mRecentOperations.endOperation(i);
                return nativeExecuteForLastInsertedRowId;
            } catch (Throwable th) {
                releasePreparedStatement(acquirePreparedStatement);
            }
        } catch (Exception e) {
            try {
                if (((e instanceof SQLiteDatabaseLockedException) || (e instanceof SQLiteTableLockedException)) && this.mPool != null) {
                    this.mPool.logConnectionPoolBusy(str);
                }
                this.mRecentOperations.failOperation(i, e);
                throw e;
            } catch (Throwable th2) {
                this.mRecentOperations.endOperation(i);
            }
        }
    }

    public final int executeForCursorWindow(String str, Object[] objArr, CursorWindow cursorWindow, int i, int i2, boolean z, CancellationSignal cancellationSignal) {
        int i3;
        int i4;
        int numRows;
        Throwable th;
        Exception e;
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (cursorWindow == null) {
            throw new IllegalArgumentException("window must not be null.");
        } else {
            cursorWindow.acquireReference();
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            try {
                Operation beginOperation = this.mRecentOperations.beginOperation("executeForCursorWindow", str, objArr);
                int i8 = beginOperation.mCookie;
                try {
                    PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
                    beginOperation.mType = acquirePreparedStatement.mType;
                    try {
                        throwIfStatementForbidden(acquirePreparedStatement);
                        bindArguments(acquirePreparedStatement, objArr);
                        applyBlockGuardPolicy(acquirePreparedStatement);
                        attachCancellationSignal(cancellationSignal);
                        try {
                            long nativeExecuteForCursorWindow = nativeExecuteForCursorWindow(this.mConnectionPtr, acquirePreparedStatement.getPtr(), cursorWindow.mWindowPtr, i, i2, z);
                            i3 = (int) (nativeExecuteForCursorWindow >> 32);
                            i4 = (int) nativeExecuteForCursorWindow;
                            try {
                                numRows = cursorWindow.getNumRows();
                                try {
                                    cursorWindow.setStartPosition(i3);
                                } catch (Throwable th2) {
                                    th = th2;
                                    detachCancellationSignal(cancellationSignal);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                numRows = -1;
                                detachCancellationSignal(cancellationSignal);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            numRows = -1;
                            i4 = -1;
                            i3 = -1;
                            detachCancellationSignal(cancellationSignal);
                            throw th;
                        }
                        try {
                            detachCancellationSignal(cancellationSignal);
                            try {
                                releasePreparedStatement(acquirePreparedStatement);
                                if (this.mRecentOperations.endOperationDeferLog(i8)) {
                                    this.mRecentOperations.logOperation(i8, "window='" + cursorWindow + "', startPos=" + i + ", actualPos=" + i3 + ", filledRows=" + numRows + ", countedRows=" + i4);
                                }
                                cursorWindow.releaseReference();
                                return i4;
                            } catch (RuntimeException e2) {
                                e = e2;
                                i7 = numRows;
                                i6 = i4;
                                i5 = i3;
                                try {
                                    this.mPool.logConnectionPoolBusy(str);
                                    this.mRecentOperations.failOperation(i8, e);
                                    throw e;
                                } catch (Throwable th5) {
                                    th = th5;
                                    if (this.mRecentOperations.endOperationDeferLog(i8)) {
                                        this.mRecentOperations.logOperation(i8, "window='" + cursorWindow + "', startPos=" + i + ", actualPos=" + i5 + ", filledRows=" + i7 + ", countedRows=" + i6);
                                    }
                                    throw th;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                i7 = numRows;
                                i6 = i4;
                                i5 = i3;
                                if (this.mRecentOperations.endOperationDeferLog(i8)) {
                                    this.mRecentOperations.logOperation(i8, "window='" + cursorWindow + "', startPos=" + i + ", actualPos=" + i5 + ", filledRows=" + i7 + ", countedRows=" + i6);
                                }
                                throw th;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            i7 = numRows;
                            i6 = i4;
                            i5 = i3;
                            releasePreparedStatement(acquirePreparedStatement);
                            throw th;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        releasePreparedStatement(acquirePreparedStatement);
                        throw th;
                    }
                } catch (RuntimeException e3) {
                    e = e3;
                    if (((e instanceof SQLiteDatabaseLockedException) || (e instanceof SQLiteTableLockedException)) && this.mPool != null) {
                        this.mPool.logConnectionPoolBusy(str);
                    }
                    this.mRecentOperations.failOperation(i8, e);
                    throw e;
                }
            } catch (Throwable th9) {
                cursorWindow.releaseReference();
            }
        }
    }

    public final String explainQueryPlan(String str) {
        return nativeExplainQueryPlan(this.mConnectionPtr, str);
    }

    final PreparedStatement acquirePreparedStatement(String str) {
        long nativePrepareStatement;
        PreparedStatement preparedStatement = (PreparedStatement) this.mPreparedStatementCache.get(str);
        boolean z;
        int nativeGetParameterCount;
        int sqlStatementType;
        if (preparedStatement == null) {
            z = false;
            nativePrepareStatement = nativePrepareStatement(this.mConnectionPtr, str);
            nativeGetParameterCount = nativeGetParameterCount(this.mConnectionPtr, nativePrepareStatement);
            sqlStatementType = DatabaseUtils.getSqlStatementType(str);
            preparedStatement = obtainPreparedStatement(str, nativePrepareStatement, nativeGetParameterCount, sqlStatementType, nativeIsReadOnly(this.mConnectionPtr, nativePrepareStatement));
            this.mPreparedStatementCache.put(str, preparedStatement);
            preparedStatement.mInCache = true;
            preparedStatement.mInUse = true;
        } else if (preparedStatement.mInUse) {
            z = true;
            nativePrepareStatement = nativePrepareStatement(this.mConnectionPtr, str);
            try {
                nativeGetParameterCount = nativeGetParameterCount(this.mConnectionPtr, nativePrepareStatement);
                sqlStatementType = DatabaseUtils.getSqlStatementType(str);
                preparedStatement = obtainPreparedStatement(str, nativePrepareStatement, nativeGetParameterCount, sqlStatementType, nativeIsReadOnly(this.mConnectionPtr, nativePrepareStatement));
                if (!z && isCacheable(sqlStatementType)) {
                    this.mPreparedStatementCache.put(str, preparedStatement);
                    preparedStatement.mInCache = true;
                }
                preparedStatement.mInUse = true;
            } catch (RuntimeException e) {
                if (preparedStatement == null || !preparedStatement.mInCache) {
                    nativeFinalizeStatement(this.mConnectionPtr, nativePrepareStatement);
                }
                throw e;
            }
        } else {
            preparedStatement.mInUse = true;
        }
        return preparedStatement;
    }

    final void releasePreparedStatement(PreparedStatement preparedStatement) {
        preparedStatement.mInUse = false;
        if (preparedStatement.mInCache) {
            try {
                resetStatement(preparedStatement, true);
                return;
            } catch (SQLiteException e) {
                this.mPreparedStatementCache.remove(preparedStatement.mSql);
                return;
            }
        }
        finalizePreparedStatement(preparedStatement);
    }

    public final void finalizePreparedStatement(PreparedStatement preparedStatement) {
        nativeFinalizeStatement(this.mConnectionPtr, preparedStatement.getPtr());
        recyclePreparedStatement(preparedStatement);
    }

    public final void attachCancellationSignal(CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
            this.mCancellationSignalAttachCount++;
            if (this.mCancellationSignalAttachCount == 1) {
                nativeResetCancel(this.mConnectionPtr, true);
                cancellationSignal.setOnCancelListener(this);
            }
        }
    }

    public final void detachCancellationSignal(CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            this.mCancellationSignalAttachCount--;
            if (this.mCancellationSignalAttachCount == 0) {
                cancellationSignal.setOnCancelListener(null);
                nativeResetCancel(this.mConnectionPtr, false);
            }
        }
    }

    public final void onCancel() {
        nativeCancel(this.mConnectionPtr);
    }

    public final void bindArguments(PreparedStatement preparedStatement, Object[] objArr) {
        int length;
        if (objArr != null) {
            length = objArr.length;
        } else {
            length = 0;
        }
        if (length != preparedStatement.mNumParameters) {
            throw new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + preparedStatement.mNumParameters + " bind arguments but " + length + " were provided.");
        } else if (length != 0) {
            long ptr = preparedStatement.getPtr();
            for (int i = 0; i < length; i++) {
                Object obj = objArr[i];
                switch (DatabaseUtils.getTypeOfObject(obj)) {
                    case 0:
                        nativeBindNull(this.mConnectionPtr, ptr, i + 1);
                        break;
                    case 1:
                        nativeBindLong(this.mConnectionPtr, ptr, i + 1, ((Number) obj).longValue());
                        break;
                    case 2:
                        nativeBindDouble(this.mConnectionPtr, ptr, i + 1, ((Number) obj).doubleValue());
                        break;
                    case 4:
                        nativeBindBlob(this.mConnectionPtr, ptr, i + 1, (byte[]) obj);
                        break;
                    default:
                        if (!(obj instanceof Boolean)) {
                            nativeBindString(this.mConnectionPtr, ptr, i + 1, obj.toString());
                            break;
                        } else {
                            nativeBindLong(this.mConnectionPtr, ptr, i + 1, ((Boolean) obj).booleanValue() ? 1 : 0);
                            break;
                        }
                }
            }
        }
    }

    public final void resetStatement(PreparedStatement preparedStatement, boolean z) {
        nativeResetStatement(this.mConnectionPtr, preparedStatement.getPtr(), z);
    }

    private void throwIfStatementForbidden(PreparedStatement preparedStatement) {
        if (this.mOnlyAllowReadOnlyOperations && !preparedStatement.mReadOnly) {
            throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
        }
    }

    private static boolean isCacheable(int i) {
        if (i == 2 || i == 1) {
            return true;
        }
        return false;
    }

    private void applyBlockGuardPolicy(PreparedStatement preparedStatement) {
        this.mConfiguration.isInMemoryDb();
    }

    public final void dump(Printer printer, boolean z) {
        dumpUnsafe(printer, z);
    }

    final void dumpUnsafe(Printer printer, boolean z) {
        printer.println("Connection #" + this.mConnectionId + ":");
        if (z) {
            printer.println("  connectionPtr: 0x" + Long.toHexString(this.mConnectionPtr));
        }
        printer.println("  isPrimaryConnection: " + this.mIsPrimaryConnection);
        printer.println("  onlyAllowReadOnlyOperations: " + this.mOnlyAllowReadOnlyOperations);
        if (this.mAcquiredThread != null) {
            printer.println("  acquiredThread: " + this.mAcquiredThread + " (tid: " + this.mAcquiredTid + ")");
        }
        this.mRecentOperations.dump(printer, z);
        if (z) {
            this.mPreparedStatementCache.dump(printer);
        }
    }

    final String describeCurrentOperationUnsafe() {
        return this.mRecentOperations.describeCurrentOperation();
    }

    final void collectDbStats(ArrayList<DbStats> arrayList) {
        int nativeGetDbLookaside = nativeGetDbLookaside(this.mConnectionPtr);
        long j = 0;
        long j2 = 0;
        try {
            j = executeForLong("PRAGMA page_count;", null, null);
            j2 = executeForLong("PRAGMA page_size;", null, null);
        } catch (SQLiteException e) {
        }
        arrayList.add(getMainDbStatsUnsafe(nativeGetDbLookaside, j, j2));
        CursorWindow cursorWindow = new CursorWindow("collectDbStats");
        try {
            executeForCursorWindow("PRAGMA database_list;", null, cursorWindow, 0, 0, false, null);
            for (int i = 1; i < cursorWindow.getNumRows(); i++) {
                long j3;
                String string = cursorWindow.getString(i, 1);
                String string2 = cursorWindow.getString(i, 2);
                long j4 = 0;
                long j5 = 0;
                try {
                    j4 = executeForLong("PRAGMA " + string + ".page_count;", null, null);
                    j5 = executeForLong("PRAGMA " + string + ".page_size;", null, null);
                    j3 = j4;
                } catch (SQLiteException e2) {
                    j3 = j4;
                } finally {
                    cursorWindow.close();
                }
                String str = "  (attached) " + string;
                if (string2.length() != 0) {
                    str = str + ": " + string2;
                }
                arrayList.add(new DbStats(str, j3, j5, 0, 0, 0, 0));
            }
        } catch (SQLiteException e3) {
        } finally {
            cursorWindow.close();
        }
    }

    final void collectDbStatsUnsafe(ArrayList<DbStats> arrayList) {
        arrayList.add(getMainDbStatsUnsafe(0, 0, 0));
    }

    private DbStats getMainDbStatsUnsafe(int i, long j, long j2) {
        String str = this.mConfiguration.path;
        if (!this.mIsPrimaryConnection) {
            str = str + " (" + this.mConnectionId + ")";
        }
        return new DbStats(str, j, j2, i, this.mPreparedStatementCache.hitCount(), this.mPreparedStatementCache.missCount(), this.mPreparedStatementCache.size());
    }

    public final String toString() {
        return "SQLiteConnection: " + this.mConfiguration.path + " (" + this.mConnectionId + ")";
    }

    private PreparedStatement obtainPreparedStatement(String str, long j, int i, int i2, boolean z) {
        PreparedStatement preparedStatement = this.mPreparedStatementPool;
        if (preparedStatement != null) {
            this.mPreparedStatementPool = preparedStatement.mPoolNext;
            preparedStatement.mPoolNext = null;
            preparedStatement.mInCache = false;
        } else {
            preparedStatement = new PreparedStatement(this);
        }
        preparedStatement.mSql = str;
        preparedStatement.mStatementPtr = j;
        preparedStatement.mNumParameters = i;
        preparedStatement.mType = i2;
        preparedStatement.mReadOnly = z;
        return preparedStatement;
    }

    private void recyclePreparedStatement(PreparedStatement preparedStatement) {
        preparedStatement.mSql = null;
        preparedStatement.mPoolNext = this.mPreparedStatementPool;
        this.mPreparedStatementPool = preparedStatement;
    }

    public static String trimSqlForDisplay(String str) {
        return TRIM_SQL_PATTERN.matcher(str).replaceAll(" ");
    }
}
