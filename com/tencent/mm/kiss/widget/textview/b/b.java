package com.tencent.mm.kiss.widget.textview.b;

import android.text.Layout;
import android.text.NoCopySpan.Concrete;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.kiss.widget.textview.a;

public final class b {
    private static b hbk;
    private static Object hbl = new Concrete();

    public static boolean a(View view, Layout layout, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (!(view instanceof a)) {
            return false;
        }
        a aVar = (a) view;
        if (action == 1 || action == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (x < aVar.vT() || x > layout.getWidth() + aVar.vT()) {
                return false;
            }
            if (y < aVar.vU() || y > layout.getHeight() + aVar.vU()) {
                return false;
            }
            x = layout.getOffsetForHorizontal(layout.getLineForVertical((y - aVar.vU()) + aVar.getScrollY()), (float) ((x - aVar.vT()) + aVar.getScrollX()));
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(x, x, ClickableSpan.class);
            if (clickableSpanArr.length == 0) {
                Selection.removeSelection(spannable);
            } else if (action == 1) {
                return true;
            } else {
                Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                return true;
            }
        }
        return false;
    }

    public static void a(Spannable spannable) {
        Selection.removeSelection(spannable);
        spannable.removeSpan(hbl);
    }

    public static b wg() {
        if (hbk == null) {
            hbk = new b();
        }
        return hbk;
    }
}
