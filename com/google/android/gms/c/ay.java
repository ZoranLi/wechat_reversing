package com.google.android.gms.c;

public abstract class ay<M extends ay<M>> extends be {
    protected ba aCy;

    private M lv() {
        ay ayVar = (ay) lw();
        bc.a(this, ayVar);
        return ayVar;
    }

    public void a(ax axVar) {
        if (this.aCy != null) {
            for (int i = 0; i < this.aCy.size(); i++) {
                this.aCy.cr(i).a(axVar);
            }
        }
    }

    protected final boolean a(aw awVar, int i) {
        int position = awVar.getPosition();
        if (!awVar.cf(i)) {
            return false;
        }
        byte[] bArr;
        bb bbVar;
        int cu = bh.cu(i);
        int position2 = awVar.getPosition() - position;
        if (position2 == 0) {
            bArr = bh.aCS;
        } else {
            bArr = new byte[position2];
            System.arraycopy(awVar.buffer, position + awVar.aCo, bArr, 0, position2);
        }
        bg bgVar = new bg(i, bArr);
        if (this.aCy == null) {
            this.aCy = new ba();
            bbVar = null;
        } else {
            ba baVar = this.aCy;
            position2 = baVar.cs(cu);
            bbVar = (position2 < 0 || baVar.aCE[position2] == ba.aCB) ? null : baVar.aCE[position2];
        }
        if (bbVar == null) {
            bb bbVar2 = new bb();
            ba baVar2 = this.aCy;
            int cs = baVar2.cs(cu);
            if (cs >= 0) {
                baVar2.aCE[cs] = bbVar2;
                bbVar = bbVar2;
            } else {
                cs ^= -1;
                if (cs >= baVar2.hP || baVar2.aCE[cs] != ba.aCB) {
                    if (baVar2.aCC && baVar2.hP >= baVar2.aCD.length) {
                        baVar2.gc();
                        cs = baVar2.cs(cu) ^ -1;
                    }
                    if (baVar2.hP >= baVar2.aCD.length) {
                        int P = ba.P(baVar2.hP + 1);
                        Object obj = new int[P];
                        Object obj2 = new bb[P];
                        System.arraycopy(baVar2.aCD, 0, obj, 0, baVar2.aCD.length);
                        System.arraycopy(baVar2.aCE, 0, obj2, 0, baVar2.aCE.length);
                        baVar2.aCD = obj;
                        baVar2.aCE = obj2;
                    }
                    if (baVar2.hP - cs != 0) {
                        System.arraycopy(baVar2.aCD, cs, baVar2.aCD, cs + 1, baVar2.hP - cs);
                        System.arraycopy(baVar2.aCE, cs, baVar2.aCE, cs + 1, baVar2.hP - cs);
                    }
                    baVar2.aCD[cs] = cu;
                    baVar2.aCE[cs] = bbVar2;
                    baVar2.hP++;
                    bbVar = bbVar2;
                } else {
                    baVar2.aCD[cs] = cu;
                    baVar2.aCE[cs] = bbVar2;
                    bbVar = bbVar2;
                }
            }
        }
        bbVar.aCH.add(bgVar);
        return true;
    }

    protected final boolean a(M m) {
        return (this.aCy == null || this.aCy.isEmpty()) ? m.aCy == null || m.aCy.isEmpty() : this.aCy.equals(m.aCy);
    }

    public /* synthetic */ Object clone() {
        return lv();
    }

    protected int kK() {
        int i = 0;
        if (this.aCy == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.aCy.size()) {
            i2 += this.aCy.cr(i).kK();
            i++;
        }
        return i2;
    }

    protected final int lu() {
        return (this.aCy == null || this.aCy.isEmpty()) ? 0 : this.aCy.hashCode();
    }

    public final /* synthetic */ be lw() {
        return lv();
    }
}
