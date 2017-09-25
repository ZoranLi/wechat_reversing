package com.tencent.mm.wallet_core.c;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.protocal.c.arg;
import com.tencent.mm.protocal.c.arh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class i extends k {
    public final b gUA;
    private e gUD;
    public String kMS;
    public String rPG;
    public String rPH;

    public i(String str, String str2, String str3, int i, int i2, String str4) {
        a aVar = new a();
        aVar.hsm = new arg();
        aVar.hsn = new arh();
        aVar.uri = "/cgi-bin/micromsg-bin/preparepurchase";
        aVar.hsl = 422;
        aVar.hso = JsApiCheckIsSupportFaceDetect.CTRL_INDEX;
        aVar.hsp = 1000000214;
        this.gUA = aVar.BE();
        arg com_tencent_mm_protocal_c_arg = (arg) this.gUA.hsj.hsr;
        this.kMS = str;
        com_tencent_mm_protocal_c_arg.tgW = str;
        this.rPH = str2;
        com_tencent_mm_protocal_c_arg.tVE = str2;
        this.rPG = str3;
        com_tencent_mm_protocal_c_arg.tVF = str3;
        com_tencent_mm_protocal_c_arg.ogR = i2;
        com_tencent_mm_protocal_c_arg.tVG = i;
        com_tencent_mm_protocal_c_arg.mvZ = str4;
        w.d("MicroMsg.NetScenePreparePurchase", "productId:" + str + ",price:" + str2 + ",currencyType:" + str3 + ",payType:" + i2);
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.e("MicroMsg.NetScenePreparePurchase", "ErrType:" + i + ",errCode:" + i2 + ",errMsg:" + str);
        if (i == 0 && i2 == 0) {
            this.gUD.a(i, i2, str, this);
        } else {
            this.gUD.a(i, i2, str, this);
        }
    }

    public final String cbY() {
        arh com_tencent_mm_protocal_c_arh = (arh) this.gUA.hsk.hsr;
        if (com_tencent_mm_protocal_c_arh != null) {
            w.d("MicroMsg.NetScenePreparePurchase", "get bill no is " + com_tencent_mm_protocal_c_arh.tVH);
            return com_tencent_mm_protocal_c_arh.tVH;
        }
        w.e("MicroMsg.NetScenePreparePurchase", "get bill no field.");
        return "";
    }

    public final int getType() {
        return 422;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
