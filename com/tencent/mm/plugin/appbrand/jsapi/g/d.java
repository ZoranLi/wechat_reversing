package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 218;
    public static final String NAME = "sendBizRedPacket";

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        Context a = a(mVar);
        if (a == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        try {
            jSONObject.put("appId", mVar.ivH);
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(jSONObject);
            dVar.fRx = 16;
            MMActivity.a anonymousClass1 = new MMActivity.a(this) {
                final /* synthetic */ d iTY;

                public final void a(int i, int i2, Intent intent) {
                    if (i == (this.iTY.hashCode() & 65535)) {
                        if (i2 == -1) {
                            mVar.x(i, this.iTY.d("ok", null));
                        } else {
                            mVar.x(i, this.iTY.d("fail", null));
                        }
                    }
                }
            };
            Intent intent = new Intent();
            intent.putExtra("key_way", 3);
            intent.putExtra("appId", dVar.appId);
            intent.putExtra("timeStamp", dVar.timeStamp);
            intent.putExtra("nonceStr", dVar.nonceStr);
            intent.putExtra("packageExt", dVar.packageExt);
            intent.putExtra("signtype", dVar.signType);
            intent.putExtra("paySignature", dVar.fRt);
            intent.putExtra("key_static_from_scene", 100004);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, dVar.url);
            a.uSV = anonymousClass1;
            com.tencent.mm.bb.d.a(a, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent, hashCode() & 65535, false);
        } catch (Exception e) {
            w.e("MicroMsg.JsApiSendBizRedPacket", e.getMessage());
            mVar.x(i, d("fail", null));
        }
    }
}
