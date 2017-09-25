package com.tencent.mm.as;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class i {
    private static a hPV = new a();

    public static class a {
        long hJZ;
        int hPW;
        long hPX;
        long hPY;
        long hPZ;
        boolean hQa = true;
        int scene;
    }

    public static void p(int i, String str) {
        g.oUh.A(i, str);
    }

    public static void a(int i, String str, boolean z, boolean z2, int i2) {
        int i3;
        if (z) {
            i3 = 3;
        } else if (z2) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        g.oUh.i(12042, Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(i2), bg.ap(str, "").replace(",", " "));
    }

    public static void gq(int i) {
        hPV.scene = i;
        hPV.hPW = 1;
        hPV.hPX = System.currentTimeMillis();
        hPV.hPY = 0;
        hPV.hPZ = System.currentTimeMillis();
        hPV.hJZ = 0;
        hPV.hQa = false;
        w.v("MicroMsg.FTS.FTSWebReportLogic", "initReport %d %d", Integer.valueOf(i), Integer.valueOf(1));
    }

    public static void Ir() {
        hPV.hPX = System.currentTimeMillis();
        w.v("MicroMsg.FTS.FTSWebReportLogic", "startH5Report %s", Long.valueOf(hPV.hPX));
    }

    public static void Is() {
        a aVar = hPV;
        aVar.hPY += System.currentTimeMillis() - hPV.hPX;
        w.v("MicroMsg.FTS.FTSWebReportLogic", "stopH5Report %s", Long.valueOf(hPV.hPY));
    }

    public static void It() {
        a aVar = hPV;
        aVar.hJZ += System.currentTimeMillis() - hPV.hPZ;
        w.v("MicroMsg.FTS.FTSWebReportLogic", "stopTotalReport %s", Long.valueOf(hPV.hJZ));
    }

    public static void Iu() {
        a aVar = hPV;
        if (!aVar.hQa) {
            g.oUh.i(12044, Integer.valueOf(aVar.scene), Integer.valueOf(aVar.hPW), Long.valueOf(aVar.hPY / 1000), Long.valueOf(aVar.hJZ / 1000));
            aVar.hQa = true;
        }
        w.v("MicroMsg.FTS.FTSWebReportLogic", "reportTime");
    }

    public static void gr(int i) {
        w.v("MicroMsg.FTS.FTSWebReportLogic", "kvReportWebSearchVisit %d", Integer.valueOf(i));
        g.oUh.i(12041, Integer.valueOf(i), Integer.valueOf(d.hPo));
    }

    public static void a(int i, int i2, String str, int i3, int i4, String str2, int i5) {
        w.v("MicroMsg.FTS.FTSWebReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2, Integer.valueOf(i5));
        g.oUh.i(12098, Integer.valueOf(i), Integer.valueOf(d.hPo), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2, Integer.valueOf(i5));
    }

    public static void c(String str, int i, int i2, int i3) {
        g.oUh.i(12639, bg.ap(str, "").replace(",", " "), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3));
    }

    public static void aW(int i, int i2) {
        g.oUh.i(12845, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2));
    }

    public static void q(int i, String str) {
        g.oUh.i(12070, Integer.valueOf(i), Integer.valueOf(d.hPo), str, Integer.valueOf(4), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0));
    }

    public static void g(int i, String str, String str2) {
        g.oUh.i(13809, Integer.valueOf(i), str, str2, Integer.valueOf(0));
    }

    public static void a(int i, String str, String str2, int i2, int i3) {
        g.oUh.i(13810, Integer.valueOf(i), str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0));
    }

    public static final void jZ(String str) {
        w.v("MicroMsg.FTS.FTSWebReportLogic", "reportWebSuggestClick %s", str);
        g.oUh.A(12721, str);
    }

    public static final void gs(int i) {
        g.oUh.a(649, (long) i, 1, true);
    }

    public static final void aX(int i, int i2) {
        if (i == 21) {
            g.oUh.a(649, (long) i2, 1, true);
        }
    }

    public static void aY(int i, int i2) {
        b(i, i2, "");
    }

    public static void b(int i, int i2, String str) {
        a(i, i2, 0, 0, str);
    }

    public static void q(int i, int i2, int i3) {
        a(i, 3, i2, i3, "");
    }

    public static void a(int i, int i2, int i3, int i4, String str) {
        g.oUh.i(14457, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(d.hPo), Integer.valueOf(i3), Integer.valueOf(i4), str);
    }
}
