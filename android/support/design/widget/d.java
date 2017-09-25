package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.b.b;

class d extends Drawable {
    int fA;
    int fB;
    private ColorStateList fC;
    private int fD;
    boolean fE = true;
    float fF;
    final Paint fu = new Paint(1);
    final Rect fv = new Rect();
    final RectF fw = new RectF();
    float fx;
    int fy;
    int fz;

    public d() {
        this.fu.setStyle(Style.STROKE);
    }

    public void draw(Canvas canvas) {
        float height;
        if (this.fE) {
            Paint paint = this.fu;
            Rect rect = this.fv;
            copyBounds(rect);
            height = this.fx / ((float) rect.height());
            float f = 0.0f;
            paint.setShader(new LinearGradient(0.0f, (float) rect.top, f, (float) rect.bottom, new int[]{b.i(this.fy, this.fD), b.i(this.fz, this.fD), b.i(b.j(this.fz, 0), this.fD), b.i(b.j(this.fB, 0), this.fD), b.i(this.fB, this.fD), b.i(this.fA, this.fD)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP));
            this.fE = false;
        }
        height = this.fu.getStrokeWidth() / 2.0f;
        RectF rectF = this.fw;
        copyBounds(this.fv);
        rectF.set(this.fv);
        rectF.left += height;
        rectF.top += height;
        rectF.right -= height;
        rectF.bottom -= height;
        canvas.save();
        canvas.rotate(this.fF, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.fu);
        canvas.restore();
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.fx);
        rect.set(round, round, round, round);
        return true;
    }

    public void setAlpha(int i) {
        this.fu.setAlpha(i);
        invalidateSelf();
    }

    final void c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.fD = colorStateList.getColorForState(getState(), this.fD);
        }
        this.fC = colorStateList;
        this.fE = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.fu.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        return this.fx > 0.0f ? -3 : -2;
    }

    protected void onBoundsChange(Rect rect) {
        this.fE = true;
    }

    public boolean isStateful() {
        return (this.fC != null && this.fC.isStateful()) || super.isStateful();
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.fC != null) {
            int colorForState = this.fC.getColorForState(iArr, this.fD);
            if (colorForState != this.fD) {
                this.fE = true;
                this.fD = colorForState;
            }
        }
        if (this.fE) {
            invalidateSelf();
        }
        return this.fE;
    }
}
