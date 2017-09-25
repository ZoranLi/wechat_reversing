package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.e.a.lc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class g extends c<lc> {
    public g() {
        this.usg = lc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (ap.zb()) {
            h.aJu();
            ap.yY();
            if (bg.aA(bg.a((Long) com.tencent.mm.u.c.vr().get(102409, null), 0)) > 900000) {
                h.aJu().aJp();
                h.aJu();
                c.cz(bg.Nz());
            } else {
                w.d("MicroMsg.PostTaskMassSendListener", "time limit");
            }
        } else {
            w.e("MicroMsg.PostTaskMassSendListener", "has not set uin");
        }
        return false;
    }
}
