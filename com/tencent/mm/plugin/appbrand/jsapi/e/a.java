package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONObject;

abstract class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    abstract boolean k(Context context, String str, String str2);

    abstract boolean pt(String str);

    a() {
    }

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        final String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH, "");
        if (bg.mA(optString)) {
            mVar.x(i, d("fail filePath invalid", null));
        } else {
            d.vL().D(new Runnable(this) {
                final /* synthetic */ a iTB;

                public final void run() {
                    AppBrandLocalMediaObject aH = c.aH(mVar.ivH, optString);
                    if (aH == null || bg.mA(aH.hos)) {
                        mVar.x(i, this.iTB.d("fail file not exists", null));
                    } else if (this.iTB.pt(aH.mimeType)) {
                        boolean z = false;
                        if (mVar.aaI) {
                            Context a = this.iTB.a(mVar);
                            if (a != null) {
                                z = this.iTB.k(a, aH.hos, aH.mimeType);
                            }
                        }
                        mVar.x(i, this.iTB.d(z ? "ok" : "fail", null));
                    } else {
                        mVar.x(i, this.iTB.d("fail invalid file type", null));
                    }
                }
            });
        }
    }
}
