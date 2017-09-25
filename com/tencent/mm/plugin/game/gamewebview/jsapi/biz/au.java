package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.gamewebview.ui.f;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class au extends a {
    public static final int CTRL_BYTE = 14;
    public static final String NAME = "showOptionMenu";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiShowOptionMenu", "invoke");
        f fVar = dVar.mmt;
        if (fVar == null) {
            w.i("MicroMsg.GameJsApiShowOptionMenu", "actionBar is null");
            return;
        }
        if (fVar.mnC != null) {
            fVar.mnC.mnS.clear();
        }
        dVar.x(i, a.d("showOptionMenu:ok", null));
    }
}
