package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 57;
    public static final String NAME = "requestPayment";

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        MMActivity a = a(mVar);
        if (a == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        try {
            jSONObject.put("appId", mVar.ivH);
            d dVar = new d(jSONObject);
            AppBrandStatObject mZ = com.tencent.mm.plugin.appbrand.b.mZ(mVar.ivH);
            if (mZ != null) {
                dVar.fRx = d.dK(mZ.scene, mZ.fWK);
            }
            dVar.fRv = 46;
            e.a(a, dVar, hashCode() & 65535, new MMActivity.a(this) {
                final /* synthetic */ b iTW;

                public final void a(int i, int i2, Intent intent) {
                    if (i == (this.iTW.hashCode() & 65535)) {
                        if (i2 == -1) {
                            mVar.x(i, this.iTW.d("ok", null));
                        } else if (i2 == 5) {
                            Map hashMap = new HashMap();
                            int intExtra = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                            String mz = bg.mz(intent.getStringExtra("key_jsapi_pay_err_msg"));
                            hashMap.put("err_code", Integer.valueOf(intExtra));
                            hashMap.put("err_desc", mz);
                            w.e("MicroMsg.JsApiRequestPayment", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(intExtra), mz});
                            mVar.x(i, this.iTW.d("fail", hashMap));
                        } else {
                            mVar.x(i, this.iTW.d("cancel", null));
                        }
                    }
                }
            });
            String str = dVar.packageExt;
            MainProcessTask reportSubmitFormTask = new ReportSubmitFormTask(mVar.ivH);
            reportSubmitFormTask.type = 0;
            reportSubmitFormTask.iRo = str.replace("prepay_id=", "");
            reportSubmitFormTask.iGe = com.tencent.mm.plugin.appbrand.jsapi.d.b(mVar).jde.jdU;
            AppBrandMainProcessService.a(reportSubmitFormTask);
        } catch (Exception e) {
            w.e("MicroMsg.JsApiRequestPayment", e.getMessage());
            mVar.x(i, d("fail", null));
        }
    }
}
