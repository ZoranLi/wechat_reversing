package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.m.h;
import org.json.JSONArray;

public final class u implements c {
    public final String getMethod() {
        return "setLineWidth";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        float c = h.c(jSONArray, 0);
        dVar.iDe.setStrokeWidth(c);
        dVar.iDd.setStrokeWidth(c);
        return true;
    }
}
