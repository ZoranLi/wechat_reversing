package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;

@Deprecated
final class l {
    public static final String[] iFw = new String[]{a.iFy};
    private final a iFx;
    final g izH;

    private static final class a extends i<m> {
        public static final String iFy = i.a(m.izp, "AppBrandWxaAppInfo");

        public final /* synthetic */ boolean b(c cVar) {
            m mVar = (m) cVar;
            if (bg.mA(mVar.field_appId)) {
                return false;
            }
            mVar.field_appIdHashCode = mVar.field_appId.hashCode();
            super.b(mVar);
            return b(mVar, new String[0]);
        }

        a(e eVar) {
            super(eVar, m.izp, "AppBrandWxaAppInfo", m.gaK);
        }
    }

    l(g gVar) {
        this.iFx = new a(gVar);
        this.izH = gVar;
        d.vL();
    }
}
