package com.tencent.mm.plugin.webview.ui.tools.game;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.46;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.protocal.c.aem;
import com.tencent.mm.protocal.c.alo;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.l;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.ab;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GameWebViewUI extends WebViewUI {
    private static String siC = "wx_fullscreen";
    private Map<Integer, alo> mnJ = new HashMap();
    private boolean mpB = false;
    private int siA;
    private boolean siB = false;
    private HashMap<String, String> siD = new HashMap();
    private Drawable siE;
    private Drawable siF;
    private a siG;
    private String siH = null;
    private String siI;
    protected GameMenuImageButton siJ;
    private com.tencent.mm.plugin.webview.wepkg.a sit;

    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] mnM = new int[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.values().length];

        static {
            try {
                mnM[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.siU.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                mnM[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.siV.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mnM[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.siW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                mnM[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.siX.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                mnM[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.siY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                mnM[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.siZ.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                mnM[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.sja.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                mnM[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.sjb.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                mnM[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.sjc.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                mnM[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.sjd.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                mnM[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.siT.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    private class a extends h {
        final /* synthetic */ GameWebViewUI siK;

        public a(GameWebViewUI gameWebViewUI) {
            this.siK = gameWebViewUI;
            super(gameWebViewUI);
        }

        public final Object onMiscCallBack(String str, Bundle bundle) {
            Object onMiscCallBack = this.siK.sit.soW.onMiscCallBack(str, bundle);
            return onMiscCallBack != null ? onMiscCallBack : super.onMiscCallBack(str, bundle);
        }
    }

    private class b extends i {
        final /* synthetic */ GameWebViewUI siK;

        public b(GameWebViewUI gameWebViewUI) {
            this.siK = gameWebViewUI;
            super(gameWebViewUI);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            this.siK.sit.soV.onPageStarted(webView, str, bitmap);
            super.onPageStarted(webView, str, bitmap);
        }

        public final void onPageFinished(WebView webView, String str) {
            GameWebViewUI.J(this.siK);
            this.siK.sit.soV.onPageFinished(webView, str);
            super.onPageFinished(webView, str);
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            GameWebViewUI.J(this.siK);
            super.onReceivedError(webView, i, str, str2);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebResourceResponse shouldInterceptRequest = this.siK.sit.soV.shouldInterceptRequest(webView, str);
            return shouldInterceptRequest != null ? shouldInterceptRequest : super.shouldInterceptRequest(webView, str);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebResourceResponse shouldInterceptRequest = this.siK.sit.soV.shouldInterceptRequest(webView, webResourceRequest);
            return shouldInterceptRequest != null ? shouldInterceptRequest : super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            WebResourceResponse shouldInterceptRequest = this.siK.sit.soV.shouldInterceptRequest(webView, webResourceRequest, bundle);
            return shouldInterceptRequest != null ? shouldInterceptRequest : super.shouldInterceptRequest(webView, webResourceRequest, bundle);
        }
    }

    static /* synthetic */ void J(GameWebViewUI gameWebViewUI) {
        if (gameWebViewUI.scN != null) {
            gameWebViewUI.scN.setVisibility(8);
        }
    }

    static /* synthetic */ void X(GameWebViewUI gameWebViewUI) {
        gameWebViewUI.siB = false;
        gameWebViewUI.wz(255);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.Wepkg.GameWebViewUI", "GameWebViewUI oncreate");
        w.i("MicroMsg.Wepkg.GameWebViewUI", "rawUrl rid:%s, pkgId:%s", new Object[]{d.KQ(this.fWY), d.KO(this.fWY)});
        Intent intent = getIntent();
        if (intent != null) {
            com.tencent.mm.plugin.webview.wepkg.utils.b.srv = intent.getBooleanExtra("disable_wepkg", false);
            if (intent.getBooleanExtra("disable_progress_bar", false)) {
                this.scM.vjc = false;
                if (this.scN != null) {
                    this.scN.setVisibility(0);
                }
            }
        }
        this.ser = new ab(this) {
            final /* synthetic */ GameWebViewUI siK;

            {
                this.siK = r1;
            }

            public final boolean s(MotionEvent motionEvent) {
                if (this.siK.oET == null) {
                    return false;
                }
                return this.siK.oET.J(motionEvent);
            }

            public final boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
                if (this.siK.oET == null) {
                    return false;
                }
                return this.siK.oET.b(i, i2, i3, i4, i5, i6, i7, i8, z);
            }

            public final void UN() {
                if (this.siK.oET != null) {
                    this.siK.oET.caJ();
                }
            }

            @TargetApi(9)
            public final void b(int i, int i2, boolean z, boolean z2) {
                if (this.siK.oET != null) {
                    this.siK.oET.c(i, i2, z, z2);
                }
            }

            public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
                if (this.siK.oET != null) {
                    this.siK.oET.v(i, i2, i3, i4);
                    if (!this.siK.mpB) {
                        return;
                    }
                    if (i2 >= this.siK.siA) {
                        if (this.siK.siB) {
                            GameWebViewUI.X(this.siK);
                        }
                    } else if (i2 < this.siK.siA) {
                        this.siK.wz((int) ((((float) i2) / ((float) this.siK.siA)) * 255.0f));
                    }
                }
            }

            public final boolean t(MotionEvent motionEvent) {
                if (this.siK.oET == null) {
                    return false;
                }
                return this.siK.oET.K(motionEvent);
            }

            public final boolean u(MotionEvent motionEvent) {
                if (this.siK.oET == null) {
                    return false;
                }
                return this.siK.oET.L(motionEvent);
            }
        };
        if (!bg.mA(this.fWY)) {
            try {
                b(new URI(this.fWY));
            } catch (Exception e) {
                w.e("MicroMsg.Wepkg.GameWebViewUI", "parseUrl error, %s,  rawUrl = %s", new Object[]{e.getMessage(), this.fWY});
            }
        }
        this.siA = bxY();
        if (this.siD.containsKey(siC) && ((String) this.siD.get(siC)).equals("1")) {
            this.mpB = true;
        }
        if (this.mpB && this.oET.wwS) {
            byc();
        }
        this.oET.setWebViewClient(new b(this));
        if (this.oET.wwS) {
            this.oET.getX5WebViewExtension().setWebViewClientExtension(new a(this));
        }
        this.sit = new com.tencent.mm.plugin.webview.wepkg.a(this, this.oET);
        this.sit.soT = new com.tencent.mm.plugin.webview.wepkg.a.a(this) {
            final /* synthetic */ GameWebViewUI siK;

            {
                this.siK = r1;
            }

            public final boolean azU() {
                return this.siK.sde;
            }
        };
        this.sit.onCreate(this.fWY);
        this.siG = new a(this, this.scS);
        this.siJ = new GameMenuImageButton(this.uSU.uTo);
    }

    private l aAe() {
        try {
            List list;
            List list2 = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.siN;
            Bundle bundle = new Bundle();
            bundle.putString("game_hv_menu_appid", this.siI);
            if (this.iYF != null) {
                bundle = this.iYF.d(92, bundle);
            } else {
                bundle = null;
            }
            if (bundle != null) {
                String string = bundle.getString("game_hv_menu_pbcache");
                if (!bg.mA(string)) {
                    byte[] bytes = string.getBytes("ISO-8859-1");
                    aem com_tencent_mm_protocal_c_aem = new aem();
                    com_tencent_mm_protocal_c_aem.aD(bytes);
                    if (!bg.bV(com_tencent_mm_protocal_c_aem.tJD)) {
                        LinkedList linkedList = com_tencent_mm_protocal_c_aem.tJD;
                        w.i("MicroMsg.Wepkg.GameWebViewUI", "use net menu data");
                        list = linkedList;
                        this.mnJ.clear();
                        for (alo com_tencent_mm_protocal_c_alo : r2) {
                            this.mnJ.put(Integer.valueOf(com_tencent_mm_protocal_c_alo.tQs), com_tencent_mm_protocal_c_alo);
                        }
                        return c.bzg().f(r2, LZ());
                    }
                }
            }
            list = list2;
            this.mnJ.clear();
            for (alo com_tencent_mm_protocal_c_alo2 : r2) {
                this.mnJ.put(Integer.valueOf(com_tencent_mm_protocal_c_alo2.tQs), com_tencent_mm_protocal_c_alo2);
            }
            return c.bzg().f(r2, LZ());
        } catch (Exception e) {
            w.e("MicroMsg.Wepkg.GameWebViewUI", "get cache hv game menu fail! exception:%s", new Object[]{e.getMessage()});
            return null;
        }
    }

    protected final void aAb() {
        if (this.siJ == null || !this.siJ.siO) {
            super.aAb();
            return;
        }
        final com.tencent.mm.plugin.webview.ui.tools.game.menu.d dVar = new com.tencent.mm.plugin.webview.ui.tools.game.menu.d(this.uSU.uTo);
        dVar.a(new com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c(this) {
            final /* synthetic */ GameWebViewUI siK;

            {
                this.siK = r1;
            }

            public final void g(MenuItem menuItem) {
                alo com_tencent_mm_protocal_c_alo = (alo) this.siK.mnJ.get(Integer.valueOf(menuItem.getItemId()));
                if (com_tencent_mm_protocal_c_alo != null) {
                    ai.c bwE;
                    switch (AnonymousClass8.mnM[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.wB(com_tencent_mm_protocal_c_alo.tAL).ordinal()]) {
                        case 1:
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", com_tencent_mm_protocal_c_alo.tAM);
                            com.tencent.mm.bb.d.b(this.siK.uSU.uTo, "webview", ".ui.tools.game.GameWebViewUI", intent);
                            return;
                        case 2:
                            bwE = this.siK.rWq.bwE();
                            bwE.rXz = new Object[]{this.siK.fWY, Integer.valueOf(32), Integer.valueOf(1)};
                            bwE.b(this.siK.iYF);
                            if (!this.siK.azQ()) {
                                this.siK.finish();
                                return;
                            }
                            return;
                        case 3:
                            String stringExtra = this.siK.getIntent().getStringExtra("KPublisherId");
                            String stringExtra2 = this.siK.getIntent().getStringExtra("KAppId");
                            String stringExtra3 = this.siK.getIntent().getStringExtra("srcUsername");
                            ai.c bwE2 = this.siK.rWq.bwE();
                            bwE2.rXz = new Object[]{this.siK.fWY, Integer.valueOf(1), Integer.valueOf(1), stringExtra, stringExtra2, stringExtra3};
                            bwE2.b(this.siK.iYF);
                            this.siK.sdd = this.siK.iYG.bxR().bHj();
                            this.siK.aAh();
                            return;
                        case 4:
                            bwE = this.siK.rWq.bwE();
                            bwE.rXz = new Object[]{this.siK.fWY, Integer.valueOf(3), Integer.valueOf(1)};
                            bwE.b(this.siK.iYF);
                            g.oUh.a(157, 6, 1, false);
                            this.siK.sdd = this.siK.iYG.bxR().bHj();
                            this.siK.aAo();
                            return;
                        case 5:
                            bwE = this.siK.rWq.bwE();
                            bwE.rXz = new Object[]{this.siK.fWY, Integer.valueOf(29), Integer.valueOf(1)};
                            bwE.b(this.siK.iYF);
                            this.siK.aAk();
                            return;
                        case 6:
                            bwE = this.siK.rWq.bwE();
                            bwE.rXz = new Object[]{this.siK.fWY, Integer.valueOf(30), Integer.valueOf(1)};
                            bwE.b(this.siK.iYF);
                            this.siK.aAl();
                            return;
                        case 7:
                            bwE = this.siK.rWq.bwE();
                            bwE.rXz = new Object[]{this.siK.fWY, Integer.valueOf(10), Integer.valueOf(1)};
                            bwE.b(this.siK.iYF);
                            if (this.siK.oET != null) {
                                this.siK.oET.reload();
                                return;
                            }
                            return;
                        case 8:
                            bwE = this.siK.rWq.bwE();
                            bwE.rXz = new Object[]{this.siK.fWY, Integer.valueOf(31), Integer.valueOf(1)};
                            bwE.b(this.siK.iYF);
                            this.siK.aAn();
                            return;
                        case 9:
                            bwE = this.siK.rWq.bwE();
                            bwE.rXz = new Object[]{this.siK.fWY, Integer.valueOf(11), Integer.valueOf(1)};
                            bwE.b(this.siK.iYF);
                            this.siK.byq();
                            return;
                        case 10:
                            if (this.siK.rVm != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d E = this.siK.rVm;
                                int i = com_tencent_mm_protocal_c_alo.tQs;
                                w.i("MicroMsg.JsApiHandler", com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME);
                                Map hashMap = new HashMap();
                                hashMap.put("itemId", Integer.valueOf(i));
                                af.v(new 46(E, com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a(com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME, hashMap, E.sjU, E.sjV)));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        dVar.sjh = new com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b(this) {
            final /* synthetic */ GameWebViewUI siK;

            {
                this.siK = r1;
            }

            public final void a(l lVar) {
                g.oUh.a(480, 0, 1, false);
                l F = this.siK.aAe();
                if (F != null) {
                    lVar.vla.addAll(F.vla);
                }
            }
        };
        if (this.scV) {
            dVar.sjm = true;
            dVar.sjn = true;
        } else {
            dVar.sjm = false;
            dVar.sjn = false;
        }
        if (this.scY == null || !this.scY.isShown()) {
            aHf();
            af.f(new Runnable(this) {
                final /* synthetic */ GameWebViewUI siK;

                public final void run() {
                    if (this.siK.isFinishing() || this.siK.sel) {
                        w.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
                    } else {
                        dVar.bzh();
                    }
                }
            }, 100);
            return;
        }
        this.scY.hide();
        af.f(new Runnable(this) {
            final /* synthetic */ GameWebViewUI siK;

            public final void run() {
                if (this.siK.isFinishing() || this.siK.sel) {
                    w.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
                } else {
                    dVar.bzh();
                }
            }
        }, 100);
    }

    protected final void byr() {
        if (!bg.mA(this.siH)) {
            this.siG.loadUrl(this.siH);
        }
    }

    protected final void ce(String str, int i) {
        super.ce(str, i);
    }

    protected final int byg() {
        return super.byg();
    }

    protected final void R(Bundle bundle) {
        super.R(bundle);
    }

    protected final void axz() {
        super.axz();
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("game_check_float", false)) {
            int intExtra = intent.getIntExtra("game_sourceScene", 0);
            this.siH = intent.getStringExtra("game_transparent_float_url");
            if (bg.mA(this.siH)) {
                intent = new Intent();
                intent.putExtra("game_check_float", true);
                intent.putExtra("game_sourceScene", intExtra);
                com.tencent.mm.bb.d.b(this, "game", ".ui.GameCenterUI", intent);
                return;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("game_sourceScene", intExtra);
                if (this.iYF != null) {
                    this.iYF.d(91, bundle);
                }
            } catch (RemoteException e) {
            }
        }
    }

    public void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.sit.onDestroy();
    }

    public void KC() {
        super.KC();
        this.siE = new ColorDrawable(android.support.v4.content.a.b(this, R.e.aSD));
        this.siF = new ColorDrawable(android.support.v4.content.a.b(this, R.e.aSD));
    }

    protected final void byh() {
        super.byh();
        this.siI = getIntent().getStringExtra("game_hv_menu_appid");
        if (this.scU && !bg.mA(this.siI)) {
            if (this.scT != null) {
                this.scT.setVisibility(8);
            }
            this.siJ.a(this.scR, new com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.a(this) {
                final /* synthetic */ GameWebViewUI siK;

                {
                    this.siK = r1;
                }

                public final void aAa() {
                    this.siK.aAb();
                }
            });
        }
    }

    protected final boolean JO(String str) {
        return this.sit.soO;
    }

    protected final void xG(String str) {
        if (this.sit.bAn()) {
            this.oET.loadUrl(str);
        } else {
            super.xG(str);
        }
    }

    protected final void azv() {
        if (VERSION.SDK_INT <= 10) {
            super.azv();
        } else if (this.screenOrientation == -1) {
            this.uST = getSharedPreferences(com.tencent.mm.sdk.platformtools.ab.bIX(), 4).getBoolean("settings_landscape_mode", false);
            if (this.uST) {
                setRequestedOrientation(2);
            } else {
                setRequestedOrientation(1);
            }
        } else {
            setRequestedOrientation(this.screenOrientation);
        }
    }

    private void b(URI uri) {
        String[] split = bg.mz(uri.getQuery()).split("&");
        if (split != null && split.length != 0) {
            for (String split2 : split) {
                String[] split3 = split2.split("=");
                if (split3 != null && split3.length == 2) {
                    this.siD.put(split3[0], split3[1]);
                }
            }
        }
    }

    protected final boolean bxX() {
        return false;
    }

    protected boolean byb() {
        return false;
    }

    protected final void byc() {
        this.siB = true;
        this.sev = true;
        ActionBar cP = cO().cP();
        if (cP != null) {
            cP.setBackgroundDrawable(this.siE);
            this.siE.setAlpha(0);
            if (cP.getCustomView() != null) {
                cP.getCustomView().setBackground(this.siF);
                this.siF.setAlpha(0);
                cP.getCustomView().invalidate();
            }
        }
        setStatusBarColor(0);
        if (this.set != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.set.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            this.set.setLayoutParams(marginLayoutParams);
        }
        f fVar = this.sez;
        int bxY = bxY();
        if (fVar.scB != null) {
            fVar.scB.setPadding(fVar.scB.getPaddingLeft(), bxY + fVar.scB.getPaddingTop(), fVar.scB.getPaddingRight(), fVar.scB.getPaddingBottom());
        }
        zk(8);
    }

    private void wz(int i) {
        if (i < 10) {
            zk(8);
        } else {
            zk(0);
        }
        if (i < 255) {
            this.siB = true;
        } else {
            this.siB = false;
        }
        if (this.siE != null) {
            this.siE.setAlpha(i);
        }
    }
}
