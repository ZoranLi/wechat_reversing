package com.tencent.mm.plugin.address.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.protocal.c.atu;
import com.tencent.mm.protocal.c.atv;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class f extends k implements j {
    private b gUA;
    private e gUD;
    public int itc = 0;

    public f(int i) {
        a aVar = new a();
        aVar.hsm = new atu();
        aVar.hsn = new atv();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinforemove";
        aVar.hsl = 416;
        aVar.hso = bh.CTRL_INDEX;
        aVar.hsp = 1000000201;
        this.gUA = aVar.BE();
        this.itc = i;
        w.d("MicroMsg.NetSceneRcptInfoRemove", "remove Id " + i);
        ((atu) this.gUA.hsj.hsr).id = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneRcptInfoRemove", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            atv com_tencent_mm_protocal_c_atv = (atv) ((b) pVar).hsk.hsr;
            if (com_tencent_mm_protocal_c_atv.tXC.tXF != null) {
                w.d("MicroMsg.NetSceneRcptInfoRemove", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_atv.tXC.tXF.size());
                com.tencent.mm.plugin.address.a.a.OR();
                com.tencent.mm.plugin.address.a.a.OT().p(com_tencent_mm_protocal_c_atv.tXC.tXF);
                com.tencent.mm.plugin.address.a.a.OR();
                com.tencent.mm.plugin.address.a.a.OT().OV();
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 416;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
