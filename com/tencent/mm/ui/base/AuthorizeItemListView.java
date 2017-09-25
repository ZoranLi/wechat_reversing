package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;

public class AuthorizeItemListView extends ListView {
    public int Ul;

    public AuthorizeItemListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AuthorizeItemListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        if (this.Ul <= 5) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        } else {
            super.onMeasure(i, i2);
        }
    }
}
