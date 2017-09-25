package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.dynamic.core.a;
import com.tencent.mm.plugin.appbrand.dynamic.core.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.recovery.util.Util;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends a {
    public e() {
        super("log", 287);
    }

    protected final void b(com.tencent.mm.plugin.appbrand.dynamic.core.e eVar, JSONObject jSONObject, b.a aVar) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("dataArray");
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    LogInfo logInfo = new LogInfo();
                    logInfo.hpU = jSONObject2.optLong("ts");
                    logInfo.level = jSONObject2.optInt("level") + 1;
                    logInfo.message = jSONObject2.optString("msg");
                    arrayList.add(logInfo);
                    w.d("MicroMsg.JsApiFunc_Log", "ts : %s, level : %d, msg : %s", new Object[]{Util.eY(logInfo.hpU), Integer.valueOf(logInfo.level), logInfo.message});
                }
            }
            com.tencent.mm.plugin.appbrand.dynamic.debugger.a.a(eVar.RT().getString("__page_view_id", null), arrayList);
            aVar.f(a(true, "", null));
        } catch (JSONException e) {
            aVar.f(a(false, "dataArray is null", null));
        }
    }
}
