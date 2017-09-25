package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class d {
    public static int nPa = 0;
    public static int nPb = 0;
    public static int nPc = 0;
    public static int nPd = 0;
    public static int nPe = 0;

    public static final void a(boolean z, long j, String str) {
        int i;
        w.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectSuccess %b %d %s", new Object[]{Boolean.valueOf(z), Long.valueOf(j), str});
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        g.oUh.i(12725, new Object[]{Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(j), str});
    }

    public static final void a(boolean z, long j, String str, int i) {
        int i2;
        w.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectFail %b %d %s %d", new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, Integer.valueOf(i)});
        if (z) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        g.oUh.i(12725, new Object[]{Integer.valueOf(2), Integer.valueOf(i2), Long.valueOf(j), str, Integer.valueOf(i)});
    }

    public static final void aMG() {
        w.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailSuccess");
        g.oUh.i(12722, new Object[]{Integer.valueOf(1)});
    }

    public static final void aMH() {
        w.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailFail");
        g.oUh.i(12722, new Object[]{Integer.valueOf(2)});
    }

    public static final void ae(int i, String str) {
        w.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkReceiveCall %d %s", new Object[]{Integer.valueOf(i), str});
        g.oUh.i(12723, new Object[]{Integer.valueOf(i), str});
    }

    public static final void l(long j, String str) {
        w.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMutliTalkDuration %d %s", new Object[]{Long.valueOf(j), str});
        g.oUh.i(12726, new Object[]{Long.valueOf(j), str});
    }

    public static final void a(int i, boolean z, int i2, String str, int i3) {
        int i4;
        w.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkSelectContact %d %b %d %s %d", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3)});
        if (z) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        g.oUh.i(12727, new Object[]{Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(i3)});
    }

    public static final void m(long j, String str) {
        long j2 = j > 1000 ? j / 1000 : 1;
        w.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkVideoDuration %d %s", new Object[]{Long.valueOf(j2), str});
        g.oUh.i(12728, new Object[]{Long.valueOf(j2), str});
    }

    public static final void AW(String str) {
        w.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkFunction %s %d %d %d %d %d", new Object[]{str, Integer.valueOf(nPa), Integer.valueOf(nPb), Integer.valueOf(nPc), Integer.valueOf(nPd), Integer.valueOf(nPe)});
        g.oUh.i(12729, new Object[]{str, Integer.valueOf(nPa), Integer.valueOf(nPb), Integer.valueOf(nPc), Integer.valueOf(nPd), Integer.valueOf(nPe)});
        cu(9, nPa);
        cu(10, nPe);
        cu(11, nPb);
        cu(12, nPc);
        cu(13, nPd);
        nPa = 0;
        nPb = 0;
        nPc = 0;
        nPd = 0;
        nPe = 0;
    }

    public static final void d(String str, boolean z, boolean z2) {
        if (z && z2) {
            g.oUh.i(12917, new Object[]{str, Integer.valueOf(2), Integer.valueOf(1)});
        } else if (z) {
            g.oUh.i(12917, new Object[]{str, Integer.valueOf(2), Integer.valueOf(2)});
        } else if (z2) {
            g.oUh.i(12917, new Object[]{str, Integer.valueOf(1), Integer.valueOf(1)});
        } else {
            g.oUh.i(12917, new Object[]{str, Integer.valueOf(1), Integer.valueOf(2)});
        }
    }

    public static final void aMI() {
        g.oUh.a(220, 0, 1, false);
    }

    public static final void fQ(boolean z) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(3);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            iDKey = new IDKey();
            iDKey.SetID(220);
            iDKey.SetKey(4);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        g.oUh.b(arrayList, false);
    }

    public static final void aMJ() {
        g.oUh.a(220, 1, 1, false);
    }

    public static final void fR(boolean z) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(5);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            iDKey = new IDKey();
            iDKey.SetID(220);
            iDKey.SetKey(6);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        g.oUh.b(arrayList, false);
    }

    public static final void pR(int i) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(7);
        iDKey.SetValue(i);
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(8);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        g.oUh.b(arrayList, false);
    }

    private static void cu(int i, int i2) {
        g.oUh.a(220, (long) i, (long) i2, false);
    }
}
