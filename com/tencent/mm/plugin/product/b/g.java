package com.tencent.mm.plugin.product.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bz;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.protocal.c.yz;
import com.tencent.mm.protocal.c.za;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class g extends k implements j {
    private b gUA;
    private e gUD;
    public LinkedList<qe> opi;
    public String opq;

    public g(String str, String str2, bz bzVar) {
        a aVar = new a();
        aVar.hsm = new yz();
        aVar.hsn = new za();
        aVar.uri = "/cgi-bin/micromsg-bin/getlastestexpressinfo";
        aVar.hsl = 578;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        yz yzVar = (yz) this.gUA.hsj.hsr;
        this.opq = str;
        yzVar.tmj = str;
        w.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "pid " + str);
        yzVar.tnq = str2;
        yzVar.tFg = bzVar;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        za zaVar = (za) ((b) pVar).hsk.hsr;
        if (i2 == 0 && i3 == 0 && zaVar.tnr == 0) {
            w.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "resp.ExpressCount " + zaVar.tFi);
            this.opi = zaVar.tFh;
        }
        if (i3 == 0 && zaVar.tnr != 0) {
            i3 = zaVar.tnr;
            str = zaVar.tns;
        }
        w.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "errCode " + i3 + ", errMsg " + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 578;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
