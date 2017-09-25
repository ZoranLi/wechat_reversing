package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.launching.r.a;
import com.tencent.mm.sdk.platformtools.bg;

final class q {

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] iZM = new int[a.values().length];

        static {
            try {
                iZM[a.Ok.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iZM[a.Timeout.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    static String ah(String str, int i) {
        i a = c.PY().a(str, i, "versionMd5", "pkgPath");
        if (a == null || bg.mA(a.field_pkgPath) || !e.aO(a.field_pkgPath) || bg.mA(a.field_versionMd5) || !a.field_pkgPath.equals(g.aV(a.field_pkgPath))) {
            return null;
        }
        return a.field_versionMd5;
    }
}
