package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.vs;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class o extends k implements j {
    b gUA = null;
    private e gUD = null;

    public o() {
        a aVar = new a();
        aVar.hsm = new vs();
        aVar.hsn = new vt();
        aVar.uri = "/cgi-bin/micromsg-bin/getboundharddevices";
        aVar.hsl = 539;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((vs) this.gUA.hsj.hsr).jOb = 1;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.exdevice.NetSceneGetBoundHardDevices", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 539;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
