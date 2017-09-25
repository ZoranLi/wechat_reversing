package com.tencent.mm.modelstat;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.yb;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class i extends k implements j {
    private e gWW;
    final b hWk;

    public i(com.tencent.mm.bd.b bVar) {
        a aVar = new a();
        com.tencent.mm.bd.a ybVar = new yb();
        ybVar.tED = bVar;
        aVar.hsm = ybVar;
        aVar.hsn = new yc();
        aVar.uri = "/cgi-bin/mmbiz-bin/geteventsampleconf";
        aVar.hsl = 1126;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.hWk = aVar.BE();
    }

    public final int getType() {
        return 1126;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.NetSceneUpdateEventConfig", "start update event config");
        this.hsJ = true;
        this.gWW = eVar2;
        return a(eVar, this.hWk, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneUpdateEventConfig", "onGYNetEnd errType: %d, errCode: %d, errMsg %s, IReqResp %s", Integer.valueOf(i2), Integer.valueOf(i3), str, pVar.toString());
        this.gWW.a(i2, i3, str, this);
    }
}
