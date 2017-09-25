package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class aj extends a {
    public static final int CTRL_BYTE = 251;
    public static final String NAME = "recordVideo";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiRecordVideo", "invoke");
        if (jSONObject == null) {
            dVar.x(i, a.d("chooseVideo:fail_invalid_data", null));
        } else {
            j.a(dVar, jSONObject, i, 1);
        }
    }
}
