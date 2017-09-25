package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.gamewebview.ui.d.AnonymousClass19;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class as extends a {
    public static final int CTRL_BYTE = 187;
    public static final String NAME = "showKeyboard";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiShowKeyBoard", "invoke");
        String optString = jSONObject.optString("placeholder");
        int optInt = jSONObject.optInt("maxLength");
        dVar.mmR = i;
        if (dVar.mmz != null) {
            dVar.mHandler.post(new AnonymousClass19(dVar, optString, optInt));
        }
    }
}
