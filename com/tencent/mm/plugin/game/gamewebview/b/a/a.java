package com.tencent.mm.plugin.game.gamewebview.b.a;

import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.game.gamewebview.b.a {
    public static final int CTRL_BYTE = 0;
    public static final String NAME = "onCustomGameMenuClicked";

    public final void i(int i, Bundle bundle) {
        w.i("MicroMsg.GameJsEventCustomGameMenuClicked", "invoke");
        if (bundle != null) {
            int i2 = bundle.getInt("itemId");
            d ns = com.tencent.mm.plugin.game.gamewebview.model.a.ns(i);
            if (ns != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("itemId", i2);
                    ns.ck(getName(), jSONObject.toString());
                } catch (Exception e) {
                    w.e("MicroMsg.GameJsEventCustomGameMenuClicked", "ex : " + e.getMessage());
                }
            }
        }
    }
}
