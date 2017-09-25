package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.abj;
import com.tencent.mm.protocal.c.abk;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class q extends k implements j {
    public b gUA = null;
    private e gUD = null;

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.exdevice.NetSceneGetSportDeviceList", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1267;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        a aVar = new a();
        aVar.hsm = new abj();
        aVar.hsn = new abk();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/getsportdevicelist";
        aVar.hsl = 1267;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        return a(eVar, this.gUA, this);
    }
}
