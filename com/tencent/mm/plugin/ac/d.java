package com.tencent.mm.plugin.ac;

import android.util.SparseArray;

public final class d {
    public SparseArray<b> ptu = new SparseArray();

    public final boolean a(b bVar) {
        this.ptu.put(bVar.getType(), bVar);
        return true;
    }
}
