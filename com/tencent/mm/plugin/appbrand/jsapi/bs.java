package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bs extends a {
    public static final int CTRL_INDEX = 63;
    public static final String NAME = "reportKeyValue";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        if (b.mY(mVar.ivH) == null) {
            w.e("MicroMsg.JsApiReportKeyValue", "config is Null!");
            mVar.x(i, d("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("key");
                String optString = jSONObject2.optString(Columns.VALUE);
                if (optInt > 0 && !bg.mA(optString)) {
                    g.oUh.i(optInt, new Object[]{mVar.ivH, Integer.valueOf(r4.iFk.izW), Integer.valueOf(r4.iFk.izV + 1), optString});
                }
            } catch (Exception e) {
                w.e("MicroMsg.JsApiReportKeyValue", "AppBrandService parse report value failed : %s", new Object[]{e.getMessage()});
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
        if (b.mY(mVar.ivH) == null) {
            w.e("MicroMsg.JsApiReportKeyValue", "config is Null!");
            mVar.x(i, d("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("key");
                String optString = jSONObject2.optString(Columns.VALUE);
                if (optInt > 0 && !bg.mA(optString)) {
                    g.oUh.i(optInt, new Object[]{mVar.ivH, Integer.valueOf(r4.iFk.izW), Integer.valueOf(r4.iFk.izV + 1), optString});
                }
            } catch (Exception e) {
                w.e("MicroMsg.JsApiReportKeyValue", "AppBrandPageView parse report value failed : %s", new Object[]{e.getMessage()});
            }
        }
        mVar.x(i, d("ok", null));
    }
}
