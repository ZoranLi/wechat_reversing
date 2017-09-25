package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.g;

public final class h extends a {
    private long mQE = 0;
    public long mQF = 0;
    public long mQG = 0;
    public long mQH = 0;
    private long mQi;
    public long mQj;

    public final void start() {
        super.start();
        this.mQi = System.currentTimeMillis();
    }

    public final void reset() {
        this.mQi = 0;
        this.mQj = 0;
        this.mQE = 0;
        this.mQF = 0;
        this.mQG = 0;
        this.mQH = 0;
    }

    protected final void aEK() {
        g.oUh.i(12931, new Object[]{Long.valueOf(this.mQi), Long.valueOf(this.mQj), Long.valueOf(this.mQE), Long.valueOf(this.mQF), Long.valueOf(this.mQG), Long.valueOf(this.mQH)});
    }
}
