package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;

abstract class p extends w {
    public p(Context context) {
        super(context);
        super.setHorizontallyScrolling(true);
    }

    public void setGravity(int i) {
        super.setGravity(((i & -81) & -49) | 16);
    }

    public final void setSingleLine(boolean z) {
    }

    public final void setInputType(int i) {
        super.setInputType(-131073 & i);
    }

    public boolean canScrollVertically(int i) {
        return false;
    }

    public final boolean YP() {
        return false;
    }
}
