package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 149;
    public static final String NAME = "requestPaymentToBank";

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        Context a = a(mVar);
        if (a == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        try {
            jSONObject.put("appId", mVar.ivH);
            d dVar = new d(jSONObject);
            AppBrandStatObject mZ = b.mZ(mVar.ivH);
            if (mZ != null) {
                dVar.fRx = d.dK(mZ.scene, mZ.fWK);
            }
            dVar.fRv = 46;
            MMActivity.a anonymousClass1 = new MMActivity.a(this) {
                final /* synthetic */ c iTX;

                public final void a(int i, int i2, Intent intent) {
                    if (i == (this.iTX.hashCode() & 65535)) {
                        if (i2 == -1) {
                            Map hashMap = new HashMap();
                            String ap = bg.ap(intent.getStringExtra("token"), "");
                            String ap2 = bg.ap(intent.getStringExtra("bind_serial"), "");
                            hashMap.put("token", ap);
                            hashMap.put("bindSerial", ap2);
                            mVar.x(i, this.iTX.d("ok", hashMap));
                            return;
                        }
                        mVar.x(i, this.iTX.d("fail", null));
                    }
                }
            };
            Intent intent = new Intent();
            intent.putExtra("appId", dVar.appId);
            intent.putExtra("timeStamp", dVar.timeStamp);
            intent.putExtra("nonceStr", dVar.nonceStr);
            intent.putExtra("packageExt", dVar.packageExt);
            intent.putExtra("signtype", dVar.signType);
            intent.putExtra("paySignature", dVar.fRt);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, dVar.url);
            intent.putExtra("pay_scene", dVar.fRw);
            a.uSV = anonymousClass1;
            com.tencent.mm.bb.d.a(a, "wallet", ".pay.ui.WalletLoanRepaymentUI", intent, hashCode() & 65535, false);
        } catch (Exception e) {
            w.e("MicroMsg.JsApiRequestPaymentToBank", e.getMessage());
            mVar.x(i, d("fail", null));
        }
    }
}
