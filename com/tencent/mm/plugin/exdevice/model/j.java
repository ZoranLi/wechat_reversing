package com.tencent.mm.plugin.exdevice.model;

import android.util.SparseArray;
import java.util.LinkedList;
import java.util.List;

public final class j {
    private static j ldu;
    private SparseArray<List<a>> ldv = new SparseArray();

    public interface a {
        void f(int i, Object... objArr);
    }

    private j() {
    }

    public static j apk() {
        if (ldu == null) {
            ldu = new j();
        }
        return ldu;
    }

    public final boolean a(int i, a aVar) {
        if (aVar == null) {
            return false;
        }
        List list = (List) this.ldv.get(i);
        if (list == null) {
            list = new LinkedList();
            this.ldv.put(i, list);
        } else if (list.contains(aVar)) {
            return false;
        }
        return list.add(aVar);
    }

    public final boolean b(int i, a aVar) {
        List list = (List) this.ldv.get(i);
        if (list != null) {
            list.remove(aVar);
            if (list.size() == 0) {
                this.ldv.remove(i);
            }
        }
        return false;
    }

    public final void g(int i, Object... objArr) {
        List list = (List) this.ldv.get(i);
        if (list != null && list.size() != 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((a) list.get(i2)).f(i, objArr);
            }
        }
    }
}
