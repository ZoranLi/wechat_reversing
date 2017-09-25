package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import java.util.Arrays;
import java.util.Map;

public final class d {
    public static final c iBN = new c();

    enum a {
        NONE(0),
        REDDOT(1),
        NEW(2);
        
        final int value;

        private a(int i) {
            this.value = i;
        }
    }

    public static final class b implements com.tencent.mm.u.bp.a {
        private static final b iBS = new b();

        private b() {
        }

        public static void Rg() {
            c.QS();
            ap.getSysCmdMsgExtension().a("wxareddot", iBS, true);
        }

        public static void unregister() {
            c.QS();
            ap.getSysCmdMsgExtension().b("wxareddot", iBS, true);
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            final String a = n.a(aVar.hst.tff);
            if (!bg.mA(a)) {
                com.tencent.mm.plugin.appbrand.m.d.vL().D(new Runnable(this) {
                    final /* synthetic */ b iBT;

                    public final void run() {
                        b.nR(a);
                    }
                });
            }
        }

        public static void nR(String str) {
            w.i("MicroMsg.AppBrandPushNewOrRedDotLogic", "parseThenProcess, accReady %b, received xml %s", new Object[]{Boolean.valueOf(ap.zb()), str});
            if (ap.zb()) {
                Map q = bh.q(str, "sysmsg");
                if (q != null && q.size() > 0) {
                    String str2 = (String) q.get(".sysmsg.wxareddot.id");
                    int i = bg.getInt((String) q.get(".sysmsg.wxareddot.activitytype"), 0);
                    if (!bg.mA(str2)) {
                        if (i == 1 || i == 2) {
                            int i2 = bg.getInt((String) q.get(".sysmsg.wxareddot.close"), 0);
                            long j = bg.getLong((String) q.get(".sysmsg.wxareddot.pushtime"), 0);
                            long j2 = bg.getLong((String) q.get(".sysmsg.wxareddot.duration"), 0);
                            long j3 = bg.getLong((String) q.get(".sysmsg.wxareddot.frequency"), 0);
                            q.get(".sysmsg.wxareddot.tips");
                            int i3 = bg.getInt((String) q.get(".sysmsg.wxareddot.showType"), 0);
                            int i4 = bg.getInt((String) q.get(".sysmsg.wxareddot.reason"), 0);
                            switch (i) {
                                case 1:
                                    ap.yY();
                                    if (!str2.equals((String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uEl, null)) && !a.QL() && !bg.bk(ab.getContext()).equals(AppBrandLauncherUI.class.getName()) && c.QU() != a.iBJ) {
                                        h.vI().vr().a(com.tencent.mm.storage.w.a.uEl, str2);
                                        h.vI().vr().a(com.tencent.mm.storage.w.a.uEm, Long.valueOf(j));
                                        h.vI().vr().a(com.tencent.mm.storage.w.a.uEn, Integer.valueOf(i3));
                                        h.vI().vr().a(com.tencent.mm.storage.w.a.uEo, Integer.valueOf(i4));
                                        if (i2 == 1 && d.Rd()) {
                                            e eVar = e.iBZ;
                                            e.a((String) h.vI().vr().get(com.tencent.mm.storage.w.a.uEl, ""), ((Long) h.vI().vr().get(com.tencent.mm.storage.w.a.uEm, Long.valueOf(0))).longValue(), 4, e.Rh());
                                        }
                                        d.a(i2 != 1, j2);
                                        return;
                                    }
                                    return;
                                case 2:
                                    ap.yY();
                                    if (!str2.equals((String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uEs, null))) {
                                        d.a(i2 != 1, j2, j3);
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                }
            }
        }
    }

    public static final class c {
    }

    public static final class d {
        public final String[] iBY = new String[9];

        public d() {
            Arrays.fill(this.iBY, "0");
            String[] strArr = this.iBY;
            ap.yY();
            strArr[0] = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uEl, "");
            String[] strArr2 = this.iBY;
            ap.yY();
            strArr2[1] = String.valueOf(com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uEm, Long.valueOf(0)));
            this.iBY[2] = String.valueOf(bg.Ny());
        }
    }

    static final class e {
        static final e iBZ = new e();

        e() {
        }

        static int Rh() {
            if (h.vI().vr().c(com.tencent.mm.storage.w.a.uEr, false)) {
                return 1;
            }
            int intValue = ((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.uEo, Integer.valueOf(0))).intValue();
            if (intValue > 0) {
                return intValue + 1;
            }
            return intValue;
        }

        static void a(String str, long j, int i, int i2) {
            g.oUh.i(14112, new Object[]{Integer.valueOf(1), bg.mz(str), Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public static void a(boolean z, long j) {
        if (z) {
            long j2;
            if (j == 0) {
                j2 = Long.MAX_VALUE;
            } else {
                j2 = bg.Ny() + Math.max(0, j);
            }
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uEk, Long.valueOf(j2));
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uEw, Boolean.valueOf(true));
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uEq, Boolean.valueOf(false));
            e eVar = e.iBZ;
            e.a((String) h.vI().vr().get(com.tencent.mm.storage.w.a.uEl, ""), ((Long) h.vI().vr().get(com.tencent.mm.storage.w.a.uEm, Long.valueOf(0))).longValue(), 1, e.Rh());
            return;
        }
        ap.yY();
        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uEk, Long.valueOf(0));
    }

    public static void a(boolean z, long j, long j2) {
        long j3 = 0;
        ap.yY();
        t vr = com.tencent.mm.u.c.vr();
        com.tencent.mm.storage.w.a aVar = com.tencent.mm.storage.w.a.uEt;
        if (z) {
            j3 = Math.max(0, j) + bg.Ny();
        }
        vr.a(aVar, Long.valueOf(j3));
        ap.yY();
        t vr2 = com.tencent.mm.u.c.vr();
        com.tencent.mm.storage.w.a aVar2 = com.tencent.mm.storage.w.a.uEv;
        if (!z) {
            j2 = Long.MAX_VALUE;
        }
        vr2.a(aVar2, Long.valueOf(j2));
    }

    public static boolean Rb() {
        c.QS();
        if (!ap.zb()) {
            return false;
        }
        ap.yY();
        return ((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uEw, Boolean.valueOf(false))).booleanValue();
    }

    static a Rc() {
        int i = 0;
        if (!Rd()) {
            return a.NONE;
        }
        int intValue = ((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.uEn, Integer.valueOf(0))).intValue();
        a[] values = a.values();
        int length = values.length;
        while (i < length) {
            a aVar = values[i];
            if (aVar.value == intValue) {
                return aVar;
            }
            i++;
        }
        return a.NONE;
    }

    public static boolean Rd() {
        if (!ap.zb()) {
            return false;
        }
        long longValue = ((Long) h.vI().vr().get(com.tencent.mm.storage.w.a.uEk, Long.valueOf(0))).longValue();
        boolean z = longValue > bg.Ny();
        if (!z && longValue > 0) {
            h.vI().vr().a(com.tencent.mm.storage.w.a.uEk, Long.valueOf(0));
            e eVar = e.iBZ;
            e.a((String) h.vI().vr().get(com.tencent.mm.storage.w.a.uEl, ""), ((Long) h.vI().vr().get(com.tencent.mm.storage.w.a.uEm, Long.valueOf(0))).longValue(), 3, e.Rh());
        }
        return z;
    }

    static void Re() {
        c.QS();
        if (h.vG().uV()) {
            e eVar = e.iBZ;
            if (!((Boolean) h.vI().vr().get(com.tencent.mm.storage.w.a.uEq, Boolean.valueOf(false))).booleanValue()) {
                e.a((String) h.vI().vr().get(com.tencent.mm.storage.w.a.uEl, ""), ((Long) h.vI().vr().get(com.tencent.mm.storage.w.a.uEm, Long.valueOf(0))).longValue(), 0, e.Rh());
                h.vI().vr().a(com.tencent.mm.storage.w.a.uEq, Boolean.valueOf(true));
            }
        }
    }

    public static void Rf() {
        if (ap.zb() && Rd()) {
            a(false, 0);
            a(false, 0, 0);
            e eVar = e.iBZ;
            e.a((String) h.vI().vr().get(com.tencent.mm.storage.w.a.uEl, ""), ((Long) h.vI().vr().get(com.tencent.mm.storage.w.a.uEm, Long.valueOf(0))).longValue(), 2, e.Rh());
        }
    }
}
