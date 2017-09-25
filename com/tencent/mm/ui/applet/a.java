package com.tencent.mm.ui.applet;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

public final class a implements OnScrollListener {
    private OnScrollListener sIl;

    public a() {
        this((byte) 0);
    }

    private a(byte b) {
        this.sIl = null;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.sIl != null) {
            this.sIl.onScroll(absListView, i, i2, i3);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.sIl != null) {
            this.sIl.onScrollStateChanged(absListView, i);
        }
    }
}
