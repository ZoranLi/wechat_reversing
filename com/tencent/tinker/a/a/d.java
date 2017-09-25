package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class d extends a<d> {
    public int xbv;
    public int[][] xbw;
    public int[][] xbx;
    public int[][] xby;

    public final /* synthetic */ int compareTo(Object obj) {
        d dVar = (d) obj;
        if (this.xbv != dVar.xbv) {
            return c.eD(this.xbv, dVar.xbv);
        }
        int length = this.xbw.length;
        int length2 = this.xbx.length;
        int length3 = this.xby.length;
        int length4 = dVar.xbw.length;
        int length5 = dVar.xbx.length;
        int length6 = dVar.xby.length;
        if (length != length4) {
            return c.eE(length, length4);
        }
        if (length2 != length5) {
            return c.eE(length2, length5);
        }
        if (length3 != length6) {
            return c.eE(length3, length6);
        }
        for (length4 = 0; length4 < length; length4++) {
            length5 = this.xbw[length4][0];
            length6 = this.xbw[length4][1];
            int i = dVar.xbw[length4][0];
            int i2 = dVar.xbw[length4][1];
            if (length5 != i) {
                return c.eD(length5, i);
            }
            if (length6 != i2) {
                return c.eE(length6, i2);
            }
        }
        for (length4 = 0; length4 < length2; length4++) {
            length = this.xbx[length4][0];
            length5 = this.xbx[length4][1];
            length6 = dVar.xbx[length4][0];
            i = dVar.xbx[length4][1];
            if (length != length6) {
                return c.eD(length, length6);
            }
            if (length5 != i) {
                return c.eE(length5, i);
            }
        }
        for (length4 = 0; length4 < length3; length4++) {
            length = this.xby[length4][0];
            length2 = this.xby[length4][1];
            length5 = dVar.xby[length4][0];
            length6 = dVar.xby[length4][1];
            if (length != length5) {
                return c.eD(length, length5);
            }
            if (length2 != length6) {
                return c.eE(length2, length6);
            }
        }
        return 0;
    }

    public d(int i, int i2, int[][] iArr, int[][] iArr2, int[][] iArr3) {
        super(i);
        this.xbv = i2;
        this.xbw = iArr;
        this.xbx = iArr2;
        this.xby = iArr3;
    }
}
