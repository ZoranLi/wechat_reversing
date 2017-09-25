package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.dynamic.core.a;
import com.tencent.mm.plugin.appbrand.dynamic.core.b;
import com.tencent.mm.plugin.appbrand.dynamic.core.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f extends a {
    public f() {
        super("reportIDKey", 282);
    }

    protected final void b(e eVar, JSONObject jSONObject, b.a aVar) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            aVar.f(a(false, "dataArray is null", null));
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                g.oUh.a((long) jSONObject2.optInt(SlookAirButtonFrequentContactAdapter.ID), (long) jSONObject2.optInt("key"), (long) jSONObject2.optInt(Columns.VALUE), false);
            } catch (Exception e) {
                w.e("MicroMsg.JsApiFunc_ReportIDKey", "parse json failed : %s", new Object[]{e.getMessage()});
            }
        }
        aVar.f(a(true, "", null));
    }
}
