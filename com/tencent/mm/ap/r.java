package com.tencent.mm.ap;

import com.tencent.mm.e.a.lc;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;

public final class r extends c<lc> {
    private static long gKu = 604800000;

    public r() {
        this.usg = lc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (bg.az(Long.valueOf(bg.c((Long) h.vI().vr().get(81937, null))).longValue()) * 1000 > gKu) {
            s.Ia().update();
        }
        return false;
    }
}
