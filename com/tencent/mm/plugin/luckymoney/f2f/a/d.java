package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.qw;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d extends k implements j {
    private e gUD;
    private b inV;
    public String lfx;
    private qv njH;
    private qw njI;
    public String njJ;
    public String njK;
    public int njL;
    public String njw;

    public d() {
        a aVar = new a();
        aVar.hsm = new qv();
        aVar.hsn = new qw();
        aVar.hsl = 1990;
        aVar.hso = 0;
        aVar.hsp = 0;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffquerydowxhb";
        this.inV = aVar.BE();
        this.njH = (qv) this.inV.hsj.hsr;
        this.njH.timestamp = System.currentTimeMillis() / 1000;
        at btK = h.btK();
        if (btK != null) {
            this.njH.latitude = btK.latitude;
            this.njH.longitude = btK.longitude;
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("NetSceneF2FLuckyMoneyQuery", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.njI = (qw) ((b) pVar).hsk.hsr;
        this.njw = this.njI.njw;
        this.lfx = this.njI.lfx;
        this.njL = this.njI.twz;
        this.njJ = this.njI.njJ;
        this.njK = this.njI.njK;
        if (this.gUD != null) {
            this.gUD.a(i2, this.njI.kAC, this.njI.kAD, this);
        }
    }

    public final int getType() {
        return 1990;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.inV, this);
    }
}
