package android.support.design.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.design.a.c;
import android.support.v7.c.a.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

final class o extends a {
    static final double iS = Math.cos(Math.toRadians(45.0d));
    float fF;
    final Paint iT;
    final Paint iU;
    final RectF iV;
    float iW;
    Path iX;
    float iY;
    float iZ;
    float ja;
    float jb;
    private boolean jc = true;
    private final int jd;
    private final int je;
    private final int jf;
    boolean jg = true;
    private boolean jh = false;

    public o(Resources resources, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.jd = resources.getColor(c.aa);
        this.je = resources.getColor(c.Z);
        this.jf = resources.getColor(c.Y);
        this.iT = new Paint(5);
        this.iT.setStyle(Style.FILL);
        this.iW = (float) Math.round(f);
        this.iV = new RectF();
        this.iU = new Paint(this.iT);
        this.iU.setAntiAlias(false);
        d(f2, f3);
    }

    private static int k(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public final void setAlpha(int i) {
        super.setAlpha(i);
        this.iT.setAlpha(i);
        this.iU.setAlpha(i);
    }

    protected final void onBoundsChange(Rect rect) {
        this.jc = true;
    }

    final void d(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float k = (float) k(f);
        float k2 = (float) k(f2);
        if (k > k2) {
            if (!this.jh) {
                this.jh = true;
            }
            k = k2;
        }
        if (this.jb != k || this.iZ != k2) {
            this.jb = k;
            this.iZ = k2;
            this.ja = (float) Math.round(k * DownloadHelper.SAVE_FATOR);
            this.iY = k2;
            this.jc = true;
            invalidateSelf();
        }
    }

    public final boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) a(this.iZ, this.iW, this.jg));
        int ceil2 = (int) Math.ceil((double) b(this.iZ, this.iW, this.jg));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public static float a(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (DownloadHelper.SAVE_FATOR * f)) + ((1.0d - iS) * ((double) f2)));
        }
        return DownloadHelper.SAVE_FATOR * f;
    }

    public static float b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - iS) * ((double) f2)));
        }
        return f;
    }

    public final int getOpacity() {
        return -3;
    }

    public final void draw(Canvas canvas) {
        float f;
        if (this.jc) {
            Rect bounds = getBounds();
            float f2 = this.iZ * DownloadHelper.SAVE_FATOR;
            this.iV.set(((float) bounds.left) + this.iZ, ((float) bounds.top) + f2, ((float) bounds.right) - this.iZ, ((float) bounds.bottom) - f2);
            this.mDrawable.setBounds((int) this.iV.left, (int) this.iV.top, (int) this.iV.right, (int) this.iV.bottom);
            RectF rectF = new RectF(-this.iW, -this.iW, this.iW, this.iW);
            RectF rectF2 = new RectF(rectF);
            rectF2.inset(-this.ja, -this.ja);
            if (this.iX == null) {
                this.iX = new Path();
            } else {
                this.iX.reset();
            }
            this.iX.setFillType(FillType.EVEN_ODD);
            this.iX.moveTo(-this.iW, 0.0f);
            this.iX.rLineTo(-this.ja, 0.0f);
            this.iX.arcTo(rectF2, 180.0f, 90.0f, false);
            this.iX.arcTo(rectF, 270.0f, -90.0f, false);
            this.iX.close();
            float f3 = -rectF2.top;
            if (f3 > 0.0f) {
                float f4 = this.iW / f3;
                f = f4 + ((1.0f - f4) / 2.0f);
                this.iT.setShader(new RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.jd, this.je, this.jf}, new float[]{0.0f, f4, f, 1.0f}, TileMode.CLAMP));
            }
            this.iU.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.jd, this.je, this.jf}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
            this.iU.setAntiAlias(false);
            this.jc = false;
        }
        int save = canvas.save();
        canvas.rotate(this.fF, this.iV.centerX(), this.iV.centerY());
        float f5 = (-this.iW) - this.ja;
        f = this.iW;
        Object obj = this.iV.width() - (2.0f * f) > 0.0f ? 1 : null;
        Object obj2 = this.iV.height() - (2.0f * f) > 0.0f ? 1 : null;
        float f6 = f / ((this.jb - (this.jb * 0.5f)) + f);
        float f7 = f / ((this.jb - (this.jb * 0.25f)) + f);
        float f8 = f / (f + (this.jb - (this.jb * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.iV.left + f, this.iV.top + f);
        canvas.scale(f6, f7);
        canvas.drawPath(this.iX, this.iT);
        if (obj != null) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f5, this.iV.width() - (2.0f * f), -this.iW, this.iU);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.iV.right - f, this.iV.bottom - f);
        canvas.scale(f6, f8);
        canvas.rotate(180.0f);
        canvas.drawPath(this.iX, this.iT);
        if (obj != null) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f5, this.iV.width() - (2.0f * f), this.ja + (-this.iW), this.iU);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.iV.left + f, this.iV.bottom - f);
        canvas.scale(f6, f8);
        canvas.rotate(270.0f);
        canvas.drawPath(this.iX, this.iT);
        if (obj2 != null) {
            canvas.scale(1.0f / f8, 1.0f);
            canvas.drawRect(0.0f, f5, this.iV.height() - (2.0f * f), -this.iW, this.iU);
        }
        canvas.restoreToCount(save3);
        save3 = canvas.save();
        canvas.translate(this.iV.right - f, this.iV.top + f);
        canvas.scale(f6, f7);
        canvas.rotate(90.0f);
        canvas.drawPath(this.iX, this.iT);
        if (obj2 != null) {
            canvas.scale(1.0f / f7, 1.0f);
            canvas.drawRect(0.0f, f5, this.iV.height() - (2.0f * f), -this.iW, this.iU);
        }
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
        super.draw(canvas);
    }
}
