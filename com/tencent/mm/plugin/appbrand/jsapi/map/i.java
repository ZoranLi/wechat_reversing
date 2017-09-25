package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.view.View;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tencentmap.mapsdk.map.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i extends c {
    public static final int CTRL_INDEX = 136;
    public static final String NAME = "includeMapPoints";

    protected final int h(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            w.e("MicroMsg.JsApiIncludeMapPoints", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final boolean a(m mVar, int i, View view, JSONObject jSONObject) {
        if (mVar.jdc.B(i, true) == null) {
            w.i("MicroMsg.JsApiIncludeMapPoints", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        }
        try {
            SoSoMapView soSoMapView = (SoSoMapView) view.findViewById(R.h.bSq);
            w.i("MicroMsg.JsApiIncludeMapPoints", "includeMapPoints, onUpdateView()");
            try {
                if (jSONObject.has("points")) {
                    Iterable arrayList = new ArrayList();
                    String optString = jSONObject.optString("points");
                    if (!bg.mA(optString)) {
                        JSONArray jSONArray = new JSONArray(optString);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                            arrayList.add(new LatLng((double) bg.getFloat(jSONObject2.optString("latitude"), 0.0f), (double) bg.getFloat(jSONObject2.optString("longitude"), 0.0f)));
                        }
                    }
                    int i3 = 0;
                    String optString2 = jSONObject.optString("padding");
                    if (!bg.mA(optString2)) {
                        i3 = h.iD(new JSONArray(optString2).optInt(0));
                    }
                    if (arrayList.size() > 0) {
                        Builder builder = new Builder();
                        builder.include(arrayList);
                        soSoMapView.getMap().a(b.a(builder.build(), i3));
                    }
                }
                return true;
            } catch (Exception e) {
                w.e("MicroMsg.JsApiIncludeMapPoints", "parse points error, exception : %s", new Object[]{e});
                return false;
            }
        } catch (Exception e2) {
            w.e("MicroMsg.JsApiIncludeMapPoints", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e2});
            return false;
        }
    }
}
