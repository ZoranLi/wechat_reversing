package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;

public abstract class b extends k {
    private int syE;

    public abstract void bCc();

    public abstract void bCd();

    public final void c(RecyclerView recyclerView, int i, int i2) {
        if ((Math.abs(i2) > this.syE ? 1 : 0) == 0 || !recyclerView.canScrollVertically(-1) || !recyclerView.canScrollVertically(1)) {
            return;
        }
        if (i2 < 0) {
            bCc();
        } else if (i2 > 0) {
            bCd();
        }
    }
}
