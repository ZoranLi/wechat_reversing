package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONObject;

public final class bc extends a {
    public static final int CTRL_INDEX = 59;
    public static final String NAME = "openCard";
    public int iLf;

    public final void a(final m mVar, JSONObject jSONObject, int i) {
        Intent intent = new Intent();
        Context a = a(mVar);
        if (a == null) {
            mVar.x(i, d("fail", null));
            w.e("MicroMsg.JsApiOpenCard", "mmActivity is null, invoke fail!");
            return;
        }
        String optString = jSONObject.optString("cardList");
        if (bg.mA(optString)) {
            mVar.x(i, d("fail", null));
            w.e("MicroMsg.JsApiOpenCard", "cardList is null, invoke fail!");
            return;
        }
        this.iLf = i;
        a.uSV = new a(this) {
            final /* synthetic */ bc iOF;

            public final void a(int i, int i2, Intent intent) {
                if (i != 1 || i2 != -1) {
                    return;
                }
                if (i2 == -1) {
                    mVar.x(this.iOF.iLf, this.iOF.d("ok", null));
                    w.i("MicroMsg.JsApiOpenCard", "view card result is cancel!");
                } else if (i2 == 0) {
                    mVar.x(this.iOF.iLf, this.iOF.d("cancel", null));
                    w.e("MicroMsg.JsApiOpenCard", "view card result is cancel!");
                } else {
                    mVar.x(this.iOF.iLf, this.iOF.d("fail", null));
                    w.e("MicroMsg.JsApiOpenCard", "view card result is fail!");
                }
            }
        };
        intent.putExtra("card_list", optString);
        intent.putExtra("key_from_scene", 26);
        AppBrandSysConfig mY = b.mY(mVar.ivH);
        if (!(mY == null || mY.iFk == null)) {
            intent.putExtra("key_from_appbrand_type", mY.iFk.izV);
        }
        d.b(a, "card", ".ui.CardViewEntranceUI", intent, 1);
    }
}
