package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bkk;
import com.tencent.mm.protocal.c.bkl;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d extends k implements j {
    public b gUA;
    private e gUD;

    public d(long j, long j2) {
        a aVar = new a();
        aVar.hsm = new bkk();
        aVar.hsn = new bkl();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipredirect";
        aVar.hsl = 285;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bkk com_tencent_mm_protocal_c_bkk = (bkk) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bkk.ujT = j;
        com_tencent_mm_protocal_c_bkk.tvM = j2;
        com_tencent_mm_protocal_c_bkk.tVW = System.currentTimeMillis();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneVoipCSRedirect", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 285;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
