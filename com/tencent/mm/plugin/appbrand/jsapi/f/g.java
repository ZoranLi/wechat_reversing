package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = 270;
    public static final String NAME = "operateDownloadTask";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.d("MicroMsg.JsApiOperateDownloadTask", "JsApiOperateDownloadTask");
        if (jSONObject == null) {
            mVar.x(i, d("fail:data is null", null));
            w.e("MicroMsg.JsApiOperateDownloadTask", "data is null");
            return;
        }
        String optString = jSONObject.optString("downloadTaskId");
        if (bg.mA(optString)) {
            w.e("MicroMsg.JsApiOperateDownloadTask", "downloadTaskId is null");
            mVar.x(i, d("fail:downloadTaskId is null or nil", null));
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (bg.mA(optString2)) {
            w.e("MicroMsg.JsApiOperateDownloadTask", "operationType is null");
            mVar.x(i, d("fail:operationType is null or nil", null));
        } else if (optString2.equals("abort")) {
            com.tencent.mm.plugin.appbrand.f.a pS = b.Vm().pS(mVar.ivH);
            if (pS == null) {
                mVar.x(i, d("fail:no task", null));
                w.w("MicroMsg.JsApiOperateDownloadTask", "download is null");
                return;
            }
            com.tencent.mm.plugin.appbrand.f.a.b pR = pS.pR(optString);
            if (pR == null) {
                mVar.x(i, d("fail:no task", null));
                w.w("MicroMsg.JsApiOperateDownloadTask", "downloadWorker is null %s", new Object[]{optString});
                return;
            }
            if (pR != null) {
                pS.pP(pR.uri);
                pR.Vu();
            }
            mVar.x(i, d("ok", null));
            Map hashMap = new HashMap();
            hashMap.put("downloadTaskId", optString);
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            optString2 = new JSONObject(hashMap).toString();
            e a = new c.a().a(mVar);
            a.mData = optString2;
            a.SR();
            w.d("MicroMsg.JsApiOperateDownloadTask", "abortTask finish %s", new Object[]{optString});
        } else {
            mVar.x(i, d("fail:unknown operationType", null));
        }
    }
}
