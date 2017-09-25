package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import org.json.JSONObject;

public final class bn extends a {
    public static final int CTRL_INDEX = 98;
    public static final String NAME = "removeStorage";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("key");
        if (bg.mA(optString)) {
            mVar.x(i, d("fail", null));
            return;
        }
        MainProcessTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
        jsApiRemoveStorageTask.appId = mVar.ivH;
        jsApiRemoveStorageTask.arH = optString;
        AppBrandMainProcessService.a(jsApiRemoveStorageTask);
        mVar.x(i, d("ok", null));
    }
}
