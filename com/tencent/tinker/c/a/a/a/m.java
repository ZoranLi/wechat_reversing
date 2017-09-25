package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.a.AnonymousClass3;
import com.tencent.tinker.c.a.c.c;
import java.io.ByteArrayOutputStream;

public final class m extends i<k> {
    private a xem = null;
    private e xen = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cgs();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        k kVar = (k) comparable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(kVar.data.length);
        new a(aVar, new AnonymousClass3(aVar, byteArrayOutputStream)).c(new com.tencent.tinker.a.a.m(kVar, 28));
        return new k(kVar.dyd, byteArrayOutputStream.toByteArray());
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        k kVar = (k) comparable;
        a aVar = this.xem;
        aVar.size++;
        return this.xen.a(kVar);
    }

    public m(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.xem = iVar2.xcf.xcR;
            this.xen = iVar2.a(this.xem);
        }
    }

    protected final a a(i iVar) {
        return iVar.xcf.xcR;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.xfi.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.xfw.DE(i2);
        }
    }
}
