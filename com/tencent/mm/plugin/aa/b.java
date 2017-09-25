package com.tencent.mm.plugin.aa;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.bl;
import com.tencent.mm.e.a.bm;
import com.tencent.mm.e.a.lq;
import com.tencent.mm.e.a.lr;
import com.tencent.mm.e.a.sc;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.aa.a.a.d;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.vending.c.a;
import java.util.HashMap;
import java.util.Map;

public final class b implements am {
    private static HashMap<Integer, c> gJr;
    private com.tencent.mm.sdk.b.c<bm> imA = new com.tencent.mm.sdk.b.c<bm>(this) {
        final /* synthetic */ b imF;

        {
            this.imF = r2;
            this.usg = bm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            final bm bmVar = (bm) bVar;
            if (!(bg.mA(bmVar.fEV.fES) || bg.mA(bmVar.fEV.fET))) {
                new d(bmVar.fEV.fES, bmVar.fEV.fET).BC().e(new a<Void, com.tencent.mm.y.a.a<com.tencent.mm.protocal.c.c>>(this) {
                    final /* synthetic */ AnonymousClass4 imJ;

                    public final /* synthetic */ Object call(Object obj) {
                        com.tencent.mm.y.a.a aVar = (com.tencent.mm.y.a.a) obj;
                        w.i("MicroMsg.SubCoreAA", "close aa urge notify cgiback, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
                        if (aVar.errType == 0 && aVar.errCode == 0) {
                            w.i("MicroMsg.SubCoreAA", "close aa urge notify success");
                            if (((com.tencent.mm.protocal.c.c) aVar.fYb).kAC > 0 && !bg.mA(((com.tencent.mm.protocal.c.c) aVar.fYb).kAD)) {
                                Toast.makeText(ab.getContext(), ((com.tencent.mm.protocal.c.c) aVar.fYb).kAD, 0).show();
                                g.oUh.a(407, 29, 1, false);
                            } else if (((com.tencent.mm.protocal.c.c) aVar.fYb).kAC == 0) {
                                Toast.makeText(ab.getContext(), R.l.dWm, 0).show();
                                g.oUh.a(407, 27, 1, false);
                                if (!bg.mA(((com.tencent.mm.protocal.c.c) aVar.fYb).tbj)) {
                                    h.g(bmVar.fEV.fEU, ((com.tencent.mm.protocal.c.c) aVar.fYb).tbj);
                                }
                            } else {
                                w.i("MicroMsg.SubCoreAA", "illegal resp");
                                g.oUh.a(407, 29, 1, false);
                            }
                        } else {
                            w.i("MicroMsg.SubCoreAA", "close aa urge notify failed");
                            Toast.makeText(ab.getContext(), R.l.dWl, 1).show();
                            g.oUh.a(407, 28, 1, false);
                        }
                        return wCE;
                    }
                });
            }
            return false;
        }
    };
    private m imB = new m(this) {
        final /* synthetic */ b imF;

        {
            this.imF = r1;
        }

        public final void b(String str, Map<String, String> map) {
            w.d("MicroMsg.SubCoreAA", "paymsgtype: %d, current version: %d", new Object[]{Integer.valueOf(bg.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0)), Integer.valueOf(com.tencent.mm.protocal.d.sYN)});
            if (bg.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0) == 32) {
                int i = bg.getInt((String) map.get(".sysmsg.paymsg.receiveorpayreddot"), 0);
                int i2 = bg.getInt((String) map.get(".sysmsg.paymsg.grouppayreddot"), 0);
                int i3 = bg.getInt((String) map.get(".sysmsg.paymsg.facingreceivereddot"), 0);
                int i4 = bg.getInt((String) map.get(".sysmsg.paymsg.f2fhongbaoreddot"), 0);
                if (com.tencent.mm.protocal.d.sYN >= bg.getInt((String) map.get(".sysmsg.paymsg.android_minclientversion"), 0)) {
                    if (i == 1) {
                        w.i("MicroMsg.SubCoreAA", "mark recv or pay red dot");
                        com.tencent.mm.q.c.uk().t(262159, true);
                    }
                    if (i2 == 1) {
                        w.i("MicroMsg.SubCoreAA", "mark group pay red dot");
                        com.tencent.mm.q.c.uk().t(262160, true);
                    }
                    if (i3 == 1) {
                        w.i("MicroMsg.SubCoreAA", "mark f2f recv red dot");
                        com.tencent.mm.q.c.uk().t(262161, true);
                    }
                    if (i4 == 1) {
                        w.i("MicroMsg.SubCoreAA", "mark f2f hb red dot");
                        com.tencent.mm.q.c.uk().t(262162, true);
                    }
                }
                g.oUh.i(14396, new Object[]{Integer.valueOf(1)});
            }
        }
    };
    com.tencent.mm.sdk.b.c<sc> imC = new com.tencent.mm.sdk.b.c<sc>(this) {
        final /* synthetic */ b imF;

        {
            this.imF = r2;
            this.usg = sc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            int i;
            sc scVar = (sc) bVar;
            String str = scVar.fZA.fZC;
            com.tencent.mm.e.a.sc.b bVar2 = scVar.fZB;
            com.tencent.mm.plugin.aa.a.b.d NJ = b.NJ();
            if (com.tencent.mm.plugin.aa.a.b.d.ioj.containsKey(str)) {
                i = ((com.tencent.mm.plugin.aa.a.b.c) com.tencent.mm.plugin.aa.a.b.d.ioj.get(str)).field_status;
            } else {
                com.tencent.mm.plugin.aa.a.b.c mJ = NJ.mJ(str);
                if (mJ != null) {
                    com.tencent.mm.plugin.aa.a.b.d.ioj.put(str, mJ);
                    i = mJ.field_status;
                } else {
                    i = -1;
                }
            }
            bVar2.status = i;
            return false;
        }
    };
    private com.tencent.mm.plugin.aa.a.b.d imD;
    private com.tencent.mm.plugin.aa.a.b.b imE;
    private com.tencent.mm.sdk.b.c<lr> imx = new com.tencent.mm.sdk.b.c<lr>(this) {
        final /* synthetic */ b imF;

        {
            this.imF = r2;
            this.usg = lr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            lr lrVar = (lr) bVar;
            String str = "MicroMsg.SubCoreAA";
            String str2 = "receiveAANewXmlEventListener, content==null: %s, type: %s, fromUser: %s, toUser: %s, paymsgid: %s";
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(lrVar.fSP.content == null);
            objArr[1] = Integer.valueOf(lrVar.fSP.type);
            objArr[2] = lrVar.fSP.fOu;
            objArr[3] = lrVar.fSP.toUser;
            objArr[4] = lrVar.fSP.fSQ;
            w.i(str, str2, objArr);
            if (lrVar.fSP.type == com.tencent.mm.plugin.aa.a.a.inh) {
                h.at(lrVar.fSP.content, lrVar.fSP.toUser);
            } else if (lrVar.fSP.type == com.tencent.mm.plugin.aa.a.a.ini) {
                h.r(lrVar.fSP.content, lrVar.fSP.toUser, lrVar.fSP.fSQ);
            } else if (lrVar.fSP.type == com.tencent.mm.plugin.aa.a.a.inj) {
                String str3 = lrVar.fSP.content;
                str = lrVar.fSP.toUser;
                w.i("MicroMsg.AAUtil", "insertUrgePaySysMsg, toUser: %s", new Object[]{str});
                if (!bg.mA(str3) && o.dH(str)) {
                    ce auVar = new au();
                    auVar.dw(0);
                    auVar.cH(str);
                    auVar.dv(3);
                    auVar.setContent(str3);
                    auVar.z(ay.i(str3, System.currentTimeMillis() / 1000));
                    auVar.setType(10000);
                    auVar.dF(auVar.field_flag | 8);
                    auVar.x(ay.i(auVar));
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<lq> imy = new com.tencent.mm.sdk.b.c<lq>(this) {
        final /* synthetic */ b imF;

        {
            this.imF = r2;
            this.usg = lq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            lq lqVar = (lq) bVar;
            w.i("MicroMsg.SubCoreAA", "ReceiveAAMsgEvent, localMsgId: %s, msgContent: %s", new Object[]{Long.valueOf(lqVar.fSN.fSO), bg.Qj(lqVar.fSN.fSs)});
            h.f(r0, r2);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<bl> imz = new com.tencent.mm.sdk.b.c<bl>(this) {
        final /* synthetic */ b imF;

        {
            this.imF = r2;
            this.usg = bl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            bl blVar = (bl) bVar;
            w.i("MicroMsg.SubCoreAA", "closeAAEvent callback, billNo: %s, chatroom: %s", new Object[]{blVar.fER.fES, blVar.fER.fET});
            if (!(bg.mA(blVar.fER.fES) || bg.mA(blVar.fER.fET))) {
                final j jVar = new j();
                jVar.NV().init();
                a aVar = jVar.inE;
                String str = blVar.fER.fES;
                int i = com.tencent.mm.plugin.aa.a.a.ing;
                com.tencent.mm.vending.g.g.a(str, Integer.valueOf(i), blVar.fER.fET, Long.valueOf(blVar.fER.fEU)).a(aVar).b(new a<Void, Boolean>(this) {
                    final /* synthetic */ AnonymousClass3 imH;

                    public final /* synthetic */ Object call(Object obj) {
                        w.i("MicroMsg.SubCoreAA", "close aa success: %s", new Object[]{(Boolean) obj});
                        jVar.NV().NU();
                        Toast.makeText(ab.getContext(), R.l.dWm, 0).show();
                        return wCE;
                    }
                }).a(new com.tencent.mm.vending.g.d.a(this) {
                    final /* synthetic */ AnonymousClass3 imH;

                    public final void aD(Object obj) {
                        if (obj instanceof String) {
                            Toast.makeText(ab.getContext(), obj.toString(), 0).show();
                        } else {
                            w.e("MicroMsg.SubCoreAA", "close aa failed: %s", new Object[]{obj});
                            Toast.makeText(ab.getContext(), R.l.dWn, 1).show();
                        }
                        jVar.NV().NU();
                    }
                });
            }
            return false;
        }
    };

    private static b NI() {
        b bVar = (b) ap.yR().gs("plugin.aa");
        if (bVar != null) {
            return bVar;
        }
        Object bVar2 = new b();
        ap.yR().a("plugin.aa", bVar2);
        return bVar2;
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("AARecord".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.aa.a.b.d.gUx;
            }
        });
        gJr.put(Integer.valueOf("AAPayRecord".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.aa.a.b.b.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public static com.tencent.mm.plugin.aa.a.b.d NJ() {
        if (NI().imD == null) {
            b NI = NI();
            ap.yY();
            NI.imD = new com.tencent.mm.plugin.aa.a.b.d(com.tencent.mm.u.c.wO());
        }
        return NI().imD;
    }

    public static com.tencent.mm.plugin.aa.a.b.b NK() {
        if (NI().imE == null) {
            b NI = NI();
            ap.yY();
            NI.imE = new com.tencent.mm.plugin.aa.a.b.b(com.tencent.mm.u.c.wO());
        }
        return NI().imE;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        com.tencent.mm.sdk.b.a.urY.b(this.imx);
        com.tencent.mm.sdk.b.a.urY.b(this.imy);
        com.tencent.mm.sdk.b.a.urY.b(this.imz);
        com.tencent.mm.sdk.b.a.urY.b(this.imA);
        com.tencent.mm.sdk.b.a.urY.b(this.imC);
        ap.getSysCmdMsgExtension().a("paymsg", this.imB);
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.urY.c(this.imx);
        com.tencent.mm.sdk.b.a.urY.c(this.imy);
        com.tencent.mm.sdk.b.a.urY.c(this.imz);
        com.tencent.mm.sdk.b.a.urY.c(this.imA);
        com.tencent.mm.sdk.b.a.urY.c(this.imC);
        ap.getSysCmdMsgExtension().b("paymsg", this.imB);
    }
}
