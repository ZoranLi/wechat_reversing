package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;

final class ah {
    static int a(q qVar, ab abVar, View view, View view2, h hVar, boolean z, boolean z2) {
        if (hVar.getChildCount() == 0 || qVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (qVar.getItemCount() - Math.max(h.be(view), h.be(view2))) - 1) : Math.max(0, Math.min(h.be(view), h.be(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(abVar.aW(view2) - abVar.aV(view))) / ((float) (Math.abs(h.be(view) - h.be(view2)) + 1)))) + ((float) (abVar.fj() - abVar.aV(view))));
    }

    static int a(q qVar, ab abVar, View view, View view2, h hVar, boolean z) {
        if (hVar.getChildCount() == 0 || qVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(h.be(view) - h.be(view2)) + 1;
        }
        return Math.min(abVar.fl(), abVar.aW(view2) - abVar.aV(view));
    }

    static int b(q qVar, ab abVar, View view, View view2, h hVar, boolean z) {
        if (hVar.getChildCount() == 0 || qVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return qVar.getItemCount();
        }
        return (int) ((((float) (abVar.aW(view2) - abVar.aV(view))) / ((float) (Math.abs(h.be(view) - h.be(view2)) + 1))) * ((float) qVar.getItemCount()));
    }
}
