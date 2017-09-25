package com.tencent.mm.plugin.appbrand.canvas.c;

import android.graphics.Path;
import com.tencent.mm.plugin.appbrand.m.h;
import org.json.JSONArray;

public final class c implements a {
    public final String getMethod() {
        return "bezierCurveTo";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 6) {
            return false;
        }
        path.cubicTo(h.c(jSONArray, 0), h.c(jSONArray, 1), h.c(jSONArray, 2), h.c(jSONArray, 3), h.c(jSONArray, 4), h.c(jSONArray, 5));
        return true;
    }
}
