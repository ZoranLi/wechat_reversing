package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;

public final class h {
    static final a wZ;

    interface a {
        k a(LayoutInflater layoutInflater);

        void a(LayoutInflater layoutInflater, k kVar);
    }

    static class b implements a {
        b() {
        }

        public void a(LayoutInflater layoutInflater, k kVar) {
            layoutInflater.setFactory(kVar != null ? new a(kVar) : null);
        }

        public final k a(LayoutInflater layoutInflater) {
            Factory factory = layoutInflater.getFactory();
            return factory instanceof a ? ((a) factory).xa : null;
        }
    }

    static class c extends b {
        c() {
        }

        public void a(LayoutInflater layoutInflater, k kVar) {
            Factory2 aVar = kVar != null ? new a(kVar) : null;
            layoutInflater.setFactory2(aVar);
            Factory factory = layoutInflater.getFactory();
            if (factory instanceof Factory2) {
                j.a(layoutInflater, (Factory2) factory);
            } else {
                j.a(layoutInflater, aVar);
            }
        }
    }

    static class d extends c {
        d() {
        }

        public final void a(LayoutInflater layoutInflater, k kVar) {
            layoutInflater.setFactory2(kVar != null ? new a(kVar) : null);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            wZ = new d();
        } else if (i >= 11) {
            wZ = new c();
        } else {
            wZ = new b();
        }
    }

    public static void a(LayoutInflater layoutInflater, k kVar) {
        wZ.a(layoutInflater, kVar);
    }

    public static k a(LayoutInflater layoutInflater) {
        return wZ.a(layoutInflater);
    }
}
