package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class k extends i<p> {
    private a xei = null;
    private e xej = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cgi();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        p pVar = (p) comparable;
        return new p(pVar.dyd, aVar.DI(pVar.xcv), aVar.DJ(pVar.xcx), aVar.DH(pVar.xcw));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        p pVar = (p) comparable;
        a aVar = this.xei;
        aVar.size++;
        return this.xej.a(pVar);
    }

    public k(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.xei = iVar2.xcf.xcG;
            this.xej = iVar2.a(this.xei);
        }
    }

    protected final a a(i iVar) {
        return iVar.xcf.xcG;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.xfc.put(i, i3);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.xfq.DE(i);
        }
    }
}
