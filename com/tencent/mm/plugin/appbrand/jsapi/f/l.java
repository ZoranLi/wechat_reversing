package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.f.f;
import com.tencent.mm.plugin.appbrand.f.h;
import com.tencent.mm.plugin.appbrand.f.i;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class l extends a {
    public static final int CTRL_INDEX = 27;
    public static final String NAME = "uploadFile";

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        String str = mVar.ivH;
        com.tencent.mm.plugin.appbrand.a.mV(str);
        com.tencent.mm.plugin.appbrand.a.Pm();
        if (jSONObject == null) {
            mVar.x(i, d("fail:data is null", null));
            return;
        }
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH);
        if (bg.mA(optString)) {
            mVar.x(i, d("fail:filePath is null", null));
            return;
        }
        w.i("MicroMsg.JsApiUploadFile", "tempFilePath " + optString);
        AppBrandLocalMediaObject aH = c.aH(str, optString);
        if (aH == null) {
            mVar.x(i, d("fail:file doesn't exist", null));
            return;
        }
        final String str2 = aH.hos;
        String str3 = aH.mimeType;
        w.i("MicroMsg.JsApiUploadFile", "filePath(%s), tempFilePath(%s)", new Object[]{str2, optString});
        f.a anonymousClass1 = new f.a(this) {
            final /* synthetic */ l iTQ;

            public final void py(String str) {
                new HashMap().put(SlookAirButtonFrequentContactAdapter.DATA, str);
                w.e("MicroMsg.JsApiUploadFile", "error: file name %s, result %s , errMsg %d", new Object[]{str2, str, Integer.valueOf(-1)});
                mVar.x(i, this.iTQ.d("fail:" + str, null));
            }

            public final void b(int i, String str, int i2) {
                Map hashMap = new HashMap();
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str);
                hashMap.put("statusCode", Integer.valueOf(i2));
                if (i == 0) {
                    w.d("MicroMsg.JsApiUploadFile", "success: file name %s, result %s , errMsg %d", new Object[]{str2, str, Integer.valueOf(i)});
                    mVar.x(i, this.iTQ.d("ok", hashMap));
                    return;
                }
                w.e("MicroMsg.JsApiUploadFile", "error: file name %s, result %s , errMsg %d", new Object[]{str2, str, Integer.valueOf(i)});
                mVar.x(i, this.iTQ.d("fail:" + str, hashMap));
            }

            public final void c(int i, long j, long j2) {
            }
        };
        AppBrandSysConfig mY = b.mY(str);
        com.tencent.mm.plugin.appbrand.config.a aVar = mVar.ixr.iwp;
        Map a = i.a(jSONObject, mY);
        String optString2 = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bg.mA(optString2)) {
            w.i("MicroMsg.JsApiUploadFile", "url is null");
            mVar.x(i, d("fail:url is null or nil", null));
        } else if (!i.c(mY) || i.b(mY.iFf, optString2)) {
            f fVar;
            if (mY.iEX <= 0) {
                w.i("MicroMsg.JsApiUploadFile", "concurrent <= 0 ");
            }
            int a2 = i.a(mY, aVar, 2);
            if (a2 <= 0) {
                a2 = 60000;
            }
            if (h.Vp().pX(str) == null) {
                fVar = new f(str);
                h.Vp().a(str, fVar);
            } else {
                fVar = h.Vp().pX(str);
            }
            if (fVar == null) {
                return;
            }
            if (i.c(mY)) {
                fVar.a(a2, str3, str2, jSONObject, a, mY.iFf, anonymousClass1, null, NAME);
                return;
            }
            w.i("MicroMsg.JsApiUploadFile", "debug type, do not verify domains");
            fVar.a(a2, str3, str2, jSONObject, a, null, anonymousClass1, null, NAME);
        } else {
            mVar.x(i, d("fail:url not in domain list", null));
            w.i("MicroMsg.JsApiUploadFile", "not in domain url %s", new Object[]{optString2});
        }
    }
}
