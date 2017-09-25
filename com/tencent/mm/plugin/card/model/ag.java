package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aqy;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class ag extends k implements j {
    public String content;
    public String fTJ;
    private final b gUA;
    private e gUD;
    public String iDX;
    public String kfY;
    public String kfZ;
    public boolean kga;
    public String kgb;
    public String kgc;
    public String kgd;
    public int status;

    public ag(int i, String str, String str2) {
        a aVar = new a();
        aVar.hsm = new aqy();
        aVar.hsn = new aqz();
        aVar.uri = "/cgi-bin/micromsg-bin/preacceptgiftcard";
        aVar.hsl = 1171;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        aqy com_tencent_mm_protocal_c_aqy = (aqy) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aqy.tcU = i;
        com_tencent_mm_protocal_c_aqy.tcV = str;
        com_tencent_mm_protocal_c_aqy.tcW = str2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetScenePreAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            aqz com_tencent_mm_protocal_c_aqz = (aqz) this.gUA.hsk.hsr;
            this.fTJ = com_tencent_mm_protocal_c_aqz.tcY;
            this.kfY = com_tencent_mm_protocal_c_aqz.tcZ;
            this.status = com_tencent_mm_protocal_c_aqz.status;
            this.content = com_tencent_mm_protocal_c_aqz.content;
            this.kfZ = com_tencent_mm_protocal_c_aqz.kft;
            this.iDX = com_tencent_mm_protocal_c_aqz.tVr;
            this.kga = com_tencent_mm_protocal_c_aqz.kga;
            this.kgb = com_tencent_mm_protocal_c_aqz.tVs;
            this.kgc = com_tencent_mm_protocal_c_aqz.tVt;
            this.kgd = com_tencent_mm_protocal_c_aqz.tVu;
            w.d("MicroMsg.NetScenePreAcceptGiftCard", "fromUserName:%s, fromUserHeadImgUrl:%s, status:%d, content:%s,buttonWording:%s, backgroundColor:%s, ignore:%b", new Object[]{this.fTJ, this.kfY, Integer.valueOf(this.status), this.content, this.kfZ, this.iDX, Boolean.valueOf(this.kga)});
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1171;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
