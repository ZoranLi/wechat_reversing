package com.tencent.mm.plugin.offline.a;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends h {
    public g(String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("buss_type", str);
        hashMap.put("method", str2);
        String str4 = TencentLocation.NETWORK_PROVIDER;
        Object obj = am.isWifi(ab.getContext()) ? "wifi" : am.is3G(ab.getContext()) ? "3g" : am.is2G(ab.getContext()) ? "2g" : am.isWap(ab.getContext()) ? "wap" : am.is4G(ab.getContext()) ? "4g" : "unknown";
        hashMap.put(str4, obj);
        hashMap.put("transactionid", str3);
        x(hashMap);
    }

    public final int aki() {
        return 122;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/datareport";
    }

    public final int zi() {
        return 1602;
    }
}
