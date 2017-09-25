package com.tencent.mm.plugin.game.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.ag;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class al extends k implements j {
    private e gUD;
    public final b ldw;

    public al(String str) {
        this(str, 0, 0);
    }

    public al(String str, int i, int i2) {
        a aVar = new a();
        aVar.hsm = new af();
        aVar.hsn = new ag();
        aVar.uri = "/cgi-bin/mmgame-bin/gamemsgblock";
        aVar.hsl = 1221;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.ldw = aVar.BE();
        af afVar = (af) this.ldw.hsj.hsr;
        afVar.msh = str;
        afVar.mtC = i;
        afVar.mtD = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.ldw, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGameMsgBlock", "errType = " + i2 + ", errCode = " + i3);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1221;
    }
}
