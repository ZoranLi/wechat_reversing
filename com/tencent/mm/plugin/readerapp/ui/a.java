package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ui.k;

public abstract class a<T> extends k<T> implements OnScrollListener {
    private static final String TAG = ("MicroMsg." + a.class.getName());
    protected boolean lre;

    public abstract int aWc();

    public abstract boolean ahI();

    public abstract int ahJ();

    public a(Context context, T t) {
        super(context, t);
        ko(true);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.lre = false;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
