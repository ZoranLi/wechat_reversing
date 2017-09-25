package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ak extends a {
    public static final int CTRL_INDEX = 113;
    public static final String NAME = "getStorageInfo";

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        final MainProcessTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
        jsApiGetStorageInfoTask.appId = mVar.ivH;
        jsApiGetStorageInfoTask.iMD = new Runnable(this) {
            final /* synthetic */ ak iOe;

            public final void run() {
                Map hashMap = new HashMap();
                hashMap.put("keys", jsApiGetStorageInfoTask.iOf);
                hashMap.put("currentSize", Integer.valueOf(jsApiGetStorageInfoTask.size));
                hashMap.put("limitSize", Integer.valueOf(jsApiGetStorageInfoTask.aIo));
                mVar.x(i, this.iOe.d("ok", hashMap));
            }
        };
        jsApiGetStorageInfoTask.SM();
        AppBrandMainProcessService.a(jsApiGetStorageInfoTask);
    }
}
