package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;

public final class o extends i {
    FrameLayout qja;
    MMWebView qjb;

    public o(Context context, s sVar, ViewGroup viewGroup) {
        super(context, sVar, viewGroup);
    }

    protected final void bgl() {
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        this.qjb.setVerticalScrollBarEnabled(false);
        this.qjb.setHorizontalScrollBarEnabled(false);
        this.qjb.getSettings().setJavaScriptEnabled(true);
        this.qjb.loadUrl(((s) this.qib).mER);
        this.qjb.setLayoutParams(new LayoutParams(-1, -1));
        this.qjb.setVisibility(0);
        this.qja.setPadding(this.qja.getPaddingLeft(), (int) ((s) this.qib).qfK, this.qja.getPaddingRight(), (int) ((s) this.qib).qfL);
        this.qja.setLayoutParams(new LinearLayout.LayoutParams(width, height));
    }

    public final View bgf() {
        this.qja = (FrameLayout) this.ipu;
        this.qjb = a.fi(this.context);
        this.qja.addView(this.qjb);
        return this.qja;
    }

    protected final int aTQ() {
        return Integer.MAX_VALUE;
    }

    protected final View bgm() {
        return new FrameLayout(this.context);
    }
}
