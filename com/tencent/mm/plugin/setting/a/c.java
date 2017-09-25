package com.tencent.mm.plugin.setting.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.abx;
import com.tencent.mm.protocal.c.aby;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c extends k implements j {
    private e gUD;

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.hsF = i;
        if (!(i2 == 0 && i3 == 0)) {
            w.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 869;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        a aVar = new a();
        aVar.hsm = new abx();
        aVar.hsn = new aby();
        aVar.uri = "/cgi-bin/micromsg-bin/gettrustedfriends";
        aVar.hsl = 869;
        aVar.hso = 0;
        aVar.hso = 0;
        return a(eVar, aVar.BE(), this);
    }
}
