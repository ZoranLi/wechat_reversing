package com.tencent.mm.plugin.appbrand.jsapi.map;

import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getMapScale";

    private static int h(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            w.e("MicroMsg.JsApiGetMapScale", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiGetMapScale", "JsApiGetMapScale data is null");
            mVar.x(i, d("fail:data is null", null));
            return;
        }
        com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
        if (b == null) {
            w.e("MicroMsg.JsApiGetMapScale", "JsApiGetMapScale pv is null");
            mVar.x(i, d("fail:pageView is null", null));
            return;
        }
        w.i("MicroMsg.JsApiGetMapScale", "JsApiGetMapScale data:%s", new Object[]{jSONObject.toString()});
        try {
            SoSoMapView soSoMapView = (SoSoMapView) b.jdc.il(h(jSONObject)).findViewById(R.h.bSq);
            Map hashMap = new HashMap();
            if (soSoMapView != null) {
                hashMap.put("scale", Integer.valueOf(soSoMapView.getMap().getZoomLevel()));
                w.i("MicroMsg.JsApiGetMapScale", "getMapScale ok, values:%s", new Object[]{hashMap.toString()});
                mVar.x(i, d("ok", hashMap));
                return;
            }
            w.e("MicroMsg.JsApiGetMapScale", "get SoSoMapView by id failed");
            mVar.x(i, d("fail:mapView is null", null));
        } catch (Exception e) {
            w.e("MicroMsg.JsApiGetMapScale", "get SoSoMapView by id failed, exception : %s", new Object[]{e});
            mVar.x(i, d("fail", null));
        }
    }
}
