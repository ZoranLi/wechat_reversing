package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bgq;
import com.tencent.mm.protocal.c.bgr;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class n extends k implements j {
    private b gUA = null;
    private e gUD = null;
    public int lga;
    public int lgb;
    public int opType;

    public n(int i, int i2) {
        this.opType = i;
        this.lga = i2;
        a aVar = new a();
        aVar.hsm = new bgq();
        aVar.hsn = new bgr();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/updateranksetting";
        aVar.hsl = 1044;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bgq com_tencent_mm_protocal_c_bgq = (bgq) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bgq.fTP = this.opType;
        com_tencent_mm_protocal_c_bgq.fRW = this.lga;
    }

    public final int getType() {
        return 1044;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneUpdateRankSetting", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.lgb = ((bgr) this.gUA.hsk.hsr).fRW;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
