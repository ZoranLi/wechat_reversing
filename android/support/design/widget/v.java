package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;

final class v extends e {
    static final Handler ji = new Handler(Looper.getMainLooper());
    boolean lp;
    private final int[] lq = new int[2];
    private final float[] lr = new float[2];
    int ls = m.CTRL_INDEX;
    a lt;
    b lu;
    float lv;
    final Runnable lw = new Runnable(this) {
        final /* synthetic */ v lx;

        {
            this.lx = r1;
        }

        public final void run() {
            v vVar = this.lx;
            if (vVar.lp) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - vVar.mStartTime)) / ((float) vVar.ls);
                if (vVar.mInterpolator != null) {
                    uptimeMillis = vVar.mInterpolator.getInterpolation(uptimeMillis);
                }
                vVar.lv = uptimeMillis;
                if (vVar.lu != null) {
                    vVar.lu.au();
                }
                if (SystemClock.uptimeMillis() >= vVar.mStartTime + ((long) vVar.ls)) {
                    vVar.lp = false;
                    if (vVar.lt != null) {
                        vVar.lt.onAnimationEnd();
                    }
                }
            }
            if (vVar.lp) {
                v.ji.postDelayed(vVar.lw, 10);
            }
        }
    };
    Interpolator mInterpolator;
    long mStartTime;

    v() {
    }

    public final void start() {
        if (!this.lp) {
            if (this.mInterpolator == null) {
                this.mInterpolator = new AccelerateDecelerateInterpolator();
            }
            this.mStartTime = SystemClock.uptimeMillis();
            this.lp = true;
            ji.postDelayed(this.lw, 10);
        }
    }

    public final boolean isRunning() {
        return this.lp;
    }

    public final void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void a(a aVar) {
        this.lt = aVar;
    }

    public final void a(b bVar) {
        this.lu = bVar;
    }

    public final void e(int i, int i2) {
        this.lq[0] = i;
        this.lq[1] = i2;
    }

    public final int aw() {
        return a.a(this.lq[0], this.lq[1], this.lv);
    }

    public final void e(float f, float f2) {
        this.lr[0] = f;
        this.lr[1] = f2;
    }

    public final float ax() {
        return a.b(this.lr[0], this.lr[1], this.lv);
    }

    public final void setDuration(int i) {
        this.ls = i;
    }

    public final void cancel() {
        this.lp = false;
        ji.removeCallbacks(this.lw);
    }

    public final float getAnimatedFraction() {
        return this.lv;
    }

    public final long getDuration() {
        return (long) this.ls;
    }
}
