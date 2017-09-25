package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.al;
import com.tencent.mm.protocal.c.am;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class q extends k implements j {
    private final b gUA;
    private e gUD;
    public CardGiftInfo kfJ;

    public q(int i, String str, String str2) {
        a aVar = new a();
        aVar.hsm = new al();
        aVar.hsn = new am();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptgiftcard";
        aVar.hsl = 1136;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        al alVar = (al) this.gUA.hsj.hsr;
        alVar.tcU = i;
        alVar.tcV = str;
        alVar.tcW = str2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.kfJ = CardGiftInfo.a((am) this.gUA.hsk.hsr);
            w.d("MicroMsg.NetSceneAcceptGiftCard", "%s", new Object[]{this.kfJ.toString()});
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1136;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
