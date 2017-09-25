package com.tencent.mm.plugin.nfc_open.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.mp;
import com.tencent.mm.protocal.c.mq;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    public com.tencent.mm.y.b gUA;
    private e gUD;

    public b(int i) {
        a aVar = new a();
        aVar.hsm = new mp();
        aVar.hsn = new mq();
        aVar.uri = "/cgi-bin/mmpay-bin/cpucardgetconfig2";
        aVar.hsl = 1561;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((mp) this.gUA.hsj.hsr).version = i;
    }

    public final int getType() {
        return 1561;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneCpuCardGetConfig", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gUD.a(i2, i3, str, this);
    }
}
