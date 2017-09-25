package android.support.v4.view;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.support.v4.view.aj.AnonymousClass1;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class ai {
    public static final g zz;
    public WeakReference<View> zv;
    public Runnable zw = null;
    public Runnable zx = null;
    public int zy = -1;

    interface g {
        void a(ai aiVar, View view);

        void a(ai aiVar, View view, float f);

        void a(ai aiVar, View view, am amVar);

        void a(View view, long j);

        void a(View view, ao aoVar);

        void a(View view, Interpolator interpolator);

        long ar(View view);

        void b(ai aiVar, View view);

        void b(ai aiVar, View view, float f);

        void b(View view, long j);

        void c(ai aiVar, View view, float f);

        void d(ai aiVar, View view, float f);

        void e(ai aiVar, View view, float f);
    }

    static class a implements g {
        WeakHashMap<View, Runnable> zA = null;

        class a implements Runnable {
            WeakReference<View> fh;
            ai zB;
            final /* synthetic */ a zC;

            public a(a aVar, ai aiVar, View view) {
                this.zC = aVar;
                this.fh = new WeakReference(view);
                this.zB = aiVar;
            }

            public final void run() {
                View view = (View) this.fh.get();
                if (view != null) {
                    this.zC.c(this.zB, view);
                }
            }
        }

        a() {
        }

        public void a(View view, long j) {
        }

        public void a(ai aiVar, View view, float f) {
            d(aiVar, view);
        }

        public void b(ai aiVar, View view, float f) {
            d(aiVar, view);
        }

        public void c(ai aiVar, View view, float f) {
            d(aiVar, view);
        }

        public long ar(View view) {
            return 0;
        }

        public void a(View view, Interpolator interpolator) {
        }

        public void b(View view, long j) {
        }

        public void d(ai aiVar, View view, float f) {
            d(aiVar, view);
        }

        public void e(ai aiVar, View view, float f) {
            d(aiVar, view);
        }

        public void a(ai aiVar, View view) {
            d(aiVar, view);
        }

        public void b(ai aiVar, View view) {
            if (this.zA != null) {
                Runnable runnable = (Runnable) this.zA.get(view);
                if (runnable != null) {
                    view.removeCallbacks(runnable);
                }
            }
            c(aiVar, view);
        }

        public void a(ai aiVar, View view, am amVar) {
            view.setTag(2113929216, amVar);
        }

        public void a(View view, ao aoVar) {
        }

        public final void c(ai aiVar, View view) {
            am amVar;
            Object tag = view.getTag(2113929216);
            if (tag instanceof am) {
                amVar = (am) tag;
            } else {
                amVar = null;
            }
            Runnable runnable = aiVar.zw;
            Runnable runnable2 = aiVar.zx;
            aiVar.zw = null;
            aiVar.zx = null;
            if (runnable != null) {
                runnable.run();
            }
            if (amVar != null) {
                amVar.p(view);
                amVar.q(view);
            }
            if (runnable2 != null) {
                runnable2.run();
            }
            if (this.zA != null) {
                this.zA.remove(view);
            }
        }

        private void d(ai aiVar, View view) {
            Runnable runnable = null;
            if (this.zA != null) {
                runnable = (Runnable) this.zA.get(view);
            }
            if (runnable == null) {
                runnable = new a(this, aiVar, view);
                if (this.zA == null) {
                    this.zA = new WeakHashMap();
                }
                this.zA.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }
    }

    static class b extends a {
        WeakHashMap<View, Integer> zD = null;

        static class a implements am {
            ai zB;
            boolean zE;

            a(ai aiVar) {
                this.zB = aiVar;
            }

            public final void p(View view) {
                am amVar;
                this.zE = false;
                if (this.zB.zy >= 0) {
                    z.a(view, 2, null);
                }
                if (this.zB.zw != null) {
                    Runnable runnable = this.zB.zw;
                    this.zB.zw = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof am) {
                    amVar = (am) tag;
                } else {
                    amVar = null;
                }
                if (amVar != null) {
                    amVar.p(view);
                }
            }

            public final void q(View view) {
                if (this.zB.zy >= 0) {
                    z.a(view, this.zB.zy, null);
                    this.zB.zy = -1;
                }
                if (VERSION.SDK_INT >= 16 || !this.zE) {
                    am amVar;
                    if (this.zB.zx != null) {
                        Runnable runnable = this.zB.zx;
                        this.zB.zx = null;
                        runnable.run();
                    }
                    Object tag = view.getTag(2113929216);
                    if (tag instanceof am) {
                        amVar = (am) tag;
                    } else {
                        amVar = null;
                    }
                    if (amVar != null) {
                        amVar.q(view);
                    }
                    this.zE = true;
                }
            }

            public final void as(View view) {
                am amVar;
                Object tag = view.getTag(2113929216);
                if (tag instanceof am) {
                    amVar = (am) tag;
                } else {
                    amVar = null;
                }
                if (amVar != null) {
                    amVar.as(view);
                }
            }
        }

        b() {
        }

        public final void a(View view, long j) {
            view.animate().setDuration(j);
        }

        public final void a(ai aiVar, View view, float f) {
            view.animate().alpha(f);
        }

        public final void b(ai aiVar, View view, float f) {
            view.animate().translationX(f);
        }

        public final void c(ai aiVar, View view, float f) {
            view.animate().translationY(f);
        }

        public final long ar(View view) {
            return view.animate().getDuration();
        }

        public final void a(View view, Interpolator interpolator) {
            view.animate().setInterpolator(interpolator);
        }

        public final void b(View view, long j) {
            view.animate().setStartDelay(j);
        }

        public final void d(ai aiVar, View view, float f) {
            view.animate().scaleX(f);
        }

        public final void e(ai aiVar, View view, float f) {
            view.animate().scaleY(f);
        }

        public final void a(ai aiVar, View view) {
            view.animate().cancel();
        }

        public final void b(ai aiVar, View view) {
            view.animate().start();
        }

        public void a(ai aiVar, View view, am amVar) {
            view.setTag(2113929216, amVar);
            view.animate().setListener(new AnonymousClass1(new a(aiVar), view));
        }
    }

    static class d extends b {
        d() {
        }

        public final void a(ai aiVar, View view, am amVar) {
            if (amVar != null) {
                view.animate().setListener(new ak.AnonymousClass1(amVar, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    static class c extends d {
        c() {
        }
    }

    static class e extends c {
        e() {
        }

        public final void a(View view, ao aoVar) {
            AnimatorUpdateListener animatorUpdateListener = null;
            if (aoVar != null) {
                animatorUpdateListener = new al.AnonymousClass1(aoVar, view);
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
    }

    static class f extends e {
        f() {
        }
    }

    ai(View view) {
        this.zv = new WeakReference(view);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            zz = new f();
        } else if (i >= 19) {
            zz = new e();
        } else if (i >= 18) {
            zz = new c();
        } else if (i >= 16) {
            zz = new d();
        } else if (i >= 14) {
            zz = new b();
        } else {
            zz = new a();
        }
    }

    public final ai c(long j) {
        View view = (View) this.zv.get();
        if (view != null) {
            zz.a(view, j);
        }
        return this;
    }

    public final ai p(float f) {
        View view = (View) this.zv.get();
        if (view != null) {
            zz.a(this, view, f);
        }
        return this;
    }

    public final ai q(float f) {
        View view = (View) this.zv.get();
        if (view != null) {
            zz.b(this, view, f);
        }
        return this;
    }

    public final ai r(float f) {
        View view = (View) this.zv.get();
        if (view != null) {
            zz.c(this, view, f);
        }
        return this;
    }

    public final ai b(Interpolator interpolator) {
        View view = (View) this.zv.get();
        if (view != null) {
            zz.a(view, interpolator);
        }
        return this;
    }

    public final ai d(long j) {
        View view = (View) this.zv.get();
        if (view != null) {
            zz.b(view, j);
        }
        return this;
    }

    public final ai s(float f) {
        View view = (View) this.zv.get();
        if (view != null) {
            zz.d(this, view, f);
        }
        return this;
    }

    public final ai t(float f) {
        View view = (View) this.zv.get();
        if (view != null) {
            zz.e(this, view, f);
        }
        return this;
    }

    public final void cancel() {
        View view = (View) this.zv.get();
        if (view != null) {
            zz.a(this, view);
        }
    }

    public final void start() {
        View view = (View) this.zv.get();
        if (view != null) {
            zz.b(this, view);
        }
    }

    public final ai a(am amVar) {
        View view = (View) this.zv.get();
        if (view != null) {
            zz.a(this, view, amVar);
        }
        return this;
    }

    public final ai a(ao aoVar) {
        View view = (View) this.zv.get();
        if (view != null) {
            zz.a(view, aoVar);
        }
        return this;
    }
}
