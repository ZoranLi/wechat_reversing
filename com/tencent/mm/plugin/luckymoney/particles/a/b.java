package com.tencent.mm.plugin.luckymoney.particles.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;

public abstract class b {
    public int alpha;
    public float noD;
    public float noF;
    public Float noH;
    public Float noJ;
    public float noP;
    public Float noR;
    public long noT;
    public Interpolator nox;
    public Rect noy;
    public boolean npA;
    public VelocityTracker npB;
    public float npC;
    public float npD;
    public float npE;
    public float npF;
    public boolean npb;
    private final Matrix npi = new Matrix();
    private final Paint npj = new Paint(1);
    public long npk;
    public float npl;
    public float npm;
    public float npn;
    public float npo;
    public Long npp;
    public Long npq;
    public float npr;
    public float nps;
    public Long npt;
    public float npu;
    public float npv;
    public float npw;
    public float npx;
    public float npy;
    public boolean npz;

    protected abstract void a(Canvas canvas, Matrix matrix, Paint paint, float f, float f2, float f3);

    public abstract int getHeight();

    public abstract int getWidth();

    public final void g(Rect rect) {
        this.noy = rect;
        this.npp = a(this.noH, this.npn, this.noD);
        this.npq = a(this.noJ, this.npo, this.noF);
        this.npt = a(this.noR, this.nps, this.noP);
        if (this.npu == 0.0f) {
            this.npu = this.noT >= 0 ? (float) this.noT : 9.223372E18f;
            this.npu = Math.min((float) a(this.npl, this.npn, this.noD, this.npp, this.noH, rect.left - getWidth(), rect.right), this.npu);
            this.npu = Math.min((float) a(this.npm, this.npo, this.noF, this.npq, this.noJ, rect.top - getHeight(), rect.bottom), this.npu);
        }
        this.npj.setAlpha(this.alpha);
    }

    private static Long a(Float f, float f2, float f3) {
        if (f == null) {
            return null;
        }
        if (f3 != 0.0f) {
            long floatValue = (long) ((f.floatValue() - f2) / f3);
            if (floatValue <= 0) {
                floatValue = 0;
            }
            return Long.valueOf(floatValue);
        } else if (f.floatValue() < f2) {
            return Long.valueOf(0);
        } else {
            return null;
        }
    }

    private static long a(float f, float f2, float f3, Long l, Float f4, int i, int i2) {
        double sqrt;
        if (f3 != 0.0f) {
            if (f3 <= 0.0f) {
                i2 = i;
            }
            if (l == null || l.longValue() < 0) {
                sqrt = Math.sqrt((double) ((((2.0f * f3) * ((float) i2)) - ((2.0f * f3) * f)) + (f2 * f2)));
                double d = ((-sqrt) - ((double) f2)) / ((double) f3);
                if (d > 0.0d) {
                    return (long) d;
                }
                sqrt = (sqrt - ((double) f2)) / ((double) f3);
                if (sqrt > 0.0d) {
                    return (long) sqrt;
                }
                return Long.MAX_VALUE;
            }
            sqrt = ((((double) ((((float) i2) - f) - (((float) l.longValue()) * f2))) - (((0.5d * ((double) f3)) * ((double) l.longValue())) * ((double) l.longValue()))) + ((double) (f4.floatValue() * ((float) l.longValue())))) / ((double) f4.floatValue());
            return sqrt > 0.0d ? (long) sqrt : Long.MAX_VALUE;
        } else {
            if (l != null) {
                f2 = f4.floatValue();
            }
            if (f2 <= 0.0f) {
                i2 = i;
            }
            if (f2 == 0.0f) {
                return Long.MAX_VALUE;
            }
            sqrt = (double) ((((float) i2) - f) / f2);
            return sqrt > 0.0d ? (long) sqrt : Long.MAX_VALUE;
        }
    }

    public static float a(long j, float f, float f2, float f3, Long l, Float f4) {
        if (l == null || j < l.longValue()) {
            return ((((float) j) * f2) + f) + (((0.5f * f3) * ((float) j)) * ((float) j));
        }
        return (((((float) l.longValue()) * f2) + f) + (((0.5f * f3) * ((float) l.longValue())) * ((float) l.longValue()))) + (((float) (j - l.longValue())) * f4.floatValue());
    }

    public final void a(Canvas canvas, float f, float f2, float f3) {
        canvas.save();
        canvas.clipRect(this.noy);
        this.npi.reset();
        this.npj.setAlpha(this.alpha);
        a(canvas, this.npi, this.npj, f, f2, f3);
        canvas.restore();
    }
}
