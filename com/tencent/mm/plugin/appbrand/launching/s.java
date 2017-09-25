package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.i.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;

public final class s implements c {
    public final void a(Context context, String str, String str2, String str3, int i, String str4) {
        if (!bg.mA(str3)) {
            if (bg.mA(str3) || bg.mA(str2)) {
                w.e("MicroMsg.WeAppLauncher", "targetAppId %s referrerAppId %s, Null Or Nil");
                return;
            }
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1055;
            appBrandStatObject.fCN = p.encode(bg.mz(str)) + ":" + str2;
            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
            appBrandLaunchReferrer.appId = str2;
            appBrandLaunchReferrer.iEL = 2;
            appBrandLaunchReferrer.url = str;
            AppBrandLaunchProxyUI.a(context, null, str3, str4, i, -1, appBrandStatObject, appBrandLaunchReferrer, null);
            Assert.assertTrue(true);
        }
    }

    public final void a(Context context, String str, int i, int i2, String str2, AppBrandStatObject appBrandStatObject) {
        AppBrandLaunchProxyUI.a(context, str, null, str2, i, i2, appBrandStatObject, null, null);
    }

    public final void a(Context context, String str, String str2, int i, String str3, String str4) {
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = i;
        appBrandStatObject.fCN = str3;
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.iEL = 4;
        appBrandLaunchReferrer.appId = str4;
        AppBrandLaunchProxyUI.a(context, str, null, str2, 0, 0, appBrandStatObject, appBrandLaunchReferrer, null);
    }
}
