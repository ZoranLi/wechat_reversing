package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.mm.plugin.appbrand.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a {
    private static Map<String, JSONObject> iSs;

    public static Map<String, JSONObject> TD() {
        if (iSs == null) {
            iSs = new HashMap();
        }
        return iSs;
    }

    public static void TE() {
        if (iSs != null) {
            iSs = null;
        }
    }

    public static String h(m mVar) {
        return "JsApi#BeaconSessionId" + mVar.hashCode();
    }
}
