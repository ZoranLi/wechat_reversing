package com.tencent.mm.plugin.appbrand.menu;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.l;

public final class e extends a {
    public e() {
        super(k.jaD - 1);
    }

    public final void a(Context context, m mVar, l lVar, String str) {
        if (b.bIu()) {
            lVar.a(this.jaM, context.getResources().getColor(R.e.aVE), context.getString(R.l.dDH));
        }
    }

    public final void a(Context context, m mVar, String str, j jVar) {
        com.tencent.mm.plugin.appbrand.e.a(str, c.CLOSE);
        if (context instanceof Activity) {
            ((Activity) context).finish();
            com.tencent.mm.plugin.appbrand.report.a.a(str, mVar.jde.jdU, 10, "", bg.Ny(), 1, 0);
        }
    }
}
