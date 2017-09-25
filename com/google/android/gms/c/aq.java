package com.google.android.gms.c;

import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import java.util.HashMap;
import java.util.Map;

public final class aq extends af<aq> {
    public String aBA;
    public String aBB;
    public String aqY;

    public final /* synthetic */ void a(af afVar) {
        aq aqVar = (aq) afVar;
        if (!TextUtils.isEmpty(this.aBA)) {
            aqVar.aBA = this.aBA;
        }
        if (!TextUtils.isEmpty(this.aqY)) {
            aqVar.aqY = this.aqY;
        }
        if (!TextUtils.isEmpty(this.aBB)) {
            aqVar.aBB = this.aBB;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put(TencentLocation.NETWORK_PROVIDER, this.aBA);
        hashMap.put("action", this.aqY);
        hashMap.put("target", this.aBB);
        return af.ac(hashMap);
    }
}
