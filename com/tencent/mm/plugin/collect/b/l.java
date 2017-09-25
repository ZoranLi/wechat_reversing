package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.azc;
import com.tencent.mm.protocal.c.azd;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class l extends k implements j {
    private e gUD;
    private b inV;
    private azc kAT;

    public l(String str) {
        a aVar = new a();
        aVar.hsm = new azc();
        aVar.hsn = new azd();
        aVar.hsl = 304;
        aVar.uri = "/cgi-bin/micromsg-bin/setpushsound";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.inV = aVar.BE();
        this.kAT = (azc) this.inV.hsj.hsr;
        this.kAT.jOc = 3;
        this.kAT.uaD = str;
        w.i("MicroMsg.NetSceneSetPushSound", "type: %d, sound: %s", new Object[]{Integer.valueOf(3), str});
    }

    public final int getType() {
        return 304;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.inV, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneSetPushSound", "errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
