package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.p;
import android.support.v7.widget.RecyclerView.t;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public final class b implements l {
    public ColorStateList dS;
    public NavigationMenuView dT;
    public LinearLayout dU;
    private android.support.v7.view.menu.l.a dV;
    public android.support.v7.view.menu.f dW;
    public int dX;
    public b dY;
    public LayoutInflater dZ;
    public int ea;
    public boolean eb;
    public ColorStateList ec;
    public Drawable ed;
    public int ee;
    public int ef;
    public final OnClickListener mOnClickListener = new OnClickListener(this) {
        final /* synthetic */ b eg;

        {
            this.eg = r1;
        }

        public final void onClick(View view) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
            this.eg.g(true);
            MenuItem menuItem = navigationMenuItemView.dR;
            boolean a = this.eg.dW.a(menuItem, this.eg, 0);
            if (menuItem != null && menuItem.isCheckable() && a) {
                this.eg.dY.d(menuItem);
            }
            this.eg.g(false);
            this.eg.f(false);
        }
    };

    private interface d {
    }

    private class b extends android.support.v7.widget.RecyclerView.a<j> {
        final /* synthetic */ b eg;
        final ArrayList<d> eh = new ArrayList();
        private android.support.v7.view.menu.h ei;
        private ColorDrawable ej;
        boolean ek;

        public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    return new g(this.eg.dZ, viewGroup, this.eg.mOnClickListener);
                case 1:
                    return new i(this.eg.dZ, viewGroup);
                case 2:
                    return new h(this.eg.dZ, viewGroup);
                case 3:
                    return new a(this.eg.dU);
                default:
                    return null;
            }
        }

        public final /* synthetic */ void a(t tVar) {
            j jVar = (j) tVar;
            if (jVar instanceof g) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.abf;
                if (navigationMenuItemView.dQ != null) {
                    navigationMenuItemView.dQ.removeAllViews();
                }
                navigationMenuItemView.dP.setCompoundDrawables(null, null, null, null);
            }
        }

        public final /* synthetic */ void a(t tVar, int i) {
            j jVar = (j) tVar;
            switch (getItemViewType(i)) {
                case 0:
                    NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.abf;
                    navigationMenuItemView.dS = this.eg.dS;
                    if (navigationMenuItemView.dR != null) {
                        navigationMenuItemView.setIcon(navigationMenuItemView.dR.getIcon());
                    }
                    if (this.eg.eb) {
                        navigationMenuItemView.dP.setTextAppearance(navigationMenuItemView.getContext(), this.eg.ea);
                    }
                    if (this.eg.ec != null) {
                        navigationMenuItemView.dP.setTextColor(this.eg.ec);
                    }
                    navigationMenuItemView.setBackgroundDrawable(this.eg.ed != null ? this.eg.ed.getConstantState().newDrawable() : null);
                    navigationMenuItemView.a(((f) this.eh.get(i)).en);
                    return;
                case 1:
                    ((TextView) jVar.abf).setText(((f) this.eh.get(i)).en.getTitle());
                    return;
                case 2:
                    e eVar = (e) this.eh.get(i);
                    jVar.abf.setPadding(0, eVar.el, 0, eVar.em);
                    return;
                default:
                    return;
            }
        }

        public b(b bVar) {
            this.eg = bVar;
            C();
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemCount() {
            return this.eh.size();
        }

        public final int getItemViewType(int i) {
            d dVar = (d) this.eh.get(i);
            if (dVar instanceof e) {
                return 2;
            }
            if (dVar instanceof c) {
                return 3;
            }
            if (!(dVar instanceof f)) {
                throw new RuntimeException("Unknown item type.");
            } else if (((f) dVar).en.hasSubMenu()) {
                return 1;
            } else {
                return 0;
            }
        }

        final void C() {
            if (!this.ek) {
                this.ek = true;
                this.eh.clear();
                this.eh.add(new c());
                int i = -1;
                int i2 = 0;
                Object obj = null;
                int size = this.eg.dW.dz().size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj2;
                    int i4;
                    int i5;
                    android.support.v7.view.menu.h hVar = (android.support.v7.view.menu.h) this.eg.dW.dz().get(i3);
                    if (hVar.isChecked()) {
                        d(hVar);
                    }
                    if (hVar.isCheckable()) {
                        hVar.E(false);
                    }
                    int i6;
                    if (hVar.hasSubMenu()) {
                        SubMenu subMenu = hVar.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i3 != 0) {
                                this.eh.add(new e(this.eg.ef, 0));
                            }
                            this.eh.add(new f(hVar));
                            Object obj3 = null;
                            int size2 = this.eh.size();
                            int size3 = subMenu.size();
                            for (i6 = 0; i6 < size3; i6++) {
                                android.support.v7.view.menu.h hVar2 = (android.support.v7.view.menu.h) subMenu.getItem(i6);
                                if (hVar2.isVisible()) {
                                    if (obj3 == null && hVar2.getIcon() != null) {
                                        obj3 = 1;
                                    }
                                    if (hVar2.isCheckable()) {
                                        hVar2.E(false);
                                    }
                                    if (hVar.isChecked()) {
                                        d(hVar);
                                    }
                                    this.eh.add(new f(hVar2));
                                }
                            }
                            if (obj3 != null) {
                                b(size2, this.eh.size());
                            }
                        }
                        obj2 = obj;
                        i4 = i2;
                        i5 = i;
                    } else {
                        Object obj4;
                        i6 = hVar.getGroupId();
                        if (i6 != i) {
                            i2 = this.eh.size();
                            obj = hVar.getIcon() != null ? 1 : null;
                            if (i3 != 0) {
                                i2++;
                                this.eh.add(new e(this.eg.ef, this.eg.ef));
                                obj4 = obj;
                                i5 = i2;
                            }
                            obj4 = obj;
                            i5 = i2;
                        } else {
                            if (obj == null && hVar.getIcon() != null) {
                                obj = 1;
                                b(i2, this.eh.size());
                            }
                            obj4 = obj;
                            i5 = i2;
                        }
                        if (obj4 != null && hVar.getIcon() == null) {
                            hVar.setIcon(17170445);
                        }
                        this.eh.add(new f(hVar));
                        obj2 = obj4;
                        i4 = i5;
                        i5 = i6;
                    }
                    i3++;
                    i2 = i4;
                    i = i5;
                    obj = obj2;
                }
                this.ek = false;
            }
        }

        private void b(int i, int i2) {
            while (i < i2) {
                MenuItem menuItem = ((f) this.eh.get(i)).en;
                if (menuItem.getIcon() == null) {
                    if (this.ej == null) {
                        this.ej = new ColorDrawable(0);
                    }
                    menuItem.setIcon(this.ej);
                }
                i++;
            }
        }

        public final void d(android.support.v7.view.menu.h hVar) {
            if (this.ei != hVar && hVar.isCheckable()) {
                if (this.ei != null) {
                    this.ei.setChecked(false);
                }
                this.ei = hVar;
                hVar.setChecked(true);
            }
        }

        public final Bundle D() {
            Bundle bundle = new Bundle();
            if (this.ei != null) {
                bundle.putInt("android:menu:checked", this.ei.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            Iterator it = this.eh.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar instanceof f) {
                    android.support.v7.view.menu.h hVar = ((f) dVar).en;
                    View actionView = hVar != null ? hVar.getActionView() : null;
                    if (actionView != null) {
                        SparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(hVar.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }
    }

    private static class c implements d {
    }

    private static class e implements d {
        final int el;
        final int em;

        public e(int i, int i2) {
            this.el = i;
            this.em = i2;
        }
    }

    private static class f implements d {
        final android.support.v7.view.menu.h en;

        public f(android.support.v7.view.menu.h hVar) {
            this.en = hVar;
        }
    }

    private static abstract class j extends t {
        public j(View view) {
            super(view);
        }
    }

    private static class a extends j {
        public a(View view) {
            super(view);
        }
    }

    private static class g extends j {
        public g(LayoutInflater layoutInflater, ViewGroup viewGroup, OnClickListener onClickListener) {
            super(layoutInflater.inflate(android.support.design.a.f.aB, viewGroup, false));
            this.abf.setOnClickListener(onClickListener);
        }
    }

    private static class h extends j {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(android.support.design.a.f.aD, viewGroup, false));
        }
    }

    private static class i extends j {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(android.support.design.a.f.aE, viewGroup, false));
        }
    }

    public final void a(Context context, android.support.v7.view.menu.f fVar) {
        this.dZ = LayoutInflater.from(context);
        this.dW = fVar;
        this.ef = context.getResources().getDimensionPixelOffset(android.support.design.a.d.al);
    }

    public final void f(boolean z) {
        if (this.dY != null) {
            android.support.v7.widget.RecyclerView.a aVar = this.dY;
            aVar.C();
            aVar.aab.notifyChanged();
        }
    }

    public final boolean a(p pVar) {
        return false;
    }

    public final void a(android.support.v7.view.menu.f fVar, boolean z) {
        if (this.dV != null) {
            this.dV.a(fVar, z);
        }
    }

    public final boolean B() {
        return false;
    }

    public final boolean b(android.support.v7.view.menu.h hVar) {
        return false;
    }

    public final boolean c(android.support.v7.view.menu.h hVar) {
        return false;
    }

    public final int getId() {
        return this.dX;
    }

    public final Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        if (this.dT != null) {
            SparseArray sparseArray = new SparseArray();
            this.dT.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.dY != null) {
            bundle.putBundle("android:menu:adapter", this.dY.D());
        }
        return bundle;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.dT.restoreHierarchyState(sparseParcelableArray);
        }
        Bundle bundle2 = bundle.getBundle("android:menu:adapter");
        if (bundle2 != null) {
            d dVar;
            b bVar = this.dY;
            int i = bundle2.getInt("android:menu:checked", 0);
            if (i != 0) {
                bVar.ek = true;
                Iterator it = bVar.eh.iterator();
                while (it.hasNext()) {
                    dVar = (d) it.next();
                    if (dVar instanceof f) {
                        android.support.v7.view.menu.h hVar = ((f) dVar).en;
                        if (hVar != null && hVar.getItemId() == i) {
                            bVar.d(hVar);
                            break;
                        }
                    }
                }
                bVar.ek = false;
                bVar.C();
            }
            SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
            Iterator it2 = bVar.eh.iterator();
            while (it2.hasNext()) {
                dVar = (d) it2.next();
                if (dVar instanceof f) {
                    android.support.v7.view.menu.h hVar2 = ((f) dVar).en;
                    View actionView = hVar2 != null ? hVar2.getActionView() : null;
                    if (actionView != null) {
                        actionView.restoreHierarchyState((SparseArray) sparseParcelableArray2.get(hVar2.getItemId()));
                    }
                }
            }
        }
    }

    public final void a(ColorStateList colorStateList) {
        this.dS = colorStateList;
        f(false);
    }

    public final void b(ColorStateList colorStateList) {
        this.ec = colorStateList;
        f(false);
    }

    public final void e(int i) {
        this.ea = i;
        this.eb = true;
        f(false);
    }

    public final void a(Drawable drawable) {
        this.ed = drawable;
        f(false);
    }

    public final void g(boolean z) {
        if (this.dY != null) {
            this.dY.ek = z;
        }
    }
}
