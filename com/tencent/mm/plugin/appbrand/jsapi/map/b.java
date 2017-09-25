package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Color;
import android.view.View;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends c {
    public static final int CTRL_INDEX = 135;
    public static final String NAME = "addMapCircles";

    protected final int h(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            w.e("MicroMsg.JsApiAddMapCircles", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final boolean a(m mVar, int i, View view, JSONObject jSONObject) {
        com.tencent.mm.u.q.b B = mVar.jdc.B(i, true);
        if (B == null) {
            w.i("MicroMsg.JsApiAddMapCircles", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        }
        try {
            SoSoMapView soSoMapView = (SoSoMapView) view.findViewById(R.h.bSq);
            try {
                if (jSONObject.has("circles")) {
                    List list;
                    int i2;
                    List list2 = (List) B.fS("map_circle");
                    if (list2 == null) {
                        ArrayList arrayList = new ArrayList();
                        B.l("map_circle", arrayList);
                        list = arrayList;
                    } else {
                        list = list2;
                    }
                    if (list.size() > 0) {
                        for (i2 = 0; i2 < list.size(); i2++) {
                            ((Circle) list.get(i2)).remove();
                        }
                        list.clear();
                    }
                    JSONArray jSONArray = new JSONArray(jSONObject.optString("circles"));
                    for (i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                        float f = bg.getFloat(jSONObject2.optString("latitude"), 0.0f);
                        float f2 = bg.getFloat(jSONObject2.optString("longitude"), 0.0f);
                        int at = h.at(jSONObject2.optString("color", ""), Color.parseColor("#000000"));
                        int at2 = h.at(jSONObject2.optString("fillColor", ""), Color.parseColor("#000000"));
                        int optInt = jSONObject2.optInt("radius");
                        int a = h.a(jSONObject2, "strokeWidth", 0);
                        CircleOptions circleOptions = new CircleOptions();
                        circleOptions.center(new LatLng((double) f, (double) f2));
                        circleOptions.radius((double) optInt);
                        circleOptions.strokeColor(at);
                        circleOptions.strokeWidth((float) a);
                        circleOptions.fillColor(at2);
                        list.add(soSoMapView.addCircle(circleOptions));
                    }
                }
                return true;
            } catch (Exception e) {
                w.e("MicroMsg.JsApiAddMapCircles", "parse circles error, exception : %s", new Object[]{e});
                return false;
            }
        } catch (Exception e2) {
            w.e("MicroMsg.JsApiAddMapCircles", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e2});
            return false;
        }
    }
}
