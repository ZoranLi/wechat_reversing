package com.tencent.mm.plugin.address.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.protocal.c.atm;
import com.tencent.mm.protocal.c.atn;
import com.tencent.mm.protocal.c.atr;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c extends k implements j {
    private b gUA;
    private e gUD;

    public c(com.tencent.mm.plugin.address.d.b bVar) {
        a aVar = new a();
        aVar.hsm = new atm();
        aVar.hsn = new atn();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoadd";
        aVar.hsl = 415;
        aVar.hso = m.CTRL_INDEX;
        aVar.hsp = 1000000200;
        this.gUA = aVar.BE();
        atm com_tencent_mm_protocal_c_atm = (atm) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_atm.tXB = new atr();
        com_tencent_mm_protocal_c_atm.tXB.tXI = new avx().OV(bg.ap(bVar.itt, ""));
        com_tencent_mm_protocal_c_atm.tXB.tXG = new avx().OV(bg.ap(bVar.itr, ""));
        com_tencent_mm_protocal_c_atm.tXB.tXL = new avx().OV(bg.ap(bVar.itw, ""));
        com_tencent_mm_protocal_c_atm.tXB.tXJ = new avx().OV(bg.ap(bVar.itu, ""));
        com_tencent_mm_protocal_c_atm.tXB.tXM = new avx().OV(bg.ap(bVar.itx, ""));
        com_tencent_mm_protocal_c_atm.tXB.tXN = new avx().OV(bg.ap(bVar.ity, ""));
        com_tencent_mm_protocal_c_atm.tXB.tXH = new avx().OV(bg.ap(bVar.its, ""));
        com_tencent_mm_protocal_c_atm.tXB.tXK = new avx().OV(bg.ap(bVar.itv, ""));
        com_tencent_mm_protocal_c_atm.tXB.tXO = new avx().OV(bg.ap(bVar.itz, ""));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneRcptInfoAdd", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            atn com_tencent_mm_protocal_c_atn = (atn) ((b) pVar).hsk.hsr;
            if (com_tencent_mm_protocal_c_atn.tXC.tXF != null) {
                w.d("MicroMsg.NetSceneRcptInfoAdd", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_atn.tXC.tXF.size());
                com.tencent.mm.plugin.address.a.a.OR();
                com.tencent.mm.plugin.address.a.a.OT().p(com_tencent_mm_protocal_c_atn.tXC.tXF);
                com.tencent.mm.plugin.address.a.a.OR();
                com.tencent.mm.plugin.address.a.a.OT().OV();
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 415;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
