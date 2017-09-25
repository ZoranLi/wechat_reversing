package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.qx;
import com.tencent.mm.protocal.c.qy;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c extends k implements j {
    public String fJH;
    private e gUD;
    private b inV;
    private qx njF;
    private qy njG;

    public c(int i, int i2, int i3, int i4) {
        a aVar = new a();
        aVar.hsm = new qx();
        aVar.hsn = new qy();
        aVar.hsl = 1970;
        aVar.hso = 0;
        aVar.hsp = 0;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffrequestwxhb";
        this.inV = aVar.BE();
        this.njF = (qx) this.inV.hsj.hsr;
        this.njF.kAx = i;
        this.njF.orq = i2;
        this.njF.nme = i3;
        this.njF.twA = i4;
        at btK = h.btK();
        if (btK != null) {
            this.njF.latitude = btK.latitude;
            this.njF.longitude = btK.longitude;
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("NetSceneF2FLuckyMoneyPrepare", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.njG = (qy) ((b) pVar).hsk.hsr;
        this.fJH = this.njG.nnL;
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1970;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.inV, this);
    }
}
