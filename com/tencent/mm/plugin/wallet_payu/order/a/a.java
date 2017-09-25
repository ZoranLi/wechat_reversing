package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.apx;
import com.tencent.mm.protocal.c.apy;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;

public final class a extends k {
    public b gUA;
    private e gUD;

    public a(int i) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new apx();
        aVar.hsn = new apy();
        aVar.uri = "/cgi-bin/mmpay-bin/payubatchuserroll";
        aVar.hsl = 1519;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        apx com_tencent_mm_protocal_c_apx = (apx) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_apx.mux = 10;
        com_tencent_mm_protocal_c_apx.tll = i;
        w.d("MicroMsg.NetScenePayUPayQueryUserRoll", "limit:10" + ",offset:" + i);
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.w("MicroMsg.NetScenePayUPayQueryUserRoll", "errType = " + i + " errCode " + i2 + " errMsg " + str);
        this.gUD.a(i, i2, str, this);
        if (i == 0 && i2 == 0) {
            w.d("MicroMsg.NetScenePayUPayQueryUserRoll", "rr" + ((apy) ((b) pVar).hsk.hsr).tUV);
        }
    }

    public final int bvD() {
        return ((apy) this.gUA.hsk.hsr).tUV;
    }

    public final int getType() {
        return 1519;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
