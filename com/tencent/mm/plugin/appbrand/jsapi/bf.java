package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.platformtools.bg;
import org.json.JSONObject;

public final class bf extends a {
    public static final int CTRL_INDEX = 38;
    public static final String NAME = "openLocation";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        int i2 = 0;
        try {
            float f = bg.getFloat(jSONObject.optString("latitude"), 0.0f);
            float f2 = bg.getFloat(jSONObject.optString("longitude"), 0.0f);
            String qU = d.qU(jSONObject.optString("name"));
            String qU2 = d.qU(jSONObject.optString("address"));
            try {
                i2 = bg.getInt(jSONObject.optString("scale"), 0);
            } catch (Exception e) {
            }
            Intent intent = new Intent();
            intent.putExtra("map_view_type", 7);
            intent.putExtra("kwebmap_slat", (double) f);
            intent.putExtra("kwebmap_lng", (double) f2);
            if (i2 > 0) {
                intent.putExtra("kwebmap_scale", i2);
            }
            intent.putExtra("kPoiName", qU);
            intent.putExtra("Kwebmap_locaion", qU2);
            Context a = a(mVar);
            if (a == null) {
                mVar.x(i, d("fail", null));
                return;
            }
            com.tencent.mm.bb.d.b(a, "location", ".ui.RedirectUI", intent);
            mVar.x(i, d("ok", null));
        } catch (Exception e2) {
            mVar.x(i, d("invalid_coordinate", null));
        }
    }
}
