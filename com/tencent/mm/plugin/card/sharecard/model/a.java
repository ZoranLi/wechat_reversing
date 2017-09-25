package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.protocal.c.nq;
import com.tencent.mm.protocal.c.nr;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    private String fVl = "";
    private final b gUA;
    private e gUD;
    public int kfH;

    public a(String str) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new nq();
        aVar.hsn = new nr();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/delsharecard";
        aVar.hsl = 1163;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((nq) this.gUA.hsj.hsr).fVl = str;
        this.fVl = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneDelShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(1163), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            nr nrVar = (nr) this.gUA.hsk.hsr;
            w.i("MicroMsg.NetSceneDelShareCard", "ret_code:" + nrVar.kfH);
            this.kfH = nrVar.kfH;
            if (this.kfH == 0) {
                al.agi().sG(this.fVl);
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1163;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
