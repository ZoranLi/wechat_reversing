package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aj extends a {
    public static final int CTRL_INDEX = 17;
    public static final String NAME = "getStorage";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        final long currentTimeMillis = System.currentTimeMillis();
        String optString = jSONObject.optString("key");
        if (bg.mA(optString)) {
            mVar.x(i, d("fail", null));
            return;
        }
        final MainProcessTask jsApiGetStorageTask = new JsApiGetStorageTask();
        jsApiGetStorageTask.appId = mVar.ivH;
        jsApiGetStorageTask.arH = optString;
        final m mVar2 = mVar;
        final int i2 = i;
        jsApiGetStorageTask.iMD = new Runnable(this) {
            final /* synthetic */ aj iOc;

            public final void run() {
                String str = jsApiGetStorageTask.value == null ? "fail" : "ok";
                Map hashMap = new HashMap();
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, jsApiGetStorageTask.value == null ? "" : jsApiGetStorageTask.value);
                hashMap.put("dataType", jsApiGetStorageTask.type == null ? "" : jsApiGetStorageTask.type);
                mVar2.x(i2, this.iOc.d(str, hashMap));
                jsApiGetStorageTask.SN();
                w.i("MicroMsg.JsApiGetStorage", "getStorage: %s, time: %d", new Object[]{jsApiGetStorageTask.arH, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            }
        };
        jsApiGetStorageTask.SM();
        AppBrandMainProcessService.a(jsApiGetStorageTask);
    }
}
