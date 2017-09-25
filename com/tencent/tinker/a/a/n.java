package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class n extends a<n> {
    public int xbH;
    public int xcv;
    public int xcw;

    public final /* synthetic */ int compareTo(Object obj) {
        n nVar = (n) obj;
        if (this.xcv != nVar.xcv) {
            return c.eD(this.xcv, nVar.xcv);
        }
        return this.xcw != nVar.xcw ? c.eD(this.xcw, nVar.xcw) : c.eD(this.xbH, nVar.xbH);
    }

    public n(int i, int i2, int i3, int i4) {
        super(i);
        this.xcv = i2;
        this.xbH = i3;
        this.xcw = i4;
    }
}
