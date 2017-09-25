package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.k.a;
import com.tencent.mm.plugin.appbrand.jsapi.k.d;
import org.json.JSONObject;

public final class co extends c {
    private static final int CTRL_INDEX = 254;
    public static final String NAME = "updateImageView";

    protected final int h(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final boolean a(m mVar, int i, View view, JSONObject jSONObject) {
        d.a(view, jSONObject.optJSONObject("style"));
        a.a(mVar, (ImageView) view, jSONObject);
        return super.a(mVar, i, view, jSONObject);
    }
}
