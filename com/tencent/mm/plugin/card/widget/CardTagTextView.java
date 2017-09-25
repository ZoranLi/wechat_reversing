package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.bg.a;

public class CardTagTextView extends TextView {
    public int fillColor = 0;
    private int kjk = 3;
    private RectF kro = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    private Paint krp = new Paint();
    private int krq = 9;
    private int krr = 0;

    public CardTagTextView(Context context) {
        super(context);
        init();
    }

    public CardTagTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CardTagTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.kjk = Math.round(a.getDensity(getContext()) * 0.5f);
        this.krq = a.fromDPToPix(getContext(), 3);
        this.krr = getCurrentTextColor();
    }

    public void setTextColor(int i) {
        this.krr = i;
        super.setTextColor(i);
    }

    protected void onDraw(Canvas canvas) {
        this.kro.left = (float) this.krq;
        this.kro.top = (float) this.kjk;
        this.kro.right = (float) (getWidth() - this.krq);
        this.kro.bottom = (float) (getHeight() - this.kjk);
        if (this.fillColor != 0) {
            this.krp.setColor(this.fillColor);
            this.krp.setStyle(Style.FILL);
            canvas.drawRoundRect(this.kro, (float) ((getHeight() / 2) - this.kjk), (float) ((getHeight() / 2) - this.kjk), this.krp);
        }
        this.krp.setColor(this.krr);
        this.krp.setStrokeWidth((float) this.kjk);
        this.krp.setStyle(Style.STROKE);
        canvas.drawRoundRect(this.kro, (float) ((getHeight() / 2) - this.kjk), (float) ((getHeight() / 2) - this.kjk), this.krp);
        super.onDraw(canvas);
    }
}
