package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.protocal.c.bjy;
import com.tencent.mm.protocal.c.blh;
import com.tencent.mm.protocal.c.bli;
import com.tencent.mm.protocal.c.blk;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class h extends n<blh, bli> {
    public h(int i, long j, int i2, int i3, int i4, int[] iArr) {
        int i5 = 0;
        a aVar = new a();
        aVar.hsm = new blh();
        aVar.hsn = new bli();
        aVar.uri = "/cgi-bin/micromsg-bin/voipRedirect";
        aVar.hsl = 678;
        aVar.hso = 240;
        aVar.hsp = 1000000240;
        this.gUA = aVar.BE();
        blh com_tencent_mm_protocal_c_blh = (blh) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_blh.tvL = i;
        com_tencent_mm_protocal_c_blh.tvM = j;
        com_tencent_mm_protocal_c_blh.tWi = i2;
        com_tencent_mm_protocal_c_blh.ula = i3;
        com_tencent_mm_protocal_c_blh.ulb = i4;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            blk com_tencent_mm_protocal_c_blk = new blk();
            int i8 = i6 + 1;
            com_tencent_mm_protocal_c_blk.ulm = iArr[i6];
            i6 = i8 + 1;
            com_tencent_mm_protocal_c_blk.uln = iArr[i8];
            i8 = i6 + 1;
            com_tencent_mm_protocal_c_blk.ulo = iArr[i6];
            int i9 = i8 + 1;
            com_tencent_mm_protocal_c_blk.ulp = iArr[i8];
            i6 = i9 + 1;
            com_tencent_mm_protocal_c_blk.ulq = iArr[i9];
            com_tencent_mm_protocal_c_blh.ulc.add(com_tencent_mm_protocal_c_blk);
        }
        if (this.rgj.rfQ.rlo.rhe != 0) {
            i5 = (int) ((System.currentTimeMillis() - this.rgj.rfQ.rlo.rhe) / 1000);
        }
        com_tencent_mm_protocal_c_blh.uld = i5;
    }

    public final int getType() {
        return 678;
    }

    public final void dl(int i, int i2) {
        if (i == 0 && i2 == 0) {
            if (((bli) this.gUA.hsk.hsr) != null) {
                w.i("MicroMsg.Voip.Redirect", "roomId:%d, roomKey:%s, member:%d", new Object[]{Integer.valueOf(((bli) this.gUA.hsk.hsr).tvL), Long.valueOf(((bli) this.gUA.hsk.hsr).tvM), Integer.valueOf(((bli) this.gUA.hsk.hsr).tWi)});
                return;
            }
            return;
        }
        w.i("MicroMsg.Voip.Redirect", "Redirect error");
    }

    public final e bqA() {
        return new e(this) {
            final /* synthetic */ h rjy;

            {
                this.rjy = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.Redirect", "Redirect response:" + i + " errCode:" + i2 + " status:" + this.rjy.rgj.mStatus);
                if (i2 != 0) {
                    com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.Redirect", " redirect response with error code:" + i2);
                    return;
                }
                bli com_tencent_mm_protocal_c_bli = (bli) this.rjy.bqE();
                com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.Redirect", "room " + com_tencent_mm_protocal_c_bli.tvL + " member " + com_tencent_mm_protocal_c_bli.tWi + " key " + com_tencent_mm_protocal_c_bli.tvM + " relay addr cnt " + com_tencent_mm_protocal_c_bli.ule + " RedirectThreshold " + com_tencent_mm_protocal_c_bli.ulk + " RedirectDecision " + com_tencent_mm_protocal_c_bli.ull);
                bjy com_tencent_mm_protocal_c_bjy = new bjy();
                bjy com_tencent_mm_protocal_c_bjy2 = new bjy();
                bjy com_tencent_mm_protocal_c_bjy3 = new bjy();
                com_tencent_mm_protocal_c_bjy.ujy = com_tencent_mm_protocal_c_bli.ule;
                com_tencent_mm_protocal_c_bjy.ujz = com_tencent_mm_protocal_c_bli.ulf;
                com_tencent_mm_protocal_c_bjy2.ujy = com_tencent_mm_protocal_c_bli.ulg;
                com_tencent_mm_protocal_c_bjy2.ujz = com_tencent_mm_protocal_c_bli.ulh;
                com_tencent_mm_protocal_c_bjy3.ujy = com_tencent_mm_protocal_c_bli.uli;
                com_tencent_mm_protocal_c_bjy3.ujz = com_tencent_mm_protocal_c_bli.ulj;
                this.rjy.rgj.rfQ.a(com_tencent_mm_protocal_c_bjy, com_tencent_mm_protocal_c_bjy2, com_tencent_mm_protocal_c_bjy3, com_tencent_mm_protocal_c_bli.ulk, com_tencent_mm_protocal_c_bli.ull);
            }
        };
    }
}
