package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.n;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class i extends k implements j {
    private e gUD;
    private b inV;
    private n ioe;
    public o iof;

    public i(String str, long j, int i, String str2) {
        a aVar = new a();
        aVar.hsm = new n();
        aVar.hsn = new o();
        aVar.hsl = 1629;
        aVar.uri = "/cgi-bin/mmpay-bin/newaapay";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.inV = aVar.BE();
        this.ioe = (n) this.inV.hsj.hsr;
        this.ioe.tbh = str;
        this.ioe.tbA = j;
        this.ioe.scene = i;
        this.ioe.tbi = str2;
        w.i("MicroMsg.NetSceneAAPay", "NetSceneAAPay, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s", new Object[]{this.ioe.tbh, Long.valueOf(this.ioe.tbA), Integer.valueOf(this.ioe.scene), this.ioe.tbi});
    }

    public final int getType() {
        return 1629;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.inV, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneAAPay", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.iof = (o) ((b) pVar).hsk.hsr;
        w.i("MicroMsg.NetSceneAAPay", "retcode: %s, retmsg: %s, paymsgid:%s", new Object[]{Integer.valueOf(this.iof.kAC), this.iof.kAD, this.iof.fSQ});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
