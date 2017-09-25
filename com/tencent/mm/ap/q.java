package com.tencent.mm.ap;

import com.tencent.mm.e.a.lc;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class q extends c<lc> {
    private static long gKu = 86400000;

    public q() {
        this.usg = lc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        return HZ();
    }

    private static boolean HZ() {
        w.d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + qf());
        if (qf()) {
            c.HV().update();
        }
        return false;
    }

    private static boolean qf() {
        if (bg.az(Long.valueOf(bg.c((Long) h.vI().vr().get(81938, null))).longValue()) * 1000 > gKu) {
            return true;
        }
        return false;
    }
}
