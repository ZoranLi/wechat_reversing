package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class e extends com.tencent.tinker.a.a.t.a.a<e> {
    public a[] xbA;
    public b[] xbB;
    public b[] xbC;
    public a[] xbz;

    public static class a implements Comparable<a> {
        public int xbD;
        public int xbE;

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            int eD = c.eD(this.xbD, aVar.xbD);
            return eD != 0 ? eD : c.eE(this.xbE, aVar.xbE);
        }

        public a(int i, int i2) {
            this.xbD = i;
            this.xbE = i2;
        }
    }

    public static class b implements Comparable<b> {
        public int xbE;
        public int xbF;
        public int xbG;

        public final /* synthetic */ int compareTo(Object obj) {
            b bVar = (b) obj;
            int eD = c.eD(this.xbF, bVar.xbF);
            if (eD != 0) {
                return eD;
            }
            eD = c.eE(this.xbE, bVar.xbE);
            return eD == 0 ? c.eE(this.xbG, bVar.xbG) : eD;
        }

        public b(int i, int i2, int i3) {
            this.xbF = i;
            this.xbE = i2;
            this.xbG = i3;
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        e eVar = (e) obj;
        int a = c.a(this.xbz, eVar.xbz);
        if (a != 0) {
            return a;
        }
        a = c.a(this.xbA, eVar.xbA);
        if (a != 0) {
            return a;
        }
        a = c.a(this.xbB, eVar.xbB);
        return a == 0 ? c.a(this.xbC, eVar.xbC) : a;
    }

    public e(int i, a[] aVarArr, a[] aVarArr2, b[] bVarArr, b[] bVarArr2) {
        super(i);
        this.xbz = aVarArr;
        this.xbA = aVarArr2;
        this.xbB = bVarArr;
        this.xbC = bVarArr2;
    }
}
