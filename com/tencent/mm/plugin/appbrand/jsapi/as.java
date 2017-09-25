package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.View;
import com.tencent.mm.plugin.appbrand.canvas.widget.AppBrandDrawableView;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import org.json.JSONObject;

public final class as extends a {
    public static final int CTRL_INDEX = 67;
    public static final String NAME = "insertCanvas";

    protected final View a(m mVar, JSONObject jSONObject) {
        View appBrandDrawableView = new AppBrandDrawableView(mVar.mContext);
        appBrandDrawableView.nU(mVar.ivH);
        return appBrandDrawableView;
    }

    protected final int h(JSONObject jSONObject) {
        return jSONObject.getInt("canvasId");
    }

    protected final boolean Tf() {
        return true;
    }

    protected final boolean Tg() {
        return true;
    }
}
