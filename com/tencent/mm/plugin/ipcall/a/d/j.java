package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bmd;
import com.tencent.mm.protocal.c.bme;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class j extends k implements com.tencent.mm.network.j {
    private b gUA = null;
    private e gUD = null;
    public bmd mPW = null;
    public bme mPX = null;

    public j(String str) {
        a aVar = new a();
        aVar.hsm = new bmd();
        aVar.hsn = new bme();
        aVar.hsl = 277;
        aVar.uri = "/cgi-bin/micromsg-bin/wcopurchasepackage";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.mPW = (bmd) this.gUA.hsj.hsr;
        this.mPW.tgW = str;
        w.i("MicroMsg.NetSceneIPCallPurchasePackage", "NetSceneIPCallPurchasePackage ProductID:%s", new Object[]{this.mPW.tgW});
    }

    public final int getType() {
        return 277;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneIPCallPurchasePackage", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mPX = (bme) ((b) pVar).hsk.hsr;
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
