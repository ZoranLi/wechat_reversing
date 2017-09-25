package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.c.v;
import com.google.android.gms.c.w;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

final class ap implements c {
    public static final String aFw = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", Columns.VALUE, "expires"});
    private final Executor aFx;
    private a aFy;
    private int aFz;
    private v ahZ;
    public final Context mContext;

    class a extends SQLiteOpenHelper {
        final /* synthetic */ ap aFC;

        a(ap apVar, Context context, String str) {
            this.aFC = apVar;
            super(context, str, null, 1);
        }

        private static boolean b(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            Throwable th;
            Cursor cursor2 = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        new StringBuilder("Error querying for table ").append(str);
                        m.lS();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
                new StringBuilder("Error querying for table ").append(str);
                m.lS();
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        public final SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.aFC.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            String path = sQLiteDatabase.getPath();
            if (h.version() >= 9) {
                File file = new File(path);
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
        }

        public final void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (b("datalayer", sQLiteDatabase)) {
                Cursor rawQuery2 = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
                Set hashSet = new HashSet();
                try {
                    String[] columnNames = rawQuery2.getColumnNames();
                    for (Object add : columnNames) {
                        hashSet.add(add);
                    }
                    if (!hashSet.remove("key") || !hashSet.remove(Columns.VALUE) || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                        throw new SQLiteException("Database column missing");
                    } else if (!hashSet.isEmpty()) {
                        throw new SQLiteException("Database has extra columns");
                    }
                } finally {
                    rawQuery2.close();
                }
            } else {
                sQLiteDatabase.execSQL(ap.aFw);
            }
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    private static class b {
        final byte[] aFE;
        final String azV;

        b(String str, byte[] bArr) {
            this.azV = str;
            this.aFE = bArr;
        }

        public final String toString() {
            return "KeyAndSerialized: key = " + this.azV + " serialized hash = " + Arrays.hashCode(this.aFE);
        }
    }

    public ap(Context context) {
        this(context, w.kV(), "google_tagmanager.db", Executors.newSingleThreadExecutor());
    }

    private ap(Context context, v vVar, String str, Executor executor) {
        this.mContext = context;
        this.ahZ = vVar;
        this.aFz = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
        this.aFx = executor;
        this.aFy = new a(this, this.mContext, str);
    }

    private static byte[] ah(Object obj) {
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private SQLiteDatabase aq(String str) {
        try {
            return this.aFy.getWritableDatabase();
        } catch (SQLiteException e) {
            m.lS();
            return null;
        }
    }

    private void c(List<b> list, long j) {
        SQLiteDatabase aq = aq("Error opening database for writeEntryToDatabase.");
        if (aq != null) {
            for (b bVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", bVar.azV);
                contentValues.put(Columns.VALUE, bVar.aFE);
                aq.insert("datalayer", null, contentValues);
            }
        }
    }

    private List<String> cw(int i) {
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            m.lS();
            return arrayList;
        }
        SQLiteDatabase aq = aq("Error opening database for peekEntryIds.");
        if (aq == null) {
            return arrayList;
        }
        Cursor query;
        try {
            query = aq.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    new StringBuilder("Error in peekEntries fetching entryIds: ").append(e.getMessage());
                    m.lS();
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            new StringBuilder("Error in peekEntries fetching entryIds: ").append(e.getMessage());
            m.lS();
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    private static Object h(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream2 = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (ClassNotFoundException e8) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream = objectInputStream2;
            th = th4;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject;
    }

    private void m(long j) {
        SQLiteDatabase aq = aq("Error opening database for deleteOlderThan.");
        if (aq != null) {
            try {
                new StringBuilder("Deleted ").append(aq.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)})).append(" expired items");
                m.lU();
            } catch (SQLiteException e) {
                m.lS();
            }
        }
    }

    private void mA() {
        try {
            this.aFy.close();
        } catch (SQLiteException e) {
        }
    }

    private List<b> my() {
        SQLiteDatabase aq = aq("Error opening database for loadSerialized.");
        List<b> arrayList = new ArrayList();
        if (aq == null) {
            return arrayList;
        }
        Cursor query = aq.query("datalayer", new String[]{"key", Columns.VALUE}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new b(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int mz() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase aq = aq("Error opening database for getNumStoredEntries.");
        if (aq != null) {
            try {
                cursor = aq.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                m.lS();
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    public final void a(final com.google.android.gms.tagmanager.c.c.a aVar) {
        this.aFx.execute(new Runnable(this) {
            final /* synthetic */ ap aFC;

            public final void run() {
                aVar.l(this.aFC.mx());
            }
        });
    }

    public final void a(List<a> list, final long j) {
        final List arrayList = new ArrayList();
        for (a aVar : list) {
            arrayList.add(new b(aVar.azV, ah(aVar.aDV)));
        }
        this.aFx.execute(new Runnable(this) {
            final /* synthetic */ ap aFC;

            public final void run() {
                this.aFC.b(arrayList, j);
            }
        });
    }

    public final synchronized void b(List<b> list, long j) {
        long currentTimeMillis;
        String[] strArr;
        try {
            currentTimeMillis = this.ahZ.currentTimeMillis();
            m(currentTimeMillis);
            int size = list.size() + (mz() - this.aFz);
            if (size > 0) {
                List cw = cw(size);
                new StringBuilder("DataLayer store full, deleting ").append(cw.size()).append(" entries to make room.");
                m.lT();
                strArr = (String[]) cw.toArray(new String[0]);
                if (!(strArr == null || strArr.length == 0)) {
                    SQLiteDatabase aq = aq("Error opening database for deleteEntries.");
                    if (aq != null) {
                        aq.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                    }
                }
            }
        } catch (SQLiteException e) {
            new StringBuilder("Error deleting entries ").append(Arrays.toString(strArr));
            m.lS();
        } catch (Throwable th) {
            mA();
        }
        c(list, currentTimeMillis + j);
        mA();
    }

    public final List<a> mx() {
        try {
            m(this.ahZ.currentTimeMillis());
            List<b> my = my();
            List<a> arrayList = new ArrayList();
            for (b bVar : my) {
                arrayList.add(new a(bVar.azV, h(bVar.aFE)));
            }
            return arrayList;
        } finally {
            mA();
        }
    }
}
