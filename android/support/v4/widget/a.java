package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class a implements OnTouchListener {
    private static final int AM = ViewConfiguration.getTapTimeout();
    private float[] AA = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int AB;
    private int AC;
    private float[] AD = new float[]{0.0f, 0.0f};
    private float[] AE = new float[]{0.0f, 0.0f};
    private float[] AF = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean AG;
    public boolean AH;
    public boolean AI;
    public boolean AJ;
    private boolean AK;
    private boolean AL;
    public final a Ax = new a();
    private final Interpolator Ay = new AccelerateInterpolator();
    private float[] Az = new float[]{0.0f, 0.0f};
    private Runnable lw;
    public final View nw;

    private static class a {
        int AN;
        int AO;
        float AP;
        float AQ;
        long AR = 0;
        int AS = 0;
        int AT = 0;
        long AU = -1;
        float AV;
        int AW;
        long mStartTime = Long.MIN_VALUE;

        final float e(long j) {
            if (j < this.mStartTime) {
                return 0.0f;
            }
            if (this.AU < 0 || j < this.AU) {
                return a.d(((float) (j - this.mStartTime)) / ((float) this.AN), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.AU;
            return (a.d(((float) j2) / ((float) this.AW), 0.0f, 1.0f) * this.AV) + (1.0f - this.AV);
        }
    }

    private class b implements Runnable {
        final /* synthetic */ a AX;

        public b(a aVar) {
            this.AX = aVar;
        }

        public final void run() {
            if (this.AX.AJ) {
                boolean z;
                if (this.AX.AH) {
                    this.AX.AH = false;
                    a aVar = this.AX.Ax;
                    aVar.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    aVar.AU = -1;
                    aVar.AR = aVar.mStartTime;
                    aVar.AV = 0.5f;
                    aVar.AS = 0;
                    aVar.AT = 0;
                }
                a aVar2 = this.AX.Ax;
                if (aVar2.AU <= 0 || AnimationUtils.currentAnimationTimeMillis() <= aVar2.AU + ((long) aVar2.AW)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z || !this.AX.aj()) {
                    this.AX.AJ = false;
                    return;
                }
                long uptimeMillis;
                if (this.AX.AI) {
                    this.AX.AI = false;
                    a aVar3 = this.AX;
                    uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    aVar3.nw.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (aVar2.AR == 0) {
                    throw new RuntimeException("Cannot compute scroll delta before calling start()");
                }
                uptimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float e = aVar2.e(uptimeMillis);
                e = (e * 4.0f) + ((-4.0f * e) * e);
                long j = uptimeMillis - aVar2.AR;
                aVar2.AR = uptimeMillis;
                aVar2.AS = (int) ((((float) j) * e) * aVar2.AP);
                aVar2.AT = (int) ((((float) j) * e) * aVar2.AQ);
                this.AX.ad(aVar2.AT);
                z.a(this.AX.nw, (Runnable) this);
            }
        }
    }

    public abstract void ad(int i);

    public abstract boolean ae(int i);

    public a(View view) {
        this.nw = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        float f = (float) i;
        this.AF[0] = f / 1000.0f;
        this.AF[1] = f / 1000.0f;
        float f2 = (float) i2;
        this.AE[0] = f2 / 1000.0f;
        this.AE[1] = f2 / 1000.0f;
        this.AB = 1;
        this.AA[0] = Float.MAX_VALUE;
        this.AA[1] = Float.MAX_VALUE;
        this.Az[0] = 0.2f;
        this.Az[1] = 0.2f;
        this.AD[0] = 0.001f;
        this.AD[1] = 0.001f;
        this.AC = AM;
        this.Ax.AN = 500;
        this.Ax.AO = 500;
    }

    public final a s(boolean z) {
        if (this.AK && !z) {
            cj();
        }
        this.AK = z;
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.AK) {
            return false;
        }
        switch (o.d(motionEvent)) {
            case 0:
                this.AI = true;
                this.AG = false;
                break;
            case 1:
            case 3:
                cj();
                break;
            case 2:
                break;
        }
        float a = a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.nw.getWidth());
        float a2 = a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.nw.getHeight());
        a aVar = this.Ax;
        aVar.AP = a;
        aVar.AQ = a2;
        if (!this.AJ && aj()) {
            if (this.lw == null) {
                this.lw = new b(this);
            }
            this.AJ = true;
            this.AH = true;
            if (this.AG || this.AC <= 0) {
                this.lw.run();
            } else {
                z.a(this.nw, this.lw, (long) this.AC);
            }
            this.AG = true;
        }
        if (this.AL && this.AJ) {
            return true;
        }
        return false;
    }

    public final boolean aj() {
        a aVar = this.Ax;
        int abs = (int) (aVar.AQ / Math.abs(aVar.AQ));
        int abs2 = (int) (aVar.AP / Math.abs(aVar.AP));
        if (abs != 0 && ae(abs)) {
            return true;
        }
        if (abs2 != 0) {
        }
        return false;
    }

    private void cj() {
        if (this.AH) {
            this.AJ = false;
            return;
        }
        a aVar = this.Ax;
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i = (int) (currentAnimationTimeMillis - aVar.mStartTime);
        int i2 = aVar.AO;
        if (i <= i2) {
            i2 = i < 0 ? 0 : i;
        }
        aVar.AW = i2;
        aVar.AV = aVar.e(currentAnimationTimeMillis);
        aVar.AU = currentAnimationTimeMillis;
    }

    private float a(int i, float f, float f2, float f3) {
        float f4;
        float f5;
        float f6;
        float d = d(this.Az[i] * f2, 0.0f, this.AA[i]);
        d = g(f2 - f, d) - g(f, d);
        if (d < 0.0f) {
            d = -this.Ay.getInterpolation(-d);
        } else if (d > 0.0f) {
            d = this.Ay.getInterpolation(d);
        } else {
            d = 0.0f;
            if (d == 0.0f) {
                return 0.0f;
            }
            f4 = this.AD[i];
            f5 = this.AE[i];
            f6 = this.AF[i];
            f4 *= f3;
            if (d <= 0.0f) {
                return d(d * f4, f5, f6);
            }
            return -d((-d) * f4, f5, f6);
        }
        d = d(d, -1.0f, 1.0f);
        if (d == 0.0f) {
            return 0.0f;
        }
        f4 = this.AD[i];
        f5 = this.AE[i];
        f6 = this.AF[i];
        f4 *= f3;
        if (d <= 0.0f) {
            return -d((-d) * f4, f5, f6);
        }
        return d(d * f4, f5, f6);
    }

    private float g(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.AB) {
            case 0:
            case 1:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.AJ && this.AB == 1) {
                    return 1.0f;
                }
                return 0.0f;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    public static float d(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }
}
