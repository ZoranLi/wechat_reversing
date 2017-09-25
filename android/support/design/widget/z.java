package android.support.design.widget;

import android.view.View;

final class z {
    private int lJ;
    private int lK;
    int lL;
    int lM;
    private final View mView;

    public z(View view) {
        this.mView = view;
    }

    public final void ay() {
        this.lJ = this.mView.getTop();
        this.lK = this.mView.getLeft();
        az();
    }

    final void az() {
        android.support.v4.view.z.j(this.mView, this.lL - (this.mView.getTop() - this.lJ));
        android.support.v4.view.z.k(this.mView, this.lM - (this.mView.getLeft() - this.lK));
    }

    public final boolean f(int i) {
        if (this.lL == i) {
            return false;
        }
        this.lL = i;
        az();
        return true;
    }
}
