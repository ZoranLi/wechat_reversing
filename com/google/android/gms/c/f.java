package com.google.android.gms.c;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class f extends af<f> {
    public Map<Integer, Double> ayM = new HashMap(4);

    public final /* synthetic */ void a(af afVar) {
        ((f) afVar).ayM.putAll(this.ayM);
    }

    public final String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.ayM.entrySet()) {
            hashMap.put("metric" + entry.getKey(), entry.getValue());
        }
        return af.ac(hashMap);
    }
}
