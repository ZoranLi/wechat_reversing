package android.support.design.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewOutlineProvider;

final class aa {
    static final d lN = new d() {
        public final u av() {
            return new u(VERSION.SDK_INT >= 12 ? new w() : new v());
        }
    };
    private static final a lO;

    private interface a {
        void u(View view);
    }

    private static class b implements a {
        public final void u(View view) {
        }
    }

    private static class c implements a {
        public final void u(View view) {
            view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            lO = new c();
        } else {
            lO = new b();
        }
    }

    static void u(View view) {
        lO.u(view);
    }

    static u av() {
        return lN.av();
    }
}
