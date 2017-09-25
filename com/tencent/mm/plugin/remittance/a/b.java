package com.tencent.mm.plugin.remittance.a;

import android.text.TextUtils;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.lt;
import com.tencent.mm.e.a.se;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.remittance.c.m;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.y.d;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class b implements am {
    private static HashMap<Integer, c> gJr;
    private a lew = new a(this) {
        final /* synthetic */ b oQi;

        {
            this.oQi = r1;
        }

        public final void a(d.a aVar) {
            w.i("MicroMsg.SubCoreRemittance", "hy: received AddMsg");
            bu buVar = aVar.hst;
            if (buVar == null) {
                w.e("MicroMsg.SubCoreRemittance", "recieve a null msg");
                return;
            }
            String a = n.a(buVar.tff);
            if (bg.mA(a)) {
                w.e("MicroMsg.SubCoreRemittance", "msg illegal,content is null");
                return;
            }
            Map q = bh.q(a, "sysmsg");
            if (q == null) {
                w.e("MicroMsg.SubCoreRemittance", "Resolve msg error");
                return;
            }
            a = (String) q.get(".sysmsg.paymsg.PayMsgType");
            String str;
            if ("15".equals(a)) {
                String decode = URLDecoder.decode((String) q.get(".sysmsg.paymsg.appmsgcontent"));
                if (TextUtils.isEmpty(decode)) {
                    w.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
                    return;
                }
                Map q2 = bh.q(decode, "msg");
                if (q2 == null) {
                    w.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
                    return;
                }
                a = (String) q2.get(".msg.appmsg.wcpayinfo.transcationid");
                if (bg.mA(a)) {
                    w.e("MicroMsg.SubCoreRemittance", "paymsgid is null");
                } else if (this.oQi.aXc().Du(a)) {
                    w.e("MicroMsg.SubCoreRemittance", "it is a duplicate msg");
                } else {
                    str = (String) q.get(".sysmsg.paymsg.tousername");
                    if (bg.mA(decode) || bg.mA(str)) {
                        w.e("MicroMsg.SubCoreRemittance", "onRecieveMsg get a illegal msg,which content or toUserName is null");
                    } else {
                        this.oQi.aXc().K(a, decode, str);
                    }
                }
            } else if ("22".equals(a)) {
                a = (String) q.get(".sysmsg.paymsg.tousername");
                str = (String) q.get(".sysmsg.paymsg.fromusername");
                try {
                    String decode2 = URLDecoder.decode((String) q.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
                    if (bg.mA(decode2)) {
                        w.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
                        return;
                    }
                    Map q3 = bh.q(decode2, "msg");
                    if (q3 == null) {
                        w.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
                        return;
                    }
                    com.tencent.mm.sdk.e.c Ds;
                    String str2 = (String) q3.get(".msg.appmsg.wcpayinfo.transferid");
                    int i = bg.getInt((String) q3.get(".msg.appmsg.wcpayinfo.paysubtype"), -1);
                    w.d("MicroMsg.SubCoreRemittance", "fromusername: %s, tousername: %s, transferId: %s, paysubtype: %d", new Object[]{str, a, str2, Integer.valueOf(i)});
                    try {
                        b.aWZ();
                        Ds = b.aXa().Ds(str2);
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.SubCoreRemittance", e, "", new Object[0]);
                        Ds = null;
                    }
                    if (Ds == null) {
                        w.i("MicroMsg.SubCoreRemittance", "empty record");
                        return;
                    }
                    ap.yY();
                    ce cA = com.tencent.mm.u.c.wT().cA(Ds.field_msgId);
                    if (cA.field_msgId <= 0) {
                        w.i("MicroMsg.SubCoreRemittance", "has delete msg");
                        b.aWZ();
                        b.aXa().a(Ds, new String[0]);
                        return;
                    }
                    w.i("MicroMsg.SubCoreRemittance", "update msg: %s", new Object[]{Long.valueOf(cA.field_msgId)});
                    cA.setContent(decode2);
                    ap.yY();
                    com.tencent.mm.u.c.wT().a(cA.field_msgId, cA);
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.SubCoreRemittance", e2, "", new Object[0]);
                }
            }
        }
    };
    private m oQd = null;
    public com.tencent.mm.plugin.remittance.b.b oQe = null;
    private com.tencent.mm.plugin.remittance.b.d oQf = null;
    private com.tencent.mm.sdk.b.c<lt> oQg = new com.tencent.mm.sdk.b.c<lt>(this) {
        final /* synthetic */ b oQi;

        {
            this.oQi = r2;
            this.usg = lt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            lt ltVar = (lt) bVar;
            w.i("MicroMsg.SubCoreRemittance", "do insert delay transfer record: %s, %s", new Object[]{Long.valueOf(ltVar.fSS.fGM), ltVar.fSS.fST});
            if (ltVar.fSS.fSU != null) {
                if (ltVar.fSS.fSU.his == 5) {
                    com.tencent.mm.sdk.e.c aVar = new com.tencent.mm.plugin.remittance.b.a();
                    aVar.field_msgId = ltVar.fSS.fGM;
                    aVar.field_transferId = ltVar.fSS.fST;
                    b.aWZ();
                    b.aXa().b(aVar);
                }
                com.tencent.mm.plugin.remittance.b.c Dt = b.aXb().Dt(ltVar.fSS.fST);
                if (Dt != null) {
                    Dt.field_receiveStatus = ltVar.fSS.fSU.his;
                    b.aXb().a(Dt);
                } else {
                    ap.yY();
                    if (!com.tencent.mm.u.c.wT().cA(ltVar.fSS.fGM).field_talker.equals(com.tencent.mm.u.m.xL())) {
                        Dt = new com.tencent.mm.plugin.remittance.b.c();
                        Dt.field_locaMsgId = ltVar.fSS.fGM;
                        Dt.field_transferId = ltVar.fSS.fSU.hiv;
                        Dt.field_receiveStatus = ltVar.fSS.fSU.his;
                        Dt.field_isSend = false;
                        b.aXb().a(Dt);
                    }
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<se> oQh = new com.tencent.mm.sdk.b.c<se>(this) {
        final /* synthetic */ b oQi;

        {
            this.oQi = r2;
            this.usg = se.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.plugin.remittance.b.c Dt;
            se seVar = (se) bVar;
            com.tencent.mm.plugin.remittance.b.d aXb = b.aXb();
            String str = seVar.fZI.fST;
            if (bg.mA(str) || !com.tencent.mm.plugin.remittance.b.d.ioj.containsKey(str)) {
                Dt = aXb.Dt(str);
                if (Dt != null) {
                    com.tencent.mm.plugin.remittance.b.d.ioj.put(str, Dt);
                } else {
                    Dt = null;
                }
            } else {
                Dt = (com.tencent.mm.plugin.remittance.b.c) com.tencent.mm.plugin.remittance.b.d.ioj.get(str);
            }
            if (Dt != null) {
                seVar.fZJ.status = Dt.field_receiveStatus;
                seVar.fZJ.fZK = Dt.field_isSend;
            } else {
                seVar.fZJ.status = -2;
                seVar.fZJ.fZK = false;
            }
            return false;
        }
    };

    static {
        com.tencent.mm.wallet_core.a.g("RemittanceProcess", a.class);
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("DelayTransferRecord".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.remittance.b.b.gUx;
            }
        });
        gJr.put(Integer.valueOf("RemittanceRecord".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.remittance.b.d.gUx;
            }
        });
    }

    public static b aWZ() {
        b bVar = (b) ap.yR().gs("plugin.remittance");
        if (bVar != null) {
            return bVar;
        }
        w.w("MicroMsg.SubCoreRemittance", "not found in MMCore, new one");
        Object bVar2 = new b();
        ap.yR().a("plugin.remittance", bVar2);
        return bVar2;
    }

    public static com.tencent.mm.plugin.remittance.b.b aXa() {
        if (aWZ().oQe == null) {
            b aWZ = aWZ();
            ap.yY();
            aWZ.oQe = new com.tencent.mm.plugin.remittance.b.b(com.tencent.mm.u.c.wO());
        }
        return aWZ().oQe;
    }

    public static com.tencent.mm.plugin.remittance.b.d aXb() {
        if (aWZ().oQf == null) {
            b aWZ = aWZ();
            ap.yY();
            aWZ.oQf = new com.tencent.mm.plugin.remittance.b.d(com.tencent.mm.u.c.wO());
        }
        return aWZ().oQf;
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }

    public final void aM(boolean z) {
        if (this.oQd != null) {
            m mVar = this.oQd;
            synchronized (mVar.lock) {
                mVar.oQX = new HashSet();
                mVar.oQY.clear();
            }
        }
        ap.getSysCmdMsgExtension().a("paymsg", this.lew, true);
        com.tencent.mm.sdk.b.a.urY.a(this.oQg);
        com.tencent.mm.sdk.b.a.urY.a(this.oQh);
    }

    public final void onAccountRelease() {
        ap.getSysCmdMsgExtension().b("paymsg", this.lew, true);
        com.tencent.mm.sdk.b.a.urY.c(this.oQg);
        com.tencent.mm.sdk.b.a.urY.c(this.oQh);
    }

    public final m aXc() {
        if (this.oQd == null) {
            this.oQd = new m();
        }
        return this.oQd;
    }
}
