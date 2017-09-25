package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.m.h;
import org.json.JSONArray;

public final class g implements c {
    public final String getMethod() {
        return "strokeRect";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        float c = h.c(jSONArray, 0);
        float c2 = h.c(jSONArray, 1);
        Canvas canvas2 = canvas;
        canvas2.drawRect(c, c2, c + h.c(jSONArray, 2), h.c(jSONArray, 3) + c2, dVar.iDd);
        return true;
    }
}
