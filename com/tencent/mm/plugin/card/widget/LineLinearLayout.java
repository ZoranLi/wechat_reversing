package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.bg.a;

public class LineLinearLayout extends LinearLayout {
    private Paint fu;
    private Rect fv;
    private int ksi;

    public LineLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LineLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        this.fv = new Rect();
        this.fu = new Paint();
        this.fu.setStyle(Style.STROKE);
        this.fu.setColor(-571543826);
        this.fu.setStrokeWidth((float) Math.round(a.getDensity(getContext()) * 0.5f));
        this.ksi = a.fromDPToPix(context, 44);
    }

    protected void onDraw(Canvas canvas) {
        int measuredHeight = getMeasuredHeight();
        Paint paint = this.fu;
        for (int i = 1; this.ksi * i < measuredHeight; i++) {
            canvas.drawLine(0.0f, (float) (this.ksi * i), (float) getMeasuredWidth(), (float) (this.ksi * i), paint);
        }
        super.onDraw(canvas);
    }
}
