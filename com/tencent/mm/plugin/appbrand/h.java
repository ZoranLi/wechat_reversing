package com.tencent.mm.plugin.appbrand;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.ActivityManager.TaskDescription;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.appcache.l;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.g.j;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.media.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.a.f;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.ui.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h {
    public boolean gZN;
    public String ivH;
    private c iwA;
    public j iwB;
    public b iwC;
    boolean iwD;
    boolean iwE;
    public boolean iwF;
    public boolean iwG;
    private int iwH;
    public boolean iwI;
    public boolean iwJ;
    public boolean iwK;
    public f iwL;
    private AppBrandRemoteTaskController.b iwM = new AppBrandRemoteTaskController.b(this) {
        final /* synthetic */ h iwP;

        {
            this.iwP = r1;
        }

        public final void finish() {
            this.iwP.Po();
        }
    };
    private a iwN = new a(this) {
        final /* synthetic */ h iwP;
        private boolean iwQ = false;

        {
            this.iwP = r2;
        }

        public final void onServiceConnected() {
            if (this.iwQ) {
                h hVar = this.iwP;
                w.i("MicroMsg.AppBrandRuntime", "onReconnected: %s", new Object[]{hVar.ivH});
                hVar.iwx.am(hVar.ivH, hVar.iwn.izM);
                MMToClientEvent.oZ(hVar.ivH);
                e.nh(hVar.ivH);
                if (!hVar.gZN) {
                    w.e("MicroMsg.AppBrandRuntime", "Main Process Restarted, start prepare again");
                    hVar.Px();
                }
            }
            this.iwQ = false;
        }

        public final void PC() {
            this.iwQ = true;
            long j = this.iwP.iwx.jhA;
            SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "pref_appbrand_process", 4);
            Editor edit = sharedPreferences.edit();
            if (sharedPreferences.getLong("on_wxa_process_connected_time", 0) == j) {
                edit.remove("on_wxa_process_connected_time");
                edit.commit();
                com.tencent.mm.plugin.report.c.oTb.a(365, 1, 1, false);
                w.v("MicroMsg.AppBrandReporter", "delete timestamp(%s) and report(%d)", new Object[]{Long.valueOf(j), Integer.valueOf(365)});
                return;
            }
            w.v("MicroMsg.AppBrandReporter", "do not need to report(%d), timestamp(cur : %s, sp : %s)", new Object[]{Long.valueOf(j), Integer.valueOf(365), Long.valueOf(j), Long.valueOf(sharedPreferences.getLong("on_wxa_process_connected_time", 0))});
        }
    };
    Runnable iwO = new Runnable(this) {
        final /* synthetic */ h iwP;

        {
            this.iwP = r1;
        }

        public final void run() {
            g.oUh.a(369, 11, 1, false);
        }
    };
    public MMActivity iwk;
    public i iwl;
    h iwm;
    public AppBrandInitConfig iwn;
    public AppBrandSysConfig iwo;
    public com.tencent.mm.plugin.appbrand.config.a iwp;
    public m iwq;
    public j iwr;
    public FrameLayout iws;
    public com.tencent.mm.plugin.appbrand.ui.h iwt;
    e iwu;
    public com.tencent.mm.plugin.appbrand.widget.b.b iwv;
    public AppBrandStatObject iww;
    public AppBrandRemoteTaskController iwx;
    private com.tencent.mm.plugin.appbrand.g.e iwy;
    private d iwz;
    public boolean mFinished;
    Handler mHandler;

    class AnonymousClass11 implements Runnable {
        final /* synthetic */ h iwP;
        final /* synthetic */ JSONObject iwV;

        public AnonymousClass11(h hVar, JSONObject jSONObject) {
            this.iwP = hVar;
            this.iwV = jSONObject;
        }

        public final void run() {
            this.iwP.c(this.iwV);
        }
    }

    public h(MMActivity mMActivity, i iVar) {
        this.iwk = mMActivity;
        this.iwl = iVar;
        this.mHandler = new Handler();
        this.iws = new FrameLayout(mMActivity);
        this.iws.setLayoutParams(new LayoutParams(-1, -1));
        this.iwx = new AppBrandRemoteTaskController();
        AppBrandRemoteTaskController appBrandRemoteTaskController = this.iwx;
        AppBrandRemoteTaskController.c cVar = iVar.iwY;
        AppBrandRemoteTaskController.b bVar = this.iwM;
        appBrandRemoteTaskController.jhx = mMActivity.getClass().getName();
        appBrandRemoteTaskController.iwY = cVar;
        appBrandRemoteTaskController.iwM = bVar;
        this.iwy = new com.tencent.mm.plugin.appbrand.g.e();
        this.iwz = new d();
        this.iwA = new c();
        this.iwB = new j();
    }

    final void a(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        if (appBrandInitConfig == null || appBrandStatObject == null) {
            w.i("MicroMsg.AppBrandRuntime", "null current config, ignored");
            return;
        }
        this.iwn = appBrandInitConfig;
        this.iww = appBrandStatObject;
        this.ivH = appBrandInitConfig.appId;
        this.iwC = new b(this);
        b bVar = this.iwC;
        com.tencent.mm.ipcinvoker.f.dT("com.tencent.mm");
        ab.getContext().registerComponentCallbacks(bVar.iAm);
        bVar.iAk.start();
        this.iwC.a(new b.a(this) {
            final /* synthetic */ h iwP;

            {
                this.iwP = r1;
            }

            public final void a(com.tencent.mm.plugin.appbrand.a.a aVar) {
                Object obj;
                h hVar = this.iwP;
                Map hashMap = new HashMap();
                switch (com.tencent.mm.plugin.appbrand.g.f.AnonymousClass1.ivJ[aVar.ordinal()]) {
                    case 1:
                        obj = "background";
                        break;
                    case 2:
                        obj = "active";
                        break;
                    case 3:
                        obj = "suspend";
                        break;
                    default:
                        return;
                }
                hashMap.put(DownloadInfo.STATUS, obj);
                new com.tencent.mm.plugin.appbrand.g.f().q(hashMap).a(hVar.iwq).SR();
            }
        });
        w.i("MicroMsg.AppBrandRuntime", "init %s, scene %d", new Object[]{this.ivH, Integer.valueOf(Pu())});
        this.gZN = false;
        this.mFinished = false;
        this.iwD = false;
        this.iwE = false;
        this.iwI = false;
        this.iwJ = false;
        this.iwK = false;
        this.iwF = false;
        this.iwG = false;
        this.iwH = 0;
        com.tencent.mm.pluginsdk.model.w.o(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY, this.iwn.appId);
        com.tencent.mm.pluginsdk.model.w.o(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY, this.iwn.fGs);
        com.tencent.mm.pluginsdk.model.w.o(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER, Boolean.valueOf(false));
        b.a(this.ivH, this);
        l.np(this.ivH);
        this.iwB.k(0, System.currentTimeMillis() - appBrandInitConfig.startTime);
        g.oUh.a(369, 1, 1, false);
        com.tencent.mm.plugin.appbrand.performance.a.a(this.ivH, "ActivityCreate", this.iwn.startTime, System.currentTimeMillis());
    }

    final void Pr() {
        final long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.plugin.appbrand.task.a.a(new com.tencent.mm.plugin.appbrand.task.a.a(this) {
            final /* synthetic */ h iwP;

            public final void onReady() {
                this.iwP.iwJ = true;
                this.iwP.iwB.k(2, System.currentTimeMillis() - currentTimeMillis);
                com.tencent.mm.plugin.appbrand.performance.a.a(this.iwP.ivH, "X5Prepare", currentTimeMillis, System.currentTimeMillis());
                this.iwP.Py();
            }
        });
        Px();
        if (this.iwt != null) {
            Pt();
        }
        String str = this.iwn.iconUrl;
        String str2 = this.iwn.fGs;
        Context context = this.iwk;
        com.tencent.mm.plugin.appbrand.ui.h cVar = Pw() ? new com.tencent.mm.plugin.appbrand.ui.c(context, this) : new com.tencent.mm.plugin.appbrand.ui.d(context, this);
        cVar.bh(str, str2);
        if ((Pu() == 1023 ? 1 : 0) != 0) {
            cVar.WU();
        }
        this.iws.addView(cVar.getView(), -1, -1);
        this.iwt = cVar;
        w.i("MicroMsg.AppBrandRuntime", "appOnCreate: %s, %s", new Object[]{this.iwn.fGs, this.iwn.appId});
        AppBrandMainProcessService.a(this.iwN);
        MainProcessTask mainProcessTask = this.iwx;
        str = this.ivH;
        mainProcessTask.jhy = a.jhM;
        mainProcessTask.ivH = str;
        AppBrandMainProcessService.a(mainProcessTask);
        this.iwx.am(this.ivH, this.iwn.izM);
        this.iwC.iAk.hx(3);
        MMToClientEvent.oZ(this.ivH);
        e.nj(this.ivH);
        e.nd(this.ivH);
        e.a(this.ivH, e.a.ON_CREATE);
        i.pe(this.ivH);
        AppBrandStickyBannerLogic.a.ch(this.iwn.iEJ);
        c cVar2 = this.iwA;
        cVar2.appId = this.ivH;
        w.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "init");
        au.a(cVar2.jnJ);
        Py();
        this.mHandler.postDelayed(this.iwO, 10000);
    }

    final void a(AppBrandStatObject appBrandStatObject, String str) {
        AppBrandIDKeyBatchReport.Wl().jfI = 1;
        AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.Wl());
        if (appBrandStatObject == null) {
            w.e("MicroMsg.AppBrandRuntime", "statObject is null!");
            return;
        }
        if (str != null) {
            appBrandStatObject.jfX = str;
        }
        appBrandStatObject.appId = this.iwn.appId;
        b.a(appBrandStatObject);
        if (this.iwr != null) {
            this.iwr.jct.VQ();
        }
        this.iww = appBrandStatObject;
        w.i("MicroMsg.AppBrandRuntime", "updateStat %s, scene %d", new Object[]{this.ivH, Integer.valueOf(Pu())});
    }

    public final h Ps() {
        i iVar = this.iwl;
        int indexOf = iVar.iwW.indexOf(this);
        return (indexOf == -1 || indexOf >= iVar.iwW.size() - 1) ? null : (h) iVar.iwW.get(indexOf + 1);
    }

    public final void a(com.tencent.mm.plugin.appbrand.widget.b.a aVar) {
        if (!this.mFinished && this.iwv != null) {
            ViewParent viewParent = this.iwv;
            com.tencent.mm.plugin.appbrand.widget.b.c cVar = viewParent.jsa;
            int i = (cVar.jsj == null || !cVar.jsj.isRunning()) ? 0 : 1;
            if (i != 0) {
                cVar = viewParent.jsa;
                if (cVar.jsj != null) {
                    cVar.jsj.cancel();
                }
            }
            View contentView = aVar.getContentView();
            if (contentView.getParent() != viewParent) {
                com.tencent.mm.plugin.appbrand.widget.b.b.bK(contentView);
                viewParent.addView(contentView, new FrameLayout.LayoutParams(-2, -2, 17));
                if (viewParent.jse != aVar) {
                    contentView.clearAnimation();
                    contentView.startAnimation(AnimationUtils.loadAnimation(viewParent.getContext(), R.a.aQM));
                }
                viewParent.jse = aVar;
            }
            contentView.setOnClickListener(viewParent.mOnClickListener);
            viewParent.jsb.add(aVar);
            if (aVar.jrV != null) {
                aVar.jrV.onShow(aVar);
            }
            aVar.jrZ = viewParent;
            viewParent.setVisibility(0);
            viewParent.jsa.a(Color.argb(127, 0, 0, 0), null);
        }
    }

    public final void Pt() {
        if (this.iwt == null) {
            w.e("MicroMsg.AppBrandRuntime", "hideSplash, splash view null");
            return;
        }
        this.iwt.a(this.iwr.VN().VF());
        this.iwt.WT();
        this.iwt = null;
    }

    public final int Pu() {
        if (this.iww == null) {
            return 0;
        }
        return this.iww.scene;
    }

    public final String Pv() {
        if (this.iwn == null) {
            return "";
        }
        if (!bg.mA(this.iwn.iEI)) {
            return this.iwn.iEI;
        }
        if (this.iwp == null) {
            return "";
        }
        return this.iwp.Rw();
    }

    public final boolean Pw() {
        return this.iwn == null || this.iwn.iEH;
    }

    final void Px() {
        this.iwL = new f(this);
        this.iwL.jgN = bg.Nz();
        final long currentTimeMillis = System.currentTimeMillis();
        MainProcessTask appBrandPrepareTask = new AppBrandPrepareTask(this.iwk, this.iwn.appId, this.iwn.izM, this.iww == null ? 0 : this.iww.fWL, Pu(), Pv(), this.iwn.iEK);
        appBrandPrepareTask.jjc = new AppBrandPrepareTask.a(this) {
            final /* synthetic */ h iwP;

            public final void b(final AppBrandSysConfig appBrandSysConfig) {
                if (!this.iwP.iwk.isFinishing()) {
                    if (appBrandSysConfig == null) {
                        this.iwP.finish();
                        return;
                    }
                    this.iwP.iwB.k(1, System.currentTimeMillis() - currentTimeMillis);
                    com.tencent.mm.plugin.appbrand.performance.a.a(this.iwP.ivH, "ResourcePrepare", currentTimeMillis, System.currentTimeMillis());
                    this.iwP.iwk.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass7 iwU;

                        public final void run() {
                            this.iwU.iwP.iwo = appBrandSysConfig;
                            this.iwU.iwP.iwI = true;
                            this.iwU.iwP.Py();
                        }
                    });
                }
            }

            public final void PD() {
                this.iwP.iwK = true;
                if (this.iwP.iwL != null) {
                    this.iwP.iwL.jgO = true;
                }
            }
        };
        com.tencent.mm.plugin.appbrand.m.d.aN(appBrandPrepareTask);
        AppBrandMainProcessService.a(appBrandPrepareTask);
    }

    public final void Py() {
        w.i("MicroMsg.AppBrandRuntime", "mFinished: %b, ResourceReady: %b, WebViewReady: %b", new Object[]{Boolean.valueOf(this.mFinished), Boolean.valueOf(this.iwI), Boolean.valueOf(this.iwJ)});
        if (!this.mFinished && this.iwI && this.iwJ) {
            this.iwk.runOnUiThread(new Runnable(this) {
                final /* synthetic */ h iwP;

                {
                    this.iwP = r1;
                }

                public final void run() {
                    h hVar = this.iwP;
                    hVar.iwp = com.tencent.mm.plugin.appbrand.config.a.oa(l.a(hVar, "app-config.json"));
                    hVar.a(hVar.iww, hVar.iwn.iEI);
                    hVar.iwq = new m(hVar.iwk, hVar);
                    hVar.iwr = new j(hVar.iwk, hVar);
                    hVar.iwr.jcv = new j.a(hVar) {
                        final /* synthetic */ h iwP;

                        {
                            this.iwP = r1;
                        }

                        public final void PE() {
                            this.iwP.Pt();
                            h hVar = this.iwP;
                            if (AppBrandPerformanceManager.qB(hVar.ivH) && hVar.iwu == null) {
                                hVar.iwu = new e(hVar.iwk, hVar.ivH);
                                hVar.iws.addView(hVar.iwu);
                                b.a(hVar.ivH, hVar.iwu);
                                e eVar = hVar.iwu;
                                AppBrandPerformanceManager.qC(eVar.ivH);
                                AppBrandPerformanceManager.qx(eVar.ivH);
                                e.a(eVar.ivH, eVar.jkR);
                                eVar.setVisibility(0);
                                eVar.setAlpha(0.0f);
                                eVar.animate().alpha(1.0f).setDuration(500).setStartDelay(500).setListener(null);
                            }
                            h hVar2 = this.iwP;
                            long currentTimeMillis = System.currentTimeMillis() - hVar2.iwn.startTime;
                            com.tencent.mm.plugin.appbrand.report.a.d(currentTimeMillis, hVar2.iwK);
                            String str = "MicroMsg.AppBrandRuntime";
                            String str2 = "onHideSplash: %s, cost: %dms, download : %b";
                            Object[] objArr = new Object[3];
                            objArr[0] = hVar2.iwn != null ? hVar2.iwn.fGs : "";
                            objArr[1] = Long.valueOf(currentTimeMillis);
                            objArr[2] = Boolean.valueOf(hVar2.iwK);
                            w.i(str, str2, objArr);
                            currentTimeMillis = System.currentTimeMillis() - hVar2.iwn.startTime;
                            hVar2.iwB.k(5, currentTimeMillis);
                            j jVar = hVar2.iwB;
                            boolean z = hVar2.iwK;
                            String str3 = hVar2.ivH;
                            jVar.akP = 0;
                            jVar.mType = 0;
                            if (hVar2.iwo != null) {
                                jVar.akP = hVar2.iwo.iFk.izW;
                                jVar.akP = hVar2.iwo.iFk.izV + 1;
                            }
                            jVar.ixf = z ? 1 : 0;
                            jVar.hPi = hVar2.Pu();
                            StringBuilder stringBuilder = new StringBuilder();
                            for (int i = 0; i < jVar.ixe.length; i++) {
                                if (jVar.ixe[i] < 0) {
                                    w.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: abort, illegal value: %d, %d", new Object[]{Integer.valueOf(i), Long.valueOf(jVar.ixe[i])});
                                    break;
                                }
                                stringBuilder.append(jVar.ixe[i]);
                                stringBuilder.append(",");
                            }
                            w.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: %s, %s, Download: %s, Preload: %s", new Object[]{str3, stringBuilder.toString(), Boolean.valueOf(z), Boolean.valueOf(com.tencent.mm.plugin.appbrand.task.a.WC())});
                            jVar.m(str3, 1, 0);
                            jVar.m(str3, 2, 1);
                            jVar.m(str3, 3, 2);
                            jVar.m(str3, 4, 3);
                            jVar.m(str3, 6, 4);
                            jVar.m(str3, 7, 5);
                            jVar.ixh = 1;
                            AppBrandPerformanceManager.b(hVar2.ivH, com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, currentTimeMillis);
                            com.tencent.mm.plugin.appbrand.performance.a.aE(hVar2.iwn.startTime);
                            this.iwP.iwL = null;
                            MainProcessTask mainProcessTask = this.iwP.iwx;
                            mainProcessTask.jhy = a.jhN;
                            AppBrandMainProcessService.a(mainProcessTask);
                        }
                    };
                    hVar.iws.addView(hVar.iwr, 0);
                    FrameLayout frameLayout = hVar.iws;
                    View bVar = new com.tencent.mm.plugin.appbrand.widget.b.b(hVar.iwk);
                    hVar.iwv = bVar;
                    frameLayout.addView(bVar);
                    j jVar = hVar.iwr;
                    String str = hVar.iwn.iEI;
                    if (bg.mA(str)) {
                        str = jVar.ixr.iwp.Rw();
                    }
                    jVar.runOnUiThread(new com.tencent.mm.plugin.appbrand.g.j.AnonymousClass1(jVar, str));
                    m mVar = hVar.iwq;
                    JSONObject jSONObject = new JSONObject();
                    AppBrandSysConfig appBrandSysConfig = mVar.ixr.iwo;
                    com.tencent.mm.plugin.appbrand.config.a aVar = mVar.ixr.iwp;
                    if (!(appBrandSysConfig == null || aVar == null)) {
                        JSONObject jSONObject2 = aVar.iDQ;
                        Iterator keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            str = (String) keys.next();
                            try {
                                jSONObject.putOpt(str, jSONObject2.opt(str));
                            } catch (Exception e) {
                                w.e("MicroMsg.AppBrandService", e.getMessage());
                            }
                        }
                        m.a(jSONObject, "debug", Boolean.valueOf(mVar.ixr.iwo.iER));
                        m.a(jSONObject, "downloadDomain", appBrandSysConfig.iFg);
                        m.a(jSONObject, "platform", (Object) "android");
                        m.a(jSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.sYN));
                        Object jSONObject3 = new JSONObject();
                        m.a((JSONObject) jSONObject3, "scene", Integer.valueOf(mVar.ixr.Pu()));
                        String Pv = mVar.ixr.Pv();
                        m.a((JSONObject) jSONObject3, "path", o.qW(Pv));
                        m.a((JSONObject) jSONObject3, "query", new JSONObject(o.qX(Pv)));
                        m.a((JSONObject) jSONObject3, "topBarStatus", Boolean.valueOf(mVar.ixr.iwn.iEJ));
                        m.a((JSONObject) jSONObject3, "referrerInfo", mVar.ixr.iwn.iEK.RC());
                        m.a((JSONObject) jSONObject3, "shareInfo", mVar.ixr.iwn.RB());
                        Object jSONObject4 = new JSONObject();
                        try {
                            m.a((JSONObject) jSONObject4, "template", new JSONArray(appBrandSysConfig.iEQ));
                        } catch (Exception e2) {
                        }
                        m.a((JSONObject) jSONObject4, "maxRequestConcurrent", Integer.valueOf(appBrandSysConfig.iEW));
                        m.a((JSONObject) jSONObject4, "maxUploadConcurrent", Integer.valueOf(appBrandSysConfig.iEX));
                        m.a((JSONObject) jSONObject4, "maxDownloadConcurrent", Integer.valueOf(appBrandSysConfig.iEY));
                        m.a(jSONObject, "appLaunchInfo", jSONObject3);
                        m.a(jSONObject, "wxAppInfo", jSONObject4);
                        m.a(jSONObject, "isPluginMiniProgram", Boolean.valueOf(mVar.ixr.Pw()));
                        str = aVar.iDR;
                        mVar.ixt.evaluateJavascript(String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[]{jSONObject.toString(), str}), null);
                    }
                    StringBuilder append = new StringBuilder().append(com.tencent.mm.plugin.appbrand.m.a.qT("wxa_library/android.js")).append(l.a(mVar.ixr, "WAService.js"));
                    str = "";
                    if (AppBrandPerformanceManager.qB(mVar.ivH)) {
                        str = l.a(mVar.ixr, "WAPerf.js");
                    }
                    str = append.append(str).toString();
                    g.oUh.a(370, 5, 1, false);
                    com.tencent.mm.plugin.appbrand.m.g.a(mVar.ixt, str, new com.tencent.mm.plugin.appbrand.m.g.a(mVar) {
                        final /* synthetic */ m ixv;

                        {
                            this.ixv = r1;
                        }

                        public final void PK() {
                            g.oUh.a(370, 7, 1, false);
                        }

                        public final void nu(String str) {
                            w.e("MicroMsg.AppBrandService", "Inject SDK Service Script Failed: %s", new Object[]{str});
                            g.oUh.a(370, 6, 1, false);
                            com.tencent.mm.plugin.appbrand.report.a.al(this.ixv.ivH, 24);
                            com.tencent.mm.plugin.appbrand.report.a.b(this.ixv.ivH, this.ixv.ixr.iwo.iFk.izW, this.ixv.ixr.iwo.iFk.izV, 370, 6);
                        }
                    });
                    str = l.a(mVar.ixr, "app-service.js");
                    g.oUh.a(370, 9, 1, false);
                    com.tencent.mm.plugin.appbrand.m.g.a(mVar.ixt, str, new com.tencent.mm.plugin.appbrand.m.g.a(mVar) {
                        final /* synthetic */ m ixv;

                        {
                            this.ixv = r1;
                        }

                        public final void PK() {
                            g.oUh.a(370, 11, 1, false);
                        }

                        public final void nu(String str) {
                            w.e("MicroMsg.AppBrandService", "Inject External Service Script Failed: %s", new Object[]{str});
                            g.oUh.a(370, 10, 1, false);
                            com.tencent.mm.plugin.appbrand.report.a.al(this.ixv.ivH, 24);
                            com.tencent.mm.plugin.appbrand.report.a.b(this.ixv.ivH, this.ixv.ixr.iwo.iFk.izW, this.ixv.ixr.iwo.iFk.izV, 370, 10);
                        }
                    });
                    mVar.PH();
                    hVar.a(hVar.iwo);
                    g.oUh.a(369, 2, 1, false);
                    this.iwP.gZN = true;
                    h hVar2 = this.iwP;
                    hVar2.mHandler.removeCallbacks(hVar2.iwO);
                }
            });
        }
    }

    public final void Pz() {
        this.iwH++;
    }

    public final void PA() {
        if (this.iwH != 0) {
            this.iwH--;
        }
    }

    public final void onPause() {
        if (this.gZN) {
            w.i("MicroMsg.AppBrandRuntime", "onPause: %s", new Object[]{this.ivH});
            this.iwC.iAk.hx(1);
            d dVar = this.iwz;
            Map hashMap = new HashMap(1);
            Object obj = "hide";
            switch (com.tencent.mm.plugin.appbrand.g.d.AnonymousClass1.ivI[e.nk(this.ivH).ordinal()]) {
                case 1:
                    obj = "close";
                    break;
                case 2:
                    obj = "back";
                    break;
                case 3:
                case 4:
                case 5:
                    obj = "hide";
                    break;
                case 6:
                    obj = "hang";
                    break;
                case 7:
                    obj = "launchMiniProgram";
                    break;
            }
            hashMap.put("mode", obj);
            dVar.q(hashMap).a(this.iwq).SR();
            j jVar = this.iwr;
            if (jVar.jcp.size() != 0) {
                ((com.tencent.mm.plugin.appbrand.g.h) jVar.jcp.getFirst()).VA();
                jVar.jct.b((com.tencent.mm.plugin.appbrand.g.h) jVar.jcp.peekFirst());
            }
            e.nf(this.ivH);
            e.a(this.ivH, e.a.ON_PAUSE);
            w.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onPause");
            au.a(null);
        }
    }

    public final void onResume() {
        if (this.gZN) {
            w.i("MicroMsg.AppBrandRuntime", "onResume: %s", new Object[]{this.ivH});
            if (this.mFinished || this.iwD) {
                Po();
                a(this.iwn, this.iww);
                Pr();
                w.i("MicroMsg.AppBrandRuntime", "reload: %s", new Object[]{this.ivH});
                return;
            }
            e.nj(this.ivH);
            e.ng(this.ivH);
            e.a(this.ivH, e.a.ON_RESUME);
            MainProcessTask mainProcessTask = this.iwx;
            String str = this.ivH;
            int i = this.iwn.izM;
            mainProcessTask.jhy = a.jhF;
            mainProcessTask.ivH = str;
            mainProcessTask.jhw = i;
            AppBrandMainProcessService.a(mainProcessTask);
            j jVar = this.iwr;
            if (jVar.jcp.size() != 0) {
                ((com.tencent.mm.plugin.appbrand.g.h) jVar.jcp.getFirst()).Vz();
                jVar.jct.c((com.tencent.mm.plugin.appbrand.g.h) jVar.jcp.peekFirst());
            }
            this.iwC.iAk.hx(3);
            if (this.iwE) {
                this.iwr.L(Pv(), true);
                this.iwy.jci = true;
            }
            com.tencent.mm.plugin.appbrand.g.e eVar = this.iwy;
            Map hashMap = new HashMap();
            AppBrandStatObject appBrandStatObject = this.iww;
            if (appBrandStatObject != null) {
                hashMap.put("scene", Integer.valueOf(appBrandStatObject.scene));
            }
            JSONObject RC = this.iwn.iEK.RC();
            if (RC != null) {
                hashMap.put("referrerInfo", RC);
            }
            RC = this.iwn.RB();
            if (RC != null) {
                hashMap.put("shareInfo", RC);
            }
            hashMap.put("relaunch", Boolean.valueOf(eVar.jci));
            hashMap.put("reLaunch", Boolean.valueOf(eVar.jci));
            eVar.q(hashMap).a(this.iwq).SR();
            eVar.jci = false;
            AppBrandInitConfig appBrandInitConfig = this.iwn;
            if (!bg.mA(appBrandInitConfig.appId)) {
                AppBrandSysConfig mY = b.mY(appBrandInitConfig.appId);
                if (mY != null) {
                    appBrandStatObject = b.mZ(appBrandInitConfig.appId);
                    if (appBrandStatObject != null) {
                        w.i("MicroMsg.AppBrandTaskUsageRecorder", "updateUsage, appId %s, type %d", new Object[]{appBrandInitConfig.appId, Integer.valueOf(appBrandInitConfig.izM)});
                        AppBrandMainProcessService.a(new UpdateTask(new LaunchCheckParams(appBrandInitConfig, appBrandStatObject, mY.iFk.izW)));
                    }
                }
            }
            c cVar = this.iwA;
            w.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
            au.a(cVar.jnJ);
            a(this.iwo);
            this.iwD = false;
            this.iwE = false;
            this.iwF = false;
            this.iwG = false;
        }
    }

    public final void Po() {
        if (!this.mFinished) {
            this.mFinished = true;
            w.i("MicroMsg.AppBrandRuntime", "onDestroy: %s", new Object[]{this.ivH});
            MainProcessTask mainProcessTask = this.iwx;
            String str = this.ivH;
            mainProcessTask.jhy = a.jhG;
            mainProcessTask.ivH = str;
            AppBrandMainProcessService.a(mainProcessTask);
            AppBrandMainProcessService.b(this.iwN);
            MMToClientEvent.pa(this.ivH);
            e.ne(this.ivH);
            e.a(this.ivH, e.a.ON_DESTROY);
            i.nm(this.ivH);
            AppBrandStickyBannerLogic.a.qR(this.ivH);
            b.nb(this.ivH);
            AppBrandMusicClientService appBrandMusicClientService = AppBrandMusicClientService.jao;
            appBrandMusicClientService.jan.clear();
            appBrandMusicClientService.jap = "";
            this.iwk.aHf();
            b bVar = this.iwC;
            com.tencent.mm.plugin.appbrand.a.c cVar = bVar.iAk;
            cVar.iAu.set(true);
            cVar.quit();
            cVar.b(com.tencent.mm.plugin.appbrand.a.a.DESTROYED);
            ab.getContext().unregisterComponentCallbacks(bVar.iAm);
            synchronized (bVar.iAl) {
                bVar.iAl.clear();
            }
            if (this.iwL != null) {
                f fVar = this.iwL;
                try {
                    l ns = l.ns(fVar.ixi.ivH);
                    fVar.jgl = com.tencent.mm.plugin.appbrand.report.a.bz(ab.getContext());
                    fVar.appId = fVar.ixi.ivH;
                    fVar.fWF = fVar.ixi.iwo == null ? 0 : fVar.ixi.iwo.iFk.izW;
                    fVar.fCM = fVar.ixi.iwn.izM + 1;
                    fVar.scene = fVar.ixi.Pu();
                    fVar.fFF = ns.ixn;
                    if (bg.mA(fVar.fFF)) {
                        fVar.fFF = com.tencent.mm.plugin.appbrand.report.a.a.Wv();
                    }
                    fVar.jgP = fVar.jgO ? 1 : 0;
                    fVar.jgQ = ns.ixq ? 1 : 0;
                    fVar.jgR = bg.Nz() - fVar.jgN;
                    fVar.jgS = bg.Nz();
                    w.i("MicroMsg.AppBrand.Report.kv_14576", "report|" + fVar.toString());
                    com.tencent.mm.plugin.report.c.oTb.i(14576, new Object[]{fVar.jgl, fVar.appId, Integer.valueOf(fVar.fWF), Integer.valueOf(fVar.fCM), Integer.valueOf(fVar.scene), fVar.fFF, Integer.valueOf(fVar.jgP), Integer.valueOf(fVar.jgQ), Long.valueOf(fVar.jgR), Long.valueOf(fVar.jgS)});
                } catch (Exception e) {
                    w.e("MicroMsg.AppBrand.Report.kv_14576", "report exp %s", new Object[]{e});
                }
            }
            this.iwL = null;
            e.ni(this.ivH);
            if (this.iwq != null) {
                m mVar = this.iwq;
                mVar.ixt.Po();
                mVar.ixs.Po();
            }
            if (this.iwr != null) {
                this.iws.removeView(this.iwr);
                this.iwr.Po();
            }
            b.a(this.ivH, null);
            l.remove(this.ivH);
            this.iwn.startTime = System.currentTimeMillis();
        }
    }

    public final void finish() {
        this.iwk.runOnUiThread(new Runnable(this) {
            final /* synthetic */ h iwP;

            {
                this.iwP = r1;
            }

            public final void run() {
                this.iwP.c(null);
            }
        });
    }

    public final void c(JSONObject jSONObject) {
        if (this.iwl.iwW.size() == 1) {
            this.iwl.D(true);
            return;
        }
        h Ps = Ps();
        if (this.iwm != null && this.iwm == Ps) {
            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
            appBrandLaunchReferrer.appId = this.ivH;
            appBrandLaunchReferrer.iEL = 3;
            appBrandLaunchReferrer.iEM = jSONObject == null ? null : jSONObject.toString();
            Ps.iwn.iEK.a(appBrandLaunchReferrer);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1038;
            appBrandStatObject.fCN = this.ivH;
            Ps.a(appBrandStatObject, null);
        }
        Runnable anonymousClass12 = new Runnable(this) {
            final /* synthetic */ h iwP;

            {
                this.iwP = r1;
            }

            public final void run() {
                h hVar = this.iwP;
                hVar.iwl.a(hVar);
            }
        };
        int i = (this.iwr == null || this.iwr.VN() == null || !this.iwr.VN().jcl) ? true : 0;
        if (i != 0) {
            Animator ofFloat = ObjectAnimator.ofFloat(this.iws, "translationX", new float[]{0.0f, (float) this.iwl.iws.getWidth()});
            ofFloat.setDuration(250);
            a(ofFloat, anonymousClass12);
            if (Ps != null) {
                ofFloat = ObjectAnimator.ofFloat(Ps.iws, "translationX", new float[]{-(((float) Ps.iwl.iws.getWidth()) * 0.25f), 0.0f});
                ofFloat.setDuration(250);
                Ps.a(ofFloat, null);
            }
        } else {
            anonymousClass12.run();
        }
        if (Ps != null) {
            Ps.onResume();
        }
    }

    public final void D(boolean z) {
        boolean z2 = true;
        if (this.iwl.iwW.size() == 1) {
            i iVar = this.iwl;
            if (!(Pw() || z)) {
                z2 = false;
            }
            iVar.D(z2);
            return;
        }
        finish();
    }

    @TargetApi(21)
    final void a(final AppBrandSysConfig appBrandSysConfig) {
        if (VERSION.SDK_INT >= 21 && !Pw()) {
            final int cd = com.tencent.mm.plugin.webview.ui.tools.d.cd(this.iwp.iDM.iEc, WebView.NIGHT_MODE_COLOR);
            this.iwk.setTaskDescription(new TaskDescription(appBrandSysConfig.fGs, null, cd));
            com.tencent.mm.modelappbrand.a.b.AY().a(new com.tencent.mm.modelappbrand.a.b.b(this) {
                final /* synthetic */ h iwP;

                public final void h(Bitmap bitmap) {
                    this.iwP.iwk.setTaskDescription(new TaskDescription(appBrandSysConfig.fGs, bitmap, cd));
                }
            }, appBrandSysConfig.iEP, null);
        }
    }

    final void i(Runnable runnable) {
        ObjectAnimator.ofFloat(this.iws, "translationX", new float[]{0.0f, -(((float) this.iwl.iws.getWidth()) * 0.25f)}).setDuration(250);
        ObjectAnimator.ofFloat(this.iws, "translationX", new float[]{0.0f}).setDuration(0);
        Animator animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{r0, r1});
        a(animatorSet, runnable);
    }

    final void PB() {
        Animator ofFloat = ObjectAnimator.ofFloat(this.iws, "translationX", new float[]{(float) this.iwl.iws.getWidth(), 0.0f});
        ofFloat.setDuration(250);
        a(ofFloat, null);
    }

    private void a(Animator animator, final Runnable runnable) {
        animator.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ h iwP;

            public final void onAnimationEnd(Animator animator) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        animator.start();
    }
}
