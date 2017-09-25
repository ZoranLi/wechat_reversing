package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.u;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class j extends k implements com.tencent.mm.network.j {
    private e gUD;
    private b inV;
    private u iog;
    public v ioh;

    public j(String str, int i, String str2, String str3, int i2) {
        a aVar = new a();
        aVar.hsm = new u();
        aVar.hsn = new v();
        aVar.hsl = 1695;
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerydetail";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.inV = aVar.BE();
        this.iog = (u) this.inV.hsj.hsr;
        this.iog.tbh = str;
        this.iog.scene = i;
        this.iog.tbi = str2;
        if (i == 5) {
            w.i("MicroMsg.NetSceneAAQueryDetail", "set sign and ver");
            this.iog.sign = str3;
            this.iog.ver = i2;
        }
        w.i("MicroMsg.NetSceneAAQueryDetail", "NetSceneAAQueryDetail, billNo: %s, scene: %s, groupId: %s", new Object[]{str, Integer.valueOf(i), str2});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneAAQueryDetail", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.ioh = (v) ((b) pVar).hsk.hsr;
        w.i("MicroMsg.NetSceneAAQueryDetail", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.ioh.kAC), this.ioh.kAD});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1695;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.NetSceneAAQueryDetail", "doScene");
        this.gUD = eVar2;
        return a(eVar, this.inV, this);
    }
}
