package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class am extends k {
    public static final int CTRL_INDEX = 17;
    public static final String NAME = "getStorageSync";

    public final String a(m mVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("key");
        if (bg.mA(optString)) {
            return d("fail", null);
        }
        MainProcessTask jsApiGetStorageTask = new JsApiGetStorageTask();
        jsApiGetStorageTask.appId = mVar.ivH;
        jsApiGetStorageTask.arH = optString;
        AppBrandMainProcessService.b(jsApiGetStorageTask);
        optString = jsApiGetStorageTask.value == null ? "fail" : "ok";
        Map hashMap = new HashMap();
        hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, jsApiGetStorageTask.value == null ? "" : jsApiGetStorageTask.value);
        hashMap.put("dataType", jsApiGetStorageTask.type == null ? "" : jsApiGetStorageTask.type);
        return d(optString, hashMap);
    }
}
