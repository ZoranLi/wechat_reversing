package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Color;
import android.view.View;
import com.tencent.mapsdk.raster.model.BitmapDescriptorFactory;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends c {
    public static final int CTRL_INDEX = 134;
    public static final String NAME = "addMapLines";

    protected final int h(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            w.e("MicroMsg.JsApiAddMapLines", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final boolean a(m mVar, int i, View view, JSONObject jSONObject) {
        b B = mVar.jdc.B(i, true);
        if (B == null) {
            w.e("MicroMsg.JsApiAddMapLines", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        }
        try {
            SoSoMapView soSoMapView = (SoSoMapView) view.findViewById(R.h.bSq);
            if (jSONObject == null) {
                w.e("MicroMsg.JsApiAddMapLines", "data is null");
                return false;
            }
            w.d("MicroMsg.JsApiAddMapLines", "onUpdateView, data:%s", new Object[]{jSONObject.toString()});
            try {
                if (jSONObject.has("lines")) {
                    List list;
                    int i2;
                    List list2 = (List) B.fS("map_line");
                    if (list2 == null) {
                        ArrayList arrayList = new ArrayList();
                        B.l("map_line", arrayList);
                        list = arrayList;
                    } else {
                        list = list2;
                    }
                    if (list.size() > 0) {
                        for (i2 = 0; i2 < list.size(); i2++) {
                            ((Polyline) list.get(i2)).remove();
                        }
                        list.clear();
                    }
                    JSONArray jSONArray = new JSONArray(jSONObject.optString("lines"));
                    for (i2 = 0; i2 < jSONArray.length(); i2++) {
                        int i3;
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                        Iterable arrayList2 = new ArrayList();
                        JSONArray jSONArray2 = new JSONArray(jSONObject2.optString("points"));
                        for (i3 = 0; i3 < jSONArray2.length(); i3++) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                            arrayList2.add(new LatLng((double) bg.getFloat(jSONObject3.optString("latitude"), 0.0f), (double) bg.getFloat(jSONObject3.optString("longitude"), 0.0f)));
                        }
                        i3 = h.at(jSONObject2.optString("color", ""), Color.parseColor("#000000"));
                        int a = h.a(jSONObject2, "width", 0);
                        boolean optBoolean = jSONObject2.optBoolean("dottedLine", false);
                        int at = h.at(jSONObject2.optString("borderColor", ""), Color.parseColor("#000000"));
                        int a2 = h.a(jSONObject2, "borderWidth", 0);
                        boolean optBoolean2 = jSONObject2.optBoolean("arrowLine", false);
                        PolylineOptions polylineOptions = new PolylineOptions();
                        polylineOptions.addAll(arrayList2);
                        polylineOptions.color(i3);
                        polylineOptions.width((float) a);
                        polylineOptions.setDottedLine(optBoolean);
                        polylineOptions.edgeColor(at);
                        polylineOptions.edgeWidth((float) a2);
                        if (optBoolean2) {
                            polylineOptions.arrowTexture(BitmapDescriptorFactory.fromAsset("app_brand_map_line_texture_arrow.png"));
                        }
                        list.add(soSoMapView.addPolyline(polylineOptions));
                    }
                } else {
                    w.e("MicroMsg.JsApiAddMapLines", "data has not lines info");
                }
                return true;
            } catch (Exception e) {
                w.e("MicroMsg.JsApiAddMapLines", "parse lines error, exception : %s", new Object[]{e});
                return false;
            }
        } catch (Exception e2) {
            w.e("MicroMsg.JsApiAddMapLines", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e2});
            return false;
        }
    }
}
