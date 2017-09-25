package com.tencent.mm.plugin.appbrand.canvas.c;

import android.graphics.Path;
import android.graphics.Path.Direction;
import com.tencent.mm.plugin.appbrand.m.h;
import org.json.JSONArray;

public final class i implements a {
    public final String getMethod() {
        return "rect";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        float c = h.c(jSONArray, 0);
        float c2 = h.c(jSONArray, 1);
        Path path2 = path;
        path2.addRect(c, c2, c + h.c(jSONArray, 2), h.c(jSONArray, 3) + c2, Direction.CW);
        return true;
    }
}
