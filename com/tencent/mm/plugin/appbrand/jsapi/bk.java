package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.m;
import org.json.JSONObject;

public final class bk extends a {
    public static final int CTRL_INDEX = 13;
    public static final String NAME = "redirectTo";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (mVar.ixr.iwp.iDO.ob(optString)) {
            mVar.x(i, d("fail:can not redirect to a tab bar page", null));
            return;
        }
        mVar.ixr.iwr.qj(optString);
        mVar.x(i, d("ok", null));
    }
}
