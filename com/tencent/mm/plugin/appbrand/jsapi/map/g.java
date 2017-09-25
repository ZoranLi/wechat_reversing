package com.tencent.mm.plugin.appbrand.jsapi.map;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tencentmap.mapsdk.map.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getMapRegion";

    private static int h(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            w.e("MicroMsg.JsApiGetMapRegion", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiGetMapRegion", "JsApiGetMapRegion data is null");
            mVar.x(i, d("fail:data is null", null));
            return;
        }
        com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
        if (b == null) {
            w.e("MicroMsg.JsApiGetMapRegion", "JsApiGetMapRegion pv is null");
            mVar.x(i, d("fail:pageView is null", null));
            return;
        }
        w.i("MicroMsg.JsApiGetMapRegion", "JsApiGetMapRegion data:%s", new Object[]{jSONObject.toString()});
        try {
            SoSoMapView soSoMapView = (SoSoMapView) b.jdc.il(h(jSONObject)).findViewById(R.h.bSq);
            if (soSoMapView == null) {
                w.e("MicroMsg.JsApiGetMapRegion", "get SoSoMapView by id failed");
                mVar.x(i, d("fail:mapView is null", null));
                return;
            }
            f projection = soSoMapView.getProjection();
            if (projection == null) {
                w.e("MicroMsg.JsApiGetMapRegion", "projection is  null");
                mVar.x(i, d("fail:projection is null", null));
                return;
            }
            LatLngBounds latLngBounds = projection.cgd().getLatLngBounds();
            if (latLngBounds == null) {
                w.e("MicroMsg.JsApiGetMapRegion", "latLngBounds is  null");
                mVar.x(i, d("fail:latLngBounds is null", null));
                return;
            }
            LatLng southwest = latLngBounds.getSouthwest();
            LatLng northeast = latLngBounds.getNortheast();
            Map hashMap = new HashMap();
            if (southwest != null) {
                hashMap.put("latitude", Double.valueOf(southwest.getLatitude()));
                hashMap.put("longitude", Double.valueOf(southwest.getLongitude()));
            }
            Map hashMap2 = new HashMap();
            if (northeast != null) {
                hashMap2.put("latitude", Double.valueOf(northeast.getLatitude()));
                hashMap2.put("longitude", Double.valueOf(northeast.getLongitude()));
            }
            Map hashMap3 = new HashMap();
            hashMap3.put("southwest", hashMap);
            hashMap3.put("northeast", hashMap2);
            w.i("MicroMsg.JsApiGetMapRegion", "getMapRegion ok, values:%s", new Object[]{hashMap3.toString()});
            mVar.x(i, d("ok", hashMap3));
        } catch (Exception e) {
            w.e("MicroMsg.JsApiGetMapRegion", "get SoSoMapView by id failed, exception : %s", new Object[]{e});
            mVar.x(i, d("fail", null));
        }
    }
}
