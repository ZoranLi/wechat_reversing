package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 85;
    public static final String NAME = "verifyPaymentPassword";

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        Context a = a(mVar);
        if (a == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        MMActivity.a anonymousClass1 = new MMActivity.a(this) {
            final /* synthetic */ e iTZ;

            public final void a(int i, int i2, Intent intent) {
                if (i == (this.iTZ.hashCode() & 65535)) {
                    if (i2 == -1) {
                        CharSequence charSequence = "";
                        if (intent != null) {
                            charSequence = bg.ap(intent.getStringExtra("token"), "");
                        }
                        Map hashMap = new HashMap();
                        if (TextUtils.isEmpty(charSequence)) {
                            w.i("MicroMsg.JsApiVerifyPaymentPassword", "checkPwdToken is empty, verifyWCPayPassword:fail");
                            mVar.x(i, this.iTZ.d("fail", null));
                            return;
                        }
                        hashMap.put("token", charSequence);
                        mVar.x(i, this.iTZ.d("ok", hashMap));
                        w.i("MicroMsg.JsApiVerifyPaymentPassword", "checkPwdToken is valid, verifyWCPayPassword:ok");
                        return;
                    }
                    mVar.x(i, this.iTZ.d("fail", null));
                }
            }
        };
        d dVar = new d(jSONObject);
        dVar.appId = mVar.ivH;
        Intent intent = new Intent();
        intent.putExtra("appId", dVar.appId);
        intent.putExtra("timeStamp", dVar.timeStamp);
        intent.putExtra("nonceStr", dVar.nonceStr);
        intent.putExtra("packageExt", dVar.packageExt);
        intent.putExtra("signtype", dVar.signType);
        intent.putExtra("paySignature", dVar.fRt);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, dVar.url);
        intent.putExtra("scene", 1);
        a.uSV = anonymousClass1;
        com.tencent.mm.bb.d.a(a, "wallet_core", ".ui.WalletCheckPwdUI", intent, hashCode() & 65535, false);
    }
}
