package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.wi;
import com.tencent.mm.protocal.c.wj;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    private final com.tencent.mm.y.b gUA;
    private e gUD;
    public String kfG;
    public String kgX = "";

    public b(double d, double d2, String str) {
        a aVar = new a();
        aVar.hsm = new wi();
        aVar.hsn = new wj();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getcardshomepage";
        aVar.hsl = 1164;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        wi wiVar = (wi) this.gUA.hsj.hsr;
        wiVar.latitude = d;
        wiVar.longitude = d2;
        wiVar.kgX = str;
        ap.yY();
        wiVar.tDc = (String) c.vr().get(w.a.uAH, "");
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneGetCardsHomePageLayout", "red_buff:" + wiVar.tDc);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneGetCardsHomePageLayout", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(1164), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            wj wjVar = (wj) this.gUA.hsk.hsr;
            com.tencent.mm.sdk.platformtools.w.v("MicroMsg.NetSceneGetCardsHomePageLayout", "json:" + wjVar.kfG);
            this.kfG = wjVar.kfG;
            this.kgX = wjVar.kgX;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1164;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
