package com.tencent.mm.plugin.game.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aww;
import com.tencent.mm.protocal.c.awx;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class aw extends k implements j {
    private e gUD;
    final b ldw;

    public aw(int i, int i2) {
        w.i("MicroMsg.NetSceneSearchGameList", "offset: %d, limit: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        a aVar = new a();
        aVar.hsm = new aww();
        aVar.hsn = new awx();
        aVar.uri = "/cgi-bin/mmgame-bin/searchgamelist";
        aVar.hsl = 1215;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.ldw = aVar.BE();
        aww com_tencent_mm_protocal_c_aww = (aww) this.ldw.hsj.hsr;
        com_tencent_mm_protocal_c_aww.muw = i;
        com_tencent_mm_protocal_c_aww.mux = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.ldw, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneSearchGameList", "errType = " + i2 + ", errCode = " + i3);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1215;
    }
}
