package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.task.a;
import com.tencent.mm.plugin.report.service.g;

public final class j {
    int akP;
    int hPi;
    long[] ixe;
    int ixf;
    private int ixg = 0;
    int ixh = 0;
    int mType;

    public final void k(int i, long j) {
        if (i == 0) {
            this.ixe = new long[6];
            this.ixg = a.WC() ? 1 : 0;
        }
        if (i < this.ixe.length && this.ixe[i] == 0) {
            this.ixe[i] = j;
        }
    }

    final void m(String str, int i, int i2) {
        g.oUh.i(13886, new Object[]{str, Integer.valueOf(this.akP), Integer.valueOf(this.mType), Integer.valueOf(i), "", "", Long.valueOf(this.ixe[i2]), Integer.valueOf(this.ixf), Integer.valueOf(this.ixg), Integer.valueOf(this.hPi), Integer.valueOf(this.ixh)});
    }
}
