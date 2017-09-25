package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class al extends k {
    public static final int CTRL_INDEX = 113;
    public static final String NAME = "getStorageInfoSync";

    public final String a(m mVar, JSONObject jSONObject) {
        MainProcessTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
        jsApiGetStorageInfoTask.appId = mVar.ivH;
        AppBrandMainProcessService.b(jsApiGetStorageInfoTask);
        Map hashMap = new HashMap();
        hashMap.put("keys", jsApiGetStorageInfoTask.iOf);
        hashMap.put("currentSize", Integer.valueOf(jsApiGetStorageInfoTask.size));
        hashMap.put("limitSize", Integer.valueOf(jsApiGetStorageInfoTask.aIo));
        return d("ok", hashMap);
    }
}
