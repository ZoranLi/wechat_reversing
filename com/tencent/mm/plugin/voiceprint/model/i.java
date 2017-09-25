package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.beg;
import com.tencent.mm.protocal.c.beh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class i extends k implements j {
    private final b gUA;
    private e gUD;
    public int mStatus;
    public int rcz;

    public i(int i) {
        a aVar = new a();
        aVar.hsm = new beg();
        aVar.hsn = new beh();
        aVar.uri = "/cgi-bin/micromsg-bin/switchopvoiceprint";
        aVar.hsl = 615;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((beg) this.gUA.hsj.hsr).fJK = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 615;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneSwitchOpVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        beh com_tencent_mm_protocal_c_beh = (beh) ((b) pVar).hsk.hsr;
        if (i2 == 0 || i3 == 0) {
            this.mStatus = com_tencent_mm_protocal_c_beh.tVh;
            this.rcz = com_tencent_mm_protocal_c_beh.ufi;
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
