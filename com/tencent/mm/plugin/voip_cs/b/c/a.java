package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bkd;
import com.tencent.mm.protocal.c.bke;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    public b gUA;
    private e gUD;

    public a(int i, long j, long j2, String str, int i2) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new bkd();
        aVar.hsn = new bke();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoiphangup";
        aVar.hsl = 880;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bkd com_tencent_mm_protocal_c_bkd = (bkd) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bkd.tVX = i;
        com_tencent_mm_protocal_c_bkd.ujT = j;
        com_tencent_mm_protocal_c_bkd.tvM = j2;
        com_tencent_mm_protocal_c_bkd.ujU = str;
        com_tencent_mm_protocal_c_bkd.tBz = i2;
        com_tencent_mm_protocal_c_bkd.tVW = System.currentTimeMillis();
    }

    public final int getType() {
        return 880;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneVoipCSHangUp", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gUD.a(i2, i3, str, this);
    }
}
