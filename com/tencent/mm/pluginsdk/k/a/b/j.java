package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;

public final class j {
    private static final int sFV = b.DoCache.fRW;
    private static final int sFW = b.DoDelete.fRW;
    private static final int sFX = b.DoDecrypt.fRW;

    public enum a {
        ;

        static {
            sFY = 1;
            sFZ = 2;
            sGa = 3;
            sGb = 4;
            sGc = 5;
            sGd = 6;
            sGe = new int[]{sFY, sFZ, sGa, sGb, sGc, sGd};
        }
    }

    public static void u(long j, long j2) {
        if (j > 0 && 197 != j) {
            g.oUh.a(j, j2, 1, false);
        }
        g.oUh.a(197, j2, 1, false);
    }

    public static void eh(long j) {
        u(j, 2);
    }

    public static void a(int i, int i2, String str, int i3, int i4, boolean z, boolean z2, boolean z3, String str2) {
        a(i, i2, str, i3, sFV, z2 ? 0 : 1, i4 - 1, z3 ? 0 : 1, 1, z ? 0 : 1, str2);
    }

    public static void a(int i, int i2, int i3, boolean z, String str) {
        a(i, i2, "", i3, sFW, z ? 0 : 1, a.sFZ - 1, 1, 1, 1, str);
    }

    public static void a(int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, String str) {
        a(i, i2, "", i3, sFX, z ? 0 : 1, a.sFZ - 1, z3 ? 0 : 1, z2 ? 0 : 1, z4 ? 0 : 1, str);
    }

    private static void a(int i, int i2, String str, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str2) {
        g.oUh.i(11906, Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
        if (!bg.mA(str2) && !str2.equals("0")) {
            g.oUh.i(11907, Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), str2);
        }
    }
}
