package com.tencent.wcdb.support;

import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import java.io.File;

public final class Context {
    public static final int MODE_ENABLE_WRITE_AHEAD_LOGGING = 8;

    static {
        SQLiteDatabase.loadLib();
    }

    private static File getDataDirFile(android.content.Context context) {
        if (context != null) {
            String str = context.getApplicationInfo().dataDir;
            return str != null ? new File(str) : null;
        } else {
            throw new RuntimeException("Not supported in system context");
        }
    }

    private static File getDatabasesDir(android.content.Context context) {
        File file = new File(getDataDirFile(context), "databases");
        if (file.getPath().equals("databases")) {
            return new File("/data/system");
        }
        return file;
    }

    private static File makeFilename(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private static File validateFilePath(android.content.Context context, String str, boolean z) {
        File file;
        File file2;
        if (str.charAt(0) == File.separatorChar) {
            file = new File(str.substring(0, str.lastIndexOf(File.separatorChar)));
            file2 = new File(file, str.substring(str.lastIndexOf(File.separatorChar)));
        } else {
            file = getDatabasesDir(context);
            file2 = makeFilename(file, str);
        }
        if (z && !file.isDirectory() && file.mkdir()) {
            FileUtils.setPermissions(file.getPath(), 505, -1, -1);
        }
        return file2;
    }

    private static void setFilePermissionsFromMode(String str, int i, int i2) {
        int i3 = i2 | 432;
        if ((i & 1) != 0) {
            i3 |= 4;
        }
        if ((i & 2) != 0) {
            i3 |= 2;
        }
        FileUtils.setPermissions(str, i3, -1, -1);
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context context, String str, int i, CursorFactory cursorFactory) {
        return openOrCreateDatabase(context, str, null, null, i, cursorFactory, null);
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context context, String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return openOrCreateDatabase(context, str, null, null, i, cursorFactory, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context context, String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i, CursorFactory cursorFactory) {
        return openOrCreateDatabase(context, str, bArr, sQLiteCipherSpec, i, cursorFactory, null);
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context context, String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        File validateFilePath = validateFilePath(context, str, true);
        int i2 = SQLiteDatabase.CREATE_IF_NECESSARY;
        if ((i & 8) != 0) {
            i2 = 805306368;
        }
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(validateFilePath.getPath(), bArr, sQLiteCipherSpec, cursorFactory, i2, databaseErrorHandler, 0);
        setFilePermissionsFromMode(validateFilePath.getPath(), i, 0);
        return openDatabase;
    }
}
