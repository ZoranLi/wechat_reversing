package com.tencent.mm.plugin.wallet_index.c.b;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.protocal.c.aqd;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;

public final class a extends k {
    private b gUA;
    private e gUD;
    public String rPI;
    public String rPJ;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new aqc();
        aVar.hsn = new aqd();
        aVar.uri = "/cgi-bin/mmpay-bin/payugenprepay";
        aVar.hsl = 1521;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        aqc com_tencent_mm_protocal_c_aqc = (aqc) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aqc.mtb = str;
        com_tencent_mm_protocal_c_aqc.trg = str4;
        com_tencent_mm_protocal_c_aqc.trf = str3;
        com_tencent_mm_protocal_c_aqc.trh = str5;
        com_tencent_mm_protocal_c_aqc.tri = str2;
        com_tencent_mm_protocal_c_aqc.tju = str6;
        com_tencent_mm_protocal_c_aqc.tqx = str7;
        com_tencent_mm_protocal_c_aqc.tBk = str8;
        com_tencent_mm_protocal_c_aqc.tcg = i;
        w.d("MicroMsg.NetScenePayUGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[]{str, str4, str3, str5, str2, str6, str7, str8}));
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.d("MicroMsg.NetScenePayUGenPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        aqd com_tencent_mm_protocal_c_aqd = (aqd) ((b) pVar).hsk.hsr;
        if (i == 0 && i2 == 0) {
            w.d("MicroMsg.NetScenePayUGenPrepay", "rr " + com_tencent_mm_protocal_c_aqd.tBn);
            this.rPI = com_tencent_mm_protocal_c_aqd.tBn;
            this.rPJ = com_tencent_mm_protocal_c_aqd.tBo;
        }
        this.gUD.a(i, i2, com_tencent_mm_protocal_c_aqd.leS, this);
    }

    public final int getType() {
        return 1521;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
