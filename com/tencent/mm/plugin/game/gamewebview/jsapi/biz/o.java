package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o extends a {
    public static final int CTRL_BYTE = 25;
    public static final String NAME = "getInstallState";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiGetNetworkType", "invoke");
        Context context = dVar.getContext();
        if (context == null) {
            w.i("MicroMsg.GameJsApiGetNetworkType", "context is null");
        } else if (jSONObject == null) {
            w.i("MicroMsg.GameJsApiGetNetworkType", "data is null");
            dVar.x(i, a.d("get_install_state:no_null_data", null));
        } else {
            JSONArray optJSONArray = jSONObject.optJSONArray(DownloadInfoColumns.PACKAGENAME);
            Map hashMap;
            if (optJSONArray != null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                int i2 = 0;
                Object obj = null;
                while (i2 < optJSONArray.length()) {
                    try {
                        String optString = optJSONArray.optString(i2);
                        PackageInfo az = p.az(context, optString);
                        int i3 = az == null ? 0 : az.versionCode;
                        String str = az == null ? "null" : az.versionName;
                        w.i("MicroMsg.GameJsApiGetNetworkType", "getInstallState, packageName = " + optString + ", version = " + i3 + ", versionName = " + str);
                        if (obj == null && i3 > 0) {
                            obj = 1;
                        }
                        jSONObject2.put(optString, i3);
                        jSONObject3.put(optString, str);
                        i2++;
                    } catch (Exception e) {
                    }
                }
                hashMap = new HashMap();
                hashMap.put("result", jSONObject2.toString());
                hashMap.put("versionName", jSONObject3.toString());
                if (obj != null) {
                    dVar.x(i, a.d("get_install_state:yes", hashMap));
                    return;
                } else {
                    dVar.x(i, a.d("get_install_state:no", null));
                    return;
                }
            }
            String optString2 = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
            if (bg.mA(optString2)) {
                w.i("MicroMsg.GameJsApiGetNetworkType", "packageName is null or nil");
                dVar.x(i, a.d("get_install_state:no_null_packageName", null));
                return;
            }
            PackageInfo az2 = p.az(context, optString2);
            int i4 = az2 == null ? 0 : az2.versionCode;
            String str2 = az2 == null ? "null" : az2.versionName;
            w.i("MicroMsg.GameJsApiGetNetworkType", "doGetInstallState, packageName = " + optString2 + ", version = " + i4 + ", versionName = " + str2);
            if (az2 == null) {
                dVar.x(i, a.d("get_install_state:no", null));
                return;
            }
            hashMap = new HashMap();
            hashMap.put("versionName", str2);
            dVar.x(i, a.d("get_install_state:yes_" + str2, hashMap));
        }
    }
}
