package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.jh;
import com.tencent.mm.protocal.c.ji;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class h extends k implements j {
    private e gUD;
    private b inV;
    public ji kAA;

    public h() {
        a aVar = new a();
        aVar.hsm = new jh();
        aVar.hsn = new ji();
        aVar.hsl = 1256;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fannounce";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.inV = aVar.BE();
        w.d("MicroMsg.NetSceneF2fAnnouce", "do cgi");
    }

    public final int getType() {
        return 1256;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.inV, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneF2fAnnouce", "errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.kAA = (ji) ((b) pVar).hsk.hsr;
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
