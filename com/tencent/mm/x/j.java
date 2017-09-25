package com.tencent.mm.x;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.afw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.fe;
import com.tencent.mm.protocal.c.ff;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class j extends k implements com.tencent.mm.network.j {
    private e gUD;
    LinkedList<avx> hrF = null;
    LinkedList<afw> hrG = null;

    public j(LinkedList<avx> linkedList) {
        this.hrF = linkedList;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.hrF == null || this.hrF.size() <= 0) {
            w.e("MicroMsg.NetSceneBatchGetHeadImg", g.sd() + "doScene ReqSize==0");
            return -1;
        }
        this.gUD = eVar2;
        a aVar = new a();
        aVar.hsm = new fe();
        aVar.hsn = new ff();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
        aVar.hsl = 123;
        aVar.hso = 15;
        aVar.hsp = 1000000015;
        p BE = aVar.BE();
        fe feVar = (fe) BE.hsj.hsr;
        feVar.tiO = this.hrF;
        feVar.jNd = this.hrF.size();
        return a(eVar, BE, this);
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final int ub() {
        return 20;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneBatchGetHeadImg", "errType:" + i2 + " errCode:" + i3);
        this.hrG = ((ff) ((b) pVar).hsk.hsr).tiR;
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 123;
    }
}
