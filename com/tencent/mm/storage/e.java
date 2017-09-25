package com.tencent.mm.storage;

import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.u.ay.b;

public abstract class e {
    public static j uyR;
    protected c uyQ;

    public abstract String QE(String str);

    protected boolean a(au auVar, b bVar) {
        return true;
    }

    public e(c cVar) {
        this.uyQ = cVar;
    }

    public final g aJZ() {
        return this.uyQ.aJZ();
    }

    protected final void a(g gVar, String str) {
        this.uyQ.a(gVar, str);
    }

    protected final void a(c.b bVar) {
        this.uyQ.a(bVar);
    }

    protected final String AB(String str) {
        return this.uyQ.AB(str);
    }

    protected final void a(c.c cVar) {
        this.uyQ.a(cVar);
    }

    protected final void eH(String str, String str2) {
        this.uyQ.b(str, str2, null);
    }
}
