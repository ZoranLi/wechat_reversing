package com.tencent.mm.kernel;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import com.tencent.mm.a.g;
import com.tencent.mm.a.h;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.bv;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.al;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.aq;
import com.tencent.mm.u.bu;
import com.tencent.mm.y.v;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

public final class a {
    private static boolean gXd = true;
    private static boolean gXe = false;
    static b gXg = new b();
    private static String gXh = "NoResetUinStack";
    private static String gXi = null;
    private static int gXn = -1;
    public c gXb;
    public final v gXc;
    byte[] gXf = new byte[0];
    public com.tencent.mm.u.a gXj;
    public int gXk = 0;
    public int gXl;
    public List<al> gXm = new LinkedList();
    volatile int gXo = a.gXv;
    public volatile boolean gXp = false;
    private String gXq = "";
    private Map<String, Integer> gXr = new HashMap();

    private enum a {
        ;

        static {
            gXv = 1;
            gXw = 2;
            gXx = new int[]{gXv, gXw};
        }
    }

    static final class b {
        private static boolean gXA = true;
        private boolean gXy = false;
        s gXz = this.gXW;
        private int uin = 0;

        b() {
        }

        public final synchronized int uH() {
            if (!this.gXy) {
                va();
                this.gXy = true;
            }
            return this.uin;
        }

