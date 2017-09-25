package com.tencent.mm.ui.base;

import android.util.SparseArray;
import android.view.View;

public final class u {
    View[] vpA = new View[0];
    int[] vpB = new int[0];
    SparseArray<View>[] vpC;
    int vpD;
    SparseArray<View> vpE;

    static View a(SparseArray<View> sparseArray, int i) {
        int size = sparseArray.size();
        if (size <= 0) {
            return null;
        }
        int i2;
        View view;
        for (i2 = 0; i2 < size; i2++) {
            int keyAt = sparseArray.keyAt(i2);
            view = (View) sparseArray.get(keyAt);
            if (keyAt == i) {
                sparseArray.remove(keyAt);
                return view;
            }
        }
        i2 = size - 1;
        view = (View) sparseArray.valueAt(i2);
        sparseArray.remove(sparseArray.keyAt(i2));
        return view;
    }
}
