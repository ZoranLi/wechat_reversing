package com.google.android.gms.c;

import com.google.android.gms.analytics.a.a;
import com.google.android.gms.analytics.a.b;
import com.google.android.gms.analytics.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class am extends af<am> {
    public final List<a> aBk = new ArrayList();
    public final List<c> aBl = new ArrayList();
    public final Map<String, List<a>> aBm = new HashMap();
    public b aBn;

    public final /* synthetic */ void a(af afVar) {
        am amVar = (am) afVar;
        amVar.aBk.addAll(this.aBk);
        amVar.aBl.addAll(this.aBl);
        for (Entry entry : this.aBm.entrySet()) {
            String str = (String) entry.getKey();
            for (a aVar : (List) entry.getValue()) {
                if (aVar != null) {
                    Object obj;
                    if (str == null) {
                        obj = "";
                    } else {
                        String str2 = str;
                    }
                    if (!amVar.aBm.containsKey(obj)) {
                        amVar.aBm.put(obj, new ArrayList());
                    }
                    ((List) amVar.aBm.get(obj)).add(aVar);
                }
            }
        }
        if (this.aBn != null) {
            amVar.aBn = this.aBn;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        if (!this.aBk.isEmpty()) {
            hashMap.put("products", this.aBk);
        }
        if (!this.aBl.isEmpty()) {
            hashMap.put("promotions", this.aBl);
        }
        if (!this.aBm.isEmpty()) {
            hashMap.put("impressions", this.aBm);
        }
        hashMap.put("productAction", this.aBn);
        return af.ac(hashMap);
    }
}
