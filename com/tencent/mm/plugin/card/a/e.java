package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.HashMap;
import java.util.Map;

public final class e {
    public CardInfo kcz = null;
    public Map<String, Object> kda = new HashMap();

    public e() {
        this.kda.clear();
    }

    public final void putValue(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            this.kda.put(str, obj);
        }
    }

    public final Object getValue(String str) {
        if (!TextUtils.isEmpty(str) && this.kda.containsKey(str)) {
            return this.kda.get(str);
        }
        return null;
    }
}
