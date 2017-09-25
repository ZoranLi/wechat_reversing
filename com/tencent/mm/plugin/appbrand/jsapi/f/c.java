package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.f.i;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class c extends k {
    public static final int CTRL_INDEX = 269;
    public static final String NAME = "createDownloadTask";

    public static class a extends e {
        public static final int CTRL_INDEX = 271;
        public static final String NAME = "onDownloadTaskStateChange";
    }

    public final String a(final m mVar, JSONObject jSONObject) {
        w.d("MicroMsg.JsApiCreateDownloadTask", "JsApiCreateDownloadTask");
        final String str = mVar.ivH;
        com.tencent.mm.plugin.appbrand.a.mV(str);
        com.tencent.mm.plugin.appbrand.a.Pm();
        b.Vm();
        final int Vl = b.Vl();
        com.tencent.mm.plugin.appbrand.f.a.a anonymousClass1 = new com.tencent.mm.plugin.appbrand.f.a.a(this) {
            final /* synthetic */ c iTI;

            public final void b(int i, String str, String str2, int i2) {
                w.i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %s", new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2)});
                if (com.tencent.mm.plugin.appbrand.f.a.FAILED != i) {
                    AppBrandLocalMediaObject x = c.x(str, str2, str);
                    if (x != null) {
                        String str3 = x.fJz;
                        w.i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode attached tempFilePath " + str3);
                        Map hashMap = new HashMap();
                        hashMap.put("downloadTaskId", Vl);
                        hashMap.put("tempFilePath", str3);
                        hashMap.put("statusCode", Integer.valueOf(i2));
                        hashMap.put("state", "success");
                        str3 = new JSONObject(hashMap).toString();
                        e a = new a().a(mVar);
                        a.mData = str3;
                        a.SR();
                        return;
                    }
                }
                if (!c.a(mVar, Vl)) {
                    Map hashMap2 = new HashMap();
                    hashMap2.put("downloadTaskId", Vl);
                    hashMap2.put("state", "fail");
                    hashMap2.put("errMsg", "download fail");
                    str3 = new JSONObject(hashMap2).toString();
                    a = new a().a(mVar);
                    a.mData = str3;
                    a.SR();
                }
            }

            public final void b(int i, long j, long j2) {
                Map hashMap = new HashMap();
                hashMap.put("downloadTaskId", Vl);
                hashMap.put("state", "progressUpdate");
                hashMap.put("progress", Integer.valueOf(i));
                hashMap.put("totalBytesWritten", Long.valueOf(j));
                hashMap.put("totalBytesExpectedToWrite", Long.valueOf(j2));
                String jSONObject = new JSONObject(hashMap).toString();
                e a = new a().a(mVar);
                a.mData = jSONObject;
                a.SR();
            }

            public final void px(String str) {
                if (!c.a(mVar, Vl)) {
                    Map hashMap = new HashMap();
                    hashMap.put("downloadTaskId", Vl);
                    hashMap.put("state", "fail");
                    hashMap.put("errMsg", str);
                    String jSONObject = new JSONObject(hashMap).toString();
                    e a = new a().a(mVar);
                    a.mData = jSONObject;
                    a.SR();
                }
            }
        };
        AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(mVar.ivH);
        com.tencent.mm.plugin.appbrand.config.a aVar = mVar.ixr.iwp;
        Map a = i.a(jSONObject, mY);
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bg.mA(optString)) {
            w.i("MicroMsg.JsApiCreateDownloadTask", "url is null");
            return d("fail:url is null or nil", null);
        } else if (!i.c(mY) || i.b(mY.iFg, optString)) {
            if (mY.iEY <= 0) {
                w.i("MicroMsg.JsApiCreateDownloadTask", "maxDownloadConcurrent <= 0 ");
            }
            int a2 = i.a(mY, aVar, 3);
            if (a2 <= 0) {
                a2 = 60000;
            }
            com.tencent.mm.plugin.appbrand.f.a pS = b.Vm().pS(mVar.ivH);
            if (pS == null) {
                pS = new com.tencent.mm.plugin.appbrand.f.a(mVar.ivH);
                b.Vm().a(mVar.ivH, pS);
            }
            if (pS != null) {
                w.i("MicroMsg.JsApiCreateDownloadTask", "before do download, checkDomains = %b", new Object[]{Boolean.valueOf(i.c(mY))});
                pS.a(jSONObject, a2, a, i.c(mY) ? mY.iFg : null, com.tencent.mm.plugin.appbrand.b.mY(str).iFm.iEq, anonymousClass1, String.valueOf(Vl), NAME);
            }
            Map hashMap = new HashMap();
            hashMap.put("downloadTaskId", String.valueOf(Vl));
            return d("ok", hashMap);
        } else {
            w.i("MicroMsg.JsApiCreateDownloadTask", "not in domain url %s", new Object[]{optString});
            return d("fail:url not in domain list", null);
        }
    }

    public static AppBrandLocalMediaObject x(String str, String str2, String str3) {
        return com.tencent.mm.plugin.appbrand.appstorage.c.b(str, str2, s.MB(str3), false);
    }

    public static boolean a(m mVar, String str) {
        com.tencent.mm.plugin.appbrand.f.a pS = b.Vm().pS(mVar.ivH);
        if (pS == null) {
            w.i("MicroMsg.JsApiCreateDownloadTask", "download is null");
            return true;
        } else if (pS.pR(str) != null) {
            return false;
        } else {
            w.i("MicroMsg.JsApiCreateDownloadTask", "downloadWorker is null %s", new Object[]{str});
            return true;
        }
    }
}
