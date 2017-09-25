package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;

public final class e extends k implements j {
    private com.tencent.mm.y.e gUD;
    private b inV;
    private d inW;
    public com.tencent.mm.protocal.c.e inX;
    public int scene;

    public e(String str, int i, String str2) {
        a aVar = new a();
        aVar.hsm = new d();
        aVar.hsn = new com.tencent.mm.protocal.c.e();
        aVar.hsl = 1530;
        aVar.uri = "/cgi-bin/mmpay-bin/newaaclose";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.inV = aVar.BE();
        this.inW = (d) this.inV.hsj.hsr;
        this.inW.tbi = str2;
        this.inW.tbh = str;
        this.inW.scene = i;
        this.scene = i;
        w.d("MicroMsg.NetSceneAAClose", "NetSceneAAClose, billNo: %s, scene: %s", new Object[]{this.inW.tbh, Integer.valueOf(i)});
    }

    public final int getType() {
        return 1530;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        w.i("MicroMsg.NetSceneAAClose", "doScene");
        this.gUD = eVar2;
        return a(eVar, this.inV, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneAAClose", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.inX = (com.tencent.mm.protocal.c.e) ((b) pVar).hsk.hsr;
        w.i("MicroMsg.NetSceneAAClose", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.inX.kAC), this.inX.kAD});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
