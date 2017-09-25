package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public abstract class a extends t {
    protected k sxO;

    public abstract void a(com.tencent.mm.plugin.wenote.model.a.a aVar, int i, int i2);

    public abstract int bCe();

    public a(View view, k kVar) {
        super(view);
        this.sxO = kVar;
    }
}
