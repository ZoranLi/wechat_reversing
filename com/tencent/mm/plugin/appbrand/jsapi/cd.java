package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import org.json.JSONObject;

public final class cd extends a {
    public static final int CTRL_INDEX = 16;
    public static final String NAME = "setStorage";

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
        String optString3 = jSONObject.optString("dataType");
        if (bg.mA(optString)) {
            mVar.x(i, d("fail", null));
            return;
        }
        if ((optString2 == null ? 0 : optString2.length()) + optString.length() > b.mY(mVar.ivH).iFm.iEr) {
            mVar.x(i, d("fail:entry size limit reached", null));
            return;
        }
        final MainProcessTask jsApiSetStorageTask = new JsApiSetStorageTask();
        jsApiSetStorageTask.appId = mVar.ivH;
        jsApiSetStorageTask.w(optString, optString2, optString3);
        jsApiSetStorageTask.iMD = new Runnable(this) {
            final /* synthetic */ cd iPT;

            public final void run() {
                mVar.x(i, this.iPT.d(jsApiSetStorageTask.result, null));
                jsApiSetStorageTask.SN();
            }
        };
        jsApiSetStorageTask.SM();
        AppBrandMainProcessService.a(jsApiSetStorageTask);
    }
}
