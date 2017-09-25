package com.tencent.mm.bj.a;

import android.util.SparseArray;
import com.tencent.mm.bj.a.f.a;
import java.util.ArrayList;

public abstract class g<K, T extends a> {
    public d uMI;

    public abstract ArrayList<T> ai(ArrayList<Object> arrayList);

    public abstract T bNR();

    public g(d dVar, int i) {
        this.uMI = dVar;
        this.uMI.ka(true);
        this.uMI.a(new a(this) {
            final /* synthetic */ g uMJ;

            {
                this.uMJ = r1;
            }

            public final a bNP() {
                return this.uMJ.bNR();
            }

            public final ArrayList<a> ai(ArrayList<Object> arrayList) {
                return this.uMJ.ai(arrayList);
            }
        });
        if (i != 0) {
            this.uMI.yR(i);
        }
        getCount();
    }

    public final void close() {
        this.uMI.close();
        this.uMI = null;
    }

    public final int getCount() {
        return this.uMI.getCount();
    }

    public final boolean isClosed() {
        return this.uMI.isClosed();
    }

    public final boolean bNL() {
        return this.uMI.bNL();
    }

    public final void c(Object obj, T t) {
        this.uMI.a(obj, t);
    }

    public final SparseArray<K>[] bNJ() {
        return this.uMI.bNJ();
    }

    public final boolean bB(Object obj) {
        return this.uMI.bB(obj);
    }
}
