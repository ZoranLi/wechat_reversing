package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.apz;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;

public final class a extends k {
    private b gUA;
    private e gUD;

    public final int getType() {
        return 1554;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.d("MicroMsg.NetScenePayUCheckJsApi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        apz com_tencent_mm_protocal_c_apz = (apz) ((b) pVar).hsk.hsr;
        if (i == 0 && i2 == 0) {
            w.d("MicroMsg.NetScenePayUCheckJsApi", "rr " + com_tencent_mm_protocal_c_apz.leR);
        }
        this.gUD.a(i, i2, com_tencent_mm_protocal_c_apz.leS, this);
    }
}
