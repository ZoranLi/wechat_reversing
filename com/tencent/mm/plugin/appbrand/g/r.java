package com.tencent.mm.plugin.appbrand.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.f.i;
import com.tencent.mm.plugin.appbrand.f.l;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.m.a;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.smtt.sdk.ab;
import com.tencent.smtt.sdk.y;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.FileInputStream;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class r extends MMWebView implements d {
    private ProxyWebViewClientExtension iYQ;
    String ivH;
    h ixr;
    boolean ixy;
    private WebViewClient ixz;
    public String jdU;
    public String jdV;
    public t jdW = this;
    private l jdX;
    public View jdY;
    private CustomViewCallback jdZ;
    u jea;
    private LinkedList<Pair<String, y<String>>> jeb;
    private long jec;
    long jed;
    long jee;
    private String jef;
    String jeg;
    private WebChromeClient jeh;
    private ab mWebViewCallbackClient;

    static /* synthetic */ void a(r rVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        int i;
        if (rVar.jdX == null) {
            sslErrorHandler.cancel();
        }
        if (sslError.getPrimaryError() == 3) {
            SslCertificate certificate = sslError.getCertificate();
            w.d("MicroMsg.AppBrandWebView", "subjectDN: " + certificate.getIssuedTo().getDName());
            try {
                certificate.getClass().getDeclaredField("mX509Certificate").setAccessible(true);
                try {
                    rVar.jdX.checkServerTrusted(new X509Certificate[]{(X509Certificate) r3.get(certificate)}, "generic");
                    i = 1;
                } catch (Exception e) {
                    w.e("MicroMsg.AppBrandWebView", "Certificate check failed: " + e);
                    i = 0;
                }
            } catch (Exception e2) {
                w.e("MicroMsg.AppBrandWebView", "Certificate check failed: ", new Object[]{e2});
            }
            if (i == 0) {
                sslErrorHandler.proceed();
            } else {
                sslErrorHandler.cancel();
            }
        }
        i = 0;
        if (i == 0) {
            sslErrorHandler.cancel();
        } else {
            sslErrorHandler.proceed();
        }
    }

    static /* synthetic */ void d(r rVar) {
        a(new JSONObject(), "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.sYN));
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "width", Integer.valueOf(rVar.getWidth()));
        a(jSONObject, "pixelRatio", Float.valueOf(rVar.getResources().getDisplayMetrics().density));
        rVar.evaluateJavascript(String.format("var __wxConfig = %s;\nvar __deviceInfo__ = %s\n", new Object[]{r0.toString(), jSONObject.toString()}), null);
    }

    static /* synthetic */ void e(r rVar) {
        StringBuilder append = new StringBuilder().append(a.qT("wxa_library/android.js")).append(com.tencent.mm.plugin.appbrand.appcache.l.a(rVar.ixr, "WAWebview.js"));
        String str = "";
        if (rVar.ixr.iwo.iER) {
            str = com.tencent.mm.plugin.appbrand.appcache.l.a(rVar.ixr, "WAVConsole.js");
        }
        append = append.append(str);
        str = "";
        if (AppBrandPerformanceManager.qB(rVar.ivH)) {
            str = com.tencent.mm.plugin.appbrand.appcache.l.a(rVar.ixr, "WAPerf.js");
        }
        str = append.append(str).toString();
        g.oUh.a(370, 1, 1, false);
        com.tencent.mm.plugin.appbrand.m.g.a(rVar, str, new com.tencent.mm.plugin.appbrand.m.g.a(rVar) {
            final /* synthetic */ r jei;

            {
                this.jei = r1;
            }

            public final void PK() {
                g.oUh.a(370, 3, 1, false);
            }

            public final void nu(String str) {
                w.e("MicroMsg.AppBrandWebView", "Inject SDK Page Script Failed: %s", new Object[]{str});
                g.oUh.a(370, 2, 1, false);
                com.tencent.mm.plugin.appbrand.report.a.al(this.jei.ivH, 24);
                com.tencent.mm.plugin.appbrand.report.a.b(this.jei.ivH, this.jei.ixr.iwo.iFk.izW, this.jei.ixr.iwo.iFk.izV, 370, 2);
            }
        });
    }

    static /* synthetic */ void h(r rVar) {
        Iterator it = rVar.jeb.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            super.evaluateJavascript((String) pair.first, (y) pair.second);
        }
        rVar.jeb.clear();
    }

    public r(Context context, h hVar) {
        super(context);
        this.ixy = false;
        this.jef = null;
        this.jeg = null;
        this.ixz = new WebViewClient(this) {
            final /* synthetic */ r jei;

            {
                this.jei = r1;
            }

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                w.i("MicroMsg.AppBrandWebView", "onPageStarted, url = %s", new Object[]{str});
                this.jei.ixy = false;
            }

            public final void onPageFinished(WebView webView, String str) {
                w.i("MicroMsg.AppBrandWebView", "onPageFinished, url = %s", new Object[]{str});
                if (!this.jei.ixy) {
                    this.jei.ixy = true;
                    r.d(this.jei);
                    r.e(this.jei);
                    this.jei.ixr.iwB.k(3, System.currentTimeMillis() - this.jei.jec);
                    com.tencent.mm.plugin.appbrand.performance.a.a(this.jei.ivH, "Native", "WebViewInit+PageFrameLoad", this.jei.jec, System.currentTimeMillis(), "");
                    if (this.jei.jdU != null) {
                        w.i("MicroMsg.AppBrandWebView", "Inject page on frame load finished");
                        this.jei.qv(this.jei.jdU);
                    }
                    r.h(this.jei);
                }
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                w.i("MicroMsg.AppBrandWebView", "shouldOverrideUrlLoading, url = %s", new Object[]{str});
                return true;
            }

            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                w.e("MicroMsg.AppBrandWebView", "SSL Error, Page URL: %s, Code %d", new Object[]{this.jei.jdU, Integer.valueOf(sslError.getPrimaryError())});
                r.a(this.jei, sslErrorHandler, sslError);
            }

            private WebResourceResponse qw(String str) {
                WebResourceResponse c;
                boolean z;
                if (str.startsWith(this.jei.We())) {
                    c = com.tencent.mm.plugin.appbrand.appcache.l.c(this.jei.ixr, str.replaceFirst(this.jei.We(), ""));
                } else if (str.startsWith("wxfile://")) {
                    AppBrandLocalMediaObject aH = c.aH(this.jei.ivH, str);
                    if (aH != null) {
                        try {
                            c = new WebResourceResponse(aH.mimeType, ProtocolPackage.ServerEncoding, new FileInputStream(aH.hos));
                        } catch (Throwable e) {
                            w.e("MicroMsg.AppBrandWebView", "tryInterceptWebViewRequest with localId(%s), exp = %s", new Object[]{str, bg.g(e)});
                        }
                    }
                    c = null;
                } else {
                    c = com.tencent.mm.plugin.appbrand.appcache.l.c(this.jei.ixr, str);
                }
                String str2 = "MicroMsg.AppBrandWebView";
                String str3 = "tryInterceptWebViewRequest, reqURL = %s, WebResourceResponse == null ? %b";
                Object[] objArr = new Object[2];
                objArr[0] = str;
                if (c == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                w.i(str2, str3, objArr);
                return c;
            }

            public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                if (bg.mA(str)) {
                    return null;
                }
                return qw(str);
            }

            public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                if (webResourceRequest == null || webResourceRequest.getUrl() == null || bg.mA(webResourceRequest.getUrl().toString())) {
                    return null;
                }
                return qw(webResourceRequest.getUrl().toString());
            }

            public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
                if (webResourceRequest == null || webResourceRequest.getUrl() == null || bg.mA(webResourceRequest.getUrl().toString())) {
                    return null;
                }
                return qw(webResourceRequest.getUrl().toString());
            }

            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                w.e("MicroMsg.AppBrandWebView", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[]{Integer.valueOf(i), str, str2});
            }

            public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                Uri url = webResourceRequest.getUrl();
                String uri = url == null ? "null" : url.toString();
                w.e("MicroMsg.AppBrandWebView", "onReceivedError, WebResourceRequest url = %s, description = %s, errCode = %d", new Object[]{uri, webResourceError.getDescription(), Integer.valueOf(webResourceError.getErrorCode())});
            }

            public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                Uri url = webResourceRequest.getUrl();
                String uri = url == null ? "null" : url.toString();
                w.e("MicroMsg.AppBrandWebView", "onReceivedHttpError, WebResourceRequest url = %s, ErrWebResourceResponse mimeType = %s, status = %d", new Object[]{uri, webResourceResponse.getMimeType(), Integer.valueOf(webResourceResponse.getStatusCode())});
            }
        };
        this.jeh = new WebChromeClient(this) {
            final /* synthetic */ r jei;

            {
                this.jei = r1;
            }

            public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                try {
                    this.jei.g(view, true);
                    this.jei.jdZ = customViewCallback;
                } catch (Exception e) {
                    w.e("MicroMsg.AppBrandWebView", "onShowCustomView error " + e.getMessage());
                }
            }

            public final void onHideCustomView() {
                try {
                    this.jei.Wf();
                } catch (Exception e) {
                    w.e("MicroMsg.AppBrandWebView", "onHideCustomView error " + e.getMessage());
                }
            }
        };
        this.mWebViewCallbackClient = new ab(this) {
            final /* synthetic */ r jei;

            {
                this.jei = r1;
            }

            public final boolean s(MotionEvent motionEvent) {
                return this.jei.J(motionEvent);
            }

            public final boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
                return this.jei.b(i, i2, i3, i4, i5, i6, i7, i8, z);
            }

            public final void UN() {
                this.jei.caJ();
            }

            @TargetApi(9)
            public final void b(int i, int i2, boolean z, boolean z2) {
                this.jei.c(i, i2, z, z2);
            }

            public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
                if (this.jei.jdW != null) {
                    this.jei.jdW.onScrollChanged(i, i2, i3, i4, view);
                }
                this.jei.v(i, i2, i3, i4);
            }

            public final boolean t(MotionEvent motionEvent) {
                return this.jei.K(motionEvent);
            }

            public final boolean u(MotionEvent motionEvent) {
                return this.jei.L(motionEvent);
            }
        };
        this.iYQ = new ProxyWebViewClientExtension(this) {
            final /* synthetic */ r jei;

            {
                this.jei = r1;
            }

            public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
                return this.jei.mWebViewCallbackClient.s(motionEvent);
            }

            public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
                return this.jei.mWebViewCallbackClient.u(motionEvent);
            }

            public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
                return this.jei.mWebViewCallbackClient.t(motionEvent);
            }

            public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
                return this.jei.mWebViewCallbackClient.a(i, i2, i3, i4, i5, i6, i7, i8, z);
            }

            public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
                this.jei.mWebViewCallbackClient.onScrollChanged(i, i2, i3, i4, view);
            }

            public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
                this.jei.mWebViewCallbackClient.b(i, i2, z, z2);
            }

            public final void computeScroll(View view) {
                this.jei.mWebViewCallbackClient.UN();
            }

            public final boolean onShowLongClickPopupMenu() {
                if (WebView.getTbsCoreVersion(this.jei.getContext()) >= 43011) {
                    return false;
                }
                return true;
            }

            public final void invalidate() {
            }

            public final Object onMiscCallBack(String str, Bundle bundle) {
                if (bg.mA(str) || bundle == null) {
                    return null;
                }
                w.i("MicroMsg.AppBrandWebView", "method = %s", new Object[]{str});
                if (!str.equalsIgnoreCase("shouldInterceptMediaUrl")) {
                    return null;
                }
                String string = bundle.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                if (bg.mA(string)) {
                    return null;
                }
                AppBrandLocalMediaObject aH = c.aH(this.jei.ivH, string);
                if (aH == null) {
                    w.e("MicroMsg.AppBrandWebView", "get meidiaobj failed, appid : %s, localid :%s", new Object[]{this.jei.ivH, string});
                    return null;
                }
                Object obj = aH.hos;
                w.i("MicroMsg.AppBrandWebView", new StringBuilder(DownloadInfoColumns.FILEPATH).append(obj).append("tempFilePath").append(string).toString());
                return obj;
            }
        };
        this.gRU = true;
        this.wwS = getX5WebViewExtension() != null;
        this.ixr = hVar;
        this.ivH = hVar.ivH;
        this.jeb = new LinkedList();
        this.jec = System.currentTimeMillis();
        fh(getContext());
        getSettings().setDomStorageEnabled(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        getSettings().setMixedContentMode(0);
        getSettings().setUserAgentString(s.aZ(getContext(), getSettings().getUserAgentString()));
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(false);
        setWebViewClient(this.ixz);
        setWebChromeClient(this.jeh);
        setWebViewCallbackClient(this.mWebViewCallbackClient);
        if (this.wwS) {
            getX5WebViewExtension().setWebViewClientExtension(this.iYQ);
        }
        w.i("MicroMsg.AppBrandWebView", "Is the current broswer kernel X5, " + this.wwS);
        setBackgroundColor(-1);
        setLayoutParams(new LayoutParams(-1, -1));
        setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ r jei;

            {
                this.jei = r1;
            }

            public final boolean onLongClick(View view) {
                if (WebView.getTbsCoreVersion(this.jei.getContext()) >= 43011) {
                    return false;
                }
                return true;
            }
        });
        setDownloadListener(new DownloadListener(this) {
            final /* synthetic */ r jei;

            {
                this.jei = r1;
            }

            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                w.i("MicroMsg.AppBrandWebView", "onDownloadStart called, url = %s, mimeType = %s, userAgent = %s", new Object[]{str, str4, str2});
            }
        });
        com.tencent.mm.plugin.appbrand.l.nt(this.ivH).ixq = true;
        com.tencent.mm.plugin.appbrand.report.a.cc(this.wwS);
        this.jdX = i.qa(this.ivH);
    }

    public final void qu(String str) {
        if (!bg.mA(str) && b.bIu()) {
            evaluateJavascript("document.title=\"" + str + "\"", null);
        }
    }

    public final void evaluateJavascript(final String str, final y<String> yVar) {
        if (this.ixy) {
            Runnable anonymousClass3 = new Runnable(this) {
                final /* synthetic */ r jei;

                public final void run() {
                    super.evaluateJavascript(str, yVar);
                }
            };
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                anonymousClass3.run();
                return;
            } else {
                post(anonymousClass3);
                return;
            }
        }
        this.jeb.add(new Pair(str, yVar));
    }

    public final void Po() {
    }

    public final void pause() {
    }

    public final void resume() {
    }

    public final boolean Pp() {
        return false;
    }

    public final void destroy() {
        super.destroy();
    }

    private static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            w.e("MicroMsg.AppBrandWebView", e.getMessage());
        }
    }

    final String We() {
        if (this.jef == null) {
            this.jef = "https://servicewechat.com/" + this.ivH + "/" + this.ixr.iwo.iFk.izW + "/";
        }
        return this.jef;
    }

    final void qv(String str) {
        this.jed = System.currentTimeMillis();
        String a = com.tencent.mm.plugin.appbrand.appcache.l.a(this.ixr, str);
        if (bg.mA(a)) {
            w.e("MicroMsg.AppBrandWebView", "Cache content empty, abort inject");
            return;
        }
        int indexOf = a.indexOf("<style>");
        int indexOf2 = a.indexOf("</style>");
        String substring = (indexOf == -1 || indexOf2 == (-indexOf)) ? "" : a.substring(indexOf + 7, indexOf2);
        String encodeToString = Base64.encodeToString(substring.getBytes(), 2);
        indexOf = a.indexOf("<page>");
        int indexOf3 = a.indexOf("</page>");
        substring = (indexOf == -1 || indexOf3 == (-indexOf)) ? "" : a.substring(indexOf + 6, indexOf3);
        String encodeToString2 = Base64.encodeToString(substring.getBytes(), 2);
        indexOf = a.indexOf("<script>");
        int indexOf4 = a.indexOf("</script>");
        substring = (indexOf == -1 || indexOf4 == (-indexOf)) ? "" : a.substring(indexOf + 8, indexOf4);
        evaluateJavascript(String.format("var style = document.createElement('style');style.innerHTML = atob(\"%s\");document.head.appendChild(style);var page = document.createElement('page');page.innerHTML = atob(\"%s\");document.body.appendChild(page);%s", new Object[]{encodeToString, encodeToString2, substring}), null);
    }

    final void g(View view, boolean z) {
        Wf();
        this.jdY = view;
        MMActivity mMActivity = (MMActivity) getContext();
        ViewGroup viewGroup = (ViewGroup) mMActivity.getWindow().getDecorView();
        viewGroup.addView(view, new LayoutParams(-1, -1));
        if (com.tencent.mm.compatible.util.d.ep(19)) {
            viewGroup.setSystemUiVisibility(2);
        } else {
            viewGroup.setSystemUiVisibility(4098);
        }
        mMActivity.getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        if (z) {
            mMActivity.setRequestedOrientation(0);
        }
    }

    public final void Wf() {
        if (this.jdY != null) {
            if (this.jdZ != null) {
                this.jdZ.onCustomViewHidden();
            }
            MMActivity mMActivity = (MMActivity) getContext();
            ViewGroup viewGroup = (ViewGroup) mMActivity.getWindow().getDecorView();
            viewGroup.setSystemUiVisibility(0);
            viewGroup.removeView(this.jdY);
            mMActivity.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            if (mMActivity.getRequestedOrientation() == 0) {
                mMActivity.setRequestedOrientation(1);
            }
            this.jdY = null;
            this.jdZ = null;
            if (this.jea != null) {
                this.jea.Uz();
            }
        }
    }
}
