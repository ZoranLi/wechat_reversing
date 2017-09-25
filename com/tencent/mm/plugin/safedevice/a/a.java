package com.tencent.mm.plugin.safedevice.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.no;
import com.tencent.mm.protocal.c.np;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    private String fwJ;
    private b gUA;
    private e gUD;

    public a(String str) {
        this.fwJ = str;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new no();
        aVar.hsn = new np();
        aVar.uri = "/cgi-bin/micromsg-bin/delsafedevice";
        aVar.hsl = 362;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((no) this.gUA.hsj.hsr).ttx = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, errType= " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            np npVar = (np) this.gUA.hsk.hsr;
            ap.yY();
            c.vr().set(64, Integer.valueOf(npVar.tdE));
            w.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, get safedevice state = " + npVar.tdE);
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 362;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bg.mA(this.fwJ)) {
            w.e("MicroMsg.NetSceneDelSafeDevice", "null device id");
            return -1;
        }
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
