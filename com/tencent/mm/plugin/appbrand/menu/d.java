package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.ui.base.l;

public final class d extends a {
    public d() {
        super(k.jaC - 1);
    }

    public final void a(Context context, m mVar, l lVar, String str) {
        if (b.mY(str).iFk.izV == 1) {
            CharSequence string;
            if (b.mY(str).iES) {
                string = context.getString(R.l.dFc);
            } else {
                string = context.getString(R.l.dFj);
            }
            lVar.e(k.jaC - 1, string);
        }
    }

    public final void a(Context context, m mVar, String str, j jVar) {
        if ((!b.mY(str).iES ? 1 : 0) != 0) {
            AppBrandPerformanceManager.qz(str);
            Toast.makeText(context, R.l.dFk, 0).show();
            return;
        }
        AppBrandPerformanceManager.qA(str);
        Toast.makeText(context, R.l.dFd, 0).show();
    }
}
