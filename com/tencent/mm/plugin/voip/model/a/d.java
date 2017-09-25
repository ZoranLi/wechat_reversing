package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.plugin.appbrand.jsapi.bx;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bkx;
import com.tencent.mm.protocal.c.bky;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d extends n<bkx, bky> {
    public d(int i, long j, int i2, int i3, int i4, int i5, int i6, byte[] bArr, int i7) {
        a aVar = new a();
        aVar.hsm = new bkx();
        aVar.hsn = new bky();
        aVar.uri = "/cgi-bin/micromsg-bin/voipDoubleLinkSwitch";
        aVar.hsl = bx.CTRL_INDEX;
        aVar.hso = bx.CTRL_INDEX;
        aVar.hsp = 1000000249;
        this.gUA = aVar.BE();
        bkx com_tencent_mm_protocal_c_bkx = (bkx) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bkx.tvL = i;
        com_tencent_mm_protocal_c_bkx.tvM = j;
        com_tencent_mm_protocal_c_bkx.tWi = i2;
        com_tencent_mm_protocal_c_bkx.ukl = i3;
        com_tencent_mm_protocal_c_bkx.ukm = i4;
        com_tencent_mm_protocal_c_bkx.ukn = i5;
        com_tencent_mm_protocal_c_bkx.uko = i6;
        com_tencent_mm_protocal_c_bkx.ukp = 1;
        com_tencent_mm_protocal_c_bkx.tij = new avw().z(bArr, i7);
    }

    public final int getType() {
        return bx.CTRL_INDEX;
    }

    public final void dl(int i, int i2) {
        if (i == 0 && i2 == 0) {
            if (((bky) bqE()) != null) {
                w.i("MicroMsg.Voip.DoubleLinkSwitch", "roomId:%d, roomKey:%s, member:%d", new Object[]{Integer.valueOf(((bky) bqE()).tvL), Long.valueOf(((bky) bqE()).tvM), Integer.valueOf(((bky) bqE()).tWi)});
                return;
            }
            return;
        }
        w.i("MicroMsg.Voip.DoubleLinkSwitch", "double link switch error");
    }

    public final e bqA() {
        return new e(this) {
            final /* synthetic */ d rju;

            {
                this.rju = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.DoubleLinkSwitch", "double link switch response:" + i + " errCode:" + i2 + " status:" + this.rju.rgj.mStatus);
                if (i2 != 0) {
                    com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.DoubleLinkSwitch", " double link switch  response with error code:" + i2);
                    return;
                }
                bky com_tencent_mm_protocal_c_bky = (bky) this.rju.bqE();
                this.rju.rgj.rfD = com_tencent_mm_protocal_c_bky.tSN;
                if (this.rju.rgj.rfD != 0) {
                    if (this.rju.rgj.rfQ.doubleLinkSwitch(com_tencent_mm_protocal_c_bky.ukq) == 0) {
                        v2protocal com_tencent_mm_plugin_voip_model_v2protocal;
                        if (1 == com_tencent_mm_protocal_c_bky.ukq) {
                            com_tencent_mm_plugin_voip_model_v2protocal = this.rju.rgj.rfQ;
                            com_tencent_mm_plugin_voip_model_v2protocal.rkF++;
                        } else if (2 == com_tencent_mm_protocal_c_bky.ukq) {
                            com_tencent_mm_plugin_voip_model_v2protocal = this.rju.rgj.rfQ;
                            com_tencent_mm_plugin_voip_model_v2protocal.rkG++;
                        }
                    }
                    com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.Voip.DoubleLinkSwitch", "zhengxue[DOUBLELINK]room " + com_tencent_mm_protocal_c_bky.tvL + " member " + com_tencent_mm_protocal_c_bky.tWi + " key " + com_tencent_mm_protocal_c_bky.tvM + "report flag " + com_tencent_mm_protocal_c_bky.tSN + "switch to link type " + com_tencent_mm_protocal_c_bky.ukq + "doubleLinkSwitchReportStatus " + this.rju.rgj.rfD + "mDoubleLinkSwitchSucToDirectCnt" + this.rju.rgj.rfQ.rkF + "mDoubleLinkSwitchSucToRelayCnt" + this.rju.rgj.rfQ.rkG);
                }
            }
        };
    }
}
