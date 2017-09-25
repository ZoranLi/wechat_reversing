package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import com.tencent.mm.plugin.appbrand.canvas.b.a.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class h implements c {
    public final String getMethod() {
        return "strokeText";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 3) {
            return false;
        }
        String optString = jSONArray.optString(0);
        float c = com.tencent.mm.plugin.appbrand.m.h.c(jSONArray, 1);
        float c2 = com.tencent.mm.plugin.appbrand.m.h.c(jSONArray, 2);
        FontMetrics fontMetrics = dVar.iDd.getFontMetrics();
        if (dVar.iDd.iDj == a.iDm) {
            c2 += Math.abs(fontMetrics.ascent);
        } else if (dVar.iDd.iDj == a.iDo) {
            c2 += Math.abs((((-fontMetrics.ascent) + fontMetrics.descent) / 2.0f) - fontMetrics.descent);
        } else if (dVar.iDd.iDj == a.iDn) {
            c2 -= Math.abs(fontMetrics.descent);
        }
        canvas.drawText(optString, c, c2, dVar.iDd);
        return true;
    }
}
