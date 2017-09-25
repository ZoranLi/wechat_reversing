package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aax;
import com.tencent.mm.protocal.c.aay;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class s extends k implements j {
    private e gUD;
    public final b hRS;

    public s() {
        a aVar = new a();
        aVar.hsm = new aax();
        aVar.hsn = new aay();
        aVar.uri = "/cgi-bin/micromsg-bin/getresourcecontrolinfo";
        this.hRS = aVar.BE();
        ((aax) this.hRS.hsj.hsr).jOc = 0;
        w.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo type[%d], stack[%s]", Integer.valueOf(0), bg.bJZ());
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            g.oUh.a(405, 2, 1, true);
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 725;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        g.oUh.a(405, 1, 1, true);
        return a(eVar, this.hRS, this);
    }
}
