package com.tencent.mm.plugin.report;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Map;

public enum c implements b {
    ;
    
    b oTc;

    private static class a implements b {
        public final void a(long j, long j2, long j3, boolean z) {
            w.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void dj(int i) {
            w.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void i(int i, Object... objArr) {
            w.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void A(int i, String str) {
            w.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void a(int i, String str, boolean z, boolean z2) {
            w.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void a(int i, boolean z, boolean z2, Object... objArr) {
            w.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void c(int i, int i2, int i3, int i4, boolean z) {
            w.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void d(String str, String str2, Map<String, Object> map) {
            w.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void b(ArrayList<IDKey> arrayList, boolean z) {
            w.i("MicroMsg.ReportService", "this is DummyReportService");
        }
    }

    private c(String str) {
        this.oTc = new a();
    }

    public final void i(int i, Object... objArr) {
        this.oTc.i(i, objArr);
    }

    public final void A(int i, String str) {
        this.oTc.A(i, str);
    }

    public final void a(int i, String str, boolean z, boolean z2) {
        this.oTc.a(i, str, z, z2);
    }

    public final void a(int i, boolean z, boolean z2, Object... objArr) {
        this.oTc.a(i, z, z2, objArr);
    }

    public final void a(long j, long j2, long j3, boolean z) {
        this.oTc.a(j, j2, j3, z);
    }

    public final void b(ArrayList<IDKey> arrayList, boolean z) {
        this.oTc.b(arrayList, z);
    }

    public final void c(int i, int i2, int i3, int i4, boolean z) {
        this.oTc.c(i, i2, i3, i4, z);
    }

    public final void dj(int i) {
        this.oTc.dj(i);
    }

    public static Object a(int i, int[] iArr, Object[] objArr) {
        int i2 = 0;
        if (iArr.length <= 0 || iArr.length + 1 != objArr.length) {
            return null;
        }
        if (i <= iArr[0]) {
            return objArr[0];
        }
        while (i2 < iArr.length - 1) {
            if (iArr[i2] >= iArr[i2 + 1]) {
                return null;
            }
            if (i > iArr[i2] && i <= iArr[i2 + 1]) {
                return objArr[i2 + 1];
            }
            i2++;
        }
        return objArr[objArr.length - 1];
    }

    public static Object a(int i, int[] iArr, int i2, int i3) {
        int i4 = 0;
        if (iArr == null || iArr.length <= 0 || i3 <= i2 || i3 > 255 || iArr.length != i3 - i2) {
            return null;
        }
        if (i <= iArr[0]) {
            return Integer.valueOf(i2);
        }
        while (i4 < iArr.length - 1) {
            if (iArr[i4] >= iArr[i4 + 1]) {
                return null;
            }
            if (i > iArr[i4] && i <= iArr[i4 + 1]) {
                return Integer.valueOf(i4 + (i2 + 1));
            }
            i4++;
        }
        return Integer.valueOf(i3);
    }

    public final void d(String str, String str2, Map<String, Object> map) {
        this.oTc.d(str, str2, map);
    }
}
