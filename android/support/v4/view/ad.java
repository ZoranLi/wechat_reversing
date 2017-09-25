package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class ad {
    private static ThreadLocal<Rect> yi;

    static class AnonymousClass1 implements OnApplyWindowInsetsListener {
        final /* synthetic */ t yj;

        AnonymousClass1(t tVar) {
            this.yj = tVar;
        }

        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return ((aq) this.yj.a(view, new aq(windowInsets))).zI;
        }
    }

    static Rect bO() {
        if (yi == null) {
            yi = new ThreadLocal();
        }
        Rect rect = (Rect) yi.get();
        if (rect == null) {
            rect = new Rect();
            yi.set(rect);
        }
        rect.setEmpty();
        return rect;
    }
}
