package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.vw;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class x extends k implements j {
    private final b gUA;
    private e gUD;
    private String kfR = "";

    public x() {
        a aVar = new a();
        aVar.hsm = new vw();
        aVar.hsn = new vx();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardconfiginfo";
        aVar.hsl = 692;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final int getType() {
        return 692;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetCardConfigInfo", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            this.kfR = ((vx) this.gUA.hsk.hsr).kfG;
            ap.yY();
            c.vr().set(282885, this.kfR);
        }
        this.gUD.a(i2, i3, str, this);
    }
}
