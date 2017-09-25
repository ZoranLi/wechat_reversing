package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bg extends a {
    public static final int CTRL_INDEX = 192;
    public static final String NAME = "openSetting";

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        w.d("MicroMsg.JsApiOpenSetting", "jumpToSettingView!");
        AppBrandSysConfig mY = b.mY(mVar.ivH);
        if (mY == null) {
            w.e("MicroMsg.JsApiOpenSetting", "config is null!");
            mVar.x(i, d("fail", null));
            return;
        }
        Context a = a(mVar);
        if (a == null) {
            mVar.x(i, d("fail", null));
            w.e("MicroMsg.JsApiOpenSetting", "mmActivity is null, invoke fail!");
            return;
        }
        a.uSV = new a(this) {
            final /* synthetic */ bg iOI;

            public final void a(int i, int i2, Intent intent) {
                if (i == 1) {
                    String stringExtra;
                    Object jSONArray;
                    String str = "";
                    if (intent != null) {
                        stringExtra = intent.getStringExtra("key_app_authorize_state");
                    } else {
                        stringExtra = str;
                    }
                    try {
                        jSONArray = new JSONArray(stringExtra);
                    } catch (JSONException e) {
                        jSONArray = new JSONArray();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errMsg", this.iOI.getName() + ":ok");
                        jSONObject.put("authSetting", jSONArray);
                    } catch (Throwable e2) {
                        w.e("MicroMsg.JsApiOpenSetting", "set json error!");
                        w.printErrStackTrace("MicroMsg.JsApiOpenSetting", e2, "", new Object[0]);
                    }
                    mVar.x(i, jSONObject.toString());
                }
            }
        };
        Intent putExtra = new Intent(mVar.mContext, AppBrandAuthorizeUI.class).putExtra("key_username", mY.fCJ);
        putExtra.putExtra("key_app_authorize_jsapi", true);
        d.b(a, "appbrand", ".ui.AppBrandAuthorizeUI", putExtra, 1);
    }
}
