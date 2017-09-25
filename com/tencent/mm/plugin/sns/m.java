package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.pi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.model.t;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;

public final class m extends c<pi> {
    public m() {
        this.usg = pi.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((pi) bVar) instanceof pi) {
            w.d("MicroMsg.SnsSyncListener", "NetSceneSnsSync");
            h.vJ();
            h.vH().gXC.a(new t(), 0);
            return true;
        }
        w.f("MicroMsg.SnsSyncListener", "mismatched event");
        return false;
    }
}
