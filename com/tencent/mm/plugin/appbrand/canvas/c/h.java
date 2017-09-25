package com.tencent.mm.plugin.appbrand.canvas.c;

import android.graphics.Path;
import org.json.JSONArray;

public final class h implements a {
    public final String getMethod() {
        return "quadraticCurveTo";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        path.quadTo(com.tencent.mm.plugin.appbrand.m.h.c(jSONArray, 0), com.tencent.mm.plugin.appbrand.m.h.c(jSONArray, 1), com.tencent.mm.plugin.appbrand.m.h.c(jSONArray, 2), com.tencent.mm.plugin.appbrand.m.h.c(jSONArray, 3));
        return true;
    }
}
