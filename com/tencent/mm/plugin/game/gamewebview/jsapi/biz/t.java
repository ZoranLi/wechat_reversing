package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.gamewebview.ui.f;
import com.tencent.mm.plugin.game.gamewebview.ui.j;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class t extends a {
    public static final int CTRL_BYTE = 14;
    public static final String NAME = "hideOptionMenu";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiHideOptionMenu", "invoke");
        f fVar = dVar.mmt;
        if (fVar == null) {
            w.e("MicroMsg.GameJsApiHideOptionMenu", "actionBar is null");
            return;
        }
        if (fVar.mnC != null) {
            j jVar = fVar.mnC;
            jVar.mnS.clear();
            jVar.mnS.addAll(jVar.mnT.values());
            jVar.mnS.removeAll(jVar.mnU);
        }
        dVar.x(i, a.d("hideOptionMenu:ok", null));
    }
}
