package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.protocal.c.ti;
import com.tencent.mm.protocal.c.tj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;

public final class a extends k {
    private b gUA;
    private e gUD;
    public String rPI;
    public String rPJ;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new ti();
        aVar.hsn = new tj();
        aVar.uri = "/cgi-bin/mmpay-bin/genprepay";
        aVar.hsl = 398;
        aVar.hso = com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k.CTRL_BYTE;
        aVar.hsp = 1000000189;
        this.gUA = aVar.BE();
        c blU = com.tencent.mm.plugin.soter.c.b.blU();
        String str9 = blU.qPZ;
        String str10 = blU.qQa;
        ti tiVar = (ti) this.gUA.hsj.hsr;
        tiVar.mtb = str;
        tiVar.trg = str4;
        tiVar.trf = str3;
        tiVar.trh = str5;
        tiVar.tri = str2;
        tiVar.tju = str6;
        tiVar.tqx = str7;
        tiVar.tBk = str8;
        tiVar.tcg = i;
        tiVar.tBm = str9;
        tiVar.tBl = str10;
        tiVar.tnu = h.btK();
        if (i2 > 0) {
            tiVar.tdM = i2;
        }
        w.d("MicroMsg.NetSceneGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s", new Object[]{str, str4, str3, str5, str2, str6, str7, str8, Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.d("MicroMsg.NetSceneGenPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        tj tjVar = (tj) ((b) pVar).hsk.hsr;
        w.i("MicroMsg.NetSceneGenPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[]{Integer.valueOf(tjVar.leR), tjVar.leS});
        if (i == 0 && i2 == 0) {
            w.d("MicroMsg.NetSceneGenPrepay", "rr " + tjVar.tBn);
            this.rPI = tjVar.tBn;
            this.rPJ = tjVar.tBo;
        }
        String str2 = tjVar.leS;
        this.gUD.a(i, tjVar.leR, str2, this);
    }

    public final int getType() {
        return 398;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
