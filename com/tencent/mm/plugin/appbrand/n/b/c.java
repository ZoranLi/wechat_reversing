package com.tencent.mm.plugin.appbrand.n.b;

import com.tencent.mm.plugin.appbrand.n.b.a.b;
import com.tencent.mm.plugin.appbrand.n.e.a;

public class c extends b {
    public final b a(a aVar) {
        if (b.c(aVar) == 13) {
            return b.MATCHED;
        }
        return b.NOT_MATCHED;
    }

    public final com.tencent.mm.plugin.appbrand.n.e.b a(com.tencent.mm.plugin.appbrand.n.e.b bVar) {
        super.a(bVar);
        bVar.put("Sec-WebSocket-Version", "13");
        return bVar;
    }

    public a XU() {
        return new c();
    }
}
