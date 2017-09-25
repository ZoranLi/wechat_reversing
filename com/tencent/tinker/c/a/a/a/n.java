package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class n extends i<s> {
    private a xeo = null;
    private a xep = null;
    private e xeq = null;
    private e xer = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cgf();
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        int a = this.xeq.a((s) comparable);
        this.xer.writeInt(a);
        a aVar = this.xeo;
        aVar.size++;
        aVar = this.xep;
        aVar.size++;
        return a;
    }

    public n(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.xeo = iVar2.xcf.xcO;
            this.xep = iVar2.xcf.xcC;
            this.xeq = iVar2.a(this.xeo);
            this.xer = iVar2.a(this.xep);
        }
    }

    protected final a a(i iVar) {
        return iVar.xcf.xcO;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.xeY.put(i, i3);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.xfm.DE(i);
        }
    }
}
