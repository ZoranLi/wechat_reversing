package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.QuotaUpdater;
import com.tencent.smtt.export.external.proxy.X5ProxyWebChromeClient;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

final class e extends X5ProxyWebChromeClient {
    private WebView vsw;
    private WebChromeClient wTP;

    class a implements com.tencent.smtt.sdk.aa.a {
        final /* synthetic */ e wTQ;
        QuotaUpdater wTS;

        a(e eVar, QuotaUpdater quotaUpdater) {
            this.wTQ = eVar;
            this.wTS = quotaUpdater;
        }

        public final void updateQuota(long j) {
            this.wTS.updateQuota(j);
        }
    }

    public e(IX5WebChromeClient iX5WebChromeClient, WebView webView, WebChromeClient webChromeClient) {
        super(iX5WebChromeClient);
        this.vsw = webView;
        this.wTP = webChromeClient;
    }

    public final Bitmap getDefaultVideoPoster() {
        return this.wTP.getDefaultVideoPoster();
    }

    public final void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    public final void onCloseWindow(IX5WebViewBase iX5WebViewBase) {
        this.vsw.wWE = iX5WebViewBase;
        this.wTP.onCloseWindow(this.vsw);
    }

    public final void onConsoleMessage(String str, int i, String str2) {
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.wTP.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(IX5WebViewBase iX5WebViewBase, boolean z, boolean z2, final Message message) {
        WebView webView = this.vsw;
        webView.getClass();
        final WebViewTransport webViewTransport = new WebViewTransport();
        Message obtain = Message.obtain(message.getTarget(), new Runnable(this) {
            final /* synthetic */ e wTQ;

            public final void run() {
                WebView webView = webViewTransport.getWebView();
                if (webView != null) {
                    ((IX5WebViewBase.WebViewTransport) message.obj).setWebView(webView.wWE);
                }
                message.sendToTarget();
            }
        });
        obtain.obj = webViewTransport;
        return this.wTP.onCreateWindow(this.vsw, z, z2, obtain);
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        this.wTP.onExceededDatabaseQuota(str, str2, j, j2, j3, new a(this, quotaUpdater));
    }

    public final void onGeolocationPermissionsHidePrompt() {
        this.wTP.onGeolocationPermissionsHidePrompt();
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        this.wTP.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
    }

    public final void onHideCustomView() {
        this.wTP.onHideCustomView();
    }

    public final boolean onJsAlert(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.vsw.wWE = iX5WebViewBase;
        return this.wTP.onJsAlert(this.vsw, str, str2, jsResult);
    }

    public final boolean onJsBeforeUnload(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.vsw.wWE = iX5WebViewBase;
        return this.wTP.onJsBeforeUnload(this.vsw, str, str2, jsResult);
    }

    public final boolean onJsConfirm(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.vsw.wWE = iX5WebViewBase;
        return this.wTP.onJsConfirm(this.vsw, str, str2, jsResult);
    }

    public final boolean onJsPrompt(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        this.vsw.wWE = iX5WebViewBase;
        return this.wTP.onJsPrompt(this.vsw, str, str2, str3, jsPromptResult);
    }

    public final boolean onJsTimeout() {
        return this.wTP.onJsTimeout();
    }

    public final void onProgressChanged(IX5WebViewBase iX5WebViewBase, int i) {
        this.vsw.wWE = iX5WebViewBase;
        this.wTP.onProgressChanged(this.vsw, i);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        this.wTP.onReachedMaxAppCacheSize(j, j2, new a(this, quotaUpdater));
    }

    public final void onReceivedIcon(IX5WebViewBase iX5WebViewBase, Bitmap bitmap) {
        this.vsw.wWE = iX5WebViewBase;
        this.wTP.onReceivedIcon(this.vsw, bitmap);
    }

    public final void onReceivedTitle(IX5WebViewBase iX5WebViewBase, String str) {
        this.vsw.wWE = iX5WebViewBase;
        this.wTP.onReceivedTitle(this.vsw, str);
    }

    public final void onReceivedTouchIconUrl(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        this.vsw.wWE = iX5WebViewBase;
        this.wTP.onReceivedTouchIconUrl(this.vsw, str, z);
    }

    public final void onRequestFocus(IX5WebViewBase iX5WebViewBase) {
        this.vsw.wWE = iX5WebViewBase;
        this.wTP.onRequestFocus(this.vsw);
    }

    public final void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        this.wTP.onShowCustomView(view, i, customViewCallback);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        this.wTP.onShowCustomView(view, customViewCallback);
    }

    public final boolean onShowFileChooser(IX5WebViewBase iX5WebViewBase, final ValueCallback<Uri[]> valueCallback, final FileChooserParams fileChooserParams) {
        y anonymousClass3 = new y<Uri[]>(this) {
            final /* synthetic */ e wTQ;

            public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                valueCallback.onReceiveValue((Uri[]) obj);
            }
        };
        com.tencent.smtt.sdk.WebChromeClient.a anonymousClass4 = new com.tencent.smtt.sdk.WebChromeClient.a(this) {
            final /* synthetic */ e wTQ;

            public final Intent createIntent() {
                return fileChooserParams.createIntent();
            }

            public final String[] getAcceptTypes() {
                return fileChooserParams.getAcceptTypes();
            }

            public final String getFilenameHint() {
                return fileChooserParams.getFilenameHint();
            }

            public final int getMode() {
                return fileChooserParams.getMode();
            }

            public final CharSequence getTitle() {
                return fileChooserParams.getTitle();
            }

            public final boolean isCaptureEnabled() {
                return fileChooserParams.isCaptureEnabled();
            }
        };
        this.vsw.wWE = iX5WebViewBase;
        return this.wTP.onShowFileChooser(this.vsw, anonymousClass3, anonymousClass4);
    }

    public final void openFileChooser(final ValueCallback<Uri[]> valueCallback, String str, String str2, boolean z) {
        this.wTP.openFileChooser(new y<Uri>(this) {
            final /* synthetic */ e wTQ;

            public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                Uri uri = (Uri) obj;
                valueCallback.onReceiveValue(new Uri[]{uri});
            }
        }, str, str2);
    }
}
