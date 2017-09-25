package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends a {
    private static final int CTRL_INDEX = 115;
    private static final String NAME = "getSavedFileList";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        List<AppBrandLocalMediaObject> nL = com.tencent.mm.plugin.appbrand.appstorage.c.nL(mVar.ivH);
        JSONArray jSONArray = new JSONArray();
        if (!bg.bV(nL)) {
            for (AppBrandLocalMediaObject appBrandLocalMediaObject : nL) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(DownloadInfoColumns.FILEPATH, appBrandLocalMediaObject.fJz);
                    jSONObject2.put("size", appBrandLocalMediaObject.ilG);
                    jSONObject2.put("createTime", appBrandLocalMediaObject.iAU);
                    jSONArray.put(jSONObject2);
                } catch (Exception e) {
                }
            }
        }
        Map hashMap = new HashMap(1);
        hashMap.put("fileList", jSONArray);
        mVar.x(i, d("ok", hashMap));
    }
}
