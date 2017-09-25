package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import org.json.JSONObject;

public final class d extends b {
    public static final int CTRL_INDEX = 299;
    public static final String NAME = "removeHTMLWebView";

    protected final int h(JSONObject jSONObject) {
        return jSONObject.getInt("htmlId");
    }
}
