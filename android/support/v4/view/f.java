package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;

public final class f {
    static final a wX;

    interface a {
        void apply(int i, int i2, int i3, Rect rect, Rect rect2, int i4);

        int getAbsoluteGravity(int i, int i2);
    }

    static class b implements a {
        b() {
        }

        public final int getAbsoluteGravity(int i, int i2) {
            return -8388609 & i;
        }

        public final void apply(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            Gravity.apply(i, i2, i3, rect, rect2);
        }
    }

    static class c implements a {
        c() {
        }

        public final int getAbsoluteGravity(int i, int i2) {
            return Gravity.getAbsoluteGravity(i, i2);
        }

        public final void apply(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            Gravity.apply(i, i2, i3, rect, rect2, i4);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            wX = new c();
        } else {
            wX = new b();
        }
    }

    public static void apply(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        wX.apply(i, i2, i3, rect, rect2, i4);
    }

    public static int getAbsoluteGravity(int i, int i2) {
        return wX.getAbsoluteGravity(i, i2);
    }
}
