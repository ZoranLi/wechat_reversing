package com.tencent.mm.plugin.backup.a;

public final class d implements Cloneable, Comparable<d> {
    public String jBh;
    public long jBi = 0;
    public long jBj = 0;
    public long jBk = -1;
    public long jBl = -1;

    public final /* synthetic */ Object clone() {
        return aad();
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        d dVar = (d) obj;
        if (this.jBk < dVar.jBk) {
            return 1;
        }
        return this.jBk > dVar.jBk ? -1 : 0;
    }

    public final d aad() {
        d dVar = new d();
        dVar.jBh = this.jBh;
        dVar.jBi = this.jBi;
        dVar.jBj = this.jBj;
        dVar.jBk = this.jBk;
        dVar.jBl = this.jBl;
        return dVar;
    }
}
