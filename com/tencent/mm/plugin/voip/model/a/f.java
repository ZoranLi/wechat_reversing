package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.protocal.c.blb;
import com.tencent.mm.protocal.c.blc;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class f extends n<blb, blc> {
    public String TAG = "MicroMsg.NetSceneVoipHeartBeat";

    public f(int i, long j, int i2) {
        a aVar = new a();
        aVar.hsm = new blb();
        aVar.hsn = new blc();
        aVar.uri = "/cgi-bin/micromsg-bin/voipheartbeat";
        aVar.hsl = 178;
        aVar.hso = 81;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        blb com_tencent_mm_protocal_c_blb = (blb) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_blb.tvL = i;
        com_tencent_mm_protocal_c_blb.tvM = j;
        com_tencent_mm_protocal_c_blb.ujr = System.currentTimeMillis();
        com_tencent_mm_protocal_c_blb.ukt = i2;
    }

    public final int getType() {
        return 178;
    }

    public final e bqA() {
        return new e(this) {
            final /* synthetic */ f rjw;

            {
                this.rjw = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                if (i != 0 && i2 == 231) {
                    com.tencent.mm.plugin.voip.b.a.dI(this.rjw.TAG, "Voip heartbeat Failed, type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
                    this.rjw.rgj.rfQ.rlo.rgD = 111;
                    this.rjw.rgj.rfQ.rlo.rgE = i2;
                    this.rjw.rgj.rfQ.rlo.rgV = 2;
                    this.rjw.rgj.q(1, -9004, "");
                }
            }
        };
    }
}
