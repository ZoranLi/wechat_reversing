package com.tencent.mm.plugin.appbrand.dynamic.i;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bg;

public final class i extends com.tencent.mm.sdk.e.i<h> {
    public static final String[] iCe = new String[]{com.tencent.mm.sdk.e.i.a(h.izp, "WxaWidgetInfo")};
    public static final String[] iIA = new String[0];

    public i(e eVar) {
        super(eVar, h.izp, "WxaWidgetInfo", iIA);
    }

    public final h oT(String str) {
        if (bg.mA(str)) {
            return null;
        }
        c hVar = new h();
        hVar.field_appId = str;
        hVar.field_appIdHash = str.hashCode();
        if (b(hVar, new String[]{"appIdHash"})) {
            return hVar;
        }
        return null;
    }
}
