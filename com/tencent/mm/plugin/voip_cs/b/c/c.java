package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bkh;
import com.tencent.mm.protocal.c.bki;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c extends k implements j {
    public b gUA;
    private e gUD;

    public c(int i, String str, int i2, byte[] bArr, byte[] bArr2, String str2) {
        a aVar = new a();
        aVar.hsm = new bkh();
        aVar.hsn = new bki();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipinvite";
        aVar.hsl = 823;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bkh com_tencent_mm_protocal_c_bkh = (bkh) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bkh.tVX = i;
        com_tencent_mm_protocal_c_bkh.ujU = str;
        com_tencent_mm_protocal_c_bkh.trD = i2;
        com_tencent_mm_protocal_c_bkh.ujV = com.tencent.mm.bd.b.aU(bArr);
        com_tencent_mm_protocal_c_bkh.ujW = com.tencent.mm.bd.b.aU(bArr2);
        com_tencent_mm_protocal_c_bkh.tVW = System.currentTimeMillis();
        if (str2 != null && !str2.equals("")) {
            com_tencent_mm_protocal_c_bkh.ujX = str2;
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneVoipCSInvite", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 823;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
