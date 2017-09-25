package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.a.a.u;
import com.tencent.tinker.c.a.c.c;

public final class p extends i<u> {
    private a xeu = null;
    private e xev = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cgg();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        u uVar = (u) comparable;
        if (uVar == u.xdc) {
            return uVar;
        }
        short[] sArr = new short[uVar.xdd.length];
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = (short) aVar.DI(uVar.xdd[i]);
        }
        return new u(uVar.dyd, sArr);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        u uVar = (u) comparable;
        a aVar = this.xeu;
        aVar.size++;
        return this.xev.a(uVar);
    }

    public p(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.xeu = iVar2.xcf.xcJ;
            this.xev = iVar2.a(this.xeu);
        }
    }

    protected final a a(i iVar) {
        return iVar.xcf.xcJ;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.xfd.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.xfr.DE(i2);
        }
    }
}
