package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.bdb;
import com.tencent.mm.protocal.c.blp;
import com.tencent.mm.protocal.c.blq;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class k extends n<blp, blq> {
    public k(bdb com_tencent_mm_protocal_c_bdb) {
        a aVar = new a();
        aVar.hsm = new blp();
        aVar.hsn = new blq();
        aVar.uri = "/cgi-bin/micromsg-bin/voipspeedtest";
        aVar.hsl = 765;
        aVar.hso = 765;
        aVar.hsp = 1000000765;
        this.gUA = aVar.BE();
        blp com_tencent_mm_protocal_c_blp = (blp) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_blp.tvL = com_tencent_mm_protocal_c_bdb.tvL;
        com_tencent_mm_protocal_c_blp.ued = com_tencent_mm_protocal_c_bdb.ued;
        com_tencent_mm_protocal_c_blp.trD = com_tencent_mm_protocal_c_bdb.trD;
        com_tencent_mm_protocal_c_blp.uee = com_tencent_mm_protocal_c_bdb.uee;
        com_tencent_mm_protocal_c_blp.uef = com_tencent_mm_protocal_c_bdb.uef;
        com_tencent_mm_protocal_c_blp.ueg = com_tencent_mm_protocal_c_bdb.ueg;
        com_tencent_mm_protocal_c_blp.ueh = com_tencent_mm_protocal_c_bdb.ueh;
        com_tencent_mm_protocal_c_blp.uei = com_tencent_mm_protocal_c_bdb.uei;
        com_tencent_mm_protocal_c_blp.uej = com_tencent_mm_protocal_c_bdb.uej;
        com_tencent_mm_protocal_c_blp.uek = com_tencent_mm_protocal_c_bdb.uek;
        com_tencent_mm_protocal_c_blp.uel = com_tencent_mm_protocal_c_bdb.uel;
        com_tencent_mm_protocal_c_blp.uem = com_tencent_mm_protocal_c_bdb.uem;
        com_tencent_mm_protocal_c_blp.uen = com_tencent_mm_protocal_c_bdb.uen;
    }

    public final int getType() {
        return 765;
    }

    public final e bqA() {
        return new e(this) {
            final /* synthetic */ k rjB;

            {
                this.rjB = r1;
            }

            public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.NetSceneVoipSpeedTest", "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
                try {
                    blq com_tencent_mm_protocal_c_blq = (blq) this.rjB.bqE();
                    if (com_tencent_mm_protocal_c_blq.ulv == 0 || com_tencent_mm_protocal_c_blq.ulw == 0) {
                        com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, svrCount = " + com_tencent_mm_protocal_c_blq.ulw);
                    } else if (this.rjB.rgj.rfv != 1) {
                        com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, for mSpeedTestStatus = " + this.rjB.rgj.rfv);
                    } else {
                        this.rjB.rgj.rfv = 2;
                        this.rjB.rgj.rfx = com_tencent_mm_protocal_c_blq.ulr;
                        v2protocal com_tencent_mm_plugin_voip_model_v2protocal = this.rjB.rgj.rfQ;
                        if (com_tencent_mm_plugin_voip_model_v2protocal.rkU != 0) {
                            com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.Voip", "v2protocal StartVoipSpeedTest fail: a speedtest is doing");
                            return;
                        }
                        com_tencent_mm_plugin_voip_model_v2protocal.rkU = com_tencent_mm_protocal_c_blq.ulr;
                        com_tencent_mm_plugin_voip_model_v2protocal.field_SpeedTestSvrParaArray = com.tencent.mm.plugin.voip.b.a.a(com_tencent_mm_protocal_c_blq);
                        com_tencent_mm_plugin_voip_model_v2protocal.StartSpeedTest(com_tencent_mm_protocal_c_blq.ulr, com_tencent_mm_protocal_c_blq.ulw);
                    }
                } catch (Exception e) {
                    this.rjB.rgj.rfv = 0;
                }
            }
        };
    }
}
