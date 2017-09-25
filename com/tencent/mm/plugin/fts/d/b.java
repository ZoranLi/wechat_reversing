package com.tencent.mm.plugin.fts.d;

import android.content.Context;
import java.util.List;

public abstract class b implements i {
    public Context context;
    public com.tencent.mm.plugin.fts.d.i.b mcw;
    public int mcx;

    public b(Context context, com.tencent.mm.plugin.fts.d.i.b bVar, int i) {
        this.context = context;
        this.mcw = bVar;
        this.mcx = i;
    }

    public static boolean aF(List<? extends Object> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        return true;
    }
}
