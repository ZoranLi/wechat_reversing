package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import org.json.JSONObject;

public final class t extends a {
    public static final int CTRL_INDEX = 18;
    public static final String NAME = "clearStorage";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        MainProcessTask jsApiClearStorageTask = new JsApiClearStorageTask();
        jsApiClearStorageTask.appId = mVar.ivH;
        AppBrandMainProcessService.a(jsApiClearStorageTask);
        mVar.x(i, d("ok", null));
    }
}
