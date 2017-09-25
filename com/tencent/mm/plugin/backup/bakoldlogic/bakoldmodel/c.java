package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.mm.plugin.backup.g.a;
import com.tencent.mm.sdk.platformtools.w;

public final class c {
    private long hnT = 0;
    private long jCI = -1;
    boolean jCJ = false;

    public final void begin() {
        w.d("MicroMsg.Recoverfaster", "begin");
        if (a.abC().abD().gYg != null) {
            this.jCI = a.abC().abD().gYg.cs(Thread.currentThread().getId());
            this.jCJ = true;
        }
        this.hnT = System.currentTimeMillis();
    }

    public final void end() {
        if (this.jCJ && a.abC().abD().gYg != null) {
            a.abC().abD().gYg.aD(this.jCI);
            this.jCJ = false;
        }
    }

    public final void abQ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.hnT > 10000) {
            end();
            begin();
            this.hnT = currentTimeMillis;
        }
    }
}
