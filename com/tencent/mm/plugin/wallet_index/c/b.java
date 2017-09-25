package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.network.p;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.m;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.protocal.c.ape;
import com.tencent.mm.protocal.c.apf;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class b extends k {
    public com.tencent.mm.y.b gUA;
    private e gUD;

    public b(PayReq payReq, String str, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.hsm = new ape();
        aVar.hsn = new apf();
        aVar.uri = "/cgi-bin/mmpay-bin/payauthapp";
        aVar.hsl = 397;
        aVar.hso = m.CTRL_BYTE;
        aVar.hsp = 1000000188;
        this.gUA = aVar.BE();
        ape com_tencent_mm_protocal_c_ape = (ape) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ape.mtb = payReq.appId;
        com_tencent_mm_protocal_c_ape.tUi = payReq.partnerId;
        com_tencent_mm_protocal_c_ape.tBn = payReq.prepayId;
        com_tencent_mm_protocal_c_ape.trf = payReq.nonceStr;
        com_tencent_mm_protocal_c_ape.tUj = payReq.timeStamp;
        com_tencent_mm_protocal_c_ape.trg = payReq.packageValue;
        com_tencent_mm_protocal_c_ape.trh = payReq.sign;
        com_tencent_mm_protocal_c_ape.tri = payReq.signType;
        com_tencent_mm_protocal_c_ape.tUk = str;
        com_tencent_mm_protocal_c_ape.msm = str2;
        com_tencent_mm_protocal_c_ape.muS = str3;
        com_tencent_mm_protocal_c_ape.tnu = h.btK();
        com_tencent_mm_protocal_c_ape.tUm = str4;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.d("MicroMsg.NetScenePayAuthApp", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gUD.a(i, i2, str, this);
    }

    public final int getType() {
        return 397;
    }
}
