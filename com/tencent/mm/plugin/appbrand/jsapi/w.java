package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.g.m;
import org.json.JSONObject;

public final class w extends a {
    public static final int CTRL_INDEX = 139;
    public static final String NAME = "disableScrollBounce";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (jSONObject.has("disable")) {
            if (jSONObject.optBoolean("disable", false)) {
                mVar.ca(false);
            } else {
                mVar.ca(mVar.ixr.iwp.nZ(mVar.jde.jdU).iEh);
            }
            mVar.x(i, d("ok", null));
            return;
        }
        mVar.x(i, d("ok", null));
    }
}
