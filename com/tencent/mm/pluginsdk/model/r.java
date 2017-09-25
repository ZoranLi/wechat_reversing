package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.QbSdk;
import java.util.HashMap;
import org.json.JSONObject;

public final class r {
    public static int a(Context context, String str, String str2, String str3, ValueCallback<String> valueCallback) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("local", "true");
        hashMap.put("style", "1");
        String str4 = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("path", str);
            jSONObject.put("ext", str2);
            jSONObject.put("token", str3);
            str4 = jSONObject.toString();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.QbReaderLogic", e, "openReadFile", new Object[0]);
        }
        return QbSdk.startMiniQBToLoadUrl(context, str4, hashMap, valueCallback);
    }
}
