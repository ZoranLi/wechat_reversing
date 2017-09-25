package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bbo extends a {
    public int ubK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((a.a.a.c.a) objArr[0]).eO(1, this.ubK);
            return 0;
        } else if (i == 1) {
            return a.a.a.a.eL(1, this.ubK) + 0;
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
                bbo com_tencent_mm_protocal_c_bbo = (bbo) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bbo.ubK = aVar2.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
