package com.tencent.mm.plugin.bbom;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.R;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.app.c;
import com.tencent.mm.booter.MMReceivers.SandBoxProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsProcessReceiver;
import com.tencent.mm.booter.d.a;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.x;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.loader.f;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.o;
import com.tencent.mm.u.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMAppMgr.Receiver;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteTrace;
import java.util.List;
import java.util.Map;

public class PluginBigBallOfMud extends d implements ApplicationLifeCycleBucket {
    private static final String TAG = "MicroMsg.PluginBigBallOfMud";
    public Application app;
    private final MMAppMgr appMgr = new MMAppMgr();
    private e mProfileCompat;

    public String toString() {
        return "plugin-big-ball-of-mud";
    }

    public void installed() {
    }

    public void dependency() {
        dependsOn(b.class);
        dependsOn(n.class);
    }

    public void configure(com.tencent.mm.kernel.b.e eVar) {
        String str;
        e eVar2;
        int i;
        ToolsProcessReceiver.a(new com.tencent.mm.booter.d.b());
        SandBoxProcessReceiver.a(new a());
        com.tencent.mm.plugin.zero.a.d dVar = (com.tencent.mm.plugin.zero.a.d) h.j(com.tencent.mm.plugin.zero.a.d.class);
        dVar.setILightPushDelegate(new g());
        dVar.addNotifyReceiverCallback(new k());
        dVar.addICoreServiceLifecycleCallback(new d());
        w.i(TAG, "zero %s", dVar);
        this.app = eVar.gZz;
        com.tencent.mm.modelstat.d.b(this.app);
        w.i(TAG, "app.getResources() is:" + eVar.gZz.getResources());
        ab.a(com.tencent.mm.bh.a.a(eVar.gZz.getResources(), eVar.gZz));
        autoScaleFontSize();
        c.ac(this.app.getApplicationContext());
        long currentTimeMillis = System.currentTimeMillis();
        f fVar = new f();
        Application application = this.app;
        String str2 = eVar.gWO;
        if (str2 == null || str2.length() <= 0) {
            HandlerThread Qu = com.tencent.mm.sdk.f.e.Qu("ProfileFactoryImp_handlerThread");
            Qu.start();
            str2 = (String) new bb<String>(fVar) {
                final /* synthetic */ f gSd;

                {
                    this.gSd = r4;
                }

                protected final /* synthetic */ Object run() {
                    return AnonymousClass1.rT();
                }

                private static String rT() {
                    while (true) {
                        String q = bg.q(ab.getContext(), Process.myPid());
                        if (q != null) {
                            return q;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.ProfileFactoryImpl", e, "", new Object[0]);
                        }
                    }
                }
            }.b(new ae(Qu.getLooper()));
            Qu.getLooper().quit();
            str = str2;
        } else {
            str = str2;
        }
        if (str == null) {
            w.e("MicroMsg.ProfileFactoryImpl", "get process name failed, retry later");
            eVar2 = null;
        } else {
            ab.Pr(str);
            if (str.equals(ab.getPackageName())) {
                eVar2 = f.a(application, ".app.WorkerProfile");
            } else if (str.equals(ab.getPackageName() + ":push")) {
                eVar2 = f.a(application, ".app.PusherProfile");
            } else if (str.equals(ab.getPackageName() + ":tools")) {
                eVar2 = f.a(application, ".app.ToolsProfile");
            } else if (str.equals(ab.getPackageName() + ":sandbox")) {
                eVar2 = f.a(application, ".app.SandBoxProfile");
            } else if (str.equals(ab.getPackageName() + ":exdevice")) {
                eVar2 = f.a(application, ".app.ExDeviceProfile");
            } else if (str.equals(ab.getPackageName() + ":TMAssistantDownloadSDKService")) {
                eVar2 = f.a(application, ".app.TMAssistantProfile");
            } else if (str.equals(ab.getPackageName() + ":nospace")) {
                eVar2 = f.a(application, ".app.NoSpaceProfile");
            } else if (str.equals(ab.getPackageName() + ":patch")) {
                eVar2 = f.a(application, ".app.PatchProfile");
            } else if (str.equals(ab.getPackageName() + ":recovery")) {
                eVar2 = f.a(application, ".app.RecoveryProfile");
            } else if (str.startsWith(ab.getPackageName() + ":appbrand")) {
                eVar2 = f.a(application, ".app.AppBrandProfile");
            } else if (str.startsWith(ab.getPackageName() + ":support")) {
                eVar2 = f.a(application, ".app.SupportProfile");
            } else {
                com.tencent.mm.sdk.a.b.r("MMApplication onCreate profile == null", "profile is null and initMMcore failed");
                eVar2 = null;
            }
            w.w("MicroMsg.ProfileFactoryImpl", "application started, profile = %s", str);
        }
        this.mProfileCompat = eVar2;
        if (!(this.mProfileCompat == null || eVar.ej(""))) {
            w.i(TAG, "before profile oncreate.");
            this.mProfileCompat.onCreate();
        }
        w.i(TAG, "after profile oncreate.");
        ((com.tencent.mm.kernel.b.f) eVar).mProfileCompat = this.mProfileCompat;
        SharedPreferences sharedPreferences = eVar.gZz.getSharedPreferences("system_config_prefs", 0);
        if (sharedPreferences != null) {
            i = sharedPreferences.getInt("default_uin", 0);
        } else {
            i = 0;
        }
        w.i(TAG, "APPonCreate proc:%s time:%d (loader:%d) ueh:%d data[%s] sdcard[%s]", eVar.gWO, Long.valueOf(bg.aA(MMApplicationLike.sAppStartTime)), Long.valueOf(bg.aA(currentTimeMillis)), Integer.valueOf(i), com.tencent.mm.storage.w.hgq, com.tencent.mm.compatible.util.e.hgs);
        com.tencent.mm.h.a.a.a(new com.tencent.mm.h.a(this) {
            final /* synthetic */ PluginBigBallOfMud jPX;

            {
                this.jPX = r1;
            }

            public final void b(au auVar) {
                if (com.tencent.mm.modelbiz.e.dr(auVar.field_talker)) {
                    auVar.cN(com.tencent.mm.modelbiz.a.e.zz());
                }
            }

            public final String p(String str, int i) {
                if (com.tencent.mm.modelbiz.e.dr(str)) {
                    return com.tencent.mm.modelbiz.a.e.iw(((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA((long) i).gxF);
                }
                return ba.zA();
            }

            public final String c(au auVar) {
                if (com.tencent.mm.modelbiz.e.dr(auVar.field_talker)) {
                    return com.tencent.mm.modelbiz.a.e.iw(auVar.gxF);
                }
                return null;
            }

            public final boolean dr(String str) {
                return com.tencent.mm.modelbiz.e.dr(str);
            }
        });
        if (eVar.ej("")) {
            s.hBz = new s.a(this) {
                final /* synthetic */ PluginBigBallOfMud jPX;

                {
                    this.jPX = r1;
                }

                public final String FF() {
                    if (com.tencent.mm.sdk.platformtools.f.usw) {
                        return ab.getContext().getString(R.l.eNL);
                    }
                    return ab.getContext().getString(R.l.eNK);
                }
            };
            com.tencent.mm.bj.e.a(new SQLiteTrace(this) {
                final /* synthetic */ PluginBigBallOfMud jPX;

                {
                    this.jPX = r1;
                }

                public final void onSQLExecuted(SQLiteDatabase sQLiteDatabase, String str, int i, long j) {
                    try {
                        com.tencent.mm.u.d.b AG = com.tencent.mm.u.d.b.AG();
                        boolean isMainThread = af.isMainThread();
                        String path = sQLiteDatabase.getPath();
                        if ((j > AG.hpx && isMainThread) || (j > AG.hpz && !isMainThread)) {
                            for (String str2 : com.tencent.mm.u.d.b.hpF) {
                                if (!isMainThread && path.contains(str2)) {
                                    return;
                                }
                            }
                            if (i != 2 || !isMainThread || j >= AG.hpy) {
                                if (AG.hpc) {
                                    w.i("MicroMsg.SQLTraceManager", "mark stop as file is full !");
                                    return;
                                }
                                String toUpperCase = str.trim().toUpperCase();
                                if (toUpperCase.startsWith("INSERT") || toUpperCase.startsWith("UPDATE") || toUpperCase.startsWith("DELETE") || toUpperCase.startsWith("COMMIT") || toUpperCase.startsWith("SELECT")) {
                                    if (toUpperCase.startsWith("INSERT")) {
                                        toUpperCase = toUpperCase.substring(0, toUpperCase.indexOf("(", 0));
                                    } else if (toUpperCase.startsWith("COMMIT")) {
                                        toUpperCase = j > AG.hpA ? toUpperCase + "task:" + bg.bJZ() : null;
                                    }
                                    if (toUpperCase.length() > 512) {
                                        toUpperCase = toUpperCase.substring(0, 512) + "...";
                                    }
                                    if (!toUpperCase.trim().endsWith(";")) {
                                        toUpperCase = toUpperCase + ";";
                                    }
                                } else {
                                    toUpperCase = null;
                                }
                                if (!bg.mA(toUpperCase)) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    com.tencent.mm.u.d.b.a("tid", String.valueOf(Thread.currentThread().getId()), stringBuilder);
                                    com.tencent.mm.u.d.b.a("sql", toUpperCase, stringBuilder);
                                    com.tencent.mm.u.d.b.a("lastTime", String.valueOf(j), stringBuilder);
                                    com.tencent.mm.u.d.b.a("foreground", com.tencent.mm.sdk.a.b.foreground ? "1" : "0", stringBuilder);
                                    com.tencent.mm.u.d.b.a("tname", Thread.currentThread().getName(), stringBuilder);
                                    toUpperCase = stringBuilder.toString();
                                    w.d("MicroMsg.SQLTraceManager", "SQL Trace mark : " + toUpperCase);
                                    ap.vL().D(new com.tencent.mm.u.d.b.AnonymousClass3(AG, toUpperCase));
                                }
                            }
                        }
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.SQLiteTrace", e, "Failed to send trace.", new Object[0]);
                    }
                }

                public final void onConnectionObtained(SQLiteDatabase sQLiteDatabase, String str, long j, boolean z) {
                }

                public final void onConnectionPoolBusy(SQLiteDatabase sQLiteDatabase, String str, List<String> list, String str2) {
                }

                public final void onDatabaseCorrupted(SQLiteDatabase sQLiteDatabase) {
                }
            });
            com.tencent.mm.storage.e.uyR = new j(this) {
                final /* synthetic */ PluginBigBallOfMud jPX;

                {
                    this.jPX = r1;
                }

                public final String F(au auVar) {
                    int i = (auVar.field_bizChatId == -1 || !com.tencent.mm.modelbiz.e.dr(auVar.field_talker)) ? 0 : 1;
                    if (i == 0) {
                        return auVar.field_talker;
                    }
                    w.d(PluginBigBallOfMud.TAG, "mapNotifyInfo key:%s", auVar.field_talker + ":" + auVar.field_bizChatId);
                    return auVar.field_talker + ":" + auVar.field_bizChatId;
                }
            };
            p.a(new p.a(this) {
                final /* synthetic */ PluginBigBallOfMud jPX;

                {
                    this.jPX = r1;
                }

                public final boolean a(String str, String str2, PInt pInt) {
                    if (!o.eV(str)) {
                        return false;
                    }
                    if (com.tencent.mm.modelbiz.e.dr(str)) {
                        if (com.tencent.mm.modelbiz.a.e.is(str2)) {
                            pInt.value = 5;
                        } else {
                            pInt.value = 4;
                        }
                    } else if (com.tencent.mm.modelbiz.e.ia(str)) {
                        pInt.value = 3;
                    } else if (com.tencent.mm.modelbiz.e.ib(str)) {
                        pInt.value = 0;
                    } else if (com.tencent.mm.modelbiz.e.hX(str)) {
                        pInt.value = 6;
                    } else {
                        pInt.value = 7;
                    }
                    return true;
                }
            });
            com.tencent.mm.plugin.messenger.foundation.a.s.b(new com.tencent.mm.bn.b<r>(this) {
                final /* synthetic */ PluginBigBallOfMud jPX;

                {
                    this.jPX = r1;
                }

                public final /* synthetic */ Object get() {
                    return new n();
                }
            });
            com.tencent.mm.plugin.messenger.foundation.a.p aVar = new com.tencent.mm.modelmulti.a();
            com.tencent.mm.plugin.messenger.foundation.a.p.a.a(69, aVar);
            com.tencent.mm.plugin.messenger.foundation.a.p.a.a(68, aVar);
            com.tencent.mm.plugin.messenger.foundation.a.p.a.a(22, aVar);
            com.tencent.mm.plugin.messenger.foundation.a.p.a.a(13, aVar);
            com.tencent.mm.plugin.messenger.foundation.a.p.a.a(15, aVar);
            com.tencent.mm.plugin.messenger.foundation.a.p.a.a(23, aVar);
            com.tencent.mm.plugin.messenger.foundation.a.p.a.a(25, aVar);
            com.tencent.mm.plugin.messenger.foundation.a.p.a.a(24, aVar);
            com.tencent.mm.plugin.messenger.foundation.a.p.a.a(33, aVar);
            com.tencent.mm.plugin.messenger.foundation.a.p.a.a(35, aVar);
            com.tencent.mm.plugin.messenger.foundation.a.p.a.a(44, aVar);
            com.tencent.mm.plugin.messenger.foundation.a.p.a.a(999999, aVar);
            com.tencent.mm.plugin.messenger.foundation.a.p.a.a(53, aVar);
            com.tencent.mm.plugin.messenger.foundation.a.p.a.a(ao.CTRL_INDEX, aVar);
            com.tencent.mm.y.e cVar = new c();
            ((com.tencent.mm.plugin.messenger.foundation.a.c) h.h(com.tencent.mm.plugin.messenger.foundation.a.c.class)).a(cVar);
            h.vd().a(681, cVar);
            com.tencent.mm.plugin.messenger.foundation.a.s.a(5, new h());
            com.tencent.mm.plugin.messenger.foundation.a.s.a(1, new o());
            com.tencent.mm.plugin.messenger.foundation.a.s.a(4, new e());
            ((b) h.j(b.class)).addHandleAuthResponse(new a());
            com.tencent.mm.plugin.messenger.foundation.a.f iVar = new i();
            ((com.tencent.mm.plugin.messenger.foundation.a.o) h.h(com.tencent.mm.plugin.messenger.foundation.a.o.class)).a((k) iVar);
            ((com.tencent.mm.plugin.messenger.foundation.a.o) h.h(com.tencent.mm.plugin.messenger.foundation.a.o.class)).a(iVar);
            com.tencent.mm.u.e.a(new b());
            com.tencent.mm.permission.b bVar = new com.tencent.mm.permission.b();
            new m().bIy();
            h.vd().b(138, j.jPU);
            h.vd().b(39, j.jPU);
            h.vd().b(268369922, j.jPU);
            if (j.jPU == null) {
                j.jPU = new j();
            }
            h.vd().a(138, j.jPU);
            h.vd().a(39, j.jPU);
            h.vd().a(268369922, j.jPU);
            l.bJ(this.app);
            com.tencent.mm.an.a.a.a("delchatroommember", new com.tencent.mm.an.a.a() {
                public final com.tencent.mm.an.a a(Map<String, String> map, au auVar) {
                    return new com.tencent.mm.an.d(map);
                }
            });
            com.tencent.mm.an.a.a.a("NewXmlChatRoomAccessVerifyApplication", new com.tencent.mm.an.a.a() {
                public final com.tencent.mm.an.a a(Map<String, String> map, au auVar) {
                    return new com.tencent.mm.an.c(map, auVar);
                }
            });
            com.tencent.mm.an.a.a.a("NewXmlChatRoomAccessVerifyApproval", new com.tencent.mm.an.a.a() {
                public final com.tencent.mm.an.a a(Map<String, String> map, au auVar) {
                    return new com.tencent.mm.an.b(map, auVar);
                }
            });
            MMAppMgr mMAppMgr = this.appMgr;
            Context context = this.app;
            if (mMAppMgr.uUk == null) {
                mMAppMgr.uUk = new Receiver(mMAppMgr);
            }
            MMActivity.bPQ();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mm.ui.ACTION_ACTIVE");
            intentFilter.addAction("com.tencent.mm.ui.ACTION_DEACTIVE");
            intentFilter.addAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
            intentFilter.addAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
            intentFilter.addAction("MINIQB_OPEN_RET");
            context.registerReceiver(mMAppMgr.uUk, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
            q xVar = new x(com.tencent.mm.booter.c.ao(this.app));
            xVar.cR("MM");
            com.tencent.mm.platformtools.r.ijc = bg.b(xVar.cS(".com.tencent.mm.debug.test.use_cdn_down_thumb"), false);
            com.tencent.mm.platformtools.r.iik = bg.b(xVar.cS(".com.tencent.mm.debug.test.display_errcode"), false);
            com.tencent.mm.platformtools.r.iil = bg.b(xVar.cS(".com.tencent.mm.debug.test.display_msgstate"), false);
            com.tencent.mm.platformtools.r.iim = bg.b(xVar.cS(".com.tencent.mm.debug.test.network.simulate_fault"), false);
            com.tencent.mm.platformtools.r.iin = bg.b(xVar.cS(".com.tencent.mm.debug.test.network.force_touch"), false);
            com.tencent.mm.platformtools.r.iio = bg.b(xVar.cS(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
            com.tencent.mm.platformtools.r.iip = bg.b(xVar.cS(".com.tencent.mm.debug.test.crashIsExit"), false);
            com.tencent.mm.platformtools.r.iiO = bg.getInt(bg.ap(xVar.getString(".com.tencent.mm.debug.datatransfer.times"), "0"), 0);
            com.tencent.mm.platformtools.r.iiP = bg.getInt(bg.ap(xVar.getString(".com.tencent.mm.debug.datatransfer.duration"), "0"), 0);
            com.tencent.mm.platformtools.r.iir = bg.b(xVar.cS(".com.tencent.mm.debug.test.album_drop_table"), false);
            com.tencent.mm.platformtools.r.iis = bg.b(xVar.cS(".com.tencent.mm.debug.test.album_dle_file"), false);
            com.tencent.mm.platformtools.r.iit = bg.b(xVar.cS(".com.tencent.mm.debug.test.album_show_info"), false);
            com.tencent.mm.platformtools.r.iiu = bg.b(xVar.cS(".com.tencent.mm.debug.test.location_help"), false);
            com.tencent.mm.platformtools.r.iix = bg.b(xVar.cS(".com.tencent.mm.debug.test.force_soso"), false);
            com.tencent.mm.platformtools.r.iiy = bg.b(xVar.cS(".com.tencent.mm.debug.test.simulatePostServerError"), false);
            com.tencent.mm.platformtools.r.iiz = bg.b(xVar.cS(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
            com.tencent.mm.platformtools.r.iiA = bg.b(xVar.cS(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
            com.tencent.mm.platformtools.r.iiD = bg.b(xVar.cS(".com.tencent.mm.debug.test.filterfpnp"), false);
            com.tencent.mm.platformtools.r.iiE = bg.b(xVar.cS(".com.tencent.mm.debug.test.testForPull"), false);
            int a = bg.a(xVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
            com.tencent.mm.platformtools.r.iiB = a;
            if (a != 4 && com.tencent.mm.platformtools.r.iiB > 0) {
                v.uze = com.tencent.mm.platformtools.r.iiB;
                w.e("MicroMsg.WorkerDebugger", "cdn thread num " + com.tencent.mm.platformtools.r.iiB);
            }
            com.tencent.mm.platformtools.r.iiC = bg.b(xVar.cS(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
            com.tencent.mm.platformtools.r.iiF = bg.ap(xVar.getString(".com.tencent.mm.debug.server.host.http"), "");
            com.tencent.mm.platformtools.r.iiG = bg.ap(xVar.getString(".com.tencent.mm.debug.server.host.socket"), "");
            if (bg.b(xVar.cS(".com.tencent.mm.debug.test.show_full_version"), false)) {
                com.tencent.mm.sdk.platformtools.f.ust = true;
            }
            try {
                a = Integer.decode(xVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
                com.tencent.mm.protocal.d.xW(a);
                new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
            } catch (Exception e) {
                w.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                String string = xVar.getString(".com.tencent.mm.debug.log.setapilevel");
                if (!bg.mA(string)) {
                    com.tencent.mm.protocal.d.DEVICE_TYPE = "android-" + string;
                    com.tencent.mm.protocal.d.sYI = "android-" + string;
                    com.tencent.mm.protocal.d.sYK = string;
                    com.tencent.mm.sdk.a.b.Pb(string);
                    new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.DEVICE_TYPE).append(" ").append(com.tencent.mm.sdk.a.b.bIv());
                }
            } catch (Exception e2) {
                w.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                currentTimeMillis = Long.decode(xVar.getString(".com.tencent.mm.debug.log.setuin")).longValue();
                new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.sYM).append(" new: ").append(currentTimeMillis);
                com.tencent.mm.protocal.d.sYM = currentTimeMillis;
            } catch (Exception e3) {
                w.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                xVar.gKC.gJL = Integer.decode(xVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            } catch (Exception e4) {
                w.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                boolean b = bg.b(xVar.cS(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean b2 = bg.b(xVar.cS(".com.tencent.mm.debug.report.kvstat"), false);
                boolean b3 = bg.b(xVar.cS(".com.tencent.mm.debug.report.clientpref"), false);
                boolean b4 = bg.b(xVar.cS(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.a(b, b2, b3, b4);
                new StringBuilder("try control report : debugModel[").append(b).append("],kv[").append(b2).append("], clientPref[").append(b3).append("], useraction[").append(b4).append("]");
            } catch (Exception e5) {
                w.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            com.tencent.mm.platformtools.r.iiJ = bg.b(xVar.cS(".com.tencent.mm.debug.test.update_test"), false);
            com.tencent.mm.platformtools.r.iiK = bg.b(xVar.cS(".com.tencent.mm.debug.test.scan_save_image"), false);
            com.tencent.mm.platformtools.r.iiM = bg.b(xVar.cS(".com.tencent.mm.debug.test.shake_get_config_list"), false);
            com.tencent.mm.platformtools.r.iiN = bg.b(xVar.cS(".com.tencent.mm.debug.test.shake_show_shaketv"), false);
            com.tencent.mm.platformtools.r.iiR = bg.ap(xVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
            w.d("MicroMsg.WorkerDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.r.iiR);
            com.tencent.mm.platformtools.r.ijg = bg.ap(xVar.getString(".com.tencent.mm.debug.cdn.front"), "");
            com.tencent.mm.platformtools.r.ijh = bg.ap(xVar.getString(".com.tencent.mm.debug.cdn.zone"), "");
            com.tencent.mm.platformtools.r.iji = bg.ap(xVar.getString(".com.tencent.mm.debug.cdn.wifi_elt"), "");
            com.tencent.mm.platformtools.r.ijj = bg.ap(xVar.getString(".com.tencent.mm.debug.cdn.nowifi_elt"), "");
            com.tencent.mm.platformtools.r.ijk = bg.ap(xVar.getString(".com.tencent.mm.debug.cdn.ptl"), "");
            com.tencent.mm.platformtools.r.ijl = bg.b(xVar.cS(".com.tencent.mm.debug.cdn.usestream"), false);
            com.tencent.mm.platformtools.r.ijm = bg.b(xVar.cS(".com.tencent.mm.debug.cdn.onlysendetl"), false);
            com.tencent.mm.platformtools.r.ijn = bg.b(xVar.cS(".com.tencent.mm.debug.cdn.onlysendptl"), false);
            com.tencent.mm.platformtools.r.ijp = bg.b(xVar.cS(".com.tencent.mm.debug.cdn.enable_debug"), false);
            com.tencent.mm.platformtools.r.ijq = bg.b(xVar.cS(".com.tencent.mm.debug.cdn.enable_conn_verify"), false);
            com.tencent.mm.platformtools.r.ijr = bg.b(xVar.cS(".com.tencent.mm.debug.cdn.enable_video_redirect_oc"), false);
            com.tencent.mm.platformtools.r.ijx = bg.b(xVar.cS(".com.tencent.mm.debug.bakmove_hardcode"), false);
            w.d("MicroMsg.WorkerDebugger", "Test.bakmove_hardcode = " + com.tencent.mm.platformtools.r.ijx);
            com.tencent.mm.platformtools.r.ijy = bg.ap(xVar.getString(".com.tencent.mm.debug.bakmove_ip"), "");
            com.tencent.mm.platformtools.r.ijz = bg.getInt(bg.ap(xVar.getString(".com.tencent.mm.debug.bakmove_port"), "0"), 0);
            com.tencent.mm.platformtools.r.iju = bg.b(xVar.cS(".com.tencent.mm.debug.cursormode_enabled"), true);
            com.tencent.mm.platformtools.r.ijV = bg.b(xVar.cS(".com.tencent.mm.debug.disaster_ignore_interval"), false);
            com.tencent.mm.platformtools.r.ijW = bg.b(xVar.cS(".com.tencent.mm.debug.disaster_ignore_expire"), false);
            com.tencent.mm.platformtools.r.ijX = bg.b(xVar.cS(".com.tencent.mm.debug.disaster_ignore_remove"), false);
            com.tencent.mm.platformtools.r.ijM = bg.b(xVar.cS(".com.tencent.mm.debug.netscene_sniffer.enable_snapshot"), false);
            com.tencent.mm.platformtools.r.ijO = bg.ap(xVar.getString(".com.tencent.mm.debug.netscene_sniffer.snapshot_protocal"), "");
            com.tencent.mm.platformtools.r.ijN = bg.b(xVar.cS(".com.tencent.mm.debug.netscene_sniffer.enable_inject"), false);
            com.tencent.mm.platformtools.r.ijP = bg.ap(xVar.getString(".com.tencent.mm.debug.netscene_sniffer.inject_protocal"), "");
            ComponentName er = bg.er(ab.getContext());
            if (er != null && er.getPackageName().equals(ab.getPackageName()) && er.getClassName().equals(ab.bIV())) {
                WorkerProfile.oC().fxi = true;
                WorkerProfile.oC().fxj = true;
                w.i(TAG, "start time check currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", er.getPackageName(), er.getClassName());
            } else {
                if (er != null) {
                    w.i(TAG, "start time check onCreate appOnCreate currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", er.getPackageName(), er.getClassName());
                } else {
                    w.i(TAG, "start time check onCreate appOnCreate currentActivity == null");
                }
                if (!(er == null || er.getPackageName().equals(ab.getPackageName()))) {
                    WorkerProfile.oC().fxi = true;
                }
            }
            com.tencent.mm.kernel.a.a.a(new com.tencent.mm.plugin.i.d(), eVar);
            com.tencent.mm.u.d.b.AG();
            com.tencent.mm.u.d.b.setup();
            AppLogic.setCallBack(new AppCallBack(ab.getContext()));
            SmcLogic.setCallBack(new com.tencent.mm.plugin.report.service.h());
            com.tencent.mm.plugin.report.service.h.oUu = (WorkerProfile) this.mProfileCompat;
            com.tencent.mm.compatible.util.k.b(com.tencent.mm.sdk.a.urR, WorkerProfile.class.getClassLoader());
            BaseEvent.onCreate();
            SmcLogic.SetDebugFlag(com.tencent.mm.plugin.report.a.c.oTe);
            n nVar = (n) h.j(n.class);
            h.j(com.tencent.mm.plugin.zero.a.d.class);
            new com.tencent.mm.plugin.i.e().after((com.tencent.mm.plugin.i.a) new com.tencent.mm.plugin.i.a().after((com.tencent.mm.plugin.i.c) new com.tencent.mm.plugin.i.c().after(nVar).before(this)).before(this)).before(this);
            new com.tencent.mm.plugin.i.b().after(nVar).before(this);
        }
        com.tencent.mm.pluginsdk.k.a.b.n.a(new com.tencent.mm.pluginsdk.k.a.a.a(this) {
            final /* synthetic */ PluginBigBallOfMud jPX;

            {
                this.jPX = r1;
            }

            public final boolean jI(int i) {
                if (i != 39 || com.tencent.mm.plugin.ipcall.d.aDM()) {
                    return false;
                }
                return true;
            }
        });
        com.tencent.mm.t.f.b.a(new com.tencent.mm.bn.b<com.tencent.mm.t.b>(this) {
            final /* synthetic */ PluginBigBallOfMud jPX;

            {
                this.jPX = r1;
            }

            public final /* synthetic */ Object get() {
                return new com.tencent.mm.t.b();
            }
        });
        com.tencent.mm.t.f.b.a(new com.tencent.mm.bn.b<com.tencent.mm.t.d>(this) {
            final /* synthetic */ PluginBigBallOfMud jPX;

            {
                this.jPX = r1;
            }

            public final /* synthetic */ Object get() {
                return new com.tencent.mm.t.d();
            }
        });
        com.tencent.mm.t.f.b.a(new com.tencent.mm.bn.b<com.tencent.mm.t.a>(this) {
            final /* synthetic */ PluginBigBallOfMud jPX;

            {
                this.jPX = r1;
            }

            public final /* synthetic */ Object get() {
                return new com.tencent.mm.t.a();
            }
        });
        com.tencent.mm.t.f.b.a(new com.tencent.mm.bn.b<com.tencent.mm.t.e>(this) {
            final /* synthetic */ PluginBigBallOfMud jPX;

            {
                this.jPX = r1;
            }

            public final /* synthetic */ Object get() {
                return new com.tencent.mm.t.e();
            }
        });
    }

    public void execute(com.tencent.mm.kernel.b.e eVar) {
    }

    private void autoScaleFontSize() {
    }

    public void onTerminate() {
        w.i(TAG, "onTerminate(%s)", ab.um());
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onTerminate();
        }
        MMAppMgr mMAppMgr = this.appMgr;
        Context context = this.app;
        if (mMAppMgr.uUk != null) {
            context.unregisterReceiver(mMAppMgr.uUk);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onConfigurationChanged(configuration);
        }
        Resources resources = ab.getResources();
        if (resources instanceof com.tencent.mm.bh.a) {
            ((com.tencent.mm.bh.a) resources).bHE();
        }
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        w.i(TAG, "onTrimMemory, level = %d, process = %s", Integer.valueOf(i), ab.um());
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onTrimMemory(i);
        }
    }

    public void onCreate() {
    }

    public void onBaseContextAttached(Context context) {
    }
}
