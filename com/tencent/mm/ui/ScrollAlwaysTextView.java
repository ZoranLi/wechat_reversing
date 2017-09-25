package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

public class ScrollAlwaysTextView extends TextView {
    public ScrollAlwaysTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public ScrollAlwaysTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            super.onFocusChanged(z, i, rect);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            super.onWindowFocusChanged(z);
        }
    }

    public boolean isFocused() {
        return true;
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Throwable th) {
        }
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            return -1;
        }
    }

    public boolean onPreDraw() {
        try {
            return super.onPreDraw();
        } catch (Throwable th) {
            return true;
        }
    }
}
