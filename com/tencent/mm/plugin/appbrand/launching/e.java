package com.tencent.mm.plugin.appbrand.launching;

import android.os.HandlerThread;
import com.tencent.mm.R;
import com.tencent.mm.ap.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.m.l;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.util.concurrent.Future;

public class e {
    public static final c<AppBrandSysConfig, AppBrandLaunchErrorAction> iZA = a.u(null, null);
    public final String appId;
    final int fWL;
    final String iEI;
    final AppBrandLaunchReferrer iEK;
    public final int iPk;
    final int iZz;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ HandlerThread iZB;
        final /* synthetic */ e iZC;

        public AnonymousClass1(e eVar, HandlerThread handlerThread) {
            this.iZC = eVar;
            this.iZB = handlerThread;
        }

        public final void run() {
            try {
                c cVar;
                e eVar = this.iZC;
                e eVar2 = this.iZC;
                AppBrandSysConfig ok = p.ok(eVar2.appId);
                if (ok == null) {
                    l.pK(d.e(R.l.dFG, ""));
                }
                if (ok == null) {
                    w.e("MicroMsg.AppBrand.AppLaunchPrepareProcess", "get null config!!!");
                    cVar = e.iZA;
                } else {
                    Object obj;
                    l lVar = new l();
                    String str = ok.appId;
                    String str2 = ok.fCJ;
                    Future Vb = new AnonymousClass2(eVar2, ok.appId, eVar2.iPk, ok.iFk.izW, ok.iFk.iAa).Vb();
                    Future Vb2 = new o().Vb();
                    WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) Vb.get();
                    if (wxaPkgWrappingInfo == null) {
                        w.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig null app pkg, username %s appId %s", new Object[]{ok.fCJ, ok.appId});
                        obj = null;
                    } else {
                        ok.iFk.a(wxaPkgWrappingInfo);
                        if (ok.iFk.izV != 0) {
                            ok.iFk.izW = 0;
                        }
                        w.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, appId %s, app pkg %s", new Object[]{ok.fCJ, ok.appId, ok.iFk});
                        Future Vb3 = new n(str, eVar2.iPk, ok.iFk.izW, eVar2.fWL, eVar2.iZz, eVar2.iEI, eVar2.iEK).Vb();
                        ok.iFl.a((WxaPkgWrappingInfo) Vb2.get());
                        w.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, appId %s, lib pkg %s", new Object[]{ok.fCJ, ok.appId, ok.iFl});
                        h hVar = (h) Vb3.get();
                        if (hVar == null) {
                            w.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, get null launchInfo", new Object[]{ok.fCJ});
                            obj = null;
                        } else {
                            a aVar = AppBrandLaunchErrorAction.CREATOR;
                            AppBrandLaunchErrorAction a = a.a(str, eVar2.iPk, hVar);
                            if (a != null) {
                                lVar.jou = a;
                                obj = null;
                            } else if (hVar.field_jsapiInfo == null || hVar.field_jsapiInfo.tqU == null) {
                                w.e("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, get null jsapi_info", new Object[]{ok.fCJ});
                                obj = null;
                            } else {
                                boolean z = hVar.field_actionsheetInfo != null && hVar.field_actionsheetInfo.teb;
                                ok.iFc = z;
                                ok.iET = new AppRuntimeApiPermissionBundle(hVar.field_jsapiInfo);
                                ok.iFm = AppBrandGlobalSystemConfig.Rz();
                                String[] om = p.om(str2);
                                if (om != null && om.length > 0) {
                                    for (String gO : om) {
                                        b.AY().gO(gO);
                                    }
                                }
                                if (h.vI().isSDCardAvailable()) {
                                    h.vH().gXC.a(new k(12), 0);
                                }
                                w.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig ok username %s, appId %s", new Object[]{ok.fCJ, ok.appId});
                                obj = 1;
                            }
                        }
                    }
                    if (obj == null) {
                        w.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig, false, username %s, appId %s", new Object[]{ok.fCJ, ok.appId});
                        cVar = a.u(null, lVar.jou);
                    } else {
                        w.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "prepare ok, just go weapp, username %s, appId %s", new Object[]{ok.fCJ, ok.appId});
                        cVar = a.u(ok, null);
                    }
                }
                eVar.a(cVar);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AppBrand.AppLaunchPrepareProcess", e, "call() exp ", new Object[0]);
                l.hV(R.l.dEP);
                this.iZC.a(e.iZA);
            }
            this.iZB.quit();
        }
    }

    class AnonymousClass2 extends m {
        final /* synthetic */ e iZC;

        AnonymousClass2(e eVar, String str, int i, int i2, String str2) {
            this.iZC = eVar;
            super(str, i, i2, str2);
        }

        final void UV() {
            this.iZC.UV();
        }

        final void UW() {
            e.UW();
        }
    }

    public e(String str, int i, int i2, int i3, String str2, AppBrandLaunchReferrer appBrandLaunchReferrer) {
        this.appId = str;
        this.iPk = i;
        this.fWL = i2;
        this.iZz = i3;
        this.iEI = str2;
        this.iEK = appBrandLaunchReferrer;
    }

    public void UV() {
    }

    public static void UW() {
    }

    public void a(AppBrandSysConfig appBrandSysConfig, AppBrandLaunchErrorAction appBrandLaunchErrorAction) {
    }

    public final void a(c<AppBrandSysConfig, AppBrandLaunchErrorAction> cVar) {
        boolean z;
        a((AppBrandSysConfig) cVar.get(0), (AppBrandLaunchErrorAction) cVar.get(1));
        AppBrandSysConfig appBrandSysConfig = (AppBrandSysConfig) cVar.get(0);
        String str = this.appId;
        int i = this.iPk;
        int i2 = this.iZz;
        if (appBrandSysConfig != null) {
            z = true;
        } else {
            z = false;
        }
        LaunchBroadCast.a(str, i, i2, z);
    }
}
