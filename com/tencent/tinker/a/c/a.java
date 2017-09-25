package com.tencent.tinker.a.c;

public final class a implements Cloneable {
    private static final int[] aIr = new int[0];
    private static final boolean[] xdu = new boolean[0];
    private int hP;
    private int[] wn;
    private boolean[] xdv;

    public final /* synthetic */ Object clone() {
        return cgJ();
    }

    public a() {
        this((byte) 0);
    }

    private a(byte b) {
        this.wn = new int[10];
        this.xdv = new boolean[10];
        this.hP = 0;
    }

    private static int DD(int i) {
        return i <= 4 ? 8 : (i >> 1) + i;
    }

    private a cgJ() {
        try {
            a aVar = (a) super.clone();
            try {
                aVar.wn = (int[]) this.wn.clone();
                aVar.xdv = (boolean[]) this.xdv.clone();
                return aVar;
            } catch (CloneNotSupportedException e) {
                return aVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final void DE(int i) {
        int a = a(this.wn, this.hP, i);
        if (a >= 0) {
            this.xdv[a] = true;
            return;
        }
        int i2 = a ^ -1;
        int[] iArr = this.wn;
        int i3 = this.hP;
        if (i3 > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i3);
        }
        if (i3 + 1 <= iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
            iArr[i2] = i;
        } else {
            Object obj = new int[DD(i3)];
            System.arraycopy(iArr, 0, obj, 0, i2);
            obj[i2] = i;
            System.arraycopy(iArr, i2, obj, i2 + 1, iArr.length - i2);
            Object obj2 = obj;
        }
        this.wn = iArr;
        boolean[] zArr = this.xdv;
        i3 = this.hP;
        if (i3 > zArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + zArr.length + " currentSize: " + i3);
        }
        if (i3 + 1 <= zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
            zArr[i2] = true;
        } else {
            obj = new boolean[DD(i3)];
            System.arraycopy(zArr, 0, obj, 0, i2);
            obj[i2] = 1;
            System.arraycopy(zArr, i2, obj, i2 + 1, zArr.length - i2);
            obj2 = obj;
        }
        this.xdv = zArr;
        this.hP++;
    }

    public final boolean DF(int i) {
        return a(this.wn, this.hP, i) >= 0;
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
            stringBuilder.append(this.xdv[i]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
