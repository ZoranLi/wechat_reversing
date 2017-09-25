package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m extends a {
    public static final int CTRL_BYTE = 188;
    public static final String NAME = "disableBounceScroll";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        int i2 = 0;
        w.i("MicroMsg.GameJsApiDisableBounceScroll", "invoke");
        JSONArray optJSONArray = jSONObject.optJSONArray("place");
        if (optJSONArray == null) {
            w.i("MicroMsg.GameJsApiDisableBounceScroll", "placeArray is null");
            dVar.x(i, a.d("disableBounceScroll:fail", null));
            return;
        }
        int i3 = 0;
        while (i2 < optJSONArray.length()) {
            if ("top".equalsIgnoreCase(optJSONArray.optString(i2))) {
                i3 = 1;
            }
            i2++;
        }
        if (i3 == 0) {
            dVar.x(i, a.d("disableBounceScroll:ok", null));
            return;
        }
        dVar.mHandler.post(new Runnable(dVar) {
            final /* synthetic */ d mnm;

            {
                this.mnm = r1;
            }

            public final void run() {
                if (this.mnm.mmw != null) {
                    this.mnm.mmw.iQ(true);
                }
            }
        });
        dVar.x(i, a.d("disableBounceScroll:ok", null));
    }
}
