package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.sdk.platformtools.bg;
import java.util.Map;

final class f {
    static Map<String, d> iKT;
    static Map<String, d> iKU;

    static void a(d dVar) {
        if (!bg.mA(dVar.getName())) {
            iKT.put(dVar.getName(), dVar);
        }
    }

    static void b(d dVar) {
        if (!bg.mA(dVar.getName())) {
            iKU.put(dVar.getName(), dVar);
        }
    }
}
