package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.sdk.platformtools.w;

public class FaceDetectDecorView extends View {
    public boolean lBV;
    public boolean lBW;
    public boolean lBX;
    public RectF lBY;
    private Paint lBZ;

    public FaceDetectDecorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectDecorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lBV = false;
        this.lBW = false;
        this.lBX = false;
        this.lBY = null;
        this.lBZ = null;
        this.lBZ = new Paint();
        this.lBZ.setColor(getResources().getColor(b.black));
        this.lBZ.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        setLayerType(1, null);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        w.i("MicroMsg.FaceDetectDecorView", "mTargetCoverMode: %b, mIsInCoverMode: %b, %s", new Object[]{Boolean.valueOf(this.lBW), Boolean.valueOf(this.lBV), this.lBY});
        if (this.lBW != this.lBV || this.lBX) {
            if (this.lBW) {
                canvas.drawColor(getResources().getColor(b.lsk));
                canvas.drawRect(this.lBY, this.lBZ);
            } else {
                canvas.drawColor(getResources().getColor(b.transparent));
            }
        }
        this.lBV = this.lBW;
    }
}
