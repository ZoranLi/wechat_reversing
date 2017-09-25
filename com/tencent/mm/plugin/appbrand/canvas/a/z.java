package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.b.a.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONArray;

public final class z implements c {
    public final String getMethod() {
        return "setTextBaseline";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        String optString = jSONArray.optString(0);
        w.i("MicroMsg.SetTextBaselineAction", "SetTextBaselineAction, align:%s", new Object[]{optString});
        if ("top".equalsIgnoreCase(optString)) {
            dVar.iDd.iDj = a.iDm;
            dVar.iDe.iDj = a.iDm;
        } else if ("middle".equalsIgnoreCase(optString)) {
            dVar.iDd.iDj = a.iDo;
            dVar.iDe.iDj = a.iDo;
        } else if ("bottom".equalsIgnoreCase(optString)) {
            dVar.iDd.iDj = a.iDn;
            dVar.iDe.iDj = a.iDn;
        } else if ("normal".equalsIgnoreCase(optString)) {
            dVar.iDd.iDj = a.iDl;
            dVar.iDe.iDj = a.iDl;
        }
        return true;
    }
}
