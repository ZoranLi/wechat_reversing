package com.tencent.mm.plugin.address.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ny;
import com.tencent.mm.protocal.c.nz;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    private b gUA;
    private e gUD;

    public a(int i) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new ny();
        aVar.hsn = new nz();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo";
        aVar.hsl = 1194;
        this.gUA = aVar.BE();
        ny nyVar = (ny) this.gUA.hsj.hsr;
        nyVar.ttE = "invoice_info";
        nyVar.ttF = i;
        nyVar.cGa = 2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneDeleteUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            w.i("MicroMsg.NetSceneDeleteUserAutoFillInfo", "");
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1194;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
