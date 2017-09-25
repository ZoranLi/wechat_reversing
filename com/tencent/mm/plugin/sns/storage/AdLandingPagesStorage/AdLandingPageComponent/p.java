package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public abstract class p implements Serializable {
    public int fEC;
    public float height;
    public String pZI;
    public String qfI;
    public int qfJ;
    public float qfK;
    public float qfL;
    public float qfM;
    public float qfN;
    public float qfO = -2.0f;
    public float qfP = -2.0f;
    public boolean qfQ;
    public int qfR;
    public int qfS;
    public boolean qfT;
    public boolean qfU;
    public int qfV;
    public boolean qfW;
    public int type;
    public float width;

    public final void tq(int i) {
        this.qfV = i;
        for (p tq : bfU()) {
            tq.tq(i);
        }
    }

    public final void hC(boolean z) {
        this.qfW = z;
        for (p hC : bfU()) {
            hC.hC(z);
        }
    }

    public final void FV(String str) {
        this.pZI = str;
        for (p FV : bfU()) {
            FV.FV(str);
        }
    }

    protected List<p> bfU() {
        return Collections.emptyList();
    }
}
