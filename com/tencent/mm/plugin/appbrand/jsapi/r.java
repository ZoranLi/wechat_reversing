package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class r extends a {
    public static final int CTRL_INDEX = 286;
    public static final String NAME = "chooseInvoiceTitle";

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        Intent intent = new Intent();
        intent.putExtra("req_scene", 0);
        intent.putExtra("launch_from_appbrand", true);
        Context a = a(mVar);
        if (a == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        a.uSV = new a(this) {
            final /* synthetic */ r iLI;

            public final void a(int i, int i2, Intent intent) {
                if (i == (this.iLI.hashCode() & 65535)) {
                    if (i2 == -1 && intent != null) {
                        Map hashMap = new HashMap();
                        String ap = bg.ap(intent.getStringExtra("choose_invoice_title_info"), "");
                        w.i("MicroMsg.JsApiChooseInvoiceTitle", "choose_invoice_title_info is : " + ap);
                        hashMap.put("choose_invoice_title_info", ap);
                        mVar.x(i, this.iLI.d("ok", hashMap));
                    } else if (i2 == 0) {
                        mVar.x(i, this.iLI.d("cancel", null));
                    } else {
                        mVar.x(i, this.iLI.d("fail", null));
                    }
                }
            }
        };
        d.a(a, "address", ".ui.InvoiceListUI", intent, hashCode() & 65535, false);
    }
}
