package com.tencent.mm.plugin.order.model;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.protocal.c.pv;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class f extends k {
    private b gUA;
    private e gUD;

    public f(String str, String str2, int i) {
        a aVar = new a();
        aVar.hsm = new pv();
        aVar.hsn = new pw();
        aVar.uri = "/cgi-bin/micromsg-bin/evaluateorder";
        aVar.hsl = 583;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        pv pvVar = (pv) this.gUA.hsj.hsr;
        pvVar.tvR = str;
        pvVar.mtb = str2;
        pvVar.oTE = i;
        pvVar.tnu = h.btK();
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.d("MicroMsg.NetSceneEvaluateOrder", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gUD.a(i, i2, str, this);
    }

    public final int getType() {
        return 583;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
