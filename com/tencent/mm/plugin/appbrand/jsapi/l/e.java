package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.view.View;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class e extends c {
    public static final int CTRL_INDEX = 300;
    public static final String NAME = "updateHTMLWebView";

    protected final boolean a(m mVar, int i, View view, JSONObject jSONObject) {
        if (!(view instanceof a)) {
            return false;
        }
        String optString = jSONObject.optString("src", "about:blank");
        w.i("URL", optString);
        ((a) view).iYA.loadUrl(optString);
        return true;
    }

    protected final int h(JSONObject jSONObject) {
        return jSONObject.getInt("htmlId");
    }
}
