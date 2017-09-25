package com.tencent.mm.plugin.appbrand.launching;

import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.a.pr.a;
import com.tencent.mm.plugin.appbrand.appcache.m;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.Locale;

public final class b extends c<pr> {
    public b() {
        this.usg = pr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        pr prVar = (pr) bVar;
        if (bg.mA(prVar.fWB.userName)) {
            prVar.fWC.fWN = false;
            prVar.fWC.fWO = "invalid username or appId";
            return true;
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = prVar.fWB.scene;
        appBrandStatObject.fCN = prVar.fWB.fCN;
        appBrandStatObject.fWL = com.tencent.mm.plugin.appbrand.report.b.e(appBrandStatObject.scene, prVar.fWB.fFu);
        appBrandStatObject.fWM = com.tencent.mm.plugin.appbrand.report.b.f(appBrandStatObject.scene, prVar.fWB.fFu);
        if (prVar.fWB.scene == 1037 || prVar.fWB.scene == 1018) {
            appBrandStatObject.fWK = prVar.fWB.fWK;
        } else {
            appBrandStatObject.fWK = prVar.fWB.scene;
        }
        switch (prVar.fWB.fWE) {
            case 0:
            case 2:
                AppBrandLaunchProxyUI.a(prVar.fWB.context, prVar.fWB.userName, prVar.fWB.appId, prVar.fWB.fWD, prVar.fWB.fWE, prVar.fWB.fWF <= 0 ? -1 : prVar.fWB.fWF, appBrandStatObject, null, prVar.fWB.fWJ);
                break;
            case 1:
                m PY;
                String str;
                int i;
                Cursor a;
                if (!prVar.fWB.fWH) {
                    if (!bg.mA(prVar.fWB.appId)) {
                        if (!bg.mA(prVar.fWB.fKS) && !bg.mA(prVar.fWB.fWG)) {
                            if (com.tencent.mm.plugin.appbrand.app.c.PY().a(prVar.fWB.appId, prVar.fWB.fWE, prVar.fWB.fKS, prVar.fWB.fWG, 0, 0)) {
                                com.tencent.mm.plugin.appbrand.task.b.an(prVar.fWB.appId, prVar.fWB.fWE);
                            } else {
                                boolean z;
                                PY = com.tencent.mm.plugin.appbrand.app.c.PY();
                                str = prVar.fWB.appId;
                                i = prVar.fWB.fWE;
                                if (bg.mA(str) || i < 0) {
                                    z = false;
                                } else {
                                    a = PY.izH.a("AppBrandWxaPkgManifestRecord", new String[]{"version"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, null, 2);
                                    if (a == null) {
                                        z = false;
                                    } else {
                                        z = a.moveToFirst();
                                        a.close();
                                    }
                                }
                                if (!z) {
                                    prVar.fWC.fWN = false;
                                    prVar.fWC.fWO = "install app failed";
                                    return true;
                                }
                            }
                            appBrandStatObject.fCN = prVar.fWB.fKS;
                            AppBrandLaunchProxyUI.a(prVar.fWB.context, prVar.fWB.userName, prVar.fWB.fWD, prVar.fWB.fWE, -1, appBrandStatObject, prVar.fWB.fWJ);
                            break;
                        }
                        prVar.fWC.fWN = false;
                        prVar.fWC.fWO = "invalid downloadURL or checkSumMd5";
                        return true;
                    }
                    prVar.fWC.fWN = false;
                    prVar.fWC.fWO = "invalid username or appId";
                    return true;
                }
                String str2;
                a aVar = prVar.fWB;
                str = p.on(prVar.fWB.userName);
                aVar.appId = str;
                if (!bg.mA(str)) {
                    PY = com.tencent.mm.plugin.appbrand.app.c.PY();
                    str = prVar.fWB.appId;
                    i = prVar.fWB.fWE;
                    a = PY.izH.query("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, null);
                    if (a == null) {
                        str2 = null;
                    } else {
                        str2 = a.moveToFirst() ? a.getString(0) : null;
                        a.close();
                    }
                    if (!bg.mA(str2) && e.aO(str2)) {
                        prVar.fWC.fWN = true;
                        AppBrandLaunchProxyUI.a(prVar.fWB.context, prVar.fWB.userName, prVar.fWB.fWD, prVar.fWB.fWE, 0, appBrandStatObject, prVar.fWB.fWJ);
                        return true;
                    }
                }
                prVar.fWC.fWN = false;
                prVar.fWC.fWO = "local pkg not exists";
                if (prVar.fWB.fWI) {
                    str2 = null;
                    if (prVar.fWB.fWE == 1) {
                        str2 = d.e(R.l.dDM, new Object[0]);
                    } else if (prVar.fWB.fWE == 2) {
                        str2 = d.e(R.l.dEW, new Object[0]);
                    }
                    com.tencent.mm.plugin.appbrand.ipc.a.a(prVar.fWB.context, str2, d.e(R.l.dIO, new Object[0]), d.e(R.l.dHT, new Object[0]), "");
                }
                return true;
                break;
            default:
                prVar.fWC.fWN = false;
                prVar.fWC.fWO = "invalid openType";
                return true;
        }
        prVar.fWC.fWN = true;
        return true;
    }
}
