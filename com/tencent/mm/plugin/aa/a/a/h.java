package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.l;
import com.tencent.mm.protocal.c.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class h extends k implements j {
    private e gUD;
    private b inV;
    private l ioc;
    public m iod;

    public h() {
        a aVar = new a();
        aVar.hsm = new l();
        aVar.hsn = new m();
        aVar.hsl = 1698;
        aVar.uri = "/cgi-bin/mmpay-bin/newaaoperation";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.inV = aVar.BE();
        this.ioc = (l) this.inV.hsj.hsr;
    }

    public final int getType() {
        return 1698;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.inV, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneAAOperation", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.iod = (m) ((b) pVar).hsk.hsr;
        if (i2 == 0 && i3 == 0) {
            w.i("MicroMsg.NetSceneAAOperation", "retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[]{Integer.valueOf(this.iod.kAC), this.iod.kAD, Integer.valueOf(this.iod.tbv), Integer.valueOf(this.iod.tbw), Integer.valueOf(this.iod.tbx), Long.valueOf(this.iod.tby), Long.valueOf(this.iod.tbz), this.iod.kAO, this.iod.kAP});
        }
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
