package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 152;
    public static final String NAME = "getContactMessageCount";

    public static class a extends e {
        private static final int CTRL_INDEX = 152;
        private static final String NAME = "onContactMessageCountChange";
    }

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        String str = "";
        AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(mVar.ivH);
        if (mY != null) {
            str = mY.fCJ;
        }
        if (bg.mA(str)) {
            w.e("MicroMsg.JsApiGetAppConfig", "getContactMessageCount username is empty!!!");
        }
        final MainProcessTask jsApiGetContactMessageCountTask = new JsApiGetContactMessageCountTask();
        jsApiGetContactMessageCountTask.username = str;
        jsApiGetContactMessageCountTask.iMD = new Runnable(this) {
            final /* synthetic */ b iSi;

            public final void run() {
                Map hashMap = new HashMap();
                hashMap.put("count", jsApiGetContactMessageCountTask.fCK);
                w.i("MicroMsg.JsApiGetAppConfig", "JsApiGetContactMessageCountTask unreadCount:%d", new Object[]{Integer.valueOf(jsApiGetContactMessageCountTask.fCK)});
                if (jsApiGetContactMessageCountTask.fCK == -1) {
                    mVar.x(i, this.iSi.d("fail", null));
                } else {
                    mVar.x(i, this.iSi.d("ok", hashMap));
                }
                jsApiGetContactMessageCountTask.SN();
            }
        };
        jsApiGetContactMessageCountTask.SM();
        AppBrandMainProcessService.a(jsApiGetContactMessageCountTask);
    }
}
