package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import android.graphics.Paint.Cap;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class s implements c {
    public final String getMethod() {
        return "setLineCap";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        String optString = jSONArray.optString(0);
        if ("butt".equalsIgnoreCase(optString)) {
            dVar.iDe.setStrokeCap(Cap.BUTT);
            dVar.iDd.setStrokeCap(Cap.BUTT);
        } else if ("round".equalsIgnoreCase(optString)) {
            dVar.iDe.setStrokeCap(Cap.ROUND);
            dVar.iDd.setStrokeCap(Cap.ROUND);
        } else if ("square".equalsIgnoreCase(optString)) {
            dVar.iDe.setStrokeCap(Cap.SQUARE);
            dVar.iDd.setStrokeCap(Cap.SQUARE);
        }
        return true;
    }
}
