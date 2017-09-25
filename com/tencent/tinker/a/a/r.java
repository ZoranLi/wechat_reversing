package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class r extends a<r> {
    public int xcA;
    public int xcy;
    public int xcz;

    public final /* synthetic */ int compareTo(Object obj) {
        r rVar = (r) obj;
        int eD = c.eD(this.xcy, rVar.xcy);
        if (eD != 0) {
            return eD;
        }
        eD = c.eD(this.xcz, rVar.xcz);
        return eD == 0 ? c.eE(this.xcA, rVar.xcA) : eD;
    }

    public r(int i, int i2, int i3, int i4) {
        super(i);
        this.xcy = i2;
        this.xcz = i3;
        this.xcA = i4;
    }
}
