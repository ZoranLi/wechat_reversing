package com.tencent.mm.plugin.hardwareopt.a;

import com.tencent.mm.plugin.hardwareopt.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.e;

public final class a implements com.tencent.mm.plugin.hardwareopt.a.a.a {
    public final void eN(boolean z) {
        new e().t(new Object[]{ab.getContext()}).c(new com.tencent.mm.plugin.hardwareopt.c.a()).b(new b(z)).a(new com.tencent.mm.vending.g.d.a(this) {
            final /* synthetic */ a mKR;

            {
                this.mKR = r1;
            }

            public final void aD(Object obj) {
                w.w("MicroMsg.HardwareProvider", "hy: on interrupt.");
            }
        }).a(new d.b<Boolean>(this) {
            final /* synthetic */ a mKR;

            {
                this.mKR = r1;
            }

            public final /* synthetic */ void ar(Object obj) {
                w.i("MicroMsg.HardwareProvider", "hy: on terminate");
            }
        });
    }
}
