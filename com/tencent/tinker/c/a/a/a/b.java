package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.c;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;

public final class b extends i<c> {
    private a xdS = null;
    private e xdT = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cgq();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        c cVar = (c) comparable;
        int length = cVar.xbu.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = aVar.DO(cVar.xbu[i]);
        }
        return new c(cVar.dyd, iArr);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        c cVar = (c) comparable;
        a aVar = this.xdS;
        aVar.size++;
        return this.xdT.a(cVar);
    }

    public b(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.c.a.c.c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.xdS = iVar2.xcf.xcK;
            this.xdT = iVar2.a(this.xdS);
        }
    }

    protected final a a(i iVar) {
        return iVar.xcf.xcK;
    }

    protected final void a(com.tencent.tinker.c.a.c.c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.xfg.put(i2, i4);
        }
    }

    protected final void a(com.tencent.tinker.c.a.c.c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.xfu.DE(i2);
        }
    }
}
