package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.apu;
import com.tencent.mm.protocal.c.aqe;
import com.tencent.mm.protocal.c.aqf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class c extends k {
    private b gUA;
    private e gUD;
    public apu rRM = null;

    public c(String str) {
        a aVar = new a();
        aVar.hsm = new aqe();
        aVar.hsn = new aqf();
        aVar.uri = "/cgi-bin/mmpay-bin/payuqueryuserroll";
        aVar.hsl = 1520;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        aqe com_tencent_mm_protocal_c_aqe = (aqe) this.gUA.hsj.hsr;
        if (!bg.mA(str)) {
            com_tencent_mm_protocal_c_aqe.ogJ = str;
        }
    }

    public final int getType() {
        return 1520;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.w("MicroMsg.NetScenePayUQueryUserRoll", "errType = " + i + " errCode " + i2 + " errMsg " + str);
        this.gUD.a(i, i2, str, this);
        if (i == 0 && i2 == 0) {
            aqf com_tencent_mm_protocal_c_aqf = (aqf) ((b) pVar).hsk.hsr;
            this.rRM = com_tencent_mm_protocal_c_aqf.tUY;
            if (com_tencent_mm_protocal_c_aqf.tUY != null) {
                w.d("MicroMsg.NetScenePayUQueryUserRoll", "rr" + com_tencent_mm_protocal_c_aqf.tUY.ogJ);
            } else {
                w.e("MicroMsg.NetScenePayUQueryUserRoll", "hy: user roll is null!!!");
            }
        }
    }
}
