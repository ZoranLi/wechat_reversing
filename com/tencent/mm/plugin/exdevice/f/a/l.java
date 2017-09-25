package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ajh;
import com.tencent.mm.protocal.c.aji;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class l extends k implements j {
    public int fTP;
    private b gUA = null;
    private e gUD = null;
    public String hiE;
    public String lfJ;

    public l(String str, String str2, int i, String str3) {
        this.lfJ = str3;
        this.hiE = str2;
        this.fTP = i;
        this.lfJ = str3;
        a aVar = new a();
        aVar.hsm = new ajh();
        aVar.hsn = new aji();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/addlike";
        aVar.hsl = 1041;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ajh com_tencent_mm_protocal_c_ajh = (ajh) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ajh.lmI = str2;
        com_tencent_mm_protocal_c_ajh.username = str;
        com_tencent_mm_protocal_c_ajh.fTP = i;
        com_tencent_mm_protocal_c_ajh.hhW = str3;
    }

    public final int getType() {
        return 1041;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneUpdateLikeStatus", "hy: end. errType: %d, errCode: %d, errMsg: %s, ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gUD.a(i2, i3, str, this);
    }
}
