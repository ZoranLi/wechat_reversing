package com.tencent.mm.plugin.sns;

import android.util.Base64;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.q.b;

public final class l implements h {
    public final void b(String str, d dVar) {
        o.b(str, dVar);
    }

    public final String a(String str, PString pString) {
        return o.a(str, pString);
    }

    public final void a(String str, b bVar, au auVar) {
        if (auVar.axO()) {
            a ek = a.ek(auVar.field_content);
            if (ek != null && !bg.mA(ek.fUY)) {
                bVar.l(str, ek.fUY);
            }
        }
    }

    public final void Q(au auVar) {
        String z = o.z(auVar);
        if (z != null) {
            byte[] decode = Base64.decode(z, 0);
            bdi com_tencent_mm_protocal_c_bdi = new bdi();
            try {
                com_tencent_mm_protocal_c_bdi.aD(decode);
                if (com_tencent_mm_protocal_c_bdi.ueA != null) {
                    String str = auVar.field_talker.endsWith("@chatroom") ? o.a.hXu.value : o.a.hXt.value;
                    w.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%s), statExtStr:%s(id=%s, uxinfo=%s)", new Object[]{str, z, com_tencent_mm_protocal_c_bdi.ueA.ueD, com_tencent_mm_protocal_c_bdi.ueA.ueE});
                    g.oUh.i(13235, new Object[]{str, com_tencent_mm_protocal_c_bdi.ueA.ueD, com_tencent_mm_protocal_c_bdi.ueA.ueE});
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, "", new Object[0]);
            }
        }
    }

    public final String z(au auVar) {
        return o.z(auVar);
    }
}
