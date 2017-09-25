package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bll;
import com.tencent.mm.protocal.c.blm;
import com.tencent.mm.protocal.c.blr;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class i extends n<bll, blm> {
    public String TAG = "MicroMsg.NetSceneVoipShutDown";

    public i(int i, long j, String str) {
        a aVar = new a();
        aVar.hsm = new bll();
        aVar.hsn = new blm();
        aVar.uri = "/cgi-bin/micromsg-bin/voipshutdown";
        aVar.hsl = ac.CTRL_BYTE;
        aVar.hso = 66;
        aVar.hsp = 1000000066;
        this.gUA = aVar.BE();
        bll com_tencent_mm_protocal_c_bll = (bll) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bll.tvL = i;
        com_tencent_mm_protocal_c_bll.tvM = j;
        blr com_tencent_mm_protocal_c_blr = new blr();
        avx com_tencent_mm_protocal_c_avx = new avx();
        com_tencent_mm_protocal_c_avx.OV(str);
        com_tencent_mm_protocal_c_blr.ufs = com_tencent_mm_protocal_c_avx;
        com_tencent_mm_protocal_c_bll.uki = com_tencent_mm_protocal_c_blr;
        com_tencent_mm_protocal_c_bll.ujr = System.currentTimeMillis();
    }

    public final int getType() {
        return ac.CTRL_BYTE;
    }

    public final e bqA() {
        return new e(this) {
            final /* synthetic */ i rjz;

            {
                this.rjz = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.dK(this.rjz.TAG, "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
            }
        };
    }
}
