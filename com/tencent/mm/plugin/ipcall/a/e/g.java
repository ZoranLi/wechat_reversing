package com.tencent.mm.plugin.ipcall.a.e;

public final class g extends a {
    public long mQA = 0;
    public long mQB = 0;
    public long mQC = 0;
    public String mQD = "";
    private long mQi;
    public long mQj;
    public long mQx = 0;
    public String mQy = "";
    public String mQz = "";

    public final void start() {
        super.start();
        this.mQi = System.currentTimeMillis();
    }

    public final void reset() {
        this.mQi = 0;
        this.mQj = 0;
        this.mQx = 0;
        this.mQy = "";
        this.mQz = "";
        this.mQA = 0;
        this.mQB = 0;
        this.mQC = 0;
        this.mQD = "";
    }

    protected final void aEK() {
        com.tencent.mm.plugin.report.service.g.oUh.i(12933, new Object[]{Long.valueOf(this.mQi), Long.valueOf(this.mQj), Long.valueOf(this.mQx), this.mQy, this.mQz, Long.valueOf(this.mQA), Long.valueOf(this.mQB), Long.valueOf(this.mQC), this.mQD});
    }
}
