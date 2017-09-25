package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aw extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "measureText";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiMeasureText", "measureText, data is null");
            mVar.x(i, d("fail:data is null", null));
            return;
        }
        Object optString = jSONObject.optString("text");
        int optInt = jSONObject.optInt("fontSize", 16);
        w.i("MicroMsg.JsApiMeasureText", "measureText data:%s", new Object[]{jSONObject.toString()});
        if (TextUtils.isEmpty(optString) || optInt <= 0) {
            w.e("MicroMsg.JsApiMeasureText", "measureText, param is illegal");
            mVar.x(i, d("fail:param is illegal", null));
            return;
        }
        Paint paint = new Paint();
        paint.setTextSize((float) optInt);
        float measureText = paint.measureText(optString);
        w.i("MicroMsg.JsApiMeasureText", "strWidth" + measureText);
        FontMetrics fontMetrics = paint.getFontMetrics();
        w.i("MicroMsg.JsApiMeasureText", "fontMetrics.bottom:%f, fontMetrics.top:%f", new Object[]{Float.valueOf(fontMetrics.bottom), Float.valueOf(fontMetrics.top)});
        w.i("MicroMsg.JsApiMeasureText", "height:%f", new Object[]{Float.valueOf(Math.abs(fontMetrics.bottom - fontMetrics.top))});
        measureText = h.P(measureText);
        float P = h.P(P);
        Map hashMap = new HashMap();
        hashMap.put("width", Float.valueOf(measureText));
        hashMap.put("height", Float.valueOf(P));
        w.i("MicroMsg.JsApiMeasureText", "map:%s", new Object[]{hashMap.toString()});
        mVar.x(i, d("ok", hashMap));
    }
}
