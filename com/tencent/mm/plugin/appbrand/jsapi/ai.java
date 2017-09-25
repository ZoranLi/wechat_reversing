package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ai extends a {
    public static final int CTRL_INDEX = 232;
    public static final String NAME = "getScreenBrightness";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.d("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness!");
        Context a = a(mVar);
        if (a == null) {
            mVar.x(i, d("fail", null));
            w.e("MicroMsg.JsApiGetScreenBrightness", "context is null, invoke fail!");
            return;
        }
        float f = a.getWindow().getAttributes().screenBrightness;
        if (f < 0.0f) {
            f = bu(a);
        }
        Map hashMap = new HashMap();
        hashMap.put(Columns.VALUE, Float.valueOf(f));
        mVar.x(i, d("ok", hashMap));
    }

    private static float bu(Context context) {
        float f = 0.0f;
        try {
            return ((float) System.getInt(context.getContentResolver(), "screen_brightness")) / 255.0f;
        } catch (SettingNotFoundException e) {
            return f;
        }
    }
}
