package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.mm.plugin.appbrand.dynamic.core.a;
import com.tencent.mm.plugin.appbrand.dynamic.core.b;
import com.tencent.mm.plugin.appbrand.dynamic.core.e;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends a {
    public g() {
        super(bs.NAME, 281);
    }

    protected final void b(e eVar, JSONObject jSONObject, b.a aVar) {
        if (com.tencent.mm.plugin.appbrand.dynamic.core.g.oC(eVar.RT().getString("__page_view_id", null)) == null) {
            aVar.f(a(false, "JsApi Framework Context is null", null));
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            aVar.f(a(false, "dataArray is null", null));
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                int optInt = jSONObject2.optInt("key");
                String optString = jSONObject2.optString(Columns.VALUE);
                if (optInt > 0 && !bg.mA(optString)) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(optInt, new Object[]{r3.getAppId(), Integer.valueOf(r3.RX()), Integer.valueOf(com.tencent.mm.plugin.appbrand.dynamic.j.a.hF(r3.RW()) + 1), optString});
                }
            } catch (Exception e) {
                w.e("MicroMsg.JsApiFunc_ReportKeyValue", "parse report value failed : %s", new Object[]{e});
            }
        }
        aVar.f(a(true, "", null));
    }
}
