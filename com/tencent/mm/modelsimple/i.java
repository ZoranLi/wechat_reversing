package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ns;
import com.tencent.mm.protocal.c.nt;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class i extends k implements j {
    private final b gUA;
    private e gUD;

    public i(String str) {
        w.i("MicroMsg.NetSceneDelTempSession", "NetSceneDelTempSession %s", str);
        a aVar = new a();
        aVar.hsm = new ns();
        aVar.hsn = new nt();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/deltempsession";
        this.gUA = aVar.BE();
        ns nsVar = (ns) this.gUA.hsj.hsr;
        nsVar.tkB = str;
        nsVar.tty = com.tencent.mm.bd.b.aU(new byte[0]);
    }

    public final int getType() {
        return 1067;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneDelTempSession", "onGYNetEnd: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gUD.a(i2, i3, str, this);
    }
}
