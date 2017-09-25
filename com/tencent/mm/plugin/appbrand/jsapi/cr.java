package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Vibrator;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class cr extends a {
    public static final int CTRL_INDEX = 231;
    public static final String NAME = "vibrateLong";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.d("MicroMsg.JsApiVibrateLong", "JsApiVibrateLong!");
        Vibrator vibrator = (Vibrator) mVar.mContext.getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(400);
        }
        mVar.x(i, d("ok", null));
    }
}
