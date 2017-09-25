package com.tencent.mm.plugin.label;

import com.tencent.mm.e.a.lc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class d extends c<lc> {
    public d() {
        this.usg = lc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ap.yY();
        if (System.currentTimeMillis() - ((Long) com.tencent.mm.u.c.vr().get(209408, Long.valueOf(0))).longValue() > 86400000) {
            w.i("MicroMsg.Label.PostTaskGetContactLabelListener", "cpan[callback] get contact label list.");
            ap.vd().a(new com.tencent.mm.plugin.label.b.c(), 0);
            ap.yY();
            com.tencent.mm.u.c.vr().set(209408, Long.valueOf((System.currentTimeMillis() - 86400000) + 1800000));
        }
        return false;
    }
}
