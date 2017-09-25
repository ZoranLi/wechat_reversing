package com.tencent.tinker.a.c;

public final class b implements Cloneable {
    private static final int[] aIr = new int[0];
    public int hP;
    public int[] wn;
    public int[] xdw;

    public final /* synthetic */ Object clone() {
        return cgK();
    }

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this.wn = new int[10];
        this.xdw = new int[this.wn.length];
        this.hP = 0;
    }

    private static int DD(int i) {
        return i <= 4 ? 8 : (i >> 1) + i;
    }

    private b cgK() {
        try {
            b bVar = (b) super.clone();
            try {
                bVar.wn = (int[]) this.wn.clone();
                bVar.xdw = (int[]) this.xdw.clone();
                return bVar;
            } catch (CloneNotSupportedException e) {
                return bVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final void put(int i, int i2) {
        int a = a(this.wn, this.hP, i);
        if (a >= 0) {
            this.xdw[a] = i2;
            return;
        }
        a ^= -1;
        this.wn = b(this.wn, this.hP, a, i);
        this.xdw = b(this.xdw, this.hP, a, i2);
        this.hP++;
    }

    public final int indexOfKey(int i) {
        return a(this.wn, this.hP, i);
    }

    private static int a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return i4 ^ -1;
    }

    public static int[] c(int[] iArr, int i, int i2) {
        if (i > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
        }
        if (i + 1 > iArr.length) {
            Object obj = new int[DD(i)];
            System.arraycopy(iArr, 0, obj, 0, i);
            iArr = obj;
        }
        iArr[i] = i2;
        return iArr;
    }

    private static int[] b(int[] iArr, int i, int i2, int i3) {
        if (i > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
        } else if (i + 1 <= iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i - i2);
            iArr[i2] = i3;
            return iArr;
        } else {
            Object obj = new int[DD(i)];
            System.arraycopy(iArr, 0, obj, 0, i2);
            obj[i2] = i3;
            System.arraycopy(iArr, i2, obj, i2 + 1, iArr.length - i2);
            return obj;
        }
    }

    public final String toString() {
        if (this.hP <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.hP * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.hP; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(this.wn[i]);
            stringBuilder.append('=');
            stringBuilder.append(this.xdw[i]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
