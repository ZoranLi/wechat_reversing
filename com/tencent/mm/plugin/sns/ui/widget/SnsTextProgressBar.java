package com.tencent.mm.plugin.sns.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.l;

public class SnsTextProgressBar extends ProgressBar {
    private Paint fu;
    private int iXL;
    private String jqT;
    private Context mContext;
    private int sd;

    public SnsTextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, l.pNv, 0, 0);
        try {
            this.iXL = a.fromDPToPix(this.mContext, obtainStyledAttributes.getInteger(l.pNw, 18));
        } finally {
            obtainStyledAttributes.recycle();
        }
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
        this.fu.setColor(this.mContext.getResources().getColor(c.pzj));
        this.fu.setTextSize((float) this.iXL);
        Rect rect = new Rect();
        this.fu.getTextBounds(this.jqT, 0, this.jqT.length(), rect);
        canvas.drawText(this.jqT, (float) ((getWidth() / 2) - rect.centerX()), (float) ((getHeight() / 2) - rect.centerY()), this.fu);
    }
}
