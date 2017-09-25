package com.google.android.gms.c;

final class ba implements Cloneable {
    static final bb aCB = new bb();
    boolean aCC;
    int[] aCD;
    bb[] aCE;
    int hP;

    public ba() {
        this(10);
    }

    private ba(int i) {
        this.aCC = false;
        int P = P(i);
        this.aCD = new int[P];
        this.aCE = new bb[P];
        this.hP = 0;
    }

    static int P(int i) {
        int i2 = i * 4;
        for (int i3 = 4; i3 < 32; i3++) {
            if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            }
        }
        return i2 / 4;
    }

    public final /* synthetic */ Object clone() {
        return lx();
    }

    public final bb cr(int i) {
        if (this.aCC) {
            gc();
        }
        return this.aCE[i];
    }

    final int cs(int i) {
        int i2 = 0;
        int i3 = this.hP - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.aCD[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ba)) {
            return false;
        }
        ba baVar = (ba) obj;
        if (size() != baVar.size()) {
            return false;
        }
        int i;
        boolean z;
        int[] iArr = this.aCD;
        int[] iArr2 = baVar.aCD;
        int i2 = this.hP;
        for (i = 0; i < i2; i++) {
            if (iArr[i] != iArr2[i]) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            bb[] bbVarArr = this.aCE;
            bb[] bbVarArr2 = baVar.aCE;
            i2 = this.hP;
            for (i = 0; i < i2; i++) {
                if (!bbVarArr[i].equals(bbVarArr2[i])) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                return true;
            }
        }
        return false;
    }

    final void gc() {
        int i = this.hP;
        int[] iArr = this.aCD;
        bb[] bbVarArr = this.aCE;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            bb bbVar = bbVarArr[i3];
            if (bbVar != aCB) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    bbVarArr[i2] = bbVar;
                    bbVarArr[i3] = null;
                }
                i2++;
            }
        }
        this.aCC = false;
        this.hP = i2;
    }

    public final int hashCode() {
        if (this.aCC) {
            gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.hP; i2++) {
            i = (((i * 31) + this.aCD[i2]) * 31) + this.aCE[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final ba lx() {
        int i = 0;
        int size = size();
        ba baVar = new ba(size);
        System.arraycopy(this.aCD, 0, baVar.aCD, 0, size);
        while (i < size) {
            if (this.aCE[i] != null) {
                baVar.aCE[i] = this.aCE[i].ly();
            }
            i++;
        }
        baVar.hP = size;
        return baVar;
    }

    public final int size() {
        if (this.aCC) {
            gc();
        }
        return this.hP;
    }
}
