package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.g;

public final class b extends a {
    private long mQi;
    public long mQj;
    public long mQk = 0;
    public long mQl = 0;
    public long mQm = 0;

    public final void start() {
        super.start();
        this.mQi = System.currentTimeMillis();
    }

    public final void reset() {
        this.mQi = 0;
        this.mQj = 0;
        this.mQk = 0;
        this.mQl = 0;
        this.mQm = 0;
    }

    protected final void aEK() {
        g.oUh.i(12930, new Object[]{Long.valueOf(this.mQi), Long.valueOf(this.mQj), Long.valueOf(this.mQk), Long.valueOf(this.mQl), Long.valueOf(this.mQm)});
    }
}
