package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import org.json.JSONObject;

public final class ce extends k {
    public static final int CTRL_INDEX = 16;
    public static final String NAME = "setStorageSync";

    public final String a(m mVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
        String optString3 = jSONObject.optString("dataType");
        if (bg.mA(optString)) {
            return d("fail", null);
        }
        if ((optString2 == null ? 0 : optString2.length()) + optString.length() > b.mY(mVar.ivH).iFm.iEr) {
            return d("fail:entry size limit reached", null);
        }
        String str = "fail";
        MainProcessTask jsApiSetStorageTask = new JsApiSetStorageTask();
        jsApiSetStorageTask.appId = mVar.ivH;
        jsApiSetStorageTask.w(optString, optString2, optString3);
        if (AppBrandMainProcessService.b(jsApiSetStorageTask)) {
            str = jsApiSetStorageTask.result;
        }
        return d(str, null);
    }
}
