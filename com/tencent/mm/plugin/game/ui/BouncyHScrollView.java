package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

public class BouncyHScrollView extends HorizontalScrollView {
    private Context mContext;
    private int mwA;

    public BouncyHScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public BouncyHScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mwA = (int) (this.mContext.getResources().getDisplayMetrics().density * 300.0f);
        setOverScrollMode(0);
        setSmoothScrollingEnabled(true);
        setHorizontalFadingEdgeEnabled(false);
    }

    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return super.overScrollBy(i, i2, i3, i4, i5, i6, this.mwA, i8, z);
    }
}
