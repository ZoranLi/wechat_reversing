package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.protocal.c.pz;
import com.tencent.mm.protocal.c.qa;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    private final com.tencent.mm.y.b gUA;
    private e gUD;
    private int nXW;

    public b(int i, long j, String str, int i2) {
        this.nXW = i2;
        a aVar = new a();
        aVar.hsm = new pz();
        aVar.hsn = new qa();
        aVar.uri = "/cgi-bin/micromsg-bin/exittalkroom";
        aVar.hsl = 333;
        aVar.hso = JsApiScanCode.CTRL_INDEX;
        aVar.hsp = 1000000148;
        this.gUA = aVar.BE();
        pz pzVar = (pz) this.gUA.hsj.hsr;
        pzVar.tvK = str;
        pzVar.tvL = i;
        pzVar.tvM = j;
        pzVar.tdM = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.NetSceneExitTalkRoom", "doScene %d", new Object[]{Integer.valueOf(this.nXW)});
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 333;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneExitTalkRoom", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.gUD.a(i2, i3, str, this);
        } else {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
