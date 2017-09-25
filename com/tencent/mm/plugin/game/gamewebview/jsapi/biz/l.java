package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class l extends a {
    public static final int CTRL_BYTE = 17;
    public static final String NAME = "closeWindow";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiCloseWindow", "invoke");
        if (dVar == null || dVar.azK() == null) {
            w.e("MicroMsg.GameJsApiCloseWindow", "page or activity is null");
            return;
        }
        dVar.eD(false);
        dVar.x(i, a.d("close_window:ok", null));
    }
}
