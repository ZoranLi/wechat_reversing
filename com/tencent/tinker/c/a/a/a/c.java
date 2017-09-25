package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.b;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;

public final class c extends i<b> {
    private a xdU = null;
    private e xdV = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cgp();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        b bVar = (b) comparable;
        int length = bVar.xbt.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = aVar.DN(bVar.xbt[i]);
        }
        return new b(bVar.dyd, iArr);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        b bVar = (b) comparable;
        a aVar = this.xdU;
        aVar.size++;
        return this.xdV.a(bVar);
    }

    public c(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.c.a.c.c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.xdU = iVar2.xcf.xcL;
            this.xdV = iVar2.a(this.xdU);
        }
    }

    protected final a a(i iVar) {
        return iVar.xcf.xcL;
    }

    protected final void a(com.tencent.tinker.c.a.c.c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.xff.put(i2, i4);
        }
    }

    protected final void a(com.tencent.tinker.c.a.c.c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.xft.DE(i2);
        }
    }
}
