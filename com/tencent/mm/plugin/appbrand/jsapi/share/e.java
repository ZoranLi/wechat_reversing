package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.menu.k;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 146;
    public static final String NAME = "showShareMenu";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
        if (b != null) {
            b.A(k.jay, false);
        }
        mVar.x(i, d("ok", null));
    }
}
