package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityRecord;

public final class f {
    public static final c Aq;
    public final Object Ar;

    interface c {
        Object ci();

        void e(Object obj, int i);

        void f(Object obj, int i);

        void f(Object obj, boolean z);

        void g(Object obj, int i);

        void h(Object obj, int i);

        void i(Object obj, int i);

        void j(Object obj, int i);

        void k(Object obj, int i);
    }

    static class e implements c {
        e() {
        }

        public Object ci() {
            return null;
        }

        public void e(Object obj, int i) {
        }

        public void f(Object obj, int i) {
        }

        public void j(Object obj, int i) {
        }

        public void k(Object obj, int i) {
        }

        public void g(Object obj, int i) {
        }

        public void h(Object obj, int i) {
        }

        public void f(Object obj, boolean z) {
        }

        public void i(Object obj, int i) {
        }
    }

    static class a extends e {
        a() {
        }

        public final Object ci() {
            return AccessibilityRecord.obtain();
        }

        public final void e(Object obj, int i) {
            ((AccessibilityRecord) obj).setFromIndex(i);
        }

        public final void f(Object obj, int i) {
            ((AccessibilityRecord) obj).setItemCount(i);
        }

        public final void g(Object obj, int i) {
            ((AccessibilityRecord) obj).setScrollX(i);
        }

        public final void h(Object obj, int i) {
            ((AccessibilityRecord) obj).setScrollY(i);
        }

        public final void f(Object obj, boolean z) {
            ((AccessibilityRecord) obj).setScrollable(z);
        }

        public final void i(Object obj, int i) {
            ((AccessibilityRecord) obj).setToIndex(i);
        }
    }

    static class b extends a {
        b() {
        }

        public final void j(Object obj, int i) {
            ((AccessibilityRecord) obj).setMaxScrollX(i);
        }

        public final void k(Object obj, int i) {
            ((AccessibilityRecord) obj).setMaxScrollY(i);
        }
    }

    static class d extends b {
        d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            Aq = new d();
        } else if (VERSION.SDK_INT >= 15) {
            Aq = new b();
        } else if (VERSION.SDK_INT >= 14) {
            Aq = new a();
        } else {
            Aq = new e();
        }
    }

    public f(Object obj) {
        this.Ar = obj;
    }

    public static f ch() {
        return new f(Aq.ci());
    }

    public final void setScrollable(boolean z) {
        Aq.f(this.Ar, z);
    }

    public final void setItemCount(int i) {
        Aq.f(this.Ar, i);
    }

    public final void setFromIndex(int i) {
        Aq.e(this.Ar, i);
    }

    public final void setToIndex(int i) {
        Aq.i(this.Ar, i);
    }

    public final int hashCode() {
        return this.Ar == null ? 0 : this.Ar.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.Ar == null) {
            if (fVar.Ar != null) {
                return false;
            }
            return true;
        } else if (this.Ar.equals(fVar.Ar)) {
            return true;
        } else {
            return false;
        }
    }
}
