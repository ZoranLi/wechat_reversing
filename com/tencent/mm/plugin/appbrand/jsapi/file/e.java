package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 51;
    public static final String NAME = "saveFile";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        String str = mVar.ivH;
        String optString = jSONObject.optString("tempFilePath");
        if (bg.mA(optString)) {
            w.e("MicroMsg.JsApiSaveFile", "temp localId is null or nil");
            mVar.x(i, d("fail", null));
            return;
        }
        AppBrandLocalMediaObject aH = c.aH(str, optString);
        boolean z = aH != null && com.tencent.mm.a.e.aO(aH.hos);
        w.i("MicroMsg.JsApiSaveFile", "get temp obj = %s, fileExists = %b", new Object[]{aH, Boolean.valueOf(z)});
        if (!z || bg.mA(aH.hos)) {
            mVar.x(i, d("fail:file doesn't exist", null));
        } else if (aH.iAT) {
            mVar.x(i, d("ok", null));
        } else {
            w.i("MicroMsg.JsApiSaveFile", "before markPermanent, quota = %d, occupation = %d, fileLength = %d", new Object[]{Long.valueOf(h.of(str)), Long.valueOf(c.nO(str)), Long.valueOf(new File(aH.hos).length())});
            if (c.nO(str) + new File(aH.hos).length() > h.of(str)) {
                mVar.x(i, d(String.format(Locale.US, "fail:exceed quota %dM", new Object[]{Long.valueOf(r4 / 1048576)}), null));
                return;
            }
            AppBrandLocalMediaObject a = c.a(aH);
            String str2 = "MicroMsg.JsApiSaveFile";
            String str3 = "after markPermanent, (obj==null): %b, obj.localId: %s, obj.path: %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(a == null);
            objArr[1] = a == null ? null : a.fJz;
            objArr[2] = a == null ? null : a.hos;
            w.i(str2, str3, objArr);
            if (a == null || bg.mA(a.fJz) || bg.mA(a.hos)) {
                mVar.x(i, d("fail", null));
                return;
            }
            Map hashMap = new HashMap(1);
            hashMap.put("savedFilePath", a.fJz);
            mVar.x(i, d("ok", hashMap));
        }
    }
}
