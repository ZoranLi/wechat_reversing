package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.protocal.c.wb;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class z extends k implements j {
    private final b gUA;
    private e gUD;
    public CardGiftInfo kfJ;

    public z(int i, String str) {
        a aVar = new a();
        aVar.hsm = new wa();
        aVar.hsn = new wb();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardgiftinfo";
        aVar.hsl = 1165;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        wa waVar = (wa) this.gUA.hsj.hsr;
        waVar.tcU = i;
        waVar.tcV = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetCardGiftInfo", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.kfJ = CardGiftInfo.a((wb) this.gUA.hsk.hsr);
            w.d("MicroMsg.NetSceneGetCardGiftInfo", "%s", new Object[]{this.kfJ.toString()});
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1165;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
