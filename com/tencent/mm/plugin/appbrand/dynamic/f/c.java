package com.tencent.mm.plugin.appbrand.dynamic.f;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.dynamic.core.c {
    public c() {
        super("onNetworkStatusChange");
    }

    public final JSONObject nQ() {
        HashMap hashMap = new HashMap();
        Context context = ab.getContext();
        boolean isConnected = am.isConnected(context);
        hashMap.put("isConnected", Boolean.valueOf(isConnected));
        if (!isConnected) {
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
        return new JSONObject(hashMap);
    }
}
