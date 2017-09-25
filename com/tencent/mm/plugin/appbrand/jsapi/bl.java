package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import org.json.JSONObject;

public final class bl extends b {
    public static final int CTRL_INDEX = 68;
    public static final String NAME = "removeCanvas";

    protected final int h(JSONObject jSONObject) {
        return jSONObject.optInt("canvasId");
    }
}
