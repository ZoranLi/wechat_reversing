package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class DrawedCallBackFrameLayout extends FrameLayout {
    public a vgH;

    public interface a {
        void om();
    }

    public DrawedCallBackFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
        }
        if (this.vgH != null) {
            this.vgH.om();
            this.vgH = null;
        }
    }
}
