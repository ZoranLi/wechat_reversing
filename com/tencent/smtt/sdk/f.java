package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.m;
import com.tencent.smtt.utils.r;
import com.tencent.wcdb.database.SQLiteDatabase;

final class f extends X5ProxyWebViewClient {
    private static String wTT = null;
    private WebViewClient oqq;
    public WebView vsw;

    public f(IX5WebViewClient iX5WebViewClient, WebView webView, WebViewClient webViewClient) {
        super(iX5WebViewClient);
        this.vsw = webView;
        this.oqq = webViewClient;
    }

    public final void countPVContentCacheCallBack(String str) {
        WebView webView = this.vsw;
        webView.wWH++;
    }

    public final void doUpdateVisitedHistory(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        this.vsw.wWE = iX5WebViewBase;
        this.oqq.doUpdateVisitedHistory(this.vsw, str, z);
    }

    public final void onDetectedBlankScreen(IX5WebViewBase iX5WebViewBase, String str, int i) {
        this.vsw.wWE = iX5WebViewBase;
        this.oqq.onDetectedBlankScreen(str, i);
    }

    public final void onFormResubmission(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.vsw.wWE = iX5WebViewBase;
        this.oqq.onFormResubmission(this.vsw, message, message2);
    }

    public final void onLoadResource(IX5WebViewBase iX5WebViewBase, String str) {
        this.vsw.wWE = iX5WebViewBase;
        this.oqq.onLoadResource(this.vsw, str);
    }

    public final void onPageFinished(IX5WebViewBase iX5WebViewBase, int i, int i2, String str) {
        if (wTT == null) {
            r cfz = r.cfz();
            if (cfz != null) {
                cfz.mf(false);
                wTT = Boolean.toString(false);
            }
        }
        this.vsw.wWE = iX5WebViewBase;
        WebView webView = this.vsw;
        webView.wWH++;
        this.oqq.onPageFinished(this.vsw, str);
        if ("com.qzone".equals(iX5WebViewBase.getView().getContext().getApplicationInfo().packageName)) {
            WebView.gD(iX5WebViewBase.getView().getContext());
        }
        TbsLog.app_extra("SmttWebViewClient", iX5WebViewBase.getView().getContext());
        try {
            super.onPageFinished(iX5WebViewBase, i, i2, str);
        } catch (Exception e) {
        }
        WebView.ceW();
        if (!(t.wWc || this.vsw.getContext() == null || !t.gu(this.vsw.getContext()))) {
            t.wWc = true;
            new Thread(new Runnable(this) {
                final /* synthetic */ f wTU;

                {
                    this.wTU = r1;
                }

                public final void run() {
                    this.wTU.vsw.getContext();
                    if (l.q(this.wTU.vsw.getContext(), false)) {
                        l.fO(this.wTU.vsw.getContext());
                    }
                }
            }).start();
        }
        if (this.vsw.getContext() != null && !r.gr(this.vsw.getContext()).wVw) {
            r.gr(this.vsw.getContext()).wVw = true;
            r.gr(this.vsw.getContext()).ceE();
        }
    }

    public final void onPageFinished(IX5WebViewBase iX5WebViewBase, String str) {
        onPageFinished(iX5WebViewBase, 0, 0, str);
    }

    public final void onPageStarted(IX5WebViewBase iX5WebViewBase, int i, int i2, String str, Bitmap bitmap) {
        this.vsw.wWE = iX5WebViewBase;
        this.oqq.onPageStarted(this.vsw, str, bitmap);
    }

    public final void onPageStarted(IX5WebViewBase iX5WebViewBase, String str, Bitmap bitmap) {
        onPageStarted(iX5WebViewBase, 0, 0, str, bitmap);
    }

    public final void onReceivedClientCertRequest(IX5WebViewBase iX5WebViewBase, ClientCertRequest clientCertRequest) {
        this.vsw.wWE = iX5WebViewBase;
        this.oqq.onReceivedClientCertRequest(this.vsw, clientCertRequest);
    }

