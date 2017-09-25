package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.acy;
import com.tencent.mm.protocal.c.acz;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d extends k implements j {
    private b gUA = null;
    private e gUD;
    private acy mPJ = null;
    public acz mPK = null;

    public d() {
        a aVar = new a();
        aVar.hsm = new acy();
        aVar.hsn = new acz();
        aVar.hsl = 288;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcogiftcardlist";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.mPJ = (acy) this.gUA.hsj.hsr;
        w.i("MicroMsg.NetSceneIPCallGetGiftCardList", "NetSceneIPCallGetGiftCardList");
    }

    public final int getType() {
        return 288;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneIPCallGetGiftCardList", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mPK = (acz) ((b) pVar).hsk.hsr;
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
