package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.e.a.oh;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.protocal.c.bib;
import com.tencent.mm.protocal.c.bic;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;

public enum a {
    ;
    
    public static final c<oh> iBs = null;

    static {
        iBs = new c<oh>() {
            {
                this.usg = oh.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                oh ohVar = (oh) bVar;
                ohVar.fVr.fVt = a.QJ();
                if (ohVar.fVq.fVs) {
                    oh.b bVar2 = ohVar.fVr;
                    ohVar.fVr.fVu = false;
                    bVar2.fVv = false;
                    if (!a.QL()) {
                        switch (d.Rc()) {
                            case NEW:
                                ohVar.fVr.fVv = true;
                                break;
                            case REDDOT:
                                ohVar.fVr.fVu = true;
                                break;
                            default:
                                break;
                        }
                    }
                    ohVar.fVr.fVv = true;
                    if (ohVar.fVr.fVu || ohVar.fVr.fVv) {
                        d.Re();
                    }
                    d.c cVar = d.iBN;
                    c.QS();
                    if (ap.zb() && u.Cx()) {
                        long Ny = bg.Ny();
                        ap.yY();
                        long longValue = ((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uEt, Long.valueOf(0))).longValue();
                        ap.yY();
                        long longValue2 = ((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uEv, Long.valueOf(Long.MAX_VALUE))).longValue();
                        ap.yY();
                        longValue2 += ((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uEu, Long.valueOf(0))).longValue();
                        if (longValue2 > 0 && Ny < longValue && Ny >= longValue2) {
                            w.d("MicroMsg.AppBrandPushNewOrRedDotLogic", "doReport");
                            com.tencent.mm.modelgeo.c.Gk().b((com.tencent.mm.modelgeo.a.a) d.aN(new com.tencent.mm.modelgeo.a.a(cVar) {
                                int count = 0;
                                final /* synthetic */ c iBU;

                                {
                                    this.iBU = r2;
                                }

                                public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                                    com.tencent.mm.plugin.appbrand.m.d.aO(this);
                                    com.tencent.mm.modelgeo.c.Gk().c(this);
                                    int i2 = this.count;
                                    this.count = i2 + 1;
                                    if (i2 <= 0 && z) {
                                        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
                                        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/uploaduserlocationinfo";
                                        aVar.hsl = 1154;
                                        aVar.hsn = new bic();
                                        com.tencent.mm.bd.a com_tencent_mm_protocal_c_bib = new bib();
                                        com_tencent_mm_protocal_c_bib.latitude = (double) f2;
                                        com_tencent_mm_protocal_c_bib.longitude = (double) f;
                                        com_tencent_mm_protocal_c_bib.uhx = d2;
                                        aVar.hsm = com_tencent_mm_protocal_c_bib;
                                        final float f3 = f;
                                        final float f4 = f2;
                                        final double d4 = d2;
                                        u.a(aVar.BE(), new com.tencent.mm.y.u.a(this) {
                                            final /* synthetic */ AnonymousClass1 iBX;

                                            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                                                w.d("MicroMsg.AppBrandPushNewOrRedDotLogic", "locationReport, errType %d, errCode %d, errMsg %s, longitude %f, latitude %f, accuracy %f", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Float.valueOf(f3), Float.valueOf(f4), Double.valueOf(d4)});
                                                return 0;
                                            }
                                        }, true);
                                    }
                                    return true;
                                }
                            }), true);
                            ap.yY();
                            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uEu, Long.valueOf(Ny));
                        }
                    }
                }
                return true;
            }
        };
    }

    public static boolean QJ() {
        if (!h.vG().uV()) {
            return false;
        }
        if (g.sV().getInt("WeAppForbiddenSwitch", 0) == 1) {
            w.i("MicroMsg.AppBrandEntranceLogic", "showInFindMore, WeAppForbiddenSwitch == 1, not show");
            return false;
        } else if (QP() || d.Rb()) {
            return true;
        } else {
            return false;
        }
    }

    public static void QK() {
        if (h.vG().uV()) {
            if (QL()) {
                e eVar = e.iBZ;
                e.a("", 0, 2, 1);
            }
            h.vI().vr().a(com.tencent.mm.storage.w.a.uEr, Boolean.valueOf(false));
        }
    }

    static boolean QL() {
        if (h.vG().uV()) {
            return ((Boolean) h.vI().vr().get(com.tencent.mm.storage.w.a.uEr, Boolean.valueOf(false))).booleanValue();
        }
        return false;
    }

    static void hA(int i) {
        boolean z = true;
        if (h.vG().uV()) {
            boolean z2;
            t vr = h.vI().vr();
            if ((i & 2) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            bI(z2);
            com.tencent.mm.storage.w.a aVar = com.tencent.mm.storage.w.a.uEf;
            if ((i & 1) <= 0) {
                z = false;
            }
            vr.a(aVar, Boolean.valueOf(z));
        }
    }

    private static void bI(boolean z) {
        if (h.vG().uV()) {
            boolean z2;
            Boolean bool = (Boolean) h.vI().vr().get(com.tencent.mm.storage.w.a.uEg, null);
            if (bool == null || bool.booleanValue() || !z) {
                z2 = false;
            } else {
                h.vI().vr().a(com.tencent.mm.storage.w.a.uEr, Boolean.valueOf(true));
                e eVar = e.iBZ;
                e.a("", 0, 1, 1);
                z2 = true;
            }
            h.vI().vr().a(com.tencent.mm.storage.w.a.uEg, Boolean.valueOf(z));
            if (z2) {
                com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a PP = com.tencent.mm.plugin.appbrand.app.c.PP();
                if (PP != null) {
                    PP.jin = true;
                }
            }
        }
    }

    static void QM() {
        bI(true);
    }

    public static boolean QN() {
        if (h.vG().uV()) {
            return ((Boolean) h.vI().vr().get(com.tencent.mm.storage.w.a.uEg, Boolean.valueOf(false))).booleanValue();
        }
        return false;
    }

    public static boolean QO() {
        if (g.Ri() && h.vG().uV()) {
            return ((Boolean) h.vI().vr().get(com.tencent.mm.storage.w.a.uEf, Boolean.valueOf(false))).booleanValue();
        }
        return false;
    }

    public static boolean QP() {
        return QO() || QN();
    }
}
