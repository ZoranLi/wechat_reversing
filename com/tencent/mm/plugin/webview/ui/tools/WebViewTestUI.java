package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class WebViewTestUI extends MMActivity {
    private WebViewClient ixz = new WebViewClient(this) {
        final /* synthetic */ WebViewTestUI scK;

        {
            this.scK = r1;
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }
    };
    MMWebViewWithJsApi scJ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("rawUrl");
        this.scJ = a.dg(this);
        this.scJ.setWebViewClient(this.ixz);
        setContentView(this.scJ);
        this.scJ.loadUrl(stringExtra);
    }

    protected final int getLayoutId() {
        return -1;
    }
}
