package com.tencent.mm.kernel.a;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.i;

public abstract class c implements d {
    public <T extends c> T after(a aVar) {
        i.vN().vF().vj().gZy.a((a) this, aVar);
        return this;
    }

    public <T extends c> T before(a aVar) {
        i.vN().vF().vj().gZy.a(aVar, (a) this);
        return this;
    }

    public void alias(Class<? extends a> cls) {
        i.vN().vF().vj().gZy.a((Class) cls, (d) this);
    }

    public String name() {
        return toString();
    }

    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(super.hashCode());
    }

    public int hashCode() {
        return name().hashCode();
    }
}
