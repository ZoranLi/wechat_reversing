package com.tencent.mm.plugin.appbrand.dynamic.core;

import android.webkit.JavascriptInterface;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class MiniJsBridge {
    public volatile boolean aaI;
    public String iDc;
    public f iHF;
    private volatile boolean iHG;
    public a iHH;
    public d ixt;

    public interface a {
        void ab(String str, int i);
    }

    @JavascriptInterface
    public void publishHandler(String str, String str2, String str3) {
        int i = 0;
        String str4 = "MicroMsg.MiniJsBridge";
        String str5 = "publishHandler, event: %s, data size: %d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (str2 != null) {
            i = str2.length();
        }
        objArr[1] = Integer.valueOf(i);
        w.d(str4, str5, objArr);
    }

    @JavascriptInterface
    public String invokeHandler(String str, String str2, int i) {
        if (this.aaI) {
            return this.iHF.j(str, str2, i);
        }
        return f.aO(str, "fail:JsApi core not started");
    }

    public final void w(int i, String str) {
        if (bg.mA(str)) {
            str = "{}";
        }
        this.ixt.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[]{Integer.valueOf(i), str}), null);
    }

    public final boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        String jSONObject = cVar.nQ().toString();
        w.d("MicroMsg.MiniJsBridge", "dispatch, event: %s, data size: %s, srcId: %d, id : %s", new Object[]{cVar.name, Integer.valueOf(jSONObject.length()), Integer.valueOf(0), this.iDc});
        this.ixt.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[]{cVar.name, jSONObject, "undefined", Sd()}), null);
        return true;
    }

    public final void b(c cVar) {
        if (!this.iHG) {
            w.v("MicroMsg.MiniJsBridge", "onPause(%s)", new Object[]{this.iDc});
            this.iHG = true;
            if (this.ixt.Pp()) {
                this.ixt.pause();
            } else {
                a(cVar);
            }
            if (this.iHH != null) {
                this.iHH.ab(this.iDc, 3);
            }
        }
    }

    public final void c(c cVar) {
        if (this.iHG) {
            w.v("MicroMsg.MiniJsBridge", "onResume(%s)", new Object[]{this.iDc});
            if (this.ixt.Pp()) {
                this.ixt.resume();
            } else {
                a(cVar);
            }
            this.iHG = false;
            if (this.iHH != null) {
                this.iHH.ab(this.iDc, 2);
            }
        }
    }

    public final void onStart() {
        if (!this.aaI) {
            w.v("MicroMsg.MiniJsBridge", "onStart(%s)", new Object[]{this.iDc});
            this.aaI = true;
            if (this.iHH != null) {
                this.iHH.ab(this.iDc, 1);
            }
        }
    }

    public static String Sd() {
        Map hashMap = new HashMap();
        hashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
        return new JSONObject(hashMap).toString();
    }
}
