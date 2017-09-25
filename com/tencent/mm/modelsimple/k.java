package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.pt;
import com.tencent.mm.protocal.c.pu;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class k extends com.tencent.mm.y.k implements j {
    private final b gUA;
    private e gUD;

    public k(String str, int i, String str2) {
        w.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", str, Integer.valueOf(i), str2);
        a aVar = new a();
        aVar.hsm = new pt();
        aVar.hsn = new pu();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/entertempsession";
        this.gUA = aVar.BE();
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        } else if (str2.length() > 32 && i != 19) {
            str2 = str2.substring(0, 32);
        }
        pt ptVar = (pt) this.gUA.hsj.hsr;
        ptVar.tkB = str;
        ptVar.tfW = i;
        ptVar.tvQ = com.tencent.mm.bd.b.NG(str2);
        ptVar.tty = com.tencent.mm.bd.b.aU(new byte[0]);
        w.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", str, Integer.valueOf(i), Integer.valueOf(ptVar.tty.sYA.length));
    }

    public final int getType() {
        return 1066;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneEnterTempSession", "onGYNetEnd: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gUD.a(i2, i3, str, this);
    }
}
