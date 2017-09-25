package com.tencent.mm.plugin.game.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.appbrand.jsapi.bg;

public class TextProgressBar extends ProgressBar {
    private Paint fu;
    private int iXL;
    private String jqT;
    private Context mContext;
    private int sd;

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public void setProgress(int i) {
        this.sd = i;
        this.jqT = String.valueOf(i) + "%";
        super.setProgress(i);
    }

    @SuppressLint({"DrawAllocation"})
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.fu = new Paint();
        this.fu.setAntiAlias(true);
        this.fu.setColor(Color.rgb(69, bg.CTRL_INDEX, 26));
        this.fu.setTextSize((float) this.iXL);
        Rect rect = new Rect();
        this.fu.getTextBounds(this.jqT, 0, this.jqT.length(), rect);
        float width = (float) ((getWidth() / 2) - rect.centerX());
        float height = (float) ((getHeight() / 2) - rect.centerY());
        canvas.drawText(this.jqT, width, height, this.fu);
        float width2 = (((float) this.sd) / 100.0f) * ((float) getWidth());
        if (width2 > width) {
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setAntiAlias(true);
            paint.setTextSize((float) this.iXL);
            RectF rectF = new RectF(0.0f, 0.0f, width2, (float) getHeight());
            canvas.save();
            canvas.clipRect(rectF);
            canvas.drawText(this.jqT, width, height, paint);
            canvas.restore();
        }
    }

    public final void nQ(int i) {
        this.iXL = a.fromDPToPix(this.mContext, i);
    }
}
