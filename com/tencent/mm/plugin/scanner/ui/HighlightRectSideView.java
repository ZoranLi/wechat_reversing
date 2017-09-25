package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;

public class HighlightRectSideView extends View {
    private aj irQ = new aj(new a(this) {
        final /* synthetic */ HighlightRectSideView oYQ;

        {
            this.oYQ = r1;
        }

        public final boolean oQ() {
            this.oYQ.oYP = this.oYQ.oYP + 1;
            this.oYQ.invalidate();
            return true;
        }
    }, true);
    private Paint mZ;
    private boolean[] oYK;
    private Rect oYL;
    private int oYM;
    private int oYN;
    private int oYO;
    private int oYP = 0;

    public HighlightRectSideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Bitmap decodeResource = com.tencent.mm.compatible.f.a.decodeResource(getResources(), R.g.bjn);
        this.oYM = decodeResource.getWidth();
        this.oYN = decodeResource.getHeight();
        if (this.oYN != this.oYM) {
            w.e("MicroMsg.HighlightRectSideView", "width is not same as height");
        }
        this.oYO = (this.oYM * 6) / 24;
        this.oYK = new boolean[4];
        this.mZ = new Paint();
        this.mZ.setColor(6676738);
        this.mZ.setAlpha(255);
        this.mZ.setStrokeWidth((float) this.oYO);
        this.mZ.setStyle(Style.STROKE);
        this.irQ.v(300, 300);
    }

    public final void j(Rect rect) {
        this.oYL = rect;
        w.d("MicroMsg.HighlightRectSideView", "rect:%s", new Object[]{rect});
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.irQ != null) {
            this.irQ.KH();
            this.irQ = null;
        }
    }

    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        for (int i2 = 0; i2 < 4; i2++) {
            if (!this.oYK[i2]) {
                i = 0;
                break;
            }
        }
        i = 1;
        int i3 = this.oYO / 2;
        if (this.oYK[0] && (1 == i || this.oYP % 2 == 0)) {
            canvas.drawLine((float) (this.oYL.left + i3), (float) (this.oYL.top + this.oYN), (float) (this.oYL.left + i3), (float) (this.oYL.bottom - this.oYN), this.mZ);
        }
        if (this.oYK[1] && (1 == i || this.oYP % 2 == 0)) {
            canvas.drawLine((float) (this.oYL.right - i3), (float) (this.oYL.top + this.oYN), (float) (this.oYL.right - i3), (float) (this.oYL.bottom - this.oYN), this.mZ);
        }
        if (this.oYK[2] && (1 == i || this.oYP % 3 == 0)) {
            canvas.drawLine((float) (this.oYL.left + this.oYM), (float) (this.oYL.top + i3), (float) (this.oYL.right - this.oYM), (float) (this.oYL.top + i3), this.mZ);
        }
        if (!this.oYK[3]) {
            return;
        }
        if (1 == i || this.oYP % 3 == 0) {
            canvas.drawLine((float) (this.oYL.left + this.oYM), (float) (this.oYL.bottom - i3), (float) (this.oYL.right - this.oYM), (float) (this.oYL.bottom - i3), this.mZ);
        }
    }

    public final void a(boolean[] zArr) {
        int i = 0;
        if (zArr != null && 4 == zArr.length) {
            w.d("MicroMsg.HighlightRectSideView", "%s, %s, %s, %s", new Object[]{Boolean.valueOf(zArr[0]), Boolean.valueOf(zArr[1]), Boolean.valueOf(zArr[2]), Boolean.valueOf(zArr[3])});
            while (i < 4) {
                this.oYK[i] = zArr[i];
                i++;
            }
            invalidate();
        }
    }
}
