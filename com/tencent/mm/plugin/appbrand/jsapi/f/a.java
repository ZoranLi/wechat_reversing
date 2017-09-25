package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.f.j;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 21;
    public static final String NAME = "closeSocket";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        j qd = a.jbC.qd(mVar.ivH);
        if (qd != null) {
            int optInt = jSONObject.optInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, 1000);
            String optString = jSONObject.optString("reason", "");
            if (qd.jbw != null) {
                try {
                    w.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
                    com.tencent.mm.plugin.appbrand.n.a.a aVar = qd.jbw;
                    if (aVar.jpd != null) {
                        aVar.joY.c(optInt, optString, false);
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.AppBrandNetworkWebSocket", "send error" + e.toString());
                }
            }
            mVar.x(i, d("ok", null));
            w.d("MicroMsg.JsApiCloseSocket", "code %d, reason %s", new Object[]{Integer.valueOf(optInt), optString});
            return;
        }
        mVar.x(i, d("fail", null));
    }
}
