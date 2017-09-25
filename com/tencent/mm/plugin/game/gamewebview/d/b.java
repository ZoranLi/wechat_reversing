package com.tencent.mm.plugin.game.gamewebview.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.game.gamewebview.model.g;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.smtt.sdk.ab;
import com.tencent.smtt.sdk.y;
import java.lang.Thread.State;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public final class b extends MMWebView {
    private boolean ixy;
    private Context mContext;
    private d mjP;
    private g mof = new g();
    private WebViewClient mog;
    private WebChromeClient moh;
    private ab moi;
    public ProxyWebViewClientExtension moj;
    private c mok;
    private boolean mol;
    private b mom = new b(this);
    private c mon = new c(this);
    private a moo = new a(this);
    private LinkedList<String> mop = new LinkedList();
    private ProxyWebViewClientExtension moq = new ProxyWebViewClientExtension(this) {
        final /* synthetic */ b mor;

        {
            this.mor = r1;
        }

        public final Object onMiscCallBack(String str, Bundle bundle) {
            boolean z = false;
            String str2 = "MicroMsg.GameWebView";
            String str3 = "method = %s, bundler == null ? %b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (bundle == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            w.i(str2, str3, objArr);
            if (str.equals("getShareUrl")) {
                return this.mor.mjP.IU();
            }
            if (this.mor.moj != null) {
                return this.mor.moj.onMiscCallBack(str, bundle);
            }
            return null;
        }

        public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
            return this.mor.mom.s(motionEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            return this.mor.mom.u(motionEvent);
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            return this.mor.mom.t(motionEvent);
        }

        public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
            return this.mor.mom.a(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            this.mor.mom.onScrollChanged(i, i2, i3, i4, view);
        }

        public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
            this.mor.mom.b(i, i2, z, z2);
        }

        public final void computeScroll(View view) {
            this.mor.mom.mor.caJ();
        }

        public final void invalidate() {
        }
    };

    private class a extends WebChromeClient {
        final /* synthetic */ b mor;

        public a(b bVar) {
            this.mor = bVar;
        }

        public final void onProgressChanged(WebView webView, int i) {
            if (this.mor.moh != null) {
                this.mor.moh.onProgressChanged(webView, i);
            }
        }

        public final void onReceivedTitle(WebView webView, String str) {
            w.i("MicroMsg.GameWebView", "onReceivedTitle, title = %s", new Object[]{str});
            if (this.mor.moh != null) {
                this.mor.moh.onReceivedTitle(webView, str);
            }
        }

        public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            w.i("MicroMsg.GameWebView", "onShowCustomView, sdk int = " + VERSION.SDK_INT);
            if (this.mor.moh != null) {
                this.mor.moh.onShowCustomView(view, customViewCallback);
            }
        }

        public final void onHideCustomView() {
            w.i("MicroMsg.GameWebView", "onHideCustomView, sdk int = " + VERSION.SDK_INT);
            if (this.mor.moh != null) {
                this.mor.moh.onHideCustomView();
            }
        }

        public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
            w.i("MicroMsg.GameWebView", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[]{str});
            if (this.mor.moh != null) {
                this.mor.moh.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
            }
        }

        public final boolean onShowFileChooser(WebView webView, y<Uri[]> yVar, com.tencent.smtt.sdk.WebChromeClient.a aVar) {
            if (this.mor.moh != null) {
                return this.mor.moh.onShowFileChooser(webView, yVar, aVar);
            }
            return super.onShowFileChooser(webView, yVar, aVar);
        }

        public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            if (this.mor.moh != null) {
                return this.mor.moh.onJsConfirm(webView, str, str2, jsResult);
            }
            return super.onJsConfirm(webView, str, str2, jsResult);
        }

        public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (this.mor.moh != null) {
                return this.mor.moh.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if (this.mor.moh != null) {
                return this.mor.moh.onJsAlert(webView, str, str2, jsResult);
            }
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String message = consoleMessage != null ? consoleMessage.message() : null;
            w.i("MicroMsg.GameWebView", "onConsoleMessage : %s", new Object[]{message});
            if (this.mor.moh != null) {
                return this.mor.moh.onConsoleMessage(consoleMessage);
            }
            return super.onConsoleMessage(consoleMessage);
        }
    }

    private class c extends WebViewClient {
        final /* synthetic */ b mor;

        public c(b bVar) {
            this.mor = bVar;
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            w.i("MicroMsg.GameWebView", "onPageStarted, url = %s", new Object[]{str});
            this.mor.mol = false;
            if (!this.mor.mok.xL(str) && this.mor.mog != null) {
                this.mor.mog.onPageStarted(webView, str, bitmap);
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            w.i("MicroMsg.GameWebView", "onPageFinished, url = %s", new Object[]{str});
            this.mor.ixy = true;
            this.mor.postDelayed(new Runnable(this) {
                final /* synthetic */ c mos;

                {
                    this.mos = r1;
                }

                public final void run() {
                    this.mos.mor.eE(true);
                }
            }, 1000);
            b.d(this.mor);
            if (this.mor.mog != null) {
                this.mor.mog.onPageFinished(webView, str);
            }
            this.mor.postDelayed(new Runnable(this) {
                final /* synthetic */ c mos;

                {
                    this.mos = r1;
                }

                public final void run() {
                    this.mos.mor.evaluateJavascript("javascript:(function(){if(window.WeixinJSBridge){return 'success';}})();", new y<String>(this.mos.mor) {
                        final /* synthetic */ b mor;

                        {
                            this.mor = r1;
                        }

                        public final /* synthetic */ void onReceiveValue(Object obj) {
                            w.i("MicroMsg.GameWebView", "WeixinJSBridge, ret = %s", new Object[]{(String) obj});
                            if (bg.mA((String) obj)) {
                                com.tencent.mm.plugin.report.service.g.oUh.a(609, 2, 1, false);
                            }
                        }
                    });
                }
            }, 2000);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            w.i("MicroMsg.GameWebView", "shouldOverrideUrlLoading, url = %s, id = %d", new Object[]{str, Integer.valueOf(hashCode())});
            this.mor.mol = false;
            if (this.mor.mok.xL(str)) {
                return true;
            }
            if (this.mor.mog != null) {
                return this.mor.mog.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            w.i("MicroMsg.GameWebView", "doUpdateVisitedHistory, url = %s, isReload = %b", new Object[]{str, Boolean.valueOf(z)});
            super.doUpdateVisitedHistory(webView, str, z);
            if (this.mor.mog != null) {
                this.mor.mog.doUpdateVisitedHistory(webView, str, z);
            }
        }

        @TargetApi(8)
        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            w.i("MicroMsg.GameWebView", "onReceivedSslError");
            if (this.mor.mog != null) {
                this.mor.mog.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            boolean isConnected = am.isConnected(this.mor.mContext);
            int we = com.tencent.mm.plugin.webview.ui.tools.a.we(i);
            w.i("MicroMsg.GameWebView", "onReceivedError, failingUrl = %s, errorCode = %d, errorKey = %d, desc = %s, isNetworkConnected = %b", new Object[]{str2, Integer.valueOf(i), Integer.valueOf(we), str, Boolean.valueOf(isConnected)});
            super.onReceivedError(webView, i, str, str2);
            if (this.mor.mog != null) {
                this.mor.mog.onReceivedError(webView, i, str, str2);
            }
        }

        public final void onLoadResource(WebView webView, String str) {
            w.i("MicroMsg.GameWebView", "onLoadResource opt, url = " + str);
            super.onLoadResource(webView, str);
            if (!this.mor.mol) {
                this.mor.mol = true;
                this.mor.eE(false);
            }
            if (this.mor.mog != null) {
                this.mor.mog.onLoadResource(webView, str);
            }
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            w.i("MicroMsg.GameWebView", "shouldInterceptRequest, url = %s", new Object[]{str});
            this.mor.mof;
            WebResourceResponse xC = g.xC(str);
            if (xC != null) {
                return xC;
            }
            if (this.mor.mog != null) {
                return this.mor.mog.shouldInterceptRequest(webView, str);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            w.i("MicroMsg.GameWebView", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{webResourceRequest.getUrl(), webResourceRequest.getMethod(), Boolean.valueOf(webResourceRequest.isForMainFrame())});
            if (webResourceRequest.getUrl() == null || bg.mA(webResourceRequest.getUrl().toString())) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            this.mor.mof;
            WebResourceResponse xC = g.xC(webResourceRequest.getUrl().toString());
            if (xC != null) {
                return xC;
            }
            if (this.mor.mog != null) {
                return this.mor.mog.shouldInterceptRequest(webView, webResourceRequest);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            w.i("MicroMsg.GameWebView", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{webResourceRequest.getUrl(), webResourceRequest.getMethod(), Boolean.valueOf(webResourceRequest.isForMainFrame())});
            if (webResourceRequest.getUrl() == null || bg.mA(webResourceRequest.getUrl().toString())) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            this.mor.mof;
            WebResourceResponse xC = g.xC(webResourceRequest.getUrl().toString());
            if (xC != null) {
                return xC;
            }
            if (this.mor.mog != null) {
                return this.mor.mog.shouldInterceptRequest(webView, webResourceRequest, bundle);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest, bundle);
        }
    }

    private class b extends com.tencent.mm.plugin.game.gamewebview.ui.g {
        final /* synthetic */ b mor;

        public b(b bVar) {
            this.mor = bVar;
        }

        public final boolean s(MotionEvent motionEvent) {
            return this.mor.J(motionEvent);
        }

        public final boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            return this.mor.b(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        public final boolean t(MotionEvent motionEvent) {
            return this.mor.K(motionEvent);
        }

        public final void UN() {
            this.mor.caJ();
        }

        @TargetApi(9)
        public final void b(int i, int i2, boolean z, boolean z2) {
            this.mor.c(i, i2, z, z2);
        }

        public final boolean u(MotionEvent motionEvent) {
            return this.mor.L(motionEvent);
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            this.mor.v(i, i2, i3, i4);
            if (this.mor.moi != null) {
                this.mor.moi.onScrollChanged(i, i2, i3, i4, view);
            }
        }
    }

    static /* synthetic */ void d(b bVar) {
        Iterator it = bVar.mop.iterator();
        while (it.hasNext()) {
            bVar.evaluateJavascript((String) it.next(), null);
        }
        bVar.mop.clear();
    }

    public b(Context context, d dVar) {
        boolean z;
        boolean booleanExtra;
        boolean booleanExtra2;
        super(context);
        this.mContext = context;
        this.mjP = dVar;
        this.mok = new c(this.mjP);
        fh(this.mContext);
        this.gRU = true;
        if (getX5WebViewExtension() != null) {
            z = true;
        } else {
            z = false;
        }
        this.wwS = z;
        w.i("MicroMsg.GameWebView", "isX5Kernel = " + this.wwS);
        if (!(this.wwS || com.tencent.mm.compatible.util.d.eo(19))) {
            try {
                w.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[]{new com.tencent.mm.compatible.loader.c(this, "mSysWebView", null).get()});
                w.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[]{new com.tencent.mm.compatible.loader.c(r0, "mProvider", null).get()});
                w.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[]{new com.tencent.mm.compatible.loader.c(r0, "mWebViewCore", null).get()});
                w.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[]{new com.tencent.mm.compatible.loader.c(r0, "sWebCoreHandler", null).get()});
                w.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[]{new com.tencent.mm.compatible.loader.c(r0, "mLooper", null).get()});
                Object obj = new com.tencent.mm.compatible.loader.c(obj, "mThread", null).get();
                w.d("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[]{obj});
                if (obj instanceof Thread) {
                    Thread thread = (Thread) obj;
                    w.i("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[]{thread.getState()});
                    if (thread.getState() == State.WAITING) {
                        thread.interrupt();
                    }
                }
            } catch (Exception e) {
                w.e("MicroMsg.GameWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[]{e});
            }
        }
        if (this.mContext instanceof Activity) {
            booleanExtra = ((Activity) this.mContext).getIntent().getBooleanExtra("usePlugin", true);
            booleanExtra2 = ((Activity) this.mContext).getIntent().getBooleanExtra("zoom", true);
            z = ((Activity) this.mContext).getIntent().getBooleanExtra("zoom", true);
        } else {
            z = true;
            booleanExtra2 = true;
            booleanExtra = true;
        }
        getSettings().setDomStorageEnabled(true);
        getSettings().setJavaScriptEnabled(z);
        getSettings().setPluginsEnabled(booleanExtra);
        getSettings().setBuiltInZoomControls(booleanExtra2);
        getSettings().setMediaPlaybackRequiresUserGesture(true);
        getSettings().setMixedContentMode(0);
        getSettings().setUserAgentString(s.aZ(getContext(), getSettings().getUserAgentString()));
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setSavePassword(false);
        getSettings().setSaveFormData(false);
        getSettings().setGeolocationEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setMixedContentMode(0);
        getSettings().setAppCacheMaxSize(10485760);
        getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
        getSettings().setAppCacheEnabled(true);
        getSettings().setDatabaseEnabled(true);
        getSettings().setDatabasePath(e.hgp + "databases/");
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(false);
        WindowManager windowManager = (WindowManager) com.tencent.mm.sdk.platformtools.ab.getContext().getSystemService("window");
        try {
            Field declaredField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(null);
            if (obj2 != null) {
                declaredField = declaredField.getType().getDeclaredField("mWindowManager");
                declaredField.setAccessible(true);
                declaredField.set(obj2, windowManager);
            }
        } catch (Exception e2) {
        }
        super.setWebChromeClient(this.moo);
        super.setWebViewClient(this.mon);
        if (this.wwS) {
            super.setWebViewCallbackClient(this.mom);
            super.setWebViewClientExtension(this.moq);
        }
        w.i("MicroMsg.GameWebView", "Is the current broswer kernel X5, " + this.wwS);
        setBackgroundColor(-1);
        setLayoutParams(new LayoutParams(-1, -1));
        requestFocus(130);
        String U = com.tencent.mm.plugin.game.gamewebview.a.d.U(this.mContext, getSettings().getUserAgentString());
        w.i("MicroMsg.GameWebView", "UserAgent = " + U);
        getSettings().setUserAgentString(U);
        caH();
        if (getWebViewClientExtension() != null) {
            j.mN(7);
            com.tencent.mm.plugin.report.service.g.oUh.n(64, 64, 1, 0);
            return;
        }
        com.tencent.mm.plugin.report.service.g.oUh.a(64, 0, 1, false);
    }

    public final void destroy() {
        CookieSyncManager createInstance = CookieSyncManager.createInstance(com.tencent.mm.sdk.platformtools.ab.getContext());
        if (createInstance != null) {
            w.i("MicroMsg.GameWebView", "now force sync the cookie between ram and db");
            createInstance.sync();
        }
        if (VERSION.SDK_INT >= 11) {
            removeJavascriptInterface("MicroMsg");
            removeJavascriptInterface("JsApi");
        }
        try {
            super.setWebChromeClient(null);
            super.setWebChromeClient(null);
            super.setOnTouchListener(null);
            super.setOnLongClickListener(null);
            setVisibility(8);
            removeAllViews();
            clearView();
            super.destroy();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.GameWebView", e, "", new Object[0]);
        }
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.mog = webViewClient;
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.moh = webChromeClient;
    }

    public final void setWebViewCallbackClient(ab abVar) {
        this.moi = abVar;
    }

    public final void eE(boolean z) {
        String convertStreamToString;
        try {
            convertStreamToString = bg.convertStreamToString(getContext().getAssets().open("game_jsapi/jsbridge.js"));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.GameWebView", e, "", new Object[0]);
            convertStreamToString = null;
        }
        if (convertStreamToString == null) {
            w.e("MicroMsg.GameWebView", "injectJavaScript fail, jsContent is null");
            com.tencent.mm.plugin.report.service.g.oUh.a(609, 4, 1, false);
            return;
        }
        evaluateJavascript("javascript:" + convertStreamToString, new y<String>(this) {
            final /* synthetic */ b mor;

            {
                this.mor = r1;
            }

            public final /* synthetic */ void onReceiveValue(Object obj) {
                w.i("MicroMsg.GameWebView", "injectJavaScript, ret = %s", new Object[]{(String) obj});
                if (bg.mA((String) obj)) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(609, 2, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.oUh.a(609, 3, 1, false);
                }
            }
        });
        w.i("MicroMsg.GameWebView", "injectJavaScript done");
        com.tencent.mm.plugin.report.service.g.oUh.a(609, 1, 1, false);
        if (z) {
            cm("sys:init", "");
        }
    }

    public final void cm(String str, String str2) {
        if (bg.mA(str2)) {
            str2 = "{}";
        }
        w.d("MicroMsg.GameWebView", "dispatch, event: %s, data size: %d", new Object[]{str, Integer.valueOf(str2.length())});
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = str2;
        Map hashMap = new HashMap();
        hashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
        objArr[2] = new JSONObject(hashMap).toString();
        String format = String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, undefined, %s)", objArr);
        if (this.ixy) {
            evaluateJavascript(format, null);
            return;
        }
        w.d("MicroMsg.GameWebView", "not page finish, add js to queue, %s", new Object[]{format});
        this.mop.add(format);
    }

    @SuppressLint({"DefaultLocale"})
    public final void x(int i, String str) {
        if (bg.mA(str)) {
            str = "{}";
        }
        w.d("MicroMsg.GameWebView", "callback, callbackId: %d, data size: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(str.length())});
        evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[]{Integer.valueOf(i), str}), null);
    }

    public final void evaluateJavascript(String str, y<String> yVar) {
        super.evaluateJavascript(str, yVar);
    }
}
