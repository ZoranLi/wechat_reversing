package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.z;

final class h extends z {
    private final LinearLayoutManager jnC;
    private final int jnD = 3000;
    private final int jnE;

    h(Context context, LinearLayoutManager linearLayoutManager) {
        super(context);
        this.jnC = linearLayoutManager;
        this.jnE = Math.round(((float) context.getResources().getDisplayMetrics().heightPixels) * 0.75f);
    }

    protected final int aZ(int i) {
        return super.aZ(Math.max(this.jnE, Math.min(this.jnD, i)));
    }

    public final PointF aW(int i) {
        return this.jnC.aW(i);
    }
}
