package com.tencent.mm.plugin.label.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.nf;
import com.tencent.mm.protocal.c.ng;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    private final com.tencent.mm.y.b gUA;
    private e gUD;
    public String mYV = null;

    public b(String str) {
        a aVar = new a();
        aVar.hsm = new nf();
        aVar.hsn = new ng();
        aVar.uri = "/cgi-bin/micromsg-bin/delcontactlabel";
        aVar.hsl = 636;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.mYV = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.Label.NetSceneDelContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 636;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        nf nfVar = (nf) this.gUA.hsj.hsr;
        nfVar.tts = this.mYV;
        if (this.mYV == null || bg.mA(this.mYV)) {
            w.e("MicroMsg.Label.NetSceneDelContactLabel", "cpan[doScene] label id list is null.");
            eVar2.a(3, -1, "[doScene]empty label is list.", this);
            return 0;
        }
        nfVar.tts = this.mYV;
        nfVar.tts = this.mYV;
        return a(eVar, this.gUA, this);
    }
}
