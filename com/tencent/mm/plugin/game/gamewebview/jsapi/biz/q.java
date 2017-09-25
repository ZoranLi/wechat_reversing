package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class q extends a {
    public static final int CTRL_BYTE = 16;
    public static final String NAME = "getNetworkType";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiGetNetworkType", "invoke");
        Context context = dVar.getContext();
        if (context == null) {
            w.e("MicroMsg.GameJsApiGetNetworkType", "context is null");
        } else if (am.isConnected(context)) {
            w.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, type = " + am.getNetType(context));
            Map hashMap = new HashMap();
            if (am.isWifi(context)) {
                w.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, wifi");
                dVar.x(i, a.d("network_type:wifi", null));
                return;
            }
            if (am.is2G(context)) {
                w.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, 2g");
                hashMap.put("subtype", "2g");
            } else if (am.is3G(context)) {
                w.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, 3g");
                hashMap.put("subtype", "3g");
            } else if (am.is4G(context)) {
                w.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, 4g");
                hashMap.put("subtype", "4g");
            }
            dVar.x(i, a.d("network_type:wwan", hashMap));
        } else {
            w.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, not connected");
            dVar.x(i, a.d("network_type:fail", null));
        }
    }
}
