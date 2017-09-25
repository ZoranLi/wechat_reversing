package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ada;
import com.tencent.mm.protocal.c.adb;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;

public final class e extends k implements j {
    private b gUA = null;
    private com.tencent.mm.y.e gUD = null;
    private ada mPL = null;
    public adb mPM = null;

    public e() {
        a aVar = new a();
        aVar.hsm = new ada();
        aVar.hsn = new adb();
        aVar.hsl = 831;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcopackageproductlist";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.mPL = (ada) this.gUA.hsj.hsr;
        w.i("MicroMsg.NetSceneIPCallGetPackageProductList", "NetSceneIPCallGetPackageProductList");
    }

    public final int getType() {
        return 831;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneIPCallGetPackageProductList", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mPM = (adb) ((b) pVar).hsk.hsr;
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
