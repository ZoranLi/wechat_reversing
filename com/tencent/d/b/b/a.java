package com.tencent.d.b.b;

import android.content.SharedPreferences;
import android.util.SparseArray;

public class a {
    private static a wZP = null;
    private boolean fEv = false;
    private boolean isInit = false;
    private SparseArray<String> wZQ = new SparseArray(10);
    public SharedPreferences wZR = null;

    public static a cfM() {
        if (wZP != null) {
            return wZP;
        }
        a aVar;
        synchronized (a.class) {
            if (wZP == null) {
                wZP = new a();
            }
            aVar = wZP;
        }
        return aVar;
    }

    public final boolean isInit() {
        boolean z;
        synchronized (a.class) {
            z = this.isInit;
        }
        return z;
    }

    public final void cfN() {
        synchronized (a.class) {
            this.isInit = true;
        }
    }

    public final boolean cfL() {
        boolean z;
        synchronized (a.class) {
            z = this.fEv;
        }
        return z;
    }

    public final void mg(boolean z) {
        synchronized (a.class) {
            this.fEv = z;
        }
    }

    public final SparseArray<String> cfO() {
        SparseArray<String> sparseArray;
        synchronized (a.class) {
            sparseArray = this.wZQ;
        }
        return sparseArray;
    }

    public final SharedPreferences cfP() {
        SharedPreferences sharedPreferences;
        synchronized (a.class) {
            sharedPreferences = this.wZR;
        }
        return sharedPreferences;
    }
}
