package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.xf;
import com.tencent.mm.protocal.c.xg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class n extends k implements j {
    public String country;
    private b gUA;
    private e gUD;
    public String gkB;
    public String gkC;

    public n(double d, double d2) {
        a aVar = new a();
        aVar.hsm = new xf();
        aVar.hsn = new xg();
        aVar.uri = "/cgi-bin/micromsg-bin/getcurlocation";
        aVar.hsl = 665;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        xf xfVar = (xf) this.gUA.hsj.hsr;
        xfVar.tle = d;
        xfVar.tld = d2;
        w.d("MicroMsg.NetSceneGetCurLocation", "latitude:" + d + ", longitude:" + d2);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 665;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetCurLocation", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            xg xgVar = (xg) this.gUA.hsk.hsr;
            this.gkC = xgVar.hAF;
            this.country = xgVar.hAM;
            this.gkB = xgVar.hAE;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
