package com.tencent.mm.modelmulti;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.e.a.jh;
import com.tencent.mm.e.a.lh;
import com.tencent.mm.e.a.nf;
import com.tencent.mm.e.a.qh;
import com.tencent.mm.e.a.qz;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelfriend.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.agf;
import com.tencent.mm.protocal.c.alw;
import com.tencent.mm.protocal.c.alz;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.amo;
import com.tencent.mm.protocal.c.amv;
import com.tencent.mm.protocal.c.ank;
import com.tencent.mm.protocal.c.asg;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.protocal.c.bil;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.bv;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.x.d;
import com.tencent.mm.x.e;
import com.tencent.mm.x.h;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.Map;
import junit.framework.Assert;

public final class a implements p {
    public final void a(lu luVar, byte[] bArr, boolean z, r rVar) {
        String a;
        af Rc;
        b lhVar;
        h hVar;
        String xL;
        int i;
        switch (luVar.tsa) {
            case 13:
                amo com_tencent_mm_protocal_c_amo = (amo) new amo().aD(bArr);
                if (1 == com_tencent_mm_protocal_c_amo.tRk) {
                    ap.yY();
                    c.wZ().c(n.a(com_tencent_mm_protocal_c_amo.ttp), com_tencent_mm_protocal_c_amo.tQU == 1, com_tencent_mm_protocal_c_amo.tRl == 1);
                    return;
                }
                w.e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + com_tencent_mm_protocal_c_amo.tRk);
                return;
            case 15:
                alz com_tencent_mm_protocal_c_alz = (alz) new alz().aD(bArr);
                if (com_tencent_mm_protocal_c_alz != null) {
                    w.d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + com_tencent_mm_protocal_c_alz.ttp + " nickname:" + com_tencent_mm_protocal_c_alz.tLj);
                    a = n.a(com_tencent_mm_protocal_c_alz.ttp);
                    ap.yY();
                    af Rc2 = c.wR().Rc(a);
                    Rc2.setUsername(a);
                    Rc2.bR(n.a(com_tencent_mm_protocal_c_alz.tLj));
                    Rc2.bS(n.a(com_tencent_mm_protocal_c_alz.ttf));
                    Rc2.bT(n.a(com_tencent_mm_protocal_c_alz.ttg));
                    Rc2.di(com_tencent_mm_protocal_c_alz.hAD);
                    Rc2.bP(n.a(com_tencent_mm_protocal_c_alz.tQl));
                    Rc2.bV(n.a(com_tencent_mm_protocal_c_alz.tQn));
                    Rc2.bW(n.a(com_tencent_mm_protocal_c_alz.tQm));
                    Rc2.dl(com_tencent_mm_protocal_c_alz.tsD);
                    h hVar2 = new h();
                    hVar2.fRW = -1;
                    hVar2.username = Rc2.field_username;
                    hVar2.hrA = com_tencent_mm_protocal_c_alz.tqc;
                    hVar2.hrB = com_tencent_mm_protocal_c_alz.tqb;
                    w.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", hVar2.getUsername(), hVar2.Bs(), hVar2.Bt());
                    hVar2.aV(true);
                    if (com_tencent_mm_protocal_c_alz.tQB == 3 || com_tencent_mm_protocal_c_alz.tQB == 4) {
                        Rc2.dh(com_tencent_mm_protocal_c_alz.tQB);
                        hVar2.gkq = com_tencent_mm_protocal_c_alz.tQB;
                    } else if (com_tencent_mm_protocal_c_alz.tQB == 2) {
                        Rc2.dh(3);
                        hVar2.gkq = 3;
                        Rc2.dh(3);
                        if (!m.xL().equals(Rc2.field_username)) {
                            com.tencent.mm.x.n.Bl();
                            d.s(Rc2.field_username, false);
                            com.tencent.mm.x.n.Bl();
                            d.s(Rc2.field_username, true);
                            com.tencent.mm.x.n.Bz().hf(Rc2.field_username);
                        }
                    }
                    com.tencent.mm.x.n.Bm().a(hVar2);
                    ap.yY();
                    c.wR().Q(Rc2);
                    BizInfo hO = com.tencent.mm.modelbiz.w.DH().hO(Rc2.field_username);
                    hO.field_username = Rc2.field_username;
                    hO.field_brandList = com_tencent_mm_protocal_c_alz.hAN;
                    my myVar = com_tencent_mm_protocal_c_alz.tMW;
                    if (myVar != null) {
                        hO.field_brandFlag = myVar.hAR;
                        hO.field_brandInfo = myVar.hAT;
                        hO.field_brandIconURL = myVar.hAU;
                        hO.field_extInfo = myVar.hAS;
                    }
                    if (!com.tencent.mm.modelbiz.w.DH().e(hO)) {
                        com.tencent.mm.modelbiz.w.DH().d(hO);
                        return;
                    }
                    return;
                }
                return;
            case 22:
                agf com_tencent_mm_protocal_c_agf = (agf) new agf().aD(bArr);
                q qVar = new q();
                qVar.username = com_tencent_mm_protocal_c_agf.jNj;
                qVar.hBx = com_tencent_mm_protocal_c_agf.tLk;
                qVar.hve = (int) bg.Ny();
                com.tencent.mm.modelfriend.af.Gc().a(qVar);
                return;
            case 23:
                su suVar = (su) new su().aD(bArr);
                switch (suVar.tAG) {
                    case 1:
                        ap.yY();
                        c.vr().set(17, Integer.valueOf(suVar.tAH));
                        return;
                    case 4:
                        return;
                    default:
                        w.e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + suVar.tAG);
                        return;
                }
            case 24:
                asg com_tencent_mm_protocal_c_asg = (asg) new asg().aD(bArr);
                Assert.assertTrue(com_tencent_mm_protocal_c_asg != null);
                Assert.assertTrue(bg.mz(com_tencent_mm_protocal_c_asg.jNj).length() > 0);
                if (x.QO(com_tencent_mm_protocal_c_asg.jNj)) {
                    ap.yY();
                    Rc = c.wR().Rc(com_tencent_mm_protocal_c_asg.jNj);
                    if (Rc == null || ((int) Rc.gTQ) == 0) {
                        Rc = new x(com_tencent_mm_protocal_c_asg.jNj);
                        Rc.ti();
                        Rc.bR(com_tencent_mm_protocal_c_asg.tqa);
                        Rc.bP(com_tencent_mm_protocal_c_asg.tqa);
                        Rc.dl(4);
                        ap.yY();
                        if (c.wR().S(Rc) == -1) {
                            w.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
                            return;
                        }
                        com.tencent.mm.x.b.hc(Rc.field_username);
                    } else if (!bg.mz(com_tencent_mm_protocal_c_asg.tqa).equals(bg.mz(Rc.field_username))) {
                        Rc.bR(com_tencent_mm_protocal_c_asg.tqa);
                        Rc.bP(com_tencent_mm_protocal_c_asg.tqa);
                        ap.yY();
                        if (c.wR().a(Rc.field_username, Rc) == -1) {
                            w.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
                        }
                    }
                    lhVar = new lh();
                    lhVar.fSb.opType = 1;
                    lhVar.fSb.fSf = com_tencent_mm_protocal_c_asg.jNj;
                    lhVar.fSb.fSg = com_tencent_mm_protocal_c_asg.tWF;
                    lhVar.fSb.fSh = com_tencent_mm_protocal_c_asg.tsK;
                    com.tencent.mm.sdk.b.a.urY.m(lhVar);
                    return;
                }
                w.w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
                return;
            case 25:
                bem com_tencent_mm_protocal_c_bem = (bem) new bem().aD(bArr);
                Assert.assertTrue(com_tencent_mm_protocal_c_bem != null);
                Assert.assertTrue(bg.mz(com_tencent_mm_protocal_c_bem.jNj).length() > 0);
                if (x.QM(com_tencent_mm_protocal_c_bem.jNj)) {
                    ap.yY();
                    Rc = c.wR().Rc(com_tencent_mm_protocal_c_bem.jNj);
                    if (Rc == null || ((int) Rc.gTQ) == 0) {
                        Rc = new x(com_tencent_mm_protocal_c_bem.jNj);
                        Rc.bP(com_tencent_mm_protocal_c_bem.tqa);
                        Rc.dl(1);
                        Rc.ti();
                        ap.yY();
                        if (c.wR().S(Rc) == -1) {
                            w.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: insert contact failed");
                            return;
                        }
                        a = Rc.field_username;
                        if (a == null) {
                            w.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
                        } else if (a.endsWith("@t.qq.com")) {
                            hVar = new h();
                            hVar.username = a;
                            hVar.gkq = 3;
                            hVar.fRW = 3;
                            com.tencent.mm.x.n.Bm().a(hVar);
                        } else {
                            w.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
                        }
                    } else if (!bg.mz(com_tencent_mm_protocal_c_bem.tqa).equals(bg.mz(Rc.field_username))) {
                        Rc.bP(com_tencent_mm_protocal_c_bem.tqa);
                        ap.yY();
                        if (c.wR().a(Rc.field_username, Rc) == -1) {
                            w.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
                        }
                    }
                    lhVar = new qh();
                    lhVar.fXn.opType = 1;
                    lhVar.fXn.fSf = com_tencent_mm_protocal_c_bem.jNj;
                    lhVar.fXn.fSg = com_tencent_mm_protocal_c_bem.tWF;
                    lhVar.fXn.fSh = com_tencent_mm_protocal_c_bem.tsK;
                    com.tencent.mm.sdk.b.a.urY.m(lhVar);
                    return;
                }
                w.w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
                return;
            case 33:
                alw com_tencent_mm_protocal_c_alw = (alw) new alw().aD(bArr);
                Assert.assertTrue(com_tencent_mm_protocal_c_alw != null);
                Assert.assertTrue(bg.mz(com_tencent_mm_protocal_c_alw.jNj).length() > 0);
                x xVar = new x();
                xVar.setUsername(com_tencent_mm_protocal_c_alw.jNj);
                xVar.setType(com_tencent_mm_protocal_c_alw.jOc);
                xVar.di(com_tencent_mm_protocal_c_alw.hAD);
                xVar.ck(RegionCodeDecoder.ab(com_tencent_mm_protocal_c_alw.hAM, com_tencent_mm_protocal_c_alw.hAE, com_tencent_mm_protocal_c_alw.hAF));
                xVar.ce(com_tencent_mm_protocal_c_alw.hAG);
                h hVar3 = new h();
                hVar3.fRW = -1;
                hVar3.username = com_tencent_mm_protocal_c_alw.jNj;
                hVar3.hrA = com_tencent_mm_protocal_c_alw.tqc;
                hVar3.hrB = com_tencent_mm_protocal_c_alw.tqb;
                w.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", hVar3.getUsername(), hVar3.Bs(), hVar3.Bt());
                w.d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + com_tencent_mm_protocal_c_alw.tQB + " hd:" + com_tencent_mm_protocal_c_alw.tQC);
                hVar3.aV(com_tencent_mm_protocal_c_alw.tQC != 0);
                if (com_tencent_mm_protocal_c_alw.tQB == 3 || com_tencent_mm_protocal_c_alw.tQB == 4) {
                    xVar.dh(com_tencent_mm_protocal_c_alw.tQB);
                    hVar3.gkq = com_tencent_mm_protocal_c_alw.tQB;
                } else if (com_tencent_mm_protocal_c_alw.tQB == 2) {
                    xVar.dh(3);
                    hVar3.gkq = 3;
                    com.tencent.mm.x.n.Bl();
                    d.s(com_tencent_mm_protocal_c_alw.jNj, false);
                    com.tencent.mm.x.n.Bl();
                    d.s(com_tencent_mm_protocal_c_alw.jNj, true);
                    com.tencent.mm.x.n.Bz().hf(com_tencent_mm_protocal_c_alw.jNj);
                } else {
                    xVar.dh(3);
                    hVar3.gkq = 3;
                }
                com.tencent.mm.x.n.Bm().a(hVar3);
                ap.yY();
                c.wR().P(xVar);
                return;
            case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                String str;
                amv com_tencent_mm_protocal_c_amv = (amv) new amv().aD(bArr);
                Assert.assertTrue(com_tencent_mm_protocal_c_amv != null);
                xL = m.xL();
                i = com_tencent_mm_protocal_c_amv.tlr;
                if (i == 2) {
                    xL = x.QR(xL);
                    ap.yY();
                    str = xL;
                    xL = (String) c.vr().get(12553, null);
                } else {
                    ap.yY();
                    str = xL;
                    xL = (String) c.vr().get(12297, null);
                }
                boolean z2 = false;
                if (xL == null || !xL.equals(com_tencent_mm_protocal_c_amv.tRq)) {
                    com.tencent.mm.x.n.Bl();
                    d.s(str, true);
                    ap.yY();
                    c.vr().set(i == 2 ? 12553 : 12297, com_tencent_mm_protocal_c_amv.tRq);
                    z2 = true;
                }
                w.d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", Boolean.valueOf(z2), Integer.valueOf(i), com_tencent_mm_protocal_c_amv.tRq, com_tencent_mm_protocal_c_amv.tqb, com_tencent_mm_protocal_c_amv.tqc);
                hVar = new h();
                hVar.username = str;
                hVar.hrB = com_tencent_mm_protocal_c_amv.tqb;
                hVar.hrA = com_tencent_mm_protocal_c_amv.tqc;
                if (!bg.mA(hVar.Bt())) {
                    if (i == 1) {
                        ap.yY();
                        c.vr().set(59, Boolean.valueOf(true));
                    } else {
                        ap.yY();
                        c.vr().set(60, Boolean.valueOf(true));
                    }
                }
                hVar.aV(false);
                hVar.fRW = 56;
                if (!bg.mA(com_tencent_mm_protocal_c_amv.tRq)) {
                    hVar.aV(true);
                }
                com.tencent.mm.x.n.Bm().a(hVar);
                if (z2) {
                    new e().a(str, new e.b(this) {
                        final /* synthetic */ a hJI;

                        {
                            this.hJI = r1;
                        }

                        public final int aM(int i, int i2) {
                            return 0;
                        }
                    });
                    return;
                }
                return;
            case 44:
                bil com_tencent_mm_protocal_c_bil = (bil) new bil().aD(bArr);
                w.d("MicroMsg.BigBallOfMudSyncExtension", "snsExtFlag " + com_tencent_mm_protocal_c_bil.tMV.hAO);
                ap.yY();
                a = (String) c.vr().get(2, null);
                if (a != null && a.length() > 0) {
                    if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
                        com.tencent.mm.plugin.sns.b.m.pQB.a(a, com_tencent_mm_protocal_c_bil.tMV);
                    }
                    BizInfo hW = com.tencent.mm.modelbiz.e.hW(m.xL());
                    if (hW == null) {
                        hW = new BizInfo();
                    }
                    hW.field_username = a;
                    hW.field_brandList = com_tencent_mm_protocal_c_bil.hAN;
                    if (!(!hW.CI() || hW.bd(false) == null || hW.bd(false).Di() == null || bg.mA(hW.CO()))) {
                        hW.field_enterpriseFather = hW.CO();
                        w.d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", a, hW.field_enterpriseFather);
                    }
                    if (!com.tencent.mm.modelbiz.w.DH().e(hW)) {
                        com.tencent.mm.modelbiz.w.DH().d(hW);
                    }
                    int i2 = com_tencent_mm_protocal_c_bil.uhY;
                    int i3 = com_tencent_mm_protocal_c_bil.uhZ;
                    i = com_tencent_mm_protocal_c_bil.uia;
                    w.d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i2 + " rommquota: " + i3 + " invite: " + i);
                    ap.yY();
                    c.vr().set(135175, Integer.valueOf(i2));
                    ap.yY();
                    c.vr().set(135176, Integer.valueOf(i3));
                    ap.yY();
                    c.vr().set(135177, Integer.valueOf(i));
                    ap.yY();
                    c.vr().set(144385, Integer.valueOf(com_tencent_mm_protocal_c_bil.uif));
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(com_tencent_mm_protocal_c_bil.uip));
                    ap.yY();
                    c.vr().set(339975, Integer.valueOf(com_tencent_mm_protocal_c_bil.uio));
                    w.i("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", Integer.valueOf(com_tencent_mm_protocal_c_bil.uio), Integer.valueOf(com_tencent_mm_protocal_c_bil.uip));
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.USERINFO_PROFILE_WEIDIANINFO_STRING, bg.ap(com_tencent_mm_protocal_c_bil.gkP, ""));
                    w.d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", com_tencent_mm_protocal_c_bil.gkP);
                    ap.yY();
                    c.vr().set(147457, Long.valueOf(com_tencent_mm_protocal_c_bil.uiq));
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.USERINFO_F2F_RING_TONE_STRING, com_tencent_mm_protocal_c_bil.uir);
                    hVar = new h();
                    hVar.fRW = -1;
                    hVar.username = a;
                    hVar.hrB = com_tencent_mm_protocal_c_bil.tqb;
                    hVar.hrA = com_tencent_mm_protocal_c_bil.tqc;
                    hVar.aV(true);
                    hVar.gkq = 3;
                    w.d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", hVar.getUsername(), hVar.Bs(), hVar.Bt());
                    com.tencent.mm.x.n.Bm().a(hVar);
                    a = com_tencent_mm_protocal_c_bil.tQM;
                    xL = com_tencent_mm_protocal_c_bil.tQN;
                    ap.yY();
                    c.vr().set(274433, xL);
                    ap.yY();
                    c.vr().set(274434, a);
                    if (com_tencent_mm_protocal_c_bil.tfr != null) {
                        ap.yY();
                        c.vr().set(286721, com_tencent_mm_protocal_c_bil.tfr.tjr);
                        ap.yY();
                        c.vr().set(286722, com_tencent_mm_protocal_c_bil.tfr.tjs);
                        ap.yY();
                        c.vr().set(286723, com_tencent_mm_protocal_c_bil.tfr.tjt);
                    }
                    if (com_tencent_mm_protocal_c_bil.uil != null && com_tencent_mm_protocal_c_bil.uil.tUg != null && com_tencent_mm_protocal_c_bil.uil.tUg.tZn > 0) {
                        w.i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", Integer.valueOf(com_tencent_mm_protocal_c_bil.uil.tUg.tZn));
                        lhVar = new qz();
                        lhVar.fXY.fXZ = com_tencent_mm_protocal_c_bil.uil;
                        com.tencent.mm.sdk.b.a.urY.m(lhVar);
                        return;
                    }
                    return;
                }
                return;
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                ank com_tencent_mm_protocal_c_ank = (ank) new ank().aD(bArr);
                w.d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", Integer.valueOf(com_tencent_mm_protocal_c_ank.mtd), Long.valueOf(com_tencent_mm_protocal_c_ank.tfk));
                if (o.fl(com_tencent_mm_protocal_c_ank.mvV)) {
                    lhVar = new nf();
                    lhVar.fUr.fGM = com_tencent_mm_protocal_c_ank.tfk;
                    com.tencent.mm.sdk.b.a.urY.m(lhVar);
                    return;
                }
                return;
            case ao.CTRL_INDEX /*204*/:
                a((bv) new bv().aD(bArr), rVar);
                return;
            case 999999:
                try {
                    int c = com.tencent.mm.a.n.c(bArr, 0);
                    w.d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", Integer.valueOf(c));
                    if (c > 0) {
                        Thread.sleep((long) c);
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", e, "", new Object[0]);
                    return;
                }
            default:
                w.e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + luVar.tsa);
                return;
        }
    }

    public static boolean a(x xVar) {
        if (xVar == null || bg.mA(xVar.field_username)) {
            String str;
            String str2 = "MicroMsg.BigBallOfMudSyncExtension";
            String str3 = "dealModContactExtInfo username:%s ";
            Object[] objArr = new Object[1];
            if (xVar == null) {
                str = "-1";
            } else {
                str = xVar.field_username;
            }
            objArr[0] = str;
            w.w(str2, str3, objArr);
            return false;
        }
        ap.yY();
        byte[] Rg = c.wR().Rg(xVar.field_username);
        if (bg.bm(Rg)) {
            str2 = "MicroMsg.BigBallOfMudSyncExtension";
            str3 = "dealModContactExtInfo username:%s  buf:%d";
            objArr = new Object[2];
            objArr[0] = xVar.field_username;
            objArr[1] = Integer.valueOf(Rg == null ? -1 : Rg.length);
            w.w(str2, str3, objArr);
            return false;
        }
        ame com_tencent_mm_protocal_c_ame;
        try {
            com_tencent_mm_protocal_c_ame = (ame) new ame().aD(Rg);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", e, "", new Object[0]);
            com_tencent_mm_protocal_c_ame = null;
        }
        ap.yY();
        c.wR().Rh(xVar.field_username);
        if (com_tencent_mm_protocal_c_ame != null) {
            return com.tencent.mm.plugin.bbom.c.a(xVar, com_tencent_mm_protocal_c_ame, false);
        }
        w.e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
        return false;
    }

    public final void a(bv bvVar, r rVar) {
        ae aeVar;
        Object obj;
        long AE;
        final String a = n.a(bvVar.tfm);
        long j = bvVar.tfk;
        int i = bvVar.ogM;
        int i2 = bvVar.tfp;
        int i3 = bvVar.tfl;
        int i4 = bvVar.mtd;
        int i5 = bvVar.tfn;
        String a2 = n.a(bvVar.tfo);
        w.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", a, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), bg.Qj(a2));
        if (bg.mA(a)) {
            w.e("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId is null and ret");
        }
        if (i5 == 0) {
            com.tencent.mm.plugin.report.c.oTb.a(403, 24, 1, false);
            if (bg.ap(ay.gi(a2), "").equals(m.xL())) {
                ap.yY();
                au x = c.wT().x(a, j);
                if (x.field_msgId > 0 && x.field_isSend == 1) {
                    w.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList self send msg[%d] createtime[%d, %d] svrid[%d, %d] seq[%d, %d]", Long.valueOf(x.field_msgId), Long.valueOf(x.field_createTime), Integer.valueOf(i), Long.valueOf(x.field_msgSvrId), Long.valueOf(j), Long.valueOf(x.field_msgSeq), Integer.valueOf(i3));
                    if (x.field_msgSeq == 0) {
                        com.tencent.mm.plugin.report.c.oTb.a(403, 25, 1, false);
                        x.B((long) i3);
                        ap.yY();
                        c.wT().a(x.field_msgId, x);
                        return;
                    }
                    return;
                }
            }
        }
        ap.yY();
        aj Rm = c.wW().Rm(a);
        aj ajVar;
        if (Rm == null) {
            com.tencent.mm.plugin.report.c.oTb.a(403, 22, 1, false);
            aj aeVar2 = new ae(a);
            aeVar2.s(((long) i) * 1000);
            aeVar2.u((long) i3);
            aeVar2.dt(i5);
            aeVar2.dB(i5);
            if (i5 < 2) {
                aeVar2.v((long) i3);
                aeVar = aeVar2;
                obj = 1;
            } else {
                ap.yY();
                aeVar2.v(c.xC().Ad(a));
                w.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", Long.valueOf(r6), Integer.valueOf(i3));
                ajVar = aeVar2;
                int i6 = 1;
            }
        } else {
            int i7 = (int) Rm.field_lastSeq;
            com.tencent.mm.plugin.report.c.oTb.a(403, 23, 1, false);
            if (i5 < Rm.field_UnDeliverCount) {
                com.tencent.mm.plugin.report.c.oTb.a(403, 26, (long) Rm.field_UnDeliverCount, false);
            }
            if (i3 > i7) {
                Rm.u((long) i3);
                Rm.dB(i5);
                Rm.s(ay.i(a, (long) i));
                if (i5 > Rm.field_unReadCount) {
                    Rm.dt(i5);
                }
                w.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList  msgSeq[%d], firstSeq[%d], lastseq[%d]", Integer.valueOf(i3), Long.valueOf(Rm.field_firstUnDeliverSeq), Integer.valueOf(i7));
                if (Rm.field_firstUnDeliverSeq > 0) {
                    ap.yY();
                    if (c.wT().y(a, (long) i7).field_msgId <= 0) {
                        com.tencent.mm.plugin.report.c.oTb.a(403, 29, 1, false);
                        w.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList unDeliverCount:%d lastSeq:%d not existed", Integer.valueOf(i5), Integer.valueOf(i7));
                        ajVar = Rm;
                        obj = null;
                    } else if (i5 != 1) {
                        w.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList unDeliverCount:%d keep firstSeq:%d", Integer.valueOf(i5), Long.valueOf(AE));
                        com.tencent.mm.plugin.report.c.oTb.a(403, 27, 1, false);
                        ajVar = Rm;
                        obj = null;
                    } else {
                        Rm.v((long) i3);
                        com.tencent.mm.plugin.report.c.oTb.a(403, 28, 1, false);
                        ajVar = Rm;
                        obj = null;
                    }
                } else {
                    ap.yY();
                    j = c.xC().Ad(a);
                    if (j > 0) {
                        com.tencent.mm.plugin.report.c.oTb.a(403, 30, 1, false);
                        if (i5 == 0 && ((long) i3) == j) {
                            w.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList[%d, %d] deleted ret", Integer.valueOf(i3), Long.valueOf(j));
                            return;
                        }
                        Rm.v((long) i3);
                        ajVar = Rm;
                        obj = null;
                    } else {
                        ap.yY();
                        AE = c.wT().AE(a);
                        if (AE > 0) {
                            Rm.v(AE);
                            com.tencent.mm.plugin.report.c.oTb.a(403, 31, 1, false);
                            ajVar = Rm;
                            obj = null;
                        } else {
                            com.tencent.mm.plugin.report.c.oTb.a(403, 32, 1, false);
                            ajVar = Rm;
                            obj = null;
                        }
                    }
                }
            } else {
                if (i3 == i7 && i5 == 0 && Rm.field_unReadCount > 0) {
                    com.tencent.mm.plugin.report.c.oTb.a(403, 33, 1, false);
                    Rm.dt(0);
                }
                w.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList msgSeq <= lastSeq, do nothing [%d, %d]", Integer.valueOf(i3), Integer.valueOf(i7));
                return;
            }
        }
        if (i2 > 0) {
            aeVar.dz(aeVar.field_atCount + i2);
        }
        au auVar = new au();
        auVar.dw(0);
        auVar.cH(a);
        auVar.setType(i4);
        auVar.setContent(a2);
        if (i4 == 49) {
            com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(j.el(a, a2));
            auVar.setType(l.d(ek));
            if (auVar.bLX() || auVar.bLY()) {
                a2 = ek.content;
            }
            auVar.setContent(a2);
        } else if (i4 == 10002) {
            ap.getSysCmdMsgExtension();
            if (auVar.field_type == CdnLogic.MediaType_FAVORITE_VIDEO && !bg.mA(a2)) {
                if (bg.mA(a2)) {
                    w.e("MicroMsg.SysCmdMsgExtension", "null msg content");
                } else {
                    Map PF;
                    if (a2.startsWith("~SEMI_XML~")) {
                        PF = aw.PF(a2);
                        if (PF == null) {
                            w.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", a2);
                        } else {
                            a2 = "brand_service";
                        }
                    } else {
                        int indexOf = a2.indexOf("<sysmsg");
                        if (indexOf == -1) {
                            w.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
                        } else {
                            PF = bh.q(a2.substring(indexOf), "sysmsg");
                            if (PF == null) {
                                w.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", a2);
                            } else {
                                a2 = (String) PF.get(".sysmsg.$type");
                            }
                        }
                    }
                    if (a2 != null && a2.equals("revokemsg")) {
                        w.i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                        PF.get(".sysmsg.revokemsg.session");
                        a2 = (String) PF.get(".sysmsg.revokemsg.newmsgid");
                        w.i("MicroMsg.SysCmdMsgExtension", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", a2, (String) PF.get(".sysmsg.revokemsg.replacemsg"));
                        auVar.setContent(r4);
                        auVar.setType(10000);
                    }
                }
            }
        }
        aeVar.dw(0);
        aeVar.setContent(auVar.field_content);
        aeVar.ct(Integer.toString(auVar.field_type));
        ap.yY();
        as.b oG = c.wW().oG();
        if (oG != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            PInt pInt = new PInt();
            oG.a(auVar, pString, pString2, pInt, false);
            aeVar.cu(pString.value);
            aeVar.cv(pString2.value);
            aeVar.dx(pInt.value);
            if (auVar.field_type == 49) {
                a2 = (String) bh.q(aeVar.field_content, "msg").get(".msg.appmsg.title");
                aeVar.cu(bg.mz(aeVar.field_digest).concat(bg.mA(a2) ? "" : " " + bg.mz(a2)));
            }
        } else {
            aeVar.cu(aeVar.field_content);
        }
        if (obj != null) {
            ap.yY();
            AE = c.wW().d(aeVar);
            w.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr, processAddMsgDigestList insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", a, Long.valueOf(AE), Long.valueOf(aeVar.field_firstUnDeliverSeq), Long.valueOf(aeVar.field_lastSeq), Integer.valueOf(aeVar.field_UnDeliverCount));
        } else {
            aeVar.dy(aeVar.field_attrflag & -1048577);
            ap.yY();
            AE = (long) c.wW().a(aeVar, a, true);
            w.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr, processAddMsgDigestList update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", a, Long.valueOf(AE), Long.valueOf(aeVar.field_firstUnDeliverSeq), Long.valueOf(aeVar.field_lastSeq), Integer.valueOf(aeVar.field_UnDeliverCount));
        }
        ap.yY();
        final com.tencent.mm.storage.q fW = c.xa().fW(a);
        ap.yY();
        com.tencent.mm.j.a Rc = c.wR().Rc(a);
        if (Rc == null || ((int) Rc.gTQ) <= 0) {
            w.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId[%s], contact is null need get", a);
            com.tencent.mm.u.ag.a.hlS.a(a, null, new com.tencent.mm.u.ag.b.a(this) {
                final /* synthetic */ a hJI;

                public final void p(String str, boolean z) {
                    if (fW != null && fW.bKT()) {
                        b jhVar = new jh();
                        jhVar.fPB.chatroomName = a;
                        jhVar.fPB.fPC = fW.bKS();
                        com.tencent.mm.sdk.b.a.urY.m(jhVar);
                    }
                }
            });
        }
        if (com.tencent.mm.sdk.a.b.foreground && i4 != 10002 && i5 > 0) {
            bu buVar = new bu();
            buVar.tfd = bvVar.tfm;
            buVar.tfe = n.mw(m.xL());
            buVar.ogM = bvVar.ogM;
            buVar.tff = bvVar.tfo;
            buVar.mtd = bvVar.mtd;
            buVar.tfk = bvVar.tfk;
            buVar.tfl = bvVar.tfl;
            if (rVar != null) {
                rVar.a(auVar, buVar);
            }
        }
    }
}
