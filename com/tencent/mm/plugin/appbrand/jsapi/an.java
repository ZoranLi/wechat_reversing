package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class an extends k {
    public static final int CTRL_INDEX = 40;
    public static final String NAME = "getSystemInfo";

    an() {
    }

    public final String a(m mVar, JSONObject jSONObject) {
        int[] iArr;
        Map hashMap = new HashMap();
        hashMap.put("brand", Build.BRAND);
        hashMap.put("model", Build.MODEL);
        hashMap.put("pixelRatio", Float.valueOf(mVar.mContext.getResources().getDisplayMetrics().density));
        if (c(mVar) != null) {
            w.i("MicroMsg.JsApiGetSystemInfo", "Method: normal");
            iArr = new int[]{c(mVar).getWidth(), c(mVar).getHeight()};
        } else if (mVar.mContext instanceof Activity) {
            w.i("MicroMsg.JsApiGetSystemInfo", "Method: DecorView");
            ((Activity) mVar.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
            iArr = new int[]{r2.right - r2.left, (r2.bottom - r2.top) - a.fromDPToPix(mVar.mContext, 48)};
        } else {
            w.i("MicroMsg.JsApiGetSystemInfo", "Method: Screen");
            iArr = new int[]{mVar.mContext.getResources().getDisplayMetrics().widthPixels, mVar.mContext.getResources().getDisplayMetrics().heightPixels};
        }
        hashMap.put("windowWidth", Integer.valueOf(h.iC(iArr[0])));
        hashMap.put("windowHeight", Integer.valueOf(h.iC(iArr[1])));
        hashMap.put("screenWidth", Integer.valueOf(h.iC(mVar.mContext.getResources().getDisplayMetrics().widthPixels)));
        hashMap.put("screenHeight", Integer.valueOf(h.iC(mVar.mContext.getResources().getDisplayMetrics().heightPixels)));
        hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, v.ea(mVar.mContext));
        hashMap.put("version", f.Z(null, d.sYN));
        hashMap.put("system", "Android " + VERSION.RELEASE);
        hashMap.put("fontSizeSetting", Integer.valueOf((int) (MultiProcessSharedPreferences.getSharedPreferences(mVar.mContext, ab.bIX(), 0).getFloat("text_size_scale_key", 1.0f) * 16.0f)));
        return d("ok", hashMap);
    }

    private static View c(m mVar) {
        com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
        return b == null ? null : b.jcb;
    }
}
