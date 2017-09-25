package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.cn;
import com.tencent.mm.protocal.c.co;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class x extends k implements j {
    private b gUA;
    private e gUD;
    int sDD;
    w sDE;

    public x(int i, w wVar) {
        this.sDD = i;
        a aVar = new a();
        aVar.hsm = new cn();
        aVar.hsn = new co();
        aVar.uri = "/cgi-bin/micromsg-bin/appcenter";
        this.gUA = aVar.BE();
        cn cnVar = (cn) this.gUA.hsj.hsr;
        byte[] aBv = wVar.aBv();
        if (aBv != null) {
            cnVar.tfG = new avw().bb(aBv);
        }
        cnVar.jOc = i;
        this.sDE = wVar;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneAppCenter", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            this.sDE.ar(n.a(((co) this.gUA.hsk.hsr).tfH));
            this.sDE.a(i, i2, i3, str, this.gUA, bArr);
            this.gUD.a(i2, i3, str, this);
            return;
        }
        w.e("MicroMsg.NetSceneAppCenter", "errType = " + i2 + ", errCode = " + i3);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 452;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
