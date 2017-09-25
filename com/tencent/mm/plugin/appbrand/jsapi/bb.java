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

public final class bb extends a {
    public static final int CTRL_INDEX = 62;
    public static final String NAME = "openAddress";

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        Intent intent = new Intent();
        intent.putExtra("req_app_id", mVar.ivH);
        intent.putExtra("launch_from_appbrand", true);
        Context a = a(mVar);
        if (a == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        a.uSV = new a(this) {
            final /* synthetic */ bb iOE;

            public final void a(int i, int i2, Intent intent) {
                if (i == (this.iOE.hashCode() & 65535)) {
                    if (i2 == -1 && intent != null) {
                        String ap = bg.ap(intent.getStringExtra("nationalCode"), "");
                        String ap2 = bg.ap(intent.getStringExtra("userName"), "");
                        String ap3 = bg.ap(intent.getStringExtra("telNumber"), "");
                        String ap4 = bg.ap(intent.getStringExtra("addressPostalCode"), "");
                        String ap5 = bg.ap(intent.getStringExtra("proviceFirstStageName"), "");
                        String ap6 = bg.ap(intent.getStringExtra("addressCitySecondStageName"), "");
                        String ap7 = bg.ap(intent.getStringExtra("addressCountiesThirdStageName"), "");
                        String ap8 = bg.ap(intent.getStringExtra("addressDetailInfo"), "");
                        w.i("MicroMsg.JsApiOpenAddress", "first =  " + ap5 + " ; detail =" + ap8 + "; second = " + ap6 + " ; tel = " + ap3 + "; third = " + ap7);
                        if (!bg.mA(ap2)) {
                            Map hashMap = new HashMap();
                            hashMap.put("nationalCode", ap);
                            hashMap.put("userName", ap2);
                            hashMap.put("telNumber", ap3);
                            hashMap.put("addressPostalCode", ap4);
                            hashMap.put("proviceFirstStageName", ap5);
                            hashMap.put("addressCitySecondStageName", ap6);
                            hashMap.put("addressCountiesThirdStageName", ap7);
                            hashMap.put("addressDetailInfo", ap8);
                            mVar.x(i, this.iOE.d("ok", hashMap));
                            return;
                        }
                    }
                    if (i2 == 0) {
                        mVar.x(i, this.iOE.d("cancel", null));
                    } else {
                        mVar.x(i, this.iOE.d("fail", null));
                    }
                }
            }
        };
        d.a(a, "address", ".ui.WalletSelectAddrUI", intent, hashCode() & 65535, false);
    }
}
