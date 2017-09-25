package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;

public class IPCallCounponCardLayout extends RelativeLayout {
    public IPCallCounponCardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public IPCallCounponCardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        super.onMeasure(i, MeasureSpec.makeMeasureSpec((getMeasuredWidth() * 3) / 5, 1073741824));
    }
}
