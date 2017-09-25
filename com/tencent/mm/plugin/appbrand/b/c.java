package com.tencent.mm.plugin.appbrand.b;

import android.os.Looper;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.c.adq;
import com.tencent.mm.protocal.c.adr;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public enum c {
    ;
    
    private static volatile long iBA;
    private static volatile adr iBB;
    private static final Set<b> iBC = null;

    enum a {
        public static final a iBJ = null;
        public static final a iBK = null;
        public static final a iBL = null;
        private static final /* synthetic */ a[] iBM = null;
        final int value;

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) iBM.clone();
        }

        static {
            iBJ = new a("FORCE_OFF", 0, 0);
            iBK = new a("FORCE_ON", 1, 1);
            iBL = new a("DYNAMIC_THRESHOLD", 2, 2);
            iBM = new a[]{iBJ, iBK, iBL};
        }

        private a(String str, int i, int i2) {
            this.value = i2;
        }
    }

    public interface b {
        void Ra();
    }

    static {
        iBC = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static void a(b bVar) {
        if (bVar != null) {
            iBC.add(bVar);
        }
    }

    public static void b(b bVar) {
        if (bVar != null) {
            iBC.remove(bVar);
        }
    }

    public static boolean QS() {
        return true;
    }

    public static boolean QT() {
        switch (QU()) {
            case iBK:
                return true;
            case iBL:
                if (QV()) {
                    return true;
                }
                return iBB != null && iBB.jDf >= iBB.tJj;
            default:
                return false;
        }
    }

    public static boolean refresh() {
        iBB = null;
        iBA = 0;
        if (a.iBJ == QU()) {
            return false;
        }
        final PBool pBool = new PBool();
        final PBool pBool2 = new PBool();
        pBool.value = false;
        pBool2.value = false;
        aj ajVar = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a() {
            public final boolean oQ() {
                if (!pBool2.value) {
                    pBool.value = true;
                    c.a(null);
                }
                return false;
            }
        }, false);
        long toMillis = TimeUnit.SECONDS.toMillis(20);
        ajVar.v(toMillis, toMillis);
        com.tencent.mm.modelgeo.c.Gk().b((com.tencent.mm.modelgeo.a.a) d.aN(new com.tencent.mm.modelgeo.a.a() {
            private int iBG;

            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                d.aO(this);
                com.tencent.mm.modelgeo.c.Gk().c(this);
                int i2 = this.iBG + 1;
                this.iBG = i2;
                if (i2 > 1 || pBool.value) {
                    return false;
                }
                pBool2.value = true;
                if (z) {
                    com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
                    aVar.hsl = 1056;
                    aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxaappnearby";
                    com.tencent.mm.bd.a com_tencent_mm_protocal_c_adq = new adq();
                    com_tencent_mm_protocal_c_adq.tJc = (double) f;
                    com_tencent_mm_protocal_c_adq.tJd = (double) f2;
                    com_tencent_mm_protocal_c_adq.tJf = !c.QV();
                    aVar.hsm = com_tencent_mm_protocal_c_adq;
                    aVar.hsn = new adr();
                    u.a(aVar.BE(), new com.tencent.mm.y.u.a(this) {
                        final /* synthetic */ AnonymousClass2 iBH;

                        {
                            this.iBH = r1;
                        }

                        public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                            if (i == 0 && i2 == 0 && bVar != null && bVar.hsk.hsr != null && (bVar.hsk.hsr instanceof adr)) {
                                c.a((adr) bVar.hsk.hsr);
                            } else {
                                w.e("MicroMsg.AppBrandNearbyLogic", "refresh() cgi return errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                                c.a(null);
                            }
                            return 0;
                        }
                    }, true);
                    return false;
                }
                c.a(null);
                return false;
            }
        }), false);
        return true;
    }

    static a QU() {
        int i = 0;
        if (!h.vG().uV()) {
            return a.iBJ;
        }
        com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100215");
        if (dX.isValid()) {
            int i2 = bg.getInt((String) dX.bKK().get("isOpenNewNearEntry"), 0);
            a[] values = a.values();
            int length = values.length;
            while (i < length) {
                a aVar = values[i];
                if (aVar.value == i2) {
                    return aVar;
                }
                i++;
            }
        }
        return a.iBJ;
    }

    static boolean QV() {
        return h.vI().vr().c(com.tencent.mm.storage.w.a.uEx, false);
    }

    static void QW() {
        h.vI().vr().a(com.tencent.mm.storage.w.a.uEx, Boolean.valueOf(true));
    }

    public static adr QX() {
        return iBB;
    }

    public static boolean QY() {
        long Ny = bg.Ny();
        long j = (!h.vG().uV() || iBB == null) ? 0 : iBA;
        return Ny >= j;
    }

    public static void QZ() {
        iBB = null;
    }
}