        public final synchronized void dj(int i) {
            w.i("MMKernel.CoreAccount", "Uin From %s To %s hash:%d thread:%d[%s] stack:%s", o.getString(this.uin), o.getString(i), Integer.valueOf(h.aw(i, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bg.bJZ());
            Assert.assertNotNull(this.gXz);
            a(this.gXz, i);
            this.uin = i;
        }

        private synchronized void va() {
            int i = 0;
            synchronized (this) {
                Assert.assertNotNull(this.gXz);
                s sVar = this.gXz;
                if (sVar == null) {
                    w.w("MMKernel.CoreAccount", "summer read detault uin exception sysCfg is null!");
                } else {
                    Integer num = (Integer) sVar.get(1);
                    if (num == null) {
                        if (sVar.uyY) {
                            com.tencent.mm.plugin.report.c.oTb.a(148, 40, 1, false);
                        }
                        Integer valueOf = Integer.valueOf(ab.getContext().getSharedPreferences("system_config_prefs", 4).getInt("default_uin", 0));
                        if (valueOf != null) {
                            w.i("MMKernel.CoreAccount", "summer read detault uin[%d], bakUin[%d] sysCfg.isOpenException[%b]", num, valueOf, Boolean.valueOf(sVar.uyY));
                            if (gXA) {
                                w.w("MMKernel.CoreAccount", "summer read detault uin exception backup uin[%d], stack[%s]", valueOf, bg.bJZ());
                                com.tencent.mm.plugin.report.c.oTb.i(11911, Integer.valueOf(bg.f(valueOf)));
                                gXA = false;
                            }
                            a(sVar, valueOf.intValue());
                            num = valueOf;
                        }
                    }
                    w.i("MMKernel.CoreAccount", "summer getDefaultUin uin[%d]", Integer.valueOf(bg.f(num)));
                    i = bg.f(num);
                }
                this.uin = i;
            }
        }

        private static void a(s sVar, int i) {
            w.i("MMKernel.CoreAccount", "setSysUin uin: %d, stack: %s", Integer.valueOf(i), bg.bJZ());
            ab.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("default_uin", i).commit();
            sVar.set(1, Integer.valueOf(i));
        }
    }

    public a(c cVar) {
        Assert.assertNotNull(gXg);
        h.vJ();
        gXd = bg.f((Integer) h.vI().gXW.get(17)) != 0;
        this.gXc = new v();
        com.tencent.mm.protocal.i.c.a.sZi = new aq(702);
        this.gXb = cVar;
    }

    public static int uH() {
        return gXg.uH();
    }

    public static String uI() {
        return gXi;
    }

    public static String ea(String str) {
        gXi = str;
        return str;
    }

    public static String uJ() {
        return gXh;
    }

    public static void eb(String str) {
        gXh = str;
    }

    static boolean eL(int i) {
        return i != 0;
    }

    protected static void uK() {
        gXg.dj(0);
    }

    protected static void uL() {
        gXg.dj(0);
    }

    private void uM() {
        this.gXo = a.gXv;
        this.gXp = false;
        w.i("MMKernel.CoreAccount", "mAccountStatus to NotReady");
        ab.getContext().getSharedPreferences(ab.bIX(), 0).edit().putBoolean("isLogin", false).commit();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        w.w("MMKernel.CoreAccount", "[arthurdan.AccountNR] account storage reset! uin:%d, resetStack is:%s, resetTime:%s", Integer.valueOf(gXg.uH()), gXh, simpleDateFormat.format(new Date()));
    }

    final void uN() {
        w.w("MMKernel.CoreAccount", "account storage release  uin:%s thread:%s stack:%s", o.getString(gXg.uH()), Thread.currentThread().getName(), bg.bJZ());
        if (uV()) {
            this.gXb.onAccountRelease();
            h.vJ();
            h.vI().cQ(null);
            uM();
            h.vJ();
            h.vI().gYl.clear();
            return;
        }
        w.i("MMKernel.CoreAccount", "Fatal crash error!!! status is not initialized when release(), this callStack is:%s, last reset stack is:%s", bg.bJZ().toString(), gXh);
    }

    final void aP(boolean z) {
        w.i("MMKernel.CoreAccount", "UserStatusChange: clear");
        synchronized (this.gXm) {
            this.gXm.clear();
        }
        Object obj = (((Thread.currentThread().getId() > h.vL().nJF.getId() ? 1 : (Thread.currentThread().getId() == h.vL().nJF.getId() ? 0 : -1)) == 0 ? 1 : null) == null || h.vL().bJj()) ? null : 1;
        if (obj != null) {
            h.vL().bJi();
        }
        long currentTimeMillis = System.currentTimeMillis();
        int uH = gXg.uH();
        w.i("MMKernel.CoreAccount", "dkacc setAccuin %s hash:%d thread:%d[%s] stack:%s", o.getString(uH), Integer.valueOf(h.aw(uH, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bg.bJZ());
        if ((uH != 0 ? 1 : null) == null) {
            w.w("MMKernel.CoreAccount", "setAccUin, Reset by MMCore.resetAccUin");
        } else {
            boolean z2;
            long currentTimeMillis2;
            if (uV()) {
                uN();
            }
            o.getString(uH);
            h.vJ();
            e vI = h.vI();
            Runnable anonymousClass1 = new Runnable(this) {
                final /* synthetic */ a gXs;

                {
                    this.gXs = r1;
                }

                public final void run() {
                    this.gXs.gXo = a.gXw;
                }
            };
            ab.getContext().getSharedPreferences(ab.bIX(), 0).edit().putBoolean("isLogin", true).commit();
            String n = g.n(("mm" + uH).getBytes());
            vI.gYf = vI.gYe + n + "/";
            vI.cachePath = com.tencent.mm.storage.w.hgq + n + "/";
            File file = new File(vI.cachePath);
            w.i("MMKernel.CoreStorage", "dkacc cachePath:" + vI.cachePath + " accPath:" + vI.gYf);
            if (file.exists()) {
                z2 = false;
            } else {
                w.w("MMKernel.CoreStorage", "setUin REBUILD data now ! DO NOT FUCKING TELL ME DB BROKEN !!! uin:%s data:%s sd:%s", o.getString(uH), vI.cachePath, vI.gYf);
                file.mkdirs();
                if (!vI.cachePath.equalsIgnoreCase(vI.gYf)) {
                    currentTimeMillis2 = System.currentTimeMillis();
                    new File(vI.gYf).renameTo(new File(e.hgu + (n + "temp" + System.currentTimeMillis())));
                    w.i("MMKernel.CoreStorage", "find the old files and rename then %s" + (System.currentTimeMillis() - currentTimeMillis2), n);
                }
                z2 = true;
            }
            vI.gYk = new bu(vI.cachePath, z2);
            vI.vm();
            n = vI.cachePath + "MicroMsg.db";
            String str = vI.cachePath + "EnMicroMsg.db";
            String str2 = vI.cachePath + "EnMicroMsg2.db";
            vI.cQ(null);
            vI.gYg = new com.tencent.mm.bj.g(new com.tencent.mm.bj.g.a(vI) {
                final /* synthetic */ e gYr;

                {
                    this.gYr = r1;
                }

                public final void vy() {
                    if (this.gYr.gYi != null) {
                        w.i("MMKernel.CoreStorage", "summer preCloseCallback userConfigStg: " + this.gYr.gYi);
                        this.gYr.gYi.jY(true);
                    }
                    this.gYr.gYa.vy();
                }

                public final void vz() {
                    this.gYr.gYa.vz();
                }

                public final void vA() {
                    this.gYr.gYa.vA();
                }
            });
            if (vI.gYg.a(n, str, str2, (long) uH, p.rA(), vI.uh(), true)) {
                String str3 = vI.gYg.uLZ;
                if (!bg.mA(str3)) {
                    w.e("MMKernel.CoreStorage", "dbinit failed :" + str3);
                    com.tencent.mm.sdk.a.b.r("init db Failed: [ " + str3 + "]", "DBinit");
                }
                vI.gYi = new t(vI.gYg);
                vI.gYh = new com.tencent.mm.bj.g(vI.gYb);
                if (vI.gYh.a(n, str, str2, (long) uH, p.rA(), new HashMap(), true)) {
                    vI.gYj = new ba(vI.gYi);
                    vI.gYj.c(new com.tencent.mm.sdk.e.j.a(vI) {
                        final /* synthetic */ e gYr;

                        {
                            this.gYr = r1;
                        }

                        public final void a(String str, l lVar) {
                            p.du(str);
                        }
                    });
                    vI.gYj.bMT();
                    anonymousClass1.run();
                    vI.gXX.onDataBaseOpened(vI.gYg, vI.gYh);
                    ab.getContext().getSharedPreferences(ab.bIX() + uH, 0);
                    w.d("MMKernel.CoreStorage", "edw setAccUin, needTransfer = " + vI.vl());
                    if (z2) {
                        currentTimeMillis2 = ((Long) vI.gYi.get(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0))).longValue();
                        int intValue = ((Integer) vI.gYi.get(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0))).intValue();
                        if (currentTimeMillis2 > 0) {
                            w.w("MMKernel.CoreStorage", "summerinstall new install but firsttime[%d] > 0", Long.valueOf(currentTimeMillis2));
                        } else {
                            vI.gYi.a(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
                        }
                        if (intValue > 0) {
                            w.w("MMKernel.CoreStorage", "summerinstall new install but version[%d] > 0", Integer.valueOf(intValue));
                        } else {
                            vI.gYi.a(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(d.sYN));
                        }
                        w.i("MMKernel.CoreStorage", "edw setAccUin, summerinstall time[%d]，version[%d], clientversion[%d]", (Long) vI.gYi.get(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0)), (Integer) vI.gYi.get(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0)), Integer.valueOf(d.sYN));
                    }
                    w.d("MMKernel.CoreStorage", "edw postDataTransfer begin");
                    if (!z) {
                        Object obj2;
                        h.vJ();
                        w.i("MMKernel.CoreAccount", "summerinit validateUsername username[%s]", bg.mz((String) h.vI().vr().get(2, null)));
                        if (bg.mz((String) h.vI().vr().get(2, null)).length() <= 0) {
                            w.e("MMKernel.CoreAccount", "username of acc stg not set: uin=" + gXg.uH());
                            uM();
                            gXg.dj(0);
                            gXh = bg.bJZ().toString();
                            af.v(new Runnable(this) {
                                final /* synthetic */ a gXs;

                                {
                                    this.gXs = r1;
                                }

                                public final void run() {
                                    h.vJ().releaseAll();
                                }
                            });
                            obj2 = null;
                        } else {
                            obj2 = 1;
                        }
                        if (obj2 == null) {
                            com.tencent.mm.plugin.report.c.oTb.a(598, 21, 1, true);
                            w.w("MMKernel.CoreAccount", "setAccUin, validateUsername false no need initialize!");
                        }
                    }
                    h.vJ();
                    e vI2 = h.vI();
                    final f fVar = new f();
                    int f = bg.f((Integer) vI2.gYi.get(14, null));
                    int i = d.sYN;
                    boolean z3 = i == f ? false : (i <= 570425344 || f > 570425344) ? i > 570556456 && f <= 570556456 : true;
                    if (z3) {
                        vI2.gYi.set(8197, "");
                        vI2.gYi.set(15, Integer.valueOf(0));
                    }
                    boolean z4 = f != i;
                    if (f > 620822536 || f == i) {
                        vI2.gYi.set(274480, Boolean.valueOf(false));
                        w.i("MMKernel.CoreStorage", "[initialize] need not init emoji");
                    } else {
                        vI2.gYi.set(274480, Boolean.valueOf(true));
                        w.i("MMKernel.CoreStorage", "[initialize] need init emoji");
                    }
                    if (f != 0 && f < 637599744) {
                        vI2.gYi.set(348162, Boolean.valueOf(true));
                    }
                    boolean z5 = f != i;
                    if (z5) {
                        w.w("MMKernel.CoreStorage", "account storage version changed from " + Integer.toHexString(f) + " to " + Integer.toHexString(i) + ", init=" + z3);
                        if (((Integer) vI2.gXW.get(37, Integer.valueOf(0))).intValue() == 0) {
                            vI2.gXW.set(37, Integer.valueOf(f));
                        }
                        vI2.gYi.set(14, Integer.valueOf(i));
                        vI2.gYi.set(30, Boolean.valueOf(false));
                        vI2.gYi.set(-2046825377, Boolean.valueOf(false));
                        vI2.gYi.set(-2046825369, Boolean.valueOf(false));
                        vI2.gYi.set(54, Boolean.valueOf(false));
                        vI2.gYi.set(-2046825368, Boolean.valueOf(false));
                        vI2.gYi.set(-2046825366, Boolean.valueOf(true));
                        vI2.gYi.set(62, Boolean.valueOf(true));
                        ab.getContext().getSharedPreferences("update_config_prefs", 4).edit().clear().commit();
                        if ((f & -256) == (i & -256)) {
                            ad.Pt("show_whatsnew");
                        }
                    } else {
                        ad.Pt("show_whatsnew");
                    }
                    vI2.gXY.aR(z5);
                    fVar.gYz = z4;
                    fVar.gYA = f;
                    w.i("MMKernel.CoreAccount", "check is update :%b ", Boolean.valueOf(fVar.gYz));
                    w.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized tid:%d, stack[%s]", Long.valueOf(Thread.currentThread().getId()), bg.bJZ());
                    final long currentTimeMillis3 = System.currentTimeMillis();
                    if (af.isMainThread()) {
                        w.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized main tid[%d] post to worker tid[%d], stack[%s]", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(h.vL().nJF.getLooper().getThread().getId()), bg.bJZ());
                        h.vL().H(new Runnable(this) {
                            final /* synthetic */ a gXs;

                            public final void run() {
                                w.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                                this.gXs.gXb.onAccountInitialized(fVar);
                                this.gXs.uW();
                                w.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                            }
                        });
                    } else {
                        this.gXb.onAccountInitialized(fVar);
                        uW();
                        w.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                    }
                    ao.hlW.L("last_login_uin", o.getString(uH));
                    com.tencent.mm.plugin.report.c.oTb.dj(uH);
                    this.gXj = new com.tencent.mm.u.a();
                    w.i("MMKernel.CoreAccount", "setAccUin done :%s", o.getString(uH));
                    h.vJ();
                    if (h.vH().gXC != null) {
                        h.vJ();
                        if (h.vH().gXC.hsZ != null) {
                            h.vJ();
                            h.vH().gXC.hsZ.ba(true);
                            h.vJ();
                            com.tencent.mm.network.c Cc = h.vH().gXC.hsZ.Cc();
                            if (!(uH == 0 || Cc == null || uH == Cc.uH())) {
                                w.w("MMKernel.CoreAccount", "summerauth update acc info with acc stg: old acc uin=%d, this uin=%d", Integer.valueOf(Cc.uH()), Integer.valueOf(uH));
                                com.tencent.mm.plugin.report.c.oTb.a(148, 46, 1, false);
                                Cc.dj(uH);
                            }
                        }
                    }
                } else {
                    throw new com.tencent.mm.u.b((byte) 0);
                }
            }
            throw new SQLiteException("main db init failed");
        }
        w.i("MMKernel.CoreAccount", "start time check setUinImpl end total time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (obj != null) {
            h.vL().bJk();
        }
        w.i("MMKernel.CoreAccount", "mAccountStatus to AccountHasReady");
    }

