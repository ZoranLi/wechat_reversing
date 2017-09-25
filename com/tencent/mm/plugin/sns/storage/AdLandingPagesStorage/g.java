package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.w;

public final class g {
    public String extra = "";
    public String fVJ;
    public int gKy;
    public int hPR;
    public String pZI;
    public String pZL;
    public int qfV;
    public int qmP;
    public int qmQ;
    public int qmR;
    public int qmS;
    public int qmT;
    public int qmU;
    public int qmV;
    public int qmW;
    public int qmX;
    public int qmY;
    public String qmZ;
    public String qna;
    public String qnb;

    public final String bgY() {
        String str;
        long j = 0;
        try {
            j = i.EQ(this.fVJ);
        } catch (Exception e) {
            w.e("AdLandingPagesReportInfo", "", new Object[]{e});
        }
        StringBuilder append = new StringBuilder().append(i.df(j)).append(",").append(this.pZI).append(",").append(this.qmP).append(",").append(this.gKy).append(",").append(this.qmQ).append(",").append(this.qmR).append(",").append(this.qmS).append(",").append(this.qmT).append(",").append(this.qmU).append(",").append(this.qmV).append(",").append(this.qmW).append(",").append(this.qmX).append(",").append(this.qmY).append(",").append(this.hPR).append(",").append(this.qmZ).append(",").append(System.currentTimeMillis()).append(",").append(this.qna).append(",");
        if (this.pZL == null) {
            str = "";
        } else {
            str = this.pZL;
        }
        return append.append(str).append(",").append(this.extra).append(",").append(this.qfV).append(",").append(this.qnb).toString();
    }
}
