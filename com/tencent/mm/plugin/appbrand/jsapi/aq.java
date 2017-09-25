package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.menu.k;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class aq extends a {
    public static final int CTRL_INDEX = 203;
    public static final String NAME = "hideShareMenu";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.JsApiHideShareMenu", "invoke");
        com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
        if (b != null) {
            b.A(k.jay, true);
        }
        mVar.x(i, d("ok", null));
    }
}
