package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class o extends i<Integer> {
    private a xes = null;
    private e xet = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return Integer.valueOf(aVar.xcn.getInt());
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        return Integer.valueOf(aVar.DH(((Integer) comparable).intValue()));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        Integer num = (Integer) comparable;
        int position = this.xet.xcn.position();
        this.xet.writeInt(num.intValue());
        a aVar = this.xes;
        aVar.size++;
        return position;
    }

    public o(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.xes = iVar2.xcf.xcD;
            this.xet = iVar2.a(this.xes);
        }
    }

    protected final a a(i iVar) {
        return iVar.xcf.xcD;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.xeZ.put(i, i3);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.xfn.DE(i);
        }
    }
}
