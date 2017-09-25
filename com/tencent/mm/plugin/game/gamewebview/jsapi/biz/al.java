package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.gamewebview.ui.d.AnonymousClass25;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class al extends a {
    public static final int CTRL_BYTE = 218;
    public static final String NAME = "setBounceBackground";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiSetBounceBackground", "invoke");
        if (jSONObject == null || bg.mA(jSONObject.optString("backgroundColor"))) {
            dVar.x(i, a.d("setBounceBackground:fail_invalid_data", null));
            return;
        }
        dVar.runOnUiThread(new AnonymousClass25(dVar, jSONObject.optString("backgroundColor")));
        dVar.x(i, a.d("setBounceBackground:ok", null));
    }
}
