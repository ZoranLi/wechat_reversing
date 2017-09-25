package com.tencent.mm.u.c;

import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.qd;
import com.tencent.mm.protocal.c.tp;
import com.tencent.mm.protocal.c.tq;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.d;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class b {
    public static boolean aaI = false;

    static void Au() {
        int i = 1;
        if (h.vG().uV()) {
            Long l = (Long) h.vI().vr().get(a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, null);
            long longValue = l == null ? 0 : l.longValue();
            int intValue;
            if (longValue == 0) {
                fm(new Random().nextInt(86400));
                Aw();
                Ax();
                w.i("MicroMsg.ABTestUpdater", "First update ignored. Next update: %d", Integer.valueOf(intValue));
            } else {
                Integer num = (Integer) h.vI().vr().get(a.USERINFO_ABTEST_UPDATE_TIME_INTERVAL_INT, null);
                intValue = (num == null || num.intValue() == 0) ? 86400 : num.intValue();
                long j = (long) intValue;
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String str = "MicroMsg.ABTestUpdater";
                String str2 = "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d";
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.valueOf(currentTimeMillis > longValue + j);
                objArr[1] = Long.valueOf(longValue);
                objArr[2] = Long.valueOf(j);
                objArr[3] = Long.valueOf(currentTimeMillis);
                w.i(str, str2, objArr);
                if (currentTimeMillis <= longValue + j) {
                    i = 0;
                }
            }
            if (i == 0) {
                w.v("MicroMsg.ABTestUpdater", "No need to update");
                return;
            } else if (aaI) {
                w.i("MicroMsg.ABTestUpdater", "Updating");
                return;
            } else {
                update();
                return;
            }
        }
        w.i("MicroMsg.ABTestUpdater", "Update aborted, Account not ready.");
    }

    static void Av() {
        if (!h.vG().uV()) {
            w.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit aborted, Account not ready.");
        } else if (aaI) {
            w.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, Already Updating");
        } else {
            w.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, before do update");
            update();
        }
    }

    private static void update() {
        aaI = true;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new tp();
        aVar.hsn = new tq();
        aVar.uri = "/cgi-bin/mmux-bin/getabtest";
        aVar.hsl = 1801;
        com.tencent.mm.y.b BE = aVar.BE();
        tp tpVar = (tp) BE.hsj.hsr;
        Integer num = (Integer) h.vI().vr().get(a.USERINFO_ABTEST_SERVER_TIMESTAMP_INT, null);
        tpVar.tBS = num == null ? 0 : num.intValue();
        tpVar.tBT = c.Az().bKI();
        tpVar.tBT.addAll(c.AA().bKI());
        String str = "MicroMsg.ABTestUpdater";
        String str2 = "update abtest: %s";
        Object[] objArr = new Object[1];
        Iterator it = tpVar.tBT.iterator();
        String str3 = "";
        while (it.hasNext()) {
            qd qdVar = (qd) it.next();
            str3 = str3 + qdVar.ttA + ":" + qdVar.priority + "|";
        }
        objArr[0] = str3;
        w.i(str, str2, objArr);
        u.a(BE, new u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                if (i == 0 && i2 == 0) {
                    tq tqVar = (tq) bVar.hsk.hsr;
                    b.Aw();
                    b.fn(tqVar.tvD);
                    b.fm(tqVar.tBW);
                    b.x(tqVar.tBX);
                    b.w(tqVar.tBV);
                    b.Ax();
                    w.i("MicroMsg.ABTestUpdater", "Update Interval: %d", Integer.valueOf(tqVar.tBW));
                    b.aaI = false;
                } else {
                    w.e("MicroMsg.ABTestUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(86400));
                    b.Aw();
                    b.fm(86400);
                    b.Ax();
                }
                return 0;
            }
        }, true);
    }

    public static void w(List<com.tencent.mm.bd.b> list) {
        if (list == null || list.size() == 0) {
            w.w("MicroMsg.ABTestUpdater", "No Exp");
            return;
        }
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        for (com.tencent.mm.bd.b a : list) {
            a.a gC = a.gC(n.a(a));
            linkedList.addAll(gC.hoO);
            linkedList2.addAll(gC.hoP);
        }
        c.Az().i(linkedList, 0);
        c.AA().i(linkedList2, 1);
    }

    public static void x(List<Integer> list) {
        if (bg.bV(list)) {
            w.w("MicroMsg.ABTestUpdater", "No expired Exp");
            return;
        }
        d Az = c.Az();
        if (!bg.bV(list)) {
            for (Integer num : list) {
                if (num != null) {
                    c cVar = new com.tencent.mm.storage.c();
                    cVar.field_expId = String.valueOf(num);
                    Az.a(cVar, "expId");
                }
            }
        }
        com.tencent.mm.storage.b AA = c.AA();
        if (!bg.bV(list)) {
            for (Integer num2 : list) {
                if (num2 != null) {
                    cVar = new com.tencent.mm.storage.a();
                    cVar.field_expId = String.valueOf(num2);
                    AA.a(cVar, "expId");
                }
            }
        }
    }

    public static void Aw() {
        h.vI().vr().a(a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, Long.valueOf(System.currentTimeMillis() / 1000));
    }

    public static void fm(int i) {
        int i2 = 0;
        if (i == 0) {
            i2 = 86400;
        } else if (i < 3600 || i > 129600) {
            i2 = new Random().nextInt(126000) + 3600;
        }
        h.vI().vr().a(a.USERINFO_ABTEST_UPDATE_TIME_INTERVAL_INT, Integer.valueOf(i2));
    }

    public static void fn(int i) {
        h.vI().vr().a(a.USERINFO_ABTEST_SERVER_TIMESTAMP_INT, Integer.valueOf(i));
    }

    public static void Ax() {
        h.vI().vr().jY(true);
    }
}
