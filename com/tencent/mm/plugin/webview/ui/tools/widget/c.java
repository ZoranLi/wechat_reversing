package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.plugin.webview.modelcache.o;
import com.tencent.mm.plugin.webview.modelcache.p;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class c extends WebViewClient {
    public ae mHandler;
    private Set<String> mmM;
    public String mmO;
    public String mmP;
    private String mmT;
    public boolean mmV;
    protected Activity oqR;
    public MMWebView qjb;
    private final Map<String, Map<String, String>> sec;
    public d sir;
    public com.tencent.mm.plugin.webview.ui.tools.jsapi.d sis;
    private f siv;
    public e sjT;
    protected b snh;
    public a sni;
    public String snj;
    private String snk;
    private List<com.tencent.mm.plugin.webview.ui.tools.jsapi.b> snl;
    private final Map<String, String> snm;
    public boolean snn;
    public boolean sno;
    public Map<String, String> snp;
    public c snq;
    public d snr;

    protected static class a {
        private static final Pattern mlF = Pattern.compile(".*#.*wechat_redirect");
        private String mlG = null;

        public a(String str) {
            this.mlG = str;
        }

        public final int xB(String str) {
            if (bg.mA(str)) {
                w.e("MicroMsg.MMWebViewClient", "getReason fail, url is null");
                return 0;
            } else if (str.equals(this.mlG)) {
                return 0;
            } else {
                if (mlF.matcher(str).find()) {
                    return 2;
                }
                return 1;
            }
        }
    }

    protected class b {
        int sfT = 0;
        final /* synthetic */ c sns;

        protected b(c cVar) {
            this.sns = cVar;
        }
    }

    protected class c implements ServiceConnection {
        final /* synthetic */ c sns;

        public c(c cVar) {
            this.sns = cVar;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            w.i("MicroMsg.MMWebViewClient", "onServiceConnected");
            if (this.sns.qjb == null) {
                w.e("MicroMsg.MMWebViewClient", "onServiceConnected, activity destroyed");
                return;
            }
            try {
                this.sns.sir = com.tencent.mm.plugin.webview.stub.d.a.V(iBinder);
                this.sns.sir.a(this.sns.snr, this.sns.qjb.hashCode());
                this.sns.a(this.sns.sir, this.sns.sjT);
                this.sns.bzV();
                this.sns.bzf();
            } catch (Exception e) {
                w.e("MicroMsg.MMWebViewClient", "addCallback fail, ex = %s", new Object[]{e.getMessage()});
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            w.i("MicroMsg.MMWebViewClient", "edw onServiceDisconnected");
            if (this.sns.oqR.isFinishing()) {
                this.sns.sir = null;
                return;
            }
            w.i("MicroMsg.MMWebViewClient", "maybe mm process crash, try rebind service");
            this.sns.bxW();
        }
    }

    public c() {
        this.siv = null;
        this.sis = null;
        this.mmV = false;
        this.mmT = "";
        this.mmM = new HashSet();
        this.snh = new b(this);
        this.sni = new a(null);
        this.snj = null;
        this.mmO = null;
        this.snk = null;
        this.snl = new ArrayList();
        this.snm = new HashMap();
        this.sec = new ConcurrentHashMap();
        this.snn = false;
        this.sno = false;
        this.snq = new c(this);
        this.snr = new d(this) {
            final /* synthetic */ c sns;
            private d snt = new d();

            {
                this.sns = r2;
            }

            private d bzX() {
                d UO = this.sns.UO();
                if (UO == null) {
                    return this.snt;
                }
                return UO;
            }

            public final boolean vY(int i) {
                return bzX().vY(i);
            }

            public final boolean m(int i, final Bundle bundle) {
                w.i("MicroMsg.MMWebViewClient", "callback, actionCode = " + i);
                final Map hashMap;
                final String string;
                final int i2;
                switch (i) {
                    case PlayerException.EXCEPTION_IN_SETDATASOURCE /*90*/:
                        if (this.sns.sis != null) {
                            this.sns.mHandler.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass4 snu;

                                public final void run() {
                                    if (this.snu.sns.sis != null) {
                                        this.snu.sns.sis.Kd(bundle.getString("webview_network_type"));
                                    }
                                }
                            });
                            break;
                        }
                        break;
                    case MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED /*1002*/:
                        this.sns.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 snu;

                            public final void run() {
                                if (this.snu.sns.sis != null && this.snu.sns.sjT != null && this.snu.sns.sjT.bxQ() != null && this.snu.sns.sjT.bxQ().nw(42)) {
                                    this.snu.sns.sis.f(bundle, "download_succ");
                                }
                            }
                        });
                        break;
                    case MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED /*1003*/:
                        this.sns.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 snu;

                            public final void run() {
                                if (this.snu.sns.sis != null && this.snu.sns.sjT != null && this.snu.sns.sjT.bxQ() != null && this.snu.sns.sjT.bxQ().nw(42)) {
                                    this.snu.sns.sis.f(bundle, "download_fail");
                                }
                            }
                        });
                        break;
                    case MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT /*1006*/:
                        if (this.sns.sis != null) {
                            this.sns.mHandler.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass4 snu;

                                public final void run() {
                                    boolean z = false;
                                    byte[] byteArray = bundle.getByteArray("jsapi_control_bytes");
                                    if (byteArray == null || this.snu.sns.sjT == null || this.snu.sns.sjT.bxQ() == null) {
                                        String str = "MicroMsg.MMWebViewClient";
                                        String str2 = "has JSAPI_CONTROL_BYTES %b, has wvPerm %b";
                                        Object[] objArr = new Object[2];
                                        objArr[0] = Boolean.valueOf(byteArray != null);
                                        if (this.snu.sns.sjT != null) {
                                            z = true;
                                        }
                                        objArr[1] = Boolean.valueOf(z);
                                        w.e(str, str2, objArr);
                                    } else {
                                        w.i("MicroMsg.MMWebViewClient", "update control bytes, %d", new Object[]{Integer.valueOf(byteArray.length)});
                                        this.snu.sns.sjT.bxQ().sZd = byteArray;
                                    }
                                    if (this.snu.sns.sis != null) {
                                        this.snu.sns.sis.bzk();
                                    }
                                }
                            });
                            break;
                        }
                        break;
                    case MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE /*1007*/:
                        final long j = bundle.getLong("download_manager_downloadid");
                        final int i3 = bundle.getInt("download_manager_progress");
                        final String string2 = bundle.getString("download_manager_appid", "");
                        this.sns.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 snu;

                            public final void run() {
                                if (this.snu.sns.sis != null && this.snu.sns.sjT != null && this.snu.sns.sjT.bxQ() != null && this.snu.sns.sjT.bxQ().nw(42)) {
                                    this.snu.sns.sis.f(string2, j, i3);
                                }
                            }
                        });
                        break;
                    case MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE /*1008*/:
                        this.sns.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 snu;

                            public final void run() {
                                if (this.snu.sns.sis != null && this.snu.sns.sjT != null && this.snu.sns.sjT.bxQ() != null && this.snu.sns.sjT.bxQ().nw(42)) {
                                    this.snu.sns.sis.f(bundle, "download_removed");
                                }
                            }
                        });
                        break;
                    case MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK /*2002*/:
                        hashMap = new HashMap();
                        hashMap.put("err_msg", bundle.getString("playResult"));
                        hashMap.put("localId", bundle.getString("localId"));
                        this.sns.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 snu;

                            public final void run() {
                                if (this.snu.sns.sis != null) {
                                    this.snu.sns.sis.V(hashMap);
                                }
                            }
                        });
                        break;
                    case MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK /*2003*/:
                        string = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        this.sns.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 snu;

                            public final void run() {
                                if (this.snu.sns.sis != null) {
                                    this.snu.sns.sis.ch(string, i2);
                                }
                            }
                        });
                        break;
                    case 2004:
                        string = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        this.sns.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 snu;

                            public final void run() {
                                if (this.snu.sns.sis != null) {
                                    this.snu.sns.sis.ci(string, i2);
                                }
                            }
                        });
                        break;
                    case 2005:
                        string = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        this.sns.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 snu;

                            public final void run() {
                                if (this.snu.sns.sis != null) {
                                    this.snu.sns.sis.cj(string, i2);
                                }
                            }
                        });
                        break;
                    case 2006:
                        string = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        this.sns.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 snu;

                            public final void run() {
                                if (this.snu.sns.sis != null) {
                                    this.snu.sns.sis.ck(string, i2);
                                }
                            }
                        });
                        break;
                    case 2008:
                        hashMap = new HashMap();
                        hashMap.put("localId", bundle.getString("localId"));
                        hashMap.put("err_msg", bundle.getString("recordResult"));
                        this.sns.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 snu;

                            public final void run() {
                                if (this.snu.sns.sis != null) {
                                    this.snu.sns.sis.W(hashMap);
                                }
                            }
                        });
                        break;
                    case 2010:
                        string = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        this.sns.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 snu;

                            public final void run() {
                                if (this.snu.sns.sis != null) {
                                    this.snu.sns.sis.cl(string, i2);
                                }
                            }
                        });
                        break;
                    default:
                        w.e("MicroMsg.MMWebViewClient", "undefine action code!!!");
                        break;
                }
                bzX().m(i, bundle);
                return true;
            }

            public final boolean a(final com.tencent.mm.plugin.webview.stub.c cVar) {
                w.i("MicroMsg.MMWebViewClient", "onSceneEnd, instance hashcode = " + this.sns.qjb.hashCode());
                this.sns.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 snu;

                    public final void run() {
                        try {
                            this.snu.sns.a(cVar);
                        } catch (Exception e) {
                            w.e("MicroMsg.MMWebViewClient", e.getMessage());
                        }
                    }
                });
                return bzX().a(cVar);
            }

            public final boolean a(String str, String str2, Bundle bundle, boolean z) {
                if (this.sns.sis != null) {
                    final String str3 = str;
                    final String str4 = str2;
                    final Bundle bundle2 = bundle;
                    final boolean z2 = z;
                    this.sns.mHandler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 snu;

                        public final void run() {
                            this.snu.sns.sis.a(str3, str4, i.W(bundle2), z2);
                        }
                    });
                    bzX().a(str, str2, bundle, z);
                }
                return false;
            }

            public final String bxj() {
                return this.sns.snj;
            }

            public final String VD() {
                return this.sns.azN();
            }

            public final String bxk() {
                return bzX().bxk();
            }

            public final void iN(boolean z) {
                bzX().iN(z);
            }

            public final void iO(boolean z) {
                bzX().iO(z);
            }

            public final void n(int i, Bundle bundle) {
                bzX().n(i, bundle);
            }

            public final void bxl() {
                if (this.sns.sis != null) {
                    this.sns.sis.bxl();
                }
            }

            public final void M(Bundle bundle) {
                bzX().M(bundle);
            }

            public final void Jn(String str) {
                bzX().Jn(str);
            }

            public final void dQ(String str, String str2) {
                bzX().dQ(str, str2);
            }

            public final void bxm() {
                if (this.sns.sis != null) {
                    this.sns.sis.bxm();
                }
            }

            public final void e(String str, String str2, int i, int i2) {
                bzX().e(str, str2, i, i2);
            }

            public final Bundle d(int i, Bundle bundle) {
                return bzX().d(i, bundle);
            }

            public final void N(Bundle bundle) {
                bzX().N(bundle);
            }

            public final void iP(boolean z) {
                bzX().iP(z);
            }

            public final void dR(String str, String str2) {
                bzX().dR(str, str2);
            }
        };
    }

    public c(MMWebView mMWebView) {
        this(mMWebView, false);
    }

    public c(MMWebView mMWebView, boolean z) {
        this.siv = null;
        this.sis = null;
        this.mmV = false;
        this.mmT = "";
        this.mmM = new HashSet();
        this.snh = new b(this);
        this.sni = new a(null);
        this.snj = null;
        this.mmO = null;
        this.snk = null;
        this.snl = new ArrayList();
        this.snm = new HashMap();
        this.sec = new ConcurrentHashMap();
        this.snn = false;
        this.sno = false;
        this.snq = new c(this);
        this.snr = /* anonymous class already generated */;
        this.oqR = (Activity) mMWebView.getContext();
        this.qjb = mMWebView;
        this.mHandler = new ae();
        this.sjT = new e(this.oqR, mMWebView);
        this.mmV = z;
    }

    public void JY(String str) {
    }

    public void a(d dVar, e eVar) {
    }

    public d UO() {
        return null;
    }

    public int UP() {
        return 0;
    }

    public void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar) {
    }

    public void a(f fVar) {
    }

    public void e(Bundle bundle, String str) {
    }

    public boolean JO(String str) {
        if (this.qjb != null) {
            return o.a(str, this.sir, this.qjb.hashCode());
        }
        return false;
    }

    public boolean Db(String str) {
        return false;
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
    }

    public void a(WebView webView, String str) {
    }

    public void bze() {
    }

    public final boolean Kl(String str) {
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar : this.snl) {
            if (bVar.xL(str)) {
                w.i("MicroMsg.MMWebViewClient", "url handled, ret = " + bVar.xM(str) + ", url = " + str);
                return true;
            }
        }
        return Db(str);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, final String str) {
        w.i("MicroMsg.MMWebViewClient", "edw opt, shouldOverride url = " + str);
        if (this.sir == null) {
            w.e("MicroMsg.MMWebViewClient", "Service not ready yet, make sure url loading happens after service connected");
            return true;
        } else if (!z.IN(str)) {
            w.f("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, URL load failed, url = " + str);
            JY(str);
            return true;
        } else if (str.equals(this.snk)) {
            this.snk = "";
            return true;
        } else {
            boolean Kl = Kl(str);
            if (!Kl && str.startsWith("weixin://")) {
                w.e("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
                return true;
            } else if (Kl) {
                return true;
            } else {
                int xB = this.sni.xB(str);
                if ((xB != 0 && xB != 2) || this.mmV) {
                    return false;
                }
                w.i("MicroMsg.MMWebViewClient", "edw shouldOverride, should not continue, reason = " + xB);
                if (JO(str)) {
                    this.qjb.stopLoading();
                    this.qjb.post(new Runnable(this) {
                        final /* synthetic */ c sns;

                        public final void run() {
                            this.sns.xG(str);
                        }
                    });
                } else {
                    this.qjb.stopLoading();
                }
                if (str.equals(this.mmT)) {
                    w.w("MicroMsg.MMWebViewClient", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                    return false;
                }
                aB(str, true);
                return true;
            }
        }
    }

    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        w.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory, url = %s, isReload = %b", new Object[]{str, Boolean.valueOf(z)});
        super.doUpdateVisitedHistory(webView, str, z);
        String url = webView.getUrl();
        if (this.mmV) {
            aB(url, false);
        }
        if (this.sjT != null && !this.sjT.has(url)) {
            w.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory start geta8key, url = %s", new Object[]{url});
            aB(url, false);
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        w.d("MicroMsg.MMWebViewClient", "onPageStarted url = %s", new Object[]{str});
        if (JX(str)) {
            if (!this.snn) {
                webView.stopLoading();
            }
        } else if (!z.IN(str)) {
            w.f("MicroMsg.MMWebViewClient", "onPageStarted, canLoadUrl fail, url = " + str);
            JY(str);
        } else if (Kl(str)) {
            this.snk = str;
        } else {
            this.mmO = str;
            super.onPageStarted(webView, str, bitmap);
            this.siv.bzu();
            if (JO(str)) {
                this.qjb.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                if (this.sis != null) {
                    this.sis.l((String) this.snm.get(str), (Map) this.sec.get(str));
                }
            }
            aB(str, false);
            a(webView, str, bitmap);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        w.d("MicroMsg.MMWebViewClient", "onPageFinished url = %s", new Object[]{str});
        if (this.sir != null) {
            super.onPageFinished(webView, str);
            if (z.IN(str)) {
                this.snk = "";
                if (str.equals("file:///android_asset/jsapi/wxjs.js")) {
                    w.i("MicroMsg.MMWebViewClient", "onPageFinished, js is finished loaded");
                    a(webView, str);
                    return;
                }
                this.siv.bzv();
                a(webView, str);
                return;
            }
            w.f("MicroMsg.MMWebViewClient", "onPageFinished, canLoadUrl fail, url = " + str);
            JY(str);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }

    public void onLoadResource(WebView webView, String str) {
        w.i("MicroMsg.MMWebViewClient", "edw onLoadResource opt, url = " + str);
        super.onLoadResource(webView, str);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        w.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s", new Object[]{str});
        o oVar = a.rYq;
        azN();
        webView.hashCode();
        return null;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null || bg.mA(webResourceRequest.getUrl().toString())) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        w.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{webResourceRequest.getUrl(), webResourceRequest.getMethod(), Boolean.valueOf(webResourceRequest.isForMainFrame())});
        webResourceRequest.getUrl().toString();
        o oVar = a.rYq;
        azN();
        webView.hashCode();
        return null;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
        return super.shouldInterceptRequest(webView, webResourceRequest, bundle);
    }

    public final void Po() {
        if (this.snq != null) {
            try {
                this.oqR.unbindService(this.snq);
            } catch (Exception e) {
                w.e("MicroMsg.MMWebViewClient", e.getMessage());
            }
        }
        if (this.sis != null) {
            this.sis.detach();
        }
        if (this.siv != null) {
            this.siv.detach();
        }
        bzW();
        bze();
    }

    public final void bzV() {
        int i;
        Map hashMap = new HashMap();
        hashMap.put("init_url", this.snj);
        hashMap.put("webview_type", "1");
        hashMap.put("init_font_size", "1");
        this.sis = new com.tencent.mm.plugin.webview.ui.tools.jsapi.d(this.qjb, this.sjT, hashMap, this.sir, this.qjb.hashCode());
        this.sis.sjR = null;
        this.snl.add(this.sis);
        this.snl.add(new com.tencent.mm.plugin.webview.ui.tools.jsapi.e(this.qjb, this.sir, this.qjb.hashCode(), this.sis));
        this.siv = new f(this.qjb, this.sis, new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.a(this) {
            final /* synthetic */ c sns;

            {
                this.sns = r1;
            }

            public final void byG() {
                this.sns.a(this.sns.sis);
            }
        }, false);
        a(this.siv);
        try {
            i = bg.getInt(this.sir.Ju("WebviewDisableDigestVerify"), 0);
        } catch (Exception e) {
            w.w("MicroMsg.MMWebViewClient", "getting js digest verification config fails, ex = " + e.getMessage());
            i = 0;
        }
        w.i("MicroMsg.MMWebViewClient", "js digest verification config = %d", new Object[]{Integer.valueOf(i)});
        if (i == 0 && this.oqR.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true)) {
            this.siv.bzt();
        }
    }

    public void bzf() {
        try {
            this.sir.a(this.snj, true, null);
        } catch (Exception e) {
            w.w("MicroMsg.MMWebViewClient", "postBinded, jumpToActivity, ex = " + e.getMessage());
        }
        if (!Kl(this.snj)) {
            Uri parse = Uri.parse(this.snj);
            if (parse.getScheme() == null) {
                this.snj += "http://";
                parse = Uri.parse(this.snj);
            }
            if (parse.getScheme().startsWith("http")) {
                w.i("MicroMsg.MMWebViewClient", "uri scheme not startwith http, scheme = " + parse.getScheme());
                this.sni = new a(this.snn ? "" : this.snj);
                this.snn = false;
                if (this.mmV || this.sjT.has(this.snj)) {
                    this.qjb.loadUrl(this.snj);
                } else {
                    aB(this.snj, false);
                }
            } else if (z.IN(this.snj)) {
                this.qjb.loadUrl(this.snj);
            } else {
                JY(this.snj);
            }
        }
    }

    public final void bxW() {
        w.i("MicroMsg.MMWebViewClient", "tryBindService");
        this.oqR.bindService(new Intent(this.oqR, WebViewStubService.class), this.snq, 1);
    }

    public boolean JX(String str) {
        if (this.sir != null) {
            return false;
        }
        this.snj = str;
        bxW();
        return true;
    }

    public void xG(String str) {
        Map hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        this.qjb.loadUrl(str, hashMap);
    }

    public final void aB(String str, boolean z) {
        boolean z2 = false;
        if (!this.oqR.isFinishing()) {
            if (this.sjT == null) {
                w.e("MicroMsg.MMWebViewClient", "startGetA8Key fail, after onDestroy");
            } else if (this.mmV) {
                w.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, nevergeta8key");
                this.sjT.a(str, null, null);
            } else {
                boolean z3;
                if (this.sir != null && this.mmM.contains(str) && JO(str)) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if ((this.sjT.has(str) || r0) && !z) {
                    w.i("MicroMsg.MMWebViewClient", "edw startGetA8Key no need, wvPerm already has value, url = " + str);
                    return;
                }
                String str2 = "";
                int UP = UP();
                int xB = this.sni.xB(str);
                w.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, url = " + str + ", scene = " + UP + ", username = " + str2 + ", reason = " + xB + ", force = " + z);
                w.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, begin, set a default permission");
                this.mmM.add(str);
                this.sjT.a(str, null, null);
                this.sno = true;
                b bVar = this.snh;
                if (bVar.sfT == 0) {
                    c cVar = bVar.sns;
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putInt("scene_end_type", 233);
                        bundle.putInt("scene_end_listener_hash_code", cVar.qjb.hashCode());
                        cVar.sir.a(5, bundle, cVar.qjb.hashCode());
                    } catch (Exception e) {
                        w.e("MicroMsg.MMWebViewClient", "addSceneEnd, ex = " + e.getMessage());
                    }
                }
                bVar.sfT++;
                Bundle bundle2 = new Bundle();
                bundle2.putString("geta8key_data_req_url", str);
                bundle2.putString("geta8key_data_username", str2);
                bundle2.putInt("geta8key_data_scene", UP);
                bundle2.putInt("geta8key_data_reason", xB);
                if (this.qjb.getX5WebViewExtension() != null) {
                    bundle2.putInt("geta8key_data_flag", 1);
                } else {
                    bundle2.putInt("geta8key_data_flag", z2);
                }
                bundle2.putString("geta8key_data_net_type", s.bwv());
                this.mmT = str;
                e(bundle2, str);
                try {
                    z2 = this.sir.q(233, bundle2);
                } catch (Exception e2) {
                    w.w("MicroMsg.MMWebViewClient", "startGetA8Key, ex = " + e2.getMessage());
                }
                w.i("MicroMsg.MMWebViewClient", "startGetA8Key, doScene ret = " + z2);
            }
        }
    }

    private void bzW() {
        try {
            if (this.sir != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("scene_end_type", 233);
                bundle.putInt("scene_end_listener_hash_code", this.qjb.hashCode());
                this.sir.a(6, bundle, this.qjb.hashCode());
            }
        } catch (Exception e) {
            w.e("MicroMsg.MMWebViewClient", "removeSceneEnd, ex = " + e.getMessage());
        }
    }

    private void k(String str, Map<String, String> map) {
        String ap = bg.ap(azN(), this.snj);
        if (bg.mA(ap)) {
            w.e("MicroMsg.MMWebViewClient", "after getA8Key, currentURL is null or nil, wtf");
            this.qjb.loadUrl(str);
        } else if (this.sis == null) {
            this.qjb.loadUrl(str);
        } else if (bg.mz(str).contains("#wechat_redirect")) {
            this.qjb.loadUrl(str);
        } else {
            if (!dU(ap, str)) {
                String Jf = p.Jf(ap);
                String Jf2 = p.Jf(str);
                Object obj = (bg.mA(Jf2) || bg.mA(Jf) || !Jf2.equals(Jf) || this.sir == null || !JO(ap)) ? null : 1;
                if (obj == null) {
                    this.qjb.loadUrl(str);
                    return;
                }
            }
            this.snm.put(ap, str);
            this.sec.put(ap, map);
            this.sis.l(str, map);
        }
    }

    private boolean dU(String str, String str2) {
        if (bg.mA(str) || bg.mA(str2)) {
            return false;
        }
        if (com.tencent.mm.plugin.webview.a.rUX.matcher(str).matches() && com.tencent.mm.plugin.webview.a.rUX.matcher(str2).matches()) {
            String replaceFirst = str.replaceFirst("http://", "").replaceFirst("https://", "");
            int indexOf = replaceFirst.indexOf(35);
            if (indexOf > 0) {
                replaceFirst = replaceFirst.substring(0, indexOf);
            }
            if (str2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(replaceFirst) && this.sir != null && JO(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean X(Bundle bundle) {
        w.d("MicroMsg.MMWebViewClient", "[cpan] process a8 key:%d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        int i = bundle.getInt("geta8key_result_action_code");
        String string = bundle.getString("geta8key_result_title");
        String string2 = bundle.getString("geta8key_result_full_url");
        String string3 = bundle.getString("geta8key_result_content");
        w.i("MicroMsg.MMWebViewClient", "processGetA8Key, actionCode = " + i + ", title = " + string + ", fullUrl = " + string2 + ", content = " + string3);
        String[] stringArray = bundle.getStringArray("geta8key_result_http_header_key_list");
        String[] stringArray2 = bundle.getStringArray("geta8key_result_http_header_value_list");
        Map hashMap = new HashMap();
        if (stringArray != null && stringArray2 != null && stringArray.length > 0 && stringArray2.length > 0 && stringArray.length == stringArray2.length) {
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                hashMap.put(stringArray[i2], stringArray2[i2]);
            }
        }
        this.snp = hashMap;
        switch (i) {
            case 1:
                w.i("MicroMsg.MMWebViewClient", "getA8key-text: " + string3);
                if (string3 == null || string3.length() == 0) {
                    w.e("MicroMsg.MMWebViewClient", "getA8key-text fail, invalid content");
                    return false;
                }
                this.qjb.getSettings().setJavaScriptEnabled(false);
                this.qjb.loadData(string3, "text/html", ProtocolPackage.ServerEncoding);
                return true;
            case 2:
            case 7:
                w.i("MicroMsg.MMWebViewClient", "getA8key-webview/no-notice: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    w.e("MicroMsg.MMWebViewClient", "getA8key-webview fail, invalid fullUrl");
                    return false;
                } else if (z.IN(string2)) {
                    k(string2, hashMap);
                    return true;
                } else {
                    w.f("MicroMsg.MMWebViewClient", "processGetA8Key qrcode, canLoadUrl fail, url = " + string2);
                    JY(string2);
                    return true;
                }
            case 6:
                w.i("MicroMsg.MMWebViewClient", "getA8key-special_webview: fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    w.e("MicroMsg.MMWebViewClient", "getA8key-special_webview fail, invalid fullUrl");
                    return false;
                } else if (z.IN(string2)) {
                    this.qjb.loadUrl(string2);
                    return true;
                } else {
                    w.f("MicroMsg.MMWebViewClient", "processGetA8Key special, canLoadUrl fail, url = " + string2);
                    JY(string2);
                    return true;
                }
            default:
                w.i("MicroMsg.MMWebViewClient", "qrcode-getA8key-not_catch: action code = " + i);
                return false;
        }
    }

    private void a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (!bg.mA(str2)) {
            this.sjT.a(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.mmM.remove(str2);
            this.sno = false;
            this.mmP = str2;
        }
        if (dU(str, str2)) {
            this.sjT.a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.mmM.remove(str);
        } else if (this.sir != null && !bg.mA(str) && JO(str2)) {
            this.sjT.a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.mmM.remove(str);
        }
    }

    public final boolean a(com.tencent.mm.plugin.webview.stub.c cVar) {
        int type = cVar.getType();
        int bxh = cVar.bxh();
        int bxi = cVar.bxi();
        cVar.Cp();
        Bundle data = cVar.getData();
        if (data == null) {
            data = new Bundle();
        }
        if (this.qjb != null) {
            if (!this.oqR.isFinishing() && this.sjT != null) {
                w.i("MicroMsg.MMWebViewClient", "get hash code = %d, self hash code = %d", new Object[]{Integer.valueOf(data.getInt("scene_end_listener_hash_code")), Integer.valueOf(this.qjb.hashCode())});
                w.i("MicroMsg.MMWebViewClient", "edw onSceneEnd, type = " + type + ", errCode = " + bxi + ", errType = " + bxh);
                if (data.getInt("scene_end_listener_hash_code") == this.qjb.hashCode()) {
                    switch (type) {
                        case 233:
                            b bVar = this.snh;
                            bVar.sfT--;
                            if (bVar.sfT <= 0) {
                                bVar.sns.bzW();
                            }
                            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(data.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
                            GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(data.getInt("geta8key_result_general_ctrl_b1"));
                            int i = data.getInt("geta8key_result_reason");
                            w.i("MicroMsg.MMWebViewClient", "edw geta8key onSceneEnd, req reason = " + i);
                            switch (i) {
                                case 0:
                                case 2:
                                    if ((bxh == 0 && bxi == 0) || (bxh == 4 && bxi == -2005)) {
                                        a(data.getString("geta8key_result_req_url"), data.getString("geta8key_result_full_url"), jsapiPermissionWrapper, generalControlWrapper);
                                        X(data);
                                        break;
                                    }
                                case 1:
                                    if (bxh != 0 || bxi != 0) {
                                        if (bxh == 4 && bxi == -2005) {
                                            this.qjb.stopLoading();
                                            a(data.getString("geta8key_result_req_url"), data.getString("geta8key_result_full_url"), jsapiPermissionWrapper, generalControlWrapper);
                                            X(data);
                                            break;
                                        }
                                    }
                                    String string = data.getString("geta8key_result_req_url");
                                    this.sjT.a(string, jsapiPermissionWrapper, generalControlWrapper);
                                    this.mmM.remove(string);
                                    break;
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;
                    }
                }
                w.e("MicroMsg.MMWebViewClient", "hash code not equal");
            } else {
                w.w("MicroMsg.MMWebViewClient", "onSceneEnd, isFinishing, do nothing");
            }
        } else {
            w.w("MicroMsg.MMWebViewClient", "onSceneEnd, viewWV is null, do nothing");
        }
        return true;
    }

    public final String azN() {
        if (!bg.mA(this.mmO)) {
            return this.mmO;
        }
        if (this.mHandler == null) {
            return null;
        }
        if (Thread.currentThread().getId() == this.mHandler.getLooper().getThread().getId()) {
            return this.qjb == null ? "" : this.qjb.getUrl();
        } else {
            return (String) new bb<String>(this, "") {
                final /* synthetic */ c sns;

                protected final /* synthetic */ Object run() {
                    return this.sns.qjb == null ? "" : this.sns.qjb.getUrl();
                }
            }.b(this.mHandler);
        }
    }
}
