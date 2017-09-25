package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.vq;
import com.tencent.mm.protocal.c.vr;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d extends k implements j {
    private final b gUA;
    private e gUD;

    public d() {
        a aVar = new a();
        aVar.hsm = new vq();
        aVar.hsn = new vr();
        aVar.uri = "/cgi-bin/micromsg-bin/getbottlecount";
        aVar.hsl = com.tencent.mm.plugin.appbrand.jsapi.contact.b.CTRL_INDEX;
        aVar.hso = 49;
        aVar.hsp = 1000000049;
        aVar.hsq = false;
        this.gUA = aVar.BE();
        vq vqVar = (vq) this.gUA.hsj.hsr;
        vqVar.jNj = m.xL();
        vqVar.tCR = (int) bg.Ny();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.contact.b.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        vr vrVar = (vr) this.gUA.hsk.hsr;
        if (i2 == 0 && i3 == 0) {
            c.jP(vrVar.tCT);
            c.jO(vrVar.tCS);
        } else if (vrVar.thX == -2002 || vrVar.thX == -56) {
            c.jP(0);
            c.jO(0);
        }
        w.d("MicroMsg.NetSceneGetBottleCount", "onGYNetEnd type:" + i2 + " code:" + i3 + " ret:" + vrVar.thX + " pickCnt:" + vrVar.tCT + " throwCnt:" + vrVar.tCS);
        this.gUD.a(0, vrVar.thX, str, this);
    }
}
