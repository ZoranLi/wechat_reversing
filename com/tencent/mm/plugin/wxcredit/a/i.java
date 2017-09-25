package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.protocal.c.aus;
import com.tencent.mm.protocal.c.aut;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class i extends k {
    private b gUA;
    private e gUD;

    public i(String str, String str2) {
        a aVar = new a();
        aVar.hsm = new aus();
        aVar.hsn = new aut();
        aVar.uri = "/cgi-bin/micromsg-bin/removevirtualbankcard";
        aVar.hsl = 600;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        aus com_tencent_mm_protocal_c_aus = (aus) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aus.tYr = str;
        com_tencent_mm_protocal_c_aus.tYq = bg.getInt(str2, 0);
        com_tencent_mm_protocal_c_aus.tnu = h.btK();
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.d("MicroMsg.NetSceneRemoveVirtualBankCard", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gUD.a(i, i2, str, this);
    }

    public final int getType() {
        return 600;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
