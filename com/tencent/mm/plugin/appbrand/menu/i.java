package com.tencent.mm.plugin.appbrand.menu;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.l;

public final class i extends a {
    public i() {
        super(k.jaE - 1);
    }

    public final void a(Context context, m mVar, l lVar, String str) {
        CharSequence string;
        boolean ap = AppBrandStickyBannerLogic.a.ap(str, mVar.ixr.iwo.iFk.izV);
        int i = this.jaM;
        if (ap) {
            string = context.getString(R.l.dDr);
        } else {
            string = context.getString(R.l.dDq);
        }
        lVar.e(i, string);
    }

    public final void a(Context context, m mVar, String str, j jVar) {
        AppBrandSysConfig mY = b.mY(str);
        if (AppBrandStickyBannerLogic.a.ap(mY.appId, mY.iFk.izV)) {
            AppBrandStickyBannerLogic.a.qS(mY.appId);
            com.tencent.mm.ui.snackbar.a.a(context, ((Activity) context).findViewById(16908290), context.getString(R.l.dDs));
        } else {
            e.a(str, c.HANG);
            if (mVar == null) {
                context = ab.getContext();
            }
            AppBrandStickyBannerLogic.a.a(context, mY.appId, mY.iFk.izV, mY.fGs, mY.iEP);
        }
        com.tencent.mm.plugin.appbrand.report.a.a(str, mVar.jde.jdU, 13, "", bg.Ny(), 1, 0);
    }
}
