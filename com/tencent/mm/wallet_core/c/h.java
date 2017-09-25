package com.tencent.mm.wallet_core.c;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.apv;
import com.tencent.mm.protocal.c.apw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class h extends k {
    private b gUA;
    private e gUD;

    public h(String str) {
        this(str, null, null, -1, -1, -1);
    }

    public h(String str, String str2, String str3, int i, int i2, int i3) {
        a aVar = new a();
        aVar.hsm = new apv();
        aVar.hsn = new apw();
        aVar.uri = "/cgi-bin/mmpay-bin/paysubscribe";
        aVar.hsl = 421;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        apv com_tencent_mm_protocal_c_apv = (apv) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_apv.tUQ = str;
        com_tencent_mm_protocal_c_apv.tnu = com.tencent.mm.plugin.wallet_core.model.h.btK();
        com_tencent_mm_protocal_c_apv.tUR = str3;
        if (!bg.mA(str2)) {
            com_tencent_mm_protocal_c_apv.tUS = new com.tencent.mm.bd.b(str2.getBytes());
        }
        if (i >= 0) {
            com_tencent_mm_protocal_c_apv.tUT = i;
        }
        if (i2 >= 0) {
            com_tencent_mm_protocal_c_apv.tcg = i2;
        }
        if (i3 >= 0) {
            com_tencent_mm_protocal_c_apv.tUU = i3;
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.d("MicroMsg.NetScenePaySubscribe", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gUD.a(i, i2, str, this);
    }

    public final int getType() {
        return 421;
    }
}
