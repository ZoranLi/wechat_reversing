package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aju;
import com.tencent.mm.protocal.c.ajv;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class aj extends k implements j {
    private final b gUA;
    private e gUD;

    public aj(int i) {
        a aVar = new a();
        aVar.hsm = new aju();
        aVar.hsn = new ajv();
        aVar.uri = "/cgi-bin/micromsg-bin/logoutwebwx";
        aVar.hsl = 281;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((aju) this.gUA.hsj.hsr).tce = i;
    }

    public final int getType() {
        return 281;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.NetSceneWebWXLogout", "doScene");
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            w.d("MicroMsg.NetSceneWebWXLogout", "logout Error. ");
        }
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
