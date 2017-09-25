package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = 117;
    private static final String NAME = "removeSavedFile";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        String str = mVar.ivH;
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH, "");
        if (bg.mA(optString)) {
            str = "fail:invalid data";
        } else {
            AppBrandLocalMediaObject aH = c.aH(str, optString);
            if (aH == null || bg.mA(aH.hos)) {
                str = "fail:file doesn't exist";
            } else {
                b.deleteFile(aH.hos);
                str = "ok";
            }
        }
        mVar.x(i, d(str, null));
    }
}
