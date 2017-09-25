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
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e extends k {
    public static final int CTRL_INDEX = 272;
    public static final String NAME = "createUploadTask";

    public static class a extends com.tencent.mm.plugin.appbrand.jsapi.e {
        public static final int CTRL_INDEX = 274;
        public static final String NAME = "onUploadTaskStateChange";
    }

    public final String a(final m mVar, JSONObject jSONObject) {
        w.d("MicroMsg.JsApiCreateUploadTask", "JsApiCreateUploadTask");
        String str = mVar.ivH;
        com.tencent.mm.plugin.appbrand.a.mV(str);
        com.tencent.mm.plugin.appbrand.a.Pm();
        if (jSONObject == null) {
            return d("fail:data is null", null);
        }
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH);
        if (bg.mA(optString)) {
            return d("fail:filePath is null", null);
        }
        w.i("MicroMsg.JsApiCreateUploadTask", "tempFilePath " + optString);
        AppBrandLocalMediaObject aH = c.aH(str, optString);
        if (aH == null) {
            return d("fail:file doesn't exist", null);
        }
        final String str2 = aH.hos;
        String str3 = aH.mimeType;
        w.i("MicroMsg.JsApiCreateUploadTask", "filePath(%s), tempFilePath(%s)", new Object[]{str2, optString});
        h.Vp();
        final int Vl = h.Vl();
        com.tencent.mm.plugin.appbrand.f.f.a anonymousClass1 = new com.tencent.mm.plugin.appbrand.f.f.a(this) {
            final /* synthetic */ e iTN;

            public final void py(String str) {
                if (!e.b(mVar, Vl)) {
                    Map hashMap = new HashMap();
                    hashMap.put("uploadTaskId", Vl);
                    hashMap.put("state", "fail");
                    hashMap.put("errMsg", str);
                    String jSONObject = new JSONObject(hashMap).toString();
                    com.tencent.mm.plugin.appbrand.jsapi.e a = new a().a(mVar);
                    a.mData = jSONObject;
                    a.SR();
                }
            }

            public final void b(int i, String str, int i2) {
                Map hashMap;
                String jSONObject;
                com.tencent.mm.plugin.appbrand.jsapi.e a;
                if (i == 0) {
                    w.d("MicroMsg.JsApiCreateUploadTask", "success: file name %s, result %s , errMsg %d", new Object[]{str2, str, Integer.valueOf(i)});
                    hashMap = new HashMap();
                    hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str);
                    hashMap.put("statusCode", Integer.valueOf(i2));
                    hashMap.put("uploadTaskId", Vl);
                    hashMap.put("state", "success");
                    jSONObject = new JSONObject(hashMap).toString();
                    a = new a().a(mVar);
                    a.mData = jSONObject;
                    a.SR();
                } else if (!e.b(mVar, Vl)) {
                    w.e("MicroMsg.JsApiCreateUploadTask", "error: file name %s, result %s , errMsg %d", new Object[]{str2, str, Integer.valueOf(i)});
                    hashMap = new HashMap();
                    hashMap.put("uploadTaskId", Vl);
                    hashMap.put("state", "fail");
                    hashMap.put("errMsg", str);
                    jSONObject = new JSONObject(hashMap).toString();
                    a = new a().a(mVar);
                    a.mData = jSONObject;
                    a.SR();
                }
            }

            public final void c(int i, long j, long j2) {
                Map hashMap = new HashMap();
                hashMap.put("uploadTaskId", Vl);
                hashMap.put("state", "progressUpdate");
                hashMap.put("progress", Integer.valueOf(i));
                hashMap.put("totalBytesSent", Long.valueOf(j));
                hashMap.put("totalBytesExpectedToSend", Long.valueOf(j2));
                String jSONObject = new JSONObject(hashMap).toString();
                com.tencent.mm.plugin.appbrand.jsapi.e a = new a().a(mVar);
                a.mData = jSONObject;
                a.SR();
            }
        };
        AppBrandSysConfig mY = b.mY(str);
        com.tencent.mm.plugin.appbrand.config.a aVar = mVar.ixr.iwp;
        Map a = i.a(jSONObject, mY);
        String optString2 = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bg.mA(optString2)) {
            w.i("MicroMsg.JsApiCreateUploadTask", "url is null");
            return d("fail:url is null or nil", null);
        } else if (!i.c(mY) || i.b(mY.iFf, optString2)) {
            f fVar;
            if (mY.iEX <= 0) {
                w.i("MicroMsg.JsApiCreateUploadTask", "concurrent <= 0 ");
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
            if (fVar != null) {
                if (i.c(mY)) {
                    fVar.a(a2, str3, str2, jSONObject, a, mY.iFf, anonymousClass1, String.valueOf(Vl), NAME);
                } else {
                    w.i("MicroMsg.JsApiCreateUploadTask", "debug type, do not verify domains");
                    fVar.a(a2, str3, str2, jSONObject, a, null, anonymousClass1, String.valueOf(Vl), NAME);
                }
            }
            Map hashMap = new HashMap();
            hashMap.put("uploadTaskId", String.valueOf(Vl));
            return d("ok", hashMap);
        } else {
            w.i("MicroMsg.JsApiCreateUploadTask", "not in domain url %s", new Object[]{optString2});
            return d("fail:url not in domain list", null);
        }
    }

    public static boolean b(m mVar, String str) {
        f pX = h.Vp().pX(mVar.ivH);
        if (pX == null) {
            w.i("MicroMsg.JsApiCreateUploadTask", "upload is null");
            return true;
        } else if (pX.pW(str) != null) {
            return false;
        } else {
            w.i("MicroMsg.JsApiCreateUploadTask", "uploadInfo is null %s", new Object[]{str});
            return true;
        }
    }
}
