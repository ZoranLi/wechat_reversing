package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import org.json.JSONObject;

public final class c extends b {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "removeContainer";

    protected final int h(JSONObject jSONObject) {
        return jSONObject.getInt("containerId");
    }
}
