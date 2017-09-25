package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.ao.r;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bc;

public final class d implements c, h {
    ad nyr;
    bc nys;
    av nyt;
    af nyu;
    r nyv;
    az nyw;
    ai nyx;

    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.c aJX() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        return this.nyt;
    }

    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.d wQ() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        return this.nyv;
    }

    public final /* synthetic */ ar wR() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        return this.nyr;
    }

    public final /* synthetic */ g wS() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        return this.nys;
    }

    public final /* synthetic */ as wW() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        return this.nyu;
    }

    public final /* synthetic */ f wZ() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        return this.nyw;
    }

    public final /* synthetic */ b xC() {
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        return this.nyx;
    }

    public final void onAccountInitialized(e.f fVar) {
    }

    public final void onAccountRelease() {
        if (this.nyr != null) {
            ad adVar = this.nyr;
            adVar.uIP.clear();
            adVar.uIQ.clear();
        }
        if (this.nyv != null) {
            com.tencent.mm.y.e eVar = this.nyv;
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vH().gXC.b(681, eVar);
        }
    }
}
