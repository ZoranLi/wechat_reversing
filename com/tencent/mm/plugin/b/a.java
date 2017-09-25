package com.tencent.mm.plugin.b;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.a.d;
import com.tencent.mm.u.a.g;
import com.tencent.mm.u.bp;
import com.tencent.mm.u.l;

public final class a extends l implements c {
    private static a irF;
    private d irG = new d();
    private com.tencent.mm.u.a.a irH = new com.tencent.mm.u.a.a();

    private a() {
        super(g.class);
    }

    public static synchronized a Ox() {
        a aVar;
        synchronized (a.class) {
            if (irF == null) {
                irF = new a();
            }
            aVar = irF;
        }
        return aVar;
    }

    public final void onAccountInitialized(f fVar) {
        com.tencent.mm.y.d.c.a(Integer.valueOf(-1879048184), this.irG);
        ((n) h.j(n.class)).getSysCmdMsgExtension().a("abtest", this.irH);
    }

    public final void onAccountRelease() {
        com.tencent.mm.y.d.c.a(Integer.valueOf(-1879048184), this.irG);
        bp sysCmdMsgExtension = ((n) h.j(n.class)).getSysCmdMsgExtension();
        String str = "abtest";
        com.tencent.mm.u.a.a aVar = this.irH;
        if (!bg.mA(str) && aVar != null) {
            synchronized (sysCmdMsgExtension.hoo) {
                sysCmdMsgExtension.hoo.remove(str);
            }
        }
    }
}
