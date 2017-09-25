package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.protocal.c.ku;
import com.tencent.mm.protocal.c.kv;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;

public final class a extends k {
    private b gUA;
    private e gUD;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new ku();
        aVar.hsn = new kv();
        aVar.uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
        aVar.hsl = 580;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ku kuVar = (ku) this.gUA.hsj.hsr;
        kuVar.mtb = str;
        kuVar.tju = str2;
        kuVar.trf = str3;
        kuVar.trg = str4;
        kuVar.tri = str5;
        kuVar.trh = str6;
        kuVar.tqx = str7;
        kuVar.trj = i;
        kuVar.tnu = h.btK();
        if (n.ccc()) {
            kuVar.trk = n.cce();
        }
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(str, str2, str3, str4, str5, str6, str7, 1);
    }

    public final int getType() {
        return 580;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.d("MicroMsg.NetSceneCheckPayJsapi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            kv kvVar = (kv) ((b) pVar).hsk.hsr;
            w.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + kvVar.leR + " resp.ErrMsg is " + kvVar.leS);
            str = kvVar.leS;
        }
        this.gUD.a(i, i2, str, this);
    }

    public final String aQZ() {
        return ((kv) this.gUA.hsk.hsr).token;
    }
}
