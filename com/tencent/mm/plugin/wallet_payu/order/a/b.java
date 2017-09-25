package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aqa;
import com.tencent.mm.protocal.c.aqb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class b extends k {
    private com.tencent.mm.y.b gUA;
    private e gUD;

    public b(String str) {
        a aVar = new a();
        aVar.hsm = new aqa();
        aVar.hsn = new aqb();
        aVar.uri = "/cgi-bin/mmpay-bin/payudeluserroll";
        aVar.hsl = 1544;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        aqa com_tencent_mm_protocal_c_aqa = (aqa) this.gUA.hsj.hsr;
        if (!bg.mA(str)) {
            com_tencent_mm_protocal_c_aqa.ogJ = str;
        }
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.d("MicroMsg.NetScenePayUDelUserRoll", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gUD.a(i, i2, str, this);
    }

    public final int getType() {
        return 1544;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
