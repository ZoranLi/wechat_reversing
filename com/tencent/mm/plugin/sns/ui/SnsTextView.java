package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class SnsTextView extends TextView {
    public String neH = "";
    private char qHu = '\u0000';

    public SnsTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTextContextMenuItem(int i) {
        return super.onTextContextMenuItem(i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        if (p.gRl.gQk == 1 || p.gRl.gQk == -1) {
            try {
                super.onMeasure(i, i2);
                this.qHu = '\u0000';
                return;
            } catch (IndexOutOfBoundsException e) {
                if (this.qHu < '\u0003') {
                    try {
                        CharSequence spannableStringBuilder = new SpannableStringBuilder(getText());
                        MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MetricAffectingSpan.class);
                        if (metricAffectingSpanArr == null || metricAffectingSpanArr.length <= 0) {
                            this.qHu = 'd';
                        } else {
                            spannableStringBuilder.insert(spannableStringBuilder.getSpanStart(metricAffectingSpanArr[0]) - 1, " ");
                            this.qHu = (char) (this.qHu + 1);
                        }
                        setText(spannableStringBuilder);
                        onMeasure(i, i2);
                        return;
                    } catch (IndexOutOfBoundsException e2) {
                        w.i("MicroMsg.SnsTextView", "tryToFix error set origintext " + bg.mA(this.neH));
                        setText(this.neH);
                        onMeasure(i, i2);
                        this.qHu = (char) (this.qHu + 1);
                        return;
                    }
                } else if (this.qHu == '\u0003') {
                    w.i("MicroMsg.SnsTextView", "fix error set origintext " + bg.mA(this.neH));
                    setText(this.neH);
                    onMeasure(i, i2);
                    this.qHu = (char) (this.qHu + 1);
                    return;
                } else {
                    throw e;
                }
            }
        }
        super.onMeasure(i, i2);
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.SnsTextView", th, "", new Object[0]);
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.SnsTextView", th, "", new Object[0]);
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
