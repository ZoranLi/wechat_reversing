package com.tencent.mm.ui.base;

import android.os.Build.VERSION;
import android.support.v4.view.u;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public abstract class v extends u {
    private final u vpF;

    public abstract View c(int i, View view);

    public v() {
        this(new u());
    }

    private v(u uVar) {
        this.vpF = uVar;
        SparseArray[] sparseArrayArr = new SparseArray[1];
        for (int i = 0; i <= 0; i++) {
            sparseArrayArr[0] = new SparseArray();
        }
        uVar.vpD = 1;
        uVar.vpE = sparseArrayArr[0];
        uVar.vpC = sparseArrayArr;
    }

    public void notifyDataSetChanged() {
        int length;
        u uVar = this.vpF;
        View[] viewArr = uVar.vpA;
        int[] iArr = uVar.vpB;
        Object obj = uVar.vpD > 1 ? 1 : null;
        SparseArray sparseArray = uVar.vpE;
        for (length = viewArr.length - 1; length >= 0; length--) {
            View view = viewArr[length];
            if (view != null) {
                int i = iArr[length];
                viewArr[length] = null;
                iArr[length] = -1;
                if ((i >= 0 ? 1 : null) != null) {
                    if (obj != null) {
                        sparseArray = uVar.vpC[i];
                    }
                    sparseArray.put(length, view);
                    if (VERSION.SDK_INT >= 14) {
                        view.setAccessibilityDelegate(null);
                    }
                }
            }
        }
        length = uVar.vpA.length;
        int i2 = uVar.vpD;
        SparseArray[] sparseArrayArr = uVar.vpC;
        for (int i3 = 0; i3 < i2; i3++) {
            SparseArray sparseArray2 = sparseArrayArr[i3];
            int size = sparseArray2.size();
            int i4 = size - length;
            size--;
            int i5 = 0;
            while (i5 < i4) {
                int i6 = size - 1;
                sparseArray2.remove(sparseArray2.keyAt(size));
                i5++;
                size = i6;
            }
        }
        super.notifyDataSetChanged();
    }

    public final Object b(ViewGroup viewGroup, int i) {
        u uVar = this.vpF;
        View a = uVar.vpD == 1 ? u.a(uVar.vpE, i) : uVar.vpC.length > 0 ? u.a(uVar.vpC[0], i) : null;
        a = c(i, a);
        viewGroup.addView(a);
        return a;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        u uVar = this.vpF;
        if (uVar.vpD == 1) {
            uVar.vpE.put(i, view);
        } else {
            uVar.vpC[0].put(i, view);
        }
        if (VERSION.SDK_INT >= 14) {
            view.setAccessibilityDelegate(null);
        }
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }
}
