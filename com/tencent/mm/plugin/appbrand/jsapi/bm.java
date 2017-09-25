package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.View;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import org.json.JSONObject;

public final class bm extends b {
    private static final int CTRL_INDEX = 255;
    public static final String NAME = "removeImageView";

    protected final int h(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final boolean c(m mVar, int i, View view, JSONObject jSONObject) {
        mVar.jdc.im(i);
        return super.c(mVar, i, view, jSONObject);
    }
}
