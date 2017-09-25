package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;

public final class i {
    private static final c Cp;
    private Object Co;

    interface c {
        boolean H(Object obj);

        void I(Object obj);

        boolean J(Object obj);

        void a(Object obj, int i, int i2);

        boolean a(Object obj, float f);

        boolean a(Object obj, float f, float f2);

        boolean a(Object obj, Canvas canvas);

        boolean l(Object obj, int i);

        Object m(Context context);
    }

    static class a implements c {
        a() {
        }

        public final Object m(Context context) {
            return null;
        }

        public final void a(Object obj, int i, int i2) {
        }

        public final boolean H(Object obj) {
            return true;
        }

        public final void I(Object obj) {
        }

        public final boolean a(Object obj, float f) {
            return false;
        }

        public final boolean J(Object obj) {
            return false;
        }

        public final boolean l(Object obj, int i) {
            return false;
        }

        public final boolean a(Object obj, Canvas canvas) {
            return false;
        }

        public final boolean a(Object obj, float f, float f2) {
            return false;
        }
    }

    static class b implements c {
        b() {
        }

        public final Object m(Context context) {
            return new EdgeEffect(context);
        }

        public final void a(Object obj, int i, int i2) {
            ((EdgeEffect) obj).setSize(i, i2);
        }

        public final boolean H(Object obj) {
            return ((EdgeEffect) obj).isFinished();
        }

        public final void I(Object obj) {
            ((EdgeEffect) obj).finish();
        }

        public final boolean a(Object obj, float f) {
            return j.a(obj, f);
        }

        public final boolean J(Object obj) {
            EdgeEffect edgeEffect = (EdgeEffect) obj;
            edgeEffect.onRelease();
            return edgeEffect.isFinished();
        }

        public final boolean l(Object obj, int i) {
            ((EdgeEffect) obj).onAbsorb(i);
            return true;
        }

        public final boolean a(Object obj, Canvas canvas) {
            return ((EdgeEffect) obj).draw(canvas);
        }

        public boolean a(Object obj, float f, float f2) {
            return j.a(obj, f);
        }
    }

    static class d extends b {
        d() {
        }

        public final boolean a(Object obj, float f, float f2) {
            ((EdgeEffect) obj).onPull(f, f2);
            return true;
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            Cp = new d();
        } else if (VERSION.SDK_INT >= 14) {
            Cp = new b();
        } else {
            Cp = new a();
        }
    }

    public i(Context context) {
        this.Co = Cp.m(context);
    }

    public final void setSize(int i, int i2) {
        Cp.a(this.Co, i, i2);
    }

    public final boolean isFinished() {
        return Cp.H(this.Co);
    }

    public final void finish() {
        Cp.I(this.Co);
    }

    public final boolean u(float f) {
        return Cp.a(this.Co, f);
    }

    public final boolean h(float f, float f2) {
        return Cp.a(this.Co, f, f2);
    }

    public final boolean cr() {
        return Cp.J(this.Co);
    }

    public final boolean ag(int i) {
        return Cp.l(this.Co, i);
    }

    public final boolean draw(Canvas canvas) {
        return Cp.a(this.Co, canvas);
    }
}
