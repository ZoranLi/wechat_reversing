package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.l;
import com.tencent.mm.plugin.exdevice.service.o;
import com.tencent.mm.plugin.exdevice.service.p.a;
import junit.framework.Assert;

public final class m extends a {
    private n lhP = null;
    l lhQ = null;

    public m(c cVar, c cVar2) {
        Assert.assertNotNull(cVar);
        Assert.assertNotNull(cVar2);
        this.lhP = new n(cVar);
        this.lhQ = new l(cVar2);
    }

    public final o apR() {
        Assert.assertNotNull(this.lhP);
        return this.lhP;
    }

    public final l apS() {
        Assert.assertNotNull(this.lhQ);
        return this.lhQ;
    }
}
