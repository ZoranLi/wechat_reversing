package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class bw extends a {
    public static final int CTRL_INDEX = 168;
    public static final String NAME = "setClipboardData";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        CharSequence optString = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
        if (bg.mA(optString)) {
            mVar.x(i, d("fail", null));
            return;
        }
        w.d("MicroMsg.JsApiSetClipboardData", "stevyang dataStr %s", new Object[]{optString});
        ClipboardManager clipboardManager = (ClipboardManager) mVar.mContext.getSystemService("clipboard");
        if (clipboardManager == null) {
            w.i("MicroMsg.JsApiSetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
            mVar.x(i, d("fail", null));
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText("text", optString));
        mVar.x(i, d("ok", null));
    }
}
