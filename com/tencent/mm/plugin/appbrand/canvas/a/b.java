package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class b implements c {
    public final String getMethod() {
        return "clipPath";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        canvas.clipPath(com.tencent.mm.plugin.appbrand.canvas.c.d.Rv().f(jSONArray));
        return true;
    }
}
