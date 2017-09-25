package com.tencent.mm.modelappbrand;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.fn;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class j extends k implements com.tencent.mm.network.j {
    private e gWW;
    private final b hpV;

    public j(LinkedList<bek> linkedList) {
        a aVar = new a();
        aVar.hsm = new fn();
        aVar.hsn = new fo();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchswitchservicenotifyoption";
        this.hpV = aVar.BE();
        ((fn) this.hpV.hsj.hsr).tjc = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gWW != null) {
            this.gWW.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1176;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "doScene");
        this.gWW = eVar2;
        return a(eVar, this.hpV, this);
    }
}
