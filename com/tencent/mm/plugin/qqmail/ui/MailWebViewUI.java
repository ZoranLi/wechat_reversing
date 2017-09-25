package com.tencent.mm.plugin.qqmail.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.p.a;
import com.tencent.mm.plugin.qqmail.b.p.c;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.HashMap;
import java.util.Map;

public class MailWebViewUI extends MMActivity {
    private String fvk;
    private ae handler;
    private d lvq = new d(this);
    private long oBg;
    private MMWebView oET;
    private View oEU;
    private a oEV = new a(this) {
        final /* synthetic */ MailWebViewUI oEW;

        {
            this.oEW = r1;
        }

        public final void onSuccess(final String str, Map map) {
            this.oEW.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 oEY;

                public final void run() {
                    MailWebViewUI.a(this.oEY.oEW, str);
                }
            });
        }

        public final void onError(int i, final String str) {
            this.oEW.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 oEY;

                public final void run() {
                    Toast.makeText(this.oEY.oEW, str, 0).show();
                }
            });
        }
    };

    static /* synthetic */ void a(MailWebViewUI mailWebViewUI, String str) {
        if (mailWebViewUI.oET != null && str != null) {
            if (mailWebViewUI.fvk == null) {
                mailWebViewUI.oET.loadData(str, "text/html", ProtocolPackage.ServerEncoding);
                return;
            }
            mailWebViewUI.oET.loadDataWithBaseURL(mailWebViewUI.fvk, str, "text/html", ProtocolPackage.ServerEncoding, null);
        }
    }

    static /* synthetic */ void b(MailWebViewUI mailWebViewUI) {
        String stringExtra = mailWebViewUI.getIntent().getStringExtra("uri");
        String[] stringArrayExtra = mailWebViewUI.getIntent().getStringArrayExtra("params");
        Map hashMap = new HashMap();
        for (int i = 0; i < stringArrayExtra.length; i++) {
            int indexOf = stringArrayExtra[i].indexOf("=");
            hashMap.put(stringArrayExtra[i].substring(0, indexOf), stringArrayExtra[i].substring(indexOf + 1));
        }
        mailWebViewUI.fvk = mailWebViewUI.getIntent().getStringExtra("baseurl");
        String ap = bg.ap(mailWebViewUI.getIntent().getStringExtra("method"), "get");
        if (ap == null || ap.length() == 0 || stringExtra == null || stringExtra.length() == 0) {
            w.e("MicroMsg.QQMail.WebViewUI", "doSend invalid argument.");
            return;
        }
        c cVar = new c();
        cVar.oAs = false;
        cVar.toBundle(new Bundle());
        try {
            if (ap.equals("get")) {
                mailWebViewUI.oBg = ((Long) new ReadMailProxy(mailWebViewUI.lvq, mailWebViewUI.oEV).REMOTE_CALL("get", stringExtra, hashMap, r5)).longValue();
                return;
            }
            mailWebViewUI.oBg = ((Long) new ReadMailProxy(mailWebViewUI.lvq, mailWebViewUI.oEV).REMOTE_CALL("post", stringExtra, hashMap, r5)).longValue();
        } catch (Exception e) {
            w.w("MicroMsg.QQMail.WebViewUI", "get/post, method = %s, ex = %s", new Object[]{ap, e.getMessage()});
        }
    }

    static /* synthetic */ void b(MailWebViewUI mailWebViewUI, String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.QQMail.WebViewUI", "dealGetContentWidthScheme fail, url is null");
            return;
        }
        String substring = str.substring(33);
        final int i = bg.getInt(substring, 480);
        w.d("MicroMsg.QQMail.WebViewUI", "getContentWidth:" + substring);
        mailWebViewUI.oET.post(new Runnable(mailWebViewUI) {
            final /* synthetic */ MailWebViewUI oEW;

            public final void run() {
                View view = (View) this.oEW.oET.getParent();
                if (view != null) {
                    int width = view.getWidth();
                    if (i > width) {
                        int i = 10;
                        float f = ((float) width) / ((float) i);
                        while (f < this.oEW.oET.getScale()) {
                            i--;
                            if (i > 0) {
                                this.oEW.oET.zoomOut();
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        });
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
        return R.i.dlE;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.handler = new ae();
        KC();
        String stringExtra = getIntent().getStringExtra("title");
        if (stringExtra != null) {
            qP(stringExtra);
        }
        this.lvq.G(new Runnable(this) {
            final /* synthetic */ MailWebViewUI oEW;

            {
                this.oEW = r1;
            }

            public final void run() {
                MailWebViewUI.b(this.oEW);
            }
        });
    }

    protected void onStop() {
        this.oET.stopLoading();
        super.onStop();
    }

    protected void onDestroy() {
        this.oET.setVisibility(8);
        this.oET.destroy();
        this.oET = null;
        this.lvq.release();
        super.onDestroy();
    }

    protected final void KC() {
        this.oEU = findViewById(R.h.cSi);
        if (this.oEU != null) {
            this.oEU.setVisibility(8);
        }
        Boolean valueOf = Boolean.valueOf(getIntent().getBooleanExtra("singleColumn", false));
        this.oET = MMWebView.a.fi(this.uSU.uTo);
        this.oET.setBackgroundDrawable(com.tencent.mm.bg.a.a(this, R.e.aVj));
        ((FrameLayout) findViewById(R.h.bGr)).addView(this.oET);
        this.oET.getSettings().setJavaScriptEnabled(true);
        if (valueOf.booleanValue()) {
            MMWebView mMWebView = this.oET;
            if (VERSION.SDK_INT >= 8) {
                mMWebView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
            }
        }
        this.oET.getSettings().setDefaultFontSize(8);
        this.oET.getSettings().setSupportZoom(true);
        this.oET.getSettings().setBuiltInZoomControls(true);
        this.oET.setWebViewClient(new WebViewClient(this) {
            final /* synthetic */ MailWebViewUI oEW;

            {
                this.oEW = r1;
            }

            public final void onScaleChanged(WebView webView, float f, float f2) {
                this.oEW.oET.getSettings().setLayoutAlgorithm(LayoutAlgorithm.NORMAL);
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str.startsWith("weixin://private/getcontentwidth/")) {
                    w.d("MicroMsg.QQMail.WebViewUI", "shouldOverride, url is getContentWidth scheme, url = " + str);
                    MailWebViewUI.b(this.oEW, str);
                } else {
                    webView.loadUrl(str);
                }
                return true;
            }

            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                s.a(webView, "weixin://private/getcontentwidth/", "document.getElementsByTagName('html')[0].scrollWidth;");
            }
        });
        this.oET.setWebChromeClient(new WebChromeClient(this) {
            final /* synthetic */ MailWebViewUI oEW;

            {
                this.oEW = r1;
            }

            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                String Nv = s.Nv(consoleMessage != null ? consoleMessage.message() : null);
                if (!Nv.startsWith("weixin://private/getcontentwidth/")) {
                    return super.onConsoleMessage(consoleMessage);
                }
                w.d("MicroMsg.QQMail.WebViewUI", "onConsoleMessage, url is getContentWidth scheme, url = " + Nv);
                MailWebViewUI.b(this.oEW, Nv);
                return true;
            }
        });
        this.oET.caH();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MailWebViewUI oEW;

            {
                this.oEW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oEW.finish();
                return true;
            }
        });
    }
}
