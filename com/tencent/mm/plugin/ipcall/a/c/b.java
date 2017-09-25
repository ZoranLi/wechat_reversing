package com.tencent.mm.plugin.ipcall.a.c;

import com.tencent.mm.sdk.platformtools.w;

public final class b {
    public String countryCode = "";
    public String isg = "";
    public long mMw = 0;
    public int mNL = 0;
    public long mNM = 0;
    public int mNO = 0;
    public int mPA = 0;
    public int mPB = 0;
    public int mPC = 0;
    public int mPc = 0;
    public int mPd = 0;
    public int mPe = 0;
    public int mPf = 0;
    public int mPg = 0;
    public long mPh = 0;
    public long mPi = 0;
    public int mPj = 0;
    public long mPk = 0;
    public int mPl = 0;
    public long mPm = 0;
    public int mPn = 0;
    public String mPo = "";
    public long mPp = 0;
    public long mPq = 0;
    public long mPr = 0;
    public long mPs = 0;
    public String mPt = "";
    public String mPu = "";
    public String mPv = "";
    public long mPw = 0;
    public long mPx = 0;
    public long mPy = 0;
    public int mPz = 0;

    public final void aEE() {
        w.i("MicroMsg.IPCallReportHelper", "selfShutdown");
        this.mPg = 1;
    }

    public final void aEF() {
        w.i("MicroMsg.IPCallReportHelper", "selfCancel");
        this.mPf = 1;
        if (this.mPy == 0 && this.mPp != 0) {
            this.mPy = System.currentTimeMillis() - this.mPp;
            w.d("MicroMsg.IPCallReportHelper", "cancelTime: %d", new Object[]{Long.valueOf(this.mPy)});
        }
    }

    public final void aEG() {
        w.i("MicroMsg.IPCallReportHelper", "channelConnect");
        this.mPj = 1;
    }

    public final void aEH() {
        if (this.mPB == 0) {
            this.mPB = 1;
        }
    }

    public final void aEI() {
        w.d("MicroMsg.IPCallReportHelper", "markConnect");
        if (this.mPw == 0) {
            this.mPw = System.currentTimeMillis();
            this.mPx = this.mPw - this.mPp;
            w.d("MicroMsg.IPCallReportHelper", "connectTime: %d", new Object[]{Long.valueOf(this.mPx)});
        }
    }

    public final void aEJ() {
        w.d("MicroMsg.IPCallReportHelper", "markStartTalk");
        if (this.mPr == 0) {
            this.mPr = System.currentTimeMillis();
        }
    }
}
