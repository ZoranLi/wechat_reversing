package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class p extends a<p> {
    public int xcv;
    public int xcw;
    public int xcx;

    public final /* synthetic */ int compareTo(Object obj) {
        p pVar = (p) obj;
        if (this.xcv != pVar.xcv) {
            return c.eD(this.xcv, pVar.xcv);
        }
        return this.xcw != pVar.xcw ? c.eD(this.xcw, pVar.xcw) : c.eD(this.xcx, pVar.xcx);
    }

    public p(int i, int i2, int i3, int i4) {
        super(i);
        this.xcv = i2;
        this.xcx = i3;
        this.xcw = i4;
    }
}
