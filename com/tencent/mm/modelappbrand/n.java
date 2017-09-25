package com.tencent.mm.modelappbrand;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bqt;
import com.tencent.mm.protocal.c.bqu;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class n extends k implements j {
    private e gWW;
    public final b hpV;

    public n(String str) {
        a aVar = new a();
        aVar.hsm = new bqt();
        aVar.hsn = new bqu();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxatmplcomplaint";
        this.hpV = aVar.BE();
        ((bqt) this.hpV.hsj.hsr).uoP = str;
    }

    public final int getType() {
        return 1198;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gWW != null) {
            this.gWW.a(i2, i3, str, this);
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
        this.gWW = eVar2;
        return a(eVar, this.hpV, this);
    }
}
