package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.ez;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.al.a;
import com.tencent.mm.sdk.platformtools.w;

public final class c extends com.tencent.mm.sdk.b.c<ez> {
    public c() {
        this.usg = ez.class.getName().hashCode();
    }

    private boolean a(final ez ezVar) {
        if (ezVar instanceof ez) {
            a beB = ae.beB();
            beB.a(ezVar.fJk.type, ezVar.fJk.username, new g.a(this) {
                final /* synthetic */ c pyG;

                public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j) {
                    if (ezVar.fJk != null) {
                        ezVar.fJk.fJo.a(null);
                    }
                }

                public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j) {
                }
            });
            beB.a(1, ezVar.fJk.username, ezVar.fJk.fJm, ezVar.fJk.fJn);
            return true;
        }
        w.f("MicroMsg.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener", "mismatched event");
        return false;
    }
}
