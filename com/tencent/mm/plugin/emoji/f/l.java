package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.share.g;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.protocal.c.pj;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.protocal.c.xu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class l extends k implements j {
    private int akP;
    private final b gUA;
    private e gUD;
    private int hPi;
    public String kMS;

    public l(String str, int i, int i2) {
        this.kMS = str;
        this.hPi = i;
        this.akP = i2;
        a aVar = new a();
        aVar.hsm = new xt();
        aVar.hsn = new xu();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotiondetail";
        aVar.hsl = 412;
        aVar.hso = g.CTRL_INDEX;
        aVar.hsp = 1000000211;
        this.gUA = aVar.BE();
    }

    public l(String str, int i) {
        this(str, i, -1);
    }

    public final int getType() {
        return 412;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ProductID:%s, Scene:%d, Version:%d", new Object[]{this.kMS, Integer.valueOf(this.hPi), Integer.valueOf(this.akP)});
        this.gUD = eVar2;
        xt xtVar = (xt) this.gUA.hsj.hsr;
        xtVar.tgW = this.kMS;
        xtVar.tdM = this.hPi;
        xtVar.jOb = this.akP;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ErrType:" + i2 + "   errCode:" + i3);
        if (i2 == 0 || i3 == 0 || i3 == 5) {
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.storage.a.l lVar = h.amc().kLe;
                String str2 = this.kMS;
                xu xuVar = (xu) this.gUA.hsk.hsr;
                String ea = v.ea(ab.getContext());
                if (bg.mA(str2) || xuVar == null) {
                    w.w("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
                }
                try {
                    com.tencent.mm.storage.a.k kVar = new com.tencent.mm.storage.a.k();
                    kVar.field_productID = str2;
                    kVar.field_content = xuVar.toByteArray();
                    kVar.field_lan = ea;
                    if (lVar.gUz.replace("EmotionDetailInfo", "productID", kVar.pv()) > 0) {
                        w.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID success. ProductId:%s", new Object[]{str2});
                    } else {
                        w.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID failed. ProductId:%s", new Object[]{str2});
                    }
                } catch (Throwable e) {
                    w.e("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[]{bg.g(e)});
                }
            }
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final pj amq() {
        pj pjVar = new pj();
        return ((xu) this.gUA.hsk.hsr).tEk;
    }
}
