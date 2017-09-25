package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.pp;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;

public final class n extends c<pp> {
    public n() {
        this.usg = pp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pp ppVar = (pp) bVar;
        if (ppVar instanceof pp) {
            ppVar.fWw.fFj = a.a(ppVar.fWv.fWz, ppVar.fWv.url, ppVar.fWv.fWy);
            return true;
        }
        w.f("MicroMsg.SnsfillEventInfoListener", "mismatched event");
        return false;
    }
}
