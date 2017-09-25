package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class d {
    public static final int syH = R.i.dkp;
    public static final int syI = R.i.dko;
    public SparseArray<Integer> syJ = new SparseArray();

    public d() {
        this.syJ.put(1, Integer.valueOf(syH));
        this.syJ.put(2, Integer.valueOf(syI));
        this.syJ.put(4, Integer.valueOf(syI));
        this.syJ.put(3, Integer.valueOf(syI));
        this.syJ.put(5, Integer.valueOf(syI));
        this.syJ.put(6, Integer.valueOf(syI));
        this.syJ.put(0, Integer.valueOf(syI));
    }

    public static a a(int i, View view, k kVar) {
        switch (i) {
            case 0:
                return new com.tencent.mm.plugin.wenote.ui.nativenote.a.d(view, kVar);
            case 1:
                return new g(view, kVar);
            case 2:
                return new c(view, kVar);
            case 3:
                return new e(view, kVar);
            case 4:
                return new i(view, kVar);
            case 5:
                return new b(view, kVar);
            case 6:
                return new h(view, kVar);
            default:
                return null;
        }
    }
}
