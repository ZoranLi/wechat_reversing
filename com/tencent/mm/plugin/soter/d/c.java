package com.tencent.mm.plugin.soter.d;

import com.tencent.d.b.e.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class c implements a<Boolean, com.tencent.mm.vending.j.c<Boolean, Boolean>> {
    public b ink = null;

    public final /* synthetic */ Object call(Object obj) {
        final com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
        w.v("MicroMsg.SoterPrepareAskFunc", "alvinluo SoterPrepareAskFunc call");
        if (((Boolean) cVar.get(0)).booleanValue()) {
            this.ink = g.cbB();
            if (!com.tencent.d.b.a.cfL()) {
                return Boolean.valueOf(false);
            }
            e eVar = h.vG().uV() ? new com.tencent.mm.plugin.soter.b.e() : new f();
            w.v("MicroMsg.SoterPrepareAskFunc", "alvinluo has ask: %b", new Object[]{Boolean.valueOf(com.tencent.d.a.a.cfE())});
            this.ink.cbA();
            com.tencent.d.b.a.a(new com.tencent.d.b.a.b<com.tencent.d.b.a.c>(this) {
                final /* synthetic */ c qQf;

                public final /* synthetic */ void a(com.tencent.d.b.a.e eVar) {
                    com.tencent.d.b.a.c cVar = (com.tencent.d.b.a.c) eVar;
                    w.i("MicroMsg.SoterPrepareAskFunc", "alvinluo SoterPrepareAskFunc onResult errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(cVar.errCode), cVar.fPf});
                    if (cVar.isSuccess()) {
                        this.qQf.ink.s(new Object[]{cVar.get(1)});
                        return;
                    }
                    com.tencent.mm.plugin.soter.c.a.dj(1, cVar.errCode);
                    this.qQf.ink.bJ(g.t(Integer.valueOf(cVar.errCode), cVar.fPf));
                }
            }, false, eVar);
            w.v("MicroMsg.SoterPrepareAskFunc", "alvinluo prepareask isNeedSaveDeviceInfo: %b", new Object[]{cVar.get(1)});
            return (Boolean) cVar.get(1);
        }
        w.i("MicroMsg.SoterPrepareAskFunc", "alvinluo not need prepare ask, return");
        return (Boolean) cVar.get(1);
    }
}
