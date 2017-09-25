package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.g.j;
import com.tencent.mm.plugin.appbrand.g.j.AnonymousClass11;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class az extends a {
    public static final int CTRL_INDEX = 14;
    public static final String NAME = "navigateTo";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        int i2 = b.mY(mVar.ivH).iEU;
        if (mVar.ixr.iwr.getPageCount() >= i2) {
            mVar.x(i, d("fail:page limit exceeded: " + i2, null));
            w.e("MicroMsg.JsApiNavigateTo", "page limit exceeded: " + i2);
            return;
        }
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (mVar.ixr.iwp.iDO.ob(optString)) {
            mVar.x(i, d("fail:can not navigate to a tab bar page", null));
            return;
        }
        j jVar = mVar.ixr.iwr;
        jVar.runOnUiThread(new AnonymousClass11(jVar, optString));
        mVar.x(i, d("ok", null));
    }
}
