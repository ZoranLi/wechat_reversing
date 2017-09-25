package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class ar extends af<ar> {
    public String aBC;
    public long aBD;
    public String aBo;
    public String sk;

    public final /* synthetic */ void a(af afVar) {
        ar arVar = (ar) afVar;
        if (!TextUtils.isEmpty(this.aBC)) {
            arVar.aBC = this.aBC;
        }
        if (this.aBD != 0) {
            arVar.aBD = this.aBD;
        }
        if (!TextUtils.isEmpty(this.sk)) {
            arVar.sk = this.sk;
        }
        if (!TextUtils.isEmpty(this.aBo)) {
            arVar.aBo = this.aBo;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("variableName", this.aBC);
        hashMap.put("timeInMillis", Long.valueOf(this.aBD));
        hashMap.put("category", this.sk);
        hashMap.put("label", this.aBo);
        return af.ac(hashMap);
    }
}
