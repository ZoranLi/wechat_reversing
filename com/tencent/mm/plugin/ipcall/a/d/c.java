package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.acw;
import com.tencent.mm.protocal.c.acx;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c extends k implements j {
    private b gUA = null;
    private e gUD = null;
    private acw mPH = null;
    public acx mPI = null;

    public c() {
        a aVar = new a();
        aVar.hsm = new acw();
        aVar.hsn = new acx();
        aVar.hsl = 746;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcocallinfo";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.mPH = (acw) this.gUA.hsj.hsr;
        w.i("MicroMsg.NetSceneIPCallGetCallInfo", "NetSceneIPCallGetCallInfo");
    }

    public final int getType() {
        return 746;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneIPCallGetCallInfo", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mPI = (acx) ((b) pVar).hsk.hsr;
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
