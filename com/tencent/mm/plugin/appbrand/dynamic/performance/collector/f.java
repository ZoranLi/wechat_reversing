package com.tencent.mm.plugin.appbrand.dynamic.performance.collector;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public final class f {
    private static Set<String> iIu = new HashSet();

    static {
        CharSequence charSequence = x.NAME;
        if (!TextUtils.isEmpty(charSequence)) {
            iIu.add(charSequence);
        }
    }

    public static boolean oO(String str) {
        return iIu.contains(str);
    }

    public static void a(String str, String str2, JSONObject jSONObject) {
        try {
            jSONObject.put("__session_id", str);
            jSONObject.put("__invoke_jsapi_timestamp", System.nanoTime());
            CollectSession oI = c.oI(str);
            if (oI != null) {
                oI.fMb.putInt("__invoke_jsapi_data_size", str2.length());
            }
        } catch (Throwable e) {
            w.e("MicroMsg.JsApiCostTimeStrategy", "%s", new Object[]{Log.getStackTraceString(e)});
        }
    }

    public static String g(JSONObject jSONObject) {
        return jSONObject.optString("__session_id");
    }
}
