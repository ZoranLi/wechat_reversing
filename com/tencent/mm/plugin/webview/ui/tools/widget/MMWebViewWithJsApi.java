package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.sdk.WebViewClient;

public class MMWebViewWithJsApi extends MMWebView {
    private c snv;
    public boolean snw;

    public static class a {
        public static MMWebViewWithJsApi dg(Context context) {
            MMWebViewWithJsApi.fh(context);
            MMWebViewWithJsApi mMWebViewWithJsApi = new MMWebViewWithJsApi(context);
            mMWebViewWithJsApi.gRU = true;
            mMWebViewWithJsApi.wwS = mMWebViewWithJsApi.getX5WebViewExtension() != null;
            return mMWebViewWithJsApi;
        }
    }

    public MMWebViewWithJsApi(Context context) {
        this(context, null);
    }

    public MMWebViewWithJsApi(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMWebViewWithJsApi(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.snw = true;
        caG();
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMixedContentMode(0);
        setWebChromeClient(new b(this));
        setWebViewClient(new c(this));
        String userAgentString = getSettings().getUserAgentString();
        if (!s.Np(userAgentString)) {
            getSettings().setUserAgentString(s.aZ(getContext(), userAgentString));
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof c) {
            this.snv = (c) webViewClient;
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.snv != null && this.snw) {
            this.snv.Po();
        }
    }

    public void loadData(String str, String str2, String str3) {
        if (this.snv != null) {
            this.snv.snn = true;
        }
        super.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.snv != null) {
            this.snv.snn = true;
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }
}
