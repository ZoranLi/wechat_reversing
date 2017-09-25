package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.b;
import com.tencent.tinker.c.a.c.c;

public final class g extends i<com.tencent.tinker.a.a.g> {
    private a xec = null;
    private e xed = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cgl();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.g.a[] aVarArr;
        com.tencent.tinker.a.a.g gVar = (com.tencent.tinker.a.a.g) comparable;
        int DT = aVar.DT(gVar.xbR);
        short[] sArr = gVar.xbS;
        if (!(sArr == null || sArr.length == 0)) {
            sArr = new b(aVar).a(sArr);
        }
        com.tencent.tinker.a.a.g.a[] aVarArr2 = gVar.xbU;
        if (aVarArr2 == null || aVarArr2.length == 0) {
            aVarArr = aVarArr2;
        } else {
            aVarArr = new com.tencent.tinker.a.a.g.a[aVarArr2.length];
            for (int i = 0; i < aVarArr2.length; i++) {
                com.tencent.tinker.a.a.g.a aVar2 = aVarArr2[i];
                int length = aVar2.xbV.length;
                int[] iArr = new int[length];
                for (int i2 = 0; i2 < length; i2++) {
                    iArr[i2] = aVar.DI(aVar2.xbV[i2]);
                }
                aVarArr[i] = new com.tencent.tinker.a.a.g.a(iArr, aVar2.xbW, aVar2.xbX, aVar2.offset);
            }
        }
        return new com.tencent.tinker.a.a.g(gVar.dyd, gVar.xbO, gVar.xbP, gVar.xbQ, DT, sArr, gVar.xbT, aVarArr);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.g gVar = (com.tencent.tinker.a.a.g) comparable;
        a aVar = this.xec;
        aVar.size++;
        return this.xed.a(gVar);
    }

    public g(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.xec = iVar2.xcf.xcN;
            this.xed = iVar2.a(this.xec);
        }
    }

    protected final a a(i iVar) {
        return iVar.xcf.xcN;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.xfl.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.xfz.DE(i2);
        }
    }
}
