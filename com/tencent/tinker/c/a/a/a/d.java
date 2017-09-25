package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;
import java.lang.reflect.Array;

public final class d extends i<com.tencent.tinker.a.a.d> {
    private a xdW = null;
    private e xdX = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cgr();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        int i;
        com.tencent.tinker.a.a.d dVar = (com.tencent.tinker.a.a.d) comparable;
        int DO = aVar.DO(dVar.xbv);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.xbw.length, 2});
        for (i = 0; i < iArr.length; i++) {
            iArr[i][0] = aVar.DK(dVar.xbw[i][0]);
            iArr[i][1] = aVar.DO(dVar.xbw[i][1]);
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.xbx.length, 2});
        for (i = 0; i < iArr2.length; i++) {
            iArr2[i][0] = aVar.DL(dVar.xbx[i][0]);
            iArr2[i][1] = aVar.DO(dVar.xbx[i][1]);
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.xby.length, 2});
        for (i = 0; i < iArr3.length; i++) {
            iArr3[i][0] = aVar.DL(dVar.xby[i][0]);
            iArr3[i][1] = aVar.DP(dVar.xby[i][1]);
        }
        return new com.tencent.tinker.a.a.d(dVar.dyd, DO, iArr, iArr2, iArr3);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.d dVar = (com.tencent.tinker.a.a.d) comparable;
        a aVar = this.xdW;
        aVar.size++;
        return this.xdX.a(dVar);
    }

    public d(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.xdW = iVar2.xcf.xcS;
            this.xdX = iVar2.a(this.xdW);
        }
    }

    protected final a a(i iVar) {
        return iVar.xcf.xcS;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.xfh.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.xfv.DE(i2);
        }
    }
}
