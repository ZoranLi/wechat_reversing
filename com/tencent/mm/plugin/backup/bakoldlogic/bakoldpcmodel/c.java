package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;

public final class c {
    public int hmn;
    public int jLA;
    private int jLB;
    int jLC;
    int jLD;
    int jLE;
    public int jLF;
    public int jLz;

    private void reset() {
        this.jLz = 0;
        this.jLA = 0;
        this.hmn = 0;
        this.jLB = 0;
        this.jLC = 0;
        this.jLD = 0;
        this.jLE = 0;
        this.jLF = 0;
    }

    public final void zO() {
        if (this.jLz == 0) {
            reset();
            return;
        }
        w.i("MicroMsg.BakPCReportor", "report: %s", new Object[]{String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[]{Integer.valueOf(this.jLz), Integer.valueOf(this.jLA), Integer.valueOf(this.hmn), Integer.valueOf(this.jLB), Integer.valueOf(this.jLC), Integer.valueOf(this.jLD), Integer.valueOf(this.jLE), Integer.valueOf(this.jLF)})});
        g.oUh.A(11103, r0);
        reset();
    }
}
