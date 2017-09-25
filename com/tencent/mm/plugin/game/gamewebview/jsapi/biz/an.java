package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.graphics.Color;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

public final class an extends a {
    public static final int CTRL_BYTE = 182;
    public static final String NAME = "setNavigationBarColor";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        int i2;
        int i3 = 1;
        w.i("MicroMsg.GameJsApiSetNavigationBarColor", "invoke");
        int i4 = jSONObject.optInt("actionCode") == i3 ? i3 : 0;
        try {
            i3 = Color.parseColor(jSONObject.optString("color")) | WebView.NIGHT_MODE_COLOR;
            i2 = i4;
        } catch (Exception e) {
            w.e("MicroMsg.GameJsApiSetNavigationBarColor", e.getMessage());
            i2 = i3;
            i3 = -1;
        }
        try {
            bg.getFloat(jSONObject.optString("alpha"), 1.0f);
        } catch (Exception e2) {
            w.e("MicroMsg.GameJsApiSetNavigationBarColor", e2.getMessage());
        }
        if (i2 != 0) {
            dVar.jdi = android.support.v4.content.a.b(dVar.mmc, R.e.aSB);
            dVar.jdk = "";
            dVar.azP();
        } else {
            dVar.jdi = i3;
            dVar.azP();
        }
        dVar.x(i, a.d("setNavigationBarColor:ok", null));
    }
}
