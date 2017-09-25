package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;

public class WrappingGridView extends GridView {
    public WrappingGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WrappingGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        if (getLayoutParams().height == -2) {
            i2 = MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }
}
