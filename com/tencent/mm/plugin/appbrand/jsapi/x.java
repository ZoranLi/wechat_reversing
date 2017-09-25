package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.View;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONArray;
import org.json.JSONObject;

public class x extends c {
    public static final int CTRL_INDEX = 69;
    public static final String NAME = "drawCanvas";

    protected final int h(JSONObject jSONObject) {
        return jSONObject.getInt("canvasId");
    }

    protected final boolean a(m mVar, int i, View view, JSONObject jSONObject) {
        w.d("MicroMsg.JsApiDrawCanvas", "drawCanvas(id : %s)", new Object[]{Integer.valueOf(i)});
        if (view instanceof a) {
            long currentTimeMillis = System.currentTimeMillis();
            JSONArray optJSONArray = jSONObject.optJSONArray("actions");
            a aVar = (a) view;
            if (jSONObject.optBoolean("reserve")) {
                aVar.e(optJSONArray);
            } else {
                aVar.d(optJSONArray);
            }
            aVar.Rp();
            w.v("MicroMsg.JsApiDrawCanvas", "post drawCanvas cost : %sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            return super.a(mVar, i, view, jSONObject);
        }
        w.i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of AppBrandDrawableView.(%s)", new Object[]{Integer.valueOf(i)});
        return false;
    }
}
