package com.tencent.mm.plugin.game.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.c.ce;
import com.tencent.mm.plugin.game.c.cf;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class ax extends k implements j {
    private e gUD;
    public final b ldw;

    public ax(String str, String str2, String str3, boolean z) {
        a aVar = new a();
        aVar.hsm = new ce();
        aVar.hsn = new cf();
        aVar.uri = "/cgi-bin/mmgame-bin/newsubscribenewgame";
        aVar.hsl = 1219;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.ldw = aVar.BE();
        ce ceVar = (ce) this.ldw.hsj.hsr;
        ceVar.msh = str;
        ceVar.mtJ = str2;
        ceVar.msg = str3;
        ceVar.msv = z;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.ldw, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGameSubscription", "errType = " + i2 + ", errCode = " + i3);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1219;
    }
}
