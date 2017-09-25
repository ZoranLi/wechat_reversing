package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.h;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.w;

public final class j extends ae {
    private a lhF;
    private h lhG;

    public j(int i, int i2, long j) {
        this.lhG = new h(i, i2, j);
    }

    public final boolean a(m mVar, d dVar) {
        if (u.apU().bz(this.lhG.jUL)) {
            this.lhF = new b(this.lhG, dVar);
            return this.lhF.b(mVar);
        }
        w.w("MicroMsg.exdevice.MMSwitchViewPushTaskExcuter", "push switchview event to device before it do auth, device id = %d", new Object[]{Long.valueOf(this.lhG.jUL)});
        return true;
    }
}
