package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.g.j;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public abstract class d extends b {
    public final String d(String str, Map<String, ? extends Object> map) {
        Map hashMap = new HashMap();
        hashMap.put("errMsg", getName() + ":" + str);
        if (map != null) {
            if (b.bIu() && map.containsKey("errMsg")) {
                Assert.assertTrue("api " + getName() + ": Cant put errMsg in res!!!", false);
            }
            hashMap.putAll(map);
        }
        com.tencent.mm.plugin.appbrand.m.d.r(hashMap);
        return new JSONObject(hashMap).toString();
    }

    public MMActivity a(m mVar) {
        j jVar = mVar.ixr.iwr;
        if (jVar == null) {
            return null;
        }
        Context context = jVar.getContext();
        if (context instanceof MMActivity) {
            return (MMActivity) context;
        }
        return null;
    }

    public static com.tencent.mm.plugin.appbrand.g.m b(m mVar) {
        j jVar = mVar.ixr.iwr;
        if (jVar == null || jVar.VN() == null) {
            return null;
        }
        return jVar.VN().VC();
    }
}
