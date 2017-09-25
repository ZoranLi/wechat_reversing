package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.protocal.c.zy;
import com.tencent.mm.protocal.c.zz;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import org.json.JSONObject;

public final class e extends k implements j {
    private b gUA;
    private com.tencent.mm.y.e gUD;
    public String oKW;
    public ArrayList<MallRechargeProduct> oLj = null;
    public String oLk;
    public String oLl;
    public String oLm;
    public String oLn;

    public e(String str) {
        a aVar = new a();
        aVar.hsm = new zy();
        aVar.hsn = new zz();
        aVar.uri = "/cgi-bin/micromsg-bin/getpayfunctionproductlist";
        aVar.hsl = 496;
        aVar.hso = JsApiOpenWeRunSetting.CTRL_INDEX;
        aVar.hsp = 1000000228;
        this.gUA = aVar.BE();
        zy zyVar = (zy) this.gUA.hsj.hsr;
        this.oKW = str;
        zyVar.tAn = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetPayFunctionProductList", "errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            zz zzVar = (zz) ((b) pVar).hsk.hsr;
            String str2 = zzVar.tFl;
            w.d("MicroMsg.NetSceneGetPayFunctionProductList", "resp.ProductList " + str2);
            if (!bg.mA(str2)) {
                try {
                    this.oLj = b.a(this.oKW, new JSONObject(str2).getJSONArray("pay_product_list"));
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", e, "", new Object[0]);
                }
            }
            if (!bg.mA(zzVar.tGh)) {
                try {
                    JSONObject jSONObject = new JSONObject(zzVar.tGh);
                    this.oLk = jSONObject.optString("balance_link");
                    this.oLm = jSONObject.optString("recharge_link");
                    this.oLl = jSONObject.optString("balance_wording");
                    this.oLn = jSONObject.optString("recharge_wording");
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", e2, "", new Object[0]);
                }
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 496;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
