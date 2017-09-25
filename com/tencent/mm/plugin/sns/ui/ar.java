package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ao.b;

public final class ar {
    public String fJz;
    public String fVJ;
    public boolean qEL = false;
    public boolean qEM = false;
    public int scene;

    public ar(String str, String str2, boolean z, boolean z2, int i) {
        this.fVJ = str;
        this.qEL = z;
        this.qEM = z2;
        this.scene = i;
        this.fJz = str2;
    }

    public final boolean bkG() {
        int i = 2;
        if (this.scene != 1) {
            if (this.scene == 2) {
                i = 4;
            } else {
                i = -1;
            }
        }
        b Fq = ao.Fq(this.fVJ);
        if (Fq == null || !Fq.hoD || Fq.hrm || (r0 & Fq.gkv) == 0) {
            return false;
        }
        return true;
    }
}
