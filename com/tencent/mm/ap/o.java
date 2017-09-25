package com.tencent.mm.ap;

import com.tencent.mm.e.a.lc;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.bm;
import com.tencent.smtt.sdk.QbSdk;

public final class o extends c<lc> {
    public o() {
        this.usg = lc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (bg.az(bg.a((Long) h.vI().vr().get(66818, null), 0)) * 1000 > 1800000) {
            int a = bg.a((Integer) h.vI().vr().get(66820, null), (int) QbSdk.EXTENSION_INIT_FAILURE);
            if (a != QbSdk.EXTENSION_INIT_FAILURE) {
                bm.n(9, String.valueOf(a));
                h.vI().vr().set(66820, Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE));
            }
            h.vI().vr().set(66818, Long.valueOf(bg.Ny()));
        }
        return false;
    }
}
