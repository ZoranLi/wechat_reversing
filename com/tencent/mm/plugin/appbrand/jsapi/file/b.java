package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 116;
    private static final String NAME = "getSavedFileInfo";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        String str = mVar.ivH;
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH, "");
        if (bg.mA(optString)) {
            mVar.x(i, d("fail:invalid data", null));
            return;
        }
        AppBrandLocalMediaObject aH = c.aH(str, optString);
        if (aH == null) {
            mVar.x(i, d("fail:file doesn't exist", null));
            return;
        }
        File file = new File(aH.hos);
        Map hashMap = new HashMap(3);
        hashMap.put("size", Long.valueOf(file.length()));
        hashMap.put("createTime", Long.valueOf(file.lastModified()));
        mVar.x(i, d("ok", hashMap));
    }
}
