package com.tencent.mm.pluginsdk.location;

public final class b {
    public int fOd;
    public float hCP;
    public float hCQ;
    public long sBS;
    public int scene;

    public b(long j, float f, float f2, int i, int i2) {
        this.hCP = f;
        this.hCQ = f2;
        this.fOd = i;
        this.scene = i2;
        this.sBS = j;
    }

    public final String toString() {
        return String.format("%d-%d-%d", new Object[]{Integer.valueOf((int) (this.hCP * 1000000.0f)), Integer.valueOf((int) (this.hCQ * 1000000.0f)), Integer.valueOf(this.fOd)});
    }
}
