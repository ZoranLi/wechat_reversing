package com.tencent.mm.modelcontrol;

import com.tencent.mm.sdk.platformtools.bg;

public final class e {
    protected String hzK;
    protected int hzL;
    protected int hzM;
    protected int hzN;
    protected int hzO;
    protected boolean hzP;
    protected f[] hzQ;

    protected final void a(String str, String str2, String str3, String str4, String str5, String str6) {
        boolean z;
        this.hzK = str;
        this.hzL = bg.getInt(str2, 0);
        this.hzL = this.hzL == 0 ? 64000 : this.hzL * 1000;
        this.hzM = bg.getInt(str3, 1);
        this.hzN = bg.getInt(str4, 2);
        this.hzO = bg.getInt(str5, 1);
        if (bg.getInt(str6, 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        this.hzP = z;
    }

    protected final boolean ED() {
        if (bg.mA(this.hzK)) {
            return true;
        }
        return b.iT(this.hzK);
    }

    protected final VideoTransPara EE() {
        VideoTransPara videoTransPara = null;
        if (this.hzQ != null) {
            for (f fVar : this.hzQ) {
                if (fVar != null && fVar.hzR <= 0 && fVar.hzS >= 0) {
                    videoTransPara = new VideoTransPara();
                    videoTransPara.width = fVar.hzT;
                    videoTransPara.height = fVar.hzU;
                    videoTransPara.gPE = fVar.hzV;
                    videoTransPara.hzY = fVar.hzW;
                    videoTransPara.hzM = this.hzM;
                    videoTransPara.hzL = this.hzL;
                    videoTransPara.hzN = this.hzN;
                    videoTransPara.hzO = this.hzO;
                }
            }
        }
        return videoTransPara;
    }

    public final String toString() {
        return "[ busyTime " + this.hzK + " audioBitrate " + this.hzL + " iFrame " + this.hzM + " profileIndex " + this.hzN + " presetIndex " + this.hzO + " isStepBr " + this.hzP + " ]";
    }
}
