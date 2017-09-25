package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 277;
    public static final String NAME = "startSoterAuthentication";

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        w.i("MicroMsg.JsApiStartSoterAuthentication", "hy: JsApiStartSoterAuthentication");
        super.a(mVar, jSONObject, i);
        Context a = a(mVar);
        if (a == null) {
            w.e("MicroMsg.JsApiStartSoterAuthentication", "JsApiStartSoterAuthentication context is null, appId is %s", new Object[]{mVar.ivH});
            mVar.x(i, d("fail", null));
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("requestAuthModes");
        String optString = jSONObject.optString("challenge");
        String optString2 = jSONObject.optString("authContent");
        Intent intent = new Intent();
        intent.putExtra("auth_mode", a.h(optJSONArray));
        intent.putExtra("challenge", optString);
        intent.putExtra("auth_content", optString2);
        intent.putExtra("key_soter_fp_mp_scene", 0);
        a.uSV = new MMActivity.a(this) {
            final /* synthetic */ b iRC;

            public final void a(int i, int i2, Intent intent) {
                Bundle bundle = null;
                if (i != 1000) {
                    return;
                }
                b bVar;
                m mVar;
                int i3;
                if (i2 == -1) {
                    w.i("MicroMsg.JsApiStartSoterAuthentication", "hy: soter auth ok");
                    bVar = this.iRC;
                    mVar = mVar;
                    i3 = i;
                    if (intent != null) {
                        bundle = intent.getExtras();
                    }
                    bVar.a(mVar, i3, bundle, "ok");
                } else if (i2 == 1) {
                    w.w("MicroMsg.JsApiStartSoterAuthentication", "hy: soter auth failed");
                    bVar = this.iRC;
                    mVar = mVar;
                    i3 = i;
                    if (intent != null) {
                        bundle = intent.getExtras();
                    }
                    bVar.a(mVar, i3, bundle, "fail");
                } else {
                    w.e("MicroMsg.JsApiStartSoterAuthentication", "hy: soter user cancelled");
                    bVar = this.iRC;
                    mVar = mVar;
                    i3 = i;
                    if (intent != null) {
                        bundle = intent.getExtras();
                    }
                    bVar.a(mVar, i3, bundle, "cancel");
                }
            }
        };
        d.b(a, "soter_mp", ".ui.SoterAuthenticationUI", intent, 1000);
    }

    public final void a(m mVar, int i, Bundle bundle, String str) {
        int i2;
        String string;
        Object string2;
        Object string3;
        int i3;
        String str2 = "not returned";
        String str3 = "";
        String str4 = "";
        if (bundle != null) {
            i2 = bundle.getInt("err_code");
            string = bundle.getString("err_msg");
            string2 = bundle.getString("result_json");
            string3 = bundle.getString("result_json_signature");
            i3 = bundle.getByte("use_mode");
        } else {
            i2 = -1;
            string = str2;
            str2 = str3;
            str3 = str4;
            i3 = 0;
        }
        JSONArray hM = a.hM(i3);
        Object obj = "";
        if (hM.length() > 0) {
            try {
                obj = hM.getString(0);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.JsApiStartSoterAuthentication", e, "hy: json error in callback", new Object[0]);
            }
        }
        Map hashMap = new HashMap(5);
        hashMap.put("authMode", obj);
        hashMap.put("errCode", Integer.valueOf(i2));
        hashMap.put("resultJSON", string2);
        hashMap.put("resultJSONSignature", string3);
        if ("fail".equals(str)) {
            str = str + " " + string;
        }
        mVar.x(i, d(str, hashMap));
    }
}
