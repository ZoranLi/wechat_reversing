package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.f.c;
import com.tencent.mm.plugin.appbrand.f.d;
import com.tencent.mm.plugin.appbrand.f.e;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h extends a {
    public static final int CTRL_INDEX = 243;
    public static final String NAME = "operateRequestTask";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.d("MicroMsg.JsApiOperateRequestTask", "JsApiOperateRequestTask");
        if (jSONObject == null) {
            mVar.x(i, d("fail:data is null", null));
            w.e("MicroMsg.JsApiOperateRequestTask", "data is null");
            return;
        }
        String optString = jSONObject.optString("requestTaskId");
        if (bg.mA(optString)) {
            w.e("MicroMsg.JsApiOperateRequestTask", "requestTaskId is null");
            mVar.x(i, d("fail:requestTaskId is null or nil", null));
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (bg.mA(optString2)) {
            w.e("MicroMsg.JsApiOperateRequestTask", "operationType is null");
            mVar.x(i, d("fail:operationType is null or nil", null));
        } else if (optString2.equals("abort")) {
            c pV = e.Vo().pV(mVar.ivH);
            if (pV == null) {
                mVar.x(i, d("fail:no task", null));
                w.w("MicroMsg.JsApiOperateRequestTask", "request is null");
                return;
            }
            d pU = pV.pU(optString);
            if (pU == null) {
                mVar.x(i, d("fail:no task", null));
                w.w("MicroMsg.JsApiOperateRequestTask", "requestInfo is null %s", new Object[]{optString});
                return;
            }
            w.d("MicroMsg.AppBrandNetworkRequest", "try to abortTask");
            pV.a(pU.mUrl, pU.jbj);
            mVar.x(i, d("ok", null));
            Map hashMap = new HashMap();
            hashMap.put("requestTaskId", optString);
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            optString2 = new JSONObject(hashMap).toString();
            com.tencent.mm.plugin.appbrand.jsapi.e a = new d.a().a(mVar);
            a.mData = optString2;
            a.SR();
            w.d("MicroMsg.JsApiOperateRequestTask", "abortTask finish %s", new Object[]{optString});
        } else {
            mVar.x(i, d("fail:unknown operationType", null));
        }
    }
}
