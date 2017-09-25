package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.b.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;

public final class n implements c {
    public final String getMethod() {
        return "save";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        canvas.save();
        a aVar = dVar.iDd;
        dVar.iDf.push(dVar.iDd);
        dVar.iDd = dVar.iDd.Ru();
        if (dVar.iDd == null) {
            dVar.iDd = aVar;
        }
        aVar = dVar.iDe;
        dVar.iDg.push(dVar.iDe);
        dVar.iDe = dVar.iDe.Ru();
        if (dVar.iDe == null) {
            dVar.iDe = aVar;
        }
        return true;
    }
}
