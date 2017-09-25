package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.webview.d.g;
import com.tencent.mm.plugin.webview.d.g.c;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult.ImageData;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.smtt.sdk.ab;
import org.json.JSONObject;

public final class a extends FrameLayout implements OnCreateContextMenuListener {
    public MMWebViewWithJsApi iYA;
    private MMFalseProgressBar iYB;
    private b iYC;
    private a iYD;
    private m iYE;
    private d iYF;
    private e iYG;
    private String iYH;
    private l iYI;
    private String iYJ;
    int iYK;
    int iYL;
    g iYM;
    HitTestResult iYN;
    IX5WebViewBase.HitTestResult iYO;
    private com.tencent.mm.plugin.webview.ui.tools.widget.d iYP = new com.tencent.mm.plugin.webview.ui.tools.widget.d(this) {
        final /* synthetic */ a iYS;

        {
            this.iYS = r1;
        }

        public final Bundle d(int i, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_webview_container_env", "miniProgram");
            switch (i) {
                case 101:
                    bundle.setClassLoader(WebViewUI.class.getClassLoader());
                    com.tencent.mm.bb.d.b(this.iYS.iYE.mContext, bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")));
                    break;
                case 132:
                    try {
                        JSONObject jSONObject = new JSONObject(bundle.getString("info"));
                        this.iYS.iYz.mData = jSONObject.toString();
                        this.iYS.iYz.SR();
                        break;
                    } catch (Exception e) {
                        break;
                    }
                case com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX /*133*/:
                    bundle2.putInt("key_webview_preverify_info_scene", 1);
                    bundle2.putString("key_webview_preverify_info_source_appid", this.iYS.ivH);
                    break;
            }
            return bundle2;
        }

        public final void e(String str, final String str2, int i, int i2) {
            w.d("MicroMsg.AppBrandHTMLWebView", "result: " + str2);
            if (this.iYS.iYM != null && str != null && str.equals(this.iYS.iYM.rZF)) {
                if (this.iYS.iYM != null) {
                    this.iYS.iYM.bxd();
                }
                this.iYS.iYK = i;
                this.iYS.iYL = i2;
                if (str2 != null && this.iYS.iYI != null) {
                    this.iYS.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 iYU;

                        public final void run() {
                            this.iYU.iYS.iYJ = str2;
                            this.iYU.iYS.iYI.b(this.iYU.iYS.iYA, new OnCreateContextMenuListener(this) {
                                final /* synthetic */ AnonymousClass1 iYV;

                                {
                                    this.iYV = r1;
                                }

                                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                                    if (this.iYV.iYU.iYS.iYN != null) {
                                        w.d("MicroMsg.AppBrandHTMLWebView", "show webkit menu");
                                        this.iYV.iYU.iYS.a(contextMenu, this.iYV.iYU.iYS.iYN);
                                        this.iYV.iYU.iYS.iYN = null;
                                    } else if (this.iYV.iYU.iYS.iYO != null) {
                                        w.d("MicroMsg.AppBrandHTMLWebView", "show IX5 menu");
                                        this.iYV.iYU.iYS.a(contextMenu, this.iYV.iYU.iYS.iYO);
                                        this.iYV.iYU.iYS.iYO = null;
                                    }
                                }
                            }, null);
                            this.iYU.iYS.iYI.blb();
                        }
                    });
                }
            }
        }
    };
    private ProxyWebViewClientExtension iYQ = new ProxyWebViewClientExtension(this) {
        final /* synthetic */ a iYS;

        {
            this.iYS = r1;
        }

        public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
            return this.iYS.mWebViewCallbackClient.s(motionEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            return this.iYS.mWebViewCallbackClient.u(motionEvent);
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            return this.iYS.mWebViewCallbackClient.t(motionEvent);
        }

        public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
            return this.iYS.mWebViewCallbackClient.a(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            this.iYS.mWebViewCallbackClient.onScrollChanged(i, i2, i3, i4, view);
        }

        public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
            this.iYS.mWebViewCallbackClient.b(i, i2, z, z2);
        }

        public final void computeScroll(View view) {
            this.iYS.mWebViewCallbackClient.UN();
        }

        public final void invalidate() {
        }
    };
    private c iYR = new c(this) {
        final /* synthetic */ a iYS;

        {
            this.iYS = r1;
        }

        public final void pF(String str) {
            try {
                if (this.iYS.iYF != null) {
                    this.iYS.iYF.Jy(str);
                } else {
                    w.i("MicroMsg.AppBrandHTMLWebView", "viewCaptureCallback, invoker is null");
                }
            } catch (RemoteException e) {
                w.e("MicroMsg.AppBrandHTMLWebView", "recog failed");
            }
        }
    };
    private b iYz;
    private String ivH;
    private ab mWebViewCallbackClient = new ab(this) {
        final /* synthetic */ a iYS;

        {
            this.iYS = r1;
        }

        public final boolean s(MotionEvent motionEvent) {
            return this.iYS.iYA.J(motionEvent);
        }

        public final boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            return this.iYS.iYA.b(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        public final void UN() {
            this.iYS.iYA.caJ();
        }

        @TargetApi(9)
        public final void b(int i, int i2, boolean z, boolean z2) {
            this.iYS.iYA.c(i, i2, z, z2);
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            this.iYS.iYA.v(i, i2, i3, i4);
        }

        public final boolean t(MotionEvent motionEvent) {
            return this.iYS.iYA.K(motionEvent);
        }

        public final boolean u(MotionEvent motionEvent) {
            return this.iYS.iYA.L(motionEvent);
        }
    };

    private class a extends com.tencent.mm.plugin.webview.ui.tools.widget.b {
        final /* synthetic */ a iYS;

        public a(a aVar, MMWebViewWithJsApi mMWebViewWithJsApi) {
            this.iYS = aVar;
            super(mMWebViewWithJsApi);
        }

        public final void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            this.iYS.iYE.qp(str);
        }
    }

    private class b extends com.tencent.mm.plugin.webview.ui.tools.widget.c {
        final /* synthetic */ a iYS;

        public b(a aVar, MMWebView mMWebView) {
            this.iYS = aVar;
            super(mMWebView);
        }

        protected final com.tencent.mm.plugin.webview.ui.tools.widget.d UO() {
            return this.iYS.iYP;
        }

        protected final void a(d dVar, e eVar) {
            this.iYS.iYF = dVar;
            this.iYS.iYG = eVar;
        }

        protected final void a(WebView webView, String str, Bitmap bitmap) {
            this.iYS.iYA.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
            this.iYS.iYB.start();
            this.iYS.pE(str);
        }

        protected final void a(WebView webView, String str) {
            this.iYS.iYA.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
            this.iYS.iYB.finish();
            this.iYS.pE(str);
        }

        protected final int UP() {
            return 49;
        }

        protected final void e(Bundle bundle, String str) {
            super.e(bundle, str);
            bundle.putString("geta8key_data_appid", this.iYS.ivH);
        }
    }

    static /* synthetic */ void b(a aVar, String str) {
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        if (intent.getIntExtra("Retr_Msg_Type", -1) < 0) {
            intent.putExtra("Retr_Msg_Type", 4);
        }
        com.tencent.mm.bb.d.a(aVar.getContext(), ".ui.transmit.MsgRetransmitUI", intent);
    }

    static /* synthetic */ void c(a aVar, String str) {
        try {
            if (aVar.iYF.Jw(str) == 0) {
                Toast.makeText(aVar.getContext(), aVar.getContext().getString(R.l.eiO), 0).show();
            }
        } catch (Exception e) {
            w.e("MicroMsg.AppBrandHTMLWebView", "favoriteUrl fail, ex = " + e.getMessage());
        }
    }

    public a(Context context, h hVar, m mVar) {
        super(context);
        this.ivH = hVar.ivH;
        this.iYz = new b();
        this.iYz.a(hVar.iwq);
        this.iYE = mVar;
        this.iYA = com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a.dg(context);
        this.iYA.getSettings().setDomStorageEnabled(true);
        this.iYA.getSettings().setJavaScriptEnabled(true);
        this.iYA.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.iYA.getSettings().setMixedContentMode(0);
        this.iYA.getSettings().setUserAgentString(s.aZ(getContext(), this.iYA.getSettings().getUserAgentString()));
        this.iYA.getView().setHorizontalScrollBarEnabled(false);
        this.iYA.getView().setVerticalScrollBarEnabled(false);
        this.iYA.getSettings().setBuiltInZoomControls(true);
        this.iYA.getSettings().setUseWideViewPort(true);
        this.iYA.getSettings().setLoadWithOverviewMode(true);
        this.iYA.getSettings().setSavePassword(false);
        this.iYA.getSettings().setSaveFormData(false);
        this.iYA.getSettings().setGeolocationEnabled(true);
        this.iYA.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.iYA.getSettings().setAppCacheMaxSize(10485760);
        this.iYA.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
        this.iYA.getSettings().setAppCacheEnabled(true);
        this.iYA.getSettings().setDatabaseEnabled(true);
        this.iYA.getSettings().setDatabasePath(com.tencent.mm.loader.stub.a.hgp + "databases/");
        this.iYC = new b(this, this.iYA);
        this.iYD = new a(this, this.iYA);
        this.iYA.setWebViewClient(this.iYC);
        this.iYA.setWebChromeClient(this.iYD);
        this.iYA.wwU = mVar.jdf;
        this.iYA.caI();
        this.iYA.setWebViewCallbackClient(this.mWebViewCallbackClient);
        if (this.iYA.wwS) {
            this.iYA.getX5WebViewExtension().setWebViewClientExtension(this.iYQ);
        }
        addView(this.iYA, new LayoutParams(-1, -1));
        this.iYB = new MMFalseProgressBar(context);
        this.iYB.setProgressDrawable(com.tencent.mm.bg.a.a(context, R.g.bhd));
        addView(this.iYB, new LayoutParams(-1, com.tencent.mm.bg.a.fromDPToPix(context, 3)));
        this.iYA.snw = false;
        this.iYE.a(new m.c(this) {
            final /* synthetic */ a iYS;

            {
                this.iYS = r1;
            }

            public final void onDestroy() {
                this.iYS.iYC.Po();
            }
        });
        this.iYI = new l(getContext());
        this.iYI.a(this.iYA, this, null);
        this.iYI.e(new OnCancelListener(this) {
            final /* synthetic */ a iYS;

            {
                this.iYS = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.iYS.iYM != null && this.iYS.iYF != null) {
                    try {
                        this.iYS.iYF.Jz(this.iYS.iYM.rZF);
                        this.iYS.iYM.bxd();
                    } catch (Exception e) {
                        w.e("MicroMsg.AppBrandHTMLWebView", "cancel capture failed");
                    }
                }
            }
        });
    }

    public final void pE(String str) {
        if (!bg.mA(str)) {
            this.iYH = str;
            if (!bg.mA(Uri.parse(str).getHost())) {
                this.iYE.qr(getContext().getString(R.l.fmw, new Object[]{r0}));
                return;
            }
        }
        this.iYE.qr("");
    }

    private boolean a(ContextMenu contextMenu, final String str) {
        boolean isSDCardAvailable;
        try {
            isSDCardAvailable = this.iYF.isSDCardAvailable();
        } catch (Exception e) {
            w.e("MicroMsg.AppBrandHTMLWebView", "onCreateContextMenu fail, ex = " + e.getMessage());
            isSDCardAvailable = false;
        }
        if (!isSDCardAvailable) {
            return true;
        }
        if (this.iYG == null) {
            return true;
        }
        contextMenu.setHeaderTitle(R.l.fnH);
        try {
            isSDCardAvailable = this.iYF.azg();
        } catch (Exception e2) {
            w.e("MicroMsg.AppBrandHTMLWebView", "get has setuin failed : %s", new Object[]{e2.getMessage()});
            isSDCardAvailable = false;
        }
        w.i("MicroMsg.AppBrandHTMLWebView", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[]{Boolean.valueOf(isSDCardAvailable), Boolean.valueOf(this.iYG.bxR().bHk()), Boolean.valueOf(this.iYG.bxR().bHl())});
        if (isSDCardAvailable && r3) {
            contextMenu.add(0, 0, 0, getContext().getString(R.l.eHR)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ a iYS;

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        s.a(this.iYS.getContext(), str, CookieManager.getInstance().getCookie(str), this.iYS.iYF.isSDCardAvailable(), new com.tencent.mm.pluginsdk.ui.tools.s.b(this) {
                            final /* synthetic */ AnonymousClass7 iYX;

                            {
                                this.iYX = r1;
                            }

                            public final void pG(String str) {
                                if (bg.mA(str)) {
                                    w.w("MicroMsg.AppBrandHTMLWebView", "share image to friend fail, imgPath is null");
                                } else {
                                    a.b(this.iYX.iYS, str);
                                }
                            }
                        });
                    } catch (Exception e) {
                        w.e("MicroMsg.AppBrandHTMLWebView", "onMenuItemClick fail, ex = " + e.getMessage());
                    }
                    return true;
                }
            });
        }
        contextMenu.add(0, 0, 0, getContext().getString(R.l.eOm)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ a iYS;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean isSDCardAvailable;
                try {
                    isSDCardAvailable = this.iYS.iYF.isSDCardAvailable();
                } catch (Exception e) {
                    w.e("MicroMsg.AppBrandHTMLWebView", "onMenuItemClick fail, ex = " + e.getMessage());
                    isSDCardAvailable = false;
                }
                try {
                    s.a(this.iYS.getContext(), str, CookieManager.getInstance().getCookie(str), isSDCardAvailable);
                } catch (Exception e2) {
                    w.e("MicroMsg.AppBrandHTMLWebView", "save to sdcard failed : %s", new Object[]{e2.getMessage()});
                }
                return true;
            }
        });
        if (isSDCardAvailable && r4) {
            contextMenu.add(0, 0, 0, getContext().getString(R.l.eGa)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ a iYS;

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        boolean isSDCardAvailable = this.iYS.iYF.isSDCardAvailable();
                        String replaceAll = str.replaceAll("tp=webp", "");
                        s.a(this.iYS.getContext(), replaceAll, CookieManager.getInstance().getCookie(replaceAll), isSDCardAvailable, new com.tencent.mm.pluginsdk.ui.tools.s.b(this) {
                            final /* synthetic */ AnonymousClass9 iYY;

                            {
                                this.iYY = r1;
                            }

                            public final void pG(String str) {
                                a.c(this.iYY.iYS, str);
                            }
                        });
                    } catch (Exception e) {
                        w.e("MicroMsg.AppBrandHTMLWebView", "onMenuItemClick fail, ex = " + e.getMessage());
                    }
                    return true;
                }
            });
        }
        if (this.iYJ == null) {
            return false;
        }
        CharSequence string;
        final String str2 = this.iYJ;
        if (com.tencent.mm.plugin.scanner.a.ak(this.iYK, this.iYJ)) {
            string = getContext().getString(R.l.eIB);
        } else {
            string = getContext().getString(R.l.eIA);
        }
        contextMenu.add(0, 0, 0, string).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ a iYS;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                a aVar = this.iYS;
                String str = str2;
                String l = this.iYS.iYH;
                String str2 = str;
                int i = this.iYS.iYK;
                int i2 = this.iYS.iYL;
                if (str != null) {
                    Intent intent = new Intent();
                    intent.setClass(aVar.getContext(), WebviewScanImageActivity.class);
                    intent.putExtra("key_string_for_scan", str);
                    intent.putExtra("key_string_for_url", l);
                    intent.putExtra("key_string_for_image_url", str2);
                    intent.putExtra("key_codetype_for_scan", i);
                    intent.putExtra("key_codeversion_for_scan", i2);
                    aVar.getContext().startActivity(intent);
                }
                return false;
            }
        });
        this.iYJ = null;
        return true;
    }

    private void a(ContextMenu contextMenu, IX5WebViewBase.HitTestResult hitTestResult) {
        if (!a(contextMenu, ((ImageData) hitTestResult.getData()).mPicUrl) && this.iYG.bxR().bHi()) {
            this.iYO = hitTestResult;
            this.iYM = new g();
            this.iYM.a(this.iYA, this.iYR);
        }
    }

    private void a(ContextMenu contextMenu, HitTestResult hitTestResult) {
        if (!a(contextMenu, hitTestResult.getExtra()) && this.iYG.bxR().bHi()) {
            this.iYN = hitTestResult;
            this.iYM = new g();
            this.iYM.a(this.iYA, this.iYR);
        }
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view instanceof android.webkit.WebView) {
            HitTestResult hitTestResult = this.iYA.getHitTestResult();
            if (hitTestResult != null) {
                if (hitTestResult.getType() == 5 || hitTestResult.getType() == 8) {
                    a(contextMenu, hitTestResult);
                }
            }
        } else if (view instanceof IX5WebViewBase) {
            IX5WebViewBase.HitTestResult hitTestResult2 = ((IX5WebViewBase) view).getHitTestResult();
            if (hitTestResult2 == null) {
                return;
            }
            if (hitTestResult2.getType() == 5 || hitTestResult2.getType() == 8) {
                a(contextMenu, hitTestResult2);
            }
        }
    }
}
