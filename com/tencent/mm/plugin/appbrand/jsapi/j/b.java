package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.m;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 238;
    private static final String NAME = "setNavigationBarRightButton";

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] iVM = new int[com.tencent.mm.plugin.appbrand.g.a.a.Vv().length];

        static {
            try {
                iVM[com.tencent.mm.plugin.appbrand.g.a.a.jbR - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iVM[com.tencent.mm.plugin.appbrand.g.a.a.jbO - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iVM[com.tencent.mm.plugin.appbrand.g.a.a.jbP - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iVM[com.tencent.mm.plugin.appbrand.g.a.a.jbQ - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        boolean optBoolean = jSONObject.optBoolean("hide", false);
        int a = com.tencent.mm.plugin.appbrand.g.a.a(d.b(mVar), jSONObject.optString("text", ""), jSONObject.optString("iconPath", ""), optBoolean);
        String str = "fail";
        switch (AnonymousClass1.iVM[a - 1]) {
            case 1:
                str = "ok";
                break;
            case 2:
                str = "fail no page available";
                break;
            case 3:
                str = "fail iconPath not found";
                break;
            case 4:
                str = "fail invalid text length";
                break;
        }
        mVar.x(i, d(str, null));
    }
}
