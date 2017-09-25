package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n extends a {
    public static final int CTRL_BYTE = 28;
    public static final String NAME = "getBrandWCPayRequest";

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        w.i("MicroMsg.GameJsApiGetBrandWCPayRequest", "invoke");
        MMActivity azK = dVar.azK();
        if (jSONObject == null) {
            w.i("MicroMsg.GameJsApiGetBrandWCPayRequest", "data is null");
            dVar.x(i, a.d("get_brand_wcpay_request:fail_invalid_data", null));
            return;
        }
        e.a(azK, new com.tencent.mm.pluginsdk.wallet.d(jSONObject), hashCode() & 65535, new MMActivity.a(this) {
            final /* synthetic */ n mkq;

            public final void a(int i, int i2, Intent intent) {
                if (i == (this.mkq.hashCode() & 65535)) {
                    d dVar;
                    int i3;
                    n nVar;
                    if (i2 == -1) {
                        dVar = dVar;
                        i3 = i;
                        nVar = this.mkq;
                        dVar.x(i3, a.d("ok", null));
                    } else if (i2 == 5) {
                        Map hashMap = new HashMap();
                        i3 = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                        String mz = bg.mz(intent.getStringExtra("key_jsapi_pay_err_msg"));
                        hashMap.put("err_code", Integer.valueOf(i3));
                        hashMap.put("err_desc", mz);
                        w.e("MicroMsg.GameJsApiGetBrandWCPayRequest", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i3), mz});
                        dVar.x(i, a.d("get_brand_wcpay_request:fail", hashMap));
                    } else {
                        dVar = dVar;
                        i3 = i;
                        nVar = this.mkq;
                        dVar.x(i3, a.d("get_brand_wcpay_request:cancel", null));
                    }
                }
            }
        });
    }
}
