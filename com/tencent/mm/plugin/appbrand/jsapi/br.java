package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONArray;
import org.json.JSONObject;

public final class br extends a {
    private static final int CTRL_INDEX = 64;
    private static final String NAME = "reportIDKey";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                g.oUh.a((long) jSONObject2.optInt(SlookAirButtonFrequentContactAdapter.ID), (long) jSONObject2.optInt("key"), (long) jSONObject2.optInt(Columns.VALUE), false);
            } catch (Exception e) {
                w.e("MicroMsg.JsApiReportIDKey", "parse json failed : %s", new Object[]{e.getMessage()});
            }
        }
        mVar.x(i, d("ok", null));
    }

    public final void a(com.tencent.mm.plugin.appbrand.g.m mVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                g.oUh.a((long) jSONObject2.optInt(SlookAirButtonFrequentContactAdapter.ID), (long) jSONObject2.optInt("key"), (long) jSONObject2.optInt(Columns.VALUE), false);
            } catch (Exception e) {
                w.e("MicroMsg.JsApiReportIDKey", "parse json failed : %s", new Object[]{e.getMessage()});
            }
        }
        mVar.x(i, d("ok", null));
    }
}
