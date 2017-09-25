package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.g.c;
import com.tencent.mm.protocal.c.ber;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;

public final class e extends f {
    private final b gUA;
    private com.tencent.mm.y.e gUD;
    private int nXW = 0;
    private final String neP;

    public e(String str, int i, long j, int i2) {
        this.nXW = i2;
        a aVar = new a();
        aVar.hsm = new ber();
        aVar.hsn = new bes();
        aVar.uri = "/cgi-bin/micromsg-bin/talknoop";
        aVar.hsl = 335;
        aVar.hso = c.CTRL_INDEX;
        aVar.hsp = 1000000149;
        this.gUA = aVar.BE();
        ber com_tencent_mm_protocal_c_ber = (ber) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ber.tvL = i;
        com_tencent_mm_protocal_c_ber.tvM = j;
        com_tencent_mm_protocal_c_ber.teU = (int) bg.Ny();
        this.neP = str;
        com_tencent_mm_protocal_c_ber.tdM = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        w.d("MicroMsg.NetSceneTalkNoop", "doScene");
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 335;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneTalkNoop", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.gUD.a(i2, i3, str, this);
        } else {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final String bnX() {
        return this.neP;
    }

    public final int bnY() {
        return this.nXW;
    }
}
