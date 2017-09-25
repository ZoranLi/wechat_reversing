package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.exdevice.e.c;
import com.tencent.mm.plugin.exdevice.e.n;
import com.tencent.mm.sdk.platformtools.w;

public final class h extends j {
    public h(int i, int i2, long j) {
        a nVar = new n();
        nVar.lfg = new c();
        nVar.lfk = i;
        nVar.lfl = i2;
        this.laz = nVar;
        this.jUL = j;
    }

    public final byte[] aoR() {
        byte[] bArr = null;
        try {
            bArr = this.laz.toByteArray();
        } catch (Exception e) {
            w.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "mResp.toByteArray() Failed!!! %s", new Object[]{e.getMessage()});
        }
        return bArr;
    }

    public final int aoT() {
        n nVar = (n) this.laz;
        if (nVar != null) {
            return nVar.lfk;
        }
        w.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "null = pushReq");
        return -1;
    }
}
