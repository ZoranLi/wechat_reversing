package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.menu.j;
import com.tencent.mm.plugin.appbrand.menu.k;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = 211;
    public static final String NAME = "updateShareMenuDynamic";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
        if (b != null) {
            j ic = b.ic(k.jay);
            if (ic == null) {
                mVar.x(i, d("fail:menu item do not exist", null));
                return;
            }
            ic.iHR.l("enable_share_dynamic", Boolean.valueOf(jSONObject.optBoolean("isDynamic", false)));
            mVar.x(i, d("ok", null));
            w.i("MicroMsg.JsApiUpdateShareMenuDynamic", "update share menu dynamic(%s)", new Object[]{Boolean.valueOf(r1)});
            return;
        }
        mVar.x(i, d("fail", null));
    }
}
