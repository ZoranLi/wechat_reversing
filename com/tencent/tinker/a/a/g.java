package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class g extends com.tencent.tinker.a.a.t.a.a<g> {
    public int xbO;
    public int xbP;
    public int xbQ;
    public int xbR;
    public short[] xbS;
    public b[] xbT;
    public a[] xbU;

    public static class a implements Comparable<a> {
        public int offset;
        public int[] xbV;
        public int[] xbW;
        public int xbX;

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            int a = c.a(this.xbV, aVar.xbV);
            if (a != 0) {
                return a;
            }
            a = c.a(this.xbW, aVar.xbW);
            return a == 0 ? c.eE(this.xbX, aVar.xbX) : a;
        }

        public a(int[] iArr, int[] iArr2, int i, int i2) {
            this.xbV = iArr;
            this.xbW = iArr2;
            this.xbX = i;
            this.offset = i2;
        }
    }

    public static class b implements Comparable<b> {
        public int xbY;
        public int xbZ;
        public int xca;

        public final /* synthetic */ int compareTo(Object obj) {
            b bVar = (b) obj;
            int eE = c.eE(this.xbY, bVar.xbY);
            if (eE != 0) {
                return eE;
            }
            eE = c.eE(this.xbZ, bVar.xbZ);
            return eE == 0 ? c.eE(this.xca, bVar.xca) : eE;
        }

        public b(int i, int i2, int i3) {
            this.xbY = i;
            this.xbZ = i2;
            this.xca = i3;
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        g gVar = (g) obj;
        int eE = c.eE(this.xbO, gVar.xbO);
        if (eE != 0) {
            return eE;
        }
        eE = c.eE(this.xbP, gVar.xbP);
        if (eE != 0) {
            return eE;
        }
        eE = c.eE(this.xbQ, gVar.xbQ);
        if (eE != 0) {
            return eE;
        }
        eE = c.eE(this.xbR, gVar.xbR);
        if (eE != 0) {
            return eE;
        }
        eE = c.a(this.xbS, gVar.xbS);
        if (eE != 0) {
            return eE;
        }
        eE = c.a(this.xbT, gVar.xbT);
        return eE == 0 ? c.a(this.xbU, gVar.xbU) : eE;
    }

    public g(int i, int i2, int i3, int i4, int i5, short[] sArr, b[] bVarArr, a[] aVarArr) {
        super(i);
        this.xbO = i2;
        this.xbP = i3;
        this.xbQ = i4;
        this.xbR = i5;
        this.xbS = sArr;
        this.xbT = bVarArr;
        this.xbU = aVarArr;
    }
}
