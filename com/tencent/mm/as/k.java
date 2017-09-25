package com.tencent.mm.as;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bow;
import com.tencent.mm.protocal.c.box;
import com.tencent.mm.protocal.c.ma;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import java.util.List;

public final class k extends com.tencent.mm.y.k implements j {
    private e gUD;
    private b hKp;
    bow hQi = new bow();
    box hQj;

    public k(List<String> list, int i, long j, List<ma> list2) {
        a aVar = new a();
        aVar.hsl = 1948;
        aVar.uri = "/cgi-bin/mmsearch-bin/websearchconfig";
        aVar.hsm = new bow();
        aVar.hsn = new box();
        this.hKp = aVar.BE();
        this.hQi = (bow) this.hKp.hsj.hsr;
        this.hQi.tOk = d.hPo;
        this.hQi.leO = v.ea(ab.getContext());
        this.hQi.tBB = d.Ik();
        this.hQi.tOl = d.AU();
        this.hQi.tdM = i;
        this.hQi.tlY = 0;
    }

    public final int getType() {
        return 1948;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.FTS.NetSceneWebSearchConfig", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.hQj = (box) this.hKp.hsk.hsr;
            if (this.hQj != null) {
                w.v("MicroMsg.FTS.NetSceneWebSearchConfig", "return data\n%s", this.hQj.tlt);
            }
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
