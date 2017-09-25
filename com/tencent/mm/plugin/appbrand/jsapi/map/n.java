package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g.l;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q.b;
import com.tencent.tencentmap.mapsdk.map.g;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n extends c {
    public static final int CTRL_INDEX = 4;
    public static final String NAME = "updateMap";

    protected final int h(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            w.e("MicroMsg.JsApiUpdateMap", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final boolean a(m mVar, int i, View view, JSONObject jSONObject) {
        b B = mVar.jdc.B(i, true);
        if (B == null) {
            w.i("MicroMsg.JsApiUpdateMap", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        }
        try {
            SoSoMapView soSoMapView = (SoSoMapView) view.findViewById(R.h.bSq);
            if (jSONObject.has("scale")) {
                int optInt = jSONObject.optInt("scale", 16);
                g map = soSoMapView.getMap();
                if (map != null) {
                    map.a(com.tencent.tencentmap.mapsdk.map.b.az((float) optInt));
                }
            }
            try {
                float optDouble;
                if (jSONObject.has("covers")) {
                    List list;
                    int i2;
                    List list2 = (List) B.fS("converters");
                    if (list2 == null) {
                        ArrayList arrayList = new ArrayList();
                        B.l("converters", arrayList);
                        list = arrayList;
                    } else {
                        list = list2;
                    }
                    if (list.size() > 0) {
                        for (i2 = 0; i2 < list.size(); i2++) {
                            ((Marker) list.get(i2)).remove();
                        }
                        list.clear();
                    }
                    JSONArray jSONArray = new JSONArray(jSONObject.optString("covers"));
                    for (i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                        float f = bg.getFloat(jSONObject2.optString("latitude"), 0.0f);
                        float f2 = bg.getFloat(jSONObject2.optString("longitude"), 0.0f);
                        String optString = jSONObject2.optString("iconPath");
                        optDouble = (float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(new LatLng((double) f, (double) f2));
                        Bitmap g = l.g(mVar.ixr, optString);
                        if (!(g == null || g.isRecycled())) {
                            markerOptions.icon(new BitmapDescriptor(g));
                        }
                        markerOptions.rotation(optDouble);
                        Marker addMarker = soSoMapView.addMarker(markerOptions);
                        addMarker.setTag("cover");
                        list.add(addMarker);
                    }
                }
                if (jSONObject.has("centerLatitude")) {
                    if (jSONObject.has("centerLongitude")) {
                        optDouble = bg.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
                        float f3 = bg.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
                        if (Math.abs(optDouble) <= 90.0f && Math.abs(f3) <= 180.0f) {
                            soSoMapView.getIController().setCenter((double) optDouble, (double) f3);
                        }
                    }
                }
                return true;
            } catch (Exception e) {
                w.e("MicroMsg.JsApiUpdateMap", "parse covers error, exception : %s", new Object[]{e});
                return false;
            }
        } catch (Exception e2) {
            w.e("MicroMsg.JsApiUpdateMap", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e2});
            return false;
        }
    }
}
