package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.c.a.c.a.AnonymousClass4;
import com.tencent.tinker.c.a.c.c;
import java.io.ByteArrayOutputStream;

public final class a extends i<com.tencent.tinker.a.a.a> {
    private com.tencent.tinker.a.a.t.a xdQ = null;
    private e xdR = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cgo();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.a aVar2 = (com.tencent.tinker.a.a.a) comparable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(aVar2.xbs.data.length);
        new a(aVar, new AnonymousClass4(aVar, byteArrayOutputStream)).b(new m(aVar2.xbs, 29));
        return new com.tencent.tinker.a.a.a(aVar2.dyd, aVar2.xbr, new k(aVar2.xbs.dyd, byteArrayOutputStream.toByteArray()));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.a aVar = (com.tencent.tinker.a.a.a) comparable;
        com.tencent.tinker.a.a.t.a aVar2 = this.xdQ;
        aVar2.size++;
        return this.xdR.a(aVar);
    }

    public a(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.xdQ = iVar2.xcf.xcQ;
            this.xdR = iVar2.a(this.xdQ);
        }
    }

    protected final com.tencent.tinker.a.a.t.a a(i iVar) {
        return iVar.xcf.xcQ;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.xfe.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.xfs.DE(i2);
        }
    }
}
