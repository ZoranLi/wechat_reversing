package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import org.json.JSONObject;

public final class u extends k {
    public static final int CTRL_INDEX = 18;
    public static final String NAME = "clearStorageSync";

    public final String a(m mVar, JSONObject jSONObject) {
        MainProcessTask jsApiClearStorageTask = new JsApiClearStorageTask();
        jsApiClearStorageTask.appId = mVar.ivH;
        AppBrandMainProcessService.b(jsApiClearStorageTask);
        return d("ok", null);
    }
}
