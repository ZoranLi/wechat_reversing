package com.tencent.mm.plugin.appbrand.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.report.a.c;
import com.tencent.mm.plugin.appbrand.report.a.c.a;
import com.tencent.mm.plugin.appbrand.report.a.c.b;
import com.tencent.mm.ui.MMTintStatusBarActivity;
import com.tencent.smtt.sdk.WebView;

public final class AppBrandNearbyEmptyUI extends MMTintStatusBarActivity {
    protected final int getLayoutId() {
        return R.i.cUf;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uSU.ipu.setBackgroundColor(AppBrandLauncherUI.jio);
        cO().cP().getCustomView().setBackgroundColor(AppBrandLauncherUI.jio);
        zi(R.l.dEU);
        zh(WebView.NIGHT_MODE_COLOR);
        a(new OnMenuItemClickListener(this) {
            final /* synthetic */ AppBrandNearbyEmptyUI jiI;

            {
                this.jiI = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jiI.onBackPressed();
                return true;
            }
        }, R.g.bdk);
        c cVar = new c();
        cVar.jgy = b.TOP_ENTRANCE_IN_DESKTOP;
        cVar.jgC = a.EMPTY_PAGE;
        cVar.qg();
        setResult(-1);
    }

    public final int getStatusBarColor() {
        if (VERSION.SDK_INT >= 23 && !g.sf()) {
            g.a(getWindow(), true);
            return AppBrandLauncherUI.jip;
        } else if (VERSION.SDK_INT >= 21) {
            return AppBrandLauncherUI.jiq;
        } else {
            return super.getStatusBarColor();
        }
    }
}
