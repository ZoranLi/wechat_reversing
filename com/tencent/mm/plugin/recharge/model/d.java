package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.cc;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.c.zb;
import com.tencent.mm.protocal.c.zc;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.List;
import org.json.JSONObject;

public final class d extends k implements j {
    public b gUA;
    private e gUD;
    public String isg;
    public String oKW;
    public String oKX = null;
    public int oLd;
    public MallRechargeProduct oLg = null;
    public List<MallRechargeProduct> oLh = null;
    public String oLi;

    public d(int i, String str, String str2, String str3, String str4, String str5) {
        this.oKW = str;
        this.oLd = i;
        this.isg = str5;
        this.oLi = str2;
        a aVar = new a();
        aVar.hsm = new zb();
        aVar.hsn = new zc();
        aVar.uri = "/cgi-bin/micromsg-bin/getlatestpayproductinfo";
        aVar.hsl = 497;
        aVar.hso = cc.CTRL_INDEX;
        aVar.hsp = 1000000229;
        this.gUA = aVar.BE();
        zb zbVar = (zb) this.gUA.hsj.hsr;
        zbVar.tAn = str;
        zbVar.tAo = str3;
        zbVar.tFj = str2;
        zbVar.tAp = str4;
        zbVar.tuo = c.buC().Ia(str);
        w.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("funcId:%s, appId:%s, productId:%s, remark:%s", new Object[]{str, str3, str2, str4}));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetLatestPayProductInfo", "errCode " + i3 + ", errMsg " + str);
        zc zcVar = (zc) ((b) pVar).hsk.hsr;
        w.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.OurterRemark " + zcVar.tAs);
        String str2 = zcVar.tAs;
        this.oKX = "";
        if (!bg.mA(str2)) {
            String[] split = str2.split("&");
            if (split != null && split.length > 0) {
                Object obj = 1;
                for (String split2 : split) {
                    String[] split3 = split2.split("=");
                    if (split3.length == 2) {
                        if (obj == null) {
                            this.oKX += " ";
                        } else {
                            obj = null;
                        }
                        this.oKX += split3[1];
                    }
                }
            }
        }
        if (!bg.mA(zcVar.tFl)) {
            try {
                this.oLh = b.a(this.oKW, new JSONObject(zcVar.tFl).optJSONArray("product_info"));
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", e, "", new Object[0]);
            }
        }
        if (i2 == 0 && i3 == 0) {
            str2 = zcVar.tFk;
            w.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.Product " + str2);
            if (!bg.mA(str2)) {
                try {
                    this.oLg = b.a(this.oKW, new JSONObject(str2));
                    this.oLg.oKX = this.oKX;
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", e2, "", new Object[0]);
                }
            }
        }
        w.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("OutErrCode : %d ,OutErrMsg : %s , WxErrCode : %d , WxErrMsg : %s", new Object[]{Integer.valueOf(zcVar.tAq), zcVar.tAr, Integer.valueOf(zcVar.tAt), zcVar.tAu}));
        if (i3 == 0) {
            if (zcVar.tAt != 0) {
                i3 = zcVar.tAt;
            } else {
                i3 = zcVar.tAq;
            }
        }
        if (bg.mA(str)) {
            if (bg.mA(zcVar.tAu)) {
                str = zcVar.tAr;
            } else {
                str = zcVar.tAu;
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 497;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
