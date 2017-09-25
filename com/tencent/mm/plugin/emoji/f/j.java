package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.xp;
import com.tencent.mm.protocal.c.xq;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class j extends k implements com.tencent.mm.network.j {
    public final b gUA;
    private e gWW;
    public String kNf;
    private String kNg;

    public j(String str, String str2) {
        a aVar = new a();
        aVar.hsm = new xp();
        aVar.hsn = new xq();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotionactivity";
        aVar.hsl = 368;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.kNf = str;
        this.kNg = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        xp xpVar = (xp) this.gUA.hsj.hsr;
        xpVar.tEf = this.kNf;
        xpVar.tup = this.kNg;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.emoji.NetSceneGetEmotionActivity", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 368;
    }
}
