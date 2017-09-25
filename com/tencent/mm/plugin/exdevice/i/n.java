package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.o.a;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;

public final class n extends a {
    private c lht = null;

    public n(c cVar) {
        Assert.assertNotNull(cVar);
        this.lht = cVar;
    }

    public final long apM() {
        w.i("MicroMsg.exdevice.RemoteExDeviceTaskRequest", "getDeviceId : " + this.lht.jUL);
        return this.lht.jUL;
    }

    public final byte[] apN() {
        return this.lht.aoR();
    }

    public final int apO() {
        return this.lht.aoP();
    }

    public final int apP() {
        return this.lht.lax;
    }

    public final int apQ() {
        return this.lht.aoQ();
    }
}
