package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.f.c;
import com.tencent.mm.plugin.appbrand.f.i;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class d extends k {
    public static final int CTRL_INDEX = 242;
    public static final String NAME = "createRequestTask";

    public static class a extends e {
        public static final int CTRL_INDEX = 244;
        public static final String NAME = "onRequestTaskStateChange";
    }

    public final String a(m mVar, JSONObject jSONObject) {
        w.d("MicroMsg.JsApiCreateRequestTask", "JsApiCreateRequestTask");
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiCreateRequestTask", "data is null");
            return d("fail:data is null", null);
        }
        com.tencent.mm.plugin.appbrand.f.e.Vo();
        final int Vl = com.tencent.mm.plugin.appbrand.f.e.Vl();
        com.tencent.mm.plugin.appbrand.a.mV(mVar.ivH);
        com.tencent.mm.plugin.appbrand.a.Pm();
        final long currentTimeMillis = System.currentTimeMillis();
        final m mVar2 = mVar;
        AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.f.c.a(this) {
            final /* synthetic */ d iTL;

            public final void aX(String str, String str2) {
                int i;
                String str3 = "MicroMsg.JsApiCreateRequestTask";
                String str4 = "onRequestResult, time: %d, data size: %d";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                if (str2 == null) {
                    i = 0;
                } else {
                    i = str2.length();
                }
                objArr[1] = Integer.valueOf(i);
                w.d(str3, str4, objArr);
                c pV = com.tencent.mm.plugin.appbrand.f.e.Vo().pV(mVar2.ivH);
                if (pV == null) {
                    w.i("MicroMsg.JsApiCreateRequestTask", "request is null");
                } else if (pV.pU(Vl) == null) {
                    w.i("MicroMsg.JsApiCreateRequestTask", "requestInfo is null %d", new Object[]{Integer.valueOf(Vl)});
                } else {
                    Map hashMap = new HashMap();
                    hashMap.put("requestTaskId", Vl);
                    hashMap.put("state", "fail");
                    hashMap.put("errMsg", str2);
                    String jSONObject = new JSONObject(hashMap).toString();
                    e a = new a().a(mVar2);
                    a.mData = jSONObject;
                    a.SR();
                }
            }

            public final void a(String str, String str2, int i, JSONObject jSONObject) {
                int i2 = 0;
                String str3 = "MicroMsg.JsApiCreateRequestTask";
                String str4 = "onRequestResult, time: %d, data size: %d, code %s,reqrestId %d";
                Object[] objArr = new Object[4];
                objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                if (str2 != null) {
                    i2 = str2.length();
                }
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(Vl);
                w.d(str3, str4, objArr);
                Map hashMap = new HashMap();
                hashMap.put("requestTaskId", Vl);
                if (str.equalsIgnoreCase("ok")) {
                    hashMap.put("state", "success");
                    hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str2);
                } else {
                    hashMap.put("state", "fail");
                }
                hashMap.put("statusCode", Integer.valueOf(i));
                if (jSONObject != null) {
                    hashMap.put("header", jSONObject);
                }
                String jSONObject2 = new JSONObject(hashMap).toString();
                e a = new a().a(mVar2);
                a.mData = jSONObject2;
                a.SR();
            }
        };
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bg.mA(optString)) {
            w.e("MicroMsg.JsApiCreateRequestTask", "url is null");
            return d("fail:url is null or nil", null);
        }
        AppBrandSysConfig mY = b.mY(mVar.ivH);
        int a = i.a(mY, mVar.ixr.iwp, 0);
        if (a <= 0) {
            a = 60000;
        }
        if (mY.iEW <= 0) {
            w.i("MicroMsg.JsApiCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
        }
        Map a2 = i.a(jSONObject, mY);
        if (!i.c(mY) || i.b(mY.iFd, optString)) {
            c cVar;
            if (com.tencent.mm.plugin.appbrand.f.e.Vo().pV(mVar.ivH) == null) {
                cVar = new c(mVar.ivH);
                com.tencent.mm.plugin.appbrand.f.e.Vo().a(mVar.ivH, cVar);
            } else {
                cVar = com.tencent.mm.plugin.appbrand.f.e.Vo().pV(mVar.ivH);
            }
            w.i("MicroMsg.JsApiCreateRequestTask", "request url: %s", new Object[]{optString});
            if (cVar == null) {
                return d("fail:create request error", null);
            }
            if (i.c(mY)) {
                cVar.a(a, jSONObject, a2, mY.iFd, anonymousClass1, String.valueOf(Vl), NAME);
            } else {
                w.i("MicroMsg.JsApiCreateRequestTask", "debug type, do not verify domains");
                cVar.a(a, jSONObject, a2, null, anonymousClass1, String.valueOf(Vl), NAME);
            }
            Map hashMap = new HashMap();
            hashMap.put("requestTaskId", String.valueOf(Vl));
            return d("ok", hashMap);
        }
        w.i("MicroMsg.JsApiCreateRequestTask", "not in domain url %s", new Object[]{optString});
        return d("fail:url not in domain list", null);
    }
}
