package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class f extends i<com.tencent.tinker.a.a.f> {
    private a xea = null;
    private e xeb = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cgk();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.f fVar = (com.tencent.tinker.a.a.f) comparable;
        return new com.tencent.tinker.a.a.f(fVar.dyd, aVar.DI(fVar.xbH), fVar.xbE, aVar.DI(fVar.xbI), aVar.DM(fVar.xbJ), aVar.DH(fVar.xbK), aVar.DQ(fVar.xbL), aVar.DS(fVar.xbM), aVar.DR(fVar.xbN));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.f fVar = (com.tencent.tinker.a.a.f) comparable;
        a aVar = this.xea;
        aVar.size++;
        return this.xeb.a(fVar);
    }

    public f(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.xea = iVar2.xcf.xcH;
            this.xeb = iVar2.a(this.xea);
        }
    }

    protected final a a(i iVar) {
        return iVar.xcf.xcH;
    }
}
