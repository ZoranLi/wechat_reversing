package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.s.a.m;
import com.tencent.smtt.sdk.WebView;

public class MMVerticalTextView extends View {
    private int direction;
    private TextPaint gm = new TextPaint();
    private String jqT;
    Rect vnl = new Rect();

    public MMVerticalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gm.setAntiAlias(true);
        this.gm.setTextSize(15.0f);
        this.gm.setColor(WebView.NIGHT_MODE_COLOR);
        this.gm.setTextAlign(Align.CENTER);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fta);
        int resourceId = obtainStyledAttributes.getResourceId(m.hgl, 0);
        if (resourceId != 0) {
            this.jqT = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getDimensionPixelOffset(m.hgo, 15);
        if (resourceId > 0) {
            this.gm.setTextSize((float) resourceId);
        }
        this.gm.setColor(obtainStyledAttributes.getColor(m.hgn, WebView.NIGHT_MODE_COLOR));
        this.direction = obtainStyledAttributes.getInt(m.hgk, 0);
        this.gm.setFakeBoldText(obtainStyledAttributes.getBoolean(m.hgm, false));
        obtainStyledAttributes.recycle();
        requestLayout();
        invalidate();
    }

    public final void setText(String str) {
        this.jqT = str;
        requestLayout();
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        int height;
        this.gm.getTextBounds(this.jqT, 0, this.jqT.length(), this.vnl);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            height = this.vnl.height();
            size = mode == Integer.MIN_VALUE ? Math.min(height, size) : height;
        }
        int mode2 = MeasureSpec.getMode(i2);
        height = MeasureSpec.getSize(i2);
        if (mode2 != 1073741824) {
            mode = this.vnl.width();
            height = mode2 == Integer.MIN_VALUE ? Math.min(mode, height) : mode;
        }
        setMeasuredDimension(size, height);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        Path path = new Path();
        int width;
        if (this.direction == 0) {
            width = (getWidth() >> 1) - (this.vnl.height() >> 1);
            path.moveTo((float) width, 0.0f);
            path.lineTo((float) width, (float) height);
        } else {
            width = (getWidth() >> 1) + (this.vnl.height() >> 1);
            path.moveTo((float) width, (float) height);
            path.lineTo((float) width, 0.0f);
        }
        canvas.drawTextOnPath(this.jqT, path, 0.0f, 0.0f, this.gm);
    }
}
