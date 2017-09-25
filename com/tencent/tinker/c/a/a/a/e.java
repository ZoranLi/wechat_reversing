package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class e extends i<com.tencent.tinker.a.a.e> {
    private a xdY = null;
    private com.tencent.tinker.a.a.i.e xdZ = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cgn();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.e eVar = (com.tencent.tinker.a.a.e) comparable;
        return new com.tencent.tinker.a.a.e(eVar.dyd, aVar.b(eVar.xbz), aVar.b(eVar.xbA), aVar.b(eVar.xbB), aVar.b(eVar.xbC));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.e eVar = (com.tencent.tinker.a.a.e) comparable;
        a aVar = this.xdY;
        aVar.size++;
        return this.xdZ.a(eVar);
    }

    public e(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.xdY = iVar2.xcf.xcM;
            this.xdZ = iVar2.a(this.xdY);
        }
    }

    protected final a a(i iVar) {
        return iVar.xcf.xcM;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.xfj.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.xfx.DE(i2);
        }
    }
}
