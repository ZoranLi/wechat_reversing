package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.amh;
import com.tencent.mm.protocal.c.ami;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.a;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class q extends k implements j {
    private final b gUA;
    private e gWW;
    public String kMS;
    private int kNu;

    public q(String str, int i) {
        this.kMS = str;
        if (!bg.mA(str) && str.equals(String.valueOf(a.uKQ))) {
            this.kMS = "com.tencent.xin.emoticon.tusiji";
        }
        this.kNu = i;
        b.a aVar = new b.a();
        aVar.hsm = new amh();
        aVar.hsn = new ami();
        aVar.uri = "/cgi-bin/micromsg-bin/modemotionpack";
        aVar.hsl = 413;
        aVar.hso = com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX;
        aVar.hsp = 1000000212;
        this.gUA = aVar.BE();
    }

    public final int getType() {
        return 413;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        amh com_tencent_mm_protocal_c_amh = (amh) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_amh.tgW = this.kMS;
        com_tencent_mm_protocal_c_amh.tce = this.kNu;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.emoji.NetSceneModEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            if (this.kNu == 1) {
                g.oUh.a(165, 2, 1, false);
            } else {
                g.oUh.a(165, 4, 1, false);
            }
            this.gWW.a(i2, i3, str, this);
            return;
        }
        this.gWW.a(i2, i3, str, this);
        if (this.kNu == 1) {
            g.oUh.a(165, 3, 1, false);
            w.i("MicroMsg.emoji.NetSceneModEmotionPack", "del tukiz failed  ");
            return;
        }
        g.oUh.a(165, 5, 1, false);
        w.i("MicroMsg.emoji.NetSceneModEmotionPack", "del emoji failed md5:%s", new Object[]{this.kMS});
    }
}
