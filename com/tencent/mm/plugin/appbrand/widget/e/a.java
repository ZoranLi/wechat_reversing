package com.tencent.mm.plugin.appbrand.widget.e;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;

public final class a implements LineHeightSpan {
    private final int gravity = 16;
    public int height;

    public final boolean Q(float f) {
        return this.height != Math.round(f);
    }

    public a(float f) {
        this.height = Math.round(f);
    }

    public final void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, FontMetricsInt fontMetricsInt) {
        int i5;
        if ((-fontMetricsInt.ascent) > this.height) {
            i5 = -this.height;
            fontMetricsInt.ascent = i5;
            fontMetricsInt.top = i5;
            fontMetricsInt.descent = 0;
            fontMetricsInt.bottom = 0;
        } else if ((-fontMetricsInt.ascent) + fontMetricsInt.descent > this.height) {
            fontMetricsInt.descent = fontMetricsInt.bottom;
            i5 = fontMetricsInt.descent - this.height;
            fontMetricsInt.ascent = i5;
            fontMetricsInt.top = i5;
        } else if ((-fontMetricsInt.ascent) + fontMetricsInt.bottom > this.height) {
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = fontMetricsInt.ascent + this.height;
        } else if ((-fontMetricsInt.top) + fontMetricsInt.bottom > this.height) {
            fontMetricsInt.top = fontMetricsInt.bottom - this.height;
        } else {
            i5 = this.height - ((-fontMetricsInt.ascent) + fontMetricsInt.descent);
            if (this.gravity == 48) {
                fontMetricsInt.descent += i5;
                fontMetricsInt.bottom = i5 + fontMetricsInt.bottom;
            } else if (this.gravity == 80) {
                fontMetricsInt.top -= i5;
                fontMetricsInt.ascent -= i5;
            } else if (this.gravity == 16) {
                i5 = Math.round(((float) i5) / 2.0f);
                fontMetricsInt.top -= i5;
                fontMetricsInt.ascent -= i5;
                fontMetricsInt.bottom += i5;
                fontMetricsInt.descent = i5 + fontMetricsInt.descent;
            }
        }
    }
}
