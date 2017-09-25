package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public final class ag {
    static final b zu;

    interface b {
        void a(ViewParent viewParent, View view);

        void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

        void a(ViewParent viewParent, View view, int i, int i2, int[] iArr);

        boolean a(ViewParent viewParent, View view, float f, float f2);

        boolean a(ViewParent viewParent, View view, float f, float f2, boolean z);

        boolean a(ViewParent viewParent, View view, View view2, int i);

        void b(ViewParent viewParent, View view, View view2, int i);
    }

    static class e implements b {
        e() {
        }

        public boolean a(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof r) {
                return ((r) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        public void b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof r) {
                ((r) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        public void a(ViewParent viewParent, View view) {
            if (viewParent instanceof r) {
                ((r) viewParent).onStopNestedScroll(view);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof r) {
                ((r) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof r) {
                ((r) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            if (viewParent instanceof r) {
                return ((r) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        public boolean a(ViewParent viewParent, View view, float f, float f2) {
            if (viewParent instanceof r) {
                return ((r) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }
    }

    static class a extends e {
        a() {
        }
    }

    static class c extends a {
        c() {
        }
    }

    static class d extends c {
        d() {
        }

        public final boolean a(ViewParent viewParent, View view, View view2, int i) {
            return ah.a(viewParent, view, view2, i);
        }

        public final void b(ViewParent viewParent, View view, View view2, int i) {
            try {
                viewParent.onNestedScrollAccepted(view, view2, i);
            } catch (AbstractMethodError e) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedScrollAccepted");
            }
        }

        public final void a(ViewParent viewParent, View view) {
            try {
                viewParent.onStopNestedScroll(view);
            } catch (AbstractMethodError e) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onStopNestedScroll");
            }
        }

        public final void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            try {
                viewParent.onNestedScroll(view, i, i2, i3, i4);
            } catch (AbstractMethodError e) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedScroll");
            }
        }

        public final void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            try {
                viewParent.onNestedPreScroll(view, i, i2, iArr);
            } catch (AbstractMethodError e) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedPreScroll");
            }
        }

        public final boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return ah.a(viewParent, view, f, f2, z);
        }

        public final boolean a(ViewParent viewParent, View view, float f, float f2) {
            return ah.a(viewParent, view, f, f2);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            zu = new d();
        } else if (i >= 19) {
            zu = new c();
        } else if (i >= 14) {
            zu = new a();
        } else {
            zu = new e();
        }
    }

    public static boolean a(ViewParent viewParent, View view, View view2, int i) {
        return zu.a(viewParent, view, view2, i);
    }

    public static void b(ViewParent viewParent, View view, View view2, int i) {
        zu.b(viewParent, view, view2, i);
    }

    public static void a(ViewParent viewParent, View view) {
        zu.a(viewParent, view);
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        zu.a(viewParent, view, i, i2, i3, i4);
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        zu.a(viewParent, view, i, i2, iArr);
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return zu.a(viewParent, view, f, f2, z);
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2) {
        return zu.a(viewParent, view, f, f2);
    }
}
