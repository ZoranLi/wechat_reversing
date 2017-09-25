package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import org.json.JSONObject;

public final class r extends a {
    public static final int CTRL_BYTE = -3;
    public static final String NAME = "getWePkgAuthResult";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiGetWePkgAuthResult", "invoke");
        if (dVar.mmS) {
            w.i("MicroMsg.GameJsApiGetWePkgAuthResult", "gettingA8Key");
            dVar.x(i, a.d("etWePkgAuthResult:fail_auth_result_not_return", null));
            return;
        }
        String str = dVar.mmP;
        if (bg.mA(str)) {
            dVar.x(i, a.d("getWePkgAuthResult:fail_full_url_empty", null));
            return;
        }
        Object hashMap = new HashMap();
        if (dVar.mmY) {
            hashMap.put("set_cookie", Integer.valueOf(1));
        } else {
            hashMap.put("set_cookie", Integer.valueOf(0));
        }
        hashMap.put("full_url", str);
        dVar.x(i, a.d("getWePkgAuthResult:ok", hashMap));
    }
}
