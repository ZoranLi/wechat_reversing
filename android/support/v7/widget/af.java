package android.support.v7.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
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
import android.support.v7.b.a.b;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

final class af extends Drawable {
    static a abD;
    static final double iS = Math.cos(Math.toRadians(45.0d));
    final int abC;
    final RectF abE;
    Paint fu;
    Paint iT;
    Paint iU;
    float iW;
    Path iX;
    float iY;
    float iZ;
    float ja;
    float jb;
    private boolean jc = true;
    private final int jd;
    private final int jf;
    boolean jg = true;
    private boolean jh = false;

    interface a {
        void a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    af(Resources resources, int i, float f, float f2, float f3) {
        this.jd = resources.getColor(android.support.v7.b.a.a.Oe);
        this.jf = resources.getColor(android.support.v7.b.a.a.Od);
        this.abC = resources.getDimensionPixelSize(b.Of);
        this.fu = new Paint(5);
        this.fu.setColor(i);
        this.iT = new Paint(5);
        this.iT.setStyle(Style.FILL);
        this.iW = (float) ((int) (f + 0.5f));
        this.abE = new RectF();
        this.iU = new Paint(this.iT);
        this.iU.setAntiAlias(false);
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        } else if (f3 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
        } else {
            float k = (float) k(f2);
            float k2 = (float) k(f3);
            if (k > k2) {
                if (!this.jh) {
                    this.jh = true;
                }
                k = k2;
            }
            if (this.jb != k || this.iZ != k2) {
                this.jb = k;
                this.iZ = k2;
                this.ja = (float) ((int) (((k * DownloadHelper.SAVE_FATOR) + ((float) this.abC)) + 0.5f));
                this.iY = ((float) this.abC) + k2;
                this.jc = true;
                invalidateSelf();
            }
        }
    }

    private static int k(float f) {
        int i = (int) (0.5f + f);
        if (i % 2 == 1) {
            return i - 1;
        }
        return i;
    }

    public final void setAlpha(int i) {
        this.fu.setAlpha(i);
        this.iT.setAlpha(i);
        this.iU.setAlpha(i);
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.jc = true;
    }

    public final boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) a(this.iZ, this.iW, this.jg));
        int ceil2 = (int) Math.ceil((double) b(this.iZ, this.iW, this.jg));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    static float a(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (DownloadHelper.SAVE_FATOR * f)) + ((1.0d - iS) * ((double) f2)));
        }
        return DownloadHelper.SAVE_FATOR * f;
    }

    static float b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - iS) * ((double) f2)));
        }
        return f;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.fu.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void draw(Canvas canvas) {
        float f;
        int i;
        int i2 = 1;
        if (this.jc) {
            Rect bounds = getBounds();
            f = this.iZ * DownloadHelper.SAVE_FATOR;
            this.abE.set(((float) bounds.left) + this.iZ, ((float) bounds.top) + f, ((float) bounds.right) - this.iZ, ((float) bounds.bottom) - f);
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
            f = this.iW / (this.iW + this.ja);
            float[] fArr = new float[]{0.0f, f, 1.0f};
            f = 0.0f;
            this.iT.setShader(new RadialGradient(0.0f, f, this.iW + this.ja, new int[]{this.jd, this.jd, this.jf}, fArr, TileMode.CLAMP));
            float f2 = 0.0f;
            this.iU.setShader(new LinearGradient(0.0f, (-this.iW) + this.ja, f2, (-this.iW) - this.ja, new int[]{this.jd, this.jd, this.jf}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
            this.iU.setAntiAlias(false);
            this.jc = false;
        }
        canvas.translate(0.0f, this.jb / 2.0f);
        f = (-this.iW) - this.ja;
        float f3 = (this.iW + ((float) this.abC)) + (this.jb / 2.0f);
        if (this.abE.width() - (2.0f * f3) > 0.0f) {
            i = 1;
        } else {
            boolean z = false;
        }
        if (this.abE.height() - (2.0f * f3) <= 0.0f) {
            i2 = 0;
        }
        int save = canvas.save();
        canvas.translate(this.abE.left + f3, this.abE.top + f3);
        canvas.drawPath(this.iX, this.iT);
        if (i != 0) {
            canvas.drawRect(0.0f, f, this.abE.width() - (2.0f * f3), -this.iW, this.iU);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        canvas.translate(this.abE.right - f3, this.abE.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.iX, this.iT);
        if (i != 0) {
            Canvas canvas2 = canvas;
            canvas2.drawRect(0.0f, f, this.abE.width() - (2.0f * f3), this.ja + (-this.iW), this.iU);
        }
        canvas.restoreToCount(save);
        i = canvas.save();
        canvas.translate(this.abE.left + f3, this.abE.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.iX, this.iT);
        if (i2 != 0) {
            canvas.drawRect(0.0f, f, this.abE.height() - (2.0f * f3), -this.iW, this.iU);
        }
        canvas.restoreToCount(i);
        i = canvas.save();
        canvas.translate(this.abE.right - f3, this.abE.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.iX, this.iT);
        if (i2 != 0) {
            canvas.drawRect(0.0f, f, this.abE.height() - (2.0f * f3), -this.iW, this.iU);
        }
        canvas.restoreToCount(i);
        canvas.translate(0.0f, (-this.jb) / 2.0f);
        abD.a(canvas, this.abE, this.iW, this.fu);
    }
}
