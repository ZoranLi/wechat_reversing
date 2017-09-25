package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.d;
import android.support.v4.view.m;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class f implements android.support.v4.c.a.a {
    private static final int[] Qo = new int[]{1, 4, 5, 3, 2, 0};
    private final Resources Cu;
    Drawable QA;
    View QB;
    private boolean QC = false;
    private boolean QD = false;
    boolean QE = false;
    private boolean QF = false;
    private ArrayList<h> QG = new ArrayList();
    public CopyOnWriteArrayList<WeakReference<l>> QH = new CopyOnWriteArrayList();
    h QI;
    public boolean QJ;
    private boolean Qp;
    private boolean Qq;
    public a Qr;
    private ArrayList<h> Qs;
    private boolean Qt;
    public ArrayList<h> Qu;
    private ArrayList<h> Qv;
    private boolean Qw;
    public int Qx = 1;
    private ContextMenuInfo Qy;
    CharSequence Qz;
    ArrayList<h> eh;
    public final Context mContext;

    public interface a {
        boolean a(f fVar, MenuItem menuItem);

        void b(f fVar);
    }

    public interface b {
        boolean f(h hVar);
    }

    public f(Context context) {
        boolean z = true;
        this.mContext = context;
        this.Cu = context.getResources();
        this.eh = new ArrayList();
        this.Qs = new ArrayList();
        this.Qt = true;
        this.Qu = new ArrayList();
        this.Qv = new ArrayList();
        this.Qw = true;
        if (this.Cu.getConfiguration().keyboard == 1 || !this.Cu.getBoolean(android.support.v7.a.a.b.IO)) {
            z = false;
        }
        this.Qq = z;
    }

    public final void a(l lVar) {
        a(lVar, this.mContext);
    }

    public final void a(l lVar, Context context) {
        this.QH.add(new WeakReference(lVar));
        lVar.a(context, this);
        this.Qw = true;
    }

    public final void b(l lVar) {
        Iterator it = this.QH.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar2 = (l) weakReference.get();
            if (lVar2 == null || lVar2 == lVar) {
                this.QH.remove(weakReference);
            }
        }
    }

    public final void dispatchSaveInstanceState(Bundle bundle) {
        if (!this.QH.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator it = this.QH.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.QH.remove(weakReference);
                } else {
                    int id = lVar.getId();
                    if (id > 0) {
                        Parcelable onSaveInstanceState = lVar.onSaveInstanceState();
                        if (onSaveInstanceState != null) {
                            sparseArray.put(id, onSaveInstanceState);
                        }
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    public final void e(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View a = m.a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (m.d(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((p) item.getSubMenu()).e(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(ds(), sparseArray);
        }
    }

    public final void f(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(ds());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View a = m.a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((p) item.getSubMenu()).f(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    m.b(item);
                }
            }
        }
    }

    protected String ds() {
        return "android:menu:actionviewstates";
    }

    public void a(a aVar) {
        this.Qr = aVar;
    }

    public final MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int i4 = (-65536 & i3) >> 16;
        if (i4 < 0 || i4 >= Qo.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i5 = (Qo[i4] << 16) | (65535 & i3);
        MenuItem hVar = new h(this, i, i2, i3, i5, charSequence, this.Qx);
        if (this.Qy != null) {
            hVar.QU = this.Qy;
        }
        this.eh.add(b(this.eh, i5), hVar);
        h(true);
        return hVar;
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return a(0, 0, 0, this.Cu.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.Cu.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.Cu.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        h hVar = (h) a(i, i2, i3, charSequence);
        SubMenu pVar = new p(this.mContext, this, hVar);
        hVar.b(pVar);
        return pVar;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.Cu.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.mContext.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        int i2;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((h) this.eh.get(i3)).getItemId() == i) {
                i2 = i3;
                break;
            }
        }
        i2 = -1;
        m(i2, true);
    }

    public void removeGroup(int i) {
        int i2;
        int size = size();
        for (i2 = 0; i2 < size; i2++) {
            if (((h) this.eh.get(i2)).getGroupId() == i) {
                size = i2;
                break;
            }
        }
        size = -1;
        if (size >= 0) {
            int size2 = this.eh.size() - size;
            int i3 = 0;
            while (true) {
                i2 = i3 + 1;
                if (i3 >= size2 || ((h) this.eh.get(size)).getGroupId() != i) {
                    h(true);
                } else {
                    m(size, false);
                    i3 = i2;
                }
            }
            h(true);
        }
    }

    private void m(int i, boolean z) {
        if (i >= 0 && i < this.eh.size()) {
            this.eh.remove(i);
            if (z) {
                h(true);
            }
        }
    }

    public void clear() {
        if (this.QI != null) {
            h(this.QI);
        }
        this.eh.clear();
        h(true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.eh.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) this.eh.get(i2);
            if (hVar.getGroupId() == i) {
                hVar.E(z2);
                hVar.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.eh.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            h hVar = (h) this.eh.get(i2);
            if (hVar.getGroupId() == i && hVar.G(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            h(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.eh.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) this.eh.get(i2);
            if (hVar.getGroupId() == i) {
                hVar.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.QJ) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((h) this.eh.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) this.eh.get(i2);
            if (hVar.getItemId() == i) {
                return hVar;
            }
            if (hVar.hasSubMenu()) {
                MenuItem findItem = hVar.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int size() {
        return this.eh.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.eh.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.Qp = z;
        h(false);
    }

    boolean dt() {
        return this.Qp;
    }

    public boolean du() {
        return this.Qq;
    }

    boolean b(f fVar, MenuItem menuItem) {
        return this.Qr != null && this.Qr.a(fVar, menuItem);
    }

    private static int b(ArrayList<h> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((h) arrayList.get(size)).PA <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = a(a, null, i2);
        }
        if ((i2 & 2) != 0) {
            D(true);
        }
        return z;
    }

    private void a(List<h> list, int i, KeyEvent keyEvent) {
        boolean dt = dt();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.eh.size();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = (h) this.eh.get(i2);
                if (hVar.hasSubMenu()) {
                    ((f) hVar.getSubMenu()).a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = dt ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (dt && alphabeticShortcut == '\b' && i == 67)) && hVar.isEnabled())) {
                    list.add(hVar);
                }
            }
        }
    }

    private h a(int i, KeyEvent keyEvent) {
        List list = this.QG;
        list.clear();
        a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (h) list.get(0);
        }
        boolean dt = dt();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) list.get(i2);
            char alphabeticShortcut = dt ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return hVar;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return hVar;
            }
            if (dt && alphabeticShortcut == '\b' && i == 67) {
                return hVar;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), null, i2);
    }

    public final boolean a(MenuItem menuItem, l lVar, int i) {
        boolean z = false;
        h hVar = (h) menuItem;
        if (hVar == null || !hVar.isEnabled()) {
            return false;
        }
        boolean z2;
        boolean dD = hVar.dD();
        d dVar = hVar.QR;
        if (dVar == null || !dVar.hasSubMenu()) {
            z2 = false;
        } else {
            z2 = true;
        }
        boolean expandActionView;
        if (hVar.dK()) {
            expandActionView = hVar.expandActionView() | dD;
            if (!expandActionView) {
                return expandActionView;
            }
            D(true);
            return expandActionView;
        } else if (hVar.hasSubMenu() || z2) {
            D(false);
            if (!hVar.hasSubMenu()) {
                hVar.b(new p(this.mContext, this, hVar));
            }
            p pVar = (p) hVar.getSubMenu();
            if (z2) {
                dVar.onPrepareSubMenu(pVar);
            }
            if (!this.QH.isEmpty()) {
                if (lVar != null) {
                    z = lVar.a(pVar);
                }
                Iterator it = this.QH.iterator();
                boolean z3 = z;
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    l lVar2 = (l) weakReference.get();
                    if (lVar2 == null) {
                        this.QH.remove(weakReference);
                    } else {
                        if (z3) {
                            z = z3;
                        } else {
                            z = lVar2.a(pVar);
                        }
                        z3 = z;
                    }
                }
                z = z3;
            }
            expandActionView = dD | r2;
            if (expandActionView) {
                return expandActionView;
            }
            D(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                D(true);
            }
            return dD;
        }
    }

    public final void D(boolean z) {
        if (!this.QF) {
            this.QF = true;
            Iterator it = this.QH.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.QH.remove(weakReference);
                } else {
                    lVar.a(this, z);
                }
            }
            this.QF = false;
        }
    }

    public void close() {
        D(true);
    }

    public void h(boolean z) {
        if (this.QC) {
            this.QD = true;
            return;
        }
        if (z) {
            this.Qt = true;
            this.Qw = true;
        }
        if (!this.QH.isEmpty()) {
            dv();
            Iterator it = this.QH.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.QH.remove(weakReference);
                } else {
                    lVar.f(z);
                }
            }
            dw();
        }
    }

    public final void dv() {
        if (!this.QC) {
            this.QC = true;
            this.QD = false;
        }
    }

    public final void dw() {
        this.QC = false;
        if (this.QD) {
            this.QD = false;
            h(true);
        }
    }

    final void dx() {
        this.Qt = true;
        h(true);
    }

    final void dy() {
        this.Qw = true;
        h(true);
    }

    public final ArrayList<h> dz() {
        if (!this.Qt) {
            return this.Qs;
        }
        this.Qs.clear();
        int size = this.eh.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) this.eh.get(i);
            if (hVar.isVisible()) {
                this.Qs.add(hVar);
            }
        }
        this.Qt = false;
        this.Qw = true;
        return this.Qs;
    }

    public final void dA() {
        ArrayList dz = dz();
        if (this.Qw) {
            Iterator it = this.QH.iterator();
            int i = 0;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.QH.remove(weakReference);
                } else {
                    i = lVar.B() | i;
                }
            }
            if (i != 0) {
                this.Qu.clear();
                this.Qv.clear();
                i = dz.size();
                for (int i2 = 0; i2 < i; i2++) {
                    h hVar = (h) dz.get(i2);
                    if (hVar.dH()) {
                        this.Qu.add(hVar);
                    } else {
                        this.Qv.add(hVar);
                    }
                }
            } else {
                this.Qu.clear();
                this.Qv.clear();
                this.Qv.addAll(dz());
            }
            this.Qw = false;
        }
    }

    public final ArrayList<h> dB() {
        dA();
        return this.Qv;
    }

    public void clearHeader() {
        this.QA = null;
        this.Qz = null;
        this.QB = null;
        h(false);
    }

    final void a(CharSequence charSequence, Drawable drawable, View view) {
        if (view != null) {
            this.QB = view;
            this.Qz = null;
            this.QA = null;
        } else {
            if (charSequence != null) {
                this.Qz = charSequence;
            }
            if (drawable != null) {
                this.QA = drawable;
            }
            this.QB = null;
        }
        h(false);
    }

    protected final f g(CharSequence charSequence) {
        a(charSequence, null, null);
        return this;
    }

    protected final f k(Drawable drawable) {
        a(null, drawable, null);
        return this;
    }

    public f dC() {
        return this;
    }

    public boolean g(h hVar) {
        boolean z = false;
        if (!this.QH.isEmpty()) {
            dv();
            Iterator it = this.QH.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.QH.remove(weakReference);
                } else {
                    z = lVar.b(hVar);
                    if (z) {
                        break;
                    }
                    z2 = z;
                }
            }
            z = z2;
            dw();
            if (z) {
                this.QI = hVar;
            }
        }
        return z;
    }

    public boolean h(h hVar) {
        boolean z = false;
        if (!this.QH.isEmpty() && this.QI == hVar) {
            dv();
            Iterator it = this.QH.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.QH.remove(weakReference);
                } else {
                    z = lVar.c(hVar);
                    if (z) {
                        break;
                    }
                    z2 = z;
                }
            }
            z = z2;
            dw();
            if (z) {
                this.QI = null;
            }
        }
        return z;
    }
}