    public final void onReceivedError(IX5WebViewBase iX5WebViewBase, int i, String str, String str2) {
        if (i < -15) {
            if (i == -17) {
                i = -1;
            } else {
                return;
            }
        }
        this.vsw.wWE = iX5WebViewBase;
        this.oqq.onReceivedError(this.vsw, i, str, str2);
    }

    public final void onReceivedError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.vsw.wWE = iX5WebViewBase;
        this.oqq.onReceivedError(this.vsw, webResourceRequest, webResourceError);
    }

    public final void onReceivedHttpAuthRequest(IX5WebViewBase iX5WebViewBase, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.vsw.wWE = iX5WebViewBase;
        this.oqq.onReceivedHttpAuthRequest(this.vsw, httpAuthHandler, str, str2);
    }

    public final void onReceivedHttpError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.vsw.wWE = iX5WebViewBase;
        this.oqq.onReceivedHttpError(this.vsw, webResourceRequest, webResourceResponse);
    }

    public final void onReceivedLoginRequest(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3) {
        this.vsw.wWE = iX5WebViewBase;
        this.oqq.onReceivedLoginRequest(this.vsw, str, str2, str3);
    }

    public final void onReceivedSslError(IX5WebViewBase iX5WebViewBase, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.vsw.wWE = iX5WebViewBase;
        this.oqq.onReceivedSslError(this.vsw, sslErrorHandler, sslError);
    }

    public final void onScaleChanged(IX5WebViewBase iX5WebViewBase, float f, float f2) {
        this.vsw.wWE = iX5WebViewBase;
        this.oqq.onScaleChanged(this.vsw, f, f2);
    }

    public final void onTooManyRedirects(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.vsw.wWE = iX5WebViewBase;
        this.oqq.onTooManyRedirects(this.vsw, message, message2);
    }

    public final void onUnhandledKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.vsw.wWE = iX5WebViewBase;
        this.oqq.onUnhandledKeyEvent(this.vsw, keyEvent);
    }

    public final WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        this.vsw.wWE = iX5WebViewBase;
        return this.oqq.shouldInterceptRequest(this.vsw, webResourceRequest);
    }

    public final WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, Bundle bundle) {
        this.vsw.wWE = iX5WebViewBase;
        return this.oqq.shouldInterceptRequest(this.vsw, webResourceRequest, bundle);
    }

    public final WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, String str) {
        this.vsw.wWE = iX5WebViewBase;
        return this.oqq.shouldInterceptRequest(this.vsw, str);
    }

    public final boolean shouldOverrideKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.vsw.wWE = iX5WebViewBase;
        return this.oqq.shouldOverrideKeyEvent(this.vsw, keyEvent);
    }

    public final boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, String str) {
        if (str == null || this.vsw.showDebugView(str)) {
            return true;
        }
        this.vsw.wWE = iX5WebViewBase;
        if (m.cft().bF(this.vsw.getContext().getApplicationContext(), str)) {
            return true;
        }
        boolean shouldOverrideUrlLoading = this.oqq.shouldOverrideUrlLoading(this.vsw, str);
        if (!shouldOverrideUrlLoading) {
            if (str.startsWith("wtai://wp/mc;")) {
                this.vsw.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str.substring(13)).toString())));
                return true;
            } else if (str.startsWith(WebView.SCHEME_TEL)) {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                try {
                    if (this.vsw.getContext() == null) {
                        return true;
                    }
                    this.vsw.getContext().startActivity(intent);
                    return true;
                } catch (Exception e) {
                    return true;
                }
            }
        }
        return shouldOverrideUrlLoading;
    }

    public final void v(String str, Bitmap bitmap) {
        super.onPageStarted(this.vsw.wWE, 0, 0, str, bitmap);
    }
}
