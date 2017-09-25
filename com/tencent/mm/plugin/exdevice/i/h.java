package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.f;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.w;

public final class h extends ae {
    private f laL;
    private a lhD;

    public h(f fVar) {
        this.laL = fVar;
    }

    public final boolean a(m mVar, d dVar) {
        this.lhD = new a(this.laL, dVar);
        w.i("MicroMsg.exdevice.MMSendDataToDeviceExcuter", "send data to devide : %b", new Object[]{Boolean.valueOf(this.lhD.b(mVar))});
        return this.lhD.b(mVar);
    }
}
