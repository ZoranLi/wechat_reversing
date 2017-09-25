package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import org.json.JSONObject;

public final class bd extends a {
    public static final int CTRL_INDEX = 247;
    public static final String NAME = "openDeliveryList";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("query");
        if (bg.mA(optString)) {
            mVar.x(i, d("fail", null));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://mp.weixin.qq.com/bizmall/expressentry" + optString);
        intent.putExtra("show_native_web_view", true);
        intent.putExtra("KRightBtn", true);
        if (mVar.mContext != null) {
            d.b(mVar.mContext, "webview", ".ui.tools.WebViewUI", intent);
            mVar.x(i, d("ok", null));
            return;
        }
        mVar.x(i, d("fail", null));
    }
}
