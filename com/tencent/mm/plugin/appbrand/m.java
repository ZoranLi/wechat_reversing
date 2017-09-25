package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.plugin.appbrand.jsapi.AppBrandJSInterface;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ae;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class m extends c {
    public boolean aaI = true;
    public String ivH;
    public final h ixr;
    AppBrandJSInterface ixs;
    public d ixt;
    private LinkedList<a> ixu = new LinkedList();
    public Context mContext;

    private static class a {
        String data;
        String fDz;
        int src;

        a(String str, String str2, int i) {
            this.fDz = str;
            this.data = str2;
            this.src = i;
        }
    }

    public m(Context context, h hVar) {
        this.mContext = context;
        this.ixr = hVar;
        this.ivH = hVar.ivH;
        this.ixs = new AppBrandJSInterface(this);
        boolean z = ae.gH(ab.getContext()) && this.ixr.iwo.iFb && (QbSdk.getTbsVersion(this.mContext) >= 43114);
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        boolean contains = sharedPreferences.contains("switch_x5_jscore");
        boolean z2 = sharedPreferences.getBoolean("switch_x5_jscore", true);
        sharedPreferences.edit().putBoolean("x5_jscore_enabled", z).commit();
        if (contains) {
            z = z2;
        }
        if (z) {
            this.ixt = new AppBrandX5BasedJsEngine(ab.getContext(), this.ixs, "WeixinJSCore");
            g.oUh.a(434, 2, 1, false);
            w.i("MicroMsg.AppBrandService", "Using X5 Javascript Engine");
        } else {
            this.ixt = new o(ab.getContext(), this.ixs, "WeixinJSCore");
            g.oUh.a(434, 1, 1, false);
            w.i("MicroMsg.AppBrandService", "Using WebView Based Javascript Engine");
        }
        g.oUh.a(434, 0, 1, false);
    }

    final synchronized void PH() {
        Iterator it = this.ixu.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            super.f(aVar.fDz, aVar.data, aVar.src);
        }
        this.ixu = null;
    }

    public final void f(String str, String str2, int i) {
        synchronized (this) {
            if (this.ixu != null) {
                this.ixu.add(new a(str, str2, i));
                return;
            }
            super.f(str, str2, i);
        }
    }

    public final void a(String str, String str2, int[] iArr) {
        this.ixr.iwr.c(str, str2, iArr);
    }

    public final boolean isRunning() {
        return this.aaI;
    }

    public final String getAppId() {
        return this.ivH;
    }

    public final h PI() {
        return this.ixr;
    }

    public final d PJ() {
        return this.ixt;
    }

    static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            w.e("MicroMsg.AppBrandService", e.getMessage());
        }
    }
}
