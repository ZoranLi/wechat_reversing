package com.tencent.mm.plugin.bbom;

import com.tencent.mm.R;
import com.tencent.mm.booter.notification.e;
import com.tencent.mm.i.a;
import com.tencent.mm.i.f;
import com.tencent.mm.plugin.zero.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class g implements b {
    public final void a(long j, String str, String str2, String str3, String str4, int i) {
        String string;
        if (bg.mA(str2)) {
            string = ab.getContext().getString(f.dH(str) ? R.l.dVr : R.l.esH);
        } else {
            string = str2;
        }
        e eVar = a.gLK.gLJ;
        if (!a.sn()) {
            e.cancel();
        }
        try {
            eVar.gLB.a(j, str, string, str3, str4, false, i);
        } catch (Throwable e) {
            w.e("MicroMsg.Notification.Handle", "push:notify, error");
            w.printErrStackTrace("MicroMsg.Notification.Handle", e, "", new Object[0]);
        }
    }

    public final void acP() {
        a.gLK.j(-1, null);
    }
}
