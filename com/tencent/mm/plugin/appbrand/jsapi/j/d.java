package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = 241;
    private static final String NAME = "setTopBarText";

    public final void a(final m mVar, JSONObject jSONObject, int i) {
        AppBrandStickyBannerLogic.a.bj(mVar.ivH, jSONObject.optString("text"));
        mVar.x(i, d("ok", null));
        e.a(mVar.ivH, new b(this) {
            final /* synthetic */ d iVN;

            public final void onDestroy() {
                AppBrandStickyBannerLogic.a.bj(mVar.ivH, "");
            }
        });
    }
}
