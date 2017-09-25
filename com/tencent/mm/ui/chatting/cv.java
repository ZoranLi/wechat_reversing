package com.tencent.mm.ui.chatting;

import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.b;
import java.lang.ref.WeakReference;

final class cv implements b {
    private WeakReference<a> vEN;

    cv() {
    }

    final void b(a aVar) {
        this.vEN = new WeakReference(aVar);
        aVar.a((b) this);
    }

    public final void bUr() {
        if (this.vEN != null) {
            a aVar = (a) this.vEN.get();
            if (aVar != null) {
                ((e) h.h(e.class)).AM().gJ(com.tencent.mm.plugin.appbrand.l.b.aM(aVar));
            }
        }
    }

    public final void bUs() {
        if (this.vEN != null) {
            a aVar = (a) this.vEN.get();
            if (aVar != null) {
                ((e) h.h(e.class)).AM().gK(com.tencent.mm.plugin.appbrand.l.b.aM(aVar));
            }
        }
    }

    public final void bUt() {
        w.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExit, then detach DynamicPageView.");
        if (this.vEN != null) {
            a aVar = (a) this.vEN.get();
            if (aVar != null) {
                q.yC().fP(com.tencent.mm.plugin.appbrand.l.b.aM(aVar));
                aVar.b((b) this);
                ((e) h.h(e.class)).gL(com.tencent.mm.plugin.appbrand.l.b.aM(aVar));
            }
        }
    }
}
