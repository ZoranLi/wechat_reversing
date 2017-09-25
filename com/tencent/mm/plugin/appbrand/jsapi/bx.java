package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.menu.MenuDelegate_EnableDebug;
import org.json.JSONObject;

public final class bx extends a {
    public static final int CTRL_INDEX = 249;
    public static final String NAME = "setEnableDebug";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        boolean optBoolean = jSONObject.optBoolean("enableDebug", false);
        if (mVar.ixr.iwo.iER == optBoolean) {
            mVar.x(i, d("ok", null));
            return;
        }
        MenuDelegate_EnableDebug.e(mVar.mContext, mVar.ivH, optBoolean);
        mVar.x(i, d("ok", null));
    }
}
