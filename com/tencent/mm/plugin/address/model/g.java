package com.tencent.mm.plugin.address.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.protocal.c.atw;
import com.tencent.mm.protocal.c.atx;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class g extends k implements j {
    private b gUA;
    private e gUD;

    public g(int i) {
        a aVar = new a();
        aVar.hsm = new atw();
        aVar.hsn = new atx();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfotouch";
        aVar.hsl = 419;
        aVar.hso = ao.CTRL_INDEX;
        aVar.hsp = 1000000204;
        this.gUA = aVar.BE();
        ((atw) this.gUA.hsj.hsr).id = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneRcptInfoTouch", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            atx com_tencent_mm_protocal_c_atx = (atx) ((b) pVar).hsk.hsr;
            if (com_tencent_mm_protocal_c_atx.tXC.tXF != null) {
                w.d("MicroMsg.NetSceneRcptInfoTouch", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_atx.tXC.tXF.size());
                com.tencent.mm.plugin.address.a.a.OR();
                com.tencent.mm.plugin.address.a.a.OT().p(com_tencent_mm_protocal_c_atx.tXC.tXF);
                com.tencent.mm.plugin.address.a.a.OR();
                com.tencent.mm.plugin.address.a.a.OT().OV();
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 419;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
