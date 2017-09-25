package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.c;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.protocal.c.aaz;
import com.tencent.mm.protocal.c.aba;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.bac;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class k extends com.tencent.mm.y.a<aba> {
    private static final long iCx = TimeUnit.MINUTES.toSeconds(5);

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] iCy = new int[a.Rn().length];

        static {
            try {
                iCy[a.iCz - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iCy[a.iCA - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum a {
        ;

        public static int[] Rn() {
            return (int[]) iCB.clone();
        }

        static {
            iCz = 1;
            iCA = 2;
            iCB = new int[]{iCz, iCA};
        }
    }

    protected final /* synthetic */ void a(int i, int i2, String str, avp com_tencent_mm_protocal_c_avp, com.tencent.mm.y.k kVar) {
        aba com_tencent_mm_protocal_c_aba = (aba) com_tencent_mm_protocal_c_avp;
        super.a(i, i2, str, com_tencent_mm_protocal_c_aba, kVar);
        c PV = com.tencent.mm.plugin.appbrand.app.c.PV();
        com.tencent.mm.plugin.appbrand.k.a Qd = com.tencent.mm.plugin.appbrand.app.c.Qd();
        if (PV == null || Qd == null) {
            w.e("MicroMsg.CgiGetSearchShowOutWxaApp", "storage NULL [ %s | %s ]", new Object[]{PV, Qd});
            return;
        }
        long j = (i == 0 && i2 == 0 && com_tencent_mm_protocal_c_aba != null) ? (long) com_tencent_mm_protocal_c_aba.tGZ : iCx;
        PV.aL("GetSearchShowOutWxaApp_interval", String.valueOf(j));
        if (i == 0 && i2 == 0 && com_tencent_mm_protocal_c_aba != null) {
            try {
                Qd.l("GetSearchShowOutWxaApp_resp", com_tencent_mm_protocal_c_aba.toByteArray());
            } catch (Exception e) {
                w.e("MicroMsg.CgiGetSearchShowOutWxaApp", "save resp e %s", new Object[]{e});
            }
            if (!bg.bV(com_tencent_mm_protocal_c_aba.tGX)) {
                List linkedList = new LinkedList();
                Iterator it = com_tencent_mm_protocal_c_aba.tGX.iterator();
                while (it.hasNext()) {
                    linkedList.add(((bac) it.next()).username);
                }
                q.R(linkedList);
            }
        }
    }

    private k(int i) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_aaz = new aaz();
        com_tencent_mm_protocal_c_aaz.fOl = (i - 1) + 1;
        aVar.hsm = com_tencent_mm_protocal_c_aaz;
        aVar.hsn = new aba();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getsearchshowoutwxaapp";
        aVar.hsl = 1314;
        this.gUA = aVar.BE();
    }

    public static void hC(int i) {
        if (h.vG().gXp) {
            switch (AnonymousClass1.iCy[i - 1]) {
                case 1:
                    if (bg.getLong(com.tencent.mm.plugin.appbrand.app.c.PV().get("GetSearchShowOutWxaApp_lastCheck", "$$invalid"), 0) + bg.getLong(com.tencent.mm.plugin.appbrand.app.c.PV().get("GetSearchShowOutWxaApp_interval", "$$invalid"), iCx) <= bg.Ny()) {
                        com.tencent.mm.plugin.appbrand.app.c.PV().aL("GetSearchShowOutWxaApp_lastCheck", String.valueOf(bg.Ny()));
                        break;
                    }
                    return;
                case 2:
                    if (((Long) h.vI().vr().get(com.tencent.mm.storage.w.a.uEz, Long.valueOf(0))).longValue() + TimeUnit.DAYS.toSeconds(1) <= bg.Ny()) {
                        h.vI().vr().a(com.tencent.mm.storage.w.a.uEz, Long.valueOf(bg.Ny()));
                        break;
                    }
                    return;
            }
            new k(i).BC();
        }
    }

    static aba Rm() {
        return (aba) com.tencent.mm.plugin.appbrand.app.c.Qd().e("GetSearchShowOutWxaApp_resp", aba.class);
    }
}
