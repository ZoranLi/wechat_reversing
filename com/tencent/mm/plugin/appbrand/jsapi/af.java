package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.am;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class af extends a {
    public static final int CTRL_INDEX = 39;
    public static final String NAME = "getNetworkType";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        Map hashMap = new HashMap();
        if (!am.isConnected(mVar.mContext)) {
            hashMap.put("networkType", "none");
        } else if (am.is2G(mVar.mContext)) {
            hashMap.put("networkType", "2g");
        } else if (am.is3G(mVar.mContext)) {
            hashMap.put("networkType", "3g");
        } else if (am.is4G(mVar.mContext)) {
            hashMap.put("networkType", "4g");
        } else if (am.isWifi(mVar.mContext)) {
            hashMap.put("networkType", "wifi");
        } else {
            hashMap.put("networkType", "unknown");
        }
        mVar.x(i, d("ok", hashMap));
    }
}
