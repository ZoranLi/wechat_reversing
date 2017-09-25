package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.qd;
import com.tencent.mm.protocal.c.tp;
import com.tencent.mm.protocal.c.tq;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.b;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class f {
    private static boolean DEBUG = false;
    public static boolean aaI = false;

    static void E(boolean z, boolean z2) {
        w.i("MicroMsg.WelabUpdater", "tryToUpdate isUpgrade %s, isManualAuth %s ", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (h.vG().uV()) {
            if (!(DEBUG || z || z2)) {
                Object obj;
                Long l = (Long) h.vI().vr().get(a.uHy, null);
                long longValue = l == null ? 0 : l.longValue();
                int intValue;
                if (longValue == 0) {
                    fm(new Random().nextInt(86400));
                    Aw();
                    Ax();
                    w.i("MicroMsg.WelabUpdater", "First update ignored. Next update: %d", new Object[]{Integer.valueOf(intValue)});
                    obj = 1;
                } else {
                    Integer num = (Integer) h.vI().vr().get(a.uHz, null);
                    intValue = (num == null || num.intValue() == 0) ? 86400 : num.intValue();
                    long j = (long) intValue;
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    String str = "MicroMsg.WelabUpdater";
                    String str2 = "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d";
                    Object[] objArr = new Object[4];
                    objArr[0] = Boolean.valueOf(currentTimeMillis > longValue + j);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Long.valueOf(j);
                    objArr[3] = Long.valueOf(currentTimeMillis);
                    w.i(str, str2, objArr);
                    obj = currentTimeMillis > longValue + j ? 1 : null;
                }
                if (obj == null) {
                    w.v("MicroMsg.WelabUpdater", "No need to update");
                    return;
                }
            }
            if (aaI) {
                w.i("MicroMsg.WelabUpdater", "Updating");
                return;
            }
            aaI = true;
            b.a aVar = new b.a();
            aVar.hsm = new tp();
            aVar.hsn = new tq();
            aVar.uri = "/cgi-bin/mmux-bin/getlabsinfo";
            aVar.hsl = 1816;
            b BE = aVar.BE();
            tp tpVar = (tp) BE.hsj.hsr;
            Integer num2 = (Integer) h.vI().vr().get(a.uHA, null);
            tpVar.tBS = num2 == null ? 0 : num2.intValue();
            tpVar.tBT = bAI();
            tpVar.tBU = (int) bg.Ny();
            if (z) {
                tpVar.fRW |= 1;
            }
            if (z2) {
                tpVar.fRW |= 2;
            }
            w.i("MicroMsg.WelabUpdater", "update abtest: %s", new Object[]{ar(tpVar.tBT)});
            u.a(BE, new u.a() {
                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    if (i == 0 && i2 == 0) {
                        tq tqVar = (tq) bVar.hsk.hsr;
                        f.Aw();
                        f.fn(tqVar.tvD);
                        f.fm(tqVar.tBW);
                        f.x(tqVar.tBX);
                        f.w(tqVar.tBV);
                        f.Ax();
                        w.i("MicroMsg.WelabUpdater", "Update Interval: %d", new Object[]{Integer.valueOf(tqVar.tBW)});
                        f.aaI = false;
                    } else {
                        w.e("MicroMsg.WelabUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(86400)});
                        f.Aw();
                        f.fm(86400);
                        f.Ax();
                    }
                    return 0;
                }
            });
            return;
        }
        w.i("MicroMsg.WelabUpdater", "Update aborted, Account not ready.");
    }

    private static String ar(LinkedList<qd> linkedList) {
        Iterator it = linkedList.iterator();
        String str = "";
        while (it.hasNext()) {
            qd qdVar = (qd) it.next();
            str = str + qdVar.ttA + ":" + qdVar.priority + "|";
        }
        return str;
    }

    private static LinkedList<qd> bAI() {
        List<com.tencent.mm.plugin.welab.c.a.a> bAP = b.bAG().ssN.bAP();
        LinkedList<qd> linkedList = new LinkedList();
        for (com.tencent.mm.plugin.welab.c.a.a aVar : bAP) {
            qd qdVar = new qd();
            qdVar.ttA = bg.getInt(aVar.field_expId, 0);
            qdVar.priority = aVar.field_prioritylevel;
            linkedList.add(qdVar);
        }
        return linkedList;
    }

    public static void w(List<com.tencent.mm.bd.b> list) {
        if (list == null || list.size() == 0) {
            w.w("MicroMsg.WelabUpdater", "No Exp");
            return;
        }
        List arrayList = new ArrayList();
        for (com.tencent.mm.bd.b a : list) {
            com.tencent.mm.plugin.welab.c.a.a KW = g.KW(n.a(a));
            if (KW != null && KW.isValid()) {
                arrayList.add(KW);
                com.tencent.mm.plugin.welab.d.b.bAV().f(KW);
                e.o(KW.field_LabsAppId, 8, com.tencent.mm.plugin.welab.d.b.bAV().e(KW));
            }
        }
        w.i("MicroMsg.WelabUpdater", "save exp " + arrayList);
        b.bAG().ssN.bO(arrayList);
    }

    public static void x(List<Integer> list) {
        if (bg.bV(list)) {
            w.w("MicroMsg.WelabUpdater", "No expired Exp");
            return;
        }
        w.i("MicroMsg.WelabUpdater", "expired exp " + list);
        List arrayList = new ArrayList();
        for (Integer num : list) {
            c aVar = new com.tencent.mm.plugin.welab.c.a.a();
            aVar.field_expId = num.toString();
            b.bAG().ssN.b(aVar, new String[]{"expId"});
            if (!TextUtils.isEmpty(aVar.field_LabsAppId)) {
                aVar.field_Switch = 3;
                arrayList.add(aVar);
            }
        }
        b.bAG().ssN.bO(arrayList);
    }

    public static void Aw() {
        h.vI().vr().a(a.uHy, Long.valueOf(System.currentTimeMillis() / 1000));
    }

    public static void fm(int i) {
        int i2 = 0;
        if (i == 0) {
            i2 = 86400;
        } else if (i < 3600 || i > 129600) {
            i2 = new Random().nextInt(126000) + 3600;
        }
        h.vI().vr().a(a.uHz, Integer.valueOf(i2));
    }

    public static void fn(int i) {
        h.vI().vr().a(a.uHA, Integer.valueOf(i));
    }

    public static void Ax() {
        h.vI().vr().jY(true);
    }
}
