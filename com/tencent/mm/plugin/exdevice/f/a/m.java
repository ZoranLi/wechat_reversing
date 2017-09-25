package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bgo;
import com.tencent.mm.protocal.c.bgp;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class m extends k implements j {
    private b gUA = null;
    private e gUD = null;
    public String lfv;
    public String lfw;

    public m(String str, String str2) {
        this.lfv = str;
        this.lfw = str2;
        a aVar = new a();
        aVar.hsm = new bgo();
        aVar.hsn = new bgp();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/updatecover";
        aVar.hsl = 1040;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bgo com_tencent_mm_protocal_c_bgo = (bgo) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bgo.tHQ = str;
        com_tencent_mm_protocal_c_bgo.lfw = str2;
    }

    public final int getType() {
        return 1040;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneUpdateRankCoverAndMotto", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gUD.a(i2, i3, str, this);
    }
}
