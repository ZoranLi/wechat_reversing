package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class aj extends af<aj> {
    public String aAU;
    public String aAV;
    public String ahs;
    public String aht;

    public final void a(aj ajVar) {
        if (!TextUtils.isEmpty(this.ahs)) {
            ajVar.ahs = this.ahs;
        }
        if (!TextUtils.isEmpty(this.aht)) {
            ajVar.aht = this.aht;
        }
        if (!TextUtils.isEmpty(this.aAU)) {
            ajVar.aAU = this.aAU;
        }
        if (!TextUtils.isEmpty(this.aAV)) {
            ajVar.aAV = this.aAV;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("appName", this.ahs);
        hashMap.put("appVersion", this.aht);
        hashMap.put("appId", this.aAU);
        hashMap.put("appInstallerId", this.aAV);
        return af.ac(hashMap);
    }
}
