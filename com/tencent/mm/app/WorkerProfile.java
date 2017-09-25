package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.view.LayoutInflater;
import com.tencent.mm.R;
import com.tencent.mm.av.l;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.console.Shell;
import com.tencent.mm.e.a.ah;
import com.tencent.mm.e.a.im;
import com.tencent.mm.e.a.ki;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.performance.wxperformancetool.c;
import com.tencent.mm.performance.wxperformancetool.d;
import com.tencent.mm.plugin.report.service.IKVReportNotify;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.as.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ac;
import com.tencent.mm.u.ae;
import com.tencent.mm.u.af;
import com.tencent.mm.u.am;
import com.tencent.mm.u.an;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.f.a;
import com.tencent.mm.u.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI;
import com.tencent.mm.ui.tools.NewTaskUI;
import com.tencent.mm.y.k;
import com.tencent.mm.y.t;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class WorkerProfile extends e implements IKVReportNotify, ac, ae, an, a, com.tencent.mm.y.e, t.a {
    public static boolean fvY = false;
    public static final String fwe = (ab.getPackageName());
    private static WorkerProfile fxd;
    public static d fxq;
    private final Shell fwV = new Shell();
    private final com.tencent.mm.console.a fxc = new com.tencent.mm.console.a();
    private af fxe;
    private b fxf;
    private y fxg;
    private boolean fxh;
    @Deprecated
    public boolean fxi;
    public boolean fxj;
    private int fxk = 0;
    private final int fxl = 0;
    private final int fxm = 1;
    public int fxn;
    private final int fxo = 2130706432;
    public StringBuilder fxp = new StringBuilder();
    public g fxr;
    private com.tencent.mm.f.b fxs;
    public final p fxt = new p();
    public final o fxu = new o();
    protected Locale locale;

    public WorkerProfile() {
        fxd = this;
    }

    public static WorkerProfile oC() {
        return fxd;
    }

    public static void an(boolean z) {
        if (fxq != null) {
            d dVar = fxq;
            if (dVar.ihd != null) {
                c cVar = dVar.ihd;
                if (cVar.ihb != null && cVar.ihb.isAlive()) {
                    com.tencent.mm.performance.wxperformancetool.b bVar = cVar.ihb;
                    if (bVar.igY != z) {
                        bVar.igY = z;
                        bVar.mHandler.removeMessages(1);
                        if (!bVar.igY) {
                            bVar.mHandler.removeMessages(1);
                            bVar.mHandler.sendEmptyMessageDelayed(1, (long) com.tencent.mm.performance.wxperformancetool.b.igX);
                        }
                    }
                }
            }
        }
    }

    public final void onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.kiss.a.b vS = com.tencent.mm.kiss.a.b.vS();
        Looper looper = com.tencent.mm.kiss.a.a.vR().gZH.getLooper();
        LayoutInflater eC = r.eC(this.app);
        if (!vS.gZN) {
            vS.gZN = true;
            vS.Du = eC;
            vS.gZL = looper;
            vS.mMode = 2;
            vS.gZM = new com.tencent.mm.kiss.a.b.AnonymousClass1(vS, vS.gZL);
            vS.gZP = new b(looper);
        }
        a.be(fwe);
        w.v("MicroMsg.WorkerProfile", "workerProfile onCreate, step 1");
        fxq = new d(ab.getContext());
        w.i("MicroMsg.WorkerProfile", "start time check onCreate proc:%s pid:%d" + fwe + Process.myPid());
        oE();
        final Context context = ab.getContext();
        com.tencent.mm.j.a.a anonymousClass27 = new com.tencent.mm.j.a.a() {
            final Map<String, Integer> fxG = new HashMap();
            final Map<String, Integer> map = new HashMap();

            public final String bs(String str) {
                if (this.map.containsKey(str)) {
                    return context.getString(((Integer) this.map.get(str)).intValue());
                }
                return null;
            }

            public final String bt(String str) {
                if (this.fxG.containsKey(str)) {
                    return context.getString(((Integer) this.fxG.get(str)).intValue());
                }
                return null;
            }
        };
        anonymousClass27.map.put("qqmail", Integer.valueOf(R.l.erN));
        anonymousClass27.map.put("fmessage", Integer.valueOf(R.l.erl));
        anonymousClass27.map.put("floatbottle", Integer.valueOf(R.l.eqZ));
        anonymousClass27.map.put("lbsapp", Integer.valueOf(R.l.err));
        anonymousClass27.map.put("shakeapp", Integer.valueOf(R.l.erX));
        anonymousClass27.map.put("medianote", Integer.valueOf(R.l.erA));
        anonymousClass27.map.put("qqfriend", Integer.valueOf(R.l.erK));
        anonymousClass27.map.put("newsapp", Integer.valueOf(R.l.erT));
        anonymousClass27.map.put("facebookapp", Integer.valueOf(R.l.erf));
        anonymousClass27.map.put("masssendapp", Integer.valueOf(R.l.erx));
        anonymousClass27.map.put("meishiapp", Integer.valueOf(R.l.erD));
        anonymousClass27.map.put("feedsapp", Integer.valueOf(R.l.eri));
        anonymousClass27.map.put("voipapp", Integer.valueOf(R.l.ese));
        anonymousClass27.map.put("weixin", Integer.valueOf(R.l.eFg));
        anonymousClass27.map.put("filehelper", Integer.valueOf(R.l.eqV));
        anonymousClass27.map.put("cardpackage", Integer.valueOf(R.l.erc));
        anonymousClass27.map.put("officialaccounts", Integer.valueOf(R.l.erH));
        anonymousClass27.map.put("voicevoipapp", Integer.valueOf(R.l.esh));
        anonymousClass27.map.put("helper_entry", Integer.valueOf(R.l.ero));
        anonymousClass27.map.put("voiceinputapp", Integer.valueOf(R.l.esb));
        anonymousClass27.map.put("linkedinplugin", Integer.valueOf(R.l.eru));
        anonymousClass27.map.put("notifymessage", Integer.valueOf(R.l.erE));
        anonymousClass27.map.put("gh_43f2581f6fd6", Integer.valueOf(R.l.esa));
        anonymousClass27.map.put("appbrandcustomerservicemsg", Integer.valueOf(R.l.eqW));
        anonymousClass27.fxG.put("weixin", Integer.valueOf(R.l.eFf));
        com.tencent.mm.j.a.a(anonymousClass27);
        if (!f.rZ()) {
            com.tencent.mm.plugin.report.service.g.oUh.a(340, com.tencent.mm.compatible.util.d.eo(19) ? 5 : 6, 1, false);
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(com.tencent.mm.compatible.util.d.eo(19) ? 5001 : 5002);
            objArr[1] = String.format("%s;%s;%s", new Object[]{com.tencent.mm.compatible.util.e.hgs, Environment.getExternalStorageDirectory().getAbsolutePath(), h.getExternalStorageDirectory().getAbsolutePath()});
            gVar.i(11098, objArr);
        }
        w.i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(this.fxi), Integer.valueOf(com.tencent.mm.sdk.platformtools.f.fuV), Integer.valueOf(com.tencent.mm.protocal.d.sYN), bg.es(ab.getContext()));
    }

    public final synchronized boolean oD() {
        return this.fxk == 2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int oE() {
        /*
        r14 = this;
        r13 = 8;
        r12 = 2;
        r11 = -1;
        r1 = 1;
        r2 = 0;
        r0 = "MicroMsg.WorkerProfile";
        r3 = "appOnCreate start appCreateStatus %d, getAccStg %b, thread name %s";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = r14.fxk;
        r5 = java.lang.Integer.valueOf(r5);
        r4[r2] = r5;
        r5 = java.lang.Boolean.valueOf(r1);
        r4[r1] = r5;
        r5 = java.lang.Thread.currentThread();
        r5 = r5.getName();
        r4[r12] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r0, r3, r4);
        r4 = java.lang.System.currentTimeMillis();
        monitor-enter(r14);
        r0 = r14.fxk;	 Catch:{ all -> 0x0774 }
        if (r0 != 0) goto L_0x0770;
    L_0x0033:
        r0 = 1;
        r14.fxk = r0;	 Catch:{ all -> 0x0774 }
        monitor-exit(r14);	 Catch:{ all -> 0x0774 }
        r0 = com.tencent.mm.app.WorkerProfile.class;
        r0.getClassLoader();
        com.tencent.mm.sdk.platformtools.MMBitmapFactory.init();
        r0 = new com.tencent.mm.app.WorkerProfile$1;
        r0.<init>(r14);
        com.tencent.mm.u.ap.a(r14, r0);
        r0 = com.tencent.mm.u.d.a.AC();
        r3 = fwe;
        com.tencent.mm.u.d.a.fwL = r3;
        r3 = com.tencent.mm.sdk.platformtools.ab.usY;
        if (r3 == 0) goto L_0x006f;
    L_0x0053:
        r3 = com.tencent.mm.u.d.a.hpa;
        r3 = com.tencent.mm.loader.stub.b.deleteFile(r3);
        r6 = "MicroMsg.HandlerTraceManager";
        r7 = new java.lang.StringBuilder;
        r8 = "trace setup delete old file ret: ";
        r7.<init>(r8);
        r3 = r7.append(r3);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.w.i(r6, r3);
    L_0x006f:
        r6 = java.lang.System.currentTimeMillis();
        r0.hpp = r6;
        r3 = new com.tencent.mm.u.d.a$1;
        r3.<init>(r0);
        com.tencent.mm.sdk.platformtools.ae.setLogCallback(r3);
        r3 = "NetsceneQueue forbid in ";
        r6 = new com.tencent.mm.u.d.a$2;
        r6.<init>(r0);
        com.tencent.mm.sdk.platformtools.ai.a(r3, r6);
        r0 = com.tencent.mm.u.ap.vd();
        r0.a(r11, r14);
        com.tencent.mm.y.t.a(r14);
        r0 = com.tencent.mm.u.ap.zc();
        r0.hlh = r14;
        com.tencent.mm.u.ap.yR();
        com.tencent.mm.u.bn.hoe = r14;
        com.tencent.mm.u.ap.a(r14);
        r0 = com.tencent.mm.u.ap.yT();
        com.tencent.mm.u.ap.yY();
        r0.xH();
        r0 = new com.tencent.mm.app.WorkerProfile$12;
        r0.<init>(r14);
        com.tencent.mm.u.ap.a(r0);
        r0 = com.tencent.mm.u.ap.getSysCmdMsgExtension();
        r3 = "getkvidkeystg";
        r6 = new com.tencent.mm.app.WorkerProfile$23;
        r6.<init>(r14);
        r0.a(r3, r6, r1);
        r0 = r14.app;
        com.tencent.mm.sdk.platformtools.f.dW(r0);
        com.tencent.mm.sdk.platformtools.f.dX(r0);
        r3 = r0.getPackageManager();
        r0 = r0.getPackageName();	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r6 = 0;
        r0 = r3.getPackageInfo(r0, r6);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r0 = r0.applicationInfo;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = r0.sourceDir;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r0 = "MicroMsg.WorkerProfile";
        r6 = "initChannelUtil sourceFile = %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r8 = 0;
        r7[r8] = r3;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        com.tencent.mm.sdk.platformtools.w.i(r0, r6, r7);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r0 = com.tencent.mm.a.e.aN(r3);	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        r6 = "MicroMsg.WorkerProfile";
        r7 = "checkApkExternal, fileSize = %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        r9 = 0;
        r10 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        r8[r9] = r10;	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        com.tencent.mm.sdk.platformtools.w.i(r6, r7, r8);	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        if (r0 >= r13) goto L_0x0777;
    L_0x0102:
        r0 = com.tencent.mm.b.a.aZ(r3);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        if (r0 == 0) goto L_0x07fc;
    L_0x0108:
        r3 = r0.fuS;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        if (r3 == 0) goto L_0x07fc;
    L_0x010c:
        r3 = "MicroMsg.WorkerProfile";
        r6 = "apk external info not null";
        com.tencent.mm.sdk.platformtools.w.i(r3, r6);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = r0.fuS;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = r3.fuV;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        if (r3 == 0) goto L_0x012a;
    L_0x011b:
        r3 = r0.fuS;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = r3.fuV;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        com.tencent.mm.sdk.platformtools.f.fuV = r3;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = "MicroMsg.WorkerProfile";
        r6 = "read channelId from apk external";
        com.tencent.mm.sdk.platformtools.w.i(r3, r6);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
    L_0x012a:
        r3 = r0.fuS;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = r3.fuX;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        if (r3 == 0) goto L_0x014b;
    L_0x0130:
        r3 = r0.fuS;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = r3.fuX;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        com.tencent.mm.sdk.platformtools.f.fuX = r3;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = "MicroMsg.WorkerProfile";
        r6 = "ext.updateMode = %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r8 = 0;
        r9 = com.tencent.mm.sdk.platformtools.f.fuX;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r7[r8] = r9;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        com.tencent.mm.sdk.platformtools.w.i(r3, r6, r7);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
    L_0x014b:
        r3 = r0.fuS;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = r3.fuY;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        if (r3 == 0) goto L_0x015c;
    L_0x0151:
        r3 = r0.fuS;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = r3.fuY;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r6 = 0;
        r3 = com.tencent.mm.sdk.platformtools.bg.getInt(r3, r6);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        com.tencent.mm.sdk.platformtools.f.usr = r3;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
    L_0x015c:
        r3 = r0.fuS;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = r3.fuZ;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        if (r3 == 0) goto L_0x0168;
    L_0x0162:
        r3 = r0.fuS;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = r3.fuZ;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        com.tencent.mm.sdk.platformtools.f.uss = r3;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
    L_0x0168:
        r3 = r0.fuS;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = r3.fuW;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        if (r3 == 0) goto L_0x0174;
    L_0x016e:
        r3 = r0.fuS;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = r3.fuW;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        com.tencent.mm.sdk.platformtools.f.fuW = r3;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
    L_0x0174:
        r3 = r0.fuS;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = r3.fvc;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        if (r3 == 0) goto L_0x0195;
    L_0x017a:
        r3 = r0.fuS;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = r3.fvc;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        com.tencent.mm.sdk.platformtools.f.usw = r3;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = "MicroMsg.WorkerProfile";
        r6 = "ext.isNokiaol = %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r8 = 0;
        r9 = com.tencent.mm.sdk.platformtools.f.usw;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r9 = java.lang.Boolean.valueOf(r9);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r7[r8] = r9;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        com.tencent.mm.sdk.platformtools.w.i(r3, r6, r7);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
    L_0x0195:
        r3 = r0.fuS;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = r3.fvb;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        if (r3 == 0) goto L_0x01b6;
    L_0x019b:
        r3 = r0.fuS;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = r3.fvb;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        com.tencent.mm.sdk.platformtools.f.fvb = r3;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = "MicroMsg.WorkerProfile";
        r6 = "ext.autoAddAccount = %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r8 = 0;
        r9 = com.tencent.mm.sdk.platformtools.f.fvb;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r7[r8] = r9;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        com.tencent.mm.sdk.platformtools.w.i(r3, r6, r7);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
    L_0x01b6:
        r3 = r0.fuS;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r3 = r3.fva;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        if (r3 == 0) goto L_0x01d7;
    L_0x01bc:
        r0 = r0.fuS;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r0 = r0.fva;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        com.tencent.mm.sdk.platformtools.f.usv = r0;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r0 = "MicroMsg.WorkerProfile";
        r3 = "ext.shouldShowGprsAlert = %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r7 = 0;
        r8 = com.tencent.mm.sdk.platformtools.f.usv;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r8 = java.lang.Boolean.valueOf(r8);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r6[r7] = r8;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        com.tencent.mm.sdk.platformtools.w.i(r0, r3, r6);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
    L_0x01d7:
        com.tencent.mm.app.c.oa();
        r0 = r14.app;
        r0 = com.tencent.mm.booter.c.ao(r0);
        if (r0 == 0) goto L_0x01ea;
    L_0x01e2:
        r3 = r0.gJL;
        if (r3 == r11) goto L_0x01ea;
    L_0x01e6:
        r0 = r0.gJL;
        com.tencent.mm.sdk.platformtools.f.fuV = r0;
    L_0x01ea:
        r0 = r14.app;
        r0 = r0.getApplicationContext();
        r3 = com.tencent.mm.sdk.platformtools.f.fuV;
        r6 = com.tencent.mm.protocal.d.sYN;
        if (r0 == 0) goto L_0x01fc;
    L_0x01f6:
        if (r3 < 0) goto L_0x01fc;
    L_0x01f8:
        r7 = 637534208; // 0x26000000 float:4.440892E-16 double:3.1498375E-315;
        if (r6 >= r7) goto L_0x082a;
    L_0x01fc:
        r0 = com.tencent.mm.sdk.platformtools.f.usr;
        if (r0 <= 0) goto L_0x0202;
    L_0x0200:
        com.tencent.mm.sdk.platformtools.f.ust = r1;
    L_0x0202:
        com.tencent.mm.bb.d.bGP();
        r3 = new java.lang.StringBuilder;
        r0 = "android-";
        r3.<init>(r0);
        r0 = com.tencent.mm.sdk.platformtools.f.fuW;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 == 0) goto L_0x085e;
    L_0x0215:
        r0 = android.os.Build.VERSION.SDK_INT;
        r0 = java.lang.Integer.valueOf(r0);
    L_0x021b:
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.tencent.mm.protocal.d.DEVICE_TYPE = r0;
        r0 = com.tencent.mm.sdk.a.b.bIv();
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0245;
    L_0x022f:
        r0 = new java.lang.StringBuilder;
        r3 = "android-";
        r0.<init>(r3);
        r3 = com.tencent.mm.sdk.a.b.bIv();
        r0 = r0.append(r3);
        r0 = r0.toString();
        com.tencent.mm.protocal.d.DEVICE_TYPE = r0;
    L_0x0245:
        r0 = "MicroMsg.WorkerProfile";
        r3 = "set device type :%s  %s";
        r6 = new java.lang.Object[r12];
        r7 = com.tencent.mm.protocal.d.DEVICE_TYPE;
        r6[r2] = r7;
        r7 = com.tencent.mm.sdk.a.b.bIv();
        r6[r1] = r7;
        com.tencent.mm.sdk.platformtools.w.v(r0, r3, r6);
        r0 = r14.app;
        r0 = r0.getBaseContext();
        r0 = com.tencent.mm.ui.MMActivity.et(r0);
        r14.locale = r0;
        r0 = com.tencent.mm.sdk.a.b.bIu();
        if (r0 == 0) goto L_0x0284;
    L_0x026c:
        r0 = r14.fwV;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r3 = r0.gTJ;
        if (r3 != 0) goto L_0x0284;
    L_0x0276:
        r3 = new com.tencent.mm.console.Shell$Receiver;
        r3.<init>();
        r0.gTJ = r3;
        r0 = r0.gTJ;
        r3 = com.tencent.mm.console.Shell.gTL;
        r1.registerReceiver(r0, r3);
    L_0x0284:
        r0 = r14.fxc;
        r1 = com.tencent.mm.sdk.b.a.urY;
        r1.b(r0);
        r0 = new com.tencent.mm.app.b;
        r0.<init>();
        r1 = "MicroMsg.AvatarDrawable";
        r3 = new java.lang.StringBuilder;
        r6 = "setLoader";
        r3.<init>(r6);
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.w.d(r1, r3);
        com.tencent.mm.pluginsdk.ui.a.b.owB = r0;
        r0 = new com.tencent.mm.app.WorkerProfile$26;
        r0.<init>(r14);
        com.tencent.mm.pluginsdk.l.a.sBt = r0;
        r0 = com.tencent.mm.pluginsdk.j.class;
        r1 = new com.tencent.mm.kernel.c.c;
        r3 = r14.fxu;
        r1.<init>(r3);
        com.tencent.mm.kernel.h.a(r0, r1);
        r0 = com.tencent.mm.pluginsdk.f.class;
        r1 = new com.tencent.mm.kernel.c.c;
        r3 = r14.fxu;
        r1.<init>(r3);
        com.tencent.mm.kernel.h.a(r0, r1);
        r0 = com.tencent.mm.pluginsdk.g.class;
        r1 = new com.tencent.mm.kernel.c.c;
        r3 = r14.fxu;
        r1.<init>(r3);
        com.tencent.mm.kernel.h.a(r0, r1);
        r0 = "hp";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "profile";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "setting";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "subapp";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "nearby";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "brandservice";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "favorite";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "scanner";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "shake";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "wallet";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "mall";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "voip";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "radar";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "ext";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "accountsync";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "traceroute";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "qqmail";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "readerapp";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "talkroom";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "emoticon";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "sandbox";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "webview";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "bottle";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "masssend";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "emoji";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "game";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "location";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "clean";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "chatroom";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "safedevice";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "card";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "search";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "exdevice";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "translate";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "location_soso";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "extqlauncher";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "nearlife";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "freewifi";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "pwdgroup";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "gallery";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "label";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "address";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "wxcredit";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "offline";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "recharge";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "wallet_index";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "order";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "product";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "remittance";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "collect";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "extaccessories";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "gai";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "backup";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "record";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "webwx";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "notification";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "gesture";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "voiceprint";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "wear";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "wallet_payu";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "luckymoney";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "fingerprint";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "ipcall";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "voip_cs";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "multitalk";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "music";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "wenote";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "dbbackup";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "soter_mp";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "aa";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "sport";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "fps_lighter";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "photoedit";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = "mmsight";
        r1 = r14.fxt;
        r3 = r14.fxu;
        com.tencent.mm.bb.d.a(r0, r1, r3);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.plugin.b.a$a;
        r1.<init>();
        r0.b(r1);
        r0 = r14.fxe;
        if (r0 != 0) goto L_0x05ce;
    L_0x05c5:
        r0 = new com.tencent.mm.booter.notification.b;
        r1 = r14.app;
        r0.<init>(r1);
        r14.fxe = r0;
    L_0x05ce:
        r0 = new com.tencent.mm.f.b;
        r0.<init>();
        r14.fxs = r0;
        r0 = r14.fxs;
        r1 = "MicroMsg.BroadcastController";
        r3 = "summerdiz init";
        com.tencent.mm.sdk.platformtools.w.i(r1, r3);
        r1 = com.tencent.mm.sdk.b.a.urY;
        r0 = r0.gME;
        r1.b(r0);
        r0 = r14.fxh;
        if (r0 == 0) goto L_0x05f1;
    L_0x05eb:
        r0 = 0;
        r14.a(r0);
        r14.fxh = r2;
    L_0x05f1:
        r0 = com.tencent.mm.kiss.a.b.vS();
        r1 = com.tencent.mm.sdk.b.a.urY;
        r2 = new com.tencent.mm.kiss.a.b$2;
        r2.<init>(r0);
        r1.b(r2);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$30;
        r1.<init>(r14);
        r0.a(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.ui.bindqq.a;
        r1.<init>();
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$31;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$32;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$33;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$34;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$35;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$2;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$3;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$4;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$5;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$6;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$7;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$8;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$9;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$10;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$11;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$13;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$14;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$15;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$16;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$17;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$18;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$19;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$20;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$21;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$22;
        r1.<init>(r14);
        r0.b(r1);
        r0 = com.tencent.mm.sdk.b.a.urY;
        r1 = new com.tencent.mm.app.WorkerProfile$24;
        r1.<init>(r14);
        r0.b(r1);
        r0 = new com.tencent.mm.ui.transmit.d;
        r0.<init>();
        com.tencent.mm.plugin.messenger.a.d.nyj = r0;
        r0 = new com.tencent.mm.app.plugin.a;
        r0.<init>();
        com.tencent.mm.pluginsdk.l.a.sBA = r0;
        r0 = new com.tencent.mm.app.plugin.d;
        r0.<init>();
        com.tencent.mm.pluginsdk.l.a.sBB = r0;
        r0 = com.tencent.mm.app.plugin.e.oM();
        com.tencent.mm.pluginsdk.ui.d.b.a.sTh = r0;
        r0 = com.tencent.mm.u.ap.uP();
        if (r0 != 0) goto L_0x073b;
    L_0x0738:
        com.tencent.mm.u.ap.yY();
    L_0x073b:
        r0 = new com.tencent.mm.e.a.ca;
        r0.<init>();
        r1 = com.tencent.mm.sdk.b.a.urY;
        r1.m(r0);
        monitor-enter(r14);
        r0 = 2;
        r14.fxk = r0;	 Catch:{ all -> 0x0862 }
        monitor-exit(r14);	 Catch:{ all -> 0x0862 }
        r0 = new com.tencent.mm.app.WorkerProfile$25;
        r0.<init>(r14);
        com.tencent.mm.opensdk.utils.Log.setLogImpl(r0);
        r0 = "MicroMsg.WorkerProfile";
        r1 = new java.lang.StringBuilder;
        r2 = "start time check WorkerProfile appOnCreate use time ";
        r1.<init>(r2);
        r2 = java.lang.System.currentTimeMillis();
        r2 = r2 - r4;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.d(r0, r1);
        r0 = r14.fxk;
    L_0x076f:
        return r0;
    L_0x0770:
        r0 = r14.fxk;	 Catch:{ all -> 0x0774 }
        monitor-exit(r14);	 Catch:{ all -> 0x0774 }
        goto L_0x076f;
    L_0x0774:
        r0 = move-exception;
        monitor-exit(r14);	 Catch:{ all -> 0x0774 }
        throw r0;
    L_0x0777:
        r6 = r0 + -8;
        r7 = 8;
        r6 = com.tencent.mm.a.e.d(r3, r6, r7);	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        r6 = com.tencent.mm.b.a.a.r(r6);	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        if (r6 != 0) goto L_0x07be;
    L_0x0785:
        r0 = "MicroMsg.WorkerProfile";
        r6 = "checkApkExternal, header null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r6);	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        goto L_0x0102;
    L_0x0790:
        r0 = move-exception;
        r6 = "MicroMsg.WorkerProfile";
        r7 = "";
        r8 = 0;
        r8 = new java.lang.Object[r8];	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r6, r0, r7, r8);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r6 = "MicroMsg.WorkerProfile";
        r7 = "Exception in checkApkExternal, %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r9 = 0;
        r0 = r0.getMessage();	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r8[r9] = r0;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        com.tencent.mm.sdk.platformtools.w.e(r6, r7, r8);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        goto L_0x0102;
    L_0x07b2:
        r0 = move-exception;
        r0 = "MicroMsg.WorkerProfile";
        r3 = "initChannelUtil NameNotFoundException";
        com.tencent.mm.sdk.platformtools.w.e(r0, r3);
        goto L_0x01d7;
    L_0x07be:
        r7 = r6.fuU;	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        r7 = r7 + 8;
        r7 = r7 + -8;
        if (r7 < 0) goto L_0x07f1;
    L_0x07c6:
        r7 = new com.tencent.mm.b.b;	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        r7.<init>();	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        r8 = r6.fuU;	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        r8 = r8 + 8;
        r8 = r8 + -8;
        r0 = r0 - r8;
        r0 = r0 + -8;
        r6 = r6.fuU;	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        r6 = r6 + 8;
        r6 = r6 + -8;
        r0 = com.tencent.mm.a.e.d(r3, r0, r6);	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        r7.aD(r0);	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        r0 = new com.tencent.mm.b.a;	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        r0.<init>(r7);	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        r0 = "MicroMsg.WorkerProfile";
        r6 = "checkApkExternal, check ok";
        com.tencent.mm.sdk.platformtools.w.i(r0, r6);	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        goto L_0x0102;
    L_0x07f1:
        r0 = "MicroMsg.WorkerProfile";
        r6 = "checkApkExternal header wrong";
        com.tencent.mm.sdk.platformtools.w.e(r0, r6);	 Catch:{ Exception -> 0x0790, NameNotFoundException -> 0x07b2 }
        goto L_0x0102;
    L_0x07fc:
        r3 = "MicroMsg.WorkerProfile";
        r6 = "initChannelUtil something null %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r8 = 0;
        if (r0 != 0) goto L_0x0828;
    L_0x0808:
        r0 = r1;
    L_0x0809:
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        r7[r8] = r0;	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        com.tencent.mm.sdk.platformtools.w.e(r3, r6, r7);	 Catch:{ NameNotFoundException -> 0x07b2, Exception -> 0x0814 }
        goto L_0x01d7;
    L_0x0814:
        r0 = move-exception;
        r3 = "MicroMsg.WorkerProfile";
        r6 = "Exception in initChannel, %s";
        r7 = new java.lang.Object[r1];
        r0 = r0.getMessage();
        r7[r2] = r0;
        com.tencent.mm.sdk.platformtools.w.e(r3, r6, r7);
        goto L_0x01d7;
    L_0x0828:
        r0 = r2;
        goto L_0x0809;
    L_0x082a:
        r7 = "crash_status_file";
        r8 = 4;
        r0 = r0.getSharedPreferences(r7, r8);	 Catch:{ Throwable -> 0x085b }
        r7 = "channel";
        r8 = -1;
        r7 = r0.getInt(r7, r8);	 Catch:{ Throwable -> 0x085b }
        r8 = "version";
        r9 = 0;
        r8 = r0.getInt(r8, r9);	 Catch:{ Throwable -> 0x085b }
        if (r7 != r3) goto L_0x0846;
    L_0x0844:
        if (r8 == r6) goto L_0x01fc;
    L_0x0846:
        r0 = r0.edit();	 Catch:{ Throwable -> 0x085b }
        r7 = "channel";
        r0.putInt(r7, r3);	 Catch:{ Throwable -> 0x085b }
        r3 = "version";
        r0.putInt(r3, r6);	 Catch:{ Throwable -> 0x085b }
        r0.commit();	 Catch:{ Throwable -> 0x085b }
        goto L_0x01fc;
    L_0x085b:
        r0 = move-exception;
        goto L_0x01fc;
    L_0x085e:
        r0 = com.tencent.mm.sdk.platformtools.f.fuW;
        goto L_0x021b;
    L_0x0862:
        r0 = move-exception;
        monitor-exit(r14);	 Catch:{ all -> 0x0862 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.WorkerProfile.oE():int");
    }

    public static boolean oF() {
        if (com.tencent.mm.am.b.HJ()) {
            return false;
        }
        com.tencent.mm.sdk.b.b qkVar = new qk();
        qkVar.fXu.fXw = true;
        com.tencent.mm.sdk.b.a.urY.m(qkVar);
        if (bg.mA(qkVar.fXv.fXy)) {
            return true;
        }
        return false;
    }

    public final void onTerminate() {
        super.onTerminate();
        com.tencent.mm.f.b bVar = this.fxs;
        w.i("MicroMsg.BroadcastController", "summerdiz release oldNoticeInfo[%s], newDisasterNoticeInfoMap[%d]", bVar.gMB, Integer.valueOf(bVar.gMD.size()));
        com.tencent.mm.sdk.b.a.urY.c(bVar.gME);
        bVar.gMB = null;
        bVar.gMC.clear();
        bVar.gMD.clear();
        this.fxs = null;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        String property = bc.getProperty("system_property_key_locale");
        if (property != null && property.length() > 0) {
            this.locale = new Locale(property);
        }
        synchronized (this) {
            if (oD()) {
                a(configuration);
                return;
            }
            this.fxh = true;
        }
    }

    private void a(Configuration configuration) {
        v.b(configuration);
        String property = bc.getProperty("system_property_key_locale");
        if (property != null && property.length() > 0) {
            if ("language_default".equalsIgnoreCase(property)) {
                this.locale = Locale.getDefault();
            } else {
                String[] split = property.split("_");
                if (split == null || split.length < 2) {
                    this.locale = new Locale(property);
                } else {
                    w.d("MicroMsg.WorkerProfile", "initLanguage arr.length = %s", Integer.valueOf(split.length));
                    this.locale = new Locale(split[0], split[1]);
                }
            }
        }
        Locale et = MMActivity.et(this.app.getBaseContext());
        w.d("MicroMsg.WorkerProfile", "onConfigurationChanged, locale = %s, n = %s, lang = %s", this.locale, et, property);
        if (et != null && this.locale != null && !et.equals(this.locale)) {
            if (ap.zb()) {
                try {
                    com.tencent.mm.network.e eVar = ap.vd().hsZ;
                    if (eVar != null) {
                        com.tencent.mm.network.c Cc = eVar.Cc();
                        if (Cc != null) {
                            byte[] bArr = new byte[0];
                            ap.yY();
                            Cc.i(bArr, com.tencent.mm.u.c.uH());
                        }
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.WorkerProfile", e, "", new Object[0]);
                    w.printErrStackTrace("MicroMsg.WorkerProfile", e, "what the f$!k", new Object[0]);
                }
            }
            w.w("MicroMsg.WorkerProfile", "language changed, restart process");
            System.exit(-1);
        }
    }

    public final String toString() {
        return fwe;
    }

    public final af getNotification() {
        if (this.fxe == null) {
            this.fxe = new com.tencent.mm.booter.notification.b(this.app);
        }
        return this.fxe;
    }

    public final b oG() {
        if (this.fxf == null) {
            this.fxf = new b(this) {
                final /* synthetic */ WorkerProfile fxv;

                {
                    this.fxv = r1;
                }

                public final void a(au auVar, PString pString, PString pString2, PInt pInt, boolean z) {
                    com.tencent.mm.booter.notification.a.h.b(auVar, pString, pString2, pInt, z);
                }

                public final String a(int i, String str, String str2, int i2, Context context) {
                    return com.tencent.mm.booter.notification.a.h.a(i, str, str2, i2, context);
                }
            };
        }
        return this.fxf;
    }

    public final y oH() {
        if (this.fxg == null) {
            this.fxg = com.tencent.mm.booter.a.pQ();
        }
        return this.fxg;
    }

    public final Map<String, am> oI() {
        Map<String, am> hashMap = new HashMap();
        hashMap.put(l.class.getName(), new l());
        hashMap.put(com.tencent.mm.pluginsdk.model.app.an.class.getName(), new com.tencent.mm.pluginsdk.model.app.an());
        hashMap.put(com.tencent.mm.modelfriend.af.class.getName(), new com.tencent.mm.modelfriend.af());
        hashMap.put(q.class.getName(), new q());
        com.tencent.mm.bb.d.o("hp", hashMap);
        com.tencent.mm.bb.d.o("profile", hashMap);
        com.tencent.mm.bb.d.o("setting", hashMap);
        com.tencent.mm.bb.d.o("subapp", hashMap);
        com.tencent.mm.bb.d.o("sandbox", hashMap);
        com.tencent.mm.bb.d.o("nearby", hashMap);
        com.tencent.mm.bb.d.o("brandservice", hashMap);
        com.tencent.mm.bb.d.o("wallet_core", hashMap);
        com.tencent.mm.bb.d.o("wallet", hashMap);
        com.tencent.mm.bb.d.o("mall", hashMap);
        com.tencent.mm.bb.d.o("favorite", hashMap);
        com.tencent.mm.bb.d.o("scanner", hashMap);
        com.tencent.mm.bb.d.o("shake", hashMap);
        com.tencent.mm.bb.d.o("voip", hashMap);
        com.tencent.mm.bb.d.o("radar", hashMap);
        com.tencent.mm.bb.d.o("ext", hashMap);
        com.tencent.mm.bb.d.o("emoji", hashMap);
        com.tencent.mm.bb.d.o("emoticon", hashMap);
        com.tencent.mm.bb.d.o("accountsync", hashMap);
        com.tencent.mm.bb.d.o("qqmail", hashMap);
        com.tencent.mm.bb.d.o("readerapp", hashMap);
        com.tencent.mm.bb.d.o("talkroom", hashMap);
        com.tencent.mm.bb.d.o("game", hashMap);
        com.tencent.mm.bb.d.o("bottle", hashMap);
        com.tencent.mm.bb.d.o("masssend", hashMap);
        com.tencent.mm.bb.d.o("chatroom", hashMap);
        com.tencent.mm.bb.d.o("location", hashMap);
        com.tencent.mm.bb.d.o("clean", hashMap);
        com.tencent.mm.bb.d.o("safedevice", hashMap);
        com.tencent.mm.bb.d.o("card", hashMap);
        com.tencent.mm.bb.d.o("search", hashMap);
        com.tencent.mm.bb.d.o("translate", hashMap);
        com.tencent.mm.bb.d.o("extqlauncher", hashMap);
        com.tencent.mm.bb.d.o("nearlife", hashMap);
        com.tencent.mm.bb.d.o("webview", hashMap);
        com.tencent.mm.bb.d.o("exdevice", hashMap);
        com.tencent.mm.bb.d.o("freewifi", hashMap);
        com.tencent.mm.bb.d.o("freewifi", hashMap);
        com.tencent.mm.bb.d.o("pwdgroup", hashMap);
        com.tencent.mm.bb.d.o("gallery", hashMap);
        com.tencent.mm.bb.d.o("gesture", hashMap);
        com.tencent.mm.bb.d.o("wallet_payu", hashMap);
        com.tencent.mm.bb.d.o("label", hashMap);
        com.tencent.mm.bb.d.o("address", hashMap);
        com.tencent.mm.bb.d.o("wxcredit", hashMap);
        com.tencent.mm.bb.d.o("offline", hashMap);
        com.tencent.mm.bb.d.o("recharge", hashMap);
        com.tencent.mm.bb.d.o("order", hashMap);
        com.tencent.mm.bb.d.o("product", hashMap);
        com.tencent.mm.bb.d.o("wallet_index", hashMap);
        com.tencent.mm.bb.d.o("remittance", hashMap);
        com.tencent.mm.bb.d.o("collect", hashMap);
        com.tencent.mm.bb.d.o("backup", hashMap);
        com.tencent.mm.bb.d.o("record", hashMap);
        com.tencent.mm.bb.d.o("webwx", hashMap);
        com.tencent.mm.bb.d.o("notification", hashMap);
        com.tencent.mm.bb.d.o("extaccessories", hashMap);
        com.tencent.mm.bb.d.o("voiceprint", hashMap);
        com.tencent.mm.bb.d.o("wear", hashMap);
        com.tencent.mm.bb.d.o("auto", hashMap);
        com.tencent.mm.bb.d.o("gai", hashMap);
        com.tencent.mm.bb.d.o("nfc", hashMap);
        com.tencent.mm.bb.d.o("luckymoney", hashMap);
        com.tencent.mm.bb.d.o("tmassistant", hashMap);
        com.tencent.mm.bb.d.o("fingerprint", hashMap);
        com.tencent.mm.bb.d.o("nfc_open", hashMap);
        com.tencent.mm.bb.d.o("ipcall", hashMap);
        com.tencent.mm.bb.d.o("voip_cs", hashMap);
        com.tencent.mm.bb.d.o("multitalk", hashMap);
        com.tencent.mm.bb.d.o("music", hashMap);
        com.tencent.mm.bb.d.o("wenote", hashMap);
        com.tencent.mm.bb.d.o("dbbackup", hashMap);
        com.tencent.mm.bb.d.o("soter_mp", hashMap);
        com.tencent.mm.bb.d.o("sl_warpgate", hashMap);
        if (BaseBuildInfo.ENABLE_STETHO) {
            com.tencent.mm.bb.d.o("stetho", hashMap);
        }
        com.tencent.mm.bb.d.o("aa", hashMap);
        com.tencent.mm.bb.d.o("sport", hashMap);
        com.tencent.mm.bb.d.o("fps_lighter", hashMap);
        com.tencent.mm.bb.d.o("photoedit", hashMap);
        com.tencent.mm.bb.d.o("mmsight", hashMap);
        com.tencent.mm.bb.d.o("facedetect", hashMap);
        com.tencent.mm.sdk.b.a.urY.m(new ki());
        w.i("MicroMsg.WorkerProfile", "publish on SubCore inited event.");
        return hashMap;
    }

    public final List<com.tencent.mm.u.ab> getDataTransferList() {
        List<com.tencent.mm.u.ab> arrayList = new ArrayList();
        arrayList.add(new com.tencent.mm.ab.d());
        arrayList.add(new com.tencent.mm.ab.g());
        arrayList.add(new com.tencent.mm.ab.e());
        arrayList.add(new com.tencent.mm.ab.f());
        arrayList.add(new com.tencent.mm.ab.a());
        arrayList.add(new com.tencent.mm.ab.c());
        arrayList.add(new com.tencent.mm.ab.h());
        arrayList.add(new com.tencent.mm.ab.b());
        return arrayList;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.WorkerProfile", "onSceneEnd dkwt type:%d [%d,%d,%s]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 3 && i2 == -1) {
            w.i("MicroMsg.WorkerProfile", "getStack([ %s ]), ThreadID: %s", bg.bJZ(), Long.valueOf(Thread.currentThread().getId()));
        }
        com.tencent.mm.sdk.b.b ahVar;
        if (i == 4 && i2 == -3002) {
            if (bg.mA(str)) {
                w.e("MicroMsg.WorkerProfile", "summerdiz -3002 but errMsg is null");
                return;
            }
            if (str.startsWith("autoauth_errmsg_")) {
                str = str.substring(16);
            }
            w.i("MicroMsg.WorkerProfile", "summerdiz MM_ERR_IDCDISASTER -3002 errStr:%s", str);
            ahVar = new ah();
            ahVar.fDx.type = 4;
            ahVar.fDx.fDz = str;
            com.tencent.mm.sdk.b.a.urY.m(ahVar);
        } else if (ap.zb() && i == 4 && ((i2 == -6 || i2 == -310 || i2 == -311) && str != null && str.startsWith("autoauth_errmsg_"))) {
            if (NewTaskUI.bZP() == null) {
                r0 = new Intent();
                r0.setClass(ab.getContext(), NewTaskUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                ab.getContext().startActivity(r0);
            }
        } else if (i == 4 && i2 == -213) {
            ahVar = new im();
            ahVar.fOk.status = 0;
            ahVar.fOk.fOl = 3;
            com.tencent.mm.sdk.b.a.urY.m(ahVar);
            if (AccountDeletedAlphaAlertUI.bZr() == null) {
                r0 = new Intent();
                r0.setClass(ab.getContext(), AccountDeletedAlphaAlertUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                r0.putExtra("errmsg", str);
                ab.getContext().startActivity(r0);
            }
        }
    }

    public final void onReportKVDataReady(byte[] bArr, final byte[] bArr2, final int i) {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ WorkerProfile fxv;

            public final void run() {
                if (!ap.yQ()) {
                    w.i("MicroMsg.WorkerProfile", "summeranrt onReportKVDataReady channel:" + i);
                    ap.vd().a(new com.tencent.mm.plugin.report.b.e(bArr2, i), 0);
                }
            }
        });
    }

    public final void bq(String str) {
        w.i("MicroMsg.WorkerProfile", "summerdiz onOldDisaster errStr[%s]", str);
        com.tencent.mm.sdk.b.b ahVar = new ah();
        ahVar.fDx.type = 4;
        ahVar.fDx.fDz = str;
        com.tencent.mm.sdk.b.a.urY.m(ahVar);
    }

    public final void br(String str) {
        w.i("MicroMsg.WorkerProfile", "summerdiz onReMoveNoticeId:%s", str);
        com.tencent.mm.sdk.b.b ahVar = new ah();
        ahVar.fDx.type = 1;
        ahVar.fDx.fDz = str;
        com.tencent.mm.sdk.b.a.urY.m(ahVar);
    }
}
