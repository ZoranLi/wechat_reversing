package com.tencent.mm.wallet_core.c;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.protocal.c.im;
import com.tencent.mm.protocal.c.in;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class d extends k {
    private b gUA;
    private e gUD;

    public d(String str, String str2) {
        a aVar = new a();
        aVar.hsm = new im();
        aVar.hsn = new in();
        aVar.uri = "/cgi-bin/mmpay-bin/cancelqrpay";
        aVar.hsl = 410;
        aVar.hso = 198;
        aVar.hsp = 1000000198;
        this.gUA = aVar.BE();
        im imVar = (im) this.gUA.hsj.hsr;
        imVar.tnt = str;
        imVar.tgY = str2;
        imVar.tnu = h.btK();
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.d("MicroMsg.NetSceneCancelQRPay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gUD.a(i, i2, str, this);
    }

    public final int getType() {
        return 410;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
