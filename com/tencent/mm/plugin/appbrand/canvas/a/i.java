package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class i implements c {
    public final String getMethod() {
        return "fillPath";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        canvas.drawPath(com.tencent.mm.plugin.appbrand.canvas.c.d.Rv().f(jSONArray), dVar.iDe);
        return true;
    }
}
