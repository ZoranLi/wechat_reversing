package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.hl;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;

public final class e extends c<hl> {
    public e() {
        this.usg = hl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        hl hlVar = (hl) bVar;
        if (hlVar instanceof hl) {
            if (hlVar.fMS.fJK == 0) {
                h.vJ();
                h.vH().gXC.a(new u(1), 0);
            } else {
                h.vJ();
                h.vH().gXC.a(new u(hlVar.fMS.fJK), 0);
            }
            return true;
        }
        w.f("MicroMsg.GetSnsTagListListener", "mismatched event");
        return false;
    }
}
