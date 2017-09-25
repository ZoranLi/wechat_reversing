package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import android.graphics.Paint.Align;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class y implements c {
    public final String getMethod() {
        return "setTextAlign";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        String optString = jSONArray.optString(0);
        if ("left".equalsIgnoreCase(optString)) {
            dVar.iDd.setTextAlign(Align.LEFT);
            dVar.iDe.setTextAlign(Align.LEFT);
        } else if ("right".equalsIgnoreCase(optString)) {
            dVar.iDd.setTextAlign(Align.RIGHT);
            dVar.iDe.setTextAlign(Align.RIGHT);
        } else if ("center".equalsIgnoreCase(optString)) {
            dVar.iDd.setTextAlign(Align.CENTER);
            dVar.iDe.setTextAlign(Align.CENTER);
        }
        return true;
    }
}
