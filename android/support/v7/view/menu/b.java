package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.z;
import android.support.v7.view.menu.l.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b implements l {
    protected LayoutInflater Du;
    public Context PR;
    protected LayoutInflater PS;
    private int PT;
    private int PU;
    public m PV;
    public a dV;
    public f dW;
    public int dX;
    public Context mContext;

    public abstract void a(h hVar, m.a aVar);

    public b(Context context, int i, int i2) {
        this.PR = context;
        this.PS = LayoutInflater.from(context);
        this.PT = i;
        this.PU = i2;
    }

    public void a(Context context, f fVar) {
        this.mContext = context;
        this.Du = LayoutInflater.from(this.mContext);
        this.dW = fVar;
    }

    public m c(ViewGroup viewGroup) {
        if (this.PV == null) {
            this.PV = (m) this.PS.inflate(this.PT, viewGroup, false);
            this.PV.a(this.dW);
            f(true);
        }
        return this.PV;
    }

    public void f(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.PV;
        if (viewGroup != null) {
            int i;
            if (this.dW != null) {
                this.dW.dA();
                ArrayList dz = this.dW.dz();
                int size = dz.size();
                int i2 = 0;
                i = 0;
                while (i2 < size) {
                    int i3;
                    h hVar = (h) dz.get(i2);
                    if (e(hVar)) {
                        View childAt = viewGroup.getChildAt(i);
                        h z2 = childAt instanceof m.a ? ((m.a) childAt).z() : null;
                        View a = a(hVar, childAt, viewGroup);
                        if (hVar != z2) {
                            a.setPressed(false);
                            z.ab(a);
                        }
                        if (a != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a);
                            }
                            ((ViewGroup) this.PV).addView(a, i);
                        }
                        i3 = i + 1;
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!c(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    public boolean c(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public View a(h hVar, View view, ViewGroup viewGroup) {
        m.a aVar;
        if (view instanceof m.a) {
            aVar = (m.a) view;
        } else {
            aVar = (m.a) this.PS.inflate(this.PU, viewGroup, false);
        }
        a(hVar, aVar);
        return (View) aVar;
    }

    public boolean e(h hVar) {
        return true;
    }

    public void a(f fVar, boolean z) {
        if (this.dV != null) {
            this.dV.a(fVar, z);
        }
    }

    public boolean a(p pVar) {
        if (this.dV != null) {
            return this.dV.d(pVar);
        }
        return false;
    }

    public boolean B() {
        return false;
    }

    public final boolean b(h hVar) {
        return false;
    }

    public final boolean c(h hVar) {
        return false;
    }

    public final int getId() {
        return this.dX;
    }
}
