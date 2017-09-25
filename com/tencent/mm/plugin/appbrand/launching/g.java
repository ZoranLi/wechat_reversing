package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class g extends i<h> {
    public static final String iFy = i.a(h.iFJ, "LaunchWxaAppRespTable");

    public final /* synthetic */ boolean a(c cVar, boolean z, String[] strArr) {
        return b((h) cVar, z, strArr);
    }

    public final /* synthetic */ boolean b(c cVar, boolean z, String[] strArr) {
        return a((h) cVar, z, strArr);
    }

    public final /* synthetic */ boolean b(c cVar, String[] strArr) {
        return a((h) cVar, strArr);
    }

    public g(e eVar) {
        super(eVar, h.iFJ, "LaunchWxaAppRespTable", h.gaK);
    }

    public final boolean a(h hVar, boolean z, String... strArr) {
        if (!bg.D(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    hVar.field_appIdHash = hVar.field_appId.hashCode();
                    break;
                }
            }
        }
        return super.b(hVar, z, strArr);
    }

    public final boolean a(h hVar, String... strArr) {
        if (!bg.D(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    hVar.field_appIdHash = hVar.field_appId.hashCode();
                    break;
                }
            }
        }
        return super.b(hVar, strArr);
    }

    public final boolean a(h hVar, boolean z) {
        hVar.field_appIdHash = hVar.field_appId.hashCode();
        super.a(hVar, z);
        w.i("MicroMsg.LaunchWxaAppCacheStorage", "insertNotify appId %s ret %B", new Object[]{hVar.field_appId, Boolean.valueOf(a(hVar, "appId"))});
        return a(hVar, "appId");
    }

    public final boolean b(h hVar, boolean z, String... strArr) {
        if (!bg.D(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    hVar.field_appIdHash = hVar.field_appId.hashCode();
                    break;
                }
            }
        }
        w.i("MicroMsg.LaunchWxaAppCacheStorage", "updateNotify appId %s, ret %B", new Object[]{hVar.field_appId, Boolean.valueOf(super.a(hVar, z, strArr))});
        return super.a(hVar, z, strArr);
    }
}
