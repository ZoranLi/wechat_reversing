package com.google.android.gms.analytics.a;

import com.google.android.gms.c.af;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class c {
    Map<String, String> ahj = new HashMap();

    public final String toString() {
        return af.c(this.ahj);
    }

    public final Map<String, String> u(String str) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.ahj.entrySet()) {
            hashMap.put(str + ((String) entry.getKey()), entry.getValue());
        }
        return hashMap;
    }
}
