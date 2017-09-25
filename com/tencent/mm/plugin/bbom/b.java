package com.tencent.mm.plugin.bbom;

import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.av.h;
import com.tencent.mm.av.l;
import com.tencent.mm.e.a.ig;
import com.tencent.mm.plugin.messenger.foundation.a.a;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.y.d;

public final class b implements a {
    public final void a(d.a aVar, au auVar, final String str, String str2, boolean z) {
        int i = 1;
        final bu buVar = aVar.hst;
        final com.tencent.mm.u.ay.b gm = ay.gm(buVar.tfi);
        if (gm != null) {
            auVar.cO(gm.hmQ);
            auVar.cL(gm.hmP);
            w.i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", gm.hmP);
            if (!(gm.hmR == null || gm.scene != 1 || buVar.mtd == 10000)) {
                ap.yY();
                com.tencent.mm.j.a Rc = c.wR().Rc(str);
                if (Rc == null || ((int) Rc.gTQ) <= 0) {
                    ag.a.hlS.a(str, null, new com.tencent.mm.u.ag.b.a(this) {
                        final /* synthetic */ b jPO;

                        public final void p(String str, boolean z) {
                            ap.yY();
                            b.a(buVar, gm, c.wR().Rc(str));
                        }
                    });
                } else {
                    a(buVar, gm, Rc);
                }
            }
        }
        int i2;
        if (o.eU(str) && o.fJ(str)) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (!o.dH(str) || o.fI(str)) {
            i = 0;
        }
        if (!z && auVar.bMh() && r0 == 0 && r1 == 0) {
            com.tencent.mm.modelcontrol.c.Er();
            if (com.tencent.mm.modelcontrol.c.l(auVar)) {
                com.tencent.mm.ah.a GU = n.GU();
                long j = auVar.field_msgId;
                com.tencent.mm.modelcontrol.c.Er();
                if (com.tencent.mm.modelcontrol.c.Es()) {
                    synchronized (GU.hEt) {
                        if (GU.hEt.size() >= 100) {
                            GU.hEt.remove(0);
                        }
                        GU.hEt.push(Long.valueOf(j));
                    }
                    GU.hEx = System.currentTimeMillis();
                    GU.start();
                }
            }
        }
    }

    public static void a(bu buVar, com.tencent.mm.u.ay.b bVar, x xVar) {
        int i;
        String a = com.tencent.mm.platformtools.n.a(buVar.tfd);
        ap.yY();
        c.vr().set(73729, Integer.valueOf(1));
        String str = xVar.field_nickname;
        h hVar = new h();
        hVar.field_content = com.tencent.mm.platformtools.n.a(buVar.tff);
        hVar.field_createtime = bg.Ny();
        hVar.field_imgpath = "";
        hVar.field_sayhicontent = buVar.mtd == 3 ? ab.getContext().getString(R.l.eDj) : com.tencent.mm.platformtools.n.a(buVar.tff);
        hVar.field_sayhiuser = a;
        hVar.field_scene = 18;
        if (buVar.jNB > 3) {
            i = buVar.jNB;
        } else {
            i = 3;
        }
        hVar.field_status = i;
        hVar.field_svrid = buVar.tfk;
        hVar.field_talker = str;
        hVar.field_type = buVar.mtd;
        hVar.field_isSend = 0;
        hVar.field_sayhiencryptuser = a;
        hVar.field_ticket = bVar.hmR;
        l.Kz().a(hVar);
        com.tencent.mm.sdk.b.b igVar = new ig();
        igVar.fNP.fNQ = a;
        com.tencent.mm.sdk.b.a.urY.m(igVar);
    }
}
