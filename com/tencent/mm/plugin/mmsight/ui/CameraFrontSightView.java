package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class CameraFrontSightView extends View {
    public int RQ;
    public int aar;
    Paint fu = new Paint();
    int jrn;
    boolean nJQ = false;
    boolean nJR = false;
    boolean nJS = false;
    boolean nJT = false;
    long nJU = 0;
    int nJV;
    int nJW;
    LayoutParams nJX;

    public CameraFrontSightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CameraFrontSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void draw(Canvas canvas) {
        canvas.translate((float) (this.nJV / 2), (float) (this.nJW / 2));
        long currentTimeMillis = System.currentTimeMillis() - this.nJU;
        if (currentTimeMillis > 200) {
            this.nJQ = false;
            this.nJR = true;
        }
        if (currentTimeMillis > 800) {
            this.nJR = false;
            this.nJS = true;
        }
        if (currentTimeMillis > 1100) {
            this.nJS = false;
            this.nJT = true;
        }
        if (currentTimeMillis > 1300) {
            this.nJT = false;
            setVisibility(8);
            return;
        }
        if (this.nJQ) {
            float f = (((float) (200 - currentTimeMillis)) / 200.0f) + 1.0f;
            canvas.scale(f, f, (float) (this.nJV / 2), (float) (this.nJW / 2));
            this.fu.setAlpha((int) ((2.0f - f) * 255.0f));
        } else {
            canvas.scale(1.0f, 1.0f);
        }
        if (this.nJR) {
            f = (((float) ((currentTimeMillis - 200) % 200)) / 200.0f) * 2.0f;
            this.fu.setAlpha((int) (((f > 1.0f ? f - 1.0f : 1.0f - f) * 128.0f) + 127.0f));
        } else {
            this.fu.setAlpha(255);
        }
        if (this.nJT) {
            this.fu.setAlpha((int) ((1.0f - (((float) (currentTimeMillis - 1100)) / 200.0f)) * 255.0f));
        }
        canvas.drawLine(0.0f, 0.0f, (float) this.nJV, 0.0f, this.fu);
        canvas.drawLine(0.0f, 0.0f, 0.0f, (float) this.nJW, this.fu);
        canvas.drawLine((float) this.nJV, 0.0f, (float) this.nJV, (float) this.nJW, this.fu);
        canvas.drawLine(0.0f, (float) this.nJW, (float) this.nJV, (float) this.nJW, this.fu);
        canvas.drawLine(0.0f, (float) (this.nJW / 2), (float) (this.nJV / 10), (float) (this.nJW / 2), this.fu);
        canvas.drawLine((float) this.nJV, (float) (this.nJW / 2), (float) ((this.nJV * 9) / 10), (float) (this.nJW / 2), this.fu);
        canvas.drawLine((float) (this.nJV / 2), 0.0f, (float) (this.nJV / 2), (float) (this.nJW / 10), this.fu);
        canvas.drawLine((float) (this.nJV / 2), (float) this.nJW, (float) (this.nJV / 2), (float) ((this.nJW * 9) / 10), this.fu);
        invalidate();
    }
}
