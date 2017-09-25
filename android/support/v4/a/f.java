package android.support.v4.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class f implements c {
    private TimeInterpolator nC;

    static class a implements AnimatorListener {
        final b nD;
        final g nE;

        public a(b bVar, g gVar) {
            this.nD = bVar;
            this.nE = gVar;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            this.nD.a(this.nE);
        }

        public final void onAnimationCancel(Animator animator) {
            this.nD.aC();
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    static class b implements g {
        final Animator nF;

        public b(Animator animator) {
            this.nF = animator;
        }

        public final void w(View view) {
            this.nF.setTarget(view);
        }

        public final void a(b bVar) {
            this.nF.addListener(new a(bVar, this));
        }

        public final void setDuration(long j) {
            this.nF.setDuration(j);
        }

        public final void start() {
            this.nF.start();
        }

        public final void cancel() {
            this.nF.cancel();
        }

        public final void a(final d dVar) {
            if (this.nF instanceof ValueAnimator) {
                ((ValueAnimator) this.nF).addUpdateListener(new AnimatorUpdateListener(this) {
                    final /* synthetic */ b nH;

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        dVar.b(this.nH);
                    }
                });
            }
        }

        public final float getAnimatedFraction() {
            return ((ValueAnimator) this.nF).getAnimatedFraction();
        }
    }

    f() {
    }

    public final g aB() {
        return new b(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}));
    }

    public final void v(View view) {
        if (this.nC == null) {
            this.nC = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.nC);
    }
}
