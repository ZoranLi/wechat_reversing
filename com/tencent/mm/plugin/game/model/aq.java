package com.tencent.mm.plugin.game.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.c.aj;
import com.tencent.mm.plugin.game.c.ak;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class aq extends k implements j {
    private e gUD;
    private final b ldw;

    public aq() {
        a aVar = new a();
        aVar.hsm = new aj();
        aVar.hsn = new ak();
        aVar.uri = "/cgi-bin/mmgame-bin/getgamecenterglobalsetting";
        aVar.hsl = 1311;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.ldw = aVar.BE();
        aj ajVar = (aj) this.ldw.hsj.hsr;
        ajVar.mtJ = v.bIN();
        ajVar.hAM = bg.bJW();
        ajVar.mtK = f.fuV;
        w.i("MicroMsg.NetSceneGetGameGlobalConfig", "lang=%s, country=%s, releaseChannel=%s", new Object[]{ajVar.mtJ, ajVar.hAM, Integer.valueOf(ajVar.mtK)});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetGameGlobalConfig", "errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        if (i2 == 0 && i3 == 0) {
            ak akVar = (ak) ((b) pVar).hsk.hsr;
            if (akVar == null) {
                this.gUD.a(i2, i3, str, this);
                return;
            }
            SubCoreGameCenter.aBF().a("pb_game_global_config", akVar);
            g.aAF().OU();
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1311;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.ldw, this);
    }
}
