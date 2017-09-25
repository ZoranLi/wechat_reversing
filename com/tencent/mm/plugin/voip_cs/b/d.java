package com.tencent.mm.plugin.voip_cs.b;

import android.os.Looper;
import com.tencent.mm.plugin.brandservice.a.j;
import com.tencent.mm.plugin.voip_cs.b.c.b;
import com.tencent.mm.plugin.voip_cs.b.c.c;
import com.tencent.mm.plugin.voip_cs.b.c.f;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.protocal.c.bjx;
import com.tencent.mm.protocal.c.bjy;
import com.tencent.mm.protocal.c.bkc;
import com.tencent.mm.protocal.c.bke;
import com.tencent.mm.protocal.c.bki;
import com.tencent.mm.protocal.c.bkl;
import com.tencent.mm.protocal.c.bko;
import com.tencent.mm.protocal.c.bkq;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Arrays;
import java.util.List;

public final class d implements e {
    public int mNW = 0;
    public int rga = 0;
    public int rrJ = 0;
    public a rsm;
    public int rsn = 0;
    public int rso = 0;
    public int rsp = 0;
    public byte[] rsq = null;
    public int rsr = 0;
    public int rss = 0;
    public int rst = 0;
    public String rsu = "";
    public int rsv = 0;
    public aj rsw = new aj(Looper.getMainLooper(), new a(this) {
        final /* synthetic */ d rsy;

        {
            this.rsy = r1;
        }

        public final boolean oQ() {
            w.v("MicroMsg.voipcs.VoipCSService", "voipcs repeat sync");
            this.rsy.brT();
            return true;
        }
    }, true);
    public aj rsx = new aj(Looper.getMainLooper(), new a(this) {
        final /* synthetic */ d rsy;

        {
            this.rsy = r1;
        }

        public final boolean oQ() {
            w.v("MicroMsg.voipcs.VoipCSService", "voipcs heart beat");
            ap.vd().a(795, this.rsy);
            ap.vd().a(new b(b.brN().mOV.rjL, b.brN().mOV.mNM), 0);
            return true;
        }
    }, true);

    public final void brT() {
        ap.vd().a(818, this);
        ap.vd().a(new f(b.brN().mOV.rjL, b.brN().mOV.mNM, this.rsn), 0);
    }

    private static void b(int i, int i2, k kVar) {
        w.i("MicroMsg.voipcs.VoipCSService", "Redirect response:" + i + " errCode:" + i2);
        if (i2 != 0) {
            w.i("MicroMsg.voipcs.VoipCSService", " redirect response with error code:" + i2);
            return;
        }
        bkl com_tencent_mm_protocal_c_bkl = (bkl) ((com.tencent.mm.plugin.voip_cs.b.c.d) kVar).gUA.hsk.hsr;
        w.i("MicroMsg.voipcs.VoipCSService", "roomid " + com_tencent_mm_protocal_c_bkl.ujT + " key " + com_tencent_mm_protocal_c_bkl.tvM + "relay addr cnt " + com_tencent_mm_protocal_c_bkl.thS.size());
        List<bkc> list = com_tencent_mm_protocal_c_bkl.thS;
        bjy com_tencent_mm_protocal_c_bjy = new bjy();
        for (bkc com_tencent_mm_protocal_c_bkc : list) {
            bjx com_tencent_mm_protocal_c_bjx = new bjx();
            b.brN();
            com_tencent_mm_protocal_c_bjx.ufq = com.tencent.mm.plugin.voip_cs.b.b.a.HL(com_tencent_mm_protocal_c_bkc.tNy);
            com_tencent_mm_protocal_c_bjx.tVV = com_tencent_mm_protocal_c_bkc.tVV;
            com_tencent_mm_protocal_c_bjy.ujz.add(com_tencent_mm_protocal_c_bjx);
        }
        com_tencent_mm_protocal_c_bjy.ujy = list.size();
        b.brN().mOV.a(com_tencent_mm_protocal_c_bjy, com_tencent_mm_protocal_c_bjy, null, 0, 0);
    }

