package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import org.json.JSONObject;

public final class cn extends c {
    public static final int CTRL_INDEX = 83;
    public static final String NAME = "updateCanvas";

    protected final int h(JSONObject jSONObject) {
        return jSONObject.optInt("canvasId");
    }

    protected final boolean Tf() {
        return true;
    }
}
