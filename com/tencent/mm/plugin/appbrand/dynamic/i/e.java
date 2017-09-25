package com.tencent.mm.plugin.appbrand.dynamic.i;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;

public final class e extends i<f> {
    public static final String iFy = i.a(f.iFJ, "LaunchWxaWidgetRespData");

    public final /* synthetic */ boolean b(c cVar, boolean z, String[] strArr) {
        f fVar = (f) cVar;
        if (!bg.D(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    fVar.field_appIdHash = fVar.field_appId.hashCode();
                    break;
                }
            }
        }
        return super.b(fVar, z, strArr);
    }

    public final /* synthetic */ boolean b(c cVar, String[] strArr) {
        return a((f) cVar, strArr);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, f.iFJ, "LaunchWxaWidgetRespData", f.gaK);
    }

    public final boolean a(f fVar, String... strArr) {
        if (!bg.D(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    fVar.field_appIdHash = fVar.field_appId.hashCode();
                    break;
                }
            }
        }
        return super.b(fVar, strArr);
    }

    public final boolean a(f fVar, boolean z) {
        fVar.field_appIdHash = fVar.field_appId.hashCode();
        super.a(fVar, z);
        return a(fVar, "appId");
    }

    public final boolean a(f fVar, boolean z, String... strArr) {
        if (!bg.D(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    fVar.field_appIdHash = fVar.field_appId.hashCode();
                    break;
                }
            }
        }
        return super.a(fVar, z, strArr);
    }
}
