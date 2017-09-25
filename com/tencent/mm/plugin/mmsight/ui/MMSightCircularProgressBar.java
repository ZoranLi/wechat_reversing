package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.u.a.b;

public class MMSightCircularProgressBar extends View {
    int duration = 0;
    boolean fOV = false;
    private Paint jXK;
    float nKc = 0.0f;
    int nKd = 0;
    int nKe = 0;
    private RectF nKf;
    a nKg;
    a nKh;
    private int nKi = Color.parseColor("#1AAD19");
    private float strokeWidth = 0.0f;
    private float zn = 0.0f;

    public interface a {
        void aLX();
    }

    public MMSightCircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMSightCircularProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        float dimensionPixelSize = (float) getResources().getDimensionPixelSize(b.nNC);
        this.strokeWidth = (float) getResources().getDimensionPixelSize(b.nNE);
        this.zn = this.strokeWidth / 2.0f;
        this.nKf = new RectF(this.zn, this.zn, dimensionPixelSize - this.zn, dimensionPixelSize - this.zn);
        this.jXK = new Paint();
        this.jXK.setStyle(Style.STROKE);
        this.jXK.setStrokeWidth(this.strokeWidth);
        this.jXK.setColor(this.nKi);
        this.jXK.setAlpha(153);
        this.jXK.setAntiAlias(true);
    }

    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.zn, this.zn);
        canvas.rotate(180.0f, this.nKf.right / 2.0f, this.nKf.bottom / 2.0f);
        canvas.drawArc(this.nKf, 90.0f, 360.0f * (this.nKc / ((float) this.nKe)), false, this.jXK);
        canvas.restore();
    }
}
