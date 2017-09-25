package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.R;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.app.i;
import com.tencent.mm.bb.d;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.e.a.ab;
import com.tencent.mm.e.a.az;
import com.tencent.mm.e.a.if;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.k;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.jsapi.bl;
import com.tencent.mm.plugin.appbrand.jsapi.cn;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.k.a.b.o;
import com.tencent.mm.pluginsdk.l.t;
import com.tencent.mm.pluginsdk.l.y;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bf;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.HomeUI.AnonymousClass35;
import com.tencent.mm.ui.HomeUI.AnonymousClass53;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr.AnonymousClass11;
import com.tencent.mm.ui.MMAppMgr.AnonymousClass9;
import com.tencent.mm.ui.account.WelcomeSelectView;
import com.tencent.mm.ui.b.c;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.chatting.ep;
import com.tencent.mm.ui.j.AnonymousClass3;
import com.tencent.mm.ui.j.AnonymousClass4;
import com.tencent.mm.ui.j.AnonymousClass5;
import com.tencent.mm.ui.widget.j;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@a(3)
@TargetApi(11)
public class LauncherUI extends MMFragmentActivity implements i.a {
    private static ArrayList<LauncherUI> uRJ = new ArrayList();
    private static boolean uRK = true;
    public static long uRL;
    private Intent fNO = null;
    public HomeUI uRM = new HomeUI();
    private j uRN = new j();
    private boolean uRO = false;
    public boolean uRP = false;
    boolean uRQ = false;
    private boolean uRR = false;

