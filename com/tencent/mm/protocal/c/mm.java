package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class mm extends a {
    public int tfc;
    public long tfk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tfc);
            aVar.O(2, this.tfk);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.eL(1, this.tfc) + 0) + a.a.a.a.N(2, this.tfk);
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
                mm mmVar = (mm) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        mmVar.tfc = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        mmVar.tfk = aVar3.xmD.mM();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
