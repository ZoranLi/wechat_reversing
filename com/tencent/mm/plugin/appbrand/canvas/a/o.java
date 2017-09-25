package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class o implements c {
    public final String getMethod() {
        return "scale";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 2) {
            return false;
        }
        canvas.scale((float) jSONArray.optDouble(0), (float) jSONArray.optDouble(1));
        return true;
    }
}
