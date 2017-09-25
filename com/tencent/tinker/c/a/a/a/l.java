package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class l extends i<r> {
    private a xek = null;
    private e xel = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cgj();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        r rVar = (r) comparable;
        return new r(rVar.dyd, aVar.DH(rVar.xcy), aVar.DI(rVar.xcz), aVar.DM(rVar.xcA));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        r rVar = (r) comparable;
        a aVar = this.xek;
        aVar.size++;
        return this.xel.a(rVar);
    }

    public l(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.xek = iVar2.xcf.xcE;
            this.xel = iVar2.a(this.xek);
        }
    }

    protected final a a(i iVar) {
        return iVar.xcf.xcE;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.xfa.put(i, i3);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.xfo.DE(i);
        }
    }
}
