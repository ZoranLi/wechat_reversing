package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.i;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.w;

public final class g extends ae {
    private c lhB;
    private a lhC;

    public g(byte[] bArr, int i, long j) {
        this.lhB = new i(bArr, i, j);
    }

    public final boolean a(m mVar, d dVar) {
        if (u.apU().bz(this.lhB.jUL)) {
            this.lhC = new a(this.lhB, dVar);
            return this.lhC.b(mVar);
        }
        w.w("MicroMsg.exdevice.MMPushManufacturerSvrSendDataLogic", "Service push data to device before it do auth, device id = %d", new Object[]{Long.valueOf(this.lhB.jUL)});
        return true;
    }
}
