package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bjz;
import com.tencent.mm.protocal.c.bka;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.blj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends n<bjz, bka> {
    public String TAG = "MicroMsg.NetSceneVoipAnswer";

    public b(int i, int i2, int i3, byte[] bArr, byte[] bArr2, long j, boolean z, boolean z2) {
        a aVar = new a();
        aVar.hsm = new bjz();
        aVar.hsn = new bka();
        aVar.uri = "/cgi-bin/micromsg-bin/voipanswer";
        aVar.hsl = 172;
        aVar.hso = 65;
        aVar.hsp = 1000000065;
        this.gUA = aVar.BE();
        bjz com_tencent_mm_protocal_c_bjz = (bjz) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bjz.ujA = i;
        com_tencent_mm_protocal_c_bjz.tvL = i3;
        com_tencent_mm_protocal_c_bjz.trD = i2;
        blj com_tencent_mm_protocal_c_blj = new blj();
        com_tencent_mm_protocal_c_blj.jOc = 2;
        avw com_tencent_mm_protocal_c_avw = new avw();
        com_tencent_mm_protocal_c_avw.bb(bArr);
        com_tencent_mm_protocal_c_blj.tij = com_tencent_mm_protocal_c_avw;
        com_tencent_mm_protocal_c_bjz.ujn = com_tencent_mm_protocal_c_blj;
        com_tencent_mm_protocal_c_blj = new blj();
        com_tencent_mm_protocal_c_blj.jOc = 3;
        com_tencent_mm_protocal_c_avw = new avw();
        com_tencent_mm_protocal_c_avw.bb(bArr2);
        com_tencent_mm_protocal_c_blj.tij = com_tencent_mm_protocal_c_avw;
        com_tencent_mm_protocal_c_bjz.ujo = com_tencent_mm_protocal_c_blj;
        com_tencent_mm_protocal_c_bjz.tvM = j;
        if (z2) {
            com_tencent_mm_protocal_c_bjz.ujB = z ? 1 : 0;
        }
        com_tencent_mm_protocal_c_bjz.ujr = System.currentTimeMillis();
    }

    public final int getType() {
        return 172;
    }

    public final e bqA() {
        return new e(this) {
            final /* synthetic */ b rjs;

            {
                this.rjs = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.dJ(this.rjs.TAG, "Anwser response:" + i + " errCode:" + i2 + " status:" + this.rjs.rgj.mStatus);
                if (this.rjs.rgj.mStatus == 1) {
                    com.tencent.mm.plugin.voip.b.a.dJ(this.rjs.TAG, "reject ok!");
                } else if (this.rjs.rgj.mStatus != 4) {
                    com.tencent.mm.plugin.voip.b.a.dI(this.rjs.TAG, "Anwser response not within WAITCONNECT, ignored.");
                } else if (i == 0) {
                    bka com_tencent_mm_protocal_c_bka = (bka) this.rjs.bqE();
                    this.rjs.rgj.rfQ.mNL = com_tencent_mm_protocal_c_bka.tvL;
                    this.rjs.rgj.rfQ.mNM = com_tencent_mm_protocal_c_bka.tvM;
                    this.rjs.rgj.rfQ.mNT = com_tencent_mm_protocal_c_bka.ujs;
                    this.rjs.rgj.rfQ.rkp = com_tencent_mm_protocal_c_bka.ujE;
                    this.rjs.rgj.rfQ.rkq = com_tencent_mm_protocal_c_bka.ujF;
                    this.rjs.rgj.rfQ.rkr = com_tencent_mm_protocal_c_bka.ujG;
                    this.rjs.rgj.rfQ.rks = com_tencent_mm_protocal_c_bka.ujH;
                    this.rjs.rgj.rfQ.rku = com_tencent_mm_protocal_c_bka.ujJ;
                    this.rjs.rgj.rfQ.rkt = com_tencent_mm_protocal_c_bka.ujO;
                    this.rjs.rgj.rfQ.rjU = com_tencent_mm_protocal_c_bka.ujw;
                    this.rjs.rgj.rfQ.rkv = com_tencent_mm_protocal_c_bka.ujQ;
                    this.rjs.rgj.uQ(com_tencent_mm_protocal_c_bka.uju);
                    this.rjs.rgj.rfQ.rjV = com_tencent_mm_protocal_c_bka.ujx;
                    com.tencent.mm.plugin.voip.b.a.dJ(this.rjs.TAG, "onAnwserResp: audioTsdfBeyond3G = " + this.rjs.rgj.rfQ.rkp + ",audioTsdEdge = " + this.rjs.rgj.rfQ.rkq + ",passthroughQosAlgorithm = " + this.rjs.rgj.rfQ.rkr + ",fastPlayRepair = " + this.rjs.rgj.rfQ.rks + ", audioDtx = " + this.rjs.rgj.rfQ.rku + ", switchtcppktCnt=" + this.rjs.rgj.rfQ.rjT + ", SvrCfgListV=" + this.rjs.rgj.rfQ.rkt + ", setMaxBRForRelay=" + this.rjs.rgj.rfQ.rkv + ", RedirectreqThreshold=" + com_tencent_mm_protocal_c_bka.ujt.ukV + ", BothSideSwitchFlag=" + com_tencent_mm_protocal_c_bka.ujt.ukW + ", WifiScanInterval=" + com_tencent_mm_protocal_c_bka.ujx);
                    this.rjs.rgj.rfQ.rkw = com_tencent_mm_protocal_c_bka.ujN;
                    com.tencent.mm.plugin.voip.b.a.dJ(this.rjs.TAG, "answerResp AudioAecMode5 = " + this.rjs.rgj.rfQ.rkw);
                    this.rjs.rgj.rfq = true;
                    com.tencent.mm.plugin.voip.b.a.dJ(this.rjs.TAG, "answer ok, roomid =" + this.rjs.rgj.rfQ.mNL + ",memberid = " + this.rjs.rgj.rfQ.mNT);
                    blf com_tencent_mm_protocal_c_blf = com_tencent_mm_protocal_c_bka.ujt;
                    if (com_tencent_mm_protocal_c_blf.mOi > 0) {
                        com_tencent_mm_protocal_c_blf.mOi--;
                        com.tencent.mm.plugin.voip.b.a.dJ(this.rjs.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + com_tencent_mm_protocal_c_blf.mOi + "] from answerresp relaydata");
                    } else {
                        com_tencent_mm_protocal_c_blf.mOi = 1;
                        com.tencent.mm.plugin.voip.b.a.dJ(this.rjs.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in answerresp mrdata");
                    }
                    com.tencent.mm.plugin.voip.b.a.dJ(this.rjs.TAG, "answer with relayData peerid.length =" + com_tencent_mm_protocal_c_blf.ujn.tij.tZn);
                    com.tencent.mm.plugin.voip.b.a.dJ(this.rjs.TAG, "answer with relayData capinfo.length =" + com_tencent_mm_protocal_c_blf.ujo.tij.tZn);
                    this.rjs.rgj.uP(com_tencent_mm_protocal_c_blf.ukA);
                    this.rjs.rgj.a(com_tencent_mm_protocal_c_blf.ukB, com_tencent_mm_protocal_c_blf.ukC, com_tencent_mm_protocal_c_blf.ukJ);
                    if (com_tencent_mm_protocal_c_blf.ujn.tij.tZp != null) {
                        this.rjs.rgj.aH(com_tencent_mm_protocal_c_blf.ujn.tij.tZp.toByteArray());
                    } else {
                        w.e(this.rjs.TAG, "multiRelayData.PeerId.Buffer.getBuffer() is null");
                    }
                    if (!(com_tencent_mm_protocal_c_blf.ukH == null || com_tencent_mm_protocal_c_blf.ukH.tZp == null || com_tencent_mm_protocal_c_blf.ukT == null || com_tencent_mm_protocal_c_blf.ukT.tZp == null)) {
                        this.rjs.rgj.a(com_tencent_mm_protocal_c_blf.ukH.tZp.toByteArray(), com_tencent_mm_protocal_c_blf.ukG, com_tencent_mm_protocal_c_blf.mOi, com_tencent_mm_protocal_c_blf.ukT.tZp.toByteArray());
                    }
                    this.rjs.rgj.g(com_tencent_mm_protocal_c_blf.ukK, com_tencent_mm_protocal_c_blf.ukL, com_tencent_mm_protocal_c_blf.ukM, com_tencent_mm_protocal_c_blf.ukN, com_tencent_mm_protocal_c_blf.ukO);
                    this.rjs.rgj.uO(com_tencent_mm_protocal_c_blf.ukS);
                    if (!(com_tencent_mm_protocal_c_blf.ukQ == null || com_tencent_mm_protocal_c_blf.ukR == null || com_tencent_mm_protocal_c_blf.ukQ.tZp == null || com_tencent_mm_protocal_c_blf.ukR.tZp == null)) {
                        this.rjs.rgj.b(com_tencent_mm_protocal_c_blf.ukP, com_tencent_mm_protocal_c_blf.ukQ.tZp.toByteArray(), com_tencent_mm_protocal_c_blf.ukR.tZp.toByteArray());
                    }
                    if (com_tencent_mm_protocal_c_blf.ujo.tij.tZp != null) {
                        this.rjs.rgj.aI(com_tencent_mm_protocal_c_blf.ujo.tij.tZp.toByteArray());
                    } else {
                        w.e(this.rjs.TAG, "multiRelayData.CapInfo.Buffer.getBuffer() is null");
                    }
                    this.rjs.rgj.uN(com_tencent_mm_protocal_c_blf.ukV);
                    this.rjs.rgj.rfQ.rkK = com_tencent_mm_protocal_c_blf.ukW;
                    if (this.rjs.rgj.rfs) {
                        this.rjs.rgj.rfs = false;
                        if (this.rjs.rgj.rfn) {
                            com.tencent.mm.plugin.voip.b.a.dJ(this.rjs.TAG, "channel pre-connect already success, start talk");
                            this.rjs.rgj.bpo();
                            return;
                        } else if (this.rjs.rgj.rfr) {
                            com.tencent.mm.plugin.voip.b.a.dJ(this.rjs.TAG, "channel pre-connect already failed");
                            this.rjs.rgj.q(1, -9000, "");
                            return;
                        } else {
                            com.tencent.mm.plugin.voip.b.a.dJ(this.rjs.TAG, "channel pre-connect still connecting...");
                            return;
                        }
                    }
                    w.i(this.rjs.TAG, "isPreConnect is false");
                    this.rjs.rgj.bpt();
                    this.rjs.rgj.bps();
                } else if (i == 4) {
                    this.rjs.rgj.rfQ.rlo.rgD = 12;
                    this.rjs.rgj.rfQ.rlo.rgE = i2;
                    this.rjs.rgj.q(1, i2, "");
                } else {
                    this.rjs.rgj.rfQ.rlo.rgD = 12;
                    this.rjs.rgj.rfQ.rlo.rgE = i2;
                    this.rjs.rgj.q(1, -9004, "");
                }
            }
        };
    }
}
