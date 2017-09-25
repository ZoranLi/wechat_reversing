package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

final class x {
    private static final a lC;

    private interface a {
        void b(ViewGroup viewGroup, View view, Rect rect);
    }

    private static class b implements a {
        public final void b(ViewGroup viewGroup, View view, Rect rect) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(view.getScrollX(), view.getScrollY());
        }
    }

    private static class c implements a {
        public final void b(ViewGroup viewGroup, View view, Rect rect) {
            y.b(viewGroup, view, rect);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            lC = new c();
        } else {
            lC = new b();
        }
    }

    static void a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        lC.b(viewGroup, view, rect);
    }
}
