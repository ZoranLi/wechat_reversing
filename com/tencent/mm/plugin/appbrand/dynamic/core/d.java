package com.tencent.mm.plugin.appbrand.dynamic.core;

import com.tencent.mm.plugin.appbrand.dynamic.core.b.a;
import org.json.JSONObject;

public abstract class d extends b {
    public abstract JSONObject a(e eVar);

    public d(String str) {
        super(str, 266);
    }

    public final void a(e eVar, JSONObject jSONObject, a aVar) {
        aVar.f(a(eVar));
    }
}
