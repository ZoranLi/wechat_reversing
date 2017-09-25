package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.m;
import org.json.JSONObject;

public final class cb extends a {
    public static final int CTRL_INDEX = 8;
    public static final String NAME = "setNavigationBarTitle";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("title");
        if (d.b(mVar) == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        d.b(mVar).qp(optString);
        mVar.x(i, d("ok", null));
    }
}
