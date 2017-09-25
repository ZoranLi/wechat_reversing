package com.tencent.mm.plugin.appbrand.canvas.c;

import android.graphics.Path;
import com.tencent.mm.plugin.appbrand.m.h;
import org.json.JSONArray;

public final class f implements a {
    public final String getMethod() {
        return "lineTo";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 2) {
            return false;
        }
        path.lineTo(h.c(jSONArray, 0), h.c(jSONArray, 1));
        return true;
    }
}
