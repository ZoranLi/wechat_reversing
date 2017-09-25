package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bep;
import com.tencent.mm.protocal.c.beq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class d extends f {
    public int actionType;
    private final b gUA;
    private e gUD;
    private int nXW = 0;
    private final String neP;
    public int qYE;

    public d(int i, long j, int i2, String str, int i3) {
        this.nXW = i3;
        a aVar = new a();
        aVar.hsm = new bep();
        aVar.hsn = new beq();
        aVar.uri = "/cgi-bin/micromsg-bin/talkmicaction";
        aVar.hsl = 334;
        aVar.hso = com.tencent.mm.plugin.appbrand.jsapi.share.e.CTRL_INDEX;
        aVar.hsp = 1000000146;
        this.gUA = aVar.BE();
        bep com_tencent_mm_protocal_c_bep = (bep) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bep.tvL = i;
        com_tencent_mm_protocal_c_bep.tvM = j;
        com_tencent_mm_protocal_c_bep.tAL = i2;
        com_tencent_mm_protocal_c_bep.teU = (int) bg.Ny();
        this.actionType = i2;
        this.neP = str;
        com_tencent_mm_protocal_c_bep.tdM = i3;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.NetSceneTalkMicAction", "doScene");
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 334;
    }

    public final String bnX() {
        return this.neP;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneTalkMicAction", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.qYE = ((beq) this.gUA.hsk.hsr).tvN;
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int bnY() {
        return this.nXW;
    }
}
