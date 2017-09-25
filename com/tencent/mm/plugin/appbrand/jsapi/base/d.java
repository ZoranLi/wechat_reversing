package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m.h;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d extends a {
    public int h(JSONObject jSONObject) {
        throw new JSONException("viewId do not exist, override the method getViewId(data).");
    }

    protected static int[] i(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("position"));
            int a = h.a(jSONObject2, "left", 0);
            int a2 = h.a(jSONObject2, "top", 0);
            int a3 = h.a(jSONObject2, "width", 0);
            int a4 = h.a(jSONObject2, "height", 0);
            int optInt = jSONObject.optInt("zIndex", 0);
            return new int[]{a, a2, a3, a4, optInt};
        } catch (Exception e) {
            return null;
        }
    }

    protected static int j(JSONObject jSONObject) {
        int i = -1;
        try {
            return jSONObject.getBoolean("hide") ? 8 : 0;
        } catch (JSONException e) {
            return i;
        }
    }
}
