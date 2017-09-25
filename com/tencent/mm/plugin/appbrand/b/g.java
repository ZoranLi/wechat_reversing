package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.ads;
import com.tencent.mm.protocal.c.adt;
import com.tencent.mm.protocal.c.bqb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.b;
import java.util.List;

public enum g {
    ;
    
    public static Integer iCp;

    static {
        iCp = null;
    }

    public static boolean Ri() {
        c dX = com.tencent.mm.u.c.c.Az().dX("100242");
        return dX.isValid() && bg.getInt((String) dX.bKK().get("isOpenStarFunction"), 0) > 0;
    }

    static void a(int i, int i2, b bVar) {
        if (bVar != null && (((ads) bVar.hsj.hsr).condition & 2) != 0) {
            adt com_tencent_mm_protocal_c_adt = (adt) bVar.hsk.hsr;
            if (i == 0 && i2 == 0 && com_tencent_mm_protocal_c_adt != null) {
                if (com.tencent.mm.plugin.appbrand.app.c.PX() != null) {
                    f PX = com.tencent.mm.plugin.appbrand.app.c.PX();
                    List<bqb> list = com_tencent_mm_protocal_c_adt.tJm;
                    long cs = PX.izH.cs(Thread.currentThread().getId());
                    PX.izH.delete("AppBrandStarApp", "", null);
                    a aVar = new a();
                    for (bqb com_tencent_mm_protocal_c_bqb : list) {
                        if (!bg.mA(com_tencent_mm_protocal_c_bqb.username)) {
                            aVar.field_username = com_tencent_mm_protocal_c_bqb.username;
                            aVar.field_versionType = com_tencent_mm_protocal_c_bqb.tlI;
                            aVar.field_updateTime = (long) com_tencent_mm_protocal_c_bqb.tpx;
                            PX.izH.insert("AppBrandStarApp", null, aVar.pv());
                        }
                    }
                    PX.izH.aD(cs);
                    PX.a("batch", 3, list);
                    h.q(com_tencent_mm_protocal_c_adt.tJm);
                }
                h.vI().vr().a(a.uEf, Boolean.valueOf((com_tencent_mm_protocal_c_adt.status & 1) > 0));
            }
        }
    }
}
