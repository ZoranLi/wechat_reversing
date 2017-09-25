package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.m;
import org.json.JSONObject;

public final class c extends a {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "setStatusBarStyle";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("color", "");
        com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
        if (b == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        if (optString.equals("white")) {
            b.qs("white");
        } else if (optString.equals("black")) {
            b.qs("black");
        }
        mVar.x(i, d("ok", null));
    }
}
