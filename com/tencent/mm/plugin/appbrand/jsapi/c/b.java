package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 223;
    private static final String NAME = "getBeacons";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.d("MicroMsg.JsApiGetBeacons", "getBeacons!");
        Map TD = a.TD();
        JSONArray jSONArray = new JSONArray();
        Map hashMap = new HashMap(1);
        if (TD == null || TD.size() <= 0) {
            w.e("MicroMsg.JsApiGetBeacons", "not found device");
            hashMap.put("beacons", jSONArray);
            mVar.x(i, d("ok", hashMap));
            return;
        }
        for (Entry value : TD.entrySet()) {
            jSONArray.put((JSONObject) value.getValue());
        }
        hashMap.put("beacons", jSONArray);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("errMsg", getName() + ":ok");
            jSONObject2.put("beacons", jSONArray);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.JsApiGetBeacons", e, "put error", new Object[0]);
        }
        mVar.x(i, d("ok", hashMap));
    }
}