    static /* synthetic */ void a(LauncherUI launcherUI) {
        boolean z;
        boolean z2 = false;
        w.i("MicroMsg.LauncherUI", "summerper doInit hasDoInit[%b]", Boolean.valueOf(launcherUI.uRP));
        if (!launcherUI.uRP) {
            Runnable anonymousClass2 = new Runnable(launcherUI) {
                final /* synthetic */ LauncherUI uRS;

                {
                    this.uRS = r1;
                }

                public final void run() {
                    LauncherUI.a(this.uRS);
                }
            };
            j jVar = launcherUI.uRN;
            w.i("MicroMsg.LauncherUICheckPermissionHelper", "summerper checkPermission checkStorage[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(launcherUI, "android.permission.WRITE_EXTERNAL_STORAGE", 32, "", "")));
            if (com.tencent.mm.pluginsdk.i.a.a(launcherUI, "android.permission.WRITE_EXTERNAL_STORAGE", 32, "", "")) {
                w.i("MicroMsg.LauncherUICheckPermissionHelper", "summerper checkPermission checkPhone[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(launcherUI, "android.permission.READ_PHONE_STATE", 96, "", "")));
                if (com.tencent.mm.pluginsdk.i.a.a(launcherUI, "android.permission.READ_PHONE_STATE", 96, "", "")) {
                    w.i("MicroMsg.LauncherUICheckPermissionHelper", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(launcherUI, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")));
                    if (com.tencent.mm.pluginsdk.i.a.a(launcherUI, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")) {
                        w.i("MicroMsg.LauncherUICheckPermissionHelper", "start time check launcherUIOnCreate from begin time ==" + (System.currentTimeMillis() - uRL));
                        f.cU(uRL);
                        z = true;
                    } else {
                        jVar.uSz = anonymousClass2;
                        z = false;
                    }
                } else {
                    jVar.uSz = anonymousClass2;
                    z = false;
                }
            } else {
                jVar.uSz = anonymousClass2;
                z = false;
            }
            if (!z) {
                return;
            }
        }
        launcherUI.uRO = true;
        z = !ap.za() && ao.hlW.A("login_user_name", "").equals("");
        if (z) {
            o.acH();
            f.sa(8);
            View welcomeSelectView = new WelcomeSelectView(launcherUI);
            launcherUI.setContentView(welcomeSelectView);
            welcomeSelectView.bRn();
            if (com.tencent.mm.sdk.platformtools.f.usv) {
                MMAppMgr.d(launcherUI);
            } else {
                MMAppMgr.eA(launcherUI);
            }
            z2 = true;
        } else {
            com.tencent.mm.sdk.platformtools.f.usu = false;
        }
        if (!z2) {
            launcherUI.bPK();
        }
    }

    public static LauncherUI bPI() {
        if (!uRJ.isEmpty()) {
            return (LauncherUI) uRJ.get(0);
        }
        w.e("MicroMsg.LauncherUI", "LauncherUI instances should not be empty. %s", u.NC());
        return null;
    }

    private void bPJ() {
        int indexOf = uRJ.indexOf(this);
        if (indexOf >= 0) {
            uRJ.remove(indexOf);
        }
        w.i("MicroMsg.LauncherUI", "checktask delteInstance index %d, size:%d, hashCode: 0x%x", Integer.valueOf(indexOf), Integer.valueOf(uRJ.size()), Integer.valueOf(hashCode()));
    }

    protected final boolean bDZ() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        HomeUI homeUI;
        long currentTimeMillis = System.currentTimeMillis();
        w.i("MicroMsg.LauncherUI", "start time check checktask onCreate 0x%x, taskid %d, task:%s", Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bg.eq(this));
        super.onCreate(bundle);
        long currentTimeMillis2 = System.currentTimeMillis();
        int taskId = getTaskId();
        String packageName = getPackageName();
        Intent intent = getIntent();
        boolean z = false;
        if (intent != null && s.a(intent, "absolutely_exit", false)) {
            z = true;
            w.i("MicroMsg.LauncherUI", "checktask checkInstance isWantToRestart");
        }
        RunningTaskInfo runningTaskInfo = null;
        if (!z) {
            Iterator it = uRJ.iterator();
            while (it.hasNext()) {
                LauncherUI launcherUI = (LauncherUI) it.next();
                if (launcherUI.getTaskId() != taskId) {
                    w.i("MicroMsg.LauncherUI", "checktask checkInstance 0x%x diff taskid taskid %d, nowtaskid:%d", Integer.valueOf(launcherUI.hashCode()), Integer.valueOf(launcherUI.getTaskId()), Integer.valueOf(taskId));
                    runningTaskInfo = bg.aa(this, taskId);
                    if (runningTaskInfo == null) {
                        w.e("MicroMsg.LauncherUI", "checktask cannot found curren taskinfo %d", Integer.valueOf(taskId));
                        finish();
                        obj = null;
                        break;
                    }
                    w.i("MicroMsg.LauncherUI", "checktask task diff id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", Integer.valueOf(runningTaskInfo.id), runningTaskInfo.topActivity.getClassName(), runningTaskInfo.baseActivity.getClassName(), Integer.valueOf(runningTaskInfo.numActivities), Integer.valueOf(runningTaskInfo.numRunning));
                    if (runningTaskInfo.baseActivity.getPackageName().equals(packageName)) {
                        launcherUI.finish();
                        uRJ.remove(launcherUI);
                    } else {
                        w.e("MicroMsg.LauncherUI", "checktask base activity is not mm, finish! info.baseActivity.getPackageName()  " + runningTaskInfo.baseActivity.getPackageName());
                        finish();
                        if (bg.aa(this, launcherUI.getTaskId()) != null) {
                            w.i("MicroMsg.LauncherUI", "checktask startLauncherUI with FLAG_ACTIVITY_NEW_TASK");
                            Intent intent2 = new Intent(this, LauncherUI.class);
                            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            startActivity(intent2);
                        }
                        obj = null;
                    }
                }
                runningTaskInfo = runningTaskInfo;
            }
        }
        if (!uRJ.isEmpty()) {
            if (runningTaskInfo == null) {
                runningTaskInfo = bg.aa(this, taskId);
            }
            if (runningTaskInfo != null) {
                w.i("MicroMsg.LauncherUI", "checktask now info id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", Integer.valueOf(runningTaskInfo.id), runningTaskInfo.baseActivity.getClassName(), runningTaskInfo.baseActivity.getClassName(), Integer.valueOf(runningTaskInfo.numActivities), Integer.valueOf(runningTaskInfo.numRunning));
                packageName = getComponentName().getClassName();
                if (runningTaskInfo.numActivities > 1 && packageName.equals(r0) && packageName.equals(r3)) {
                    finish();
                    w.w("MicroMsg.LauncherUI", "checktask finish this mainTabUI, and use the last LauncherUI instanceCount: %d", Integer.valueOf(uRJ.size()));
                    obj = null;
                    if (obj != null) {
                        w.i("MicroMsg.LauncherUI", "onCreate checkInstance false");
                    }
                    w.i("MicroMsg.LauncherUI", "onCreate normally");
                    homeUI = this.uRM;
                    homeUI.uQk = this;
                    NotifyReceiver.pW();
                    e.R(homeUI.uQk);
                    homeUI.Gx = cO().cP();
                    if (homeUI.Gx != null) {
                        if (VERSION.SDK_INT < 11) {
                            homeUI.Gx.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.aSD)));
                        }
                        homeUI.Gx.hide();
                    }
                    setRequestedOrientation(1);
                    i.oj().fwr.add(this);
                    String A = ao.hlW.A("login_user_name", "");
                    this.fNO = getIntent();
                    w.i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s, DefaultBootStep.isStartupOnInitThread() %s", A, Boolean.valueOf(ap.za()), Boolean.valueOf(uRK), Boolean.valueOf(WorkerProfile.fvY));
                    if ((uRK || !WorkerProfile.fvY) && (ap.za() || !A.equals(""))) {
                        uRL = currentTimeMillis;
                        w.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - MMApplicationLike.sAppStartTime));
                        this.uRO = true;
                        return;
                    }
                    if (!WorkerProfile.oC().fxj || WorkerProfile.oC().oD()) {
                        uRL = currentTimeMillis;
                        w.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - MMApplicationLike.sAppStartTime));
                    } else {
                        uRL = MMApplicationLike.sAppStartTime;
                        w.i("MicroMsg.LauncherUI", "start time check isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - MMApplicationLike.sAppStartTime));
                    }
                    setRequestedOrientation(1);
                    i oj = i.oj();
                    Object obj2 = (ap.za() || !ao.hlW.A("login_user_name", "").equals("")) ? null : 1;
                    if (oj.fwm) {
                        oj.ol();
                    }
                    ep anonymousClass1 = new ep(oj) {
                        final /* synthetic */ i fwt;

                        {
                            this.fwt = r1;
                        }

                        public final void om() {
                            w.i("MicroMsg.INIT", "start time check WorkerProfile.getInstance().hasCreate:%b, onviewDrawed time: %d", Boolean.valueOf(WorkerProfile.oC().oD()), Long.valueOf(System.currentTimeMillis() - LauncherUI.uRL));
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 fwu;

                                {
                                    this.fwu = r1;
                                }

                                public final void run() {
                                    w.i("MicroMsg.INIT", "start time check post run: " + (System.currentTimeMillis() - LauncherUI.uRL));
                                    w.i("MicroMsg.INIT", "--- %s", ((com.tencent.mm.kernel.b.f) h.vF().vj()).gZy.gZq);
                                    w.i("MicroMsg.INIT", "--- process().current().boot().bootStep() instanceof IBootStepDelayExecute %s", Boolean.valueOf(((com.tencent.mm.kernel.b.f) h.vF().vj()).gZy.gZq instanceof h));
                                    if (((com.tencent.mm.kernel.b.f) h.vF().vj()).gZy.gZq instanceof h) {
                                        ((h) ((com.tencent.mm.kernel.b.f) h.vF().vj()).gZy.gZq).og();
                                    }
                                    h.vJ().a(new com.tencent.mm.kernel.api.h(this) {
                                        final /* synthetic */ AnonymousClass1 fwv;

                                        {
                                            this.fwv = r1;
                                        }

                                        public final void oh() {
                                            this.fwv.fwu.fwt.fwn = true;
                                            w.i("MicroMsg.INIT", "showNewLaunchImageEnd: %s, onStartupDone : %s ", Boolean.valueOf(this.fwv.fwu.fwt.fwo), Integer.valueOf(this.fwv.fwu.fwt.fwr.size()));
                                            if (this.fwv.fwu.fwt.fwo) {
                                                this.fwv.fwu.fwt.ok();
                                            }
                                            h.vJ().b(this);
                                        }

                                        public final void ak(boolean z) {
                                        }
                                    });
                                }
                            });
                        }
                    };
                    bf.zK().hgx.edit().putInt("MicroMsg.RegStyleStoragestyle_id", 21).commit();
                    currentTimeMillis = System.currentTimeMillis();
                    View splashWelcomeView = new SplashWelcomeView(this);
                    splashWelcomeView.uWy = anonymousClass1;
                    splashWelcomeView.uWB = new SplashWelcomeView.a(oj) {
                        final /* synthetic */ i fwt;

                        {
                            this.fwt = r1;
                        }

                        public final void on() {
                            this.fwt.fwo = true;
                            w.i("MicroMsg.INIT", "on change LaunchImage end, startup done: %s", Boolean.valueOf(this.fwt.fwn));
                            if (this.fwt.fwn) {
                                this.fwt.ok();
                            }
                        }
                    };
                    if (this instanceof Activity) {
                        setContentView(splashWelcomeView);
                    } else if (oj.fwi == null || oj.fwj == null) {
                        oj.fwk = new LayoutParams();
                        oj.fwk.height = -1;
                        oj.fwk.width = -1;
                        oj.fwj = (WindowManager) getSystemService("window");
                        oj.fwk.x = 0;
                        oj.fwk.y = 0;
                        oj.fwk.type = MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK;
                        oj.mView = splashWelcomeView;
                        oj.fwk.gravity = 51;
                        oj.fwk.format = 1;
                        oj.fwi = new FrameLayout(this);
                        oj.fwi.setPadding(0, 0, 0, 0);
                        oj.fwl = new ViewGroup.LayoutParams(-1, -1);
                        oj.fwi.addView(oj.mView, oj.fwl);
                        oj.fwj.addView(oj.fwi, oj.fwk);
                        oj.fwm = true;
                    }
                    if (obj2 == null && oj.fwp != null) {
                        oj.fwp.setCallback(null);
                        oj.fwp = null;
                    }
                    w.d("MicroMsg.INIT", "start time check initWindow  Last: " + (System.currentTimeMillis() - currentTimeMillis));
                    w.d("MicroMsg.INIT", "start time check APPCreate to Window Show Last: " + (System.currentTimeMillis() - uRL));
                    w.i("MicroMsg.LauncherUI", "start time check after initwindow time from launcherui==" + (System.currentTimeMillis() - uRL));
                    return;
                }
                w.w("MicroMsg.LauncherUI", "checktask should not here without isWantToRestart is true launcherUIInstances.clear LauncherUI instanceCount: %d, isWantToRestart %b", Integer.valueOf(uRJ.size()), Boolean.valueOf(r2));
                uRJ.clear();
            } else {
                w.w("MicroMsg.LauncherUI", "checktask can not found taskid %d,  LauncherUI instanceCount: %d", Integer.valueOf(taskId), Integer.valueOf(uRJ.size()));
                uRJ.clear();
            }
        }
        uRJ.add(this);
        w.i("MicroMsg.LauncherUI", "checktask Launcherui oncreate checkInstance size %d, use time %d", Integer.valueOf(uRJ.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        obj = 1;
        if (obj != null) {
            w.i("MicroMsg.LauncherUI", "onCreate normally");
            homeUI = this.uRM;
            homeUI.uQk = this;
            NotifyReceiver.pW();
            e.R(homeUI.uQk);
            homeUI.Gx = cO().cP();
            if (homeUI.Gx != null) {
                if (VERSION.SDK_INT < 11) {
                    homeUI.Gx.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.aSD)));
                }
                homeUI.Gx.hide();
            }
            setRequestedOrientation(1);
            i.oj().fwr.add(this);
            String A2 = ao.hlW.A("login_user_name", "");
            this.fNO = getIntent();
            w.i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s, DefaultBootStep.isStartupOnInitThread() %s", A2, Boolean.valueOf(ap.za()), Boolean.valueOf(uRK), Boolean.valueOf(WorkerProfile.fvY));
            if (uRK) {
            }
            uRL = currentTimeMillis;
            w.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - MMApplicationLike.sAppStartTime));
            this.uRO = true;
            return;
        }
        w.i("MicroMsg.LauncherUI", "onCreate checkInstance false");
    }

    protected void onNewIntent(Intent intent) {
        w.i("MicroMsg.LauncherUI", "onNewIntent 0x%x task:%s", Integer.valueOf(hashCode()), bg.eq(this));
        this.fNO = intent;
        super.onNewIntent(intent);
        setIntent(intent);
        if (!WorkerProfile.oC().oD()) {
            return;
        }
        if (bPL()) {
            w.i("MicroMsg.LauncherUI", "onNewIntent handleExitIntent");
        } else if (this.fNO == null || !s.a(this.fNO, "Intro_Need_Clear_Top ", false)) {
            HomeUI homeUI = this.uRM;
            if ((intent.getFlags() & 67108864) == 67108864) {
                homeUI.kl(false);
                homeUI.uPW = true;
                homeUI.uPX = s.a(intent, "Intro_Notify", false);
            }
            homeUI.zb(0);
            if (this.uRP) {
                w.v("MicroMsg.LauncherUI", "onMainTabNewIntent on new intent");
                if (WorkerProfile.oC().oD()) {
                    ag(intent);
                }
            }
        } else {
            w.d("MicroMsg.LauncherUI", "KEVIN KNeedClearTop");
            finish();
            ez(this);
        }
    }

    public final void oo() {
        w.d("MicroMsg.LauncherUI", "KEVIN onInit");
        af.v(new Runnable(this) {
            final /* synthetic */ LauncherUI uRS;

            {
                this.uRS = r1;
            }

            public final void run() {
                LauncherUI.a(this.uRS);
            }

            public final String toString() {
                return super.toString() + "|onInit";
            }
        });
    }

    public void onResume() {
        super.onResume();
        if (bPL()) {
            w.i("MicroMsg.LauncherUI", "onResume handleExitIntent");
            return;
        }
        w.i("MicroMsg.LauncherUI", "onResume hasLoaderFinished:%b", Boolean.valueOf(this.uRO));
        if (this.uRO) {
            bPK();
            if (this.uRN.oIa) {
                w.i("MicroMsg.LauncherUICheckPermissionHelper", "summerper checkPermission checkStorage[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", "")));
                if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", "")) {
                    w.i("MicroMsg.LauncherUICheckPermissionHelper", "summerper checkPermission checkPhone[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_PHONE_STATE", 97, "", "")));
                    if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_PHONE_STATE", 97, "", "")) {
                        boolean a = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 70, "", "");
                        w.i("MicroMsg.LauncherUICheckPermissionHelper", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(a));
                    }
                }
            }
        }
    }

    private void bPK() {
        uRK = false;
        boolean z = (this.fNO == null || s.a(this.fNO, "Intro_Switch", false) || !ap.za() || ap.uP()) ? false : true;
        String i;
        Intent intent;
        if (z) {
            LauncherUI bPI;
            String i2;
            w.i("MicroMsg.LauncherUI", "doOnResumeImp notSwitchorHold, hasDoInit:%b", Boolean.valueOf(this.uRP));
            if (!this.uRP) {
                this.uRP = true;
                HomeUI homeUI = this.uRM;
                getWindow().setCallback(new c(getWindow().getCallback(), this));
                SharedPreferences sharedPreferences = homeUI.uQk.getSharedPreferences("system_config_prefs", 4);
                if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
                    sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
                    XLogSetup.realSetupXlog();
                }
                homeUI.bPA();
                homeUI.uQe = new u(this);
                homeUI.uPU = true;
                NotifyReceiver.pX();
                ap.getNotification().dP(1);
                w.d("MicroMsg.LauncherUI", "on main tab create");
                long currentTimeMillis = System.currentTimeMillis();
                if (ap.zb()) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    MMActivity.et(homeUI.uQk);
                    try {
                        Set hashSet = new HashSet();
                        String[] split = homeUI.getString(R.l.eaR).split(";");
                        hashSet.add(split[0]);
                        hashSet.add(split[1]);
                        n.c(hashSet);
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.LauncherUI", e, "", new Object[0]);
                    }
                    com.tencent.mm.sdk.b.a.urY.m(new az());
                    w.d("MicroMsg.LauncherUI", "KEVIN MainTabUI onCreate initLanguage: " + (System.currentTimeMillis() - currentTimeMillis2));
                    homeUI.myo = (LayoutInflater) homeUI.uQk.getSystemService("layout_inflater");
                    currentTimeMillis2 = System.currentTimeMillis();
                    homeUI.ipu = r.eC(homeUI.uQk).inflate(R.i.dhH, null);
                    w.d("MicroMsg.LauncherUI", "KEVIN MainTabUI onCreate inflater.inflate(R.layout.main_tab, null);" + (System.currentTimeMillis() - currentTimeMillis2));
                    homeUI.uQk.setContentView(homeUI.ipu);
                    Looper.myQueue().addIdleHandler(homeUI.uQB);
                    homeUI.uPY = true;
                    homeUI.uQu = (VoiceSearchLayout) homeUI.uQk.findViewById(R.h.cNA);
                    homeUI.uQu.xo(b.a(homeUI.uQk, 100.0f));
                    homeUI.uQc = (CustomViewPager) homeUI.uQk.findViewById(R.h.cqE);
                    homeUI.uQc.Cb(4);
                    if (homeUI.uQb != null) {
                        homeUI.uQb.a(null);
                        ((View) homeUI.uQb).setVisibility(8);
                    }
                    homeUI.uQc.DC = true;
                    homeUI.uQd = new HomeUI.c(homeUI, homeUI.uQk, homeUI.uQc);
                    c cVar = homeUI.uQb;
                    if (homeUI.uQb != null) {
                        homeUI.uQb.a(null);
                        ((View) homeUI.uQb).setVisibility(8);
                        ((ViewGroup) homeUI.uQc.getParent()).removeView((View) homeUI.uQb);
                    }
                    ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    Object launcherUIBottomTabView = new LauncherUIBottomTabView(homeUI.uQk);
                    ((ViewGroup) homeUI.uQc.getParent()).addView(launcherUIBottomTabView, layoutParams);
                    homeUI.uQb = launcherUIBottomTabView;
                    ((View) homeUI.uQb).setVisibility(0);
                    homeUI.uQb.a(homeUI.uQd);
                    if (!(cVar == null || cVar == homeUI.uQb)) {
                        homeUI.uQb.ke(cVar.bOD());
                        homeUI.uQb.kf(cVar.bOE());
                        homeUI.uQb.yV(cVar.bOz());
                        homeUI.uQb.yW(cVar.bOA());
                        homeUI.uQb.yX(cVar.bOB());
                        homeUI.uQb.yY(cVar.bOC());
                        homeUI.uQb.lJ(cVar.bOF());
                    }
                    homeUI.zb(0);
                    w.d("MicroMsg.LauncherUI", "KEVIN MainTabUI onCreate initView(); " + (System.currentTimeMillis() - currentTimeMillis2));
                    w.d("MicroMsg.LauncherUI", "KEVIN handleJump(getIntent()); " + (System.currentTimeMillis() - System.currentTimeMillis()));
                    long currentTimeMillis3 = System.currentTimeMillis();
                    if (!s.a(homeUI.uQk.getIntent(), "LauncherUI.enter_from_reg", false) && MMAppMgr.oK() && ap.zb() && ad.Pt("show_whatsnew")) {
                        w.i("MicroMsg.LauncherUI", "dz[showWhatsNewForResult from onMainTabCreate]");
                        d.b(homeUI.uQk, "whatsnew", ".ui.WhatsNewUI", new Intent(), 1);
                    }
                    com.tencent.mm.app.plugin.b.cV(3);
                    w.d("MicroMsg.LauncherUI", "KEVIN syncAddrBookAndUpload checkLastLbsroomAndQuitIt " + (System.currentTimeMillis() - currentTimeMillis3));
                    homeUI.bPA();
                    homeUI.Gx.show();
                    homeUI.ipu.post(new Runnable(homeUI) {
                        final /* synthetic */ HomeUI uRb;

                        {
                            this.uRb = r1;
                        }

                        public final void run() {
                            this.uRb.ajj();
                            ap.yY();
                            com.tencent.mm.u.c.vr().setInt(327947, this.uRb.Gx.getHeight());
                            w.i("MicroMsg.LauncherUI", "contentView.post then setFullScreenAfterSetContentView, padding: %s", Integer.valueOf(this.uRb.ipu.getPaddingTop()));
                            e.a(this.uRb.uQk, this.uRb.ipu);
                        }

                        public final String toString() {
                            return super.toString() + "|updateTitle";
                        }
                    });
                    w.v("MicroMsg.LauncherUI", "KEVIN MainTabUI onCreate : " + (System.currentTimeMillis() - currentTimeMillis));
                    af.f(new Runnable(homeUI) {
                        final /* synthetic */ HomeUI uRb;

                        {
                            this.uRb = r1;
                        }

                        public final void run() {
                            w.d("MicroMsg.LauncherUI", "onMainTabCreate, send refresh broadcast");
                            this.uRb.uQk.sendBroadcast(new Intent(ConstantsAPI.ACTION_REFRESH_WXAPP));
                        }

                        public final String toString() {
                            return super.toString() + "|sendBroadcast";
                        }
                    }, 2000);
                    homeUI.ipu.addOnLayoutChangeListener(new OnLayoutChangeListener(homeUI) {
                        final /* synthetic */ HomeUI uRb;

                        {
                            this.uRb = r1;
                        }

                        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                            w.i("MicroMsg.LauncherUI", "contentView.addOnLayoutChangeListener %s %s %s %s, %s %s %s %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
                        }
                    });
                    e.a(homeUI.uQk, homeUI.ipu);
                    homeUI.ipu.postDelayed(new Runnable(homeUI) {
                        final /* synthetic */ HomeUI uRb;

                        {
                            this.uRb = r1;
                        }

                        public final void run() {
                            w.i("MicroMsg.LauncherUI", "contentView.post, padding: %s", Integer.valueOf(this.uRb.ipu.getPaddingTop()));
                        }
                    }, 20);
                } else {
                    w.e("MicroMsg.LauncherUI", "mmcore has not ready, finish launcherui");
                    homeUI.uQk.finish();
                }
                ag(getIntent());
            }
            this.uRM.bPl();
            w.i("MicroMsg.LauncherUI", "resumeNormalJump");
            MMFragmentActivity.a.bQp();
            if ("pushcontent_notification".equals(s.i(getIntent(), "nofification_type")) && !u.mA(s.i(getIntent(), "Main_FromUserName"))) {
                w.e("MicroMsg.LauncherUI", "launch report, fromUserName = %s, msgType = %d" + s.i(getIntent(), "Main_FromUserName") + s.a(getIntent(), "MainUI_User_Last_Msg_Type", 0));
                g.oUh.i(10856, Integer.valueOf(r1), i, Integer.valueOf(0));
            }
            i = s.i(getIntent(), "LauncherUI.Shortcut.LaunchType");
            if (i != null) {
                if (i.equals("launch_type_voip")) {
                    w.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIP");
                    startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip"));
                    g.oUh.i(11034, Integer.valueOf(2), Integer.valueOf(0));
                } else if (i.equals("launch_type_voip_audio")) {
                    w.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIPAudio");
                    startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio"));
                    g.oUh.i(11034, Integer.valueOf(2), Integer.valueOf(1));
                }
            }
            i = s.i(getIntent(), "LauncherUI.switch.tab");
            if (!u.mA(i)) {
                this.uRM.SD(i);
                getIntent().putExtra("LauncherUI.switch.tab", "");
            }
            if (s.a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false) || this.uRR) {
                this.uRR = false;
                bPI = bPI();
                if (bPI != null) {
                    HomeUI homeUI2 = bPI.uRM;
                    ap.vL().bJh();
                    if (homeUI2.uPT) {
                        w.i("MicroMsg.LauncherUI", "remove setTagRunnable");
                        af.I(homeUI2.uQm);
                    }
                    af.v(homeUI2.uQT);
                }
                getIntent().putExtra("LauncherUI.From.Scaner.Shortcut", false);
                getIntent().putExtra("LauncherUI.switch.tab", "tab_find_friend");
            }
            z = s.a(getIntent(), "LauncherUI.From.Biz.Shortcut", false);
            if (z) {
                i2 = s.i(getIntent(), "LauncherUI.Shortcut.Username");
            } else {
                z = s.a(getIntent(), "LauncherUI_From_Biz_Shortcut", false);
                i2 = getIntent().getAction();
            }
            if (z) {
                w.d("MicroMsg.LauncherUI", "launch, fromBizShortcut, bizUsername = " + i2);
                if (!u.mA(i2)) {
                    i2 = com.tencent.mm.plugin.base.model.c.rP(i2);
                    if (!u.mA(i2)) {
                        if (com.tencent.mm.u.o.eU(i2)) {
                            w.d("MicroMsg.LauncherUI", "launch, username is contact, go to chattingui");
                            if (!com.tencent.mm.modelbiz.e.hZ(i2)) {
                                bPI = bPI();
                                if (bPI != null) {
                                    bPI.a(i2, null, false);
                                }
                            } else if (com.tencent.mm.modelbiz.e.dr(i2)) {
                                intent = new Intent();
                                intent.setClassName(this, "com.tencent.mm.ui.bizchat.BizChatConversationUI");
                                intent.putExtra("Contact_User", i2);
                                intent.putExtra("biz_chat_from_scene", 9);
                                intent.addFlags(67108864);
                                startActivity(intent);
                            } else if (com.tencent.mm.modelbiz.e.ib(i2)) {
                                intent = new Intent();
                                intent.setClassName(this, "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
                                intent.putExtra("enterprise_biz_name", i2);
                                intent.putExtra("enterprise_biz_display_name", n.eK(i2));
                                startActivity(intent);
                            } else if (com.tencent.mm.modelbiz.e.ic(i2)) {
                                BizInfo hW = com.tencent.mm.modelbiz.e.hW(i2);
                                i = hW == null ? null : hW.CL();
                                if (i == null) {
                                    i = "";
                                }
                                Intent intent2 = new Intent();
                                intent2.putExtra("rawUrl", i);
                                intent2.putExtra("useJs", true);
                                intent2.putExtra("srcUsername", i2);
                                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                                intent2.addFlags(67108864);
                                d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
                            } else {
                                bPI = bPI();
                                Bundle bundle = new Bundle();
                                bundle.putInt("chat_from_scene", 3);
                                bPI.a(i2, bundle, false);
                            }
                        }
                        getIntent().putExtra("LauncherUI_From_Biz_Shortcut", false);
                        getIntent().putExtra("LauncherUI.From.Biz.Shortcut", false);
                    }
                }
            }
            this.uRQ = true;
            return;
        }
        w.i("MicroMsg.LauncherUI", "doOnResumeImp resumeLogoutJump");
        w.i("MicroMsg.LauncherUI", "resumeLogoutJump");
        MMFragmentActivity.a.bQp();
        i = ao.hlW.A("login_user_name", "");
        if (ap.za() || !i.equals("")) {
            f.sa(8);
            com.tencent.mm.kernel.b vH = h.vH();
            vH.gXC.a(new bb(new bb.a(vH) {
                final /* synthetic */ b gXG;

                {
                    this.gXG = r1;
                }

                public final void a(com.tencent.mm.network.e eVar) {
                    if (eVar != null && eVar.Cc() != null) {
                        eVar.Cc().reset();
                    }
                }
            }, "reset accinfo"), 0);
            w.i("MicroMsg.LauncherUI", "resumeLogoutJump hasDoInit:%b needResetLaunchUI:%b formNotification:%b, ishold:%b", Boolean.valueOf(this.uRP), Boolean.valueOf((this.fNO.getFlags() & 67108864) == 67108864), Boolean.valueOf(s.a(this.fNO, "Intro_Notify", false)), Boolean.valueOf(ap.uP()));
            ap.hold();
            com.tencent.mm.sdk.b.a.urY.m(new com.tencent.mm.e.a.w());
            if (ap.zb()) {
                h.vJ().eh("[" + this.uRP + " " + z + " " + r1 + "]");
            }
            if (s.a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
                this.uRR = true;
            }
            if (s.a(this.fNO, "Intro_Switch", false) || (ap.uP() && this.uRP)) {
                w.appenderClose();
                BaseEvent.onSingalCrash(0);
                finish();
                intent = new Intent(this, LauncherUI.class);
                intent.addFlags(67108864);
                startActivity(intent);
                ap.unhold();
                w.i("MicroMsg.LauncherUI", "checktask ConstantsUI.Intro.KSwitch kill myself.");
                w.bIP();
                ap.unhold();
                Process.killProcess(Process.myPid());
            } else {
                if (ao.hlW.A("login_user_name", "").equals("")) {
                    View welcomeSelectView = new WelcomeSelectView(this);
                    setContentView(welcomeSelectView);
                    welcomeSelectView.bRn();
                } else {
                    int PY = bg.PY(ao.hlW.A("last_login_use_voice", ""));
                    w.i("MicroMsg.LauncherUI", "pluginSwitch  " + PY);
                    if ((PY & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                        startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.account.LoginVoiceUI"));
                    } else {
                        startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.account.LoginPasswordUI"));
                    }
                    com.tencent.mm.ui.base.b.eL(this);
                }
                f.sa(8);
            }
            ap.unhold();
        }
    }

    private boolean bPL() {
        if (this.fNO != null && (s.a(this.fNO, "absolutely_exit", false) || s.a(this.fNO, "absolutely_exit_pid", 0) == Process.myPid())) {
            w.w("MicroMsg.LauncherUI", "launcherOnResume exit absolutely!!!");
            finish();
            f.sa(8);
            MMAppMgr.kv(s.a(this.fNO, "kill_service", true));
            return true;
        } else if (this.fNO == null || !s.a(this.fNO, "can_finish", false)) {
            return false;
        } else {
            w.i("MicroMsg.LauncherUI", "exit obviously");
            ap.vd().aW(true);
            if (k.aK(getApplicationContext())) {
                Context applicationContext = getApplicationContext();
                applicationContext.stopService(new Intent(applicationContext, CoreService.class));
            }
            f.sa(8);
            sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_FORCE_DEACTIVE"), WXApp.WXAPP_BROADCAST_PERMISSION);
            finish();
            com.tencent.mm.ui.base.b.eN(this);
            return true;
        }
    }

    private void ag(Intent intent) {
        w.i("MicroMsg.LauncherUI", "handleJump");
        if (ap.zb()) {
            com.tencent.mm.sdk.b.b ifVar = new if();
            ifVar.fNN.fNO = this.fNO;
            com.tencent.mm.sdk.b.a.urY.m(ifVar);
            String i;
            if ("talkroom_notification".equals(s.i(intent, "nofification_type"))) {
                i = s.i(intent, "enter_chat_usrname");
                if (!u.mA(i)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("enter_room_username", i);
                    intent2.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    d.b((Context) this, "talkroom", ".ui.TalkRoomUI", intent2);
                    return;
                }
                return;
            } else if ("back_to_pcmgr_notification".equals(intent.getStringExtra("nofification_type"))) {
                if (intent.getBooleanExtra("newPCBackup", true)) {
                    w.i("MicroMsg.LauncherUI", "summerbak jump BackupPcUI");
                    r0 = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
                } else {
                    w.i("MicroMsg.LauncherUI", "summerbak jump BakToPcUI");
                    r0 = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI");
                }
                r0.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                MMWizardActivity.z(this, r0);
                return;
            } else if ("back_to_pcmgr_error_notification".equals(intent.getStringExtra("nofification_type"))) {
                r0 = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI");
                r0.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                MMWizardActivity.z(this, r0);
                return;
            } else if ("backup_move_notification".equals(intent.getStringExtra("nofification_type"))) {
                r0 = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
                r0.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                MMWizardActivity.z(this, r0);
                return;
            } else {
                int a;
                boolean a2;
                LauncherUI bPI;
                Bundle bundle;
                if (s.a(intent, "show_update_dialog", false)) {
                    a = s.a(intent, "update_type", -1);
                    if (a == -1) {
                        w.e("MicroMsg.LauncherUI", "showUpdateDialog is true, but updateType is -1");
                    } else {
                        g.oUh.a(405, 28, 1, true);
                        if (y.bCs() != null) {
                            t a3 = y.bCs().a(this, null);
                            if (a3 != null) {
                                g.oUh.a(405, a == 2 ? 29 : 30, 1, true);
                                a3.update(a);
                            }
                        }
                    }
                }
                String i2 = s.i(intent, "Main_User");
                if (!(i2 == null || i2.equals(""))) {
                    ap.yY();
                    aj Rm = com.tencent.mm.u.c.wW().Rm(i2);
                    if (Rm != null) {
                        a = Rm.field_unReadCount;
                        if (a == 0) {
                            a = s.a(intent, "pushcontent_unread_count", 0);
                        }
                        MMAppMgr.ox();
                        com.tencent.mm.sdk.b.a.urY.m(new ab());
                        this.uRM.zb(0);
                        a2 = s.a(intent, "Intro_Is_Muti_Talker", true);
                        w.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", Boolean.valueOf(a2), Integer.valueOf(a));
                        if (!a2 && a > 0 && s.a(intent, "Intro_Bottle_unread_count", 0) > 0) {
                            w.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", Integer.valueOf(s.a(intent, "Intro_Bottle_unread_count", 0)));
                            d.w(this, "bottle", ".ui.BottleConversationUI");
                        }
                        if (!a2 || a <= 0) {
                            if (s.a(intent, "From_fail_notify", false)) {
                                if (s.a(intent, "biz_chat_need_to_jump_to_chatting_ui", false)) {
                                    this.uRM.zb(0);
                                } else if (bPI() != null && com.tencent.mm.modelbiz.e.dr(i2)) {
                                    intent.putExtra("Contact_User", i2);
                                    intent.addFlags(67108864);
                                    d.a((Context) this, ".ui.bizchat.BizChatConversationUI", intent);
                                }
                            } else if (!u.mA(i2)) {
                                bPI = bPI();
                                if (bPI != null) {
                                    bundle = new Bundle();
                                    bundle.putBoolean("Chat_Mode", s.a(intent, "resend_fail_messages", false));
                                    if (com.tencent.mm.modelbiz.e.dr(i2)) {
                                        bPI.a(i2, bundle, false);
                                    } else {
                                        intent.putExtra("Contact_User", i2);
                                        intent.addFlags(67108864);
                                        intent.putExtra("biz_chat_from_scene", 4);
                                        d.a((Context) this, ".ui.bizchat.BizChatConversationUI", intent);
                                    }
                                }
                            } else if (s.a(intent, "jump_sns_from_notify", false)) {
                                r0 = new Intent();
                                r0.addFlags(67108864);
                                r0.putExtra("is_need_resend_sns", intent.getBooleanExtra("is_need_resend_sns", false));
                                r0.putExtra("sns_resume_state", intent.getBooleanExtra("sns_resume_state", false));
                                r0.putExtra("sns_timeline_NeedFirstLoadint", intent.getBooleanExtra("sns_timeline_NeedFirstLoadint", false));
                                d.b((Context) this, "sns", ".ui.En_424b8e16", r0);
                            }
                        } else if (com.tencent.mm.u.o.fl(i2)) {
                            w.i("MicroMsg.LauncherUI", "handleJump, isReaderAppNewsHelper");
                            r0 = new Intent();
                            r0.addFlags(67108864);
                            r0.putExtra(Columns.TYPE, 20);
                            d.b((Context) this, "readerapp", ".ui.ReaderAppUI", r0);
                        } else if (com.tencent.mm.u.o.ft(i2)) {
                            w.i("MicroMsg.LauncherUI", "handleJump, isReaderAppWeiboHelper");
                            r0 = new Intent();
                            r0.addFlags(67108864);
                            r0.putExtra(Columns.TYPE, 11);
                            d.b((Context) this, "readerapp", ".ui.ReaderAppUI", r0);
                        } else {
                            if (intent.getIntExtra("MainUI_User_Last_Msg_Type", 34) == 34) {
                                a = 2;
                            } else {
                                a = 1;
                            }
                            bundle = new Bundle();
                            bundle.putInt("Chat_Mode", a);
                            if ("new_msg_nofification".equals(s.i(intent, "nofification_type"))) {
                                bundle.putInt("chat_from_scene", 1);
                            }
                            bPI = bPI();
                            if (bPI != null) {
                                if (com.tencent.mm.modelbiz.e.dr(i2)) {
                                    intent.putExtra("Contact_User", i2);
                                    intent.addFlags(67108864);
                                    intent.putExtra("biz_chat_from_scene", 4);
                                    d.a((Context) this, ".ui.bizchat.BizChatConversationUI", intent);
                                } else if (com.tencent.mm.modelbiz.e.ic(i2)) {
                                    BizInfo hW = com.tencent.mm.modelbiz.e.hW(i2);
                                    i = hW == null ? null : hW.CL();
                                    if (i == null) {
                                        i = "";
                                    }
                                    intent.putExtra("rawUrl", i);
                                    intent.putExtra("useJs", true);
                                    intent.putExtra("srcUsername", i2);
                                    intent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                                    intent.addFlags(67108864);
                                    d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
                                } else if (x.em(i2)) {
                                    intent.putExtra("Contact_User", i2);
                                    intent.addFlags(67108864);
                                    intent.putExtra("app_brand_conversation_from_scene", 3);
                                    intent.putExtra("finish_direct", true);
                                    intent.putExtra("key_need_send_video", false);
                                    d.a((Context) this, ".ui.conversation.AppBrandServiceConversationUI", intent);
                                } else {
                                    bPI.a(i2, bundle, false);
                                }
                            }
                        }
                        if (s.a(intent, "kstyle_show_bind_mobile_afterauth", 0) > 0) {
                            r0 = new Intent();
                            r0.setClassName(this, "com.tencent.mm.ui.account.bind.BindMobileUI");
                            r0.putExtra("kstyle_bind_recommend_show", intent.getIntExtra("kstyle_bind_recommend_show", 0));
                            r0.putExtra("kstyle_bind_wording", intent.getParcelableExtra("kstyle_bind_wording"));
                            MMWizardActivity.z(this, r0);
                            return;
                        }
                        return;
                    }
                }
                a = 0;
                if (a == 0) {
                    a = s.a(intent, "pushcontent_unread_count", 0);
                }
                MMAppMgr.ox();
                com.tencent.mm.sdk.b.a.urY.m(new ab());
                this.uRM.zb(0);
                a2 = s.a(intent, "Intro_Is_Muti_Talker", true);
                w.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", Boolean.valueOf(a2), Integer.valueOf(a));
                w.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", Integer.valueOf(s.a(intent, "Intro_Bottle_unread_count", 0)));
                d.w(this, "bottle", ".ui.BottleConversationUI");
                if (a2) {
                }
                if (s.a(intent, "From_fail_notify", false)) {
                    if (s.a(intent, "biz_chat_need_to_jump_to_chatting_ui", false)) {
                        this.uRM.zb(0);
                    } else {
                        intent.putExtra("Contact_User", i2);
                        intent.addFlags(67108864);
                        d.a((Context) this, ".ui.bizchat.BizChatConversationUI", intent);
                    }
                } else if (!u.mA(i2)) {
                    bPI = bPI();
                    if (bPI != null) {
                        bundle = new Bundle();
                        bundle.putBoolean("Chat_Mode", s.a(intent, "resend_fail_messages", false));
                        if (com.tencent.mm.modelbiz.e.dr(i2)) {
                            bPI.a(i2, bundle, false);
                        } else {
                            intent.putExtra("Contact_User", i2);
                            intent.addFlags(67108864);
                            intent.putExtra("biz_chat_from_scene", 4);
                            d.a((Context) this, ".ui.bizchat.BizChatConversationUI", intent);
                        }
                    }
                } else if (s.a(intent, "jump_sns_from_notify", false)) {
                    r0 = new Intent();
                    r0.addFlags(67108864);
                    r0.putExtra("is_need_resend_sns", intent.getBooleanExtra("is_need_resend_sns", false));
                    r0.putExtra("sns_resume_state", intent.getBooleanExtra("sns_resume_state", false));
                    r0.putExtra("sns_timeline_NeedFirstLoadint", intent.getBooleanExtra("sns_timeline_NeedFirstLoadint", false));
                    d.b((Context) this, "sns", ".ui.En_424b8e16", r0);
                }
                if (s.a(intent, "kstyle_show_bind_mobile_afterauth", 0) > 0) {
                    r0 = new Intent();
                    r0.setClassName(this, "com.tencent.mm.ui.account.bind.BindMobileUI");
                    r0.putExtra("kstyle_bind_recommend_show", intent.getIntExtra("kstyle_bind_recommend_show", 0));
                    r0.putExtra("kstyle_bind_wording", intent.getParcelableExtra("kstyle_bind_wording"));
                    MMWizardActivity.z(this, r0);
                    return;
                }
                return;
            }
        }
        w.i("MicroMsg.LauncherUI", "handleJump not accHhasReady");
        startActivity(new Intent(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864));
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z;
        super.onActivityResult(i, i2, intent);
        w.v("MicroMsg.LauncherUI", "edw on activity result");
        HomeUI homeUI = this.uRM;
        if (i == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN && homeUI.uQM != null) {
            homeUI.uQM.onActivityResult(i, i2, intent);
        }
        w.w("MicroMsg.LauncherUI", "check request code %d", Integer.valueOf(65535 & i));
        switch (65535 & i) {
            case com.tencent.mm.plugin.appbrand.jsapi.e.b.CTRL_INDEX /*217*/:
            case 218:
            case com.tencent.mm.plugin.appbrand.jsapi.n.CTRL_INDEX /*226*/:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z && homeUI.uQM == null) {
            w.i("MicroMsg.LauncherUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
            af.I(homeUI.uQt);
            homeUI.uQt.uRz = 0;
            homeUI.uQt.fFR = i;
            homeUI.uQt.aMA = i2;
            homeUI.uQt.fFS = intent;
            af.v(homeUI.uQt);
        } else if (!homeUI.uPU) {
        } else {
            if (i == 1) {
                ap.yY();
                if (!bg.f((Boolean) com.tencent.mm.u.c.vr().get(12323, null))) {
                    m.a(homeUI.uQk, null, false, 3);
                }
            } else if (i == 65534 && i2 == -1) {
                ad.Pu("welcome_page_show");
                k.e(homeUI.uQk, true);
                MMAppMgr.ox();
                MMAppMgr.a(homeUI.uQk, true);
                homeUI.uQk.finish();
            }
        }
    }

    protected void onPause() {
        w.d("MicroMsg.LauncherUI", "onPause, chatting is show ");
        super.onPause();
        q bPM = bPM();
        HomeUI homeUI = this.uRM;
        com.tencent.mm.sdk.a.b.aX(false);
        homeUI.uQj = a.ACTIVITY_PAUSE;
        if (!ap.yQ()) {
            ap.getNotification().aw(false);
        }
        boolean isShown = homeUI.uQN != null ? homeUI.uQN.isShown() : false;
        w.i("MicroMsg.LauncherUI", "edw onPause, chatting is show " + isShown);
        com.tencent.mm.sdk.f.e.post(new AnonymousClass53(homeUI, isShown), "directReport_onPause");
        if (!homeUI.uQk.isFinishing()) {
            j.a(homeUI.uQk);
        }
        if (homeUI.uPU) {
            w.d("MicroMsg.LauncherUI", "KEVIN MainTabUI onMainTabPause");
            if (WorkerProfile.oC().oD()) {
                homeUI.bPv();
                if (ap.zb()) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().b(homeUI.uQx);
                    ap.yY();
                    com.tencent.mm.u.c.wW().b(homeUI);
                    com.tencent.mm.q.c.uk().b(homeUI.uQw);
                    com.tencent.mm.sdk.b.a.urY.c(homeUI.uQv);
                    com.tencent.mm.sdk.b.a.urY.c(homeUI.uQy);
                    com.tencent.mm.sdk.b.a.urY.c(homeUI.uPy);
                }
            }
        }
        if (homeUI.uQe != null && homeUI.uQe.isShowing()) {
            homeUI.uQe.dismiss();
        }
        if (homeUI.uQM != null && homeUI.uQM.bQi()) {
            homeUI.uQM.uUD.mEnable = false;
        }
        w.v("MicroMsg.LauncherUI", "KEVIN Launcher onPause %d", Integer.valueOf(homeUI.lCS));
        if (homeUI.uPV != null) {
            ap.vd().b(255, homeUI.uPV);
            ap.vd().b(384, homeUI.uPV);
            homeUI.uPV = null;
        }
        if (WorkerProfile.oC().oD() && bPM == null) {
            this.uRQ = false;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Object obj;
        j jVar = this.uRN;
        if (iArr != null && iArr.length > 0) {
            w.i("MicroMsg.LauncherUICheckPermissionHelper", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
            int i2;
            switch (i) {
                case 32:
                case 64:
                case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*96*/:
                    i2 = R.l.eFL;
                    if (i == 96) {
                        i2 = R.l.eFK;
                    } else if (i == 64) {
                        i2 = R.l.eFI;
                    }
                    if (iArr[0] == 0) {
                        if (i == 32) {
                            com.tencent.mm.plugin.report.c.oTb.a(462, 0, 1, true);
                        } else if (i == 96) {
                            com.tencent.mm.plugin.report.c.oTb.a(462, 1, 1, true);
                        } else {
                            com.tencent.mm.plugin.report.c.oTb.a(462, 2, 1, true);
                        }
                        if (jVar.uSz != null) {
                            jVar.uSz.run();
                        }
                    } else {
                        com.tencent.mm.ui.base.g.a((Context) this, getString(i2), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new com.tencent.mm.ui.j.AnonymousClass2(jVar, i, this), new AnonymousClass3(jVar, i, this));
                    }
                    obj = 1;
                    break;
                case 33:
                case 70:
                case PlayerException.EXCEPTION_IN_RELEASE /*97*/:
                    i2 = R.l.eFL;
                    if (i == 97) {
                        i2 = R.l.eFK;
                    } else if (i == 70) {
                        i2 = R.l.eFI;
                    }
                    if (iArr[0] != 0) {
                        jVar.oIa = false;
                        com.tencent.mm.ui.base.g.a((Context) this, getString(i2), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new AnonymousClass4(jVar, i, this), new AnonymousClass5(jVar, i, this));
                    } else if (i == 33) {
                        com.tencent.mm.plugin.report.c.oTb.a(462, 9, 1, true);
                    } else if (i == 97) {
                        com.tencent.mm.plugin.report.c.oTb.a(462, 10, 1, true);
                    } else {
                        com.tencent.mm.plugin.report.c.oTb.a(462, 11, 1, true);
                    }
                    obj = 1;
                    break;
                default:
                    obj = null;
                    break;
            }
        }
        String str = "MicroMsg.LauncherUICheckPermissionHelper";
        String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = strArr;
        objArr[3] = bg.bJZ();
        w.w(str, str2, objArr);
        af.f(new Runnable(jVar) {
            final /* synthetic */ j uSA;

            {
                this.uSA = r1;
            }

            public final void run() {
                if (this.uSA.uSz != null) {
                    this.uSA.uSz.run();
                }
            }

            public final String toString() {
                return super.toString() + "|onInitDelay";
            }
        }, 500);
        obj = 1;
        if (obj == null) {
            HomeUI homeUI = this.uRM;
            int i3;
            switch (i) {
                case 16:
                case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                    i3 = i == 80 ? R.l.eFJ : R.l.eFG;
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.g.a(homeUI.uQk, homeUI.getString(i3), homeUI.getString(R.l.eFM), homeUI.getString(R.l.evw), homeUI.getString(R.l.cancel), false, new OnClickListener(homeUI) {
                            final /* synthetic */ HomeUI uRb;

                            {
                                this.uRb = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                this.uRb.uQk.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            }
                        }, new OnClickListener(homeUI) {
                            final /* synthetic */ HomeUI uRb;

                            {
                                this.uRb = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        return;
                    }
                    return;
                case 18:
                    if (iArr[0] != 0) {
                        i3 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.eFG : R.l.eFJ;
                        if (iArr[0] != 0) {
                            com.tencent.mm.ui.base.g.a(homeUI.uQk, homeUI.getString(i3), homeUI.getString(R.l.eFM), homeUI.getString(R.l.evw), homeUI.getString(R.l.cancel), false, new OnClickListener(homeUI) {
                                final /* synthetic */ HomeUI uRb;

                                {
                                    this.uRb = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    this.uRb.uQk.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                }
                            }, new OnClickListener(homeUI) {
                                final /* synthetic */ HomeUI uRb;

                                {
                                    this.uRb = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            return;
                        }
                        return;
                    } else if (homeUI.uQM != null) {
                        homeUI.uQM.bWi();
                        return;
                    } else {
                        return;
                    }
                case 19:
                case 21:
                case 22:
                    if (iArr[0] != 0) {
                        i3 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.eFG : R.l.eFJ;
                        if (iArr[0] != 0) {
                            com.tencent.mm.ui.base.g.a(homeUI.uQk, homeUI.getString(i3), homeUI.getString(R.l.eFM), homeUI.getString(R.l.evw), homeUI.getString(R.l.cancel), false, new OnClickListener(homeUI) {
                                final /* synthetic */ HomeUI uRb;

                                {
                                    this.uRb = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    this.uRb.uQk.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                }
                            }, new OnClickListener(homeUI) {
                                final /* synthetic */ HomeUI uRb;

                                {
                                    this.uRb = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            return;
                        }
                        return;
                    } else if (homeUI.uQM == null) {
                        return;
                    } else {
                        if (i == 19) {
                            homeUI.uQM.aTG();
                            return;
                        } else if (i == 21) {
                            homeUI.uQM.bUj();
                            return;
                        } else {
                            homeUI.uQM.bUh();
                            return;
                        }
                    }
                case 20:
                    if (iArr[0] == 0) {
                        homeUI.uQM.bUl();
                        return;
                    } else {
                        com.tencent.mm.ui.base.g.a(homeUI.uQk, homeUI.getString(R.l.eFG), homeUI.getString(R.l.eFM), homeUI.getString(R.l.evw), homeUI.getString(R.l.cancel), false, new OnClickListener(homeUI) {
                            final /* synthetic */ HomeUI uRb;

                            {
                                this.uRb = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.uRb.uQk.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            }
                        }, null);
                        return;
                    }
                case 65:
                    if (iArr[0] == 0) {
                        homeUI.bPr();
                        return;
                    } else {
                        com.tencent.mm.ui.base.g.a(homeUI.uQk, homeUI.getString(R.l.eFI), homeUI.getString(R.l.eFM), homeUI.getString(R.l.evw), homeUI.getString(R.l.cancel), false, new OnClickListener(homeUI) {
                            final /* synthetic */ HomeUI uRb;

                            {
                                this.uRb = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.uRb.uQk.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            }
                        }, null);
                        return;
                    }
                case 66:
                    if (iArr[0] == 0) {
                        q zc = homeUI.zc(homeUI.lCS);
                        if (zc instanceof g) {
                            ((g) zc).bPf();
                            return;
                        }
                        return;
                    }
                    com.tencent.mm.ui.base.g.a(homeUI.uQk, homeUI.getString(R.l.eFI), homeUI.getString(R.l.eFM), homeUI.getString(R.l.evw), homeUI.getString(R.l.cancel), false, new OnClickListener(homeUI) {
                        final /* synthetic */ HomeUI uRb;

                        {
                            this.uRb = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.uRb.uQk.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                case 67:
                case bl.CTRL_INDEX /*68*/:
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.g.a(homeUI.uQk, homeUI.getString(R.l.eFI), homeUI.getString(R.l.eFM), homeUI.getString(R.l.evw), homeUI.getString(R.l.cancel), false, new OnClickListener(homeUI) {
                            final /* synthetic */ HomeUI uRb;

                            {
                                this.uRb = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.uRb.uQk.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            }
                        }, null);
                        return;
                    } else if (i == 67) {
                        homeUI.uQM.bVM();
                        return;
                    } else {
                        homeUI.uQM.bVN();
                        return;
                    }
                case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_NATIVE_DATASOURCE /*81*/:
                    if (iArr[0] == 0) {
                        homeUI.uQM.bUk();
                        return;
                    } else {
                        com.tencent.mm.ui.base.g.a(homeUI.uQk, homeUI.getString(R.l.eFI), homeUI.getString(R.l.eFM), homeUI.getString(R.l.evw), homeUI.getString(R.l.cancel), false, new OnClickListener(homeUI) {
                            final /* synthetic */ HomeUI uRb;

                            {
                                this.uRb = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.uRb.uQk.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            }
                        }, null);
                        return;
                    }
                case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                case cn.CTRL_INDEX /*83*/:
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.g.a(homeUI.uQk, homeUI.getString(R.l.eFJ), homeUI.getString(R.l.eFM), homeUI.getString(R.l.evw), homeUI.getString(R.l.cancel), false, new OnClickListener(homeUI) {
                            final /* synthetic */ HomeUI uRb;

                            {
                                this.uRb = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.uRb.uQk.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            }
                        }, null);
                        return;
                    } else if (i == 82) {
                        homeUI.uQM.aTF();
                        return;
                    } else {
                        homeUI.uQM.bUi();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        HomeUI homeUI = this.uRM;
        com.tencent.mm.sdk.b.a.urY.c(homeUI.uQE);
        com.tencent.mm.sdk.b.a.urY.c(homeUI.uQH);
        com.tencent.mm.sdk.b.a.urY.c(homeUI.uQG);
        af.I(homeUI.uQS);
        Looper.myQueue().removeIdleHandler(homeUI.uQA);
        if (homeUI.uPU) {
            Looper.myQueue().removeIdleHandler(homeUI.uQB);
        }
        if (homeUI.uQu != null) {
            homeUI.uQu.sLB = null;
        }
        homeUI.uRa.clear();
        bPJ();
        w.i("MicroMsg.LauncherUI", "checktask onDestroy 0x%x, taskid %d, task:%s, instancesize %d", Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bg.eq(this), Integer.valueOf(uRJ.size()));
        i.oj().fwr.remove(this);
    }

    public void finish() {
        super.finish();
        bPJ();
        w.i("MicroMsg.LauncherUI", "checktask Launcherui onfinish 0x%x,instance size %d, stack: %s", Integer.valueOf(hashCode()), Integer.valueOf(uRJ.size()), bg.bJZ());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void O(float r10) {
        /*
        r9 = this;
        r1 = 1;
        r0 = 0;
        r8 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = r9.uRM;
        r3 = "MicroMsg.LauncherUI";
        r4 = "ashutest::on swipe %f, duration %d, status %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];
        r6 = java.lang.Float.valueOf(r10);
        r5[r0] = r6;
        r6 = 240; // 0xf0 float:3.36E-43 double:1.186E-321;
        r6 = java.lang.Long.valueOf(r6);
        r5[r1] = r6;
        r6 = 2;
        r7 = r2.uQj;
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.w.v(r3, r4, r5);
        r3 = r2.bPF();
        if (r3 != 0) goto L_0x0032;
    L_0x002b:
        r0 = r1;
    L_0x002c:
        if (r0 != 0) goto L_0x0031;
    L_0x002e:
        super.O(r10);
    L_0x0031:
        return;
    L_0x0032:
        r3 = com.tencent.mm.ui.HomeUI.a.ACTIVITY_RESUME;
        r4 = r2.uQj;
        if (r3 == r4) goto L_0x0062;
    L_0x0038:
        r1 = java.lang.Float.compare(r8, r10);
        if (r1 > 0) goto L_0x002c;
    L_0x003e:
        r1 = r2.uQk;
        r2 = com.tencent.mm.R.h.caQ;
        r1 = r1.findViewById(r2);
        r2 = java.lang.Float.compare(r8, r10);
        if (r2 > 0) goto L_0x0051;
    L_0x004c:
        r2 = 0;
        com.tencent.mm.ui.tools.j.n(r1, r2);
        goto L_0x002c;
    L_0x0051:
        r2 = r1.getWidth();
        r2 = r2 / 4;
        r2 = (float) r2;
        r3 = r8 - r10;
        r2 = r2 * r3;
        r3 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r2 = r2 * r3;
        com.tencent.mm.ui.tools.j.n(r1, r2);
        goto L_0x002c;
    L_0x0062:
        r0 = r1;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.LauncherUI.O(float):void");
    }

    public final void d(boolean z, int i) {
        int i2;
        long j = 120;
        HomeUI homeUI = this.uRM;
        w.v("MicroMsg.LauncherUI", "ashutest: on settle %B, speed %d, status %s", Boolean.valueOf(z), Integer.valueOf(i), homeUI.uQj);
        if (homeUI.bPF()) {
            if (a.ACTIVITY_RESUME != homeUI.uQj) {
                i2 = 0;
                if (i2 == 0) {
                    super.d(z, i);
                }
            }
            View findViewById = homeUI.uQk.findViewById(R.h.caQ);
            if (z) {
                if (i <= 0) {
                    j = 240;
                }
                com.tencent.mm.ui.tools.j.a(findViewById, j, 0.0f, 0.125f);
            } else {
                if (i <= 0) {
                    j = 240;
                }
                com.tencent.mm.ui.tools.j.a(findViewById, j, (float) ((findViewById.getWidth() * -1) / 4), 0.75f);
            }
        }
        i2 = 1;
        if (i2 == 0) {
            super.d(z, i);
        }
    }

    public final boolean VJ() {
        return HomeUI.VJ();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i = 3;
        HomeUI homeUI = this.uRM;
        w.i("MicroMsg.LauncherUI", "ui group onKeyDown, code:%d action:%d", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()));
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            af.I(homeUI.uQS);
        }
        boolean z;
        if (homeUI.uQM == null || !homeUI.uQM.hML) {
            if (keyEvent.getKeyCode() == 25 && keyEvent.getAction() == 0 && ap.zb()) {
                if (!com.tencent.mm.am.b.HJ()) {
                    i = 5;
                }
                ap.yZ().ec(i);
                i = 1;
            } else if (keyEvent.getKeyCode() == 24 && keyEvent.getAction() == 0 && ap.zb()) {
                if (!com.tencent.mm.am.b.HJ()) {
                    i = 5;
                }
                ap.yZ().eb(i);
                i = 1;
            } else if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && homeUI.uQe != null && homeUI.uQe.isShowing()) {
                homeUI.uQe.dismiss();
                i = 1;
            } else if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 1) {
                homeUI.bPp();
                i = 1;
            } else if (homeUI.uQd != null && keyEvent.getAction() == 0 && ((q) homeUI.uQd.I(homeUI.uQc.ys)).onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
                i = 1;
            } else {
                if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
                    if (i.oj().fwm) {
                        i = 1;
                    } else if (homeUI.uQu == null || homeUI.uQu.getVisibility() != 0) {
                        if (ap.zb() && h.vG().gXp && am.isWap(homeUI.uQk)) {
                            Context context = homeUI.uQk;
                            OnClickListener anonymousClass33 = new OnClickListener(homeUI) {
                                final /* synthetic */ HomeUI uRb;

                                {
                                    this.uRb = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.uRb.bOs();
                                }
                            };
                            if (ap.zb()) {
                                ap.yY();
                                int intValue = ((Integer) com.tencent.mm.u.c.vr().get(65, Integer.valueOf(0))).intValue();
                                if (intValue >= 5) {
                                    z = false;
                                } else if (ad.Pt("show_wap_adviser")) {
                                    View inflate = View.inflate(context, R.i.dkh, null);
                                    ((TextView) inflate.findViewById(R.h.cnc)).setText(R.l.eDw);
                                    com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
                                    aVar.zW(R.l.dIO);
                                    aVar.dd(inflate);
                                    aVar.zZ(R.l.dHT).a(new AnonymousClass9(intValue));
                                    aVar.kK(false);
                                    aVar.Aa(R.l.eDt).b(new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            ap.yY();
                                            com.tencent.mm.u.c.vr().set(65, Integer.valueOf(5));
                                        }
                                    });
                                    aVar.a(new AnonymousClass11(anonymousClass33));
                                    aVar.WJ().show();
                                    z = true;
                                } else {
                                    z = false;
                                }
                            } else {
                                z = false;
                            }
                            if (z) {
                                i = 1;
                            }
                        }
                        int backgroundLimitType = am.getBackgroundLimitType(homeUI.uQk);
                        if (ap.zb() && h.vG().gXp && am.isLimited(backgroundLimitType)) {
                            ap.yY();
                            if (bg.e((Boolean) com.tencent.mm.u.c.vr().get(16385, null)) && MMAppMgr.a(homeUI.uQk, backgroundLimitType, new AnonymousClass35(homeUI, backgroundLimitType), new OnClickListener(homeUI) {
                                final /* synthetic */ HomeUI uRb;

                                {
                                    this.uRb = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.uRb.bOs();
                                }
                            })) {
                                i = 1;
                            }
                        }
                        homeUI.bOs();
                    } else {
                        homeUI.uQu.bEN();
                        i = 1;
                    }
                }
                z = false;
            }
        } else if (homeUI.uQM.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            i = 1;
        } else {
            z = false;
        }
        if (i != 0) {
            return true;
        }
        try {
            return super.dispatchKeyEvent(keyEvent);
        } catch (Throwable e) {
            w.w("MicroMsg.LauncherUI", "dispatch key event catch exception %s", e.getMessage());
            w.printErrStackTrace("MicroMsg.LauncherUI", e, "", new Object[0]);
            return false;
        }
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.uRM.uQz = bundle.getString("last_restore_talker");
        w.d("MicroMsg.LauncherUI", "onRestoreInstantceState:%s", r0.uQz);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        HomeUI homeUI = this.uRM;
        if (homeUI.uQM != null && !bg.mA(homeUI.uQM.bUg())) {
            w.d("MicroMsg.LauncherUI", "onSaveInstanceState:%s", homeUI.uQM.bUg());
            bundle.putString("last_restore_talker", homeUI.uQM.bUg());
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int i = 0;
        HomeUI homeUI = this.uRM;
        if ((homeUI.uQk.bPM() == null || !homeUI.uQk.bPM().isShowing()) && (homeUI.uQM == null || !homeUI.uQM.hML)) {
            if (menuItem.getItemId() == 2) {
                g.oUh.A(10919, "0");
                homeUI.bPp();
            } else if (menuItem.getItemId() == 1) {
                w.i("MicroMsg.LauncherUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(homeUI.uQk, "android.permission.ACCESS_COARSE_LOCATION", 65, null, null)));
                if (com.tencent.mm.pluginsdk.i.a.a(homeUI.uQk, "android.permission.ACCESS_COARSE_LOCATION", 65, null, null)) {
                    homeUI.bPr();
                }
            }
            i = 1;
        }
        if (i != 0) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        HomeUI homeUI = this.uRM;
        if (homeUI.uQM != null && homeUI.uQM.hML) {
            return false;
        }
        int dimensionPixelSize;
        int height = homeUI.uQk.cO().cP().getHeight();
        if (height == 0) {
            DisplayMetrics displayMetrics = homeUI.uQk.getResources().getDisplayMetrics();
            dimensionPixelSize = displayMetrics.widthPixels > displayMetrics.heightPixels ? homeUI.uQk.getResources().getDimensionPixelSize(R.f.aWR) : homeUI.uQk.getResources().getDimensionPixelSize(R.f.aWS);
        } else {
            dimensionPixelSize = height;
        }
        homeUI.uQr = menu.add(0, 1, 0, R.l.eYk);
        homeUI.uQr.setIcon(R.k.dsV);
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(homeUI.uQk, 68);
        homeUI.uQs = menu.add(0, 2, 0, R.l.eYj);
        if (homeUI.uQo == null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(fromDPToPix, dimensionPixelSize);
            homeUI.uQo = View.inflate(homeUI.uQk, R.i.cTD, null);
            homeUI.uQp = (ImageView) homeUI.uQo.findViewById(R.h.icon);
            homeUI.uQq = homeUI.uQo.findViewById(R.h.cIN);
            homeUI.uQo.setLayoutParams(layoutParams);
            homeUI.uQo.setBackgroundResource(R.g.bbE);
            homeUI.uQo.setMinimumHeight(dimensionPixelSize);
            homeUI.uQo.setMinimumWidth(fromDPToPix);
            homeUI.uQp.setImageResource(R.k.dsI);
            homeUI.uQo.setContentDescription(homeUI.getString(R.l.eYj));
            homeUI.uQo.setOnClickListener(new View.OnClickListener(homeUI) {
                final /* synthetic */ HomeUI uRb;

                {
                    this.uRb = r1;
                }

                public final void onClick(View view) {
                    g.oUh.A(10919, "0");
                    this.uRb.bPp();
                    if (HomeUI.uQf.booleanValue()) {
                        this.uRb.c(Boolean.valueOf(true), Boolean.valueOf(true));
                    }
                    if (HomeUI.uQg.booleanValue()) {
                        this.uRb.c(Boolean.valueOf(true), Boolean.valueOf(false));
                    }
                    if (!com.tencent.mm.sdk.a.b.bIs()) {
                        long Nz = bg.Nz();
                        if (Nz - this.uRb.miD > 10000) {
                            this.uRb.miD = Nz;
                            this.uRb.qhP = 1;
                            return;
                        }
                        HomeUI homeUI = this.uRb;
                        homeUI.qhP++;
                        if (this.uRb.qhP >= 5) {
                            w.w("MicroMsg.LauncherUI", "Switch to MonkeyEnv now.");
                            com.tencent.mm.sdk.a.b.jP(true);
                        }
                    }
                }
            });
            homeUI.uQo.post(new Runnable(homeUI) {
                final /* synthetic */ HomeUI uRb;

                {
                    this.uRb = r1;
                }

                public final void run() {
                    this.uRb.uQk.aQ();
                }

                public final String toString() {
                    return super.toString() + "|supportInvalidateOptionsMenu";
                }
            });
        }
        homeUI.kk(false);
        android.support.v4.view.m.a(homeUI.uQs, homeUI.uQo);
        if (homeUI.uQr != null) {
            android.support.v4.view.m.a(homeUI.uQr, 2);
            homeUI.uQr.setVisible(true);
        }
        if (homeUI.uQs != null) {
            android.support.v4.view.m.a(homeUI.uQs, 2);
            homeUI.uQs.setVisible(true);
        }
        homeUI.uQo.getLayoutParams().width = fromDPToPix;
        homeUI.uQo.getLayoutParams().height = dimensionPixelSize;
        w.v("MicroMsg.LauncherUI", "onCreateOptionsMenu");
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        HomeUI homeUI = this.uRM;
        e.a(homeUI.uQk, homeUI.ipu);
    }

    public ActionMode onWindowStartingActionMode(Callback callback) {
        ActionMode actionMode = null;
        HomeUI homeUI = this.uRM;
        if (!(homeUI.uQM == null || homeUI.uQM.vKo == null || !homeUI.uQM.bQi() || com.tencent.mm.compatible.util.d.eq(22))) {
            ActionMode startActionMode = homeUI.uQM.vKo.startActionMode(callback);
            if (startActionMode != null) {
                actionMode = startActionMode;
            }
        }
        if (actionMode == null) {
            return super.onWindowStartingActionMode(callback);
        }
        return actionMode;
    }

    public final q bPM() {
        HomeUI homeUI = this.uRM;
        q qVar = !homeUI.uQX ? homeUI.uQM : null;
        if (qVar == null) {
            return super.bPM();
        }
        return qVar;
    }

    public static void ez(Context context) {
        Intent intent = new Intent(context, LauncherUI.class);
        intent.addFlags(67108864);
        context.startActivity(intent);
    }

    public final void a(String str, Bundle bundle, boolean z) {
        this.uRM.a(str, bundle, z);
    }
}
