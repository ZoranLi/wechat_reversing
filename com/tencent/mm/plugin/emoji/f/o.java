package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.protocal.c.xz;
import com.tencent.mm.protocal.c.ya;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.m;
import com.tencent.mm.storage.a.n;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class o extends k implements j {
    public static int kNp = 0;
    public static int kNq = 1;
    public static int kNr = 1;
    public static int kNs = 2;
    public static int kNt = 256;
    private final b gUA;
    private e gUD;
    private String kMI;
    private int kNu;

    public o(String str, int i) {
        a aVar = new a();
        aVar.hsm = new xz();
        aVar.hsn = new ya();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetemotionreward";
        aVar.hsl = 822;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.kMI = str;
        this.kNu = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.emoji.NetSceneGetEmotionReward", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            if (this.kNu == kNp) {
                n nVar = h.amc().kLf;
                String str2 = this.kMI;
                ya amu = amu();
                if (bg.mA(str2) || amu == null) {
                    w.w("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
                } else {
                    try {
                        m mVar = new m();
                        mVar.field_productID = str2;
                        mVar.field_content = amu.toByteArray();
                        if (nVar.gUz.replace("EmotionRewardInfo", "productID", mVar.pv()) > 0) {
                            w.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID success. ProductId:%s", new Object[]{str2});
                        } else {
                            w.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. ProductId:%s", new Object[]{str2});
                        }
                    } catch (Throwable e) {
                        w.e("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", new Object[]{bg.g(e)});
                    }
                }
            }
            if (amu() == null || amu().tEC == null) {
                w.i("MicroMsg.emoji.NetSceneGetEmotionReward", "getEmotionRewardRespone is null. so i think no such product reward information");
                h.amc().kLh.cI(this.kMI, kNt);
                h.amd().aJ(this.kMI, kNt);
            } else {
                h.amc().kLh.cI(this.kMI, amu().tEC.teT);
                h.amd().aJ(this.kMI, amu().tEC.teT);
            }
        } else if (i3 == 1) {
            h.amc().kLh.cI(this.kMI, kNt);
            h.amd().aJ(this.kMI, kNt);
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 822;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        xz xzVar = (xz) this.gUA.hsj.hsr;
        xzVar.tgW = this.kMI;
        xzVar.tce = this.kNu;
        return a(eVar, this.gUA, this);
    }

    public final ya amu() {
        return (ya) this.gUA.hsk.hsr;
    }
}
