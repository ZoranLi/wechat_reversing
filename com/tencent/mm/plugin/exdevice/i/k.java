package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.s;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;

public final class k extends ae implements e {
    private int kMP = -1;
    private String lcq = null;
    private String lcr = null;
    private String lhH = null;

    public k(String str, String str2, String str3, int i) {
        this.lcq = str;
        this.lhH = str2;
        this.lcr = str3;
        this.kMP = i;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "onSceneEnd. errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        ap.vd().b(1090, this);
    }

    public final boolean a(m mVar, d dVar) {
        w.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "excute MMWifiStatusSubscribeTaskExcuter. brandName=" + this.lcq + ",deviceType=" + this.lhH + ",deviceId=" + this.lcr + ",reqType=" + this.kMP);
        ap.vd().a(1090, this);
        ap.vd().a(new s(this.lcq, this.lhH, this.lcr, this.kMP), 0);
        return false;
    }
}
