package android.support.design.widget;

import android.view.animation.Interpolator;

final class u {
    final e ll;

    interface a {
        void aq();
    }

    interface c {
        void a(u uVar);
    }

    interface d {
        u av();
    }

    static abstract class e {

        interface a {
            void onAnimationEnd();
        }

        interface b {
            void au();
        }

        abstract void a(a aVar);

        abstract void a(b bVar);

        abstract int aw();

        abstract float ax();

        abstract void cancel();

        abstract void e(float f, float f2);

        abstract void e(int i, int i2);

        abstract float getAnimatedFraction();

        abstract long getDuration();

        abstract boolean isRunning();

        abstract void setDuration(int i);

        abstract void setInterpolator(Interpolator interpolator);

        abstract void start();

        e() {
        }
    }

    class AnonymousClass2 implements a {
        final /* synthetic */ u ln;
        final /* synthetic */ a lo;

        AnonymousClass2(u uVar, a aVar) {
            this.ln = uVar;
            this.lo = aVar;
        }

        public final void onAnimationEnd() {
            this.lo.aq();
        }
    }

    static class b implements a {
        b() {
        }

        public void aq() {
        }
    }

    u(e eVar) {
        this.ll = eVar;
    }

    public final void setInterpolator(Interpolator interpolator) {
        this.ll.setInterpolator(interpolator);
    }

    public final void a(final c cVar) {
        this.ll.a(new b(this) {
            final /* synthetic */ u ln;

            public final void au() {
                cVar.a(this.ln);
            }
        });
    }

    public final void e(int i, int i2) {
        this.ll.e(i, i2);
    }

    public final void e(float f, float f2) {
        this.ll.e(f, f2);
    }

    public final void setDuration(int i) {
        this.ll.setDuration(i);
    }
}
