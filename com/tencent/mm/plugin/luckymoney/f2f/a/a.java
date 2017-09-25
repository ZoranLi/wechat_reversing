package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.qr;
import com.tencent.mm.protocal.c.qs;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    private e gUD;
    private b inV;
    private qr njs;
    private qs njt;

    public a(String str) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new qr();
        aVar.hsn = new qs();
        aVar.hsl = 1987;
        aVar.hso = 0;
        aVar.hsp = 0;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffclearwxhb";
        this.inV = aVar.BE();
        this.njs = (qr) this.inV.hsj.hsr;
        this.njs.njw = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.njt = (qs) ((b) pVar).hsk.hsr;
        w.i("NetSceneF2FLuckyMoneyClear", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.njt.kAC), this.njt.kAD});
        if (this.gUD != null) {
            this.gUD.a(i2, this.njt.kAC, this.njt.kAD, this);
        }
    }

    public final int getType() {
        return 1987;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.inV, this);
    }
}
