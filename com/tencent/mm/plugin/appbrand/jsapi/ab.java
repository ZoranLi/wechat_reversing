package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ab extends a {
    public static final int CTRL_INDEX = 101;
    public static final String NAME = "getAppConfig";

    public static class a extends e {
        private static final int CTRL_INDEX = 109;
        private static final String NAME = "onAppConfig";
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            mVar.x(i, d("fail", null));
            w.e("MicroMsg.JsApiGetAppConfig", "data is null");
            return;
        }
        String str = mVar.ivH;
        final int optInt = jSONObject.optInt(Columns.TYPE, 0);
        w.i("MicroMsg.JsApiGetAppConfig", "getAppConfig app_id:%s,type:%d", new Object[]{str, Integer.valueOf(optInt)});
        if (optInt <= 0) {
            mVar.x(i, d("fail", null));
            w.e("MicroMsg.JsApiGetAppConfig", "type %d is invalid", new Object[]{Integer.valueOf(optInt)});
            return;
        }
        final MainProcessTask jsApiGetAppConfigTask = new JsApiGetAppConfigTask();
        jsApiGetAppConfigTask.appId = str;
        jsApiGetAppConfigTask.type = optInt;
        final m mVar2 = mVar;
        final int i2 = i;
        jsApiGetAppConfigTask.iMD = new Runnable(this) {
            final /* synthetic */ ab iMC;

            public final void run() {
                Map hashMap = new HashMap();
                hashMap.put(Columns.TYPE, optInt);
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, jsApiGetAppConfigTask.value);
                w.i("MicroMsg.JsApiGetAppConfig", "getAppConfig type:%d,data:\n%s", new Object[]{Integer.valueOf(optInt), jsApiGetAppConfigTask.value});
                if (bg.mA(jsApiGetAppConfigTask.value)) {
                    mVar2.x(i2, this.iMC.d("fail", null));
                } else {
                    mVar2.x(i2, this.iMC.d("ok", hashMap));
                }
                jsApiGetAppConfigTask.SN();
            }
        };
        jsApiGetAppConfigTask.SM();
        AppBrandMainProcessService.a(jsApiGetAppConfigTask);
    }
}
