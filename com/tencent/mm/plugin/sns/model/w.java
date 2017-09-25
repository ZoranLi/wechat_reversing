package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.bce;
import com.tencent.mm.protocal.c.bcj;
import com.tencent.mm.protocal.c.bck;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class w extends k implements j {
    private int fJA;
    private b gUA;
    public e gUD;
    private long pUF = 0;

    public w(long j, String str) {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneSnsTagOption", "opcode 3" + " snsTagId " + j + " tagName " + str);
        this.pUF = j;
        this.fJA = 3;
        a aVar = new a();
        aVar.hsm = new bcj();
        aVar.hsn = new bck();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstagoption";
        aVar.hsl = 290;
        aVar.hso = 114;
        aVar.hsp = 1000000114;
        this.gUA = aVar.BE();
        bcj com_tencent_mm_protocal_c_bcj = (bcj) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bcj.tce = 3;
        com_tencent_mm_protocal_c_bcj.udq = j;
        com_tencent_mm_protocal_c_bcj.muQ = str;
    }

    public final int getType() {
        return 290;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneSnsTagOption", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            bce com_tencent_mm_protocal_c_bce = ((bck) ((b) pVar).hsk.hsr).uds;
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneSnsTagOption", com_tencent_mm_protocal_c_bce.toString());
            switch (this.fJA) {
                case 1:
                case 2:
                    s dI = ae.beQ().dI(com_tencent_mm_protocal_c_bce.udq);
                    dI.field_tagId = com_tencent_mm_protocal_c_bce.udq;
                    dI.field_tagName = bg.ap(com_tencent_mm_protocal_c_bce.muQ, "");
                    dI.field_count = com_tencent_mm_protocal_c_bce.jNd;
                    dI.bw(com_tencent_mm_protocal_c_bce.jNe);
                    ae.beQ().a(dI);
                    break;
                case 3:
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneSnsTagOption", "MM_SNS_TAG_DEL " + ae.beQ().dJ(this.pUF));
                    break;
            }
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
