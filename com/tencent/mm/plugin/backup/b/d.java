package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.g.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class d {
    long hnT = 0;
    private long jCI = -1;
    boolean jCJ = false;

    public final void begin() {
        w.d("MicroMsg.BackupRecoverFaster", "begin");
        if (a.abC().abD().gYg != null) {
            this.jCI = a.abC().abD().gYg.cs(Thread.currentThread().getId());
            this.jCJ = true;
        }
        this.hnT = bg.Nz();
    }

    public final void end() {
        if (this.jCJ && a.abC().abD().gYg != null) {
            a.abC().abD().gYg.aD(this.jCI);
            this.jCJ = false;
        }
    }
}
