package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.m;
import org.json.JSONObject;

public final class cg extends a {
    public static final int CTRL_INDEX = 9;
    public static final String NAME = "showNavigationBarLoading";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (d.b(mVar) == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        d.b(mVar).bZ(true);
        mVar.x(i, d("ok", null));
    }
}
