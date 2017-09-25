package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.t;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.ArrayList;
import java.util.List;

final class j extends a {
    private LayoutInflater Du;
    final SparseArray<k> jnG = new SparseArray();
    private final ArrayList<?> jnH;

    j(ArrayList<?> arrayList) {
        this.jnH = arrayList;
    }

    final boolean isEmpty() {
        return this.jnH == null || bg.bV(this.jnH);
    }

    final Object iB(int i) {
        return (i < 0 || i > getItemCount()) ? null : this.jnH.get(i);
    }

    public final t a(ViewGroup viewGroup, int i) {
        k kVar = (k) this.jnG.get(i);
        if (kVar == null) {
            return null;
        }
        Context context = viewGroup.getContext();
        if (this.Du == null) {
            this.Du = LayoutInflater.from(context);
        }
        return kVar.a(this.Du, viewGroup);
    }

    public final void a(t tVar, int i) {
        k kVar = (k) this.jnG.get(getItemViewType(i));
        if (kVar != null) {
            kVar.a(tVar, iB(i));
        }
    }

    public final void a(t tVar, int i, List list) {
        k kVar = (k) this.jnG.get(getItemViewType(i));
        if (kVar == null) {
            super.a(tVar, i, list);
        } else if (list.size() <= 0 || !kVar.a(tVar, iB(i), list.get(0))) {
            kVar.a(tVar, iB(i));
        }
    }

    public final int getItemViewType(int i) {
        Object iB = iB(i);
        return iB == null ? 0 : iB.getClass().hashCode();
    }

    public final long getItemId(int i) {
        Object iB = iB(i);
        k kVar = (k) this.jnG.get(getItemViewType(i));
        return (iB == null || kVar == null) ? 0 : kVar.aL(iB);
    }

    public final int getItemCount() {
        return this.jnH == null ? 0 : this.jnH.size();
    }
}
