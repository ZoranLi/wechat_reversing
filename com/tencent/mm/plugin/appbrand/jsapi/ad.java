package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;

public final class ad extends k {
    public static int CTRL_INDEX = 71;
    public static String NAME = "getCurrentRoute";

    public final String a(m mVar) {
        Map hashMap = new HashMap();
        hashMap.put(TencentExtraKeys.LOCATION_KEY_ROUTE, mVar.jde.jdU);
        w.d("MicroMsg.JsApiGetCurrentRoute", "getCurrentRoute : %s", new Object[]{d("ok", hashMap)});
        return d("ok", hashMap);
    }
}
