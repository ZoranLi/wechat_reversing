package com.tencent.mm.wallet_core.c;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.cp;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bjb;
import com.tencent.mm.protocal.c.bjc;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class j extends k {
    private final b gUA;
    private e gUD;
    public String kMS = null;
    public int wEf = 0;

    public j(String str, int i, int i2, String str2, String str3, String str4, String str5, String str6) {
        a aVar = new a();
        aVar.hsm = new bjb();
        aVar.hsn = new bjc();
        aVar.uri = "/cgi-bin/micromsg-bin/verifypurchase";
        aVar.hsl = 414;
        aVar.hso = cp.CTRL_INDEX;
        aVar.hsp = 1000000215;
        this.gUA = aVar.BE();
        bjb com_tencent_mm_protocal_c_bjb = (bjb) this.gUA.hsj.hsr;
        this.kMS = str;
        com_tencent_mm_protocal_c_bjb.tgW = str;
        com_tencent_mm_protocal_c_bjb.uiF = 1;
        com_tencent_mm_protocal_c_bjb.tVG = i2;
        com_tencent_mm_protocal_c_bjb.ogR = i;
        if (!bg.mA(str6)) {
            com_tencent_mm_protocal_c_bjb.tVE = str6;
            com_tencent_mm_protocal_c_bjb.tVF = str5;
        }
        com_tencent_mm_protocal_c_bjb.tVH = str2;
        com_tencent_mm_protocal_c_bjb.uiH = str4;
        if (str3 != null) {
            com_tencent_mm_protocal_c_bjb.uiE = new avw().bb(str3.getBytes());
        } else {
            com_tencent_mm_protocal_c_bjb.uiE = new avw();
        }
        com_tencent_mm_protocal_c_bjb.uiG = (int) bg.Ny();
        w.i("MicroMsg.NetSceneVerifyPurchase", "productId:" + this.kMS + ",verifyType:1,palyType:" + i + ",payload:" + str2 + ",purchaseData:" + str3 + ",dataSignature:" + str4);
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.e("MicroMsg.NetSceneVerifyPurchase", "ErrType:" + i + "   errCode:" + i2);
        bjc com_tencent_mm_protocal_c_bjc = (bjc) ((b) pVar).hsk.hsr;
        if (com_tencent_mm_protocal_c_bjc.tZe != null) {
            this.wEf = com_tencent_mm_protocal_c_bjc.uiI;
        }
        if (i == 0 && i2 == 0) {
            this.gUD.a(i, i2, str, this);
        } else {
            this.gUD.a(i, i2, str, this);
        }
    }

    public final String cbZ() {
        bjc com_tencent_mm_protocal_c_bjc = (bjc) this.gUA.hsk.hsr;
        if (com_tencent_mm_protocal_c_bjc == null) {
            return "";
        }
        w.d("MicroMsg.NetSceneVerifyPurchase", " Get Series ID is " + com_tencent_mm_protocal_c_bjc.tvS);
        w.d("MicroMsg.NetSceneVerifyPurchase", " Get Biz Type is " + com_tencent_mm_protocal_c_bjc.mtq);
        return com_tencent_mm_protocal_c_bjc.tvS;
    }

    public final int getType() {
        return 414;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
