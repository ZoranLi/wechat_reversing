package com.tencent.mm.plugin.backup.bakoldlogic.a;

public final class a implements Cloneable, Comparable<a> {
    public String jBh;
    public long jBk;
    public long jBl;

    public final /* synthetic */ Object clone() {
        return abM();
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        a aVar = (a) obj;
        if (this.jBk < aVar.jBk) {
            return 1;
        }
        return this.jBk > aVar.jBk ? -1 : 0;
    }

    public final a abM() {
        a aVar = new a();
        aVar.jBh = this.jBh;
        aVar.jBk = this.jBk;
        aVar.jBl = this.jBl;
        return aVar;
    }
}
