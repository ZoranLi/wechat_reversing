package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class ao extends af<ao> {
    public String aBq;
    public boolean aBr;

    public final /* synthetic */ void a(af afVar) {
        ao aoVar = (ao) afVar;
        if (!TextUtils.isEmpty(this.aBq)) {
            aoVar.aBq = this.aBq;
        }
        if (this.aBr) {
            aoVar.aBr = this.aBr;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("description", this.aBq);
        hashMap.put("fatal", Boolean.valueOf(this.aBr));
        return af.ac(hashMap);
    }
}
