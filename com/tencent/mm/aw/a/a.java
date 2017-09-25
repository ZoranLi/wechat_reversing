package com.tencent.mm.aw.a;

public final class a {
    int idA = 0;
    short[] idB;
    int idy = 0;
    int idz = 0;

    public a(int i) {
        if (i <= 1) {
            i = 512;
        }
        this.idB = new short[i];
    }

    final int b(short[] sArr, int i) {
        int length;
        if (i > sArr.length) {
            length = sArr.length;
        } else {
            length = i;
        }
        if (length == 0) {
            return 0;
        }
        int length2 = this.idB.length;
        if (length >= this.idA) {
            length = this.idA;
        }
        if (length <= length2 - this.idy) {
            System.arraycopy(this.idB, this.idy, sArr, 0, length);
            this.idy += length;
            if (this.idy >= length2) {
                this.idy = 0;
            }
        } else {
            length2 -= this.idy;
            System.arraycopy(this.idB, this.idy, sArr, 0, length2);
            int i2 = length - length2;
            System.arraycopy(this.idB, 0, sArr, length2, i2);
            this.idy = i2;
        }
        this.idA -= length;
        return length;
    }
}
