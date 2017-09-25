package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public enum b {
    ;
    
    private Map<String, WeakReference<a>> rJk;

    private b(String str) {
        this.rJk = new HashMap();
    }

    public final a a(Orders orders) {
        String str;
        if (orders == null || orders.rGe == null) {
            str = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < orders.rGe.size(); i++) {
                stringBuilder.append(((Commodity) orders.rGe.get(i)).fTA);
            }
            stringBuilder.append("@");
            stringBuilder.append(orders.rFL);
            str = stringBuilder.toString();
        }
        if (bg.mA(str)) {
            w.w("MicroMsg.FavorLogicHelperPool", "get key null");
            return null;
        }
        if (this.rJk.containsKey(str)) {
            w.i("MicroMsg.FavorLogicHelperPool", "hit cache, key:" + str);
            WeakReference weakReference = (WeakReference) this.rJk.get(str);
            if (weakReference != null) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    return aVar;
                }
                w.i("MicroMsg.FavorLogicHelperPool", "helper null");
            } else {
                w.i("MicroMsg.FavorLogicHelperPool", "weakHelper null");
            }
        }
        if (orders == null || orders.rGf == null) {
            return null;
        }
        a aVar2 = new a(orders.rGf);
        this.rJk.put(str, new WeakReference(aVar2));
        return aVar2;
    }
}
