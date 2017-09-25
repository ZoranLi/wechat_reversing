package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.l.d;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class m extends k implements j {
    private final b gUA;
    private e gUD;
    public byte[] kNk = null;
    private String kNl;

    public m(String str, byte[] bArr) {
        a aVar = new a();
        aVar.hsm = new xv();
        aVar.hsn = new xw();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetemotiondonorlist";
        aVar.hsl = d.CTRL_INDEX;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.kNk = bArr;
        this.kNl = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.emoji.NetSceneGetEmotionDonorList", "ErrType:" + i2 + "   errCode:" + i3);
        xw xwVar = (xw) ((b) pVar).hsk.hsr;
        if (xwVar.tfH != null) {
            this.kNk = n.a(xwVar.tfH);
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return d.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        xv xvVar = (xv) this.gUA.hsj.hsr;
        if (this.kNk != null) {
            xvVar.tfG = n.G(this.kNk);
        } else {
            xvVar.tfG = new avw();
        }
        xvVar.tgW = this.kNl;
        return a(eVar, this.gUA, this);
    }

    public final xw amr() {
        return (xw) this.gUA.hsk.hsr;
    }
}
