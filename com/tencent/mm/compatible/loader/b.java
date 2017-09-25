package com.tencent.mm.compatible.loader;

public final class b<E> {
    static final Object vT = new Object();
    int hP;
    boolean vU;
    long[] vV;
    Object[] vW;

    public final void put(long j, E e) {
        int b = b(this.vV, this.hP, j);
        if (b >= 0) {
            this.vW[b] = e;
            return;
        }
        b ^= -1;
        if (b >= this.hP || this.vW[b] != vT) {
            int i;
            if (this.vU && this.hP >= this.vV.length) {
                int i2 = this.hP;
                long[] jArr = this.vV;
                Object[] objArr = this.vW;
                b = 0;
                for (i = 0; i < i2; i++) {
                    Object obj = objArr[i];
                    if (obj != vT) {
                        if (i != b) {
                            jArr[b] = jArr[i];
                            objArr[b] = obj;
                        }
                        b++;
                    }
                }
                this.vU = false;
                this.hP = b;
                b = b(this.vV, this.hP, j) ^ -1;
            }
            if (this.hP >= this.vV.length) {
                i = a.P(this.hP + 1);
                Object obj2 = new long[i];
                Object obj3 = new Object[i];
                System.arraycopy(this.vV, 0, obj2, 0, this.vV.length);
                System.arraycopy(this.vW, 0, obj3, 0, this.vW.length);
                this.vV = obj2;
                this.vW = obj3;
            }
            if (this.hP - b != 0) {
                System.arraycopy(this.vV, b, this.vV, b + 1, this.hP - b);
                System.arraycopy(this.vW, b, this.vW, b + 1, this.hP - b);
            }
            this.vV[b] = j;
            this.vW[b] = e;
            this.hP++;
            return;
        }
        this.vV[b] = j;
        this.vW[b] = e;
    }

    static int b(long[] jArr, int i, long j) {
        int i2 = -1;
        int i3 = i + 0;
        while (i3 - i2 > 1) {
            int i4 = (i3 + i2) / 2;
            if (jArr[i4] < j) {
                i2 = i4;
            } else {
                i3 = i4;
            }
        }
        if (i3 == i + 0) {
            return (i + 0) ^ -1;
        }
        return jArr[i3] != j ? i3 ^ -1 : i3;
    }
}
