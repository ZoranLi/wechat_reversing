package com.tencent.mm.ak;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bfz;
import com.tencent.mm.protocal.c.bga;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    private final com.tencent.mm.y.b gUA;
    private e gUD;

    public b() {
        a aVar = new a();
        aVar.hsm = new bfz();
        aVar.hsn = new bga();
        aVar.uri = "/cgi-bin/micromsg-bin/unbindlinkedincontact";
        aVar.hsl = 550;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((bfz) this.gUA.hsj.hsr).thO = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 550;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneUnBindLinkedinContact", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            ap.yY();
            c.vr().set(286722, "");
            ap.yY();
            c.vr().set(286721, "");
            ap.yY();
            c.vr().set(286723, "");
        }
        this.gUD.a(i2, i3, str, this);
    }
}
