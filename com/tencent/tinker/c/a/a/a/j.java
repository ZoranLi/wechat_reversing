package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class j extends i<n> {
    private a xeg = null;
    private e xeh = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cgh();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        n nVar = (n) comparable;
        return new n(nVar.dyd, aVar.DI(nVar.xcv), aVar.DI(nVar.xbH), aVar.DH(nVar.xcw));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        n nVar = (n) comparable;
        a aVar = this.xeg;
        aVar.size++;
        return this.xeh.a(nVar);
    }

    public j(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.xeg = iVar2.xcf.xcF;
            this.xeh = iVar2.a(this.xeg);
        }
    }

    protected final a a(i iVar) {
        return iVar.xcf.xcF;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.xfb.put(i, i3);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.xfp.DE(i);
        }
    }
}
