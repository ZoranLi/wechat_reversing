package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.tencent.mm.ah.n;
import com.tencent.mm.ap.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.d.a;
import com.tencent.mm.u.d.b;
import com.tencent.mm.u.d.c;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.conversation.j;
import com.tencent.mm.ui.i;
import java.io.File;
import java.lang.reflect.Field;

public final class l {
    public static l fwR;
    public boolean fwS;
    public ae fwT = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ l fwU;

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            HomeUI homeUI;
            if (message.what == -1999) {
                if (!this.fwU.fwS) {
                    LauncherUI bPI = LauncherUI.bPI();
                    if (bPI != null && bPI.uRP) {
                        Resources resources;
                        Field declaredField;
                        bPI.uRM.SD("tab_main");
                        homeUI = bPI.uRM;
                        if (homeUI.uPU) {
                            homeUI.uQa = true;
                            homeUI.uQu.setBackgroundDrawable(null);
                            VoiceSearchLayout voiceSearchLayout = homeUI.uQu;
                            voiceSearchLayout.sLy.setBackgroundDrawable(null);
                            voiceSearchLayout.sLC.setBackgroundDrawable(null);
                            voiceSearchLayout.sLD = null;
                        }
                        try {
                            resources = ab.getContext().getResources();
                            if (resources != null) {
                                declaredField = resources.getClass().getDeclaredField("mDrawableCache");
                                declaredField.setAccessible(true);
                                ((LongSparseArray) declaredField.get(resources)).clear();
                            }
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.ActivityResourceRecycler", e, "", new Object[0]);
                        }
                        try {
                            resources = ab.getContext().getResources();
                            if (resources != null) {
                                declaredField = resources.getClass().getDeclaredField("mColorStateListCache");
                                declaredField.setAccessible(true);
                                Object obj = declaredField.get(resources);
                                if (obj instanceof SparseArray) {
                                    ((SparseArray) obj).clear();
                                } else {
                                    ((LongSparseArray) obj).clear();
                                }
                            }
                        } catch (Throwable e2) {
                            w.printErrStackTrace("MicroMsg.ActivityResourceRecycler", e2, "", new Object[0]);
                        }
                        try {
                            if (VERSION.SDK_INT >= 16) {
                                Resources resources2 = ab.getContext().getResources();
                                if (resources2 != null) {
                                    Field declaredField2 = resources2.getClass().getDeclaredField("mColorDrawableCache");
                                    declaredField2.setAccessible(true);
                                    ((LongSparseArray) declaredField2.get(resources2)).clear();
                                    declaredField2 = resources2.getClass().getDeclaredField("sPreloadedColorDrawables");
                                    declaredField2.setAccessible(true);
                                    ((LongSparseArray) declaredField2.get(resources2)).clear();
                                }
                            }
                        } catch (Throwable e22) {
                            w.printErrStackTrace("MicroMsg.ActivityResourceRecycler", e22, "", new Object[0]);
                        }
                        e eVar = m.pQA;
                        if (eVar != null) {
                            eVar.bdw();
                        }
                        for (Fragment fragment : bPI.uRM.uRa.values()) {
                            if (!(fragment instanceof j)) {
                                ((i) fragment).bOu();
                            }
                        }
                    }
                    System.gc();
                }
            } else if (message.what == -2999 && !this.fwU.fwS) {
                LauncherUI bPI2 = LauncherUI.bPI();
                if (bPI2 != null) {
                    homeUI = bPI2.uRM;
                    if (homeUI.uRa.containsKey(Integer.valueOf(0))) {
                        ((i) homeUI.uRa.get(Integer.valueOf(0))).bOu();
                    }
                }
                if (h.vG().uV()) {
                    am gs = ap.yR().gs("plugin.emoji");
                    if (gs != null) {
                        gs.eD(0);
                    }
                    if (((n) ap.yR().gs(n.class.getName())) != null) {
                        n.GY();
                    }
                    a AG = b.AG();
                    a AC = a.AC();
                    c AI = c.AI();
                    ap.vL().D(new Runnable(AG) {
                        final /* synthetic */ b hpG;

                        {
                            this.hpG = r1;
                        }

                        public final void run() {
                            File file = new File(b.hpw + "MMSQL.trace");
                            if (!file.exists()) {
                                w.w("MicroMsg.SQLTraceManager", "SqlTrace file is not  exists");
                            } else if (h.vG().uV()) {
                                long currentTimeMillis = System.currentTimeMillis();
                                long aN = b.aN(ab.getContext());
                                boolean z = false;
                                if (aN > currentTimeMillis) {
                                    z = true;
                                } else if (currentTimeMillis - aN > 86400000) {
                                    z = true;
                                } else if (currentTimeMillis - aN > this.hpG.hpD && this.hpG.hpc) {
                                    z = true;
                                }
                                w.i("MicroMsg.SQLTraceManager", "check need upload ,file size is %d,time out  %b", Long.valueOf(file.length()), Boolean.valueOf(z));
                                if (z && r2 > this.hpG.hpC) {
                                    b bVar = this.hpG;
                                    Context context = ab.getContext();
                                    String packageName = ab.getContext().getPackageName();
                                    try {
                                        PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context.getPackageManager(), new Object[]{packageName, new Stub(bVar) {
                                            final /* synthetic */ b hpG;

                                            {
                                                this.hpG = r1;
                                            }

                                            public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                                                this.hpG.fwN[0] = packageStats.cacheSize;
                                                this.hpG.fwN[1] = packageStats.dataSize;
                                                this.hpG.fwN[2] = packageStats.codeSize;
                                                w.i("MicroMsg.SQLTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
                                            }
                                        }});
                                    } catch (Exception e) {
                                        bVar.fwN[0] = -1;
                                        bVar.fwN[1] = -1;
                                        bVar.fwN[2] = -1;
                                    }
                                    if (this.hpG.fwN[1] != 0 || this.hpG.hpb > 1) {
                                        w.i("MicroMsg.SQLTraceManager", "start file upload ,file length is %d ", Long.valueOf(file.length()));
                                        if (file.length() > this.hpG.hpB) {
                                            w.e("MicroMsg.SQLTraceManager", "log file invaild format");
                                        } else {
                                            String gF = b.gF(b.hpw + "MMSQL.trace");
                                            w.i("MicroMsg.SQLTraceManager", "read content success");
                                            this.hpG.gG(gF);
                                        }
                                        w.i("MicroMsg.SQLTraceManager", "set last Upload Time %d ", Long.valueOf(System.currentTimeMillis()));
                                        this.hpG.a(file, true);
                                        this.hpG.hpc = false;
                                        this.hpG.hpb = 0;
                                        b.c(ab.getContext(), System.currentTimeMillis());
                                        return;
                                    }
                                    w.i("MicroMsg.SQLTraceManager", "wait for get packageStats");
                                    bVar = this.hpG;
                                    bVar.hpb++;
                                }
                            } else {
                                w.w("MicroMsg.SQLTraceManager", "acc not ready ");
                            }
                        }
                    });
                    ap.vL().D(new Runnable(AC) {
                        final /* synthetic */ a hps;

                        {
                            this.hps = r1;
                        }

                        public final void run() {
                            File file = new File(a.hpa);
                            if (!file.exists()) {
                                w.w("MicroMsg.HandlerTraceManager", "summer handler trace file is not exists");
                            } else if (h.vG().uV()) {
                                long j = this.hps.hgx.getLong("handler_report_lastUploadTime", 0);
                                long currentTimeMillis = System.currentTimeMillis();
                                Object obj = (currentTimeMillis - j > this.hps.hpi || j > currentTimeMillis) ? 1 : null;
                                if (this.hps.hpc && obj != null) {
                                    w.i("MicroMsg.HandlerTraceManager", "summer check need upload ,file size is %d,time out %b", Long.valueOf(file.length()), Boolean.valueOf(true));
                                    a aVar = this.hps;
                                    Context context = ab.getContext();
                                    String packageName = ab.getContext().getPackageName();
                                    try {
                                        PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context.getPackageManager(), new Object[]{packageName, new Stub(aVar) {
                                            final /* synthetic */ a hps;

                                            {
                                                this.hps = r1;
                                            }

                                            public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                                                this.hps.fwN[0] = packageStats.cacheSize;
                                                this.hps.fwN[1] = packageStats.dataSize;
                                                this.hps.fwN[2] = packageStats.codeSize;
                                                w.i("MicroMsg.HandlerTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
                                            }
                                        }});
                                    } catch (Exception e) {
                                        aVar.fwN[0] = -1;
                                        aVar.fwN[1] = -1;
                                        aVar.fwN[2] = -1;
                                    }
                                    if (this.hps.fwN[1] != 0 || this.hps.hpb > 1) {
                                        if (file.length() > this.hps.hph) {
                                            w.e("MicroMsg.HandlerTraceManager", "summer log file invaild format");
                                        } else {
                                            String gF = a.gF(a.hpa);
                                            a aVar2 = this.hps;
                                            Intent intent = new Intent();
                                            intent.setClassName(ab.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
                                            intent.setAction("uncatch_exception");
                                            intent.putExtra("exceptionPid", Process.myPid());
                                            String str = "userName";
                                            String A = ao.hlW.A("login_weixin_username", "");
                                            if (bg.mA(A)) {
                                                A = ao.hlW.A("login_user_name", "never_login_crash");
                                            }
                                            intent.putExtra(str, A);
                                            intent.putExtra("tag", "handler");
                                            intent.putExtra("exceptionMsg", Base64.encodeToString((aVar2.AD() + gF).getBytes(), 2));
                                            ab.getContext().startService(intent);
                                        }
                                        this.hps.a(file, true);
                                        this.hps.hpc = false;
                                        this.hps.hpb = 0;
                                        this.hps.hgx.edit().putLong("handler_report_lastUploadTime", System.currentTimeMillis()).commit();
                                        return;
                                    }
                                    aVar = this.hps;
                                    aVar.hpb++;
                                }
                            } else {
                                w.w("MicroMsg.HandlerTraceManager", "summer acc not ready ");
                            }
                        }

                        public final String toString() {
                            return super.toString() + "|checkAndUpload";
                        }
                    });
                    AI.a(AG);
                    AI.a(AC);
                    ap.vL().D(new Runnable(AI) {
                        final /* synthetic */ c hpN;

                        {
                            this.hpN = r1;
                        }

                        public final void run() {
                            if (this.hpN.hpL) {
                                w.i("MicroMsg.TraceConfigUpdater", "summer update isUpdating and ret");
                                return;
                            }
                            long j = this.hpN.hgx.getLong("trace_config_last_update_time", 0);
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - j > 86400000 || j > currentTimeMillis) {
                                this.hpN.release();
                                this.hpN.hpL = true;
                                ap.vd().a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, this.hpN);
                                ap.vd().a((int) JsApiSetBackgroundAudioState.CTRL_INDEX, this.hpN);
                                ap.vd().a(new k(21), 0);
                                return;
                            }
                            w.i("MicroMsg.TraceConfigUpdater", "summer last update time: " + j + " current time: " + currentTimeMillis + " in same day");
                        }
                    });
                }
                System.gc();
            }
        }
    };

    public static l os() {
        if (fwR == null) {
            fwR = new l();
        }
        return fwR;
    }
}
