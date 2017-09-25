package com.tencent.mm.plugin.product.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bal;
import com.tencent.mm.protocal.c.bdw;
import com.tencent.mm.protocal.c.bdx;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class k extends com.tencent.mm.y.k implements j {
    private b gUA;
    private e gUD;
    public String opu;

    public k(bal com_tencent_mm_protocal_c_bal) {
        a aVar = new a();
        aVar.hsm = new bdw();
        aVar.hsn = new bdx();
        aVar.uri = "/cgi-bin/micromsg-bin/submitmallfreeorder";
        aVar.hsl = 557;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((bdw) this.gUA.hsj.hsr).ufc = com_tencent_mm_protocal_c_bal;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        bdx com_tencent_mm_protocal_c_bdx = (bdx) ((b) pVar).hsk.hsr;
        if (i2 == 0 && i3 == 0) {
            w.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "resp.PrepareId " + com_tencent_mm_protocal_c_bdx.ufd);
            this.opu = com_tencent_mm_protocal_c_bdx.ufd;
        }
        w.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "errCode " + i3 + ", errMsg " + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 557;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
