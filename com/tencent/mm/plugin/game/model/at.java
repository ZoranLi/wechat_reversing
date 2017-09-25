package com.tencent.mm.plugin.game.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.c.ar;
import com.tencent.mm.plugin.game.c.as;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class at extends k implements j {
    private e gUD;
    public final b ldw;

    public at(int i, int i2, int i3) {
        w.i("MicroMsg.NetSceneGetMoreGameList", "offset: %d, limit: %d, type: %d, cat: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(15), Integer.valueOf(i2), Integer.valueOf(i3)});
        a aVar = new a();
        aVar.hsm = new ar();
        aVar.hsn = new as();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetmoregamelist";
        aVar.hsl = 1220;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.ldw = aVar.BE();
        ar arVar = (ar) this.ldw.hsj.hsr;
        arVar.muw = i;
        arVar.mux = 15;
        arVar.mtJ = v.bIN();
        arVar.muE = i2;
        arVar.muF = i3;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.ldw, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetMoreGameList", "errType = " + i2 + ", errCode = " + i3);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1220;
    }
}
