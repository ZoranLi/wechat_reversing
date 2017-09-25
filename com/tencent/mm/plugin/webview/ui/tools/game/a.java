package com.tencent.mm.plugin.webview.ui.tools.game;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetLocation;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.d.g;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.Map;

public final class a {
    public ViewGroup Fa;
    public Context mContext;
    public MMWebView qjb;
    public GameWebViewUI sip;
    public c siq;
    public d sir;
    public com.tencent.mm.plugin.webview.ui.tools.jsapi.d sis;
    public com.tencent.mm.plugin.webview.wepkg.a sit;
    public a siu;
    public f siv;
    public com.tencent.mm.plugin.webview.ui.tools.widget.d siw = new com.tencent.mm.plugin.webview.ui.tools.widget.d(this) {
        final /* synthetic */ a six;

        {
            this.six = r1;
        }

        public final void M(Bundle bundle) {
            w.i("MicroMsg.GameFloatWebView", l.NAME);
            try {
                this.six.Fa.removeView(this.six.qjb);
            } catch (Exception e) {
            }
        }

        public final Bundle d(int i, final Bundle bundle) {
            w.i("MicroMsg.GameFloatWebView", "game float invokeAsResult, actionCode = " + i);
            final Bundle bundle2 = new Bundle();
            final String string;
            final int i2;
            boolean z;
            String VD;
            int init;
            switch (i) {
                case 18:
                    bundle2.putString("KPublisherId", c.fUX);
                    bundle2.putInt("getA8KeyScene", this.six.cf(c.siM, c.gaA));
                    break;
                case JsApiGetLocation.CTRL_INDEX /*37*/:
                    string = bundle.getString("show_kb_placeholder");
                    i2 = bundle.getInt("show_kb_max_length");
                    this.six.sip.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 siy;

                        public final void run() {
                            this.siy.six.sip.ce(string, i2);
                        }
                    });
                    break;
                case 43:
                    string = bundle.getString("set_page_title_text");
                    i2 = com.tencent.mm.plugin.webview.ui.tools.d.cd(bundle.getString("set_page_title_color"), this.six.sip.getResources().getColor(R.e.aSC));
                    this.six.sip.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 siy;

                        public final void run() {
                            if (string != null) {
                                this.siy.six.sip.qP(string);
                            }
                            this.siy.six.sip.zh(i2);
                        }
                    });
                    break;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    this.six.sip.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 siy;

                        public final void run() {
                            this.siy.six.sip.R(bundle);
                        }
                    });
                    break;
                case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    z = bundle.getBoolean("add_shortcut_status");
                    if (this.six.sis != null) {
                        this.six.sis.iX(z);
                        break;
                    }
                    break;
                case JsApiOperateWXData.CTRL_INDEX /*79*/:
                    this.six.sip.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 siy;

                        public final void run() {
                            bundle2.putInt("height", this.siy.six.sip.byg());
                        }
                    });
                    break;
                case 84:
                    CharSequence bPV = this.six.sip.bPV();
                    VD = VD();
                    bundle2.putString("webview_current_url", VD);
                    bundle2.putString("webview_current_title", bPV != null ? bPV.toString() : "");
                    bundle2.putString("webview_current_desc", VD);
                    break;
                case 87:
                    z = this.six.siu.sno;
                    VD = this.six.siu.mmP;
                    Map map = this.six.siu.snp;
                    if (!z) {
                        bundle2.putString("full_url", bg.mz(VD));
                        if (map != null && map.size() != 0) {
                            bundle2.putInt("set_cookie", 1);
                            CookieSyncManager.createInstance(ab.getContext());
                            CookieManager instance = CookieManager.getInstance();
                            for (String string2 : map.keySet()) {
                                instance.setCookie(bg.mz(VD), string2 + "=" + ((String) map.get(string2)));
                            }
                            CookieSyncManager.getInstance().sync();
                            w.i("MicroMsg.GameFloatWebView", "cookies:%s", new Object[]{instance.getCookie(bg.mz(VD))});
                            break;
                        }
                        bundle2.putInt("set_cookie", 0);
                        break;
                    }
                    bundle2.putString("result", "not_return");
                    break;
                case 99:
                    bundle2.putInt("geta8key_scene", c.gaA);
                    w.i("MicroMsg.GameFloatWebView", "Key value: getA8KeyScene(%d)", new Object[]{Integer.valueOf(init)});
                    break;
                case 101:
                    bundle.setClassLoader(Activity.class.getClassLoader());
                    com.tencent.mm.bb.d.b(this.six.mContext, bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", c.fUX));
                    break;
                case 5001:
                    if (this.six.sir.isSDCardAvailable()) {
                        w.i("MicroMsg.GameFloatWebView", "availableSize = %d", new Object[]{Long.valueOf(av.bJE())});
                        if (av.bJE() < 524288000) {
                            w.e("MicroMsg.GameFloatWebView", "available size not enough");
                            init = FactoryProxyManager.getPlayManager().init(this.six.mContext, null);
                        } else {
                            File file = new File(com.tencent.mm.plugin.webview.a.rUY);
                            z = true;
                            if (!file.exists()) {
                                z = file.mkdirs();
                                w.i("MicroMsg.GameFloatWebView", "create proxy cache path : %s, %b", new Object[]{file.getAbsolutePath(), Boolean.valueOf(z)});
                            }
                            if (z) {
                                init = FactoryProxyManager.getPlayManager().init(this.six.mContext, com.tencent.mm.plugin.webview.a.rUY);
                                FactoryProxyManager.getPlayManager().setMaxStorageSize(200);
                            } else {
                                init = FactoryProxyManager.getPlayManager().init(this.six.mContext, null);
                            }
                        }
                    } else {
                        w.i("MicroMsg.GameFloatWebView", "sdcard not available");
                        init = FactoryProxyManager.getPlayManager().init(this.six.mContext, null);
                    }
                    bundle2.putInt("webview_video_proxy_init", init);
                    break;
                case 5002:
                    VD = bundle.getString("webview_video_proxy_cdn_urls");
                    String string3 = bundle.getString("webview_video_proxy_fileId");
                    int i3 = bundle.getInt("webview_video_proxy_file_size");
                    init = FactoryProxyManager.getPlayManager().startPlay(VD, bundle.getInt("webview_video_proxy_file_type"), string3, (long) i3, bundle.getInt("webview_video_proxy_file_duration"));
                    w.i("MicroMsg.GameFloatWebView", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[]{VD, string3, Integer.valueOf(i3), Integer.valueOf(r6), Integer.valueOf(r2), Integer.valueOf(init), FactoryProxyManager.getPlayManager().buildPlayURLMp4(init)});
                    bundle2.putInt("webview_video_proxy_play_data_id", init);
                    bundle2.putString("webview_video_proxy_local_url", r4);
                    break;
                case 5003:
                    init = bundle.getInt("webview_video_proxy_play_data_id");
                    w.i("MicroMsg.GameFloatWebView", "webview proxy stop play, play id = %d", new Object[]{Integer.valueOf(init)});
                    if (init > 0) {
                        FactoryProxyManager.getPlayManager().stopPlay(init);
                        break;
                    }
                    break;
                case 5004:
                    FactoryProxyManager.getPlayManager().setPlayerState(bundle.getInt("webview_video_proxy_play_state"));
                    break;
                case 5005:
                    FactoryProxyManager.getPlayManager().setNetWorkState(bundle.getInt("webview_video_proxy_net_state"));
                    break;
                case 5006:
                    FactoryProxyManager.getPlayManager().setRemainTime(bundle.getInt("webview_video_proxy_play_data_id"), bundle.getInt("webview_video_proxy_play_remain_time"));
                    break;
                case 5007:
                    w.i("MicroMsg.GameFloatWebView", "playid = %d, duration = %d", new Object[]{Integer.valueOf(bundle.getInt("webview_video_proxy_play_data_id")), Integer.valueOf(bundle.getInt("webview_video_proxy_preload_duration"))});
                    bundle2.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(init, i2));
                    break;
                case 6001:
                    w.i("MicroMsg.GameFloatWebView", "includeCookie = %b", new Object[]{Boolean.valueOf(bundle.getBoolean("clear_webview_cache_clear_cookie", false))});
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                    intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    intent.putExtra("tools_clean_webview_cache_ignore_cookie", z);
                    this.six.mContext.sendBroadcast(intent);
                    break;
                case 90001:
                    w.i("MicroMsg.GameFloatWebView", "url = %s, cookie = %s", new Object[]{VD(), CookieManager.getInstance().getCookie(VD())});
                    bundle2.putString("cookie", VD);
                    break;
                case 90002:
                    com.tencent.mm.plugin.webview.ui.tools.g.scG.dT(bundle.getString("traceid"), bundle.getString("username"));
                    break;
                default:
                    w.e("MicroMsg.GameFloatWebView", "undefine action code!!!");
                    break;
            }
            return bundle2;
        }
    };

    private class b extends ProxyWebViewClientExtension {
        final /* synthetic */ a six;

        public b(a aVar) {
            this.six = aVar;
        }

        public final Object onMiscCallBack(String str, Bundle bundle) {
            Object onMiscCallBack = this.six.sit.soW.onMiscCallBack(str, bundle);
            return onMiscCallBack != null ? onMiscCallBack : super.onMiscCallBack(str, bundle);
        }
    }

    private class a extends b {
        final /* synthetic */ a six;

        public a(a aVar, MMWebView mMWebView) {
            this.six = aVar;
            super(mMWebView);
        }

        protected final void a(WebView webView, String str, Bitmap bitmap) {
            w.i("MicroMsg.GameFloatWebView", "onPageStarted opt, url = " + str);
            this.six.sit.soV.onPageStarted(webView, str, bitmap);
        }

        protected final void a(WebView webView, String str) {
            w.i("MicroMsg.GameFloatWebView", "onPageFinished opt, url = %s", new Object[]{str});
            this.qjb.setVisibility(0);
            this.six.sit.soV.onPageFinished(webView, str);
            this.six.sit.onDestroy();
        }

        protected final void a(d dVar, e eVar) {
            this.six.sir = dVar;
        }

        protected final void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar) {
            w.i("MicroMsg.GameFloatWebView", "jsapi ready");
            this.six.sis = dVar;
        }

        protected final void a(f fVar) {
            w.i("MicroMsg.GameFloatWebView", "jsloader ready");
            this.six.siv = fVar;
        }

        protected final boolean JO(String str) {
            return this.six.sit.soO;
        }

        protected final void xG(String str) {
            if (this.six.sit.bAn()) {
                this.qjb.loadUrl(str);
            } else {
                super.xG(str);
            }
        }

        protected final boolean JX(String str) {
            return super.JX(str);
        }

        protected final void JY(String str) {
            try {
                w.i("MicroMsg.GameFloatWebView", "onURLFilteredOut url:%s", new Object[]{str});
                this.six.Fa.removeView(this.qjb);
            } catch (Exception e) {
            }
        }

        protected final void bze() {
            if (VERSION.SDK_INT >= 11) {
                this.qjb.removeJavascriptInterface("MicroMsg");
                this.qjb.removeJavascriptInterface("JsApi");
            }
            try {
                this.qjb.setWebChromeClient(null);
                this.qjb.setWebViewClient(null);
                this.qjb.setOnTouchListener(null);
                this.qjb.setOnLongClickListener(null);
                this.qjb.setVisibility(8);
                this.qjb.removeAllViews();
                this.qjb.clearView();
            } catch (Exception e) {
                w.e("MicroMsg.GameFloatWebView", "onDestroy, set web infos to null,  ex = %s", new Object[]{e.getMessage()});
            }
            try {
                this.qjb.destroy();
            } catch (Exception e2) {
                w.w("MicroMsg.GameFloatWebView", "onDestroy, viewWV destroy, ex = %s", new Object[]{e2.getMessage()});
            }
            this.qjb = null;
        }

        protected final com.tencent.mm.plugin.webview.ui.tools.widget.d UO() {
            return this.six.siw;
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebResourceResponse shouldInterceptRequest = this.six.sit.soV.shouldInterceptRequest(webView, str);
            return shouldInterceptRequest != null ? shouldInterceptRequest : super.shouldInterceptRequest(webView, str);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebResourceResponse shouldInterceptRequest = this.six.sit.soV.shouldInterceptRequest(webView, webResourceRequest);
            return shouldInterceptRequest != null ? shouldInterceptRequest : super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            WebResourceResponse shouldInterceptRequest = this.six.sit.soV.shouldInterceptRequest(webView, webResourceRequest, bundle);
            return shouldInterceptRequest != null ? shouldInterceptRequest : super.shouldInterceptRequest(webView, webResourceRequest, bundle);
        }
    }

    public a(GameWebViewUI gameWebViewUI, ViewGroup viewGroup) {
        this.mContext = gameWebViewUI;
        this.sip = gameWebViewUI;
        this.Fa = viewGroup;
        WebView dg = com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a.dg(this.mContext);
        dg.setBackgroundResource(17170445);
        dg.setBackgroundColor(0);
        dg.setVisibility(8);
        this.siu = new a(this, dg);
        dg.setWebViewClient(this.siu);
        if (dg.wwS) {
            dg.getX5WebViewExtension().setWebViewClientExtension(new b(this));
        }
        dg.getSettings().setJavaScriptEnabled(true);
        dg.getSettings().setDomStorageEnabled(true);
        dg.getSettings().setBuiltInZoomControls(false);
        dg.getSettings().setUseWideViewPort(true);
        dg.getSettings().setLoadWithOverviewMode(true);
        dg.getSettings().setSavePassword(false);
        dg.getSettings().setSaveFormData(false);
        dg.getSettings().setGeolocationEnabled(true);
        dg.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        dg.getSettings().setMixedContentMode(0);
        dg.getSettings().setAppCacheMaxSize(10485760);
        dg.getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
        dg.getSettings().setAppCacheEnabled(true);
        dg.getSettings().setDatabaseEnabled(true);
        dg.getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.hgp + "databases/");
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(dg, true);
        this.qjb = dg;
        this.siq = new c(gameWebViewUI.getIntent());
        this.sit = new com.tencent.mm.plugin.webview.wepkg.a(gameWebViewUI, this.qjb, this.qjb.hashCode());
    }

    public final void loadUrl(String str) {
        this.sit.onCreate(str);
        this.Fa.addView(this.qjb);
        this.qjb.setVisibility(8);
        this.siu.JX(str);
    }

    public final int cf(String str, int i) {
        if (i == 0) {
            if (str == null || str.length() <= 0) {
                i = 0;
            } else if (this.sir == null) {
                i = 1;
            } else {
                try {
                    i = this.sir.fE(str) ? 8 : this.sir.eV(str) ? 7 : 1;
                } catch (Exception e) {
                    w.e("MicroMsg.GameFloatWebView", "getScene fail, ex = " + e.getMessage());
                    i = 1;
                }
            }
        }
        w.i("MicroMsg.GameFloatWebView", "KGetA8KeyScene = %s", new Object[]{Integer.valueOf(i)});
        return i;
    }
}
