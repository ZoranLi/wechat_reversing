package com.tencent.mm.plugin.appbrand.dynamic.core;

import com.tencent.mm.plugin.appbrand.dynamic.d.a;
import com.tencent.mm.plugin.appbrand.dynamic.d.b;
import com.tencent.mm.plugin.appbrand.dynamic.d.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.d;
import com.tencent.mm.plugin.appbrand.dynamic.d.e;
import com.tencent.mm.plugin.appbrand.dynamic.d.f;
import com.tencent.mm.plugin.appbrand.dynamic.d.g;
import com.tencent.mm.plugin.appbrand.dynamic.d.i;
import java.util.HashMap;
import java.util.Map;

public class h {
    private static h iHD;
    Map<String, b> iHE = new HashMap();

    public static h Sc() {
        if (iHD == null) {
            synchronized (h.class) {
                if (iHD == null) {
                    iHD = new h();
                }
            }
        }
        return iHD;
    }

    private h() {
        a(new com.tencent.mm.plugin.appbrand.dynamic.d.h());
        a(new c());
        a(new d());
        a(new a());
        a(new b());
        a(new g());
        a(new f());
        a(new i());
        a(new e());
    }

    private void a(b bVar) {
        this.iHE.put(bVar.name, bVar);
    }
}
