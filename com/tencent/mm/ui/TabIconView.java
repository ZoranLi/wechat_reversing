package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.wcdb.FileUtils;

public class TabIconView extends ImageView {
    private Paint jXK;
    private Bitmap uWH;
    private Bitmap uWI;
    private Bitmap uWJ;
    private Rect uWK;
    private Rect uWL;
    private Rect uWM;
    private int uWN = 0;

    public TabIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TabIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void g(int i, int i2, int i3, boolean z) {
        if (z) {
            this.uWH = d.yq(i);
            this.uWI = d.yq(i3);
            this.uWJ = d.yq(i2);
        } else {
            this.uWH = d.yp(i);
            this.uWI = d.yp(i3);
            this.uWJ = d.yp(i2);
        }
        this.uWK = new Rect(0, 0, this.uWH.getWidth(), this.uWH.getHeight());
        this.uWL = new Rect(0, 0, this.uWI.getWidth(), this.uWI.getHeight());
        this.uWM = new Rect(0, 0, this.uWJ.getWidth(), this.uWJ.getHeight());
        this.jXK = new Paint(1);
    }

    public final void zy(int i) {
        this.uWN = i;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.jXK != null) {
            if (this.uWN < FileUtils.S_IWUSR) {
                this.jXK.setAlpha(255 - (this.uWN * 2));
                canvas.drawBitmap(this.uWI, null, this.uWL, this.jXK);
                this.jXK.setAlpha(this.uWN * 2);
                canvas.drawBitmap(this.uWJ, null, this.uWM, this.jXK);
                return;
            }
            this.jXK.setAlpha(255 - (this.uWN * 2));
            canvas.drawBitmap(this.uWJ, null, this.uWM, this.jXK);
            this.jXK.setAlpha(this.uWN * 2);
            canvas.drawBitmap(this.uWH, null, this.uWK, this.jXK);
        }
    }
}
