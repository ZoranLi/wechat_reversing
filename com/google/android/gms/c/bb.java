package com.google.android.gms.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class bb implements Cloneable {
    private az<?, ?> aCF;
    private Object aCG;
    List<bg> aCH = new ArrayList();

    bb() {
    }

    private byte[] toByteArray() {
        byte[] bArr = new byte[kK()];
        a(ax.b(bArr, 0, bArr.length));
        return bArr;
    }

    final void a(ax axVar) {
        if (this.aCG != null) {
            this.aCF.a(this.aCG, axVar);
            return;
        }
        for (bg bgVar : this.aCH) {
            axVar.co(bgVar.tag);
            axVar.g(bgVar.aCK);
        }
    }

    public final /* synthetic */ Object clone() {
        return ly();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bb)) {
            return false;
        }
        bb bbVar = (bb) obj;
        if (this.aCG != null && bbVar.aCG != null) {
            return this.aCF == bbVar.aCF ? !this.aCF.aCz.isArray() ? this.aCG.equals(bbVar.aCG) : this.aCG instanceof byte[] ? Arrays.equals((byte[]) this.aCG, (byte[]) bbVar.aCG) : this.aCG instanceof int[] ? Arrays.equals((int[]) this.aCG, (int[]) bbVar.aCG) : this.aCG instanceof long[] ? Arrays.equals((long[]) this.aCG, (long[]) bbVar.aCG) : this.aCG instanceof float[] ? Arrays.equals((float[]) this.aCG, (float[]) bbVar.aCG) : this.aCG instanceof double[] ? Arrays.equals((double[]) this.aCG, (double[]) bbVar.aCG) : this.aCG instanceof boolean[] ? Arrays.equals((boolean[]) this.aCG, (boolean[]) bbVar.aCG) : Arrays.deepEquals((Object[]) this.aCG, (Object[]) bbVar.aCG) : false;
        } else {
            if (this.aCH != null && bbVar.aCH != null) {
                return this.aCH.equals(bbVar.aCH);
            }
            try {
                return Arrays.equals(toByteArray(), bbVar.toByteArray());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    final int kK() {
        if (this.aCG != null) {
            return this.aCF.ad(this.aCG);
        }
        int i = 0;
        for (bg bgVar : this.aCH) {
            i = (bgVar.aCK.length + (ax.cp(bgVar.tag) + 0)) + i;
        }
        return i;
    }

    public final bb ly() {
        int i = 0;
        bb bbVar = new bb();
        try {
            bbVar.aCF = this.aCF;
            if (this.aCH == null) {
                bbVar.aCH = null;
            } else {
                bbVar.aCH.addAll(this.aCH);
            }
            if (this.aCG != null) {
                if (this.aCG instanceof be) {
                    bbVar.aCG = ((be) this.aCG).lw();
                } else if (this.aCG instanceof byte[]) {
                    bbVar.aCG = ((byte[]) this.aCG).clone();
                } else if (this.aCG instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.aCG;
                    Object obj = new byte[bArr.length][];
                    bbVar.aCG = obj;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        obj[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.aCG instanceof boolean[]) {
                    bbVar.aCG = ((boolean[]) this.aCG).clone();
                } else if (this.aCG instanceof int[]) {
                    bbVar.aCG = ((int[]) this.aCG).clone();
                } else if (this.aCG instanceof long[]) {
                    bbVar.aCG = ((long[]) this.aCG).clone();
                } else if (this.aCG instanceof float[]) {
                    bbVar.aCG = ((float[]) this.aCG).clone();
                } else if (this.aCG instanceof double[]) {
                    bbVar.aCG = ((double[]) this.aCG).clone();
                } else if (this.aCG instanceof be[]) {
                    be[] beVarArr = (be[]) this.aCG;
                    Object obj2 = new be[beVarArr.length];
                    bbVar.aCG = obj2;
                    while (i < beVarArr.length) {
                        obj2[i] = beVarArr[i].lw();
                        i++;
                    }
                }
            }
            return bbVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
