package com.tencent.mm.plugin.game.gamewebview.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameMMToClientEvent;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiInterface;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ag;
import com.tencent.mm.plugin.game.gamewebview.model.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.d.c;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.b;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.plugin.webview.wepkg.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.afe;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.tn;
import com.tencent.mm.protocal.c.to;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.r;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.smtt.sdk.y;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class d extends FrameLayout {
    private static final Pattern mnk = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Pattern mnl = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private String gLD;
    private MMFalseProgressBar iYB;
    private LinearLayout jbY;
    public int jdi;
    public String jdk = "";
    WebChromeClient jeh;
    private View kD;
    boolean kIH = false;
    public ae mHandler;
    public String mlI;
    WebViewSearchContentInputFooter mmA;
    private FrameLayout mmB;
    MovingImageButton mmC;
    private ProgressBar mmD;
    GameMenuImageButton mmE;
    private CustomViewCallback mmF;
    private ProgressBar mmG;
    public e mmH;
    public long mmI = 0;
    private b mmJ;
    a mmK;
    private f mmL;
    private Set<String> mmM;
    private boolean mmN;
    public String mmO;
    public String mmP;
    final c mmQ = new c();
    public int mmR;
    public boolean mmS;
    private String mmT;
    private boolean mmU = true;
    private boolean mmV = false;
    private Map<String, String> mmW = new HashMap();
    public i mmX;
    public boolean mmY;
    b.a mmZ;
    public GameWebViewBaseActivity mmc;
    com.tencent.mm.plugin.game.gamewebview.c.a mmr;
    public b mms;
    public f mmt;
    private WebViewKeyboardLinearLayout mmu;
    private FrameLayout mmv;
    com.tencent.mm.plugin.webview.ui.tools.f mmw;
    GameJsApiInterface mmx;
    public com.tencent.mm.plugin.game.gamewebview.d.b mmy;
    public WebViewInputFooter mmz;
    private boolean mna = true;
    public int mnb;
    private String mnc;
    boolean mnd = false;
    private int mne = 0;
    JsResult mnf;
    private boolean mng;
    String mnh;
    public final HashMap<String, String> mni = new HashMap();
    public final HashMap<String, com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d> mnj = new HashMap();
    public int scene = 0;
    public Bundle uT = new Bundle();

    class AnonymousClass19 implements Runnable {
        final /* synthetic */ d mnm;
        final /* synthetic */ String mnq;
        final /* synthetic */ int mnr;

        public AnonymousClass19(d dVar, String str, int i) {
            this.mnm = dVar;
            this.mnq = str;
            this.mnr = i;
        }

        public final void run() {
            if (!bg.mA(this.mnq)) {
                this.mnm.mmz.setText(this.mnq);
            }
            if (this.mnr >= 0) {
                this.mnm.mmz.wJ(this.mnr);
            }
            this.mnm.mmz.show();
        }
    }

    class AnonymousClass20 extends bb<Integer> {
        final /* synthetic */ d mnm;

        public AnonymousClass20(d dVar, Integer num) {
            this.mnm = dVar;
            super(1000, num);
        }

        protected final /* synthetic */ Object run() {
            return Integer.valueOf(this.mnm.mmz.bAb());
        }
    }

    class AnonymousClass21 implements Runnable {
        final /* synthetic */ String iia;
        final /* synthetic */ int iwS;
        final /* synthetic */ d mnm;

        public AnonymousClass21(d dVar, String str, int i) {
            this.mnm = dVar;
            this.iia = str;
            this.iwS = i;
        }

        public final void run() {
            if (this.mnm.mmt != null) {
                if (!bg.mA(this.iia)) {
                    this.mnm.mmt.tC(this.iia);
                }
                f e = this.mnm.mmt;
                e.llG.setTextColor(this.iwS);
            }
        }
    }

    class AnonymousClass25 implements Runnable {
        final /* synthetic */ String jdr;
        final /* synthetic */ d mnm;

        public AnonymousClass25(d dVar, String str) {
            this.mnm = dVar;
            this.jdr = str;
        }

        public final void run() {
            this.mnm.mmw.wm(com.tencent.mm.plugin.webview.ui.tools.d.cd(this.jdr, this.mnm.getResources().getColor(R.e.aWs)));
            this.mnm.mmw.bxT();
        }
    }

    static /* synthetic */ void a(d dVar, int i, int i2, com.tencent.mm.y.b bVar) {
        if (dVar.mmc.isFinishing()) {
            w.e("MicroMsg.GameWebPageView", "activity is finish, processGetA8Key return");
            return;
        }
        dVar.eB(true);
        dVar.mmS = false;
        tn tnVar = (tn) bVar.hsj.hsr;
        to toVar = (to) bVar.hsk.hsr;
        int i3 = toVar.tBI != null ? toVar.tBI.tBp : 0;
        dVar.mmI = toVar.tBN != null ? toVar.tBN.tto : -1;
        JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(n.a(toVar.tBO));
        GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(i3);
        avx com_tencent_mm_protocal_c_avx = tnVar.tBu;
        String str = "";
        if (com_tencent_mm_protocal_c_avx != null) {
            str = com_tencent_mm_protocal_c_avx.toString();
        }
        dVar.mmM.remove(str);
        if (!bg.mA(toVar.tBJ)) {
            String str2 = toVar.tBF;
            String str3 = toVar.tBJ;
            if (!bg.mA(str2)) {
                dVar.mmW.put(str2, str3);
            }
            dVar.mmW.put(str, str3);
        }
        if ((i == 0 && i2 == 0) || (i == 4 && i2 == -2005)) {
            dVar.mmr.ey(true);
        } else {
            dVar.mmr.ey(false);
        }
        switch (tnVar.tBz) {
            case 0:
            case 2:
                if ((i == 0 && i2 == 0) || (i == 4 && i2 == -2005)) {
                    dVar.a(str, toVar.tBF, jsapiPermissionWrapper, generalControlWrapper);
                    dVar.a(toVar);
                    return;
                }
                if (!(dVar.mmB == null || dVar.azJ())) {
                    dVar.mmB.setVisibility(0);
                }
                if (dVar.uT.getBoolean("finishviewifloadfailed", false)) {
                    dVar.mmc.finish();
                    return;
                }
                return;
            case 1:
            case 5:
                if (i == 0 && i2 == 0) {
                    dVar.mmH.a(str, jsapiPermissionWrapper, generalControlWrapper);
                    return;
                } else if (i == 4 && i2 == -2005) {
                    dVar.mmy.stopLoading();
                    dVar.a(str, toVar.tBF, jsapiPermissionWrapper, generalControlWrapper);
                    dVar.a(toVar);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    static /* synthetic */ void a(d dVar, WebViewKeyboardLinearLayout webViewKeyboardLinearLayout, int i) {
        if (dVar.mmy.getX5WebViewExtension() == null && VERSION.SDK_INT < 19) {
            return;
        }
        if (i == -3) {
            final int i2 = webViewKeyboardLinearLayout.scd;
            dVar.mHandler.post(new Runnable(dVar) {
                final /* synthetic */ d mnm;

                public final void run() {
                    com.tencent.mm.plugin.game.gamewebview.a.a.a(this.mnm, i2);
                }
            });
            return;
        }
        dVar.mHandler.post(new Runnable(dVar) {
            final /* synthetic */ d mnm;

            {
                this.mnm = r1;
            }

            public final void run() {
                com.tencent.mm.plugin.game.gamewebview.a.a.a(this.mnm, 0);
            }
        });
    }

    static /* synthetic */ boolean azR() {
        GWMainProcessTask commonLogicTask = new CommonLogicTask();
        commonLogicTask.type = 4;
        GameWebViewMainProcessService.b(commonLogicTask);
        return commonLogicTask.lHw.getBoolean("allowDownloadFile", true);
    }

    static /* synthetic */ void d(d dVar, String str) {
        if (dVar.mmR != 0) {
            Map hashMap = new HashMap();
            hashMap.put("text", str);
            dVar.x(dVar.mmR, com.tencent.mm.plugin.game.gamewebview.a.d.d("showKeyboard:ok", hashMap));
        }
    }

    public d(b bVar) {
        super(bVar.getContext());
        w.i("MicroMsg.GameWebPageView", "onCreate");
        this.mms = bVar;
        this.mHandler = new ae();
        this.mmc = (GameWebViewBaseActivity) bVar.getContext();
        this.uT = this.mmc.getIntent().getExtras();
        this.gLD = this.uT.getString("geta8key_username");
        this.mnc = this.uT.getString("KPublisherId");
        this.scene = this.uT.getInt("geta8key_scene", 0);
        this.mnb = com.tencent.mm.plugin.game.gamewebview.a.d.ab(this.scene, this.gLD);
        this.mmV = this.uT.getBoolean("neverGetA8Key", false);
        this.mnh = this.uT.getString("game_hv_menu_appid");
        this.jbY = new LinearLayout(getContext());
        this.jbY.setLayoutParams(new LayoutParams(-1, -1));
        this.jbY.setOrientation(1);
        addView(this.jbY);
        this.mmt = new f(this.mms);
        this.jbY.addView(this.mmt);
        View inflate = r.eC(getContext()).inflate(R.i.dft, this, false);
        this.jbY.addView(inflate, new LayoutParams(-1, -1));
        this.mmu = (WebViewKeyboardLinearLayout) inflate.findViewById(R.h.bVd);
        this.mmw = new com.tencent.mm.plugin.webview.ui.tools.f();
        this.mmw.cM(inflate);
        this.mmx = new GameJsApiInterface(this);
        this.mmx.mjQ = azH();
        GameJsApiInterface gameJsApiInterface = this.mmx;
        com.tencent.mm.pluginsdk.model.w.a.dw(this.mmc);
        this.mmy = new com.tencent.mm.plugin.game.gamewebview.d.b(this.mmc, this);
        this.mmy.addJavascriptInterface(gameJsApiInterface, "WXGameJsCore");
        this.mmy.setWebViewClient(new WebViewClient(this) {
            final /* synthetic */ d mnm;

            {
                this.mnm = r1;
            }

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (z.IN(str)) {
                    this.mnm.mmO = str;
                    if (this.mnm.azJ()) {
                        this.mnm.azL();
                    } else {
                        this.mnm.azM();
                    }
                    this.mnm.f(str, false, -1);
                    this.mnm.mmw.bxS();
                    this.mnm.mmw.pE(str);
                    if (!(this.mnm.mmK == null || this.mnm.mmK.soV == null)) {
                        this.mnm.mmK.soV.onPageStarted(webView, str, bitmap);
                    }
                    com.tencent.mm.plugin.game.gamewebview.c.a i = this.mnm.mmr;
                    i.mlM = false;
                    i.mlR = System.currentTimeMillis();
                    g.oUh.a(606, 0, 1, false);
                    g.oUh.a(611, 2, 1, false);
                    return;
                }
                w.i("MicroMsg.GameWebPageView", "onPageStarted canLoadUrl fail, url = %s", new Object[]{str});
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, final String str) {
                w.i("MicroMsg.GameWebPageView", "shouldOverrideUrlLoading, url = %s, id = %d", new Object[]{str, Integer.valueOf(hashCode())});
                if (!z.IN(str)) {
                    w.f("MicroMsg.GameWebPageView", "shouldOverrideUrlLoading, canLoadUrl fail, url = " + str);
                    this.mnm.azI();
                    return true;
                } else if (s.eq(str, "about:blank")) {
                    w.e("MicroMsg.GameWebPageView", "shouldOverride, url is about:blank");
                    return true;
                } else if (str.startsWith("weixin://")) {
                    w.e("MicroMsg.GameWebPageView", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
                    return true;
                } else if (str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe")) {
                    return true;
                } else {
                    if (this.mnm.xF(str)) {
                        w.i("MicroMsg.GameWebPageView", "custom scheme url deal success, url = " + str);
                        return true;
                    }
                    int xB = this.mnm.mmL.mlz.xB(str);
                    boolean z = this.mnm.uT.getBoolean("neverGetA8Key", false);
                    if ((xB == 0 || xB == 2) && !z) {
                        w.i("MicroMsg.GameWebPageView", "edw shouldOverride, should not continue, reason = " + xB);
                        if (this.mnm.azJ()) {
                            this.mnm.mmy.stopLoading();
                            this.mnm.mmy.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass29 mnt;

                                public final void run() {
                                    this.mnt.mnm.xG(str);
                                }
                            });
                        } else {
                            this.mnm.mmy.stopLoading();
                        }
                        if (!str.equals(this.mnm.mmT)) {
                            this.mnm.f(str, true, -1);
                            return true;
                        }
                    }
                    w.w("MicroMsg.GameWebPageView", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }

            public final void onPageFinished(WebView webView, String str) {
                this.mnm.mmD.setVisibility(8);
                if (z.IN(str)) {
                    this.mnm.mmw.pE(this.mnm.azN());
                    this.mnm.iYB.finish();
                    if (!(this.mnm.mmK == null || this.mnm.mmK.soV == null)) {
                        this.mnm.mmK.soV.onPageFinished(webView, str);
                    }
                    com.tencent.mm.plugin.game.gamewebview.c.a i = this.mnm.mmr;
                    w.d("MicroMsg.GameWebViewReportManager", "loadTime = %d", new Object[]{Long.valueOf(System.currentTimeMillis() - i.mlR)});
                    i.mlL = 1;
                    i.a(i.mkn.azN(), 2, r4, i.mlL, 0);
                    g.oUh.a(611, 3, 1, false);
                    if (this.mnm.mmZ != null) {
                        this.mnm.mmZ.azD();
                        return;
                    }
                    return;
                }
                w.f("MicroMsg.GameWebPageView", "onPageFinished, canLoadUrl fail, url = " + str);
                this.mnm.azI();
            }

            public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
                w.i("MicroMsg.GameWebPageView", "doUpdateVisitedHistory, url = %s, isReload = %b", new Object[]{str, Boolean.valueOf(z)});
                this.mnm.f(webView.getUrl(), false, -1);
                this.mnm.mmO = str;
            }

            @TargetApi(8)
            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                String q = webView.getUrl() == null ? this.mnm.mmO : webView.getUrl();
                this.mnm.mmr.mlL = 0;
                g.oUh.a(606, 2, 1, false);
                this.mnm.mmD.setVisibility(8);
                if (this.mnm.mmJ == null) {
                    this.mnm.mmJ = new b(this.mnm.mmc, this.mnm.mmy);
                }
                this.mnm.mmJ.a(q, sslErrorHandler, sslError);
            }

            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                com.tencent.mm.plugin.game.gamewebview.c.a i2 = this.mnm.mmr;
                i2.mlL = 0;
                g.oUh.a(606, 1, 1, false);
                g.oUh.a(606, (long) com.tencent.mm.plugin.webview.ui.tools.a.we(i), 1, false);
                i2.a(str2, 6, 0, i2.mlL, i);
            }

            public final void onLoadResource(WebView webView, String str) {
                if (z.IN(str)) {
                    com.tencent.mm.plugin.game.gamewebview.c.a i = this.mnm.mmr;
                    if (!i.mlM) {
                        i.mlM = true;
                        w.d("MicroMsg.GameWebViewReportManager", "domReadyTime = %d", new Object[]{Long.valueOf(System.currentTimeMillis() - i.mlR)});
                        i.a(i.mkn.azN(), 5, r4, i.mlL, 0);
                        return;
                    }
                    return;
                }
                this.mnm.azI();
            }

            public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                if (!(this.mnm.mmK == null || this.mnm.mmK.soV == null)) {
                    WebResourceResponse shouldInterceptRequest = this.mnm.mmK.soV.shouldInterceptRequest(webView, str);
                    if (shouldInterceptRequest != null) {
                        return shouldInterceptRequest;
                    }
                }
                return super.shouldInterceptRequest(webView, str);
            }

            public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                if (!(this.mnm.mmK == null || this.mnm.mmK.soV == null)) {
                    WebResourceResponse shouldInterceptRequest = this.mnm.mmK.soV.shouldInterceptRequest(webView, webResourceRequest);
                    if (shouldInterceptRequest != null) {
                        return shouldInterceptRequest;
                    }
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }

            public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
                if (webResourceRequest == null || webResourceRequest.getUrl() == null || bg.mA(webResourceRequest.getUrl().toString())) {
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
                if (!(this.mnm.mmK == null || this.mnm.mmK.soV == null)) {
                    WebResourceResponse shouldInterceptRequest = this.mnm.mmK.soV.shouldInterceptRequest(webView, webResourceRequest, bundle);
                    if (shouldInterceptRequest != null) {
                        return shouldInterceptRequest;
                    }
                }
                if (WebView.getTbsCoreVersion(this.mnm.mmc) > 36541) {
                    try {
                        int i = bundle.getInt("resourceType");
                        if (i == 1 || i == 7) {
                            w.i("MicroMsg.GameWebPageView", "get resoutce type is iframe : %d, start geta8key", new Object[]{Integer.valueOf(i)});
                            this.mnm.f(webResourceRequest.getUrl().toString(), false, 5);
                        }
                    } catch (Exception e) {
                        w.w("MicroMsg.GameWebPageView", "get resource type failed Exception ; %s", new Object[]{e.getMessage()});
                    } catch (Throwable th) {
                        w.w("MicroMsg.GameWebPageView", "get resource type failed Throwable ; %s", new Object[]{th.getMessage()});
                    }
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        });
        this.jeh = new WebChromeClient(this) {
            final /* synthetic */ d mnm;
            private Dialog mnu = null;

            {
                this.mnm = r2;
            }

            public final void onProgressChanged(WebView webView, int i) {
            }

            public final void onReceivedTitle(WebView webView, String str) {
                w.i("MicroMsg.GameWebPageView", "onReceivedTitle, title = %s", new Object[]{str});
                if (!bg.mz(this.mnm.mmO).equals(str) && !com.tencent.mm.plugin.game.gamewebview.a.d.xt(str)) {
                    this.mnm.mmt.tC(str);
                }
            }

            public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                w.i("MicroMsg.GameWebPageView", "onShowCustomView, sdk int = " + VERSION.SDK_INT);
                try {
                    if (this.mnm.kD != null) {
                        customViewCallback.onCustomViewHidden();
                        return;
                    }
                    this.mnm.kD = view;
                    this.mnm.mmF = customViewCallback;
                    this.mnm.mmy.setVisibility(8);
                    this.mnm.mmv.addView(view);
                    this.mnm.mmt.setVisibility(8);
                } catch (Exception e) {
                    w.e("MicroMsg.GameWebPageView", "onShowCustomView error " + e.getMessage());
                }
            }

            public final void onHideCustomView() {
                w.i("MicroMsg.GameWebPageView", "onHideCustomView, sdk int = " + VERSION.SDK_INT);
                if (this.mnm.kD != null) {
                    try {
                        this.mnm.mmy.setVisibility(0);
                        if (this.mnm.mmv != null) {
                            this.mnm.mmv.removeView(this.mnm.kD);
                        }
                        this.mnm.kD = null;
                        if (this.mnm.mmF != null) {
                            this.mnm.mmF.onCustomViewHidden();
                        }
                        this.mnm.mmt.setVisibility(0);
                    } catch (Exception e) {
                        w.e("MicroMsg.GameWebPageView", "onHideCustomView error " + e.getMessage());
                    }
                }
            }

            public final View getVideoLoadingProgressView() {
                if (this.mnm.mmG == null) {
                    this.mnm.mmG = new ProgressBar(this.mnm.mmc);
                    this.mnm.mmG.setIndeterminate(true);
                }
                return this.mnm.mmG;
            }

            public final void onGeolocationPermissionsShowPrompt(final String str, final GeolocationPermissionsCallback geolocationPermissionsCallback) {
                w.i("MicroMsg.GameWebPageView", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[]{str});
                com.tencent.mm.ui.base.g.a(this.mnm.mmc, false, this.mnm.mmc.getString(R.l.fnE, new Object[]{str}), this.mnm.mmc.getString(R.l.fnF), this.mnm.mmc.getString(R.l.dHT), this.mnm.mmc.getString(R.l.dGs), new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass30 mnx;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.i("MicroMsg.GameWebPageView", "onGeolocationPermissionsShowPrompt ok, origin = %s");
                        geolocationPermissionsCallback.invoke(str, true, true);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass30 mnx;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.i("MicroMsg.GameWebPageView", "onGeolocationPermissionsShowPrompt cancel, origin = %s");
                        geolocationPermissionsCallback.invoke(str, false, false);
                    }
                });
            }

            public final boolean onShowFileChooser(WebView webView, y<Uri[]> yVar, WebChromeClient.a aVar) {
                if (aVar.getMode() != 0) {
                    return false;
                }
                if (aVar.getAcceptTypes() == null || aVar.getAcceptTypes().length <= 0) {
                    w.i("MicroMsg.GameWebPageView", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
                    return true;
                }
                this.mnm.mmQ.a(this.mnm.mmc, this.mnm.mmH, null, yVar, aVar.getAcceptTypes()[0], "*");
                return true;
            }

            public final boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
                this.mnm.mnf = jsResult;
                if (this.mnm.kIH) {
                    jsResult.cancel();
                    return true;
                }
                this.mnm.mne = this.mnm.mne + 1;
                if (this.mnm.mne > 2) {
                    this.mnu = com.tencent.mm.ui.base.g.a(this.mnm.mmc, str2, "", this.mnm.mmc.getString(R.l.fnz), this.mnm.mmc.getString(R.l.dHT), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass30 mnx;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.cancel();
                            if (dialogInterface != null) {
                                dialogInterface.dismiss();
                            }
                            this.mnx.mnm.eD(true);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass30 mnx;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.confirm();
                        }
                    }, R.e.aTa);
                } else {
                    this.mnu = com.tencent.mm.ui.base.g.a(this.mnm.mmc, false, str2, "", this.mnm.mmc.getString(R.l.dHT), this.mnm.mmc.getString(R.l.dGs), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass30 mnx;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.confirm();
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass30 mnx;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.cancel();
                        }
                    });
                }
                if (this.mnu == null) {
                    return super.onJsConfirm(webView, str, str2, jsResult);
                }
                this.mnu.setCancelable(false);
                this.mnu.setCanceledOnTouchOutside(false);
                return true;
            }

            public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }

            public final boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
                w.d("MicroMsg.GameWebPageView", "onJsAlert, mHasDestroy = %b", new Object[]{Boolean.valueOf(this.mnm.kIH)});
                this.mnm.mnf = jsResult;
                if (this.mnm.kIH) {
                    jsResult.cancel();
                    return true;
                }
                this.mnm.mne = this.mnm.mne + 1;
                if (this.mnm.mne > 2) {
                    this.mnu = com.tencent.mm.ui.base.g.a(this.mnm.mmc, str2, "", this.mnm.mmc.getString(R.l.fnz), this.mnm.mmc.getString(R.l.dHT), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass30 mnx;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.cancel();
                            if (dialogInterface != null) {
                                dialogInterface.dismiss();
                            }
                            this.mnx.mnm.eD(true);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass30 mnx;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.confirm();
                        }
                    }, R.e.aTa);
                } else {
                    this.mnu = com.tencent.mm.ui.base.g.a(this.mnm.mmc, false, str2, "", this.mnm.mmc.getString(R.l.dHT), this.mnm.mmc.getString(R.l.dGs), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass30 mnx;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.confirm();
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass30 mnx;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.cancel();
                        }
                    });
                }
                if (this.mnu == null) {
                    return super.onJsAlert(webView, str, str2, jsResult);
                }
                this.mnu.setCancelable(false);
                this.mnu.setCanceledOnTouchOutside(false);
                return true;
            }

            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                String message = consoleMessage != null ? consoleMessage.message() : null;
                w.i("MicroMsg.GameWebPageView", "onConsoleMessage : %s", new Object[]{message});
                if (!bg.mA(message)) {
                    if (message.equalsIgnoreCase("weixin://preInjectJSBridge/start")) {
                        w.i("MicroMsg.GameWebPageView", "now inject js library");
                        return true;
                    } else if (message.equalsIgnoreCase("weixin://preInjectJSBridge/fail")) {
                        return true;
                    } else {
                        if (message.equalsIgnoreCase("weixin://preInjectJSBridge/ok")) {
                            w.d("MicroMsg.GameWebPageView", "preInjectJSBridge ok");
                            return true;
                        } else if (message.equalsIgnoreCase("weixin://whiteScreenEnd")) {
                            w.d("MicroMsg.GameWebPageView", "whiteScreenEnd");
                            this.mnm.mng = true;
                            return true;
                        }
                    }
                }
                return false;
            }
        };
        this.mmy.setWebChromeClient(this.jeh);
        this.mmy.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ d mnm;

            {
                this.mnm = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 1:
                        if (!view.hasFocus()) {
                            view.requestFocus();
                            break;
                        }
                        break;
                }
                if (this.mnm.mmy != null && (motionEvent.getAction() == 0 || motionEvent.getAction() == 5 || motionEvent.getAction() == 5 || motionEvent.getAction() == 261 || motionEvent.getAction() == 517)) {
                    if (motionEvent.getPointerCount() > 1) {
                        this.mnm.mmy.getSettings().setBuiltInZoomControls(true);
                        this.mnm.mmy.getSettings().setSupportZoom(true);
                    } else {
                        this.mnm.mmy.getSettings().setBuiltInZoomControls(false);
                        this.mnm.mmy.getSettings().setSupportZoom(false);
                    }
                }
                return false;
            }
        });
        if (this.mmy.wwS) {
            this.mmy.setWebViewCallbackClient(new g(this) {
                final /* synthetic */ d mnm;

                {
                    this.mnm = r1;
                }

                public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
                }
            });
            this.mmy.moj = new ProxyWebViewClientExtension(this) {
                final /* synthetic */ d mnm;

                {
                    this.mnm = r1;
                }

                public final Object onMiscCallBack(String str, Bundle bundle) {
                    boolean z = false;
                    String str2 = "MicroMsg.GameWebPageView";
                    String str3 = "method = %s, bundler == null ? %b";
                    Object[] objArr = new Object[2];
                    objArr[0] = str;
                    if (bundle == null) {
                        z = true;
                    }
                    objArr[1] = Boolean.valueOf(z);
                    w.i(str2, str3, objArr);
                    if (bg.mA(str) || bundle == null) {
                        return super.onMiscCallBack(str, bundle);
                    }
                    if (!(this.mnm.mmK == null || this.mnm.mmK.soW == null)) {
                        Object onMiscCallBack = this.mnm.mmK.soW.onMiscCallBack(str, bundle);
                        if (onMiscCallBack != null) {
                            return onMiscCallBack;
                        }
                    }
                    return super.onMiscCallBack(str, bundle);
                }

                public final void invalidate() {
                }
            };
        }
        this.mmy.setDownloadListener(new DownloadListener(this) {
            final /* synthetic */ d mnm;

            {
                this.mnm = r1;
            }

            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                int i = 1;
                w.i("MicroMsg.GameWebPageView", "onDownloadStart called, url = %s, mimeType = %s, userAgent = %s", new Object[]{str, str4, str2});
                if (this.mnm.mmH != null) {
                    JsapiPermissionWrapper JN = this.mnm.mmH.JN(this.mnm.azN());
                    if (JN != null) {
                        if (str4 != null) {
                            w.i("MicroMsg.GameWebPageView", "onDownloadStart configOpen:%s", new Object[]{Boolean.valueOf(d.azR())});
                            CharSequence xv = com.tencent.mm.plugin.game.gamewebview.a.d.xv(str3);
                            int i2 = (xv == null || !Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", xv)) ? 0 : 1;
                            boolean contains = com.tencent.mm.plugin.webview.ui.tools.jsapi.a.sjy.contains(str4.toLowerCase());
                            if (!r4 || (i2 == 0 && !contains)) {
                                i = 0;
                            }
                        } else {
                            i = 0;
                        }
                        if (i != 0 || JN.nw(24)) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            try {
                                this.mnm.mmc.startActivity(intent);
                                return;
                            } catch (Exception e) {
                                w.e("MicroMsg.GameWebPageView", "startActivity fail, e = " + e.getMessage());
                                return;
                            }
                        }
                        w.e("MicroMsg.GameWebPageView", "onDownloadStart permission fail");
                        return;
                    }
                }
                w.e("MicroMsg.GameWebPageView", "onDownloadStart fail, mWebViewPermission is null");
            }
        });
        this.mmw.a(this.mmy);
        this.mmv = (FrameLayout) inflate.findViewById(R.h.bGr);
        this.mmz = (WebViewInputFooter) inflate.findViewById(R.h.cSq);
        this.mmz.hide();
        this.mmz.snS = new WebViewInputFooter.c(this) {
            final /* synthetic */ d mnm;

            {
                this.mnm = r1;
            }

            public final void xK(String str) {
                d.d(this.mnm, str);
                if (this.mnm.mmz != null) {
                    this.mnm.mmz.hide();
                }
            }
        };
        this.mmz.snT = new WebViewInputFooter.a(this) {
            final /* synthetic */ d mnm;

            {
                this.mnm = r1;
            }

            public final boolean rl(String str) {
                d dVar = this.mnm;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("smiley", str);
                    dVar.ck("onGetSmiley", jSONObject.toString());
                } catch (Exception e) {
                    w.e("MicroMsg.GameWebviewJsLoader", "onGetA8Key, e:" + e.getMessage());
                }
                return true;
            }
        };
        this.mmz.snU = new WebViewInputFooter.b(this) {
            final /* synthetic */ d mnm;

            {
                this.mnm = r1;
            }

            public final void azV() {
                this.mnm.nv(0);
            }

            public final void azW() {
                WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout) this.mnm.findViewById(R.h.cSv);
                if (webViewKeyboardLinearLayout != null && webViewKeyboardLinearLayout.scd > 0) {
                    this.mnm.nv(webViewKeyboardLinearLayout.scd);
                }
            }
        };
        this.mmA = (WebViewSearchContentInputFooter) inflate.findViewById(R.h.cAB);
        this.mmA.snQ = new WebViewSearchContentInputFooter.a(this) {
            final /* synthetic */ d mnm;

            {
                this.mnm = r1;
            }

            public final void azX() {
                this.mnm.mmy.setPadding(this.mnm.mmy.getPaddingLeft(), this.mnm.mmy.getPaddingTop(), this.mnm.mmy.getPaddingRight(), 0);
                this.mnm.mmy.clearMatches();
                this.mnm.mmA.bzY();
            }

            public final void a(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                if (webViewSearchContentInputFooter.getVisibility() == 0) {
                    b(webViewSearchContentInputFooter);
                }
            }

            public final void azY() {
                g.oUh.a(608, 5, 1, false);
                this.mnm.mmy.findNext(false);
            }

            public final void azZ() {
                g.oUh.a(608, 4, 1, false);
                this.mnm.mmy.findNext(true);
            }

            public final void b(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                this.mnm.mmy.clearMatches();
                webViewSearchContentInputFooter.reset();
                this.mnm.mmA.q(0, 0, true);
                this.mnm.mmN = false;
                this.mnm.mmy.findAllAsync(webViewSearchContentInputFooter.bzZ());
            }

            public final boolean c(int i, KeyEvent keyEvent) {
                if (i == 67 && keyEvent.getAction() == 0) {
                    g.oUh.a(608, 6, 1, false);
                }
                return false;
            }

            public final void azn() {
                this.mnm.mmy.setPadding(this.mnm.mmy.getPaddingLeft(), this.mnm.mmy.getPaddingTop(), this.mnm.mmy.getPaddingRight(), this.mnm.mmA.getHeight());
            }
        };
        this.mmy.setFindListener(new FindListener(this) {
            final /* synthetic */ d mnm;

            {
                this.mnm = r1;
            }

            public final void onFindResultReceived(int i, int i2, boolean z) {
                if (!(!z || this.mnm.mmN || bg.mA(this.mnm.mmA.bzZ()))) {
                    if (i2 == 0) {
                        g.oUh.a(608, 3, 1, false);
                    } else {
                        g.oUh.a(608, 2, 1, false);
                    }
                    this.mnm.mmN = true;
                }
                this.mnm.mmA.q(i, i2, z);
            }
        });
        this.mmB = (FrameLayout) inflate.findViewById(R.h.cxo);
        if (this.mmB != null) {
            this.mmB.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ d mnm;

                {
                    this.mnm = r1;
                }

                public final void onClick(View view) {
                    this.mnm.f(this.mnm.mmT, true, -1);
                }
            });
        }
        this.iYB = (MMFalseProgressBar) inflate.findViewById(R.h.cSh);
        this.mmC = (MovingImageButton) inflate.findViewById(R.h.bSm);
        this.mmC.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ d mnm;

            {
                this.mnm = r1;
            }

            public final void onClick(View view) {
                if (this.mnm.mmt != null) {
                    this.mnm.mmt.aAb();
                }
            }
        });
        this.mmD = (ProgressBar) inflate.findViewById(R.h.bHg);
        this.mmu.uRI = new KeyboardLinearLayout.a(this) {
            final /* synthetic */ d mnm;

            {
                this.mnm = r1;
            }

            public final void nx(int i) {
                w.i("MicroMsg.GameWebPageView", "onKeyBoardStateChange, state = " + i);
                d.a(this.mnm, this.mnm.mmu, i);
                if (i == -3 && this.mnm.mmz != null && this.mnm.mmz.getVisibility() == 0) {
                    this.mnm.mmz.bAc();
                }
            }
        };
        com.tencent.mm.plugin.game.gamewebview.model.a.a(this);
        GameMMToClientEvent.np(hashCode());
        this.mmH = new e(this.mmc, this.mmy);
        this.mmM = new HashSet();
        this.mmX = new i(this.mmc, this.mmy, this.mmH);
        this.mmr = new com.tencent.mm.plugin.game.gamewebview.c.a(this);
        this.jdi = android.support.v4.content.a.b(this.mmc, R.e.aSB);
    }

    public final void loadUrl(String str) {
        int i = 1;
        if (bg.mA(str)) {
            w.e("MicroMsg.GameWebPageView", "rawUrl is null");
            return;
        }
        w.d("MicroMsg.GameWebPageView", "loadUrl, rawUrl = %s, this = %d", new Object[]{str, Integer.valueOf(hashCode())});
        g.oUh.a(611, 1, 1, false);
        this.mlI = str;
        this.mmK = new a(this.mmc, this.mmy, this.mmy.hashCode());
        this.mmK.soT = new a.a(this) {
            final /* synthetic */ d mnm;

            {
                this.mnm = r1;
            }

            public final boolean azU() {
                return this.mnm.mng;
            }
        };
        this.mmK.onCreate(this.mlI);
        if (this.mmK.soO) {
            this.mmD.setVisibility(0);
        }
        Uri parse = Uri.parse(this.mlI);
        if (parse == null) {
            w.e("MicroMsg.GameWebPageView", "uri is null");
            return;
        }
        if (parse.getScheme() == null) {
            this.mlI = "http://" + this.mlI;
        } else if (!parse.getScheme().startsWith("http")) {
            w.i("MicroMsg.GameWebPageView", "uri scheme not startwith http, scheme = " + parse.getScheme());
            if (z.IN(this.mlI)) {
                this.mmy.loadUrl(this.mlI);
                return;
            }
            w.f("MicroMsg.GameWebPageView", "canLoadUrl fail, url = " + this.mlI);
            azI();
            return;
        }
        if (this.mmV) {
            w.i("MicroMsg.GameWebPageView", "initView, no need to geta8key, loadUrl directly, neverGetA8Key = " + this.mmV);
            if (!z.IN(this.mlI)) {
                w.f("MicroMsg.GameWebPageView", "postBinded 2, canLoadUrl fail, url = " + this.mlI);
                azI();
                return;
            } else if (azJ()) {
                azL();
                xG(this.mlI);
                return;
            } else {
                this.mmy.loadUrl(this.mlI);
                return;
            }
        }
        if (azJ()) {
            xG(this.mlI);
            this.mmO = this.mlI;
            azL();
        }
        if (!this.mmc.isFinishing()) {
            i = 0;
        }
        if (i == 0) {
            w.i("MicroMsg.GameWebPageView", "not call onDestory, try to geta8key again");
            f(this.mlI, false, -1);
            w.i("MicroMsg.GameWebPageView", "before geta8key, rawUrl = " + this.mlI);
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        w.d("MicroMsg.GameWebPageView", "onLayout, changed = %b, left = %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
        super.onLayout(z, i, i2, i3, i4);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        if (i == 4) {
            try {
                if (this.kD == null || this.mmF == null || this.jeh == null) {
                    z = false;
                } else {
                    this.jeh.onHideCustomView();
                    z = true;
                }
                if (z) {
                    return true;
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.GameWebPageView", e, "onkeydown", new Object[0]);
                return true;
            }
        }
        if (i == 4) {
            if (this.mmz == null || !this.mmz.isShown()) {
                z = false;
            } else {
                this.mmz.hide();
                z = true;
            }
            if (z) {
                return true;
            }
        }
        if (i != 4 || !this.mmy.canGoBack() || !this.mna) {
            return false;
        }
        this.mmT = "";
        this.mmy.goBack();
        return true;
    }

    public final void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    final void xD(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("state", str);
            ck("activity:state_change", jSONObject.toString());
        } catch (Exception e) {
            w.e("MicroMsg.GameWebviewJsLoader", "onActivityStateChanged, e:" + e.getMessage());
        }
    }

    final void xE(String str) {
        if (this.mmy != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.mmy, new Object[0]);
            } catch (NoSuchMethodException e) {
                w.e("MicroMsg.GameWebPageView", "No such method: " + str + ", " + e.toString());
            } catch (IllegalAccessException e2) {
                w.e("MicroMsg.GameWebPageView", "Illegal Access: " + str + ", " + e2.toString());
            } catch (InvocationTargetException e3) {
                w.e("MicroMsg.GameWebPageView", "Invocation Target Exception: " + str + ", " + e3.toString());
            } catch (Exception e4) {
                w.e("MicroMsg.GameWebPageView", "Exception : " + str + ", " + e4.toString());
            }
        }
    }

    private JSONObject azH() {
        JSONObject jSONObject = new JSONObject();
        try {
            String string = this.uT.getString("geta8key_username");
            if (!bg.mA(this.uT.getString("srcUsername"))) {
                jSONObject.put("srcUsername", this.uT.getString("srcUsername"));
                jSONObject.put("srcDisplayname", this.uT.getString("srcDisplayname"));
            } else if (!bg.mA(string)) {
                jSONObject.put("srcUsername", string);
            }
            jSONObject.put("message_id", this.uT.getLong("message_id", 0));
            jSONObject.put("message_index", this.uT.getInt("message_index", 0));
            jSONObject.put("scene", com.tencent.mm.plugin.game.gamewebview.a.d.ab(this.scene, string));
            jSONObject.put("pay_channel", this.uT.getInt("pay_channel", 0));
            jSONObject.put("stastic_scene", this.uT.getInt("stastic_scene", 0));
            jSONObject.put("from_scence", this.uT.getInt("from_scence", 0));
            if (!bg.mA(this.uT.getString("KTemplateId"))) {
                jSONObject.put("KTemplateId", this.uT.getString("KTemplateId"));
            }
        } catch (Exception e) {
            w.e("MicroMsg.GameWebPageView", e.getMessage());
        }
        return jSONObject;
    }

    public final void nu(int i) {
        this.mmt.setVisibility(i);
    }

    private boolean xF(String str) {
        w.i("MicroMsg.GameWebPageView", "dealCustomScheme, url = " + str);
        if (str == null || str.length() == 0) {
            return false;
        }
        final Uri parse = Uri.parse(str);
        if (!(parse == null || str.startsWith("weixin://") || str.startsWith("http"))) {
            if (str.startsWith(WebView.SCHEME_TEL)) {
                return true;
            }
            Intent intent;
            if (str.startsWith("sms:") || str.startsWith("smsto:")) {
                intent = new Intent("android.intent.action.SENDTO", parse);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                try {
                    this.mmc.startActivity(intent);
                    return true;
                } catch (Exception e) {
                    w.e("MicroMsg.GameWebPageView", "start sms app failed:[%s]", new Object[]{e.getMessage()});
                    return true;
                }
            } else if (this.mmH == null || !this.mmH.bxR().bHg()) {
                return true;
            } else {
                if (this.mmc.getIntent().getBooleanExtra("show_openapp_dialog", true)) {
                    return com.tencent.mm.bk.a.post(new Runnable(this) {
                        final /* synthetic */ d mnm;

                        public final void run() {
                            com.tencent.mm.pluginsdk.model.app.g.d(this.mnm.mmc, parse);
                        }
                    });
                }
                intent = new Intent("android.intent.action.VIEW", parse);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                if (bg.j(this.mmc, intent)) {
                    this.mmc.startActivity(intent);
                    return true;
                }
            }
        }
        return false;
    }

    protected final void xG(String str) {
        Map hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        this.mmy.loadUrl(str, hashMap);
    }

    public final void nv(int i) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.mmz.getLayoutParams();
        if (marginLayoutParams.bottomMargin != i) {
            marginLayoutParams.bottomMargin = i;
            this.mmz.setLayoutParams(marginLayoutParams);
        }
    }

    private void f(String str, boolean z, int i) {
        if (this.mmc.isFinishing()) {
            w.e("MicroMsg.GameWebPageView", "activity is finished");
        } else if (this.mmH == null) {
            w.e("MicroMsg.GameWebPageView", "mWebViewPermission is null");
        } else if ((this.mmH.has(str) || this.mmM.contains(str)) && !z) {
            w.i("MicroMsg.GameWebPageView", "startGetA8Key no need, has url");
        } else {
            if (this.mmL == null) {
                this.mmL = new f(this.mlI, new f.c(this) {
                    final /* synthetic */ d mnm;

                    {
                        this.mnm = r1;
                    }

                    public final void a(int i, int i2, String str, com.tencent.mm.y.b bVar) {
                        d.a(this.mnm, i, i2, bVar);
                    }
                });
            }
            w.i("MicroMsg.GameWebPageView", "startGetA8Key, url = %s", new Object[]{str});
            this.mmM.add(str);
            this.mmH.a(str, null, null);
            this.mmS = true;
            this.mmT = str;
            f fVar = this.mmL;
            String str2 = this.gLD;
            int i2 = this.mnb;
            int i3 = this.mmy.getX5WebViewExtension() != null ? 1 : 0;
            String bwv = ai.bwv();
            int i4 = this.uT.getInt("geta8key_session_id", (int) System.currentTimeMillis());
            if (i == -1) {
                i = fVar.mlz.xB(str);
            }
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_req_url", str);
            bundle.putString("geta8key_data_username", str2);
            bundle.putInt("geta8key_data_scene", i2);
            bundle.putInt("geta8key_data_reason", i);
            bundle.putInt("geta8key_data_flag", i3);
            bundle.putString("geta8key_data_net_type", bwv);
            bundle.putInt("geta8key_session_id", i4);
            XIPCInvoker.a("com.tencent.mm", bundle, a.class, new h<IPCRunCgiRespWrapper>(fVar) {
                final /* synthetic */ f mlB;

                {
                    this.mlB = r1;
                }

                public final /* synthetic */ void ak(Object obj) {
                    final IPCRunCgiRespWrapper iPCRunCgiRespWrapper = (IPCRunCgiRespWrapper) obj;
                    if (this.mlB.mlA != null) {
                        w.i("MicroMsg.GameWebViewGetA8KeyHelp", "callback(%d), this(%d)", new Object[]{Integer.valueOf(this.mlB.mlA.hashCode()), Integer.valueOf(hashCode())});
                        com.tencent.mm.bk.a.W(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 mlD;

                            public final void run() {
                                this.mlD.mlB.mlA.a(iPCRunCgiRespWrapper.errType, iPCRunCgiRespWrapper.errCode, iPCRunCgiRespWrapper.fPf, iPCRunCgiRespWrapper.gUA);
                            }
                        });
                    }
                }
            });
            w.d("MicroMsg.GameWebViewGetA8KeyHelp", "runCgi, url = %s, id = %d", new Object[]{str, Integer.valueOf(fVar.hashCode())});
            if (this.mmB != null) {
                this.mmB.setVisibility(8);
            }
            eB(false);
            this.mmr.mlQ = System.currentTimeMillis();
        }
    }

    private void a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (this.mmH == null) {
            w.e("MicroMsg.GameWebPageView", "mWebViewPermission is null");
            return;
        }
        if (!bg.mA(str2)) {
            this.mmH.a(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.mmP = str2;
        }
        if (azJ()) {
            this.mmH.a(str, jsapiPermissionWrapper, generalControlWrapper);
        }
    }

    private void a(to toVar) {
        if (!this.mmc.isFinishing() && this.mmy != null) {
            final Map hashMap = new HashMap();
            List<afe> list = toVar.tBQ;
            if (!bg.bV(list)) {
                for (afe com_tencent_mm_protocal_c_afe : list) {
                    if (!(bg.mA(com_tencent_mm_protocal_c_afe.tkE) || bg.mA(com_tencent_mm_protocal_c_afe.oTN))) {
                        hashMap.put(com_tencent_mm_protocal_c_afe.tkE, com_tencent_mm_protocal_c_afe.oTN);
                    }
                }
            }
            String str = toVar.fDC;
            int i = toVar.tcm;
            final String str2 = toVar.tBF;
            switch (i) {
                case 6:
                    w.i("MicroMsg.GameWebPageView", "getA8key-special_webview: fullUrl = " + str2);
                    if (str2 == null || str2.length() == 0) {
                        w.e("MicroMsg.GameWebPageView", "getA8key-special_webview fail, invalid fullUrl");
                        return;
                    } else if (z.IN(str2)) {
                        this.mmy.loadUrl(str2);
                        this.mmc.ks(false);
                        return;
                    } else {
                        w.f("MicroMsg.GameWebPageView", "processGetA8Key special, canLoadUrl fail, url = " + str2);
                        azI();
                        return;
                    }
                case 7:
                    w.i("MicroMsg.GameWebPageView", "getA8key-webview_no_notice: title = " + str + ", fullUrl = " + str2);
                    if (str2 == null || str2.length() == 0) {
                        w.e("MicroMsg.GameWebPageView", "getA8key-webview_no_notice fail, invalid fullUrl");
                        return;
                    }
                    if (str != null && str.length() > 0) {
                        this.mmc.qP(str);
                    }
                    if (z.IN(str2)) {
                        this.mmP = str2;
                        if (azJ()) {
                            this.mHandler.post(new Runnable(this) {
                                final /* synthetic */ d mnm;

                                public final void run() {
                                    int i;
                                    if (!(hashMap == null || hashMap.size() == 0)) {
                                        this.mnm.mmY = true;
                                        CookieSyncManager.createInstance(this.mnm.mmc);
                                        CookieManager instance = CookieManager.getInstance();
                                        for (String str : hashMap.keySet()) {
                                            instance.setCookie(bg.Qo(str2), str + "=" + ((String) hashMap.get(str)));
                                        }
                                        instance.setCookie(bg.Qo(this.mnm.mmP), "httponly");
                                        CookieSyncManager.getInstance().sync();
                                        w.i("MicroMsg.GameWebPageView", "cookies:%s", new Object[]{instance.getCookie(bg.Qo(str2))});
                                    }
                                    d dVar = this.mnm;
                                    String str2 = str2;
                                    if (hashMap == null || hashMap.size() == 0) {
                                        i = 0;
                                    } else {
                                        i = 1;
                                    }
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("fullurl", str2);
                                        jSONObject.put("set_cookie", i);
                                        dVar.ck("onGetA8KeyUrl", jSONObject.toString());
                                    } catch (Exception e) {
                                        w.e("MicroMsg.GameWebviewJsLoader", "onGetA8Key, e:" + e.getMessage());
                                    }
                                }
                            });
                            return;
                        } else if (hashMap.size() > 0) {
                            this.mmy.loadUrl(str2, hashMap);
                            return;
                        } else {
                            this.mmy.loadUrl(str2);
                            return;
                        }
                    }
                    w.f("MicroMsg.GameWebPageView", "processGetA8Key qrcode no notice, canLoadUrl fail, url = " + str2);
                    azI();
                    return;
                default:
                    return;
            }
        }
    }

    private void azI() {
        w.d("MicroMsg.GameWebPageView", "forceQuit");
        if (this.mmU) {
            eD(false);
        }
    }

    private void eB(boolean z) {
        this.mmc.setProgressBarIndeterminateVisibility(false);
        if (z) {
            azL();
        } else if (!azJ()) {
            azM();
        }
    }

    public final boolean azJ() {
        if (this.mmK != null) {
            return this.mmK.soO;
        }
        return false;
    }

    public final GameWebViewBaseActivity azK() {
        if (this.mmc.isFinishing() || this.mmc.uSW) {
            return null;
        }
        return this.mmc;
    }

    public final String IU() {
        String azN = azN();
        if (bg.mA(azN)) {
            return "";
        }
        String str = (String) this.mmW.get(azN);
        if (bg.mA(str)) {
            str = (String) this.mmW.get(xI(azN));
        }
        return bg.mz(str);
    }

    public final String xH(String str) {
        if (bg.mA(str)) {
            return "";
        }
        String str2 = (String) this.mmW.get(str);
        if (bg.mA(str2)) {
            str2 = (String) this.mmW.get(xI(str));
        }
        return !bg.mA(str2) ? str2 : str;
    }

    public static String xI(String str) {
        if (bg.mA(str)) {
            return str;
        }
        int indexOf = str.indexOf("#");
        return indexOf >= 0 ? str.substring(0, indexOf) : str;
    }

    public final void azL() {
        this.iYB.finish();
        this.iYB.setVisibility(8);
    }

    public final void azM() {
        this.iYB.start();
        this.iYB.setVisibility(0);
    }

    public final void x(final int i, final String str) {
        if (i != -1) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ d mnm;

                    public final void run() {
                        if (this.mnm.mmy != null) {
                            this.mnm.mmy.x(i, str);
                        }
                    }
                });
            } else if (this.mmy != null) {
                this.mmy.x(i, str);
            }
        }
    }

    public final void ck(final String str, final String str2) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ d mnm;

                public final void run() {
                    if (this.mnm.mmy != null) {
                        this.mnm.mmy.cm(str, str2);
                    }
                }
            });
        } else if (this.mmy != null) {
            this.mmy.cm(str, str2);
        }
    }

    public final void cl(String str, String str2) {
        this.mmx.invokeHandler(str, str2, -1, System.currentTimeMillis());
    }

    public final String azN() {
        if (this.mHandler == null) {
            return this.mmO;
        }
        if (Thread.currentThread().getId() == this.mHandler.getLooper().getThread().getId()) {
            return this.mmy == null ? "" : this.mmy.getUrl();
        } else {
            return (String) new bb<String>(this, "") {
                final /* synthetic */ d mnm;

                protected final /* synthetic */ Object run() {
                    return this.mnm.mmy == null ? "" : this.mnm.mmy.getUrl();
                }
            }.b(this.mHandler);
        }
    }

    public final String azO() {
        String azN = azN();
        if (bg.mA(azN)) {
            return null;
        }
        return (String) this.mni.get(xI(azN));
    }

    public final String getTitle() {
        if (Thread.currentThread().getId() == this.mHandler.getLooper().getThread().getId()) {
            return this.mmy == null ? "" : this.mmy.getTitle();
        } else {
            return (String) new bb<String>(this, "") {
                final /* synthetic */ d mnm;

                protected final /* synthetic */ Object run() {
                    return this.mnm.mmy == null ? "" : this.mnm.mmy.getTitle();
                }
            }.b(this.mHandler);
        }
    }

    public final void xJ(String str) {
        if (this.mmx != null) {
            this.mmx.mjR.add(str);
        }
    }

    public final void eC(boolean z) {
        if (!z) {
            this.mmA.hide();
        } else if (!this.mmA.isShown()) {
            this.mmA.reset();
            this.mmA.bzY();
            this.mmA.show();
        }
    }

    public final boolean aY(String str, int i) {
        JsapiPermissionWrapper JN = this.mmH.JN(azN());
        if (JN == null) {
            return false;
        }
        switch (JN.xX(i)) {
            case 0:
            case 3:
                return false;
            case 1:
                return true;
            case 2:
                if (str.equals(ag.NAME)) {
                    return true;
                }
                return false;
            case 4:
                if (com.tencent.mm.plugin.game.gamewebview.d.a.bc(str, azN())) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public final boolean nw(int i) {
        if (this.mmH == null) {
            return false;
        }
        JsapiPermissionWrapper JN = this.mmH.JN(azN());
        if (JN != null) {
            return JN.nw(i);
        }
        return false;
    }

    public final void azP() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ d mnm;

            {
                this.mnm = r1;
            }

            public final void run() {
                com.tencent.mm.plugin.game.gamewebview.a.d.b(this.mnm.mmc, this.mnm.jdi, this.mnm.jdk);
            }
        });
    }

    public final boolean azQ() {
        if (this.mmt != null) {
            return this.mmt.azQ();
        }
        return false;
    }

    public final void eD(final boolean z) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ d mnm;

            public final void run() {
                b L = this.mnm.mms;
                boolean z = z;
                c cVar = L.mmd;
                if (cVar.mmi.peek() == L) {
                    cVar.eA(z);
                    return;
                }
                cVar.mmi.remove(L);
                cVar.a(L);
            }
        });
    }
}
