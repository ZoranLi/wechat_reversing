package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONArray;
import org.json.JSONException;

public final class r implements c {
    public final String getMethod() {
        return "setGlobalAlpha";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        boolean z = false;
        try {
            int i = jSONArray.getInt(0);
            dVar.iDd.J(((float) i) / 255.0f);
            dVar.iDe.J(((float) i) / 255.0f);
            return true;
        } catch (JSONException e) {
            w.e("MicroMsg.SetGlobalAlphaAction", "getGlobalAlpha value error. exception : %s", new Object[]{e});
            return z;
        }
    }
}
