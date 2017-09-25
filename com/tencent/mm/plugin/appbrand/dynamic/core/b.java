package com.tencent.mm.plugin.appbrand.dynamic.core;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b {
    int index;
    public String name;

    public interface a {
        void f(JSONObject jSONObject);
    }

    public b(String str, int i) {
        this.name = str;
        this.index = i;
    }

    public void a(e eVar, JSONObject jSONObject, a aVar) {
    }

    public final JSONObject a(boolean z, String str, Map<String, ? extends Object> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append(":");
        stringBuilder.append(z ? "ok" : "fail");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(":");
            stringBuilder.append(bg.mz(str));
        }
        Map hashMap = new HashMap();
        hashMap.put("errMsg", stringBuilder.toString());
        if (map != null) {
            hashMap.putAll(map);
        }
        d.r(hashMap);
        return new JSONObject(hashMap);
    }
}
