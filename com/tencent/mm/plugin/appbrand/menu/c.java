package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.ui.base.l;

public final class c extends a {
    public c() {
        super(k.jaI - 1);
    }

    public final void a(Context context, m mVar, l lVar, String str) {
        if (AppBrandPerformanceManager.qB(str)) {
            lVar.e(k.jaI - 1, context.getString(R.l.dFf));
        }
    }

    public final void a(final Context context, m mVar, final String str, j jVar) {
        Toast.makeText(context, R.l.dFh, 0).show();
        d.vL().D(new Runnable(this) {
            final /* synthetic */ c jaq;

            public final void run() {
                final boolean qE = com.tencent.mm.plugin.appbrand.performance.a.qE(str);
                d.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 jas;

                    public final void run() {
                        Toast.makeText(context, qE ? R.l.dFi : R.l.dFg, 0).show();
                    }
                });
            }
        });
    }
}
