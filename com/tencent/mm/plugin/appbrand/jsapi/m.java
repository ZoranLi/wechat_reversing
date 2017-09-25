package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m extends a {
    public static final int CTRL_INDEX = 58;
    public static final String NAME = "addCard";
    public int iLf;

    public final void a(final com.tencent.mm.plugin.appbrand.m mVar, JSONObject jSONObject, int i) {
        Intent intent = new Intent();
        Context a = a(mVar);
        if (a == null) {
            mVar.x(i, d("fail", null));
            w.e("MicroMsg.JsApiAddCard", "mmActivity is null, invoke fail!");
            return;
        }
        String optString = jSONObject.optString("cardList");
        if (bg.mA(optString)) {
            mVar.x(i, d("fail", null));
            w.e("MicroMsg.JsApiAddCard", "cardList is null, invoke fail!");
            return;
        }
        this.iLf = i;
        a.uSV = new a(this) {
            final /* synthetic */ m iLh;

            public final void a(int i, int i2, Intent intent) {
                if (i != 1) {
                    return;
                }
                if (i2 == -1) {
                    if (intent == null) {
                        mVar.x(this.iLh.iLf, this.iLh.d("fail", null));
                        w.e("MicroMsg.JsApiAddCard", "location result is empty!");
                        return;
                    }
                    Object jSONArray;
                    Map hashMap = new HashMap();
                    w.d("MicroMsg.JsApiAddCard", "mmSetOnActivityResultCallback cardList:%s", new Object[]{intent.getStringExtra("card_list")});
                    try {
                        jSONArray = new JSONArray(intent.getStringExtra("card_list"));
                    } catch (Throwable e) {
                        w.e("MicroMsg.JsApiAddCard", "parse fail result:%s", new Object[]{bg.g(e)});
                        jSONArray = null;
                    }
                    if (jSONArray != null) {
                        hashMap.put("cardList", jSONArray);
                        mVar.x(this.iLh.iLf, this.iLh.d("ok", hashMap));
                        return;
                    }
                    mVar.x(this.iLh.iLf, this.iLh.d("fail: cardList is empty", hashMap));
                    w.e("MicroMsg.JsApiAddCard", "add card result is fail! cardList is empty");
                } else if (i2 == 0) {
                    mVar.x(this.iLh.iLf, this.iLh.d("cancel", null));
                    w.e("MicroMsg.JsApiAddCard", "add card result is cancel!");
                } else {
                    int intExtra;
                    if (intent != null) {
                        intExtra = intent.getIntExtra("result_code", 2);
                    } else {
                        intExtra = 2;
                    }
                    w.i("MicroMsg.JsApiAddCard", "mmSetOnActivityResultCallback ret_code:%d", new Object[]{Integer.valueOf(intExtra)});
                    if (intExtra == 2) {
                        mVar.x(this.iLh.iLf, this.iLh.d("fail", null));
                    } else {
                        mVar.x(this.iLh.iLf, this.iLh.d("cancel", null));
                    }
                }
            }
        };
        intent.putExtra("key_in_card_list", optString);
        intent.putExtra("key_from_scene", 26);
        AppBrandSysConfig mY = b.mY(mVar.ivH);
        if (!(mY == null || mY.iFk == null)) {
            intent.putExtra("key_from_appbrand_type", mY.iFk.izV);
        }
        d.b(a, "card", ".ui.CardAddEntranceUI", intent, 1);
    }
}
