package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.SparseArray;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.jsapi.l.b;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONArray;
import org.json.JSONObject;

final class cp extends a {
    public static final int CTRL_INDEX = 215;
    public static final String NAME = "updatePerfData";
    private static final SparseArray<Integer> iQk = new SparseArray();

    cp() {
        iQk.put("firstRenderTime".hashCode(), Integer.valueOf(b.CTRL_INDEX));
        iQk.put("reRenderTime".hashCode(), Integer.valueOf(302));
        iQk.put("webview2AppServiceTotalTime".hashCode(), Integer.valueOf(402));
        iQk.put("webview2AppServiceDataSize".hashCode(), Integer.valueOf(403));
        iQk.put("webview2AppServiceNativeTime".hashCode(), Integer.valueOf(TencentLocation.ERROR_UNKNOWN));
        iQk.put("appService2WebviewTotalTime".hashCode(), Integer.valueOf(405));
        iQk.put("appService2WebviewDataSize".hashCode(), Integer.valueOf(406));
        iQk.put("appService2WebviewNativeTime".hashCode(), Integer.valueOf(407));
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (!AppBrandPerformanceManager.qB(cVar.getAppId()) || optJSONArray == null) {
            cVar.x(i, d("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("key");
                String optString2 = optJSONObject.optString(Columns.VALUE);
                if (!bg.mA(optString)) {
                    Integer num = (Integer) iQk.get(optString.hashCode());
                    if (num != null) {
                        AppBrandPerformanceManager.g(cVar.getAppId(), num.intValue(), optString2);
                    } else {
                        AppBrandPerformanceManager.z(cVar.getAppId(), optString, optString2);
                    }
                }
            }
        }
        cVar.x(i, d("ok", null));
    }
}
