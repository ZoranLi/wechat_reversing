package com.tencent.mm.modelappbrand;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.abb;
import com.tencent.mm.protocal.c.abc;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class k extends com.tencent.mm.y.k implements j {
    private e gWW;
    public final b hpV;

    public k(int i) {
        a aVar = new a();
        aVar.hsm = new abb();
        aVar.hsn = new abc();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getservicenotifyoptions";
        this.hpV = aVar.BE();
        ((abb) this.hpV.hsj.hsr).tHa = i;
    }

    public final abc AR() {
        if (this.hpV == null) {
            return null;
        }
        return (abc) this.hpV.hsk.hsr;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gWW != null) {
            this.gWW.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1145;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
        this.gWW = eVar2;
        return a(eVar, this.hpV, this);
    }
}
