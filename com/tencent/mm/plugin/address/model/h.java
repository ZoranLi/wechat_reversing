package com.tencent.mm.plugin.address.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.protocal.c.atr;
import com.tencent.mm.protocal.c.aty;
import com.tencent.mm.protocal.c.atz;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class h extends k implements j {
    private b gUA;
    private e gUD;

    public h(com.tencent.mm.plugin.address.d.b bVar) {
        a aVar = new a();
        aVar.hsm = new aty();
        aVar.hsn = new atz();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoupdate";
        aVar.hsl = 418;
        aVar.hso = aq.CTRL_INDEX;
        aVar.hsp = 1000000203;
        this.gUA = aVar.BE();
        aty com_tencent_mm_protocal_c_aty = (aty) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aty.tXB = new atr();
        com_tencent_mm_protocal_c_aty.tXB.id = bVar.id;
        com_tencent_mm_protocal_c_aty.tXB.tXI = new avx().OV(bg.ap(bVar.itt, ""));
        com_tencent_mm_protocal_c_aty.tXB.tXG = new avx().OV(bg.ap(bVar.itr, ""));
        com_tencent_mm_protocal_c_aty.tXB.tXL = new avx().OV(bg.ap(bVar.itw, ""));
        com_tencent_mm_protocal_c_aty.tXB.tXJ = new avx().OV(bg.ap(bVar.itu, ""));
        com_tencent_mm_protocal_c_aty.tXB.tXM = new avx().OV(bg.ap(bVar.itx, ""));
        com_tencent_mm_protocal_c_aty.tXB.tXN = new avx().OV(bg.ap(bVar.ity, ""));
        com_tencent_mm_protocal_c_aty.tXB.tXH = new avx().OV(bg.ap(bVar.its, ""));
        com_tencent_mm_protocal_c_aty.tXB.tXK = new avx().OV(bg.ap(bVar.itv, ""));
        com_tencent_mm_protocal_c_aty.tXB.tXO = new avx().OV(bg.ap(bVar.itz, ""));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneRcptInfoUpdate", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            atz com_tencent_mm_protocal_c_atz = (atz) ((b) pVar).hsk.hsr;
            if (com_tencent_mm_protocal_c_atz.tXC.tXF != null) {
                w.d("MicroMsg.NetSceneRcptInfoUpdate", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_atz.tXC.tXF.size());
                com.tencent.mm.plugin.address.a.a.OR();
                com.tencent.mm.plugin.address.a.a.OT().p(com_tencent_mm_protocal_c_atz.tXC.tXF);
                com.tencent.mm.plugin.address.a.a.OR();
                com.tencent.mm.plugin.address.a.a.OT().OV();
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 418;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
