package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewBaseActivity;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.gamewebview.ui.f;
import com.tencent.mm.plugin.game.gamewebview.ui.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONArray;
import org.json.JSONObject;

public final class s extends a {
    public static final int CTRL_BYTE = 85;
    public static final String NAME = "hideMenuItems";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiHideMenuItems", "invoke");
        GameWebViewBaseActivity azK = dVar.azK();
        if (azK == null || azK.isFinishing()) {
            w.e("MicroMsg.GameJsApiHideMenuItems", "activity is finish");
            return;
        }
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("menuList");
            if (optJSONArray != null) {
                f fVar = dVar.mmt;
                if (!(fVar == null || fVar.mnC == null)) {
                    j jVar = fVar.mnC;
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            int f = bg.f((Integer) jVar.mnT.get(optJSONArray.optString(i2)));
                            if (f > 0 && !jVar.mnU.contains(Integer.valueOf(f))) {
                                jVar.mnS.add(Integer.valueOf(f));
                            }
                        }
                    }
                }
                dVar.x(i, a.d("hideMenuItems:ok", null));
                return;
            }
        }
        w.i("MicroMsg.GameJsApiHideMenuItems", "data is null");
        dVar.x(i, a.d("hideMenuItems:fail_invalid_data", null));
    }
}
