package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.tencent.mm.plugin.appbrand.m.h;
import org.json.JSONArray;

public final class d implements c {
    public final String getMethod() {
        return "arc";
    }

    public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 5) {
            return false;
        }
        float c = h.c(jSONArray, 0);
        float c2 = h.c(jSONArray, 1);
        float c3 = h.c(jSONArray, 2);
        Canvas canvas2 = canvas;
        canvas2.drawArc(new RectF(c - c3, c2 - c3, c + c3, c3 + c2), (float) ((((double) ((float) jSONArray.optDouble(3))) / 3.141592653589793d) * 180.0d), (float) ((((double) ((float) jSONArray.optDouble(4))) / 3.141592653589793d) * 180.0d), true, dVar.iDd);
        return true;
    }
}
