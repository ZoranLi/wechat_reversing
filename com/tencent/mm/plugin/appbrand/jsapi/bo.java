package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import org.json.JSONObject;

public final class bo extends k {
    public static final int CTRL_INDEX = 98;
    public static final String NAME = "removeStorageSync";

    public final String a(m mVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("key");
        if (bg.mA(optString)) {
            return d("fail", null);
        }
        MainProcessTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
        jsApiRemoveStorageTask.appId = mVar.ivH;
        jsApiRemoveStorageTask.arH = optString;
        AppBrandMainProcessService.b(jsApiRemoveStorageTask);
        return d("ok", null);
    }
}
