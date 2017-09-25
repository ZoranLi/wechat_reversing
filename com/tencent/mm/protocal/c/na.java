package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class na extends a {
    public long tto;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((a.a.a.c.a) objArr[0]).O(1, this.tto);
            return 0;
        } else if (i == 1) {
            return a.a.a.a.N(1, this.tto) + 0;
        } else {
            if (i == 2) {
                a.a.a.a.a aVar = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar2 = (a.a.a.a.a) objArr[0];
                na naVar = (na) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        naVar.tto = aVar2.xmD.mM();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
