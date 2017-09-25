package com.tencent.mm.bj.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteCursorDriver;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.database.SQLiteProgram;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class f extends AbstractCursor implements d {
    public static final CursorFactory FACTORY = new CursorFactory() {
        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram) {
            return new f(sQLiteCursorDriver, str, (h) sQLiteProgram);
        }

        public final SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
            return new h(sQLiteDatabase, str, cancellationSignal);
        }
    };
    private Map<String, Integer> mColumnNameMap;
    private final String[] mColumns;
    private int mCount = -1;
    private final SQLiteCursorDriver mDriver;
    private final String mEditTable;
    private final Throwable mStackTrace;
    private int pageSize = 3000;
    private final h uMB;
    public a uMC;
    private boolean uMD;
    private b<a> uME;
    c uMF;
    private boolean uMG;

    public interface a {
        ArrayList<a> ai(ArrayList<Object> arrayList);

        a bNP();
    }

    public f(SQLiteCursorDriver sQLiteCursorDriver, String str, h hVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("query object cannot be null");
        }
        this.mStackTrace = null;
        this.mDriver = sQLiteCursorDriver;
        this.mEditTable = str;
        this.mColumnNameMap = null;
        this.uMB = hVar;
        this.mColumns = hVar.getColumnNames();
        this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
    }

    public final void yR(int i) {
        if (i <= 15000 && i >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            this.pageSize = i;
        }
    }

    public final void ka(boolean z) {
        this.uMD = z;
    }

    public final boolean onMove(int i, int i2) {
        if (!this.uMD) {
            boolean z;
            if (this.uMF == null) {
                bNQ();
            }
            c cVar = this.uMF;
            int i3 = i2 / cVar.uMu;
            if (cVar.uMt.indexOfKey(i3) >= 0) {
                if (((Object[]) cVar.uMt.get(i3))[(i2 % cVar.uMu) * cVar.columnCount] != null) {
                    z = true;
                    if (!z) {
                        yT((i2 / this.pageSize) * this.pageSize);
                    }
                    this.uMF.moveToPosition(i2);
                }
            }
            z = false;
            if (z) {
                yT((i2 / this.pageSize) * this.pageSize);
            }
            this.uMF.moveToPosition(i2);
        } else if (this.uME == null || !this.uME.yS(i2)) {
            yT((i2 / this.pageSize) * this.pageSize);
        }
        return true;
    }

    private void bNQ() {
        if (this.uMF == null) {
            this.uMF = new c(this.mColumns, (byte) 0);
        }
    }

    public final int getCount() {
        boolean z = false;
        if (this.mCount == -1) {
            this.mCount = yT(0);
            if (this.uME != null) {
                if (this.mCount != -1 && this.mCount == this.uME.uMo.size()) {
                    z = true;
                }
                this.uMG = z;
            }
        }
        if (this.uMD) {
            return this.uMG ? this.uME.uMo.size() : this.mCount;
        } else {
            return this.mCount;
        }
    }

    protected final void checkPosition() {
        super.checkPosition();
    }

    private int yT(int i) {
        if (this.uMD) {
            if (this.uME == null) {
                this.uME = new b<a>(this) {
                    final /* synthetic */ f uMH;

                    {
                        this.uMH = r1;
                    }

                    public final a bNP() {
                        f fVar = this.uMH;
                        return fVar.uMC != null ? fVar.uMC.bNP() : null;
                    }

                    public final ArrayList<a> ai(ArrayList<Object> arrayList) {
                        f fVar = this.uMH;
                        return fVar.uMC != null ? fVar.uMC.ai(arrayList) : null;
                    }
                };
            }
            this.uME.mStartPos = i;
            return this.uMB.a(this.uME, i, this.pageSize);
        }
        bNQ();
        return this.uMB.a(this.uMF, i, this.pageSize);
    }

    public final int getColumnIndex(String str) {
        int i;
        if (this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            Map hashMap = new HashMap(length, 1.0f);
            for (i = 0; i < length; i++) {
                hashMap.put(strArr[i], Integer.valueOf(i));
            }
            this.mColumnNameMap = hashMap;
        }
        i = str.lastIndexOf(46);
        if (i != -1) {
            Exception exception = new Exception();
            Log.e("WCDB.SQLiteNewCursor", "requesting column name with table name -- " + str, exception);
            str = str.substring(i + 1);
        }
        Integer num = (Integer) this.mColumnNameMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public final String[] getColumnNames() {
        return this.mColumns;
    }

    public final void deactivate() {
        super.deactivate();
        this.mDriver.cursorDeactivated();
    }

    public final void close() {
        super.close();
        synchronized (this) {
            this.uMB.close();
            this.mDriver.cursorClosed();
        }
    }

    public final boolean requery() {
        boolean z = false;
        if (!isClosed()) {
            synchronized (this) {
                if (this.uMB.getDatabase().isOpen()) {
                    if (this.uME != null) {
                        this.uME.QZ();
                    }
                    this.mPos = -1;
                    this.mCount = -1;
                    this.mDriver.cursorRequeried(this);
                    try {
                        z = super.requery();
                    } catch (IllegalStateException e) {
                        Log.w("WCDB.SQLiteNewCursor", "requery() failed " + e.getMessage(), e);
                    }
                }
            }
        }
        return z;
    }

    protected final void finalize() {
        try {
            if (this.uME != null) {
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final String getString(int i) {
        if (this.uMD) {
            return null;
        }
        return this.uMF.getString(i);
    }

    public final short getShort(int i) {
        if (this.uMD) {
            return (short) 0;
        }
        return this.uMF.getShort(i);
    }

    public final int getInt(int i) {
        if (this.uMD) {
            return 0;
        }
        return this.uMF.getInt(i);
    }

    public final long getLong(int i) {
        if (this.uMD) {
            return 0;
        }
        return this.uMF.getLong(i);
    }

    public final float getFloat(int i) {
        if (this.uMD) {
            return 0.0f;
        }
        return this.uMF.getFloat(i);
    }

    public final double getDouble(int i) {
        if (this.uMD) {
            return 0.0d;
        }
        return this.uMF.getDouble(i);
    }

    public final boolean isNull(int i) {
        if (this.uMD) {
            return false;
        }
        return this.uMF.isNull(i);
    }

    public final byte[] getBlob(int i) {
        if (this.uMD) {
            return null;
        }
        return this.uMF.getBlob(i);
    }

    public final a yQ(int i) {
        a aVar = null;
        int i2 = 0;
        if (this.uME != null) {
            b bVar = this.uME;
            if (bVar.yS(i)) {
                Object obj = bVar.uMo.get(i);
                aVar = (a) bVar.uMq.get(obj);
                if (aVar == null) {
                    w.i("WCDB.CursorDataWindow", "get data null %s", obj);
                    if (bVar.uMr.size() != 0) {
                        ArrayList ai = bVar.ai(bVar.uMr);
                        while (i2 < ai.size()) {
                            aVar = (a) ai.get(i2);
                            if (aVar != null) {
                                bVar.b(aVar.getKey(), aVar);
                            } else {
                                w.e("WCDB.CursorDataWindow", "newcursor obj is null");
                            }
                            i2++;
                        }
                        bVar.uMr.clear();
                    }
                    aVar = (a) bVar.uMq.get(obj);
                    if (aVar == null) {
                        w.e("WCDB.CursorDataWindow", "newcursor error obj : " + obj + "pos:" + i);
                    }
                }
            } else {
                w.e("WCDB.CursorDataWindow", "newcursor cursor getItem error: pos " + i + " loaded num :" + bVar.uMo.size());
            }
        }
        return aVar;
    }

    public final boolean a(Object obj, a aVar) {
        if (this.uMD && this.uME != null) {
            if (!this.uMG && (obj instanceof Object[]) && this.uME.bB(obj)) {
                this.mCount -= ((Object[]) obj).length;
                this.pageSize -= ((Object[]) obj).length;
            }
            b bVar = this.uME;
            if (aVar != null) {
                w.i("WCDB.CursorDataWindow", "newcursor cursor update Memory key : " + obj + "values : " + aVar);
                bVar.b(obj, aVar);
            } else if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                for (Object remove : objArr) {
                    bVar.uMq.remove(remove);
                }
                bVar.q(objArr);
            } else {
                if (bVar.uMr == null) {
                    bVar.uMr = new ArrayList();
                }
                if (!bVar.uMr.contains(obj)) {
                    bVar.uMr.add(obj);
                    w.i("WCDB.CursorDataWindow", "newcursor cursor clearData : " + obj);
                }
                bVar.uMq.remove(obj);
            }
        } else if (!this.uMD) {
            c cVar = this.uMF;
            cVar.mPos = 0;
            cVar.uMt.clear();
        }
        return false;
    }

    public final boolean bNL() {
        return this.uMG;
    }

    public final boolean yP(int i) {
        if (!this.uMD) {
            return false;
        }
        b bVar = this.uME;
        if (i > 50) {
            return false;
        }
        if (bVar.uMp < 10) {
            return true;
        }
        if (((double) i) / ((double) bVar.uMp) < 0.1d) {
            return true;
        }
        return false;
    }

    public final boolean bB(Object obj) {
        if (this.uMD && this.uME != null) {
            return this.uME.bB(obj);
        }
        return false;
    }

    public final a bC(Object obj) {
        if (!this.uMD) {
            Log.e("WCDB.SQLiteNewCursor", "newcursor getItemByKey error " + obj);
            return null;
        } else if (this.uME == null) {
            Log.e("WCDB.SQLiteNewCursor", "newcursor error getItemByKey window is null");
            return null;
        } else {
            b bVar = this.uME;
            if (bVar.uMq != null) {
                return (a) bVar.uMq.get(obj);
            }
            return null;
        }
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void a(a aVar) {
        this.uMC = aVar;
    }

    public final SparseArray<Object>[] bNJ() {
        if (!this.uMD) {
            return null;
        }
        return new SparseArray[]{this.uME.uMo};
    }

    public final HashMap bNK() {
        return this.uME.uMq;
    }
}
