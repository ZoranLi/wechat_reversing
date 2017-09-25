package com.tencent.mm.plugin.appbrand.widget.a;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

public final class c implements Iterator<View> {
    private int jkb = 0;
    private final ViewGroup jrQ;

    public final /* synthetic */ Object next() {
        ViewGroup viewGroup = this.jrQ;
        int i = this.jkb;
        this.jkb = i + 1;
        return viewGroup.getChildAt(i);
    }

    public c(ViewGroup viewGroup) {
        this.jrQ = viewGroup;
    }

    public final boolean hasNext() {
        return this.jkb < this.jrQ.getChildCount();
    }

    public final void remove() {
        this.jrQ.removeViewAt(this.jkb - 1);
    }
}