    public final void a(bkq com_tencent_mm_protocal_c_bkq) {
        if (com_tencent_mm_protocal_c_bkq.ukb > this.rsn && b.brO().rst != 3) {
            w.i("MicroMsg.voipcs.VoipCSService", "get callee sync resp,notifySeq:" + com_tencent_mm_protocal_c_bkq.ukb + ",calleeMemberId:" + com_tencent_mm_protocal_c_bkq.ukc + ",calleeStatus:" + com_tencent_mm_protocal_c_bkq.ukd + ",calleeSubStatus:" + com_tencent_mm_protocal_c_bkq.uke + ",recv roomId:" + com_tencent_mm_protocal_c_bkq.ujT + ",recv roomKey:" + com_tencent_mm_protocal_c_bkq.tvM);
            if (b.brN().mOV.rjL == 0 || b.brN().mOV.rjL == com_tencent_mm_protocal_c_bkq.ujT) {
                this.rsn = com_tencent_mm_protocal_c_bkq.ukb;
                this.rrJ = com_tencent_mm_protocal_c_bkq.ukc;
                this.rso = com_tencent_mm_protocal_c_bkq.ukd;
                this.rsp = com_tencent_mm_protocal_c_bkq.uke;
                b.brP().rrJ = this.rrJ;
                if (this.rso == 2) {
                    w.i("MicroMsg.voipcs.VoipCSService", "callee accept!");
                    this.rsw.KH();
                    brT();
                    b.brN().mOV.mNM = com_tencent_mm_protocal_c_bkq.tvM;
                    w.i("MicroMsg.voipcs.VoipCSService", "csroomId:" + com_tencent_mm_protocal_c_bkq.ujT + ",roomkey:" + com_tencent_mm_protocal_c_bkq.tvM);
                    this.rsq = com_tencent_mm_protocal_c_bkq.ukf != null ? com_tencent_mm_protocal_c_bkq.ukf.toByteArray() : null;
                    if (b.brN().mOV.field_capInfo != null && this.rsq != null) {
                        int i;
                        c brP = b.brP();
                        w.d("MicroMsg.VoipCSReportHelper", "markUserAccept");
                        if (brP.rrW == 0) {
                            brP.rsi = (int) (System.currentTimeMillis() / 1000);
                            brP.rrW = (long) (brP.rsi - brP.rsg);
                        }
                        b.brN().mOV.rjN = this.rsq;
                        w.i("MicroMsg.voipcs.VoipCSService", "calleeCapDump is " + Arrays.toString(b.brN().mOV.rjN));
                        w.i("MicroMsg.voipcs.VoipCSService", "calleeCap length:" + this.rsq.length);
                        if (b.brN().mOV.rjN != null && b.brN().mOV.exchangeCabInfo(b.brN().mOV.rjN, b.brN().mOV.rjN.length) < 0) {
                            w.i("MicroMsg.voipcs.VoipCSService", "exchangeCabInfo fail!");
                        }
                        if (b.brN().mOV.rjQ == null) {
                            i = 0;
                        } else {
                            i = b.brN().mOV.rjQ.length;
                        }
                        if (b.brN().mOV.setConfigConnect(b.brN().mOV.rjK, b.brN().mOV.rjL, b.brN().mOV.mNT, b.brN().mOV.mNM, b.brN().mOV.field_peerId, 1, b.brN().mOV.rjR, b.brN().mOV.rjS, b.brN().mOV.rjP, i, b.brN().mOV.rjQ, b.brN().mOV.rjT, 1, b.brN().mOV.netType, b.brN().mOV.rkH, b.brN().mOV.rkI, 255, 0) != 0) {
                            w.e("MicroMsg.voipcs.VoipCSService", "setConfig fail..");
                        }
                        if (this.rsx.bJq()) {
                            this.rsx.v(50000, 50000);
                        }
                        b.brP().rrP = 1;
                        return;
                    }
                    return;
                } else if (this.rso != 0 && this.rso != 1 && this.rso == 3) {
                    w.i("MicroMsg.voipcs.VoipCSService", "callee hangup!");
                    b.brP().aMw = 5;
                    b.brP().brQ();
                    b.brP().rrT = 2;
                    if (this.rsp == 1) {
                        b.brP().rrL = 12;
                    } else if (this.rsp == 3) {
                        b.brP().rrL = 99;
                    }
                    if (this.rsm != null) {
                        this.rsm.vn(1);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            w.i("MicroMsg.voipcs.VoipCSService", "csRoomId:" + b.brN().mOV.rjL + ",recv roomId:" + com_tencent_mm_protocal_c_bkq.ujT + ",current and recv not equal!!");
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            w.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd  resp error!:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i != 0 && i != 4) {
                this.rsv = -1;
                this.rsm.onError(10);
            } else if (kVar.getType() == 823) {
                if (i2 == 406) {
                    w.i("MicroMsg.voipcs.VoipCSService", "CS_INVITE_RESP_REPEAT_INVTIE 503..");
                    return;
                }
                b.brP().aMw = 1;
                this.rsv = 823;
                this.rsm.onError(i2);
            } else if (kVar.getType() != 880 && kVar.getType() != 818 && kVar.getType() == 455) {
                this.rsm.dM("", "");
            }
        } else if (kVar.getType() == 823) {
            bki com_tencent_mm_protocal_c_bki = (bki) ((c) kVar).gUA.hsk.hsr;
            long j = com_tencent_mm_protocal_c_bki.ujT;
            long j2 = com_tencent_mm_protocal_c_bki.tvM;
            List<bkc> list = com_tencent_mm_protocal_c_bki.thS;
            this.mNW = com_tencent_mm_protocal_c_bki.ujY;
            b.brN().mOV.rjS = com_tencent_mm_protocal_c_bki.mOd;
            this.rsr = com_tencent_mm_protocal_c_bki.mNX;
            b.brN().mOV.rkH = com_tencent_mm_protocal_c_bki.mOi;
            b.brN().mOV.rkI = com_tencent_mm_protocal_c_bki.tWm.toByteArray();
            b.brN().mOV.rjR = com_tencent_mm_protocal_c_bki.mOe;
            bjy com_tencent_mm_protocal_c_bjy = new bjy();
            for (bkc com_tencent_mm_protocal_c_bkc : list) {
                bjx com_tencent_mm_protocal_c_bjx = new bjx();
                b.brN();
                com_tencent_mm_protocal_c_bjx.ufq = com.tencent.mm.plugin.voip_cs.b.b.a.HL(com_tencent_mm_protocal_c_bkc.tNy);
                com_tencent_mm_protocal_c_bjx.tVV = com_tencent_mm_protocal_c_bkc.tVV;
                com_tencent_mm_protocal_c_bjy.ujz.add(com_tencent_mm_protocal_c_bjx);
            }
            com_tencent_mm_protocal_c_bjy.ujy = list.size();
            b.brN().mOV.rjL = j;
            b.brN().mOV.mNM = j2;
            w.i("MicroMsg.voipcs.VoipCSService", "recv invite resp csRoomId : " + j + ",roomKey:" + j2);
            b.brN().mOV.rkR = com_tencent_mm_protocal_c_bki.ujZ;
            b.brN().mOV.rkS = com_tencent_mm_protocal_c_bki.uka;
            if (b.brN().mOV.b(com_tencent_mm_protocal_c_bjy, com_tencent_mm_protocal_c_bjy, com_tencent_mm_protocal_c_bjy) != 0) {
                w.i("MicroMsg.voipcs.VoipCSService", "setIp fail!");
            }
            c brP = b.brP();
            r1 = this.rsu;
            w.d("MicroMsg.VoipCSReportHelper", "setVoipCSBaseInfo");
            brP.rrH = j;
            brP.mNM = j2;
            brP.rrI = r1;
            if (this.rsw.bJq()) {
                if (this.mNW > 0) {
                    j = (long) (this.mNW * 1000);
                    this.rsw.v(j, j);
                } else {
                    this.rsw.v(4000, 4000);
                }
            }
            brP = b.brP();
            w.d("MicroMsg.VoipCSReportHelper", "markRecvInvite");
            if (brP.rsg != 0) {
                brP.rsh = (int) (System.currentTimeMillis() / 1000);
            }
        } else if (kVar.getType() == 818) {
            bkq com_tencent_mm_protocal_c_bkq = (bkq) ((f) kVar).gUA.hsk.hsr;
            w.i("MicroMsg.voipcs.VoipCSService", "sync status = " + com_tencent_mm_protocal_c_bkq.ukd + ",notifySeq = " + com_tencent_mm_protocal_c_bkq.ukb);
            a(com_tencent_mm_protocal_c_bkq);
        } else if (kVar.getType() == 880) {
            bke com_tencent_mm_protocal_c_bke = (bke) ((com.tencent.mm.plugin.voip_cs.b.c.a) kVar).gUA.hsk.hsr;
            if (b.brN().mOV.rjL == com_tencent_mm_protocal_c_bke.ujT && b.brN().mOV.mNM == com_tencent_mm_protocal_c_bke.tvM) {
                w.i("MicroMsg.voipcs.VoipCSService", "hangup success!");
            }
            ap.vd().b(880, this);
            b.brP().vo(com.tencent.mm.plugin.voip_cs.b.a.a.brV().riY.brC());
        } else if (kVar.getType() == 455) {
            j jVar = (j) kVar;
            r1 = "";
            String str2 = "";
            if (jVar.jZr == null || jVar.jZr.size() <= 0) {
                w.i("MicroMsg.voipcs.VoipCSService", "search Or Recommend items is null or empty !");
            } else {
                axg com_tencent_mm_protocal_c_axg = (axg) jVar.jZr.get(0);
                r1 = com_tencent_mm_protocal_c_axg.tqb;
                str2 = com_tencent_mm_protocal_c_axg.tLj.tZr;
            }
            this.rsm.dM(r1, str2);
        } else if (kVar.getType() == 285) {
            b(i, i2, kVar);
        } else if (kVar.getType() == 312) {
            bko com_tencent_mm_protocal_c_bko = (bko) ((com.tencent.mm.plugin.voip_cs.b.c.e) kVar).gUA.hsk.hsr;
            if (com_tencent_mm_protocal_c_bko.ujT == b.brN().mOV.rjL && com_tencent_mm_protocal_c_bko.tvM == b.brN().mOV.mNM) {
                w.i("MicroMsg.voipcs.VoipCSService", "report data success!");
            }
        }
    }
}
