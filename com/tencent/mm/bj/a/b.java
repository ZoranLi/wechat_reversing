package com.tencent.mm.bj.a;

import android.database.sqlite.SQLiteClosable;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class b<T extends a> extends SQLiteClosable {
    int mStartPos = 0;
    SparseArray<Object> uMo = new SparseArray();
    int uMp;
    HashMap<Object, T> uMq = new HashMap();
    ArrayList<Object> uMr;
    T uMs;

    public abstract ArrayList<T> ai(ArrayList<Object> arrayList);

    public abstract T bNP();

    final void b(Object obj, T t) {
        this.uMq.put(obj, t);
    }

    public final boolean yS(int i) {
        return this.uMo.indexOfKey(i) >= 0;
    }

    public final void dQ(int i, int i2) {
        if (i2 != 0) {
            w.e("WCDB.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", Integer.valueOf(i2), Integer.valueOf(i));
            this.uMo.remove(i);
        } else if (this.uMs != null) {
            Object key = this.uMs.getKey();
            b(key, this.uMs);
            this.uMo.put(i, key);
        }
    }

    public final void QZ() {
        w.i("WCDB.CursorDataWindow", "clearData");
        this.uMo.clear();
        this.uMq.clear();
    }

    protected void onAllReferencesReleased() {
        QZ();
    }

    final void q(Object[] objArr) {
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        for (int i2 = 0; i2 < this.uMo.size(); i2++) {
            int keyAt = this.uMo.keyAt(i2);
            Object valueAt = this.uMo.valueAt(i2);
            Object obj = 1;
            for (Object equals : objArr) {
                if (equals.equals(valueAt)) {
                    i++;
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                sparseArray.put(keyAt - i, valueAt);
            } else {
                w.i("WCDB.CursorDataWindow", "newcursor delete index : " + i2 + " obj : " + valueAt);
            }
        }
        if (this.uMo.size() != sparseArray.size()) {
            w.i("WCDB.CursorDataWindow", "newcursor oldposition size :" + this.uMo.size() + " newposistion Size : " + sparseArray.size());
        }
        this.uMo = sparseArray;
    }

    public final boolean bB(Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 1) {
                if (this.uMq == null || !this.uMq.containsKey(objArr[0])) {
                    return false;
                }
                return true;
            }
        }
        return this.uMq != null && this.uMq.containsKey(obj);
    }
}
