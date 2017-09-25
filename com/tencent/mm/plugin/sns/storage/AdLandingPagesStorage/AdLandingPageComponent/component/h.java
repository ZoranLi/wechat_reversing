package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.webview.ui.tools.widget.a.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public final class h extends a {
    public h(Context context, p pVar, ViewGroup viewGroup) {
        super(context, pVar, viewGroup);
    }

    protected final void bgl() {
        u uVar = (u) bgd();
        if (uVar != null) {
            ((WebView) getView()).loadUrl(uVar.url);
        }
    }

    protected final View bgm() {
        View bK = a.snf.bK(this.context);
        bK.getSettings().setAppCacheEnabled(true);
        bK.getSettings().setCacheMode(-1);
        bK.getSettings().setDomStorageEnabled(true);
        bK.setWebViewClient(new WebViewClient(this) {
            final /* synthetic */ h qia;

            {
                this.qia = r1;
            }

            public final void onLoadResource(WebView webView, String str) {
                super.onLoadResource(webView, str);
                w.i("AdLandingNewH5Comp", "loadRes " + str);
            }

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                w.i("AdLandingNewH5Comp", "page start " + str);
            }

            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                w.i("AdLandingNewH5Comp", "page finish " + str);
            }

            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                w.i("AdLandingNewH5Comp", "recv err " + i + ", " + str + ", " + str2);
            }

            public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                w.i("AdLandingNewH5Comp", "recv err ");
            }

            public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                w.i("AdLandingNewH5Comp", "onReceivedHttpError");
            }
        });
        return bK;
    }
}
