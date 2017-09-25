package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.Map;

public final class a implements com.tencent.mm.sdk.e.j.a {
    private static a iZd;
    final Map<String, AppBrandInitConfig> iZe = new android.support.v4.e.a();
    final Map<String, String> iZf = new android.support.v4.e.a();

    private a() {
    }

    public static void init() {
        synchronized (a.class) {
            iZd = new a();
            p.RG().c(iZd);
        }
    }

    public static void release() {
        synchronized (a.class) {
            iZd = null;
        }
    }

    public static a UR() {
        a aVar;
        synchronized (a.class) {
            aVar = iZd;
        }
        return aVar;
    }

    public final void a(String str, l lVar) {
        if ("single".equals(str)) {
            if (String.class.isInstance(lVar.obj)) {
                String valueOf = String.valueOf(lVar.obj);
                if (!bg.mA(valueOf)) {
                    pI(valueOf);
                }
            }
        } else if ("batch".equals(str)) {
            synchronized (this.iZe) {
                this.iZe.clear();
            }
        }
    }

    final String pH(String str) {
        if (bg.mA(str)) {
            return null;
        }
        String str2;
        synchronized (this.iZf) {
            str2 = (String) this.iZf.get(str);
        }
        return str2;
    }

    private AppBrandInitConfig pI(String str) {
        if (bg.mA(str)) {
            return null;
        }
        synchronized (this.iZf) {
            String str2 = (String) this.iZf.get(str);
        }
        if (!bg.mA(str2)) {
            return pJ(str2);
        }
        AppBrandInitConfig b = b(c.PR().d(str, "appId", "appInfo", "brandIconURL", "nickname"));
        if (b == null) {
            return b;
        }
        synchronized (this.iZf) {
            this.iZf.put(str, b.appId);
        }
        return b;
    }

    private static AppBrandInitConfig b(WxaAttributes wxaAttributes) {
        if (wxaAttributes == null) {
            return null;
        }
        AppBrandInitConfig appBrandInitConfig = new AppBrandInitConfig();
        appBrandInitConfig.appId = wxaAttributes.field_appId;
        appBrandInitConfig.fGs = wxaAttributes.field_nickname;
        appBrandInitConfig.iconUrl = wxaAttributes.field_brandIconURL;
        appBrandInitConfig.iEH = wxaAttributes.RH().iFP != 0;
        return appBrandInitConfig;
    }

    final AppBrandInitConfig pJ(String str) {
        if (bg.mA(str)) {
            return null;
        }
        synchronized (this.iZe) {
            AppBrandInitConfig appBrandInitConfig = (AppBrandInitConfig) this.iZe.remove(str);
        }
        if (appBrandInitConfig != null) {
            return appBrandInitConfig;
        }
        return b(c.PR().e(str, "appInfo", "brandIconURL", "nickname"));
    }
}
