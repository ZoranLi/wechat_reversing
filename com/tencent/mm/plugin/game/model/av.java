package com.tencent.mm.plugin.game.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.c.ah;
import com.tencent.mm.plugin.game.c.ai;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class av extends k implements j {
    private e gUD;
    private final b ldw;

    public av(String str, int i, int i2, String str2, String str3) {
        a aVar = new a();
        aVar.hsm = new ah();
        aVar.hsn = new ai();
        aVar.uri = "/cgi-bin/mmgame-bin/gamereport";
        aVar.hsl = 1223;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.ldw = aVar.BE();
        ah ahVar = (ah) this.ldw.hsj.hsr;
        ahVar.msh = str;
        ahVar.mtF = i;
        ahVar.mtG = i2;
        ahVar.mtH = str2;
        ahVar.mtI = str3;
        ahVar.mtE = (int) (System.currentTimeMillis() / 1000);
    }

    public final int getType() {
        return 1223;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.ldw, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetGameIndex", "errType = " + i2 + ", errCode = " + i3);
        this.gUD.a(i2, i3, str, this);
    }
}
