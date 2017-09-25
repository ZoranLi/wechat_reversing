package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.b.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class l implements c {
    public final String getMethod() {
        return "restore";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        canvas.restore();
        if (!dVar.iDf.isEmpty()) {
            dVar.iDd = (a) dVar.iDf.pop();
            dVar.iDe = (a) dVar.iDg.pop();
        }
        return true;
    }
}
