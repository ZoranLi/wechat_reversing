package com.tencent.mm.plugin.appbrand.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.smtt.sdk.WebView;

public class AppBrandNearbyWebViewUI extends WebViewUI {
    public void onCreate(Bundle bundle) {
        if (getIntent() != null) {
            getIntent().putExtra("forceHideShare", true);
            getIntent().putExtra("disable_bounce_scroll", true);
            getIntent().putExtra("geta8key_scene", 41);
            getIntent().putExtra("title", getBaseContext().getString(R.l.dEU));
            getIntent().putExtra("show_long_click_popup_menu", false);
        }
        super.onCreate(bundle);
        setResult(-1);
    }

    public final void qP(String str) {
        super.qP(str);
        zh(WebView.NIGHT_MODE_COLOR);
    }

    protected final void KC() {
        super.KC();
        if (cO().cP() != null) {
            zh(WebView.NIGHT_MODE_COLOR);
            wq(WebView.NIGHT_MODE_COLOR);
            cO().cP().getCustomView().setBackgroundColor(AppBrandLauncherUI.jio);
        }
    }

    protected final int WR() {
        if (VERSION.SDK_INT >= 23 && !g.sf()) {
            g.a(getWindow(), true);
            return AppBrandLauncherUI.jip;
        } else if (VERSION.SDK_INT >= 21) {
            return AppBrandLauncherUI.jiq;
        } else {
            return super.WR();
        }
    }
}
