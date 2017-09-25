package com.tencent.mm.plugin.appbrand.jsapi.map;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 144;
    public static final String NAME = "getMapCenterLocation";

    private static int h(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            w.e("MicroMsg.JsApiGetMapCenterLocation", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiGetMapCenterLocation", "getMapCenterLocation data is null");
            mVar.x(i, d("fail:data is null", null));
            return;
        }
        com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
        if (b == null) {
            w.e("MicroMsg.JsApiGetMapCenterLocation", "getMapCenterLocation pv is null");
            return;
        }
        w.i("MicroMsg.JsApiGetMapCenterLocation", "getMapCenterLocation data:%s", new Object[]{jSONObject.toString()});
        try {
            SoSoMapView soSoMapView = (SoSoMapView) b.jdc.il(h(jSONObject)).findViewById(R.h.bSq);
            Map hashMap = new HashMap();
            if (soSoMapView != null) {
                LatLng mapCenter = soSoMapView.getMap().getMapCenter();
                hashMap.put("latitude", Double.valueOf(mapCenter.getLatitude()));
                hashMap.put("longitude", Double.valueOf(mapCenter.getLongitude()));
                w.i("MicroMsg.JsApiGetMapCenterLocation", "ok, values:%s", new Object[]{hashMap.toString()});
                mVar.x(i, d("ok", hashMap));
                return;
            }
            w.e("MicroMsg.JsApiGetMapCenterLocation", "get SoSoMapView by id failed");
            mVar.x(i, d("fail", null));
        } catch (Exception e) {
            w.e("MicroMsg.JsApiGetMapCenterLocation", "get SoSoMapView by id failed, exception : %s", new Object[]{e});
            mVar.x(i, d("fail", null));
        }
    }
}
