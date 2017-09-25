package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.m;
import org.json.JSONObject;

public final class ck extends a {
    public static final int CTRL_INDEX = 150;
    public static final String NAME = "switchTab";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (mVar.ixr.iwp.iDO.ob(optString)) {
            mVar.ixr.iwr.qk(optString);
            mVar.x(i, d("ok", null));
            return;
        }
        mVar.x(i, d("fail:can not switch to non-TabBar page", null));
    }
}
