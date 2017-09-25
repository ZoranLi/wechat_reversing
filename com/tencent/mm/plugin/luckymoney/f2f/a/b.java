package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.aua;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.protocal.c.qu;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    public int boy;
    public int fFG;
    public int fZG;
    private e gUD;
    private com.tencent.mm.y.b inV;
    public int njA;
    public String njB;
    public String njC;
    public String njD;
    public int njE;
    private qt nju;
    private qu njv;
    public String njw;
    public int njx;
    public String njy;
    public aua njz;

    public b(String str) {
        a aVar = new a();
        aVar.hsm = new qt();
        aVar.hsn = new qu();
        aVar.hsl = 1997;
        aVar.hso = 0;
        aVar.hsp = 0;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffopenwxhb";
        this.inV = aVar.BE();
        this.nju = (qt) this.inV.hsj.hsr;
        this.nju.lfx = str;
        at btK = h.btK();
        if (btK != null) {
            this.nju.gkC = btK.gkC;
            this.nju.gkB = btK.gkB;
            this.nju.twt = btK.tdX;
            this.nju.twu = btK.tdY;
            this.nju.twv = btK.tdW;
            this.nju.tww = btK.latitude;
            this.nju.twx = btK.longitude;
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.njv = (qu) ((com.tencent.mm.y.b) pVar).hsk.hsr;
        w.i("NetSceneF2FLuckyMoneyOpen", "errType %d, retCode %d, retMsg %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.njv.kAC), this.njv.kAD});
        this.njw = this.njv.njw;
        this.fZG = this.njv.fZG;
        this.njx = this.njv.fZH;
        this.fFG = this.njv.fFG;
        this.njy = this.njv.nmD;
        this.boy = this.njv.boy;
        this.njz = this.njv.twy;
        this.njA = this.njv.njA;
        this.njB = this.njv.njB;
        this.njC = this.njv.njC;
        this.njD = this.njv.njD;
        this.njE = this.njv.njE;
        if (this.gUD != null) {
            this.gUD.a(i2, this.njv.kAC, this.njv.kAD, this);
        }
    }

    public final int getType() {
        return 1997;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.inV, this);
    }
}
