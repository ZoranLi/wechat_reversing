package com.tencent.mm.plugin.wallet_index.c.a;

import com.tencent.mm.R;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.protocal.c.apm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;

public final class a extends k {
    private b gUA;
    private e gUD;
    public String jumpUrl;
    public String prepayId;
    public String rPJ;
    public String rPS;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new apl();
        aVar.hsn = new apm();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggenprepay";
        aVar.hsl = 1563;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        apl com_tencent_mm_protocal_c_apl = (apl) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_apl.mtb = str;
        com_tencent_mm_protocal_c_apl.trg = str4;
        com_tencent_mm_protocal_c_apl.trf = str2;
        com_tencent_mm_protocal_c_apl.trh = str5;
        com_tencent_mm_protocal_c_apl.tri = str6;
        com_tencent_mm_protocal_c_apl.tju = str3;
        com_tencent_mm_protocal_c_apl.tqx = str7;
        com_tencent_mm_protocal_c_apl.tBk = str8;
        com_tencent_mm_protocal_c_apl.tcg = i;
        w.d("MicroMsg.NetSceneIbgPayGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[]{str, str4, str2, str5, str6, str3, str7, str8}));
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay raw net errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        apm com_tencent_mm_protocal_c_apm = (apm) ((b) pVar).hsk.hsr;
        if (i == 0 && i2 == 0) {
            w.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_apm.leR), com_tencent_mm_protocal_c_apm.leS});
            str = com_tencent_mm_protocal_c_apm.leS;
            i2 = com_tencent_mm_protocal_c_apm.leR;
            this.jumpUrl = com_tencent_mm_protocal_c_apm.msF;
            this.prepayId = com_tencent_mm_protocal_c_apm.tBn;
            this.rPJ = com_tencent_mm_protocal_c_apm.tBo;
            this.rPS = com_tencent_mm_protocal_c_apm.tUu;
        } else {
            w.e("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url failed");
            this.jumpUrl = null;
        }
        if (bg.mA(str)) {
            str = ab.getContext().getString(R.l.ffj);
        }
        this.gUD.a(i, i2, str, this);
    }

    public final int getType() {
        return 1563;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
