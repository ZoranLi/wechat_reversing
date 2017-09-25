package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.m.h;
import org.json.JSONArray;

public final class q implements c {
    public final String getMethod() {
        return "setFontSize";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        int a = h.a(jSONArray, 0);
        dVar.iDe.setTextSize((float) a);
        dVar.iDd.setTextSize((float) a);
        return true;
    }
}
