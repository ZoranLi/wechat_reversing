package com.tencent.mm.plugin.setting.ui.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

class NetStatUnit extends View {
    protected static int max;
    private int piF;
    private int piG;

    public NetStatUnit(Context context) {
        this(context, null);
    }

    public NetStatUnit(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetStatUnit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void cQ(int i, int i2) {
        this.piF = i;
        this.piG = i2;
        if (i > 94371840) {
            this.piF = 94371840;
        }
        if (i2 > 94371840) {
            this.piG = 94371840;
        }
        if (i <= i2) {
            i = i2;
        }
        int i3 = ((i / 1572864) + 1) * 1572864;
        if (94371840 <= i3) {
            i3 = 94371840;
        }
        if (3145728 >= i3) {
            i3 = 3145728;
        }
        if (i3 > max) {
            max = i3;
        }
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Rect rect = new Rect();
        getDrawingRect(rect);
        Rect rect2 = new Rect(rect.left, (int) (((float) rect.bottom) - ((((float) rect.height()) * ((float) this.piG)) / ((float) max))), (int) ((((float) rect.width()) * 0.6f) + ((float) rect.left)), rect.bottom);
        paint.setColor(-7829368);
        canvas.drawRect(rect2, paint);
        rect2 = new Rect(rect.left, (int) (((float) rect.bottom) - ((((float) rect.height()) * ((float) this.piF)) / ((float) max))), (int) ((((float) rect.width()) * 0.6f) + ((float) rect.left)), rect.bottom);
        paint.setColor(-16711936);
        canvas.drawRect(rect2, paint);
    }
}
