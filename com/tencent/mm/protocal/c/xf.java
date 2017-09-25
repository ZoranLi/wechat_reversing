package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class xf extends a {
    public double tld;
    public double tle;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.a(1, this.tld);
            aVar.a(2, this.tle);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.b.b.a.cH(1) + 8) + 0) + (a.a.a.b.b.a.cH(2) + 8);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                xf xfVar = (xf) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        xfVar.tld = aVar3.xmD.readDouble();
                        return 0;
                    case 2:
                        xfVar.tle = aVar3.xmD.readDouble();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
