package com.tencent.mm.modelcontrol;

public final class f implements Comparable {
    public int hzR;
    public int hzS;
    public int hzT;
    public int hzU;
    public int hzV;
    public int hzW;
    public int hzX;

    public f(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.hzR = i;
        this.hzS = i2;
        this.hzT = i3;
        this.hzU = i4;
        this.hzV = i5;
        this.hzW = i6;
        this.hzX = i7;
    }

    public final int compareTo(Object obj) {
        if (obj == null || !(obj instanceof f)) {
            return 0;
        }
        return this.hzR - ((f) obj).hzR;
    }
}
