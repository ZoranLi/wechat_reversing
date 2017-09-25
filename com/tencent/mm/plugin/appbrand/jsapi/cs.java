package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Vibrator;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class cs extends a {
    public static final int CTRL_INDEX = 230;
    public static final String NAME = "vibrateShort";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.d("MicroMsg.JsApiVibrateShort", "JsApiVibrateShort services!");
        bv(mVar.mContext);
        mVar.x(i, d("ok", null));
    }

    public final void a(com.tencent.mm.plugin.appbrand.g.m mVar, JSONObject jSONObject, int i) {
        w.d("MicroMsg.JsApiVibrateShort", "JsApiVibrateShort!");
        bv(mVar.mContext);
        mVar.x(i, d("ok", null));
    }

    private static void bv(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(15);
        }
    }
}
