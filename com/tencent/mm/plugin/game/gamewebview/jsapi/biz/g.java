package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_BYTE = 84;
    public static final String NAME = "checkJsApi";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiCheckJsApi", "invoke");
        JSONArray optJSONArray = jSONObject.optJSONArray("jsApiList");
        if (optJSONArray == null) {
            dVar.x(i, a.d("checkJsApi:param is empty", null));
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        int i2 = 0;
        while (i2 < optJSONArray.length()) {
            try {
                boolean z;
                String optString = optJSONArray.optString(i2);
                if (com.tencent.mm.plugin.game.gamewebview.jsapi.d.azm().containsKey(optString)) {
                    z = true;
                } else {
                    z = false;
                }
                jSONObject2.put(optString, z);
                i2++;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.GameJsApiCheckJsApi", e, "", new Object[0]);
            }
        }
        Map hashMap = new HashMap();
        hashMap.put("checkResult", jSONObject2.toString());
        dVar.x(i, a.d("checkJsApi:ok", hashMap));
    }
}
