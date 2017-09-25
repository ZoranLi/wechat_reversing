package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.performance.a;
import com.tencent.mm.sdk.platformtools.bg;
import org.json.JSONArray;
import org.json.JSONObject;

final class cm extends a {
    public static final int CTRL_INDEX = 283;
    public static final String NAME = "traceEvent";

    cm() {
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("events");
        if (!AppBrandPerformanceManager.qB(cVar.getAppId()) || optJSONArray == null) {
            cVar.x(i, d("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("category");
                String optString2 = optJSONObject.optString("name");
                long optLong = optJSONObject.optLong("start");
                long optLong2 = optJSONObject.optLong("end");
                String optString3 = optJSONObject.optString("phase");
                String optString4 = optJSONObject.optString("args");
                if (!bg.mA(optString2)) {
                    a.a(cVar.getAppId(), optString, optString2, optString3, optLong, optLong2, optString4);
                }
            }
        }
        cVar.x(i, d("ok", null));
    }
}