    public static boolean uO() {
        return gXe;
    }

    public static void aQ(boolean z) {
        gXe = z;
    }

    public static boolean uP() {
        if (gXd) {
            String string;
            String str = "MMKernel.CoreAccount";
            String str2 = "account holded :%s init:%b";
            Object[] objArr = new Object[2];
            h.vJ();
            if (h.vG() != null) {
                h.vJ();
                h.vG();
                string = o.getString(gXg.uH());
            } else {
                string = "-1";
            }
            objArr[0] = string;
            objArr[1] = Boolean.valueOf(h.vG().uV());
            w.w(str, str2, objArr);
        }
        return gXd;
    }

    public static void hold() {
        String string;
        String str = "MMKernel.CoreAccount";
        String str2 = " HOLD ACCOUNT! uin:%s stack:%s init:%b";
        Object[] objArr = new Object[3];
        h.vJ();
        if (h.vG() != null) {
            h.vJ();
            h.vG();
            string = o.getString(gXg.uH());
        } else {
            string = "-1";
        }
        objArr[0] = string;
        objArr[1] = bg.bJZ();
        objArr[2] = Boolean.valueOf(h.vG().uV());
        w.w(str, str2, objArr);
        gXd = true;
        h.vJ();
        h.vI().gXW.set(17, Integer.valueOf(1));
    }

