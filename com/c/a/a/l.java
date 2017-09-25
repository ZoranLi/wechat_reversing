package com.c.a.a;

import java.util.Arrays;

final class l {
    float aLj;
    long aLn;
    private final float[] aLo = new float[3];
    private int aLp;
    private long aLq;
    long aLr;

    l() {
    }

    final void a(float f, int i, long j) {
        long j2 = j - this.aLq;
        if (j2 > this.aLn) {
            Arrays.fill(this.aLo, 0.0f);
            this.aLp = 0;
            this.aLq = 0;
            this.aLr = 0;
            this.aLj = 0.0f;
        } else {
            this.aLr = j2 + this.aLr;
        }
        this.aLo[0] = this.aLo[1];
        this.aLo[1] = this.aLo[2];
        this.aLo[2] = f;
        if (this.aLo[2] != 0.0f) {
            float f2 = this.aLo[0] != 0.0f ? ((this.aLo[0] + this.aLo[1]) + this.aLo[2]) / 3.0f : this.aLo[1] != 0.0f ? (this.aLo[1] + this.aLo[2]) / 2.0f : this.aLo[2];
            this.aLj = ((((float) i) / (f2 + (this.aLo[2] * 3.0f))) * y.aPs) + ((y.aPt * ((float) (i - this.aLp))) / ((float) ((this.aLp + i) + 1)));
        }
        this.aLp = i;
        this.aLq = j;
    }
}
