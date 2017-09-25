package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class cl extends a {
    public static final int CTRL_INDEX = 65;
    public static final String NAME = "systemLog";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.i("AppBrandLog." + mVar.ivH, jSONObject.optString("message"));
    }

    public final void a(com.tencent.mm.plugin.appbrand.g.m mVar, JSONObject jSONObject, int i) {
        w.i("AppBrandLog." + mVar.ivH, jSONObject.optString("message"));
    }
}
