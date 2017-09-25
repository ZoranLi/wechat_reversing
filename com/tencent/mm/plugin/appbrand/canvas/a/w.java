package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.m.h;
import org.json.JSONArray;

public final class w implements c {
    public final String getMethod() {
        return "setShadow";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        int a = h.a(jSONArray, 0);
        int a2 = h.a(jSONArray, 1);
        int a3 = h.a(jSONArray, 2);
        JSONArray optJSONArray = jSONArray.optJSONArray(3);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            return false;
        }
        int j = h.j(optJSONArray);
        dVar.iDe.setShadowLayer((float) a3, (float) a, (float) a2, j);
        dVar.iDd.setShadowLayer((float) a3, (float) a, (float) a2, j);
        return true;
    }
}
