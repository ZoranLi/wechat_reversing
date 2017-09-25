package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.e;
import android.support.v7.widget.RecyclerView.e.c;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;

public abstract class aj extends e {
    public boolean acX = true;

    public abstract boolean a(t tVar, int i, int i2, int i3, int i4);

    public abstract boolean a(t tVar, t tVar2, int i, int i2, int i3, int i4);

    public abstract boolean b(t tVar);

    public abstract boolean c(t tVar);

    public final boolean m(t tVar) {
        return !this.acX || tVar.gl();
    }

    public boolean d(t tVar, c cVar, c cVar2) {
        int i = cVar.left;
        int i2 = cVar.top;
        View view = tVar.abf;
        int left = cVar2 == null ? view.getLeft() : cVar2.left;
        int top = cVar2 == null ? view.getTop() : cVar2.top;
        if (tVar.isRemoved() || (i == left && i2 == top)) {
            return b(tVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(tVar, i, i2, left, top);
    }

    public boolean e(t tVar, c cVar, c cVar2) {
        if (cVar == null || (cVar.left == cVar2.left && cVar.top == cVar2.top)) {
            return c(tVar);
        }
        return a(tVar, cVar.left, cVar.top, cVar2.left, cVar2.top);
    }

    public final boolean f(t tVar, c cVar, c cVar2) {
        if (cVar.left == cVar2.left && cVar.top == cVar2.top) {
            q(tVar);
            return false;
        }
        return a(tVar, cVar.left, cVar.top, cVar2.left, cVar2.top);
    }

    public boolean a(t tVar, t tVar2, c cVar, c cVar2) {
        int i;
        int i2;
        int i3 = cVar.left;
        int i4 = cVar.top;
        if (tVar2.gd()) {
            i = cVar.left;
            i2 = cVar.top;
        } else {
            i = cVar2.left;
            i2 = cVar2.top;
        }
        return a(tVar, tVar2, i3, i4, i, i2);
    }

    public final void q(t tVar) {
        t(tVar);
        k(tVar);
    }

    public void r(t tVar) {
    }

    public void s(t tVar) {
    }

    public void t(t tVar) {
    }
}
