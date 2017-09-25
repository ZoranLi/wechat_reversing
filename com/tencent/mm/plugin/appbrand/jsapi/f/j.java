package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.f.c;
import com.tencent.mm.plugin.appbrand.f.e;
import com.tencent.mm.plugin.appbrand.f.i;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class j extends a {
    public static final int CTRL_INDEX = 19;
    public static final String NAME = "request";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        com.tencent.mm.plugin.appbrand.a.mV(mVar.ivH);
        com.tencent.mm.plugin.appbrand.a.Pm();
        final long currentTimeMillis = System.currentTimeMillis();
        final m mVar2 = mVar;
        final int i2 = i;
        AnonymousClass1 anonymousClass1 = new c.a(this) {
            final /* synthetic */ j iTP;

            public final void aX(String str, String str2) {
                int i = 0;
                Map hashMap = new HashMap();
                String str3 = "MicroMsg.JsApiRequest";
                String str4 = "onRequestResult, time: %d, data size: %d";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                if (str2 != null) {
                    i = str2.length();
                }
                objArr[1] = Integer.valueOf(i);
                w.d(str3, str4, objArr);
                if (str.equalsIgnoreCase("ok")) {
                    hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str2);
                } else {
                    str = str + " " + str2;
                }
                mVar2.x(i2, this.iTP.d(str, hashMap));
            }

            public final void a(String str, String str2, int i, JSONObject jSONObject) {
                int i2 = 0;
                String str3 = "MicroMsg.JsApiRequest";
                String str4 = "onRequestResult, time: %d, data size: %d, code %s";
                Object[] objArr = new Object[3];
                objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                if (str2 != null) {
                    i2 = str2.length();
                }
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = Integer.valueOf(i);
                w.d(str3, str4, objArr);
                Map hashMap = new HashMap();
                if (str.equalsIgnoreCase("ok")) {
                    hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str2);
                } else {
                    str = str + " " + str2;
                }
                hashMap.put("statusCode", Integer.valueOf(i));
                if (jSONObject != null) {
                    hashMap.put("header", jSONObject);
                }
                mVar2.x(i2, this.iTP.d(str, hashMap));
            }
        };
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bg.mA(optString)) {
            w.e("MicroMsg.JsApiRequest", "url is null");
            Map hashMap = new HashMap();
            hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, "url is null");
            mVar.x(i, d("fail:url is null or nil", hashMap));
            return;
        }
        AppBrandSysConfig mY = b.mY(mVar.ivH);
        int a = i.a(mY, mVar.ixr.iwp, 0);
        if (a <= 0) {
            a = 60000;
        }
        if (mY.iEW <= 0) {
            w.i("MicroMsg.JsApiRequest", "maxRequestConcurrent <= 0 use default concurrent");
        }
        Map a2 = i.a(jSONObject, mY);
        if (!i.c(mY) || i.b(mY.iFd, optString)) {
            c cVar;
            if (e.Vo().pV(mVar.ivH) == null) {
                cVar = new c(mVar.ivH);
                e.Vo().a(mVar.ivH, cVar);
            } else {
                cVar = e.Vo().pV(mVar.ivH);
            }
            w.i("MicroMsg.JsApiRequest", "request url: %s", new Object[]{optString});
            if (cVar == null) {
                mVar.x(i, d("fail:create request error", null));
                return;
            } else if (i.c(mY)) {
                cVar.a(a, jSONObject, a2, mY.iFd, anonymousClass1, null, NAME);
                return;
            } else {
                w.i("MicroMsg.JsApiRequest", "debug type, do not verify domains");
                cVar.a(a, jSONObject, a2, null, anonymousClass1, null, NAME);
                return;
            }
        }
        mVar.x(i, d("fail:url not in domain list", null));
        w.i("MicroMsg.JsApiRequest", "not in domain url %s", new Object[]{optString});
    }
}
