package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.AnonymousClass11;
import com.tencent.mm.plugin.appbrand.m;
import org.json.JSONObject;

public final class ay extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "navigateBackMiniProgram";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
        h hVar = mVar.ixr;
        hVar.iwk.runOnUiThread(new AnonymousClass11(hVar, optJSONObject));
    }
}
