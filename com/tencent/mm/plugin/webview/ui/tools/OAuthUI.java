package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class OAuthUI extends WebViewUI {
    private String appId;
    private boolean nqV = false;
    private boolean sbh = true;
    private Req sbi;
    private c sbj;
    private aj sbk;

    static /* synthetic */ void a(OAuthUI oAuthUI, String str) {
        String Js;
        String bxp;
        Exception e;
        Resp resp;
        Bundle bundle;
        Args args;
        String str2 = null;
        w.i("MicroMsg.OAuthUI", "checkUrlAndLoad, url = " + str);
        if (!bg.mA(str)) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                oAuthUI.oET.loadUrl(str);
                return;
            }
            w.i("MicroMsg.OAuthUI", "check schema as appId:" + oAuthUI.appId);
            try {
                Js = oAuthUI.iYF.Js(oAuthUI.appId);
                try {
                    bxp = oAuthUI.iYF.bxp();
                    try {
                        str2 = oAuthUI.iYF.aw(274436, null);
                    } catch (Exception e2) {
                        e = e2;
                        w.w("MicroMsg.OAuthUI", "getPackageName, ex = " + e.getMessage());
                        if (!bg.mA(Js)) {
                            w.e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
                            oAuthUI.oET.loadUrl(str);
                        } else if (!str.toLowerCase().startsWith("http")) {
                            w.i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
                            oAuthUI.oET.loadUrl(str);
                        } else if (oAuthUI.nqV) {
                            oAuthUI.nqV = true;
                            resp = new Resp();
                            resp.transaction = oAuthUI.sbi.transaction;
                            resp.lang = bxp;
                            resp.country = str2;
                            str2 = parse.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                            w.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = " + str2);
                            if (!bg.mA(str2)) {
                                resp.errCode = -1;
                            } else if (str2.toLowerCase().equals("authdeny")) {
                                resp.errCode = 0;
                                resp.code = str2;
                            } else {
                                resp.errCode = -4;
                            }
                            resp.state = parse.getQueryParameter("state");
                            resp.errStr = parse.getQueryParameter("reason");
                            resp.url = str;
                            w.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + resp.code + ", errCode=" + resp.errCode + ", state=" + resp.state + ", reason=" + resp.errStr);
                            bundle = new Bundle();
                            resp.toBundle(bundle);
                            p.aa(bundle);
                            args = new Args();
                            args.targetPkgName = Js;
                            args.bundle = bundle;
                            MMessageActV2.send(oAuthUI, args);
                            oAuthUI.finish();
                        } else {
                            w.e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    bxp = str2;
                    w.w("MicroMsg.OAuthUI", "getPackageName, ex = " + e.getMessage());
                    if (!bg.mA(Js)) {
                        w.e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
                        oAuthUI.oET.loadUrl(str);
                    } else if (!str.toLowerCase().startsWith("http")) {
                        w.i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
                        oAuthUI.oET.loadUrl(str);
                    } else if (oAuthUI.nqV) {
                        oAuthUI.nqV = true;
                        resp = new Resp();
                        resp.transaction = oAuthUI.sbi.transaction;
                        resp.lang = bxp;
                        resp.country = str2;
                        str2 = parse.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                        w.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = " + str2);
                        if (!bg.mA(str2)) {
                            resp.errCode = -1;
                        } else if (str2.toLowerCase().equals("authdeny")) {
                            resp.errCode = 0;
                            resp.code = str2;
                        } else {
                            resp.errCode = -4;
                        }
                        resp.state = parse.getQueryParameter("state");
                        resp.errStr = parse.getQueryParameter("reason");
                        resp.url = str;
                        w.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + resp.code + ", errCode=" + resp.errCode + ", state=" + resp.state + ", reason=" + resp.errStr);
                        bundle = new Bundle();
                        resp.toBundle(bundle);
                        p.aa(bundle);
                        args = new Args();
                        args.targetPkgName = Js;
                        args.bundle = bundle;
                        MMessageActV2.send(oAuthUI, args);
                        oAuthUI.finish();
                    } else {
                        w.e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
                    }
                }
            } catch (Exception e32) {
                e = e32;
                Js = str2;
                bxp = str2;
                w.w("MicroMsg.OAuthUI", "getPackageName, ex = " + e.getMessage());
                if (!bg.mA(Js)) {
                    w.e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
                    oAuthUI.oET.loadUrl(str);
                } else if (!str.toLowerCase().startsWith("http")) {
                    w.i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
                    oAuthUI.oET.loadUrl(str);
                } else if (oAuthUI.nqV) {
                    oAuthUI.nqV = true;
                    resp = new Resp();
                    resp.transaction = oAuthUI.sbi.transaction;
                    resp.lang = bxp;
                    resp.country = str2;
                    str2 = parse.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                    w.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = " + str2);
                    if (!bg.mA(str2)) {
                        resp.errCode = -1;
                    } else if (str2.toLowerCase().equals("authdeny")) {
                        resp.errCode = 0;
                        resp.code = str2;
                    } else {
                        resp.errCode = -4;
                    }
                    resp.state = parse.getQueryParameter("state");
                    resp.errStr = parse.getQueryParameter("reason");
                    resp.url = str;
                    w.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + resp.code + ", errCode=" + resp.errCode + ", state=" + resp.state + ", reason=" + resp.errStr);
                    bundle = new Bundle();
                    resp.toBundle(bundle);
                    p.aa(bundle);
                    args = new Args();
                    args.targetPkgName = Js;
                    args.bundle = bundle;
                    MMessageActV2.send(oAuthUI, args);
                    oAuthUI.finish();
                } else {
                    w.e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
                }
            }
            if (!bg.mA(Js)) {
                w.e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
                oAuthUI.oET.loadUrl(str);
            } else if (!str.toLowerCase().startsWith("http")) {
                w.i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
                oAuthUI.oET.loadUrl(str);
            } else if (oAuthUI.nqV) {
                w.e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
            } else {
                oAuthUI.nqV = true;
                resp = new Resp();
                resp.transaction = oAuthUI.sbi.transaction;
                resp.lang = bxp;
                resp.country = str2;
                str2 = parse.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                w.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = " + str2);
                if (!bg.mA(str2)) {
                    resp.errCode = -1;
                } else if (str2.toLowerCase().equals("authdeny")) {
                    resp.errCode = -4;
                } else {
                    resp.errCode = 0;
                    resp.code = str2;
                }
                resp.state = parse.getQueryParameter("state");
                resp.errStr = parse.getQueryParameter("reason");
                resp.url = str;
                w.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + resp.code + ", errCode=" + resp.errCode + ", state=" + resp.state + ", reason=" + resp.errStr);
                bundle = new Bundle();
                resp.toBundle(bundle);
                p.aa(bundle);
                args = new Args();
                args.targetPkgName = Js;
                args.bundle = bundle;
                MMessageActV2.send(oAuthUI, args);
                oAuthUI.finish();
            }
        }
    }

    static /* synthetic */ void a(OAuthUI oAuthUI, String str, String str2, final String str3) {
        final View inflate = ((ViewStub) oAuthUI.findViewById(R.h.cmo)).inflate();
        oAuthUI.qP(oAuthUI.getString(R.l.fnc));
        oAuthUI.SE(oAuthUI.getString(R.l.ePy));
        oAuthUI.zn(1);
        ImageView imageView = (ImageView) oAuthUI.findViewById(R.h.bVT);
        TextView textView = (TextView) oAuthUI.findViewById(R.h.cTi);
        final ThreeDotsLoadingView threeDotsLoadingView = (ThreeDotsLoadingView) oAuthUI.findViewById(R.h.cbK);
        threeDotsLoadingView.caQ();
        a aVar = new a();
        aVar.hJj = 10.0f;
        aVar.hJa = R.k.dxP;
        com.tencent.mm.ah.a.a.Hd().a(str, imageView, aVar.Hg());
        if (bg.mA(str2)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str2);
        }
        oAuthUI.sbk = new aj(new aj.a(oAuthUI) {
            final /* synthetic */ OAuthUI sbl;

            public final boolean oQ() {
                OAuthUI.a(this.sbl, str3);
                inflate.setVisibility(8);
                threeDotsLoadingView.Wd();
                return false;
            }
        }, false);
        oAuthUI.sbk.v(1000, 1000);
    }

    static /* synthetic */ void b(OAuthUI oAuthUI, String str) {
        ((ViewStub) oAuthUI.findViewById(R.h.cmp)).inflate();
        oAuthUI.qP(oAuthUI.getString(R.l.fnc));
        oAuthUI.SE(oAuthUI.getString(R.l.ePy));
        oAuthUI.zn(1);
        TextView textView = (TextView) oAuthUI.findViewById(R.h.cTi);
        if (bg.mA(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
    }

    protected void onResume() {
        super.onResume();
        WebView.enablePlatformNotifications();
    }

    protected void onPause() {
        super.onPause();
        WebView.disablePlatformNotifications();
    }

    protected final int getLayoutId() {
        return R.i.drO;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.rWq != null) {
            this.rWq.bwA().fWY = "weixin://mark/oauth";
        }
    }

    protected final void axz() {
        boolean azg;
        super.axz();
        try {
            azg = this.iYF.azg();
        } catch (Exception e) {
            w.w("MicroMsg.OAuthUI", "hasSetUin, ex = " + e.getMessage());
            azg = false;
        }
        if (azg) {
            this.oET.setWebChromeClient(new WebChromeClient(this) {
                final /* synthetic */ OAuthUI sbl;

                {
                    this.sbl = r1;
                }

                public final void onReceivedTitle(WebView webView, String str) {
                    super.onReceivedTitle(webView, str);
                    this.sbl.qP(str);
                }
            });
            this.oET.setWebViewClient(new i(this) {
                final /* synthetic */ OAuthUI sbl;

                {
                    this.sbl = r1;
                }

                public final boolean b(WebView webView, String str) {
                    w.i("MicroMsg.OAuthUI", "mmShouldOverrideUrlLoading, url = " + str);
                    if (!(str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe"))) {
                        OAuthUI.a(this.sbl, str);
                    }
                    return true;
                }
            });
            this.oET.setDownloadListener(new DownloadListener(this) {
                final /* synthetic */ OAuthUI sbl;

                {
                    this.sbl = r1;
                }

                public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    this.sbl.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            });
            this.oET.caH();
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ OAuthUI sbl;

                {
                    this.sbl = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.sbl.bxG();
                    this.sbl.finish();
                    return true;
                }
            });
            a(1, getString(R.l.dIw), new OnMenuItemClickListener(this) {
                final /* synthetic */ OAuthUI sbl;

                {
                    this.sbl = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (this.sbl.sbj != null) {
                        this.sbl.sbj;
                    }
                    this.sbl.oET.stopLoading();
                    this.sbl.A(false, false);
                    this.sbl.bxI();
                    return false;
                }
            });
            Bundle extras = getIntent().getExtras();
            String string = extras.getString(ConstantsAPI.CONTENT);
            if (bg.mA(string)) {
                w.f("MicroMsg.OAuthUI", "content is null");
                return;
            }
            this.appId = Uri.parse(string).getQueryParameter("appid");
            w.i("MicroMsg.OAuthUI", "initView, appId = " + this.appId);
            try {
                this.iYF.Jr(this.appId);
            } catch (Exception e2) {
                w.w("MicroMsg.OAuthUI", "checkGetAppSetting, ex = " + e2.getMessage());
            }
            this.sbi = new Req(extras);
            try {
                this.sdA.byH();
            } catch (Exception e22) {
                w.w("MicroMsg.OAuthUI", "AC_ADD_SCENE_END, ex = " + e22.getMessage());
            }
            bxI();
            return;
        }
        w.e("MicroMsg.OAuthUI", "start, hasSetUin fail");
        Toast.makeText(this, R.l.dBK, 1).show();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ OAuthUI sbl;

            {
                this.sbl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.sbl.finish();
                return true;
            }
        });
        kr(false);
    }

    protected void onStop() {
        this.oET.stopLoading();
        super.onStop();
    }

    protected void onDestroy() {
        try {
            this.sdA.byI();
        } catch (Exception e) {
            w.w("MicroMsg.OAuthUI", "AC_REMOVE_SCENE_END, ex = " + e.getMessage());
        }
        if (this.sbk != null) {
            this.sbk.KH();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.sbh && i == 4 && this.oET.canGoBack()) {
            this.oET.goBack();
            return true;
        } else if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        } else {
            bxG();
            finish();
            return true;
        }
    }

    private void bxG() {
        String Js;
        String bxp;
        Exception exception;
        Resp resp;
        Bundle bundle;
        Args args;
        String str = null;
        w.i("MicroMsg.OAuthUI", "callbackResultCancel, appId = " + this.appId);
        if (this.nqV) {
            w.e("MicroMsg.OAuthUI", "has callback, ignore this callback");
            return;
        }
        this.nqV = true;
        try {
            Js = this.iYF.Js(this.appId);
            try {
                bxp = this.iYF.bxp();
            } catch (Exception e) {
                exception = e;
                bxp = str;
                w.w("MicroMsg.OAuthUI", "getPackageName, ex = " + exception.getMessage());
                if (bg.mA(Js)) {
                    w.e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
                    return;
                }
                resp = new Resp();
                resp.transaction = this.sbi.transaction;
                resp.errCode = -2;
                resp.lang = bxp;
                resp.country = str;
                bundle = new Bundle();
                resp.toBundle(bundle);
                p.aa(bundle);
                args = new Args();
                args.targetPkgName = Js;
                args.bundle = bundle;
                MMessageActV2.send(this, args);
            }
            try {
                str = this.iYF.aw(274436, null);
            } catch (Exception e2) {
                exception = e2;
                w.w("MicroMsg.OAuthUI", "getPackageName, ex = " + exception.getMessage());
                if (bg.mA(Js)) {
                    w.e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
                    return;
                }
                resp = new Resp();
                resp.transaction = this.sbi.transaction;
                resp.errCode = -2;
                resp.lang = bxp;
                resp.country = str;
                bundle = new Bundle();
                resp.toBundle(bundle);
                p.aa(bundle);
                args = new Args();
                args.targetPkgName = Js;
                args.bundle = bundle;
                MMessageActV2.send(this, args);
            }
        } catch (Exception e3) {
            exception = e3;
            Js = str;
            bxp = str;
            w.w("MicroMsg.OAuthUI", "getPackageName, ex = " + exception.getMessage());
            if (bg.mA(Js)) {
                resp = new Resp();
                resp.transaction = this.sbi.transaction;
                resp.errCode = -2;
                resp.lang = bxp;
                resp.country = str;
                bundle = new Bundle();
                resp.toBundle(bundle);
                p.aa(bundle);
                args = new Args();
                args.targetPkgName = Js;
                args.bundle = bundle;
                MMessageActV2.send(this, args);
            }
            w.e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
            return;
        }
        if (bg.mA(Js)) {
            w.e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
            return;
        }
        resp = new Resp();
        resp.transaction = this.sbi.transaction;
        resp.errCode = -2;
        resp.lang = bxp;
        resp.country = str;
        bundle = new Bundle();
        resp.toBundle(bundle);
        p.aa(bundle);
        args = new Args();
        args.targetPkgName = Js;
        args.bundle = bundle;
        MMessageActV2.send(this, args);
    }

    protected final boolean bxH() {
        return true;
    }

    protected final void KC() {
        super.KC();
        this.oET.getSettings().setJavaScriptEnabled(true);
        this.oET.setVerticalScrollBarEnabled(false);
    }

    private void bxI() {
        v.d(getSharedPreferences(ab.bIX(), 0));
        this.sbj = c.a(this, this.appId, this.sbi, new c.a(this) {
            final /* synthetic */ OAuthUI sbl;

            {
                this.sbl = r1;
            }

            public final void a(c cVar, String str, boolean z) {
                w.i("MicroMsg.OAuthUI", "onResult, url = " + str + ", isShowLocalErrorPage = " + z);
                if (cVar != null) {
                    cVar.sbc = false;
                }
                if (z) {
                    String string;
                    try {
                        string = this.sbl.getString(R.l.eFe);
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.OAuthUI", e, "", new Object[0]);
                        string = null;
                    }
                    w.i("MicroMsg.OAuthUI", "onResult, html = " + string);
                    if (this.sbl.oET != null) {
                        this.sbl.oET.loadUrl(string);
                        if (this.sbl.rWq != null) {
                            this.sbl.rWq.bwA().fWY = string;
                        }
                    }
                } else if (!bg.mA(str) && this.sbl.oET != null) {
                    this.sbl.oET.loadUrl(str);
                    if (this.sbl.rWq != null) {
                        this.sbl.rWq.bwA().fWY = str;
                    }
                }
            }

            public final void c(boolean z, String str, String str2, String str3) {
                if (z) {
                    OAuthUI.a(this.sbl, str2, str3, str);
                } else {
                    OAuthUI.b(this.sbl, str3);
                }
            }
        }, this.iYF);
    }

    public final void b(c cVar) {
        Exception e;
        Object obj;
        c.a aVar;
        if (this.sbj != null) {
            c cVar2 = this.sbj;
            if (cVar2.sbc) {
                String string;
                boolean z;
                c.a aVar2;
                c cVar3;
                int i = -1;
                int i2 = -1;
                String str = null;
                String str2 = null;
                int i3 = -1;
                try {
                    i = cVar.bxh();
                    i2 = cVar.bxi();
                    cVar.Cp();
                    str = cVar.getData().getString("geta8key_result_full_url");
                    str2 = cVar.getData().getString("geta8key_result_head_img");
                    string = cVar.getData().getString("geta8key_result_wording");
                    try {
                        i3 = cVar.getData().getInt("geta8key_result_action_code", -1);
                    } catch (Exception e2) {
                        e = e2;
                        w.e("MicroMsg.OAuthSession", "onSceneEnd, ex = " + e.getMessage());
                        w.i("MicroMsg.OAuthSession", "onSceneEnd, errType = " + i + ", errCode = " + i2 + " , actionCode=" + i3);
                        if (cVar2.lXp != null) {
                            cVar2.lXp.dismiss();
                        }
                        cVar2.sbb = false;
                        cVar2.hqQ.KH();
                        if (i2 == 0) {
                        }
                        if (i == 4) {
                        }
                        if (i != 1) {
                        }
                        w.e("MicroMsg.OAuthSession", "isNetworkAvailable false, errType = " + i);
                        obj = null;
                        if (obj == null) {
                            aVar = cVar2.sbd;
                            if (i2 == -1) {
                                z = false;
                                aVar2 = aVar;
                                cVar3 = cVar2;
                            } else {
                                z = true;
                                aVar2 = aVar;
                                cVar3 = cVar2;
                            }
                        } else {
                            str = null;
                            z = true;
                            aVar2 = cVar2.sbd;
                            cVar3 = cVar2;
                        }
                        aVar2.a(cVar3, str, z);
                        return;
                    }
                } catch (Exception e3) {
                    Exception exception = e3;
                    string = null;
                    e = exception;
                    w.e("MicroMsg.OAuthSession", "onSceneEnd, ex = " + e.getMessage());
                    w.i("MicroMsg.OAuthSession", "onSceneEnd, errType = " + i + ", errCode = " + i2 + " , actionCode=" + i3);
                    if (cVar2.lXp != null) {
                        cVar2.lXp.dismiss();
                    }
                    cVar2.sbb = false;
                    cVar2.hqQ.KH();
                    if (i2 == 0) {
                    }
                    if (i == 4) {
                    }
                    if (i != 1) {
                    }
                    w.e("MicroMsg.OAuthSession", "isNetworkAvailable false, errType = " + i);
                    obj = null;
                    if (obj == null) {
                        str = null;
                        z = true;
                        aVar2 = cVar2.sbd;
                        cVar3 = cVar2;
                    } else {
                        aVar = cVar2.sbd;
                        if (i2 == -1) {
                            z = true;
                            aVar2 = aVar;
                            cVar3 = cVar2;
                        } else {
                            z = false;
                            aVar2 = aVar;
                            cVar3 = cVar2;
                        }
                    }
                    aVar2.a(cVar3, str, z);
                    return;
                }
                w.i("MicroMsg.OAuthSession", "onSceneEnd, errType = " + i + ", errCode = " + i2 + " , actionCode=" + i3);
                if (cVar2.lXp != null) {
                    cVar2.lXp.dismiss();
                }
                cVar2.sbb = false;
                cVar2.hqQ.KH();
                if ((i2 == 0 || i != 0) && i2 != -2033) {
                    if (i == 4 || i2 != -100) {
                        if (i != 1 || i == 2 || i == 7 || i == 8) {
                            w.e("MicroMsg.OAuthSession", "isNetworkAvailable false, errType = " + i);
                            obj = null;
                        } else if (am.isConnected(cVar2.sbe)) {
                            obj = 1;
                        } else {
                            w.e("MicroMsg.OAuthSession", "isNetworkAvailable false, not connected");
                            obj = null;
                        }
                        if (obj == null) {
                            str = null;
                            z = true;
                            aVar2 = cVar2.sbd;
                            cVar3 = cVar2;
                        } else {
                            aVar = cVar2.sbd;
                            if (i2 == -1) {
                                z = true;
                                aVar2 = aVar;
                                cVar3 = cVar2;
                            } else {
                                z = false;
                                aVar2 = aVar;
                                cVar3 = cVar2;
                            }
                        }
                        aVar2.a(cVar3, str, z);
                        return;
                    }
                    cVar2.sbe.A(true, true);
                    try {
                        cVar2.iYF.Q(i, i2, cVar2.hashCode());
                        return;
                    } catch (Exception e4) {
                        w.w("MicroMsg.OAuthSession", "accountExpired, ex = " + e4.getMessage());
                        return;
                    }
                } else if (i3 == 27) {
                    cVar2.sbc = false;
                    cVar2.sbd.c(i2 == 0, str, str2, string);
                    return;
                } else {
                    cVar2.sbd.a(cVar2, str, false);
                    return;
                }
            }
            w.w("MicroMsg.OAuthSession", "onScenEnd, not listening");
        }
    }
}
