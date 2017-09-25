package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewBaseActivity;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.gamewebview.ui.d.AnonymousClass21;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class ao extends a {
    public static final int CTRL_BYTE = 113;
    public static final String NAME = "setPageTitle";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiSetPageTitle", "invoke");
        if (jSONObject == null) {
            w.i("MicroMsg.GameJsApiSetPageTitle", "data is null");
            dVar.x(i, "setPageTitle:fail");
            return;
        }
        GameWebViewBaseActivity azK = dVar.azK();
        dVar.mHandler.post(new AnonymousClass21(dVar, jSONObject.optString("title"), com.tencent.mm.plugin.webview.ui.tools.d.cd(jSONObject.optString("color"), azK.getResources().getColor(R.e.aSC))));
        dVar.x(i, a.d("setPageTitle:ok", null));
    }
}
