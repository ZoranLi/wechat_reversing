package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.a.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.g.j;
import com.tencent.mm.plugin.appbrand.g.r;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.c;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@a(1)
public class AppBrandUI extends MMActivity implements android.support.v4.app.a.a {
    private static HashSet<MMActivity> jkx = new HashSet();
    private c iwY = new c(this) {
        final /* synthetic */ AppBrandUI jkz;

        {
            this.jkz = r1;
        }

        public final void finish() {
            this.jkz.uSU.uTo.finish();
        }

        public final void a(AppBrandRemoteTaskController appBrandRemoteTaskController) {
            AppBrandUI.a(this.jkz, appBrandRemoteTaskController);
        }
    };
    private i iwl;
    private f jkv;
    private d jkw;
    private h jky = null;

    private static class ProcessRestartTask extends MainProcessTask {
        public static final Creator<ProcessRestartTask> CREATOR = new Creator<ProcessRestartTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                ProcessRestartTask processRestartTask = new ProcessRestartTask();
                processRestartTask.f(parcel);
                return processRestartTask;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ProcessRestartTask[i];
            }
        };
        public String gWO;
        public String jhx;

        public final void PM() {
            b.gI(this.gWO);
            com.tencent.mm.plugin.appbrand.task.b.qJ(this.jhx);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.gWO);
            parcel.writeString(this.jhx);
        }

        public final void f(Parcel parcel) {
            this.gWO = parcel.readString();
            this.jhx = parcel.readString();
        }
    }

    static /* synthetic */ void a(AppBrandUI appBrandUI, final AppBrandRemoteTaskController appBrandRemoteTaskController) {
        if (appBrandUI.jky == null || !appBrandUI.jky.isShowing()) {
            h.a aVar = new a(appBrandUI.uSU.uTo);
            aVar.zW(R.l.dIO);
            aVar.zX(R.l.dDp);
            aVar.kK(false);
            aVar.zZ(R.l.dDK).a(new OnClickListener(appBrandUI) {
                final /* synthetic */ AppBrandUI jkz;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.jkz.uSU.uTo.finish();
                    MainProcessTask mainProcessTask = appBrandRemoteTaskController;
                    mainProcessTask.jhy = a.jhI;
                    mainProcessTask.jhz = 0;
                    AppBrandMainProcessService.a(mainProcessTask);
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    intent.putExtra("Intro_Switch", true);
                    com.tencent.mm.bb.d.a(this.jkz.uSU.uTo, ".ui.LauncherUI", intent);
                }
            });
            appBrandUI.jky = aVar.WJ();
            appBrandUI.jky.show();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "pref_appbrand_process", 4);
        String str = ab.um() + ":start_time";
        Editor edit = sharedPreferences.edit();
        if (sharedPreferences.contains(str)) {
            edit.remove(str);
            com.tencent.mm.plugin.report.c.oTb.a(365, 2, 1, false);
        }
        com.tencent.mm.plugin.report.c.oTb.a(365, 4, 1, false);
        edit.putLong(str, System.currentTimeMillis());
        edit.commit();
        w.v("MicroMsg.AppBrandReporter", "onProcessStart");
        KVCommCrossProcessReceiver.aXA();
        View frameLayout = new FrameLayout(this.uSU.uTo);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        setContentView(frameLayout);
        m.a((MMActivity) this, frameLayout);
        this.iwl = new i(this, this.iwY);
        frameLayout.addView(this.iwl.iws);
        this.jkv = new f(this, this.iwl);
        e eVar = this.jkv;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        try {
            ab.getContext().registerReceiver(eVar.iAD, intentFilter);
        } catch (Exception e) {
            w.e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "register screen off receiver e = " + e);
        }
        this.jkw = new d(this, this) {
            final /* synthetic */ AppBrandUI jkz;

            protected final void QG() {
                com.tencent.mm.plugin.appbrand.h PF = this.jkz.iwl.PF();
                if (PF != null) {
                    com.tencent.mm.plugin.appbrand.e.a(PF.ivH, com.tencent.mm.plugin.appbrand.e.c.HOME_PRESSED);
                }
            }
        };
        d dVar = this.jkw;
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        try {
            ab.getContext().registerReceiver(dVar.tF, intentFilter);
        } catch (Exception e2) {
            w.e("MicroMsg.BaseAppBrandUIHomePressReceiver", "register screen off receiver e = " + e2);
        }
        jkx.add(this);
        r(getIntent());
    }

    public void onNewIntent(Intent intent) {
        r(intent);
    }

    private void r(Intent intent) {
        AppBrandInitConfig appBrandInitConfig;
        Exception e;
        int i;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            finish();
            return;
        }
        AppBrandStatObject appBrandStatObject;
        try {
            extras.setClassLoader(AppBrandInitConfig.class.getClassLoader());
            appBrandInitConfig = (AppBrandInitConfig) extras.getParcelable("key_appbrand_init_config");
            try {
                appBrandStatObject = (AppBrandStatObject) extras.getParcelable("key_appbrand_stat_object");
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.AppBrandUI", "getParcelable: %s", new Object[]{e});
                appBrandStatObject = null;
                this.iwl.a(null, appBrandInitConfig, appBrandStatObject);
                if (appBrandStatObject == null) {
                    i = 0;
                } else {
                    i = appBrandStatObject.scene;
                }
                if ((i == 1023 ? 1 : 0) != 0) {
                    com.tencent.mm.plugin.appbrand.m.d.bD(this.uSU.uTo);
                } else {
                    com.tencent.mm.plugin.appbrand.m.d.bF(this.uSU.uTo);
                }
            }
        } catch (Exception e3) {
            e = e3;
            appBrandInitConfig = null;
            w.e("MicroMsg.AppBrandUI", "getParcelable: %s", new Object[]{e});
            appBrandStatObject = null;
            this.iwl.a(null, appBrandInitConfig, appBrandStatObject);
            if (appBrandStatObject == null) {
                i = appBrandStatObject.scene;
            } else {
                i = 0;
            }
            if (i == 1023) {
            }
            if ((i == 1023 ? 1 : 0) != 0) {
                com.tencent.mm.plugin.appbrand.m.d.bF(this.uSU.uTo);
            } else {
                com.tencent.mm.plugin.appbrand.m.d.bD(this.uSU.uTo);
            }
        }
        this.iwl.a(null, appBrandInitConfig, appBrandStatObject);
        if (appBrandStatObject == null) {
            i = 0;
        } else {
            i = appBrandStatObject.scene;
        }
        if (i == 1023) {
        }
        if ((i == 1023 ? 1 : 0) != 0) {
            com.tencent.mm.plugin.appbrand.m.d.bD(this.uSU.uTo);
        } else {
            com.tencent.mm.plugin.appbrand.m.d.bF(this.uSU.uTo);
        }
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        boolean z = intent != null && (intent.getFlags() & SQLiteDatabase.CREATE_IF_NECESSARY) > 0;
        if (!(z || this.iwl.PF() == null)) {
            this.iwl.PF().iwF = true;
            String str = this.iwl.PF().ivH;
            if (com.tencent.mm.plugin.appbrand.e.c.HIDE == com.tencent.mm.plugin.appbrand.e.nk(str)) {
                com.tencent.mm.plugin.appbrand.e.a(str, com.tencent.mm.plugin.appbrand.e.c.LAUNCH_NATIVE_PAGE);
            }
        }
        try {
            this.iwl.PF().iwr.jct.jcN = intent;
        } catch (Exception e) {
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void onResume() {
        super.onResume();
        w.i("MicroMsg.AppBrandUI", "onResume");
        com.tencent.mm.plugin.appbrand.h PF = this.iwl.PF();
        if (PF != null) {
            PF.onResume();
        }
        try {
            com.tencent.mm.modelstat.d.a(3, "AppBrandUI_" + this.iwl.PF().ivH, hashCode());
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.AppBrandUI", th, "[oneliang]AppBrandUI click flow exception.", new Object[0]);
        }
    }

    public void onPause() {
        super.onPause();
        w.i("MicroMsg.AppBrandUI", "onPause");
        com.tencent.mm.plugin.appbrand.h PF = this.iwl.PF();
        if (PF != null) {
            PF.onPause();
        }
        try {
            com.tencent.mm.modelstat.d.a(4, "AppBrandUI_" + this.iwl.PF().ivH, hashCode());
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.AppBrandUI", th, "[oneliang]AppBrandUI click flow exception.", new Object[0]);
        }
    }

    public void finish() {
        if (!isFinishing() && !this.uSW) {
            if (VERSION.SDK_INT >= 21) {
                finishAndRemoveTask();
            } else {
                super.finish();
            }
            com.tencent.mm.plugin.appbrand.m.d.bE(this.uSU.uTo);
            com.tencent.mm.plugin.appbrand.report.a.Ws();
        }
    }

    public boolean moveTaskToBack(boolean z) {
        try {
            boolean moveTaskToBack = super.moveTaskToBack(z);
            com.tencent.mm.plugin.appbrand.m.d.bE(this.uSU.uTo);
            return moveTaskToBack;
        } catch (NullPointerException e) {
            jkx.remove(this);
            if (!Xc()) {
                finish();
            }
            return true;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        i iVar = this.iwl;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(iVar.iwW);
        linkedList.addAll(iVar.iwX.values());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            iVar.a((com.tencent.mm.plugin.appbrand.h) it.next());
        }
        w.i("MicroMsg.AppBrandRuntimeContainer", "cleanup");
        jkx.remove(this);
        if (this.jkw != null) {
            try {
                ab.getContext().unregisterReceiver(this.jkw.tF);
            } catch (Exception e) {
                w.e("MicroMsg.BaseAppBrandUIHomePressReceiver", "unregister screen off receiver e = " + e);
            }
        }
        if (this.jkv != null) {
            try {
                ab.getContext().unregisterReceiver(this.jkv.iAD);
            } catch (Exception e2) {
                w.e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "unregister screen off receiver e = " + e2);
            }
        }
        Xc();
    }

    public void onBackPressed() {
        Object obj = null;
        com.tencent.mm.plugin.appbrand.h PF = this.iwl.PF();
        if (PF == null) {
            return;
        }
        if (PF.iwt == null) {
            Object obj2;
            int i;
            if (PF.iwv != null) {
                com.tencent.mm.plugin.appbrand.widget.b.b bVar = PF.iwv;
                com.tencent.mm.plugin.appbrand.widget.b.a aVar = (com.tencent.mm.plugin.appbrand.widget.b.a) bVar.jsb.peekLast();
                if (aVar == null) {
                    bVar.setVisibility(8);
                    obj2 = null;
                } else {
                    aVar.onCancel();
                    bVar.b(aVar);
                    i = 1;
                }
                if (obj2 != null) {
                    return;
                }
            }
            if (PF.iwr != null) {
                j jVar = PF.iwr;
                com.tencent.mm.plugin.appbrand.g.m VC = jVar.VN().VC();
                r rVar = VC.jde;
                if (rVar.jdY == null) {
                    obj2 = null;
                } else {
                    rVar.Wf();
                    i = 1;
                }
                if (obj2 != null) {
                    obj = 1;
                } else if (VC.jda.size() != 0) {
                    for (com.tencent.mm.plugin.appbrand.g.m.a UQ : VC.jda) {
                        obj = UQ.UQ() ? 1 : obj;
                    }
                }
                if (obj == null) {
                    jVar.VM();
                    return;
                }
                return;
            }
            return;
        }
        PF.finish();
    }

    protected final void SC() {
        super.SC();
        getWindow().requestFeature(10);
        getWindow().getDecorView().setFitsSystemWindows(true);
        aq(10);
        aq(1);
        m.a(this);
    }

    protected final int Ol() {
        return 1;
    }

    public final boolean Xb() {
        return true;
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.tencent.mm.plugin.appbrand.h PF = this.iwl.PF();
        if (PF != null) {
            com.tencent.mm.plugin.appbrand.b.a(PF.ivH, i, strArr, iArr);
        }
    }

    private boolean Xc() {
        if (jkx.isEmpty()) {
            MainProcessTask processRestartTask = new ProcessRestartTask();
            processRestartTask.gWO = ab.um();
            processRestartTask.jhx = getClass().getName();
            AppBrandMainProcessService.b(processRestartTask);
            try {
                KVCommCrossProcessReceiver.aXE();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AppBrandUI", e, "sendKV", new Object[0]);
            }
            com.tencent.mm.bk.a.post(new Runnable(this) {
                final /* synthetic */ AppBrandUI jkz;

                {
                    this.jkz = r1;
                }

                public final void run() {
                    w.i("MicroMsg.AppBrandUI", "tryRestartProcess, %s", new Object[]{q.yC().toString()});
                    System.exit(0);
                }
            });
            return true;
        }
        w.i("MicroMsg.AppBrandUI", "Activity running");
        return false;
    }
}
