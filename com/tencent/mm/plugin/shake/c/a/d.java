package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class d {
    public float gKj = -85.0f;
    public float gKk = -1000.0f;
    Map<String, Object> kda = new HashMap();
    int poM = 0;
    long poN = 0;
    String poO = "";

    public d() {
        this.kda.clear();
    }

    public final void putValue(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            this.kda.put(str, obj);
        }
    }
}
