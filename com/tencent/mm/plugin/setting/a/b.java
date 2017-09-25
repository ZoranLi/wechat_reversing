package com.tencent.mm.plugin.setting.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.tl;
import com.tencent.mm.protocal.c.tm;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    private com.tencent.mm.y.b gUA;
    private e gUD;

    public b(String str) {
        a aVar = new a();
        aVar.hsm = new tl();
        aVar.hsn = new tm();
        aVar.uri = "/cgi-bin/micromsg-bin/generalset";
        aVar.hsl = 177;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        tl tlVar = (tl) this.gUA.hsj.hsr;
        tlVar.tuO = 1;
        tlVar.tBq = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.NetSceneGeneralSet", "doScene");
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 177;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGeneralSet", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        this.gUD.a(i2, i3, str, this);
    }
}
