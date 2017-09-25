package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class ac extends a {
    public static final int CTRL_BYTE = 173;
    public static final String NAME = "openUrlWithExtraWebview";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        Context azK = dVar.azK();
        if (azK == null) {
            w.i("MicroMsg.GameJsApiOpenUrlWithExtraWebView", "activity is null");
            return;
        }
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bg.mA(optString)) {
            dVar.x(i, a.d("openUrlWithExtraWebview:fail_invalid_url", null));
            return;
        }
        Intent intent = new Intent(azK, GameWebViewUI.class);
        intent.putExtra("rawUrl", optString);
        azK.startActivity(intent);
        dVar.x(i, a.d("openUrlWithExtraWebview:ok", null));
    }
}
