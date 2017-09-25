package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.view.f;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    private final Rect hd = new Rect();
    private final Rect he = new Rect();
    int iI = 0;
    int iJ;

    abstract View c(List<View> list);

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View c = c(coordinatorLayout.n(view));
            if (c != null) {
                if (z.aa(c) && !z.aa(view)) {
                    z.a(view, true);
                    if (z.aa(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                if (z.aj(c)) {
                    int size = MeasureSpec.getSize(i3);
                    if (size == 0) {
                        size = coordinatorLayout.getHeight();
                    }
                    coordinatorLayout.a(view, i, i2, MeasureSpec.makeMeasureSpec(g(c) + (size - c.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                    return true;
                }
            }
        }
        return false;
    }

    protected final void d(CoordinatorLayout coordinatorLayout, View view, int i) {
        View c = c(coordinatorLayout.n(view));
        if (c != null) {
            d dVar = (d) view.getLayoutParams();
            Rect rect = this.hd;
            rect.set(coordinatorLayout.getPaddingLeft() + dVar.leftMargin, c.getBottom() + dVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - dVar.rightMargin, ((coordinatorLayout.getHeight() + c.getBottom()) - coordinatorLayout.getPaddingBottom()) - dVar.bottomMargin);
            Rect rect2 = this.he;
            int i2 = dVar.gravity;
            if (i2 == 0) {
                i2 = 8388659;
            }
            f.apply(i2, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            i2 = o(c);
            view.layout(rect2.left, rect2.top - i2, rect2.right, rect2.bottom - i2);
            this.iI = rect2.top - c.getBottom();
            return;
        }
        super.d(coordinatorLayout, view, i);
        this.iI = 0;
    }

    float f(View view) {
        return 1.0f;
    }

    final int o(View view) {
        return this.iJ == 0 ? 0 : n.b(Math.round(f(view) * ((float) this.iJ)), 0, this.iJ);
    }

    int g(View view) {
        return view.getMeasuredHeight();
    }
}
