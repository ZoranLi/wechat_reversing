package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.LinkedList;
import java.util.List;

public final class e {
    private final SparseArray<b<a>> rYb = new SparseArray();

    private static final class a {
        public final String appId;
        public final String gaj;
        public final String gak;
        public final int gal;
        public final int key;
        public final int rYc;
        public final int rYd;
        public final String rYe;
    }

    private static final class b<T> {
        public final byte[] hAl = new byte[0];
        final SparseArray<T> rYf = new SparseArray();

        public final T valueAt(int i) {
            return this.rYf.valueAt(i);
        }

        public final void remove(int i) {
            this.rYf.remove(i);
        }
    }

    public static final class c {
        public final int rYc;
        public final int rYd;

        public c(int i, int i2) {
            this.rYd = i;
            this.rYc = i2;
        }
    }

    public final boolean vU(int i) {
        synchronized (this.rYb) {
            b bVar = (b) this.rYb.get(i);
            this.rYb.remove(i);
        }
        if (bVar != null) {
            synchronized (bVar.hAl) {
                bVar.rYf.clear();
            }
        }
        return true;
    }

    public final boolean a(int i, String str, String str2, String str3, int i2) {
        if (bg.mA(str) || bg.mA(str2) || bg.mA(str3) || (i2 != 2 && i2 != 1 && i2 != 3)) {
            return false;
        }
        synchronized (this.rYb) {
            b bVar = (b) this.rYb.get(i);
        }
        if (bVar == null) {
            return true;
        }
        synchronized (bVar.hAl) {
            if (bVar.rYf.size() == 0) {
                return true;
            }
            List<Integer> linkedList = new LinkedList();
            for (int i3 = 0; i3 < bVar.rYf.size(); i3++) {
                a aVar = (a) bVar.valueAt(i3);
                if (bg.mz(aVar.appId).equals(str) && bg.mz(aVar.gaj).equals(str2) && bg.mz(aVar.gak).equals(str3) && aVar.gal == i2) {
                    linkedList.add(Integer.valueOf(aVar.key));
                }
            }
            for (Integer intValue : linkedList) {
                bVar.remove(intValue.intValue());
            }
            return true;
        }
    }

    public final boolean a(int i, String str, String str2, String str3, int i2, String str4) {
        if (bg.mA(str) || bg.mA(str2) || bg.mA(str3) || bg.mA(str4) || (i2 != 2 && i2 != 1 && i2 != 3)) {
            return false;
        }
        synchronized (this.rYb) {
            b bVar = (b) this.rYb.get(i);
        }
        if (bVar == null) {
            return true;
        }
        synchronized (bVar.hAl) {
            if (bVar.rYf.size() == 0) {
                return true;
            }
            List<Integer> linkedList = new LinkedList();
            for (int i3 = 0; i3 < bVar.rYf.size(); i3++) {
                a aVar = (a) bVar.valueAt(i3);
                if (bg.mz(aVar.appId).equals(str) && bg.mz(aVar.gaj).equals(str2) && bg.mz(aVar.gak).equals(str3) && bg.mz(aVar.rYe).equals(str4) && aVar.gal == i2) {
                    linkedList.add(Integer.valueOf(aVar.key));
                }
            }
            for (Integer intValue : linkedList) {
                bVar.remove(intValue.intValue());
            }
            return true;
        }
    }

    public final List<c> l(String str, String str2, String str3, String str4) {
        if (bg.mA(str) || bg.mA(str2) || bg.mA(str3) || bg.mA(str4)) {
            return null;
        }
        String Je = p.Je(str);
        if (bg.mA(Je)) {
            return null;
        }
        List<c> linkedList = new LinkedList();
        synchronized (this.rYb) {
            for (int i = 0; i < this.rYb.size(); i++) {
                b bVar = (b) this.rYb.valueAt(i);
                if (bVar != null) {
                    synchronized (bVar.hAl) {
                        for (int i2 = 0; i2 < bVar.rYf.size(); i2++) {
                            a aVar = (a) bVar.valueAt(i2);
                            if (bg.mz(aVar.rYe).equals(Je) && bg.mz(aVar.appId).equals(str2) && bg.mz(aVar.gaj).equals(str3) && bg.mz(aVar.gak).equals(str4)) {
                                linkedList.add(new c(aVar.rYd, aVar.rYc));
                            }
                        }
                    }
                }
            }
        }
        return linkedList;
    }
}
