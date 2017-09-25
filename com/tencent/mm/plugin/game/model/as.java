package com.tencent.mm.plugin.game.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.c.ap;
import com.tencent.mm.plugin.game.c.aq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class as extends k implements j {
    private e gUD;
    public final b ldw;

    public as(int i, LinkedList<String> linkedList, int i2, boolean z) {
        a aVar = new a();
        aVar.hsm = new ap();
        aVar.hsn = new aq();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetlibgamelist";
        aVar.hsl = 1218;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.ldw = aVar.BE();
        ap apVar = (ap) this.ldw.hsj.hsr;
        apVar.muw = i;
        apVar.mux = 15;
        apVar.mtJ = v.bIN();
        apVar.hAM = bg.bJW();
        apVar.muy = i2;
        apVar.mue = linkedList;
        apVar.muz = z;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.ldw, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetLibGameList", "errType = " + i2 + ", errCode = " + i3);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1218;
    }
}
