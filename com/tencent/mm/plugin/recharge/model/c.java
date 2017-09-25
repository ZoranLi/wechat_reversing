package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.si;
import com.tencent.mm.protocal.c.sj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c extends k implements j {
    public String fOI;
    public b gUA;
    private e gUD;
    public String kSV;

    public c(String str, String str2, String str3, String str4, String str5) {
        this.fOI = str2;
        this.kSV = str3;
        a aVar = new a();
        aVar.hsm = new si();
        aVar.hsn = new sj();
        aVar.uri = "/cgi-bin/mmpay-bin/flowdatarechargepreinquery";
        aVar.hsl = 1555;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        si siVar = (si) this.gUA.hsj.hsr;
        siVar.tAn = str;
        siVar.tjy = str2;
        siVar.ohr = str3;
        siVar.tAo = str4;
        siVar.tAp = str5;
        siVar.tuo = com.tencent.mm.plugin.wallet_core.model.mall.c.buC().Ia(str);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneFlowDataRechargePreinQuery", "errCode " + i3 + ", errMsg " + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1555;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
