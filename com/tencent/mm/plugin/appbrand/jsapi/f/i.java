package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.f.f;
import com.tencent.mm.plugin.appbrand.f.g;
import com.tencent.mm.plugin.appbrand.f.h;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i extends a {
    public static final int CTRL_INDEX = 273;
    public static final String NAME = "operateUploadTask";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.d("MicroMsg.JsApiOperateUploadTask", "JsApiOperateUploadTask");
        if (jSONObject == null) {
            mVar.x(i, d("fail:data is null", null));
            w.e("MicroMsg.JsApiOperateUploadTask", "data is null");
            return;
        }
        String optString = jSONObject.optString("uploadTaskId");
        if (bg.mA(optString)) {
            w.e("MicroMsg.JsApiOperateUploadTask", "uploadTaskId is null");
            mVar.x(i, d("fail:uploadTaskId is null or nil", null));
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (bg.mA(optString2)) {
            w.e("MicroMsg.JsApiOperateUploadTask", "operationType is null");
            mVar.x(i, d("fail:operationType is null or nil", null));
        } else if (optString2.equals("abort")) {
            f pX = h.Vp().pX(mVar.ivH);
            if (pX == null) {
                w.i("MicroMsg.JsApiOperateUploadTask", "upload is null");
                mVar.x(i, d("fail:no task", null));
                return;
            }
            g pW = pX.pW(optString);
            if (pW == null) {
                w.i("MicroMsg.JsApiOperateUploadTask", "uploadInfo is null %s", new Object[]{optString});
                mVar.x(i, d("fail:no task", null));
                return;
            }
            if (pW != null) {
                pW.aJi = false;
                pX.a(pW.mUrl, pW.mName, pW.jbp, pW.jbj);
            }
            mVar.x(i, d("ok", null));
            Map hashMap = new HashMap();
            hashMap.put("uploadTaskId", optString);
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            optString2 = new JSONObject(hashMap).toString();
            e a = new e.a().a(mVar);
            a.mData = optString2;
            a.SR();
            w.d("MicroMsg.JsApiOperateUploadTask", "abortTask finish %s", new Object[]{optString});
        } else {
            mVar.x(i, d("fail:unknown operationType", null));
        }
    }
}
