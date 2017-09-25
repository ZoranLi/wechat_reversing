package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import android.graphics.Paint.Join;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class t implements c {
    public final String getMethod() {
        return "setLineJoin";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        String optString = jSONArray.optString(0);
        if ("miter".equalsIgnoreCase(optString)) {
            dVar.iDe.setStrokeJoin(Join.MITER);
            dVar.iDd.setStrokeJoin(Join.MITER);
        } else if ("round".equalsIgnoreCase(optString)) {
            dVar.iDe.setStrokeJoin(Join.ROUND);
            dVar.iDd.setStrokeJoin(Join.ROUND);
        } else if ("bevel".equalsIgnoreCase(optString)) {
            dVar.iDe.setStrokeJoin(Join.BEVEL);
            dVar.iDd.setStrokeJoin(Join.BEVEL);
        }
        return true;
    }
}
