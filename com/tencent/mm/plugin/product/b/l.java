package com.tencent.mm.plugin.product.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bal;
import com.tencent.mm.protocal.c.bdy;
import com.tencent.mm.protocal.c.bdz;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class l extends k implements j {
    private b gUA;
    private e gUD;
    public String opu;

    public l(bal com_tencent_mm_protocal_c_bal, String str) {
        a aVar = new a();
        aVar.hsm = new bdy();
        aVar.hsn = new bdz();
        aVar.uri = "/cgi-bin/micromsg-bin/submitmallorder";
        aVar.hsl = 556;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bdy com_tencent_mm_protocal_c_bdy = (bdy) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bdy.ufc = com_tencent_mm_protocal_c_bal;
        com_tencent_mm_protocal_c_bdy.ufe = str;
    }

    public final int getType() {
        return 556;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void d(int i, int i2, String str, p pVar) {
        bdz com_tencent_mm_protocal_c_bdz = (bdz) ((b) pVar).hsk.hsr;
        if (i == 0 && i2 == 0) {
            w.d("MicroMsg.NetSceneMallSubmitMallOrder", "resp.ReqKey " + com_tencent_mm_protocal_c_bdz.ufd);
            this.opu = com_tencent_mm_protocal_c_bdz.ufd;
        }
        w.d("MicroMsg.NetSceneMallSubmitMallOrder", "errCode " + i2 + ", errMsg " + str);
        this.gUD.a(i, i2, str, this);
    }
}
