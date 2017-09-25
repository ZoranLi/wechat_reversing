package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bkr;
import com.tencent.mm.protocal.c.bks;
import com.tencent.mm.protocal.c.blr;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c extends n<bkr, bks> {
    public c(int i, long j, String str, String str2, int i2) {
        a aVar = new a();
        aVar.hsm = new bkr();
        aVar.hsn = new bks();
        aVar.uri = "/cgi-bin/micromsg-bin/voipcancelinvite";
        aVar.hsl = 171;
        aVar.hso = 64;
        aVar.hsp = 1000000064;
        this.gUA = aVar.BE();
        bkr com_tencent_mm_protocal_c_bkr = (bkr) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bkr.tvL = i;
        com_tencent_mm_protocal_c_bkr.tvM = j;
        com_tencent_mm_protocal_c_bkr.mvU = str;
        com_tencent_mm_protocal_c_bkr.tVX = i2;
        blr com_tencent_mm_protocal_c_blr = new blr();
        avx com_tencent_mm_protocal_c_avx = new avx();
        com_tencent_mm_protocal_c_avx.OV(str2);
        com_tencent_mm_protocal_c_blr.ufs = com_tencent_mm_protocal_c_avx;
        com_tencent_mm_protocal_c_bkr.uki = com_tencent_mm_protocal_c_blr;
        com_tencent_mm_protocal_c_bkr.ujr = System.currentTimeMillis();
    }

    public final int bqB() {
        bkr com_tencent_mm_protocal_c_bkr = (bkr) bqF();
        if (com_tencent_mm_protocal_c_bkr.tvL == 0 && com_tencent_mm_protocal_c_bkr.tVX == 0) {
            return -1;
        }
        return 0;
    }

    public final int getType() {
        return 171;
    }

    public final e bqA() {
        return new e(this) {
            final /* synthetic */ c rjt;

            {
                this.rjt = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.NetSceneVoipCancelInvite", "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
            }
        };
    }
}
