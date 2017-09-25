package com.tencent.mm.plugin.d;

import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.g;

public final class a implements e, b {
    private static a ivC;
    private g ivD;

    private a() {
    }

    public static synchronized a Pj() {
        a aVar;
        synchronized (a.class) {
            if (ivC == null) {
                ivC = new a();
            }
            aVar = ivC;
        }
        return aVar;
    }

    public final g xB() {
        h.vG().uQ();
        return this.ivD;
    }

    public final void onDataBaseOpened(com.tencent.mm.bj.g gVar, com.tencent.mm.bj.g gVar2) {
        this.ivD = new g(gVar);
    }

    public final void onDataBaseClosed(com.tencent.mm.bj.g gVar, com.tencent.mm.bj.g gVar2) {
    }
}
