package com.tencent.mm.plugin.game.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.c.al;
import com.tencent.mm.plugin.game.c.am;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class ap extends k implements j {
    private e gUD;
    public final b ldw;

    public ap(String str, String str2, boolean z) {
        a aVar = new a();
        aVar.hsm = new al();
        aVar.hsn = new am();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetgamedetail";
        aVar.hsl = 1217;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.ldw = aVar.BE();
        al alVar = (al) this.ldw.hsj.hsr;
        alVar.mtJ = str;
        alVar.msh = str2;
        alVar.mtR = z;
        alVar.mtT = true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.ldw, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetGameDetailNew", "errType = " + i2 + ", errCode = " + i3);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1217;
    }
}
