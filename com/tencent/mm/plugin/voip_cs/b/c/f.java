package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bkp;
import com.tencent.mm.protocal.c.bkq;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class f extends k implements j {
    public b gUA;
    private e gUD;

    public f(long j, long j2, int i) {
        a aVar = new a();
        aVar.hsm = new bkp();
        aVar.hsn = new bkq();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipsync";
        aVar.hsl = 818;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bkp com_tencent_mm_protocal_c_bkp = (bkp) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bkp.ujT = j;
        com_tencent_mm_protocal_c_bkp.tvM = j2;
        com_tencent_mm_protocal_c_bkp.ukb = i;
        com_tencent_mm_protocal_c_bkp.tVW = System.currentTimeMillis();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneVoipCSSync", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 818;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
