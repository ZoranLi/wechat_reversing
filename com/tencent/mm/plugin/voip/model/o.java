package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.a.m;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bkt;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.blj;
import com.tencent.mm.protocal.c.blu;
import com.tencent.mm.protocal.c.blw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class o {
    e rew = null;
    blf rjn = new blf();
    private bku rjo = null;
    private int rjp = 0;

    public o(e eVar) {
        this.rew = eVar;
    }

    private void a(bku com_tencent_mm_protocal_c_bku) {
        if (com_tencent_mm_protocal_c_bku == null) {
            a.dI("MicroMsg.Voip.VoipSyncHandle", "failed to pushVoipCmdList , VoipCmdList = null");
            this.rjp++;
            return;
        }
        if (this.rjo == null) {
            this.rjo = new bku();
        }
        for (int i = 0; i < com_tencent_mm_protocal_c_bku.jNd; i++) {
            this.rjo.jNe.add((bkt) com_tencent_mm_protocal_c_bku.jNe.get(i));
        }
        this.rjo.jNd = this.rjo.jNe.size();
    }

    private void b(bku com_tencent_mm_protocal_c_bku) {
        if (this.rjo != null && this.rjo.jNd > 0) {
            for (int i = 0; i < this.rjo.jNd; i++) {
                com_tencent_mm_protocal_c_bku.jNe.add((bkt) this.rjo.jNe.get(i));
            }
            com_tencent_mm_protocal_c_bku.jNd = com_tencent_mm_protocal_c_bku.jNe.size();
            bqz();
        }
    }

    public final void bqz() {
        if (this.rjo != null) {
            this.rjo.jNe.clear();
            this.rjo.jNd = 0;
            this.rjo = null;
            this.rjp = 0;
        }
    }

    public final int a(bku com_tencent_mm_protocal_c_bku, boolean z, int i) {
        if (this.rew.rfQ.mNL == 0) {
            a.dI("MicroMsg.Voip.VoipSyncHandle", g.sd() + "failed to do voip sync , roomid = 0");
        } else if (this.rew.rfW) {
            a.dI("MicroMsg.Voip.VoipSyncHandle", g.sd() + "voip syncing, push to cache...");
            a(com_tencent_mm_protocal_c_bku);
        } else {
            bku com_tencent_mm_protocal_c_bku2;
            this.rew.rfW = true;
            if (com_tencent_mm_protocal_c_bku == null) {
                com_tencent_mm_protocal_c_bku2 = new bku();
                com_tencent_mm_protocal_c_bku2.jNd = 0;
                com_tencent_mm_protocal_c_bku2.jNe = new LinkedList();
            } else {
                com_tencent_mm_protocal_c_bku2 = com_tencent_mm_protocal_c_bku;
            }
            b(com_tencent_mm_protocal_c_bku2);
            this.rjp = 0;
            if (this.rew.rfU == null) {
                this.rew.rfU = "".getBytes();
            }
            a.dJ("MicroMsg.Voip.VoipSyncHandle", "doSync fromjni:" + z + " cmdList:" + com_tencent_mm_protocal_c_bku2.jNd + ",syncKey.length=" + this.rew.rfU.length);
            new m(this.rew.rfQ.mNL, com_tencent_mm_protocal_c_bku2, this.rew.rfU, this.rew.rfQ.mNM, i).bqD();
        }
        return 0;
    }

    public final void a(blu com_tencent_mm_protocal_c_blu, int i) {
        a.dK("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged:  status:" + com_tencent_mm_protocal_c_blu.jNB);
        if (com_tencent_mm_protocal_c_blu.jNB == 1) {
            h hVar;
            this.rew.rfp = true;
            if (1 == i) {
                hVar = this.rew.rfQ.rlo;
                if (0 == hVar.rhf) {
                    hVar.rhf = System.currentTimeMillis();
                    a.dJ("MicroMsg.VoipDailReport", "accept received timestamp:" + hVar.rhf);
                }
            }
            if (3 == i) {
                hVar = this.rew.rfQ.rlo;
                if (0 == hVar.rhg) {
                    hVar.rhg = System.currentTimeMillis();
                    a.dJ("MicroMsg.VoipDailReport", "sync accept received timestamp:" + hVar.rhg);
                }
            }
            a.dK("MicroMsg.Voip.VoipSyncHandle", "zhengxue[DataAccept]onVoipSyncStatus:ACCEPTdata Flag: " + i);
            this.rew.rfR.aDA();
            d.bpd().riE.bqy();
            this.rew.rfq = true;
            if (this.rew.rfs) {
                this.rew.rfs = false;
                if (this.rew.rfn) {
                    a.dK("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT, pre-connect already success");
                    this.rew.bpo();
                } else if (this.rew.rfr) {
                    a.dJ("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect already fail");
                    this.rew.q(1, -9000, "");
                } else {
                    a.dJ("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect still connecting...");
                }
            }
            com.tencent.mm.plugin.report.service.g.oUh.i(11519, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(2)});
            this.rew.bps();
            this.rew.bpt();
        } else if (com_tencent_mm_protocal_c_blu.jNB == 6) {
            a.dK("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACKED");
            a.dK("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: try use pre-connect");
            this.rew.rfs = true;
            this.rew.rfQ.rkn = 1;
            this.rew.bps();
        } else if (com_tencent_mm_protocal_c_blu.jNB == 8) {
            a.dJ("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACK BUSY");
            this.rew.rfQ.rlo.rgE = com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX;
            this.rew.rfQ.rlo.rgD = 11;
            this.rew.rfQ.rlo.rgP = 12;
            com.tencent.mm.plugin.report.service.g.oUh.i(11519, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(3)});
            this.rew.q(1, com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX, "");
            this.rew.bpt();
        } else if (com_tencent_mm_protocal_c_blu.jNB == 2) {
            a.dK("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_REJECT");
            this.rew.rfQ.rlo.rgD = 103;
            this.rew.rfQ.rlo.rgP = 4;
            this.rew.rfQ.rlo.rgW = (int) (System.currentTimeMillis() - this.rew.rfQ.rlo.beginTime);
            com.tencent.mm.plugin.report.service.g.oUh.i(11519, new Object[]{Integer.valueOf(d.bpd().bqh()), Long.valueOf(d.bpd().bqi()), Long.valueOf(d.bpd().bqj()), Integer.valueOf(1)});
            this.rew.bpt();
            this.rew.q(4, 0, "");
        } else if (com_tencent_mm_protocal_c_blu.jNB == 3) {
            this.rew.rfQ.rlo.rgP = 5;
        } else if (com_tencent_mm_protocal_c_blu.jNB == 4) {
            a.dK("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_SHUTDOWN");
            if (this.rew.mStatus < 6) {
                this.rew.rfQ.rlo.rgQ = 1;
            }
            this.rew.rfQ.rlo.rgD = MMGIFException.D_GIF_ERR_CLOSE_FAILED;
            this.rew.q(6, 0, "");
            this.rew.bpt();
        } else {
            a.dK("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged: unknow status:" + com_tencent_mm_protocal_c_blu.jNB);
        }
    }

    public final void a(blj com_tencent_mm_protocal_c_blj) {
        try {
            boolean z;
            blf com_tencent_mm_protocal_c_blf = (blf) new blf().aD(com_tencent_mm_protocal_c_blj.tij.tZp.toByteArray());
            if (!(com_tencent_mm_protocal_c_blf.ujn == null || com_tencent_mm_protocal_c_blf.ujn.tij == null || com_tencent_mm_protocal_c_blf.ujn.tij.tZp == null)) {
                this.rjn.ujn = com_tencent_mm_protocal_c_blf.ujn;
            }
            if (!(com_tencent_mm_protocal_c_blf.ujo.tij == null || com_tencent_mm_protocal_c_blf.ujo.tij.tZp == null)) {
                this.rjn.ujo = com_tencent_mm_protocal_c_blf.ujo;
            }
            if (com_tencent_mm_protocal_c_blf.ukA != 0) {
                this.rjn.ukA = com_tencent_mm_protocal_c_blf.ukA;
            }
            if (!(com_tencent_mm_protocal_c_blf.ukB == null || com_tencent_mm_protocal_c_blf.ukB.ujy == 0)) {
                this.rjn.ukB = com_tencent_mm_protocal_c_blf.ukB;
            }
            if (!(com_tencent_mm_protocal_c_blf.ukC == null || com_tencent_mm_protocal_c_blf.ukC.ujy == 0)) {
                this.rjn.ukC = com_tencent_mm_protocal_c_blf.ukC;
            }
            if (com_tencent_mm_protocal_c_blf.ukE != 0) {
                this.rjn.ukE = com_tencent_mm_protocal_c_blf.ukE;
            }
            if (com_tencent_mm_protocal_c_blf.ukF != 0) {
                this.rjn.ukF = com_tencent_mm_protocal_c_blf.ukF;
            }
            if (com_tencent_mm_protocal_c_blf.ukJ.ujy != 0) {
                this.rjn.ukJ = com_tencent_mm_protocal_c_blf.ukJ;
            }
            if (com_tencent_mm_protocal_c_blf.ukK > 0) {
                this.rjn.ukK = com_tencent_mm_protocal_c_blf.ukK;
            } else {
                this.rjn.ukK = 0;
                a.dJ("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQstrategy in mrdata");
            }
            if (com_tencent_mm_protocal_c_blf.mOi > 0) {
                this.rjn.mOi = com_tencent_mm_protocal_c_blf.mOi - 1;
                a.dJ("MicroMsg.Voip.VoipSyncHandle", "zhengxue[ENCRYPT] got encryptStrategy[" + this.rjn.mOi + "] from relaydata");
            } else {
                this.rjn.mOi = 1;
                a.dJ("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no EncryptStrategy in mrdata");
            }
            if (com_tencent_mm_protocal_c_blf.ukL > 0) {
                this.rjn.ukL = com_tencent_mm_protocal_c_blf.ukL;
                this.rjn.ukM = com_tencent_mm_protocal_c_blf.ukM;
                this.rjn.ukN = com_tencent_mm_protocal_c_blf.ukN;
                this.rjn.ukO = com_tencent_mm_protocal_c_blf.ukO;
                a.dJ("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got ARQCacheLen: " + com_tencent_mm_protocal_c_blf.ukL + ", ARQRttThreshold: " + com_tencent_mm_protocal_c_blf.ukM + ", ARQUsedRateThreshold: " + com_tencent_mm_protocal_c_blf.ukN + ", ARQRespRateThreshold: " + com_tencent_mm_protocal_c_blf.ukO);
            } else {
                a.dJ("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQKeyParameters in mrdata");
            }
            if (com_tencent_mm_protocal_c_blf.ukS > 0) {
                this.rjn.ukS = com_tencent_mm_protocal_c_blf.ukS;
            } else {
                this.rjn.ukS = 0;
                a.dJ("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no QosStrategy in mrdata");
            }
            this.rjn.ukV = com_tencent_mm_protocal_c_blf.ukV;
            if (this.rjn.ujn == null || this.rjn.ujn.tij == null || this.rjn.ujn.tij.tZp == null || this.rjn.ukA == 0 || this.rjn.ujo == null || this.rjn.ujo.tij == null || this.rjn.ujo.tij.tZp == null || this.rjn.ukB == null || this.rjn.ukB.ujy == 0 || this.rjn.ukC == null || this.rjn.ukC.ujy == 0 || this.rjn.ukJ == null || this.rjn.ukJ.ujy == 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                a.dJ("MicroMsg.Voip.VoipSyncHandle", "multiRelayData recv all, update. RedirectReqThreshold = " + this.rjn.ukV + " BothSideSwitchFlag = " + com_tencent_mm_protocal_c_blf.ukW);
                this.rew.uP(this.rjn.ukA);
                this.rew.aH(this.rjn.ujn.tij.tZp.toByteArray());
                if (!(com_tencent_mm_protocal_c_blf.ukH == null || com_tencent_mm_protocal_c_blf.ukH.tZp == null || com_tencent_mm_protocal_c_blf.ukT == null || com_tencent_mm_protocal_c_blf.ukT.tZp == null)) {
                    this.rew.a(com_tencent_mm_protocal_c_blf.ukH.tZp.toByteArray(), com_tencent_mm_protocal_c_blf.ukG, this.rjn.mOi, com_tencent_mm_protocal_c_blf.ukT.tZp.toByteArray());
                }
                if (d.bpd().bqh() != 0) {
                    this.rew.aI(this.rjn.ujo.tij.tZp.toByteArray());
                }
                this.rew.a(this.rjn.ukB, this.rjn.ukC, this.rjn.ukJ);
                this.rew.g(this.rjn.ukK, this.rjn.ukL, this.rjn.ukM, this.rjn.ukN, this.rjn.ukO);
                this.rew.uO(this.rjn.ukS);
                e eVar = this.rew;
                int i = this.rjn.ukE;
                int i2 = this.rjn.ukF;
                eVar.rfQ.rjR = i;
                eVar.rfQ.rjS = i2;
                this.rew.uN(this.rjn.ukV);
                this.rew.rfQ.rkK = com_tencent_mm_protocal_c_blf.ukW;
                if (!(com_tencent_mm_protocal_c_blf.ukQ == null || com_tencent_mm_protocal_c_blf.ukQ.tZp == null || com_tencent_mm_protocal_c_blf.ukR == null || com_tencent_mm_protocal_c_blf.ukR.tZp == null)) {
                    this.rew.b(com_tencent_mm_protocal_c_blf.ukP, com_tencent_mm_protocal_c_blf.ukQ.tZp.toByteArray(), com_tencent_mm_protocal_c_blf.ukR.tZp.toByteArray());
                }
                this.rew.rfs = true;
                this.rew.bps();
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
        }
    }

    public final void b(blj com_tencent_mm_protocal_c_blj) {
        e eVar = this.rew;
        eVar.rfQ.rjO = com_tencent_mm_protocal_c_blj.tij.tZp.toByteArray();
        if (eVar.rfm && !bg.bm(eVar.rfQ.rjO)) {
            int handleCommand = eVar.rfQ.handleCommand(eVar.rfQ.rjO, eVar.rfQ.rjO.length);
            if (handleCommand < 0) {
                a.dI("MicroMsg.Voip.VoipContext", "v2protocal handlecommand failed ret:" + handleCommand);
            }
            eVar.rfQ.rjO = null;
        }
    }

    public final void c(avw com_tencent_mm_protocal_c_avw) {
        int aM = a.aM(com_tencent_mm_protocal_c_avw.tZp.toByteArray());
        a.dK("MicroMsg.Voip.VoipSyncHandle", "voipSync remote status changed, status = " + aM);
        e eVar = this.rew;
        aM &= 255;
        if (8 == aM || 9 == aM) {
            eVar.rfI = aM;
        } else {
            eVar.rfG = aM;
            eVar.rfE = aM;
        }
        if (1 == aM || 3 == aM) {
            eVar.uM(2);
        }
        eVar.rfR.uV(aM);
    }

    public final void n(k kVar) {
        this.rew.rfW = false;
        blw com_tencent_mm_protocal_c_blw = (blw) ((m) kVar).bqE();
        this.rew.rfQ.parseSyncKeyBuff(this.rew.rfU, this.rew.rfU.length);
        int i = this.rew.rfQ.field_statusSyncKey;
        int i2 = this.rew.rfQ.field_relayDataSyncKey;
        int i3 = this.rew.rfQ.field_connectingStatusKey;
        this.rew.rfQ.parseSyncKeyBuff(com_tencent_mm_protocal_c_blw.tob.tZp.toByteArray(), com_tencent_mm_protocal_c_blw.tob.tZn);
        int i4 = this.rew.rfQ.field_statusSyncKey;
        int i5 = this.rew.rfQ.field_relayDataSyncKey;
        int i6 = this.rew.rfQ.field_connectingStatusKey;
        w.d("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: oldStatusSyncKey:" + i + " oldRelayDataSyncKey:" + i2 + " oldConnectingStatusSyncKey:" + i3);
        w.d("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: newStatusSyncKey:" + i4 + " newRelayDataSyncKey:" + i5 + " newConnectingStatusSyncKey:" + i6);
        this.rew.rfU = com_tencent_mm_protocal_c_blw.tob.tZp.toByteArray();
        w.d("MicroMsg.Voip.VoipSyncHandle", "voipSync response: continueflag=" + com_tencent_mm_protocal_c_blw.tlZ);
        LinkedList linkedList = com_tencent_mm_protocal_c_blw.ulD.jNe;
        if (!(linkedList == null || linkedList.size() == 0)) {
            w.d("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size" + linkedList.size());
            w.d("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size:" + linkedList.size() + ",selector = " + ((m) kVar).bqC());
            for (int i7 = 0; i7 < linkedList.size(); i7++) {
                bkt com_tencent_mm_protocal_c_bkt = (bkt) linkedList.get(i7);
                int i8 = com_tencent_mm_protocal_c_bkt.tsa;
                if (i8 == 1) {
                    if (i4 > i) {
                        if (this.rew.rfQ.mNL == 0) {
                            a.dI("MicroMsg.Voip.VoipSyncHandle", "voipSyncStatus ignored , roomid = 0");
                        } else {
                            try {
                                blu com_tencent_mm_protocal_c_blu = (blu) new blu().aD(com_tencent_mm_protocal_c_bkt.tsb.tZp.toByteArray());
                                a.dK("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus in...from user=" + com_tencent_mm_protocal_c_bkt.mvV + ",itemStatus =  " + com_tencent_mm_protocal_c_blu.jNB);
                                a(com_tencent_mm_protocal_c_blu, 3);
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
                            }
                        }
                    }
                } else if (i8 == 2) {
                    if (i5 > i2) {
                        if (this.rew.rfQ.mNL == 0) {
                            a.dI("MicroMsg.Voip.VoipSyncHandle", "RelayData ignored , roomid = 0");
                        } else {
                            try {
                                blj com_tencent_mm_protocal_c_blj = (blj) new blj().aD(com_tencent_mm_protocal_c_bkt.tsb.tZp.toByteArray());
                                a.dK("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncRelayData ...relayType = " + com_tencent_mm_protocal_c_blj.jOc + ",from user = " + com_tencent_mm_protocal_c_bkt.mvV);
                                if (com_tencent_mm_protocal_c_blj.jOc == 5) {
                                    a(com_tencent_mm_protocal_c_blj);
                                } else if (com_tencent_mm_protocal_c_blj.jOc == 3) {
                                    this.rew.aI(com_tencent_mm_protocal_c_blj.tij.tZp.toByteArray());
                                    if (!(com_tencent_mm_protocal_c_blj.tij == null || com_tencent_mm_protocal_c_blj.tij.tZp == null)) {
                                        this.rjn.ujo = com_tencent_mm_protocal_c_blj;
                                    }
                                } else if (com_tencent_mm_protocal_c_blj.jOc == 2) {
                                    this.rew.aH(com_tencent_mm_protocal_c_blj.tij.tZp.toByteArray());
                                    if (!(com_tencent_mm_protocal_c_blj.tij == null || com_tencent_mm_protocal_c_blj.tij.tZp == null)) {
                                        this.rjn.ujn = com_tencent_mm_protocal_c_blj;
                                    }
                                } else if (com_tencent_mm_protocal_c_blj.jOc == 1) {
                                    b(com_tencent_mm_protocal_c_blj);
                                }
                            } catch (Throwable e2) {
                                w.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e2, "", new Object[0]);
                            }
                        }
                    }
                } else if (i8 == 3 && i6 > i3) {
                    if (this.rew.rfQ.mNL == 0) {
                        w.e("MicroMsg.Voip.VoipSyncHandle", "voipSync(ClientStatus) ignored , roomid = 0");
                    } else {
                        try {
                            avw bc = new avw().bc(com_tencent_mm_protocal_c_bkt.tsb.tZp.toByteArray());
                            if (com_tencent_mm_protocal_c_bkt.mvV.equals(com.tencent.mm.u.m.xL())) {
                                a.dI("MicroMsg.Voip.VoipSyncHandle", "svr response: local connecting status changed.");
                            } else {
                                c(bc);
                            }
                        } catch (Throwable e22) {
                            w.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e22, "", new Object[0]);
                        }
                    }
                }
            }
        }
        if ((this.rjo != null && this.rjo.jNd > 0) || this.rjp > 0) {
            a(null, false, 7);
        }
    }
}
