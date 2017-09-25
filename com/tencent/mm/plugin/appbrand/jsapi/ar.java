package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.g.m;
import org.json.JSONObject;

public final class ar extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "initReady";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        mVar.onReady();
    }
}
