package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.yf;
import com.tencent.mm.protocal.c.yg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class ae extends k implements j {
    private final b gUA;
    private e gUD = null;

    public ae() {
        a aVar = new a();
        aVar.hsm = new yf();
        aVar.hsn = new yg();
        aVar.uri = "/cgi-bin/micromsg-bin/getfavinfo";
        aVar.hsl = 438;
        aVar.hso = com.tencent.mm.plugin.appbrand.jsapi.e.b.CTRL_INDEX;
        aVar.hsp = 1000000217;
        this.gUA = aVar.BE();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetFavInfo", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            yg ygVar = (yg) ((b) pVar).hsk.hsr;
            w.v("MicroMsg.NetSceneGetFavInfo", "used:%d  total:%d  mxDown:%d  mxUp:%d  mxFile:%d", new Object[]{Long.valueOf(ygVar.tfa), Long.valueOf(ygVar.jNA), Integer.valueOf(ygVar.tEJ), Integer.valueOf(ygVar.tEI), Integer.valueOf(ygVar.tEH)});
            x.cb(ygVar.tfa);
            x.cc(ygVar.jNA);
            x.cd((long) ygVar.tEJ);
            x.ce((long) ygVar.tEI);
            x.cf((long) ygVar.tEH);
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 438;
    }
}
