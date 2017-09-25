package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.b;
import java.util.Map;
import junit.framework.Assert;

public final class f implements d {

    public static final class a {
        String content = "";
        String gMX = "";
    }

    public final b b(com.tencent.mm.y.d.a aVar) {
        bu buVar = aVar.hst;
        if (buVar == null) {
            w.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM is null");
            return null;
        } else if (buVar.mtd == 36 || buVar.mtd == 39) {
            ce ceVar;
            int i;
            au auVar;
            String a = n.a(buVar.tff);
            String a2 = n.a(buVar.tfd);
            String a3 = n.a(buVar.tfe);
            w.d("MicroMsg.QMsgExtension", "parseQMsg content:" + a);
            ap.yY();
            String str = (String) c.vr().get(2, null);
            String str2 = str.equals(a2) ? a3 : a2;
            ap.yY();
            ce x = c.wT().x(str2, buVar.tfk);
            w.d("MicroMsg.QMsgExtension", "dkmsgid parseQMsg svrid:%d localid:%d", new Object[]{Long.valueOf(buVar.tfk), Long.valueOf(x.field_msgId)});
            if (x.field_msgId != 0 && x.field_createTime + 604800000 < ay.i(a2, (long) buVar.ogM)) {
                w.w("MicroMsg.QMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[]{Long.valueOf(buVar.tfk), Long.valueOf(x.field_msgId)});
                ay.L(x.field_msgId);
                x.x(0);
            }
            if (x.field_msgId == 0) {
                x = new au();
                x.y(buVar.tfk);
                x.z(ay.i(a2, (long) buVar.ogM));
                ceVar = x;
            } else {
                ceVar = x;
            }
            ceVar.setType(buVar.mtd);
            ceVar.cH(str2);
            d CJ = g.aUe().CJ(str2);
            if (CJ == null || bg.mz(CJ.getUsername()).length() <= 0) {
                CJ = new d();
                CJ.username = str2;
                CJ.oyB = 1;
                CJ.fRW = 9;
                if (!g.aUe().a(CJ)) {
                    w.e("MicroMsg.QMsgExtension", "parseQMsg : insert QContact failed : username = " + CJ.getUsername());
                }
            }
            long j = -1;
            if (buVar.tfg == 2 && ceVar.field_msgId == 0) {
                byte[] a4 = n.a(buVar.tfh);
                PString pString = new PString();
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                com.tencent.mm.ah.f GS = com.tencent.mm.ah.n.GS();
                int i2 = buVar.tfg;
                j = GS.a(a4, buVar.tfk, false, "", pString, pInt, pInt2);
                if (j > 0) {
                    ceVar.cI(pString.value);
                    ceVar.dH(pInt.value);
                    ceVar.dI(pInt2.value);
                }
            }
            long j2 = j;
            if (buVar.mtd == 36) {
                Object obj;
                af xVar;
                Assert.assertTrue(true);
                Assert.assertTrue(bg.mz(a).length() > 0);
                Assert.assertTrue(bg.mz(ceVar.field_talker).length() > 0);
                ap.yY();
                af Rc = c.wR().Rc(ceVar.field_talker);
                if (Rc == null || bg.mz(Rc.field_username).length() <= 0) {
                    obj = 1;
                    xVar = new x(ceVar.field_talker);
                } else {
                    obj = null;
                    xVar = Rc;
                }
                a aVar2 = new a();
                Map q = bh.q(a, "msg");
                if (q != null) {
                    aVar2.gMX = (String) q.get(".msg.from.displayname");
                    aVar2.content = (String) q.get(".msg.content.t");
                }
                xVar.bP(aVar2.gMX == null ? "" : aVar2.gMX);
                ceVar.setContent(aVar2.content == null ? "" : aVar2.content);
                if (obj != null) {
                    ap.yY();
                    c.wR().R(xVar);
                } else {
                    ap.yY();
                    c.wR().a(xVar.field_username, xVar);
                }
            }
            ap.yY();
            Object obj2 = (c.wZ().has(a2) || str.equals(a2)) ? 1 : null;
            if (obj2 != null) {
                ceVar.dw(1);
                i = buVar.jNB;
                auVar = ceVar;
            } else {
                ceVar.dw(0);
                if (buVar.jNB > 3) {
                    i = buVar.jNB;
                    x = ceVar;
                } else {
                    i = 3;
                    x = ceVar;
                }
            }
            auVar.dv(i);
            ceVar.cN(buVar.tfi);
            ay.a(ceVar, aVar);
            if (ceVar.field_msgId == 0) {
                ceVar.x(ay.i(ceVar));
                if (buVar.tfg == 2) {
                    com.tencent.mm.ah.d b = com.tencent.mm.ah.n.GS().b(Long.valueOf(j2));
                    b.ag((long) ((int) ceVar.field_msgId));
                    com.tencent.mm.ah.n.GS().a(Long.valueOf(j2), b);
                }
                return new b(ceVar, true);
            }
            ap.yY();
            c.wT().b(buVar.tfk, ceVar);
            return new b(ceVar, false);
        } else {
            w.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM.type:%d", new Object[]{Integer.valueOf(buVar.mtd)});
            return null;
        }
    }

    public final void h(au auVar) {
        com.tencent.mm.ah.n.GS().o(auVar);
    }
}
