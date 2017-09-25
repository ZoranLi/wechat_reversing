package com.tencent.mm.modelbiz;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.modelbiz.a.b;
import com.tencent.mm.modelbiz.a.d;
import com.tencent.mm.modelbiz.a.g;
import com.tencent.mm.modelbiz.a.h;
import com.tencent.mm.modelbiz.a.i;
import com.tencent.mm.modelbiz.a.k;
import com.tencent.mm.modelbiz.l.a;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.am;
import com.tencent.mm.u.bp;
import com.tencent.mm.u.e;
import com.tencent.mm.u.l;
import com.tencent.mm.u.o;
import java.util.HashMap;
import java.util.Map;

public class w implements am {
    private static HashMap<Integer, c> gJr;
    private static long hwi = 0;
    private e hmf = new e();
    private d hwj;
    private a hwk = null;
    private j hwl = null;
    private h hwm;
    private g hwn = null;
    private d hwo = null;
    private b hwp = null;
    private k hwq = null;
    private g hwr = null;
    private i hws = null;
    private h hwt = null;
    private c hwu = null;
    private a hwv;
    private bp.a hww = new bp.a(this) {
        final /* synthetic */ w hwz;

        {
            this.hwz = r1;
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            bu buVar = aVar.hst;
            if (buVar == null) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SubCoreBiz", "AddMsg is null.");
                return;
            }
            String a = n.a(buVar.tff);
            if (bg.mA(a)) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SubCoreBiz", "msg content is null");
                return;
            }
            Map q = bh.q(a, "sysmsg");
            if (q == null || q.size() <= 0) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SubCoreBiz", "receiveMessage, no sysmsg");
                return;
            }
            if ("mmbizattrappsvr_BizAttrSync".equalsIgnoreCase((String) q.get(".sysmsg.$type"))) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SubCoreBiz", "BizAttrSync openFlag : %d.", Integer.valueOf(bg.getInt((String) q.get(".sysmsg.mmbizattrappsvr_BizAttrSync.openflag"), 0)));
                com.tencent.mm.kernel.h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_BIZ_ATTR_SYNC_OPEN_FLAG_INT, Integer.valueOf(r0));
                com.tencent.mm.kernel.h.vI().vr().jY(true);
                return;
            }
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SubCoreBiz", "receiveMessage, type not BizAttrSync.");
        }
    };
    private as.a hwx = new as.a(this) {
        final /* synthetic */ w hwz;

        {
            this.hwz = r1;
        }

        public final void a(ae aeVar, as asVar) {
            if (aeVar != null && !bg.mA(aeVar.field_username)) {
                String str = aeVar.field_username;
                x Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(str);
                if (Rc != null && Rc.bLe() && !o.fh(str)) {
                    BizInfo hO = w.DH().hO(str);
                    if (hO.uxb == -1) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
                    } else if (hO.CI()) {
                        if (hO.bd(false) == null) {
                            aeVar.cw(null);
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                        } else if (hO.bd(false).Di() == null) {
                            aeVar.cw(null);
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                        } else if (hO.CJ()) {
                            aeVar.cw(null);
                        } else {
                            aeVar.cw(bg.mz(hO.CO()));
                            if (bg.mA(hO.CO())) {
                                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", aeVar.field_username);
                            }
                        }
                    } else if (hO.CE() || hO.CH() || o.fC(str)) {
                        aeVar.cw(null);
                    } else {
                        aeVar.cw("officialaccounts");
                    }
                }
            }
        }
    };
    private d.a hwy = new d.a(this) {
        final /* synthetic */ w hwz;

        {
            this.hwz = r1;
        }

        public final void a(d.a.b bVar) {
            if ((bVar.hvE == d.a.a.hvA || bVar.hvE == d.a.a.hvC) && bVar.hvF != null) {
                af Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(bVar.huj);
                if (Rc == null) {
                    return;
                }
                if (!Rc.bLe()) {
                    w.h(bVar.hvF);
                } else if (!o.fh(Rc.field_username)) {
                    ae Rm = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rm(bVar.huj);
                    com.tencent.mm.sdk.platformtools.w.v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", bVar.huj);
                    if (!(!bVar.hvF.CI() || bVar.hvF.bd(false) == null || bVar.hvF.bd(false).Di() == null || bg.mA(bVar.hvF.CO()) || !bg.mA(bVar.hvF.field_enterpriseFather))) {
                        bVar.hvF.field_enterpriseFather = bVar.hvF.CO();
                        w.DH().e(bVar.hvF);
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", bVar.huj, bVar.hvF.field_enterpriseFather);
                    }
                    if (Rm != null) {
                        int i;
                        boolean z;
                        if (bVar.hvF.CI()) {
                            if (bVar.hvF.bd(false) == null) {
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                                return;
                            } else if (bVar.hvF.bd(false).Di() == null) {
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                                return;
                            } else {
                                String str = Rm.field_parentRef;
                                if (bVar.hvF.CJ()) {
                                    Rm.cw(null);
                                } else {
                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", bVar.hvF.CO(), bVar.huj);
                                    Rm.cw(bg.mz(bVar.hvF.CO()));
                                }
                                if (str != null && Rm.field_parentRef != null && !str.equals(Rm.field_parentRef)) {
                                    i = 1;
                                } else if (str == null && Rm.field_parentRef != null) {
                                    i = 1;
                                } else if (str == null || Rm.field_parentRef != null) {
                                    z = false;
                                } else {
                                    i = 1;
                                }
                                com.tencent.mm.sdk.platformtools.w.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", bVar.huj, Rm.field_parentRef);
                            }
                        } else if (bVar.hvF.CH()) {
                            com.tencent.mm.sdk.platformtools.w.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", bVar.huj);
                            i = 1;
                        } else if (!bVar.hvF.CE() && !o.fC(Rc.field_username) && !"officialaccounts".equals(Rm.field_parentRef)) {
                            Rm.cw("officialaccounts");
                            i = 1;
                        } else if (!bVar.hvF.CE() || Rm.field_parentRef == null) {
                            z = false;
                        } else {
                            Rm.cw(null);
                            i = 1;
                        }
                        if (i != 0) {
                            ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().a(Rm, Rm.field_username);
                            if (!bg.mA(Rm.field_parentRef)) {
                                aj Rm2;
                                String bLL;
                                au Ai;
                                if ("officialaccounts".equals(Rm.field_parentRef)) {
                                    Rm2 = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rm("officialaccounts");
                                    if (Rm2 == null) {
                                        aj aeVar = new ae("officialaccounts");
                                        aeVar.bLB();
                                        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().d(aeVar);
                                        Rm2 = aeVar;
                                    }
                                    if (bg.mA(Rm2.field_content)) {
                                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SubCoreBiz", "conv content is null");
                                        bLL = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().bLL();
                                        if (bg.mA(bLL)) {
                                            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.SubCoreBiz", "last convBiz is null");
                                            return;
                                        }
                                        Ai = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().Ai(bLL);
                                        if (Ai == null || Ai.field_msgId == 0) {
                                            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.SubCoreBiz", "last biz msg is error");
                                            return;
                                        } else {
                                            ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a(Ai.field_msgId, Ai);
                                            return;
                                        }
                                    }
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", bVar.huj, Rm.field_parentRef);
                                Rm2 = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rm(Rm.field_parentRef);
                                if (Rm2 != null && bg.mA(Rm2.field_content)) {
                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SubCoreBiz", "conv content is null");
                                    bLL = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rx(Rm.field_parentRef);
                                    if (bg.mA(bLL)) {
                                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
                                        return;
                                    }
                                    Ai = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().Ai(bLL);
                                    if (Ai == null || Ai.field_msgId == 0) {
                                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
                                    } else {
                                        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a(Ai.field_msgId, Ai);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    };

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("BIZINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return d.gUx;
            }
        });
        gJr.put(Integer.valueOf("BIZKF_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return h.gUx;
            }
        });
        gJr.put(Integer.valueOf("BIZCHAT_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return d.gUx;
            }
        });
        gJr.put(Integer.valueOf("BIZCHATUSER_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return k.gUx;
            }
        });
        gJr.put(Integer.valueOf("BIZCONVERSATION_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return b.gUx;
            }
        });
        gJr.put(Integer.valueOf("BIZCHAMYUSERINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return g.gUx;
            }
        });
        gJr.put(Integer.valueOf("BIZENTERPRISE_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return c.gUx;
            }
        });
    }

    private static synchronized w DF() {
        w wVar;
        synchronized (w.class) {
            wVar = (w) l.o(w.class);
        }
        return wVar;
    }

    public static h DG() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (DF().hwm == null) {
            DF().hwm = new h(com.tencent.mm.kernel.h.vI().gYg);
        }
        return DF().hwm;
    }

    public static d DH() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (DF().hwj == null) {
            DF().hwj = new d(com.tencent.mm.kernel.h.vI().gYg);
        }
        return DF().hwj;
    }

    public static g DI() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (DF().hwn == null) {
            DF().hwn = new g();
            com.tencent.mm.y.e eVar = DF().hwn;
            com.tencent.mm.kernel.h.vH().gXC.a(675, eVar);
            com.tencent.mm.kernel.h.vH().gXC.a(672, eVar);
            com.tencent.mm.kernel.h.vH().gXC.a(674, eVar);
            synchronized (eVar.hvG) {
                eVar.hvI.clear();
            }
        }
        return DF().hwn;
    }

    public static d DJ() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (DF().hwo == null) {
            DF().hwo = new d(com.tencent.mm.kernel.h.vI().gYg);
        }
        return DF().hwo;
    }

    public static b DK() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (DF().hwp == null) {
            DF().hwp = new b(com.tencent.mm.kernel.h.vI().gYg);
        }
        return DF().hwp;
    }

    public static k DL() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (DF().hwq == null) {
            DF().hwq = new k(com.tencent.mm.kernel.h.vI().gYg);
        }
        return DF().hwq;
    }

    public static g DM() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (DF().hwr == null) {
            DF().hwr = new g(com.tencent.mm.kernel.h.vI().gYg);
        }
        return DF().hwr;
    }

    public static h DN() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (DF().hwt == null) {
            DF().hwt = new h();
        }
        return DF().hwt;
    }

    public static c DO() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (DF().hwu == null) {
            DF().hwu = new c(com.tencent.mm.kernel.h.vI().gYg);
        }
        return DF().hwu;
    }

    public static a DP() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (DF().hwk == null) {
            DF().hwk = new a();
        }
        return DF().hwk;
    }

    public static j DQ() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (DF().hwl == null) {
            DF().hwl = new j();
        }
        return DF().hwl;
    }

    public static a DR() {
        if (DF().hwv == null) {
            DF().hwv = new a();
        }
        return DF().hwv;
    }

    public static i DS() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (DF().hws == null) {
            DF().hws = new i();
        }
        return DF().hws;
    }

    public static long DT() {
        if (hwi == 0) {
            Object obj = com.tencent.mm.kernel.h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_NEED_TO_UPDATE_CONVERSATION_TIME_DIVIDER_LONG, null);
            if (obj != null && (obj instanceof Long)) {
                hwi = ((Long) obj).longValue();
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", Long.valueOf(hwi));
            }
        }
        if (hwi == 0) {
            hwi = System.currentTimeMillis();
            com.tencent.mm.kernel.h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_NEED_TO_UPDATE_CONVERSATION_TIME_DIVIDER_LONG, Long.valueOf(hwi));
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", Long.valueOf(hwi));
        }
        return hwi;
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        com.tencent.mm.y.d.c.a(Integer.valueOf(55), this.hmf);
        com.tencent.mm.y.d.c.a(Integer.valueOf(57), this.hmf);
        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().b(this.hwx);
        DH().a(this.hwy, null);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("mmbizattrappsvr_BizAttrSync", this.hww, true);
    }

    public final void onAccountRelease() {
        com.tencent.mm.y.d.c.aA(Integer.valueOf(55));
        com.tencent.mm.y.d.c.aA(Integer.valueOf(57));
        if (DF().hwn != null) {
            com.tencent.mm.y.e eVar = DF().hwn;
            com.tencent.mm.kernel.h.vH().gXC.b(675, eVar);
            com.tencent.mm.kernel.h.vH().gXC.b(672, eVar);
            com.tencent.mm.kernel.h.vH().gXC.b(674, eVar);
            synchronized (eVar.hvG) {
                eVar.hvI.clear();
            }
            eVar.hvH.clear();
        }
        if (com.tencent.mm.kernel.h.vG().uV()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().c(this.hwx);
            DH().a(this.hwy);
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("mmbizattrappsvr_BizAttrSync", this.hww, true);
    }

    public final void aN(boolean z) {
    }

    public static void h(BizInfo bizInfo) {
        if (bizInfo.CI() && !bizInfo.CJ() && bizInfo.bd(false) != null && bizInfo.bd(false).Di() != null && !bg.mA(bizInfo.CO())) {
            if (((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rm(bizInfo.CO()) == null) {
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SubCoreBiz", "father conv is null");
            }
            if (((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rm(bizInfo.field_username) == null) {
                com.tencent.mm.sdk.platformtools.w.v("MicroMsg.SubCoreBiz", "add empty conv for enterprise child %s", bizInfo.field_username);
                ae aeVar = new ae(bizInfo.field_username);
                if (!bizInfo.CJ()) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", bizInfo.CO(), bizInfo.field_username);
                    aeVar.cw(bg.mz(bizInfo.CO()));
                    aeVar.bLB();
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().d(aeVar);
                }
            }
        }
    }
}
