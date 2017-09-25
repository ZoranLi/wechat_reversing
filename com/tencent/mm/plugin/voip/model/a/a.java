package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bjw;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.blj;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends n<bjv, bjw> {
    public String TAG = "MicroMsg.NetSceneVoipAck";

    public a(int i, long j, int i2, byte[] bArr, byte[] bArr2, String str) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new bjv();
        aVar.hsn = new bjw();
        aVar.uri = "/cgi-bin/micromsg-bin/voipack";
        aVar.hsl = 305;
        aVar.hso = 123;
        aVar.hsp = 1000000123;
        this.gUA = aVar.BE();
        bjv com_tencent_mm_protocal_c_bjv = (bjv) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bjv.tvL = i;
        com_tencent_mm_protocal_c_bjv.tvM = j;
        com_tencent_mm_protocal_c_bjv.ujq = i2;
        if (i2 != 1) {
            com_tencent_mm_protocal_c_bjv.ujm = 0;
            return;
        }
        com_tencent_mm_protocal_c_bjv.ujp = str;
        blj com_tencent_mm_protocal_c_blj = new blj();
        com_tencent_mm_protocal_c_blj.jOc = 2;
        avw com_tencent_mm_protocal_c_avw = new avw();
        com_tencent_mm_protocal_c_avw.bb(bArr);
        com_tencent_mm_protocal_c_blj.tij = com_tencent_mm_protocal_c_avw;
        com_tencent_mm_protocal_c_bjv.ujn = com_tencent_mm_protocal_c_blj;
        com_tencent_mm_protocal_c_blj = new blj();
        com_tencent_mm_protocal_c_blj.jOc = 3;
        com_tencent_mm_protocal_c_avw = new avw();
        com_tencent_mm_protocal_c_avw.bb(bArr2);
        com_tencent_mm_protocal_c_blj.tij = com_tencent_mm_protocal_c_avw;
        com_tencent_mm_protocal_c_bjv.ujo = com_tencent_mm_protocal_c_blj;
        com_tencent_mm_protocal_c_bjv.ujr = System.currentTimeMillis();
        com_tencent_mm_protocal_c_bjv.ujm = 1;
    }

    public final int getType() {
        return 305;
    }

    public final e bqA() {
        return new e(this) {
            final /* synthetic */ a rjr;

            {
                this.rjr = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.dJ(this.rjr.TAG, "ack response:" + i + " errCode:" + i2 + " status:" + this.rjr.rgj.mStatus);
                if (this.rjr.rgj.mStatus == 1) {
                    com.tencent.mm.plugin.voip.b.a.dJ(this.rjr.TAG, "reject ok!");
                } else if (this.rjr.rgj.mStatus != 3) {
                    com.tencent.mm.plugin.voip.b.a.dI(this.rjr.TAG, "ack response not within WAITCONNECT, ignored.");
                } else if (i == 0) {
                    bjw com_tencent_mm_protocal_c_bjw = (bjw) this.rjr.bqE();
                    if (com_tencent_mm_protocal_c_bjw.ujm != 1) {
                        com.tencent.mm.plugin.voip.b.a.dJ(this.rjr.TAG, "onVoipAckResp: do not use preconnect");
                        return;
                    }
                    this.rjr.rgj.rfs = true;
                    this.rjr.rgj.rfQ.rkn = 1;
                    this.rjr.rgj.rfQ.mNL = com_tencent_mm_protocal_c_bjw.tvL;
                    this.rjr.rgj.rfQ.mNM = com_tencent_mm_protocal_c_bjw.tvM;
                    this.rjr.rgj.rfQ.mNT = com_tencent_mm_protocal_c_bjw.ujs;
                    this.rjr.rgj.rfQ.rjU = com_tencent_mm_protocal_c_bjw.ujw;
                    this.rjr.rgj.rfQ.rjV = com_tencent_mm_protocal_c_bjw.ujx;
                    this.rjr.rgj.uQ(com_tencent_mm_protocal_c_bjw.uju);
                    com.tencent.mm.plugin.voip.b.a.dJ(this.rjr.TAG, "ack ok, roomid =" + this.rjr.rgj.rfQ.mNL + ",memberid = " + this.rjr.rgj.rfQ.mNT);
                    blf com_tencent_mm_protocal_c_blf = com_tencent_mm_protocal_c_bjw.ujt;
                    if (com_tencent_mm_protocal_c_blf.mOi > 0) {
                        com_tencent_mm_protocal_c_blf.mOi--;
                        com.tencent.mm.plugin.voip.b.a.dJ(this.rjr.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + com_tencent_mm_protocal_c_blf.mOi + "] from ackresp relaydata");
                    } else {
                        com_tencent_mm_protocal_c_blf.mOi = 1;
                        com.tencent.mm.plugin.voip.b.a.dJ(this.rjr.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in ackresp mrdata");
                    }
                    com.tencent.mm.plugin.voip.b.a.dJ(this.rjr.TAG, "ack with switchtcpcnt  =" + this.rjr.rgj.rfQ.rjT + " RedirectReqThreshold =" + com_tencent_mm_protocal_c_blf.ukV + " BothSideSwitchFlag =" + com_tencent_mm_protocal_c_blf.ukW + " WifiScanInterval =" + com_tencent_mm_protocal_c_bjw.ujx);
                    this.rjr.rgj.rfQ.rkK = com_tencent_mm_protocal_c_blf.ukW;
                    this.rjr.rgj.uP(com_tencent_mm_protocal_c_blf.ukA);
                    this.rjr.rgj.aH(com_tencent_mm_protocal_c_blf.ujn.tij.tZp.toByteArray());
                    if (!(com_tencent_mm_protocal_c_blf.ukH == null || com_tencent_mm_protocal_c_blf.ukH.tZp == null || com_tencent_mm_protocal_c_blf.ukT == null || com_tencent_mm_protocal_c_blf.ukT.tZp == null)) {
                        this.rjr.rgj.a(com_tencent_mm_protocal_c_blf.ukH.tZp.toByteArray(), com_tencent_mm_protocal_c_blf.ukG, com_tencent_mm_protocal_c_blf.mOi, com_tencent_mm_protocal_c_blf.ukT.tZp.toByteArray());
                    }
                    this.rjr.rgj.g(com_tencent_mm_protocal_c_blf.ukK, com_tencent_mm_protocal_c_blf.ukL, com_tencent_mm_protocal_c_blf.ukM, com_tencent_mm_protocal_c_blf.ukN, com_tencent_mm_protocal_c_blf.ukO);
                    this.rjr.rgj.aI(com_tencent_mm_protocal_c_blf.ujo.tij.tZp.toByteArray());
                    this.rjr.rgj.a(com_tencent_mm_protocal_c_blf.ukB, com_tencent_mm_protocal_c_blf.ukC, com_tencent_mm_protocal_c_blf.ukJ);
                    this.rjr.rgj.uO(com_tencent_mm_protocal_c_blf.ukS);
                    this.rjr.rgj.uN(com_tencent_mm_protocal_c_blf.ukV);
                    if (!(com_tencent_mm_protocal_c_blf.ukQ == null || com_tencent_mm_protocal_c_blf.ukR == null)) {
                        this.rjr.rgj.b(com_tencent_mm_protocal_c_blf.ukP, com_tencent_mm_protocal_c_blf.ukQ.tZp.toByteArray(), com_tencent_mm_protocal_c_blf.ukR.tZp.toByteArray());
                    }
                    d.bpd().bqq();
                    com.tencent.mm.plugin.voip.b.a.dJ(this.rjr.TAG, "ack success, try connect channel");
                    this.rjr.rgj.bps();
                } else if (i == 4) {
                    this.rjr.rgj.rfQ.rlo.rgD = 12;
                    this.rjr.rgj.rfQ.rlo.rgE = i2;
                    this.rjr.rgj.q(1, i2, "");
                } else {
                    this.rjr.rgj.rfQ.rlo.rgD = 12;
                    this.rjr.rgj.rfQ.rlo.rgE = i2;
                    this.rjr.rgj.q(1, -9004, "");
                }
            }
        };
    }
}
