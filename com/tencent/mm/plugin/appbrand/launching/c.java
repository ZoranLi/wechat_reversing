package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.launching.q.AnonymousClass1;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.b;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class c implements Runnable {
    private final String appId;
    private final int iPk;
    private final a iZs;
    private AppBrandStatObject iZt;
    private final int izW;
    private final String username;

    public interface a {
        void b(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject);
    }

    public c(LaunchParcel launchParcel, a aVar) {
        this.iZs = aVar;
        this.iPk = launchParcel.iPk;
        this.appId = launchParcel.appId;
        this.username = launchParcel.username;
        this.izW = launchParcel.version;
        this.iZt = launchParcel.iZq;
    }

    public c(String str, int i, AppBrandStatObject appBrandStatObject, a aVar) {
        this.iZs = aVar;
        this.appId = str;
        this.iPk = i;
        this.username = null;
        this.izW = 0;
        this.iZt = appBrandStatObject;
    }

    public final void run() {
        boolean z = true;
        AppBrandSysConfig appBrandSysConfig = null;
        try {
            appBrandSysConfig = new p(this.username, this.appId, this.iPk, this.izW).Vd();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcess", e, "get attr ", new Object[0]);
        }
        if (appBrandSysConfig == null) {
            w.i("MicroMsg.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
            onError();
            return;
        }
        boolean z2;
        i iVar = new i(appBrandSysConfig.appId);
        if (g.sV().getInt("WeAppForbiddenSwitch", 0) == 1) {
            w.i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", new Object[]{iVar.appId});
            Intent putExtra = new Intent().putExtra("rawUrl", n.nv(iVar.appId)).putExtra("forceHideShare", true);
            Context context = ab.getContext();
            if (!(context instanceof Activity)) {
                putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            d.b(context, "webview", ".ui.tools.WebViewUI", putExtra);
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            z2 = true;
        } else {
            if (2 == this.iPk) {
                String str = appBrandSysConfig.appId;
                boolean qM = b.qM(appBrandSysConfig.appId);
                int Ve = new r(str, q.ah(str, 2), q.ah(str, CdnLogic.MediaType_FAVORITE_FILE), qM).Ve();
                w.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", new Object[]{str, Integer.valueOf(Ve), Boolean.valueOf(qM)});
                com.tencent.mm.plugin.appbrand.launching.r.a hW = com.tencent.mm.plugin.appbrand.launching.r.a.hW(Ve);
                if (hW != null) {
                    if (!qM) {
                        switch (AnonymousClass1.iZM[hW.ordinal()]) {
                            case 1:
                                z2 = true;
                                break;
                            case 2:
                                l.hV(R.l.dDR);
                                com.tencent.mm.plugin.appbrand.report.a.w(str, 13, 3);
                                z2 = false;
                                break;
                            default:
                                l.hV(R.l.dDQ);
                                com.tencent.mm.plugin.appbrand.report.a.w(str, 13, 3);
                                z2 = false;
                                break;
                        }
                    }
                    z2 = true;
                } else {
                    switch (Ve) {
                        case -13003:
                            l.hV(R.l.dDT);
                            com.tencent.mm.plugin.appbrand.report.a.w(str, 12, 3);
                            z2 = false;
                            break;
                        case -13002:
                            l.hV(R.l.dDS);
                            com.tencent.mm.plugin.appbrand.report.a.w(str, 13, 3);
                            z2 = false;
                            break;
                        default:
                            if (!qM) {
                                l.pK(ab.getResources().getString(R.l.dFH, new Object[]{Integer.valueOf(3), Integer.valueOf(Ve)}));
                                z2 = false;
                                break;
                            }
                            z2 = true;
                            break;
                    }
                }
                if (!z2) {
                    z2 = true;
                }
            }
            if (this.iPk == 0) {
                int i;
                if (1 == appBrandSysConfig.iFo) {
                    AppBrand404PageUI.show(R.l.dER);
                    com.tencent.mm.plugin.appbrand.report.a.w(appBrandSysConfig.appId, 14, 1);
                    i = 0;
                } else {
                    z2 = true;
                }
                if (i == 0) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        if (z2) {
            onError();
            return;
        }
        AppBrandInitConfig appBrandInitConfig = new AppBrandInitConfig();
        appBrandInitConfig.appId = appBrandSysConfig.appId;
        appBrandInitConfig.fGs = appBrandSysConfig.fGs;
        appBrandInitConfig.izM = this.iPk;
        appBrandInitConfig.iconUrl = appBrandSysConfig.iEP;
        if (com.tencent.mm.plugin.appbrand.app.c.PR().e(appBrandSysConfig.appId, "appInfo").RH().iFP == 0) {
            z = false;
        }
        appBrandInitConfig.iEH = z;
        if (this.iZt == null) {
            this.iZt = new AppBrandStatObject();
        }
        AppBrandStatObject appBrandStatObject = this.iZt;
        if (this.iZs != null) {
            this.iZs.b(appBrandInitConfig, appBrandStatObject);
        }
    }

    private void onError() {
        if (this.iZs != null) {
            this.iZs.b(null, null);
        }
    }
}
