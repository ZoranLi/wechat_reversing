package com.tencent.mm.plugin.address.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.protocal.c.ats;
import com.tencent.mm.protocal.c.att;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;

public final class e extends k implements j {
    public String fFa;
    private b gUA;
    private com.tencent.mm.y.e gUD;
    public boolean itb;
    public String username;

    public e(String str, String str2, int i) {
        a aVar = new a();
        aVar.hsm = new ats();
        aVar.hsn = new att();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoquery";
        aVar.hsl = 417;
        aVar.hso = f.CTRL_INDEX;
        aVar.hsp = 1000000202;
        this.gUA = aVar.BE();
        ats com_tencent_mm_protocal_c_ats = (ats) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ats.kBd = 0;
        com_tencent_mm_protocal_c_ats.tXP = str;
        com_tencent_mm_protocal_c_ats.fTO = str2;
        com_tencent_mm_protocal_c_ats.scene = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        boolean z = true;
        w.d("MicroMsg.NetSceneRcptInfoQuery", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            att com_tencent_mm_protocal_c_att = (att) ((b) pVar).hsk.hsr;
            this.username = com_tencent_mm_protocal_c_att.lmI;
            this.fFa = com_tencent_mm_protocal_c_att.tXS;
            if (com_tencent_mm_protocal_c_att.tXR != 1) {
                z = false;
            }
            this.itb = z;
            if (com_tencent_mm_protocal_c_att.tXC.tXF != null) {
                w.d("MicroMsg.NetSceneRcptInfoQuery", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_att.tXC.tXF.size());
                com.tencent.mm.plugin.address.a.a.OR();
                com.tencent.mm.plugin.address.a.a.OT().p(com_tencent_mm_protocal_c_att.tXC.tXF);
                com.tencent.mm.plugin.address.a.a.OR();
                com.tencent.mm.plugin.address.a.a.OT().OV();
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 417;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
