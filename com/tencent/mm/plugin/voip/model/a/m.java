package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.protocal.c.blv;
import com.tencent.mm.protocal.c.blw;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class m extends n<blv, blw> {
    public m(int i, bku com_tencent_mm_protocal_c_bku, byte[] bArr, long j, int i2) {
        a aVar = new a();
        aVar.hsm = new blv();
        aVar.hsn = new blw();
        aVar.uri = "/cgi-bin/micromsg-bin/voipsync";
        aVar.hsl = GameJsApiOperateGameCenterMsg.CTRL_BYTE;
        aVar.hso = 62;
        aVar.hsp = 1000000062;
        this.gUA = aVar.BE();
        blv com_tencent_mm_protocal_c_blv = (blv) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_blv.tvL = i;
        com_tencent_mm_protocal_c_blv.ulC = com_tencent_mm_protocal_c_bku;
        com_tencent_mm_protocal_c_blv.tvM = j;
        com_tencent_mm_protocal_c_blv.tWt = com.tencent.mm.u.m.xL();
        com_tencent_mm_protocal_c_blv.toa = i2;
        com_tencent_mm_protocal_c_blv.tob = new avw().bb(bArr);
        com_tencent_mm_protocal_c_blv.ujr = System.currentTimeMillis();
        w.d("MicroMsg.NetSceneVoipSync", "sync timestamp: " + com_tencent_mm_protocal_c_blv.ujr);
    }

    public final int getType() {
        return GameJsApiOperateGameCenterMsg.CTRL_BYTE;
    }

    public final int bqC() {
        return ((blv) this.gUA.hsj.hsr).toa;
    }

    public final e bqA() {
        return new e(this) {
            final /* synthetic */ m rjD;

            {
                this.rjD = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.dK("MicroMsg.NetSceneVoipSync", "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
                try {
                    if (((blw) this.rjD.bqE()).tvL != this.rjD.rgj.rfQ.mNL) {
                        com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.NetSceneVoipSync", "syncOnSceneEnd: recv roomId != current roomid");
                        return;
                    }
                } catch (Exception e) {
                }
                if (i != 0) {
                    com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.NetSceneVoipSync", "VoipSync Failed, type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
                    this.rjD.rgj.rfQ.rlo.rgD = 11;
                    this.rjD.rgj.rfQ.rlo.rgF = i2;
                    this.rjD.rgj.rfQ.rlo.rgE = i2;
                    this.rjD.rgj.rfQ.rlo.rgV = 3;
                    if (i == 1) {
                        this.rjD.rgj.rfQ.rlo.rgP = 8;
                    } else {
                        this.rjD.rgj.rfQ.rlo.rgP = 99;
                    }
                    this.rjD.rgj.q(1, -9004, "");
                    return;
                }
                this.rjD.rgj.rfT.n(kVar);
            }
        };
    }
}
