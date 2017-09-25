package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class c {
    g iKE = new g();

    public abstract h PI();

    public abstract d PJ();

    public abstract void a(String str, String str2, int[] iArr);

    public abstract boolean isRunning();

    public void f(String str, String str2, int i) {
        if (bg.mA(str2)) {
            str2 = "{}";
        }
        w.d("MicroMsg.AppBrandComponent", "dispatch, event: %s, data size: %s, srcId: %d", new Object[]{str, Integer.valueOf(str2.length()), Integer.valueOf(i)});
        d PJ = PJ();
        String str3 = "typeof WeixinJSCoreAndroid !== 'undefined' && WeixinJSCoreAndroid.subscribeHandler(\"%s\", %s, %s, %s)";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = i == 0 ? "undefined" : String.valueOf(i);
        Map hashMap = new HashMap();
        hashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
        objArr[3] = new JSONObject(hashMap).toString();
        PJ.evaluateJavascript(String.format(str3, objArr), null);
    }

    public final void x(int i, String str) {
        if (bg.mA(str)) {
            str = "{}";
        }
        w.d("MicroMsg.AppBrandComponent", "callbackId: %d, data size: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(str.length())});
        PJ().evaluateJavascript(String.format("typeof WeixinJSCoreAndroid !== 'undefined' && WeixinJSCoreAndroid.invokeCallbackHandler(%d, %s)", new Object[]{Integer.valueOf(i), str}), null);
        this.iKE.y(i, str);
    }

    public String getAppId() {
        return PI().ivH;
    }
}
