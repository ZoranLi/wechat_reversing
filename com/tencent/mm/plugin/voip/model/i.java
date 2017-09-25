package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.e.b.ce;
import com.tencent.mm.i.f;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.b;
import java.util.Map;

public final class i implements d {

    public static final class a {
        public static int rhq = 1;
        public static int rhr = 2;
        public static int rhs = 3;
        public static int rht = 4;
        public static int rhu = 0;
        public static int rhv = 1;
        public int rhn;
        public long rho;
        public int rhp;
        public int status;

        public final boolean bpA() {
            return this.rhp == rhu;
        }

        public final boolean parse(String str) {
            this.rhp = rhu;
            try {
                Map q = bh.q(str, "voipinvitemsg");
                if (q == null) {
                    return false;
                }
                if (q.get(".voipinvitemsg.roomid") != null) {
                    this.rhn = bg.getInt((String) q.get(".voipinvitemsg.roomid"), 0);
                }
                if (q.get(".voipinvitemsg.key") != null) {
                    this.rho = bg.getLong((String) q.get(".voipinvitemsg.key"), 0);
                }
                if (q.get(".voipinvitemsg.status") != null) {
                    this.status = bg.getInt((String) q.get(".voipinvitemsg.status"), 0);
                }
                if (q.get(".voipinvitemsg.invitetype") != null) {
                    this.rhp = bg.getInt((String) q.get(".voipinvitemsg.invitetype"), 0);
                }
                return true;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.VoipExtension", e, "", new Object[0]);
                w.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[]{e.getMessage()});
                return false;
            }
        }
    }

    public final b b(com.tencent.mm.y.d.a aVar) {
        bu buVar = aVar.hst;
        String a = n.a(buVar.tfd);
        String a2 = n.a(buVar.tfe);
        String a3 = n.a(buVar.tff);
        w.d("MicroMsg.VoipExtension", "voip msg, from: %s, content: %s", new Object[]{a, a3});
        ap.yY();
        c wT = com.tencent.mm.u.c.wT();
        ap.yY();
        String str = (String) com.tencent.mm.u.c.vr().get(2, "");
        if (str.length() <= 0) {
            return null;
        }
        ce ceVar;
        ce x = wT.x(str.equals(a) ? a2 : a, buVar.tfk);
        if (x.field_msgId == 0) {
            x = new au();
            x.y(buVar.tfk);
            x.z(ay.i(a, (long) buVar.ogM));
            ceVar = x;
        } else {
            ceVar = x;
        }
        d.bpd();
        a HC = m.HC(a3);
        if (HC == null) {
            w.e("MicroMsg.VoipExtension", "parse voip message failed, voipMessage is null!");
            try {
                Map q = bh.q(a3, "voipwarnmsg");
                if (!(q == null || q.get(".voipwarnmsg.type") == null || bg.getInt((String) q.get(".voipwarnmsg.type"), 0) != 1)) {
                    str = (String) q.get(".voipwarnmsg.warntips");
                    if (!(str == null || str.equals(""))) {
                        w.i("MicroMsg.VoipExtension", "got risk tips back:" + str);
                        if (q.get(".voipwarnmsg.roomid") != null) {
                            if (!f.sm()) {
                                w.i("MicroMsg.VoipExtension", "set voipmsg not notification...");
                            } else if (bg.getInt((String) q.get(".voipwarnmsg.roomid"), 0) != d.bpd().riE.rew.rfQ.mNL) {
                                w.i("MicroMsg.VoipExtension", "wrong roomid,now return..");
                                return null;
                            }
                        }
                        d.bpd().ric = str;
                        d.bpd().HD(str);
                    }
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.VoipExtension", e, "", new Object[0]);
                w.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[]{e.getMessage()});
            }
            return null;
        }
        if ((HC.status == a.rhr ? 1 : null) != null) {
            w.i("MicroMsg.VoipExtension", "recv voip cancel message");
            m bpd = d.bpd();
            if (!(a3 == null || a3.length() == 0)) {
                a aVar2 = new a();
                if (aVar2.parse(a3) && aVar2.status == 2) {
                    bpd.uX(aVar2.rhn);
                    n nVar = bpd.riE;
                    w.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteMessage, roomId: " + aVar2.rhn);
                    if (nVar.rew.rfV != null && aVar2.rhn == nVar.rew.rfV.tvL) {
                        nVar.bqw();
                        nVar.rew.shutdown();
                    }
                }
            }
            if (HC.rhn == d.bpd().riK) {
                w.i("MicroMsg.VoipExtension", "already ignore the invite, don't add the message to db");
                return null;
            }
            ceVar.setType(buVar.mtd);
            ceVar.setContent(HC.bpA() ? au.uJR : au.uJQ);
            ceVar.dw(0);
            ceVar.cH(a);
            ceVar.dv(buVar.jNB > 3 ? buVar.jNB : 3);
            ceVar.cN(null);
            ay.a(ceVar, aVar);
            w.d("MicroMsg.VoipExtension", "voipMessage==null: %b", new Object[]{HC});
            if (ceVar.field_msgId == 0) {
                a aVar3;
                if (HC == null) {
                    aVar3 = new a();
                    aVar3.parse(a3);
                } else {
                    aVar3 = HC;
                }
                w.d("MicroMsg.VoipExtension", "add or update msg, roomid: %s", new Object[]{Integer.valueOf(aVar3.rhn)});
                if (d.bpd().riJ.get(Integer.valueOf(aVar3.rhn)) == null) {
                    ceVar.x(ay.i(ceVar));
                    d.bpd().riJ.put(Integer.valueOf(aVar3.rhn), Long.valueOf(ceVar.field_msgId));
                } else {
                    ap.yY();
                    com.tencent.mm.u.c.wT().a(((Long) d.bpd().riJ.get(Integer.valueOf(aVar3.rhn))).longValue(), ceVar);
                }
                return new b(ceVar, true);
            }
            ap.yY();
            com.tencent.mm.u.c.wT().b(buVar.tfk, ceVar);
            return new b(ceVar, false);
        }
        if ((HC.status == a.rht ? 1 : null) != null) {
            return null;
        }
        if ((HC.status == a.rhq ? 1 : null) == null) {
            return null;
        }
        w.i("MicroMsg.VoipExtension", "recv voip invite delay");
        d.bpd().J(HC.rhn, HC.rho);
        return null;
    }

    public final void h(au auVar) {
    }
}
