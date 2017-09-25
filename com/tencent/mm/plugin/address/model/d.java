package com.tencent.mm.plugin.address.model;

import com.tencent.mm.a.o;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ato;
import com.tencent.mm.protocal.c.atp;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d extends k implements j {
    private b gUA;
    private e gUD;
    public int status;

    public d(String str, String str2, o oVar) {
        boolean z = true;
        a aVar = new a();
        aVar.hsm = new ato();
        aVar.hsn = new atp();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoimport";
        aVar.hsl = 582;
        aVar.hso = 0;
        aVar.hsp = 0;
        String str3 = "MicroMsg.NetSceneRcptInfoImportYiXun";
        StringBuilder append = new StringBuilder("a2key is ").append(!bg.mA(str)).append(", newa2key is ");
        if (bg.mA(str2)) {
            z = false;
        }
        w.d(str3, append.append(z).toString());
        this.gUA = aVar.BE();
        ato com_tencent_mm_protocal_c_ato = (ato) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ato.thn = new avw().bb(bg.PT(str));
        com_tencent_mm_protocal_c_ato.tXD = new avw().bb(bg.PT(str2));
        com_tencent_mm_protocal_c_ato.ctC = oVar.intValue();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneRcptInfoImportYiXun", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            atp com_tencent_mm_protocal_c_atp = (atp) ((b) pVar).hsk.hsr;
            this.status = com_tencent_mm_protocal_c_atp.tXE;
            w.d("MicroMsg.NetSceneRcptInfoImportYiXun", "status : " + this.status);
            if (com_tencent_mm_protocal_c_atp.tXC.tXF != null && this.status == 0) {
                w.d("MicroMsg.NetSceneRcptInfoImportYiXun", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_atp.tXC.tXF.size());
                com.tencent.mm.plugin.address.a.a.OR();
                com.tencent.mm.plugin.address.a.a.OT().p(com_tencent_mm_protocal_c_atp.tXC.tXF);
                com.tencent.mm.plugin.address.a.a.OR();
                com.tencent.mm.plugin.address.a.a.OT().OV();
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 582;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
