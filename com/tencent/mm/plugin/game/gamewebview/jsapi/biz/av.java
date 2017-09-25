package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.gamewebview.ui.d.AnonymousClass20;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class av extends a {
    public static final int CTRL_BYTE = 238;
    public static final String NAME = "showSmileyPanel";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        int i2 = 0;
        w.i("MicroMsg.GameJsApiShowSmileyPanel", "invoke");
        if (dVar.mmz != null) {
            i2 = Thread.currentThread().getId() == dVar.mHandler.getLooper().getThread().getId() ? dVar.mmz.bAb() : ((Integer) new AnonymousClass20(dVar, Integer.valueOf(0)).b(dVar.mHandler)).intValue();
        }
        if (i2 > 0) {
            Map hashMap = new HashMap();
            hashMap.put("height", Integer.valueOf(com.tencent.mm.bg.a.W(dVar.getContext(), i2)));
            dVar.x(i, a.d("showSmileyPanel:ok", hashMap));
            return;
        }
        dVar.x(i, a.d("showSmileyPanel:fail", null));
    }
}
