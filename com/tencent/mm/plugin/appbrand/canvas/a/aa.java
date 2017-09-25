package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.m.h;
import org.json.JSONArray;

public final class aa implements c {
    public final String getMethod() {
        return "translate";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 2) {
            return false;
        }
        canvas.translate(h.c(jSONArray, 0), h.c(jSONArray, 1));
        return true;
    }
}
