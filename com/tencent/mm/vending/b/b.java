package com.tencent.mm.vending.b;

import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class b<_Callback> implements a {
    public d fwy;
    private int mPriority = -1;
    private int wCA;
    private a wCy;
    public _Callback wCz;

    public final b<_Callback> a(com.tencent.mm.vending.e.b bVar) {
        Assert.assertNotNull(bVar);
        bVar.a(this);
        return this;
    }

    public b(_Callback _Callback, a aVar) {
        Assert.assertNotNull("Callback should not be null!", _Callback);
        this.wCA = _Callback.hashCode();
        this.wCz = _Callback;
        this.wCy = aVar;
    }

    public final int hashCode() {
        return this.wCA;
    }

    public final boolean equals(Object obj) {
        return obj != null && obj.hashCode() == this.wCA;
    }

    public final void dead() {
        Assert.assertNotNull(this.wCy);
        this.wCy.b(this);
    }
}
