package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.js;
import com.tencent.mm.protocal.c.jt;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    private e gUD;
    private b inV;
    private js oQj;

    public a(String str, String str2, String str3, String str4, int i) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new js();
        aVar.hsn = new jt();
        aVar.hsl = 1273;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fpaycheck";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.inV = aVar.BE();
        this.oQj = (js) this.inV.hsj.hsr;
        this.oQj.tpE = str;
        this.oQj.tpF = str2;
        this.oQj.tpG = str3;
        this.oQj.tpH = str4;
        this.oQj.boy = i;
        w.d("MicroMsg.NetSceneF2fPayCheck", "NetSceneF2fPayCheck, f2fId: %s, transId: %s, extendStr: %s, amount: %s", new Object[]{str, str2, str3, Integer.valueOf(i)});
    }

    public final int getType() {
        return 1273;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.inV, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
