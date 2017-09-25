package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.Interpolator;

final class w extends e {
    final ValueAnimator ly = new ValueAnimator();

    w() {
    }

    public final void start() {
        this.ly.start();
    }

    public final boolean isRunning() {
        return this.ly.isRunning();
    }

    public final void setInterpolator(Interpolator interpolator) {
        this.ly.setInterpolator(interpolator);
    }

    public final void a(final b bVar) {
        this.ly.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ w lA;

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                bVar.au();
            }
        });
    }

    public final void a(final a aVar) {
        this.ly.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ w lA;

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                aVar.onAnimationEnd();
            }

            public final void onAnimationCancel(Animator animator) {
            }
        });
    }

    public final void e(int i, int i2) {
        this.ly.setIntValues(new int[]{i, i2});
    }

    public final int aw() {
        return ((Integer) this.ly.getAnimatedValue()).intValue();
    }

    public final void e(float f, float f2) {
        this.ly.setFloatValues(new float[]{f, f2});
    }

    public final float ax() {
        return ((Float) this.ly.getAnimatedValue()).floatValue();
    }

    public final void setDuration(int i) {
        this.ly.setDuration((long) i);
    }

    public final void cancel() {
        this.ly.cancel();
    }

    public final float getAnimatedFraction() {
        return this.ly.getAnimatedFraction();
    }

    public final long getDuration() {
        return this.ly.getDuration();
    }
}
