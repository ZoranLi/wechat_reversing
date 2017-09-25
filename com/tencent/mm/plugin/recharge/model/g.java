package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.cs;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.bea;
import com.tencent.mm.protocal.c.beb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class g extends k {
    private b gUA;
    private e gUD;
    public String ivH;
    public PayInfo oLz;

    public g(MallRechargeProduct mallRechargeProduct, String str) {
        this(mallRechargeProduct.appId, mallRechargeProduct.oKW, mallRechargeProduct.fGa, str);
    }

    public g(String str, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.hsm = new bea();
        aVar.hsn = new beb();
        aVar.uri = "/cgi-bin/micromsg-bin/submitpayproductbuyinfo";
        aVar.hsl = 498;
        aVar.hso = cs.CTRL_INDEX;
        aVar.hsp = 1000000230;
        this.gUA = aVar.BE();
        bea com_tencent_mm_protocal_c_bea = (bea) this.gUA.hsj.hsr;
        w.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "remark: %s", new Object[]{str4});
        this.ivH = str;
        com_tencent_mm_protocal_c_bea.tAo = str;
        com_tencent_mm_protocal_c_bea.tAn = str2;
        com_tencent_mm_protocal_c_bea.tFj = str3;
        com_tencent_mm_protocal_c_bea.tAp = str4;
        com_tencent_mm_protocal_c_bea.tuo = c.buC().Ia(str2);
    }

    public final void d(int i, int i2, String str, p pVar) {
        this.oLz = new PayInfo();
        beb com_tencent_mm_protocal_c_beb = (beb) ((b) pVar).hsk.hsr;
        if (i == 0 && i2 == 0) {
            w.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "resp.ReqKey " + com_tencent_mm_protocal_c_beb.tgY);
            this.oLz.appId = this.ivH;
            this.oLz.rPJ = com_tencent_mm_protocal_c_beb.tBo;
            this.oLz.fJH = com_tencent_mm_protocal_c_beb.tgY;
        }
        if (i2 == 0) {
            i2 = com_tencent_mm_protocal_c_beb.tAq;
        }
        if (bg.mA(str)) {
            str = com_tencent_mm_protocal_c_beb.tAr;
        }
        this.oLz.sYd = String.valueOf(i2);
        this.oLz.fPf = str != null ? str : "";
        w.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "errCode " + i2 + ", errMsg " + str);
        this.gUD.a(i, i2, str, this);
    }

    public final int getType() {
        return 498;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
