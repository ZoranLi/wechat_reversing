package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.tg;
import com.tencent.mm.protocal.c.th;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class al extends k implements j {
    private b gUA;
    private e gUD;
    private int hVl;
    private String mrx;

    public al(int i, String str) {
        a aVar = new a();
        aVar.hsm = new tg();
        aVar.hsn = new th();
        aVar.uri = "/cgi-bin/micromsg-bin/gamereportkv";
        aVar.hsl = 427;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        tg tgVar = (tg) this.gUA.hsj.hsr;
        tgVar.tlu = d.sYH;
        tgVar.tlv = d.sYG;
        tgVar.tlw = d.sYJ;
        tgVar.tlx = d.sYK;
        tgVar.tly = v.bIN();
        tgVar.oTM = i;
        tgVar.tlz = str;
        this.hVl = i;
        this.mrx = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MircoMsg.NetsceneGameKVReport", "errType = " + i2 + ", errCode = " + i3 + ", logId = " + this.hVl + ", logExt = " + this.mrx);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 427;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
