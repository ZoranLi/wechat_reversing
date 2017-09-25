package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.f.i;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class f extends a {
    public static final int CTRL_INDEX = 28;
    public static final String NAME = "downloadFile";

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        final String str = mVar.ivH;
        com.tencent.mm.plugin.appbrand.a.mV(str);
        com.tencent.mm.plugin.appbrand.a.Pm();
        com.tencent.mm.plugin.appbrand.f.a.a anonymousClass1 = new com.tencent.mm.plugin.appbrand.f.a.a(this) {
            final /* synthetic */ f iTO;

            public final void b(int i, String str, String str2, int i2) {
                w.i("MicroMsg.JsApiDownloadFile", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %s", new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2)});
                if (com.tencent.mm.plugin.appbrand.f.a.FAILED != i) {
                    AppBrandLocalMediaObject x = f.x(str, str2, str);
                    if (x != null) {
                        String str3 = x.fJz;
                        w.i("MicroMsg.JsApiDownloadFile", "onDownloadResultWithCode attached tempFilePath " + str3);
                        Map hashMap = new HashMap();
                        hashMap.put("tempFilePath", str3);
                        hashMap.put("statusCode", Integer.valueOf(i2));
                        mVar.x(i, this.iTO.d("ok", hashMap));
                        return;
                    }
                }
                Map hashMap2 = new HashMap();
                hashMap2.put("statusCode", Integer.valueOf(i2));
                mVar.x(i, this.iTO.d("fail", hashMap2));
            }

            public final void b(int i, long j, long j2) {
            }

            public final void px(String str) {
                mVar.x(i, this.iTO.d("fail:" + str, null));
            }
        };
        AppBrandSysConfig mY = b.mY(mVar.ivH);
        com.tencent.mm.plugin.appbrand.config.a aVar = mVar.ixr.iwp;
        Map a = i.a(jSONObject, mY);
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bg.mA(optString)) {
            w.i("MicroMsg.JsApiDownloadFile", "url is null");
            mVar.x(i, d("fail:url is null or nil", null));
        } else if (!i.c(mY) || i.b(mY.iFg, optString)) {
            if (mY.iEY <= 0) {
                w.i("MicroMsg.JsApiDownloadFile", "maxDownloadConcurrent <= 0 ");
            }
            int a2 = i.a(mY, aVar, 3);
            if (a2 <= 0) {
                a2 = 60000;
            }
            com.tencent.mm.plugin.appbrand.f.a pS = com.tencent.mm.plugin.appbrand.f.b.Vm().pS(mVar.ivH);
            if (pS == null) {
                pS = new com.tencent.mm.plugin.appbrand.f.a(mVar.ivH);
                com.tencent.mm.plugin.appbrand.f.b.Vm().a(mVar.ivH, pS);
            }
            if (pS != null) {
                w.i("MicroMsg.JsApiDownloadFile", "before do download, checkDomains = %b", new Object[]{Boolean.valueOf(i.c(mY))});
                pS.a(jSONObject, a2, a, i.c(mY) ? mY.iFg : null, b.mY(str).iFm.iEq, anonymousClass1, null, NAME);
            }
        } else {
            mVar.x(i, d("fail:url not in domain list", null));
            w.i("MicroMsg.JsApiDownloadFile", "not in domain url %s", new Object[]{optString});
        }
    }

    public static AppBrandLocalMediaObject x(String str, String str2, String str3) {
        return c.b(str, str2, s.MB(str3), false);
    }
}
