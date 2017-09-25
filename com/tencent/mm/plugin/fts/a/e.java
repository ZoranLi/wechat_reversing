package com.tencent.mm.plugin.fts.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import java.util.ArrayList;

public final class e {
    public static final int[] lZI = new int[]{8, 9, 10, 11, 12, 14, 19, 20, 21, 22, 24, 25};

    public static final void a(String str, int i, long j, String str2) {
        if (d.b(i, lZI)) {
            if (d.sYO) {
                h.vG();
                if (((long) a.uH()) % 50 != 1) {
                    return;
                }
            }
            if (i > 0 && !bg.mA(str)) {
                h.vJ();
                long longValue = ((Long) h.vI().vr().get(w.a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(0))).longValue();
                com.tencent.mm.sdk.platformtools.w.v("MicroMsg.FTS.FTSReportLogic", "reportKVSearchTime: %d %s %d %d %s %d", Integer.valueOf(14175), str, Integer.valueOf(i), Long.valueOf(j), bg.ap(str2, ""), Long.valueOf(longValue));
                c.oTb.i(14175, bg.ap(str, ""), Integer.valueOf(i), Long.valueOf(j), bg.ap(str2, ""), Long.valueOf(longValue));
            }
        }
    }

    public static void s(int i, long j) {
        if (i > 0) {
            int i2 = ((i - 1) * 2) + 1;
            com.tencent.mm.sdk.platformtools.w.v("MicroMsg.FTS.FTSReportLogic", "reportIDKeySearchTime: reportKey=%d taskId=%d", Integer.valueOf(i2), Integer.valueOf(i));
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(601);
            iDKey.SetKey(i2);
            iDKey.SetValue((int) j);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(601);
            iDKey.SetKey(i2 + 1);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            c.oTb.b(arrayList, false);
        }
    }

    public static void t(int i, long j) {
        if (i > 0) {
            int i2 = ((i - 1) * 4) + 1;
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(602);
            iDKey.SetKey(i2);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            if (j <= 100) {
                iDKey = new IDKey();
                iDKey.SetID(602);
                iDKey.SetKey(i2 + 1);
                iDKey.SetValue(1);
                arrayList.add(iDKey);
            } else if (j <= 500) {
                iDKey = new IDKey();
                iDKey.SetID(602);
                iDKey.SetKey(i2 + 2);
                iDKey.SetValue(1);
                arrayList.add(iDKey);
            } else {
                iDKey = new IDKey();
                iDKey.SetID(602);
                iDKey.SetKey(i2 + 3);
                iDKey.SetValue(1);
                arrayList.add(iDKey);
            }
            c.oTb.b(arrayList, false);
        }
    }

    public static void mQ(int i) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.share.e.CTRL_INDEX);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        if (i != 1) {
            iDKey = new IDKey();
            iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.share.e.CTRL_INDEX);
            iDKey.SetKey(2);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.share.e.CTRL_INDEX);
            iDKey.SetKey(i);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        } else {
            iDKey = new IDKey();
            iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.share.e.CTRL_INDEX);
            iDKey.SetKey(1);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        c.oTb.b(arrayList, false);
    }
}