    public static void unhold() {
        String string;
        String str = "MMKernel.CoreAccount";
        String str2 = " UN HOLD ACCOUNT! uin:%s init:%b";
        Object[] objArr = new Object[2];
        h.vJ();
        if (h.vG() != null) {
            h.vJ();
            h.vG();
            string = o.getString(gXg.uH());
        } else {
            string = "-1";
        }
        objArr[0] = string;
        objArr[1] = Boolean.valueOf(h.vG().uV());
        w.w(str, str2, objArr);
        gXd = false;
        h.vJ();
        h.vI().gXW.set(17, Integer.valueOf(0));
    }

    public final void uQ() {
        if (!uV()) {
            throw new com.tencent.mm.u.b();
        }
    }

    public final void uR() {
        new ae(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ a gXs;

            {
                this.gXs = r1;
            }

            public final void run() {
                al[] alVarArr = new al[this.gXs.gXm.size()];
                this.gXs.gXm.toArray(alVarArr);
                for (al yP : alVarArr) {
                    yP.yP();
                }
            }
        });
    }

    public final void aF(int i, int i2) {
        int i3 = (this.gXk == i && this.gXl == i2) ? 0 : 1;
        w.d("MMKernel.CoreAccount", "online status, %d, %d, %d ,%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.gXl), Integer.valueOf(this.gXk));
        if (i3 != 0) {
            this.gXk = i;
            this.gXl = i2;
            new ae(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ a gXs;

                {
                    this.gXs = r1;
                }

                public final void run() {
                    this.gXs.uR();
                }
            });
        }
    }

