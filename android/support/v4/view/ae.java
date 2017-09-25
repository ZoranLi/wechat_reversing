package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public final class ae {
    static final e yk;

    interface e {
        int a(ViewConfiguration viewConfiguration);

        boolean b(ViewConfiguration viewConfiguration);
    }

    static class a implements e {
        a() {
        }

        public int a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledTouchSlop();
        }

        public boolean b(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    static class b extends a {
        b() {
        }

        public final int a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledPagingTouchSlop();
        }
    }

    static class c extends b {
        c() {
        }

        public boolean b(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    static class d extends c {
        d() {
        }

        public final boolean b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.hasPermanentMenuKey();
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            yk = new d();
        } else if (VERSION.SDK_INT >= 11) {
            yk = new c();
        } else if (VERSION.SDK_INT >= 8) {
            yk = new b();
        } else {
            yk = new a();
        }
    }

    public static int a(ViewConfiguration viewConfiguration) {
        return yk.a(viewConfiguration);
    }

    public static boolean b(ViewConfiguration viewConfiguration) {
        return yk.b(viewConfiguration);
    }
}
