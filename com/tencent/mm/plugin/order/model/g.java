package com.tencent.mm.plugin.order.model;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.as;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.protocal.c.api;
import com.tencent.mm.protocal.c.apj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class g extends k {
    private b gUA;
    private e gUD;

    public g(String str, String str2, int i) {
        a aVar = new a();
        aVar.hsm = new api();
        aVar.hsn = new apj();
        aVar.uri = "/cgi-bin/micromsg-bin/paydeluserroll";
        aVar.hsl = 389;
        aVar.hso = as.CTRL_BYTE;
        aVar.hsp = 1000000187;
        this.gUA = aVar.BE();
        api com_tencent_mm_protocal_c_api = (api) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_api.tUq = 1;
        if (!bg.mA(str)) {
            com_tencent_mm_protocal_c_api.ogJ = str;
        }
        if (!bg.mA(str2)) {
            com_tencent_mm_protocal_c_api.ohc = str2;
        }
        com_tencent_mm_protocal_c_api.tnu = h.btK();
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.d("MicroMsg.NetScenePayDelUserRoll", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gUD.a(i, i2, str, this);
    }

    public final int aRF() {
        return ((api) this.gUA.hsj.hsr).tUq;
    }

    public final String aRG() {
        return ((api) this.gUA.hsj.hsr).ogJ;
    }

    public final int getType() {
        return 389;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
