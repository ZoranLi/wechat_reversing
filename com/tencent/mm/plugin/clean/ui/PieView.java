package com.tencent.mm.plugin.clean.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class PieView extends View {
    int ivi = 0;
    private int kAa;
    private int kAb;
    int kAc;
    int kAd;
    private int kAe = -90;
    private Paint kzS;
    private Paint kzT;
    private Paint kzU;
    private Paint kzV;
    private Paint kzW;
    private Paint kzX;
    private int kzY = 6;
    private int kzZ;

    public PieView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        KC();
    }

    public PieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        KC();
    }

    private void KC() {
        this.kzS = kU(-1);
        this.kzT = kU(-657931);
        this.kzU = kU(-2565928);
        this.kzV = kU(-15223279);
        this.kzW = kU(-7876878);
        this.kzX = kU(-1447447);
    }

    private static Paint kU(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Style.FILL);
        paint.setColor(i);
        return paint;
    }

    public void draw(Canvas canvas) {
        float measuredWidth = (float) (getMeasuredWidth() / 2);
        float measuredHeight = (float) ((getMeasuredHeight() / 2) + getTop());
        float measuredHeight2 = (float) ((getMeasuredHeight() / 3) + 15);
        float f = measuredHeight2 - 15.0f;
        RectF rectF = new RectF(measuredWidth - measuredHeight2, measuredHeight - measuredHeight2, measuredWidth + measuredHeight2, measuredHeight + measuredHeight2);
        if (this.ivi == 0) {
            canvas.drawCircle(measuredWidth, measuredHeight, measuredHeight2, this.kzT);
            canvas.drawArc(rectF, (float) this.kAe, 45.0f, true, this.kzU);
            canvas.drawCircle(measuredWidth, measuredHeight, f, this.kzS);
            this.kAe += 4;
            this.kAe %= 360;
        }
        if (this.ivi == 1) {
            float f2 = 10.0f + measuredHeight2;
            RectF rectF2 = new RectF(measuredWidth - f2, measuredHeight - f2, measuredWidth + f2, f2 + measuredHeight);
            this.kzZ = y(this.kzZ, this.kAc, this.kzY);
            canvas.drawArc(rectF2, -90.0f, (float) this.kzZ, true, this.kzV);
            if (this.kzZ == this.kAc) {
                this.kAb = y(this.kAb, this.kAd, this.kzY);
                canvas.drawArc(rectF, (float) (this.kAc - 90), (float) this.kAb, true, this.kzW);
            }
            if (this.kAb == this.kAd) {
                this.kAa = y(this.kAa, (360 - this.kAc) - this.kAd, this.kzY);
                canvas.drawArc(rectF, (float) ((this.kAc - 90) + this.kAd), (float) this.kAa, true, this.kzX);
            }
        }
        invalidate();
    }

    private static int y(int i, int i2, int i3) {
        if (i2 - i >= i3) {
            return i + i3;
        }
        if (i - i2 > i3) {
            return i - i3;
        }
        return i2;
    }
}
