package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.y;

public final class f {
    public static String skr = "window.addEventListener('load', requestInjectJS, false); function requestInjectJS() { console.log('weixin://preInjectJSBridge/start');}";
    private d rVm;
    public WebView saV;
    private boolean sjU = false;
    private String sjV = "";
    a skm;
    private boolean skn = false;
    public boolean sko = true;
    public boolean skp = false;
    private final aj skq = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ f sks;

        {
            this.sks = r1;
        }

        public final boolean oQ() {
            f fVar = this.sks;
            boolean bzw = fVar.bzw();
            w.i("MicroMsg.JsLoader", "onTimerExpired, js loaded ret = %b", new Object[]{Boolean.valueOf(bzw)});
            if (bzw && fVar.skm != null) {
                fVar.skm.byG();
            }
            g.oUh.a(156, 1, 1, false);
            if (!bzw) {
                g.oUh.a(156, 0, 1, false);
            }
            return false;
        }
    }, true);

    public interface a {
        void byG();
    }

    public f(WebView webView, d dVar, a aVar, boolean z) {
        this.saV = webView;
        this.rVm = dVar;
        this.skm = aVar;
        this.skn = z;
        w.d("MicroMsg.JsLoader", "JsLoader <init>, withoutDelay = %b", new Object[]{Boolean.valueOf(z)});
    }

    public final void bzt() {
        this.sjU = true;
        this.sjV = bg.bKb();
        w.i("MicroMsg.JsLoader", "js digest verification randomStr = ", new Object[]{this.sjV});
        if (this.rVm != null) {
            d dVar = this.rVm;
            String str = this.sjV;
            dVar.sjU = true;
            dVar.sjV = str;
        }
    }

    public final void detach() {
        w.v("MicroMsg.JsLoader", "detach");
        this.saV = null;
        this.rVm = null;
        this.skm = null;
    }

    public final void bzu() {
        w.v("MicroMsg.JsLoader", "onPageStarted");
        if (!this.skq.bJq()) {
            this.skq.KH();
            w.i("MicroMsg.JsLoader", "tryStopTimer success");
        }
    }

    public final void bzv() {
        w.v("MicroMsg.JsLoader", "onPageFinished");
        if (this.skq.bJq()) {
            aj ajVar = this.skq;
            long j = this.skn ? 0 : 1000;
            ajVar.v(j, j);
            w.i("MicroMsg.JsLoader", "tryStartTimer success");
        }
    }

    final boolean bzw() {
        String convertStreamToString;
        try {
            convertStreamToString = bg.convertStreamToString(this.saV.getContext().getAssets().open("jsapi/wxjs.js"));
            if (this.sjU) {
                convertStreamToString = convertStreamToString.replace("isUseMd5_check", "yes").replace("xx_yy", this.sjV);
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.JsLoader", e, "", new Object[0]);
            convertStreamToString = null;
        }
        if (convertStreamToString == null) {
            w.e("MicroMsg.JsLoader", "loadJavaScript fail, jsContent is null");
            return false;
        } else if (this.saV == null) {
            w.e("MicroMsg.JsLoader", "loadJavaScript, viewWV is null");
            return false;
        } else {
            this.saV.evaluateJavascript("javascript:" + convertStreamToString, new y<String>(this) {
                final /* synthetic */ f sks;

                {
                    this.sks = r1;
                }

                public final /* synthetic */ void onReceiveValue(Object obj) {
                    w.i("MicroMsg.JsLoader", "loadJavaScript, evaluateJavascript cb, ret = %s", new Object[]{(String) obj});
                }
            });
            if (this.rVm == null) {
                w.e("MicroMsg.JsLoader", "loadJavaScript, jspai is null");
                return false;
            }
            if (!this.sko) {
                this.saV.evaluateJavascript("javascript:WeixinJSBridge._isBridgeByIframe = false", null);
            }
            d dVar = this.rVm;
            w.v("MicroMsg.JsApiHandler", "jsapi init, preInit = %b", new Object[]{Boolean.valueOf(false)});
            dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("sys:init", dVar.sjQ, dVar.sjU, dVar.sjV) + ")", null);
            dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("sys:bridged", null, dVar.sjU, dVar.sjV) + ")", null);
            dVar.sjS = true;
            dVar.bzk();
            if (!(bg.mA(dVar.sjX) || dVar.sjM == null)) {
                dVar.sjM.evaluateJavascript(dVar.cm(dVar.sjX, dVar.sjY), null);
                dVar.sjX = null;
                dVar.sjY = 0;
            }
            w.i("MicroMsg.JsLoader", "jsapi init done");
            return true;
        }
    }
}
