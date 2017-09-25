package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class ap extends a {
    public static final int CTRL_BYTE = 270;
    public static final String NAME = "setScreenOrientation";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        int i2 = 0;
        w.i("MicroMsg.GameJsApiSetScreenOrientation", "invoke");
        if (jSONObject != null) {
            String optString = jSONObject.optString("orientation");
            if (!bg.mA(optString)) {
                if (!optString.equals("horizontal")) {
                    if (optString.equals("vertical")) {
                        i2 = 1;
                    } else if (optString.equals("sensor")) {
                        i2 = 4;
                    } else if (!optString.equals("horizontal_unforced")) {
                        i2 = optString.equals("vertical_unforced") ? 1 : -1;
                    }
                }
                dVar.mms.nt(i2);
                dVar.x(i, a.d("setScreenOrientation:ok", null));
                return;
            }
        }
        w.e("MicroMsg.GameJsApiSetScreenOrientation", "data is null");
        dVar.x(i, a.d("setScreenOrientation:fail_invalid_data", null));
    }
}
