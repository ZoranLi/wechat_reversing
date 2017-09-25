package com.tencent.mm.svg.a;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Gravity;
import android.view.View;
import com.tencent.mm.svg.b.c;

public abstract class b extends Drawable {
    protected View lCU;
    public long mDuration = 0;
    protected final Rect tZ = new Rect();
    protected int uNa = 0;
    protected boolean uNb = false;
    protected Paint uNc = new Paint();
    protected int uNd = 0;
    protected int uNe = 0;
    protected int uNf = 0;
    protected int uNg = 0;
    protected float uNh;

    public b(int i, int i2, int i3) {
        this.uNf = i;
        this.uNg = i2;
        this.uNh = 1.0f;
        this.uNd = this.uNf;
        this.uNe = this.uNg;
        setLevel(10000);
        this.uNa = i3;
    }

    protected final void bNU() {
        this.tZ.set(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
    }

    protected void onBoundsChange(Rect rect) {
        this.uNb = true;
    }

    protected boolean onLevelChange(int i) {
        bNW();
        return super.onLevelChange(i);
    }

    protected final void bNV() {
        if (this.uNb) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.tZ);
        }
        this.uNb = false;
    }

    private void bNW() {
        this.lCU = a.u(this);
        if (this.lCU != null) {
            a.b(this.lCU, this.uNc);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        bNW();
        return super.setVisible(z, z2);
    }

    @TargetApi(17)
    public void setAlpha(int i) {
        this.uNc.setAlpha(i);
        if (this.lCU != null && VERSION.SDK_INT >= 17) {
            try {
                this.lCU.setLayerPaint(this.uNc);
            } catch (Throwable e) {
                c.printErrStackTrace("MicroMsg.SVGDrawable", e, "fucking samsung", new Object[0]);
            }
        }
    }

    @TargetApi(17)
    public void setColorFilter(ColorFilter colorFilter) {
        this.uNc.setColorFilter(colorFilter);
        if (this.lCU != null && VERSION.SDK_INT >= 17) {
            try {
                this.lCU.setLayerPaint(this.uNc);
            } catch (Throwable e) {
                c.printErrStackTrace("MicroMsg.SVGDrawable", e, "fucking samsung", new Object[0]);
            }
        }
    }

    public int getOpacity() {
        if (this.lCU != null && this.lCU.getAlpha() < 1.0f) {
            return -3;
        }
        if (this.uNc == null || this.uNc.getAlpha() >= 255) {
            return 0;
        }
        return -3;
    }

    protected final void n(Canvas canvas) {
        if (com.tencent.mm.svg.b.b.bNZ()) {
            int height = this.tZ.height() / 3;
            canvas.save();
            Paint paint = new Paint();
            paint.setStyle(Style.FILL);
            paint.setColor(-12303292);
            paint.setAlpha(127);
            paint.setTextSize((float) height);
            paint.setStrokeWidth(1.0f);
            canvas.translate(((float) this.tZ.width()) - paint.measureText("SVG"), (float) ((this.tZ.height() * 2) / 3));
            canvas.drawText("SVG", 0.0f, (float) height, paint);
            canvas.restore();
        }
    }

    public int getIntrinsicWidth() {
        return this.uNd;
    }

    public int getIntrinsicHeight() {
        return this.uNe;
    }
}
