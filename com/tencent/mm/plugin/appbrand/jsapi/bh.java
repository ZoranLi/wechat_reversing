package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import org.json.JSONObject;

public final class bh extends a {
    public static final int CTRL_INDEX = 201;
    public static final String NAME = "openUrl";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bg.mA(optString)) {
            mVar.x(i, d("fail", null));
            return;
        }
        Intent putExtra = new Intent().putExtra("rawUrl", optString).putExtra("appbrand_report_key_target_url", optString);
        if (mVar.mContext != null) {
            d.b(mVar.mContext, "webview", ".ui.tools.WebViewUI", putExtra);
            mVar.x(i, d("ok", null));
            return;
        }
        mVar.x(i, d("fail", null));
    }
}
