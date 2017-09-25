package com.tencent.mm.bj.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.mm.bj.a.f.a;
import com.tencent.wcdb.AbstractCursor;
import java.util.HashMap;

public final class e extends AbstractCursor implements d {
    private DataSetObserver mObserver = new DataSetObserver(this) {
        final /* synthetic */ e uMA;

        {
            this.uMA = r1;
        }

        public final void onChanged() {
            this.uMA.mPos = -1;
        }

        public final void onInvalidated() {
            this.uMA.mPos = -1;
        }
    };
    private d uMy;
    public d[] uMz;

    public e(f[] fVarArr) {
        int i = 0;
        this.uMz = fVarArr;
        this.uMy = fVarArr[0];
        while (i < this.uMz.length) {
            if (this.uMz[i] != null) {
                this.uMz[i].registerDataSetObserver(this.mObserver);
            }
            i++;
        }
    }

    public final int getCount() {
        int i = 0;
        int length = this.uMz.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.uMz[i2] != null) {
                i += this.uMz[i2].getCount();
            }
        }
        return i;
    }

    public final boolean onMove(int i, int i2) {
        this.uMy = null;
        int length = this.uMz.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.uMz[i4] != null) {
                if (i2 < this.uMz[i4].getCount() + i3) {
                    this.uMy = this.uMz[i4];
                    break;
                }
                i3 += this.uMz[i4].getCount();
            }
        }
        if (this.uMy != null) {
            return this.uMy.moveToPosition(i2 - i3);
        }
        return false;
    }

    public final String getString(int i) {
        return this.uMy.getString(i);
    }

    public final short getShort(int i) {
        return this.uMy.getShort(i);
    }

    public final int getInt(int i) {
        return this.uMy.getInt(i);
    }

    public final long getLong(int i) {
        return this.uMy.getLong(i);
    }

    public final float getFloat(int i) {
        return this.uMy.getFloat(i);
    }

    public final double getDouble(int i) {
        return this.uMy.getDouble(i);
    }

    public final boolean isNull(int i) {
        return this.uMy.isNull(i);
    }

    public final byte[] getBlob(int i) {
        return this.uMy.getBlob(i);
    }

    public final String[] getColumnNames() {
        if (this.uMy != null) {
            return this.uMy.getColumnNames();
        }
        return new String[0];
    }

    public final void deactivate() {
        int length = this.uMz.length;
        for (int i = 0; i < length; i++) {
            if (this.uMz[i] != null) {
                this.uMz[i].deactivate();
            }
        }
        super.deactivate();
    }

    public final void close() {
        int length = this.uMz.length;
        for (int i = 0; i < length; i++) {
            if (this.uMz[i] != null) {
                this.uMz[i].close();
            }
        }
        super.close();
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
        int length = this.uMz.length;
        for (int i = 0; i < length; i++) {
            if (this.uMz[i] != null) {
                this.uMz[i].registerContentObserver(contentObserver);
            }
        }
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
        int length = this.uMz.length;
        for (int i = 0; i < length; i++) {
            if (this.uMz[i] != null) {
                this.uMz[i].unregisterContentObserver(contentObserver);
            }
        }
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        int length = this.uMz.length;
        for (int i = 0; i < length; i++) {
            if (this.uMz[i] != null) {
                this.uMz[i].registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        int length = this.uMz.length;
        for (int i = 0; i < length; i++) {
            if (this.uMz[i] != null) {
                this.uMz[i].unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public final boolean requery() {
        int length = this.uMz.length;
        int i = 0;
        while (i < length) {
            if (this.uMz[i] != null && !this.uMz[i].requery()) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final void a(a aVar) {
        int length = this.uMz.length;
        for (int i = 0; i < length; i++) {
            if (this.uMz[i] != null) {
                this.uMz[i].a(aVar);
            }
        }
    }

    public final void ka(boolean z) {
        int length = this.uMz.length;
        for (int i = 0; i < length; i++) {
            if (this.uMz[i] != null) {
                this.uMz[i].ka(z);
            }
        }
    }

    public final boolean bNL() {
        int length = this.uMz.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            if (!(this.uMz[i] == null || this.uMz[i].bNL())) {
                z = false;
            }
            i++;
        }
        return z;
    }

    public final a yQ(int i) {
        int length = this.uMz.length;
        for (int i2 = 0; i2 < length; i2++) {
            int count = this.uMz[i2].getCount();
            if (i < count) {
                return this.uMz[i2].yQ(i);
            }
            i -= count;
        }
        return null;
    }

    public final boolean a(Object obj, a aVar) {
        boolean z = false;
        int length = this.uMz.length;
        int i = 0;
        while (i < length) {
            if (this.uMz[i] != null && this.uMz[i].a(obj, aVar)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    public final SparseArray<Object>[] bNJ() {
        int length = this.uMz.length;
        SparseArray<Object>[] sparseArrayArr = new SparseArray[length];
        for (int i = 0; i < length; i++) {
            sparseArrayArr[i] = this.uMz[i].bNJ()[0];
        }
        return sparseArrayArr;
    }

    public final HashMap bNK() {
        return null;
    }

    public final boolean yP(int i) {
        int length = this.uMz.length;
        boolean z = true;
        int i2 = 0;
        while (i2 < length) {
            if (!(this.uMz[i2] == null || this.uMz[i2].yP(i))) {
                z = false;
            }
            i2++;
        }
        return z;
    }

    public final boolean bB(Object obj) {
        boolean z = false;
        int length = this.uMz.length;
        int i = 0;
        while (i < length) {
            if (this.uMz[i] != null && this.uMz[i].bB(obj)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    public final a bC(Object obj) {
        return this.uMy.bC(obj);
    }

    public final void yR(int i) {
        int length = this.uMz.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.uMz[i2] != null) {
                this.uMz[i2].yR(i);
            }
        }
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }
}
