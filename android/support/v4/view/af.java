package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public final class af {
    static final c yl;

    interface c {
        void b(ViewGroup viewGroup, boolean z);
    }

    static class f implements c {
        f() {
        }

        public void b(ViewGroup viewGroup, boolean z) {
        }
    }

    static class a extends f {
        a() {
        }

        public final void b(ViewGroup viewGroup, boolean z) {
            viewGroup.setMotionEventSplittingEnabled(false);
        }
    }

    static class b extends a {
        b() {
        }
    }

    static class d extends b {
        d() {
        }
    }

    static class e extends d {
        e() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            yl = new e();
        } else if (i >= 18) {
            yl = new d();
        } else if (i >= 14) {
            yl = new b();
        } else if (i >= 11) {
            yl = new a();
        } else {
            yl = new f();
        }
    }

    public static void b(ViewGroup viewGroup) {
        yl.b(viewGroup, false);
    }
}
