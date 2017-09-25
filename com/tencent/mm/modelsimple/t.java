package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ajs;
import com.tencent.mm.protocal.c.ajt;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class t extends k implements j {
    private final b gUA;
    private e gUD;

    public t() {
        a aVar = new a();
        aVar.hsm = new ajs();
        aVar.hsn = new ajt();
        aVar.uri = "/cgi-bin/micromsg-bin/logout";
        aVar.hsl = 282;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((ajs) this.gUA.hsj.hsr).tdM = 0;
    }

    public final int getType() {
        return 282;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.NetSceneLogout", "doScene");
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            w.d("MicroMsg.NetSceneLogout", "logout Error. ");
        }
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
