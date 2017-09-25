package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.blr;
import com.tencent.mm.protocal.c.bls;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class l extends n<bls, blt> {
    public l(String str, String str2, String str3, String str4, String str5) {
        a aVar = new a();
        aVar.hsm = new bls();
        aVar.hsn = new blt();
        aVar.uri = "/cgi-bin/micromsg-bin/voipstatreport";
        aVar.hsl = 320;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bls com_tencent_mm_protocal_c_bls = (bls) this.gUA.hsj.hsr;
        blr com_tencent_mm_protocal_c_blr = new blr();
        avx com_tencent_mm_protocal_c_avx = new avx();
        com_tencent_mm_protocal_c_avx.OV(str);
        com_tencent_mm_protocal_c_blr.ufs = com_tencent_mm_protocal_c_avx;
        blr com_tencent_mm_protocal_c_blr2 = new blr();
        avx com_tencent_mm_protocal_c_avx2 = new avx();
        com_tencent_mm_protocal_c_avx2.OV(str2);
        com_tencent_mm_protocal_c_blr2.ufs = com_tencent_mm_protocal_c_avx2;
        blr com_tencent_mm_protocal_c_blr3 = new blr();
        avx com_tencent_mm_protocal_c_avx3 = new avx();
        com_tencent_mm_protocal_c_avx3.OV(str3);
        com_tencent_mm_protocal_c_blr3.ufs = com_tencent_mm_protocal_c_avx3;
        blr com_tencent_mm_protocal_c_blr4 = new blr();
        avx com_tencent_mm_protocal_c_avx4 = new avx();
        com_tencent_mm_protocal_c_avx4.OV(str4);
        com_tencent_mm_protocal_c_blr4.ufs = com_tencent_mm_protocal_c_avx4;
        blr com_tencent_mm_protocal_c_blr5 = new blr();
        avx com_tencent_mm_protocal_c_avx5 = new avx();
        com_tencent_mm_protocal_c_avx5.OV(str5);
        com_tencent_mm_protocal_c_blr5.ufs = com_tencent_mm_protocal_c_avx5;
        com_tencent_mm_protocal_c_bls.uki = com_tencent_mm_protocal_c_blr;
        com_tencent_mm_protocal_c_bls.ulz = com_tencent_mm_protocal_c_blr2;
        com_tencent_mm_protocal_c_bls.uly = com_tencent_mm_protocal_c_blr3;
        com_tencent_mm_protocal_c_bls.ulA = com_tencent_mm_protocal_c_blr4;
        com_tencent_mm_protocal_c_bls.ulB = com_tencent_mm_protocal_c_blr5;
    }

    public final int getType() {
        return 320;
    }

    public final e bqA() {
        return new e(this) {
            final /* synthetic */ l rjC;

            {
                this.rjC = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.NetSceneVoipStatReport", "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
            }
        };
    }
}
