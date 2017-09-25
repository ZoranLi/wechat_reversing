package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.awy;
import com.tencent.mm.protocal.c.awz;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class u extends k implements j {
    b gUA = null;
    private e gUD = null;

    public u(String str) {
        a aVar = new a();
        aVar.hsm = new awy();
        aVar.hsn = new awz();
        aVar.uri = "/cgi-bin/micromsg-bin/searchharddevice";
        aVar.hsl = 540;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((awy) this.gUA.hsj.hsr).tZN = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.exdevice.NetSceneSearchHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 540;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