    public static void eM(int i) {
        if (gXn == -1 || gXn != i) {
            gXn = i;
            uT().edit().putInt("notification.user.state", i).commit();
            w.i("MMKernel.CoreAccount", "[NOTIFICATION SETTINGS]save UserStatus: %d", Integer.valueOf(i));
        }
    }

    public static int uS() {
        return uT().getInt("notification.user.state", 0);
    }

    public static SharedPreferences uT() {
        return ab.getContext().getSharedPreferences("notify_key_pref_settings", 4);
    }

    public static boolean eN(int i) {
        return (i & 1) != 0;
    }

    public final void release() {
        synchronized (this.gXf) {
            uN();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize() {
        /*
        r6 = this;
        r0 = r6.uV();
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r1 = r6.gXf;
        monitor-enter(r1);
        r0 = r6.uV();	 Catch:{ all -> 0x0012 }
        if (r0 == 0) goto L_0x0015;
    L_0x0010:
        monitor-exit(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x0006;
    L_0x0012:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0012 }
        throw r0;
    L_0x0015:
        r0 = gXg;	 Catch:{ all -> 0x0012 }
        r0 = r0.uH();	 Catch:{ all -> 0x0012 }
        if (r0 == 0) goto L_0x003b;
    L_0x001d:
        r2 = "MMKernel.CoreAccount";
        r3 = "auto set up account storage uin: %d, stack: %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0012 }
        r5 = 0;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x0012 }
        r4[r5] = r0;	 Catch:{ all -> 0x0012 }
        r0 = 1;
        r5 = com.tencent.mm.sdk.platformtools.bg.bJZ();	 Catch:{ all -> 0x0012 }
        r4[r0] = r5;	 Catch:{ all -> 0x0012 }
        com.tencent.mm.sdk.platformtools.w.w(r2, r3, r4);	 Catch:{ all -> 0x0012 }
        r0 = 0;
        r6.aP(r0);	 Catch:{ all -> 0x0012 }
    L_0x003b:
        monitor-exit(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.a.initialize():void");
    }

    public static boolean uU() {
        return gXg.uH() != 0;
    }

    public final boolean uV() {
        return this.gXo == a.gXw;
    }

    public final void uW() {
        w.i("MMKernel.CoreAccount", "summerasyncinit setInitializedNotifyAllDone[%b] to true stack[%s]", Boolean.valueOf(this.gXp), bg.bJZ());
        this.gXp = true;
        com.tencent.mm.sdk.b.a.urY.m(new bv());
    }

    public static int uX() {
        return Integer.valueOf(ab.getContext().getSharedPreferences("system_config_prefs", 4).getInt("default_uin", 0)).intValue();
    }

    public static String uY() {
        h.vJ();
        if (bg.mA(h.vG().gXq)) {
            uZ();
        }
        h.vJ();
        return h.vG().gXq;
    }

    public static void uZ() {
        h.vJ();
        h.vG().gXq = p.rB() + "_" + System.currentTimeMillis();
        h.vJ();
        h.vG().gXr.clear();
    }

    public static int ec(String str) {
        int i;
        h.vJ();
        if (h.vG().gXr.get(str) == null) {
            i = 0;
        } else {
            h.vJ();
            i = ((Integer) h.vG().gXr.get(str)).intValue();
        }
        int Ny = (int) bg.Ny();
        if (i == 0) {
            h.vJ();
            h.vG().gXr.put(str, Integer.valueOf(Ny));
            return i;
        }
        i = Ny - i;
        h.vJ();
        h.vG().gXr.put(str, Integer.valueOf(Ny));
        return i < 0 ? 0 : i;
    }
}
