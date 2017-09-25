package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.view.View;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.m.h;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends c {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "updateContainer";

    protected final boolean a(m mVar, int i, View view, JSONObject jSONObject) {
        if (!(view instanceof a)) {
            return false;
        }
        int a = h.a(jSONObject, "contentOffsetLeft", 0);
        int a2 = h.a(jSONObject, "contentOffsetTop", 0);
        a aVar = (a) view;
        try {
            aVar.setVisibility(jSONObject.getBoolean("visible") ? 0 : 4);
        } catch (JSONException e) {
        }
        aVar.setPadding(-a, -a2, 0, 0);
        return true;
    }

    protected final int h(JSONObject jSONObject) {
        return jSONObject.getInt("containerId");
    }
}
