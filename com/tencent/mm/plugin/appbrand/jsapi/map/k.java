package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q.b;
import org.json.JSONObject;

public final class k extends c {
    public static final int CTRL_INDEX = 141;
    public static final String NAME = "moveToMapLocation";

    protected final int h(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            w.e("MicroMsg.JsApiMoveToMapLocation", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final boolean a(m mVar, int i, View view, JSONObject jSONObject) {
        b B = mVar.jdc.B(i, true);
        if (B == null) {
            w.i("MicroMsg.JsApiMoveToMapLocation", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        }
        try {
            SoSoMapView soSoMapView = (SoSoMapView) view.findViewById(R.h.bSq);
            AppbrandMapLocationPoint appbrandMapLocationPoint = (AppbrandMapLocationPoint) B.fS(String.valueOf(i));
            if (appbrandMapLocationPoint != null) {
                soSoMapView.getIController().animateTo(appbrandMapLocationPoint.iSP, appbrandMapLocationPoint.iSQ);
                return true;
            }
            w.e("MicroMsg.JsApiMoveToMapLocation", "appbrandMapLocationPoint is null");
            return false;
        } catch (Exception e) {
            w.e("MicroMsg.JsApiMoveToMapLocation", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e});
            return false;
        }
    }
}
