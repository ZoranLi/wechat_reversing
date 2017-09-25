package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import org.json.JSONObject;

public final class av extends a {
    public static final int CTRL_INDEX = 102;
    public static final String NAME = "makePhoneCall";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("phoneNumber");
        if (bg.mA(optString)) {
            mVar.x(i, d("fail", null));
            return;
        }
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(Uri.encode(optString)).toString()));
        a(mVar).startActivity(intent);
        mVar.x(i, d("ok", null));
    }
}
