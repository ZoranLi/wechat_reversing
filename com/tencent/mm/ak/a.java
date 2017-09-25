package com.tencent.mm.ak;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.gb;
import com.tencent.mm.protocal.c.gc;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    private final b gUA;
    private e gUD;

    public a(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new gb();
        aVar.hsn = new gc();
        aVar.uri = "/cgi-bin/micromsg-bin/bindlinkedincontact";
        aVar.hsl = 549;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        gb gbVar = (gb) this.gUA.hsj.hsr;
        gbVar.thO = 1;
        gbVar.tjq = i;
        gbVar.tjr = str;
        gbVar.tjs = str2;
        gbVar.tjt = str3;
        gbVar.tju = str4;
        gbVar.tjv = str5;
        gbVar.tjw = str6;
        gbVar.tjx = str7;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 549;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneBindLinkedinContact", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        gb gbVar = (gb) this.gUA.hsj.hsr;
        if (i2 == 0 && i3 == 0) {
            ap.yY();
            c.vr().set(286722, gbVar.tjs);
            ap.yY();
            c.vr().set(286721, gbVar.tjr);
            ap.yY();
            c.vr().set(286723, gbVar.tjt);
        }
        this.gUD.a(i2, i3, str, this);
    }
}
