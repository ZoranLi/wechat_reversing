package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ayy;
import com.tencent.mm.protocal.c.ayz;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class ae extends k implements j {
    private final b gUA;
    private e gUD;

    public ae(String str) {
        a aVar = new a();
        aVar.hsm = new ayy();
        aVar.hsn = new ayz();
        aVar.uri = "/cgi-bin/micromsg-bin/newsetemailpwd";
        aVar.hsl = 382;
        aVar.hso = 181;
        aVar.hsp = 1000000181;
        this.gUA = aVar.BE();
        ((ayy) this.gUA.hsj.hsr).tjK = bg.PR(str);
        w.d("MicroMsg.NetSceneSetEmailPwd", "md5 " + str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 382;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneSetEmailPwd", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.gUD.a(i2, i3, str, this);
    }
}
