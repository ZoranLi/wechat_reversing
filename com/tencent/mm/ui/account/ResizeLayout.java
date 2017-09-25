package com.tencent.mm.ui.account;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ResizeLayout extends LinearLayout {
    public a vbI = null;

    public interface a {
        void bQP();
    }

    public ResizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.vbI != null) {
            this.vbI.bQP();
        }
        super.onSizeChanged(i, i2, i3, i4);
    }
}
