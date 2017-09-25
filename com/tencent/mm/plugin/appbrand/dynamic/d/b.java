package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.dynamic.core.a;
import com.tencent.mm.plugin.appbrand.dynamic.core.e;
import com.tencent.mm.sdk.platformtools.am;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public b() {
        super("getNetworkType", 267);
    }

    protected final void b(e eVar, JSONObject jSONObject, com.tencent.mm.plugin.appbrand.dynamic.core.b.a aVar) {
        Context context = eVar.getContext();
        Map hashMap = new HashMap();
        if (!am.isConnected(context)) {
            hashMap.put("networkType", "none");
        } else if (am.is2G(context)) {
            hashMap.put("networkType", "2g");
        } else if (am.is3G(context)) {
            hashMap.put("networkType", "3g");
        } else if (am.is4G(context)) {
            hashMap.put("networkType", "4g");
        } else if (am.isWifi(context)) {
            hashMap.put("networkType", "wifi");
        } else {
            hashMap.put("networkType", "unknown");
        }
        aVar.f(a(true, "", hashMap));
    }
}
