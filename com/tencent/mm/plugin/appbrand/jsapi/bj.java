package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.m;
import org.json.JSONObject;

public final class bj extends a {
    private static final int CTRL_INDEX = 170;
    private static final String NAME = "reLaunch";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        mVar.ixr.iwr.L(jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL), false);
        mVar.x(i, d("ok", null));
    }
}
