package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.g;

public final class j extends a {
    public long mQI = 0;
    public long mQJ = 0;
    public long mQK = 0;
    private long mQi;
    public long mQj;

    public final void start() {
        super.start();
        this.mQi = System.currentTimeMillis();
    }

    public final void reset() {
        this.mQi = 0;
        this.mQj = 0;
        this.mQI = 0;
        this.mQJ = 0;
        this.mQK = 0;
    }

    protected final void aEK() {
        g.oUh.i(12934, new Object[]{Long.valueOf(this.mQi), Long.valueOf(this.mQj), Long.valueOf(this.mQI), Long.valueOf(this.mQJ), Long.valueOf(this.mQK)});
    }
}
