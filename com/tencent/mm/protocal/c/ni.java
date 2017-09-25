package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ni extends a {
    public int teS;
    public int thX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.thX);
            aVar.eO(2, this.teS);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.eL(1, this.thX) + 0) + a.a.a.a.eL(2, this.teS);
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
                ni niVar = (ni) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        niVar.thX = aVar3.xmD.mL();
                        return 0;
                    case 2:
                        niVar.teS = aVar3.xmD.mL();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
