package com.tencent.mm.plugin.safedevice.a;

import android.content.Context;
import android.os.Build;
import com.tencent.mm.R;
import com.tencent.mm.bd.a;
import com.tencent.mm.protocal.c.avz;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import java.util.List;

public final class e {
    public static void q(boolean z, boolean z2) {
        if (ap.zb()) {
            int xR = m.xR();
            if (z) {
                xR |= 16384;
            } else {
                xR &= -16385;
            }
            ap.yY();
            c.vr().set(40, Integer.valueOf(xR));
            if (z2) {
                a suVar = new su();
                suVar.tAG = 28;
                suVar.tAH = z ? 1 : 2;
                ap.yY();
                c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(23, suVar));
                com.tencent.mm.plugin.c.a.imw.ou();
            }
        }
    }

    static void a(awa com_tencent_mm_protocal_c_awa) {
        if (com_tencent_mm_protocal_c_awa != null && com_tencent_mm_protocal_c_awa.jNe != null) {
            List<avz> list = com_tencent_mm_protocal_c_awa.jNe;
            if (list != null && list.size() >= 0) {
                f.aXP().eE("SafeDeviceInfo", "delete from SafeDeviceInfo");
                for (avz cVar : list) {
                    f.aXP().a(new c(cVar));
                }
            }
        }
    }

    public static String cK(Context context) {
        return context == null ? f.usw ? ab.getContext().getString(R.l.eNL) : ab.getContext().getString(R.l.eNK) : f.usw ? context.getString(R.l.eNL) : context.getString(R.l.eNK);
    }

    public static String aXN() {
        return Build.MANUFACTURER + "-" + Build.MODEL;
    }
}
