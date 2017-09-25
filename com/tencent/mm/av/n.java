package com.tencent.mm.av;

import com.tencent.mm.e.a.ig;
import com.tencent.mm.e.a.ll;
import com.tencent.mm.e.b.af;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.x.h;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;

public final class n implements d {
    public final b b(a aVar) {
        int i = 0;
        bu buVar = aVar.hst;
        String a = com.tencent.mm.platformtools.n.a(buVar.tfd);
        if ("fmessage".equals(a) || buVar.mtd == 37) {
            String a2 = com.tencent.mm.platformtools.n.a(buVar.tff);
            final au.d RI = au.d.RI(a2);
            String xL = m.xL();
            if (RI.rUK == null || !RI.rUK.equals(xL)) {
                String str;
                h hVar = new h();
                hVar.username = RI.rUK;
                hVar.gkq = 3;
                hVar.aV(true);
                hVar.fRW = -1;
                hVar.hrB = RI.uJZ;
                hVar.hrA = RI.uKa;
                w.d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", RI.rUK, hVar.Bs(), hVar.Bt());
                com.tencent.mm.x.n.Bm().a(hVar);
                if (!bg.mA(RI.rUK)) {
                    if (RI.scene == 18) {
                        l.Kz().a(buVar, RI);
                        ap.yY();
                        c.vr().set(73729, Integer.valueOf(1));
                        ap.yY();
                        af Rc = c.wR().Rc(RI.uKj);
                        if (Rc == null || ((int) Rc.gTQ) <= 0) {
                            ag.a.hlS.a(RI.uKj, null, new ag.b.a(this) {
                                final /* synthetic */ n hXV;

                                public final void p(String str, boolean z) {
                                    ap.yY();
                                    w.d("MicroMsg.VerifyMessageExtension", String.valueOf(c.wR().Rc(RI.uKj)));
                                    com.tencent.mm.sdk.b.b igVar = new ig();
                                    igVar.fNP.fNQ = RI.uKj;
                                    igVar.fNP.type = 1;
                                    com.tencent.mm.sdk.b.a.urY.m(igVar);
                                }
                            });
                        } else {
                            str = Rc.field_username;
                            if (!(str == null || o.eT(str))) {
                                Rc.setUsername(RI.uKj);
                                Rc.bX(null);
                                ap.yY();
                                c.wR().a(str, Rc);
                            }
                            com.tencent.mm.sdk.b.b igVar = new ig();
                            igVar.fNP.fNQ = RI.uKj;
                            igVar.fNP.type = 1;
                            com.tencent.mm.sdk.b.a.urY.m(igVar);
                        }
                    } else if (ay.fc(RI.scene)) {
                        l.KA().a(buVar, RI);
                        ap.yY();
                        c.vr().set(73730, Integer.valueOf(1));
                    } else if (RI.scene == 48) {
                        com.tencent.mm.sdk.b.b llVar = new ll();
                        llVar.fSq.fSs = a2;
                        llVar.fSq.fJL = RI.rUK;
                        com.tencent.mm.sdk.b.a.urY.m(llVar);
                    }
                }
                f fVar = new f();
                fVar.field_createTime = e.i(a, (long) buVar.ogM);
                if (buVar.jNB == 4) {
                    i = 2;
                }
                fVar.field_isSend = i + 0;
                fVar.field_msgContent = com.tencent.mm.platformtools.n.a(buVar.tff);
                fVar.field_svrId = buVar.tfk;
                fVar.field_talker = RI.rUK;
                ap.yY();
                com.tencent.mm.j.a Rc2 = c.wR().Rc(RI.chatroomName);
                if (!(Rc2 == null || ((int) Rc2.gTQ) == -1)) {
                    fVar.field_chatroomName = RI.chatroomName;
                }
                switch (RI.fJK) {
                    case 2:
                        fVar.field_type = 1;
                        break;
                    case 5:
                        fVar.field_type = 2;
                        break;
                    case 6:
                        fVar.field_type = 3;
                        break;
                    default:
                        fVar.field_type = 1;
                        break;
                }
                if (bg.mA(RI.uKj)) {
                    w.e("MicroMsg.VerifyMessageExtension", "it should not go in here");
                    b kY = l.Ky().kY(fVar.field_talker);
                    if (kY != null) {
                        fVar.field_encryptTalker = kY.field_talker;
                        fVar.field_talker = kY.field_talker;
                    }
                    l.Kx().a(fVar);
                } else {
                    fVar.field_encryptTalker = RI.uKj;
                    if (l.Ky().kX(RI.uKj) != null) {
                        g Kx = l.Kx();
                        str = fVar.field_encryptTalker;
                        Kx.gUz.eE("fmessage_msginfo", "update fmessage_msginfo set talker = '" + bg.my(fVar.field_talker) + "'  where talker = '" + bg.my(str) + "'");
                        l.Ky().c(0, fVar.field_encryptTalker);
                    }
                    l.Kx().a(fVar);
                }
            } else {
                w.d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", Integer.valueOf(RI.scene), a2);
                w.e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }
}
