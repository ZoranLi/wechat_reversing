package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.g;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.w;

public final class i extends ae {
    private a lhC;
    private g lhE;

    public i(int i) {
        this.lhE = new g(i);
    }

    public final boolean a(m mVar, d dVar) {
        if (u.apU().bz(this.lhE.jUL)) {
            this.lhC = new a(this.lhE, dVar);
            return this.lhC.b(mVar);
        }
        w.w("MicroMsg.exdevice.MMSwitchBackGroudTaskExcuter", "push switch backgroud event to device before it do auth, device id = %d", new Object[]{Long.valueOf(this.lhE.jUL)});
        return true;
    }
}
