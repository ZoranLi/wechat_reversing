package com.tencent.mm.plugin.appbrand.canvas.c;

import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.mm.plugin.appbrand.m.h;
import org.json.JSONArray;

public final class b implements a {
    public final String getMethod() {
        return "arc";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 5) {
            return false;
        }
        float c = h.c(jSONArray, 0);
        float c2 = h.c(jSONArray, 1);
        float c3 = h.c(jSONArray, 2);
        float f = c - c3;
        float f2 = c2 - c3;
        float f3 = c + c3;
        c2 += c3;
        float toDegrees = (float) Math.toDegrees((double) ((float) jSONArray.optDouble(3)));
        c = (float) Math.toDegrees((double) ((float) jSONArray.optDouble(4)));
        c3 = (float) (360.0d / (6.283185307179586d * ((double) c3)));
        float f4 = (c - toDegrees) % 360.0f;
        c = jSONArray.optBoolean(5) ? toDegrees - c : c - toDegrees;
        if (f4 > c3 || f4 < (-c3)) {
            path.arcTo(new RectF(f, f2, f3, c2), toDegrees, c, false);
        } else {
            path.addArc(new RectF(f, f2, f3, c2), toDegrees, c);
        }
        return true;
    }
}
