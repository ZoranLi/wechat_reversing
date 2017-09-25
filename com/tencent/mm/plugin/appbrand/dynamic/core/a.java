package com.tencent.mm.plugin.appbrand.dynamic.core;

import org.json.JSONObject;

public abstract class a extends b {
    public abstract void b(e eVar, JSONObject jSONObject, com.tencent.mm.plugin.appbrand.dynamic.core.b.a aVar);

    public a(String str, int i) {
        super(str, i);
    }

    public final void a(e eVar, JSONObject jSONObject, com.tencent.mm.plugin.appbrand.dynamic.core.b.a aVar) {
        b(eVar, jSONObject, aVar);
    }
}
