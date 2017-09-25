package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

final class y {
    private static final ThreadLocal<Matrix> lD = new ThreadLocal();
    private static final ThreadLocal<RectF> lE = new ThreadLocal();
    private static final Matrix lF = new Matrix();

    public static void b(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix;
        Matrix matrix2 = (Matrix) lD.get();
        if (matrix2 == null) {
            matrix2 = new Matrix();
            lD.set(matrix2);
            matrix = matrix2;
        } else {
            matrix2.set(lF);
            matrix = matrix2;
        }
        a(viewGroup, view, matrix);
        RectF rectF = (RectF) lE.get();
        if (rectF == null) {
            rectF = new RectF();
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    private static void a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
