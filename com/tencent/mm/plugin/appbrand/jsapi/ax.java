package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.m;
import org.json.JSONObject;

public final class ax extends a {
    public static final int CTRL_INDEX = 15;
    public static final String NAME = "navigateBack";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        mVar.ixr.iwr.ib(jSONObject.optInt("delta", 1));
        mVar.x(i, d("ok", null));
    }
}
