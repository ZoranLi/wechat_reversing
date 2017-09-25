package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class v implements c {
    public final String getMethod() {
        return "setMiterLimit";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        float optDouble = (float) jSONArray.optDouble(0);
        dVar.iDe.setStrokeMiter(optDouble);
        dVar.iDd.setStrokeMiter(optDouble);
        return true;
    }
}
